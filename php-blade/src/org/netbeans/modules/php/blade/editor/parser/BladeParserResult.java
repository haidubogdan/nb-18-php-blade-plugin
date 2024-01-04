package org.netbeans.modules.php.blade.editor.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.BaseErrorListener;

import org.netbeans.modules.csl.api.Error;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.spi.Parser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.netbeans.modules.csl.api.Severity;
import org.netbeans.modules.php.blade.editor.compiler.BladePhpCompiler;
import org.netbeans.modules.php.blade.editor.indexing.BladeIndex;
import org.netbeans.modules.php.blade.editor.navigator.BladeStructureItem;
import org.netbeans.modules.php.blade.editor.navigator.BladeStructureItem.DirectiveBlockStructureItem;
import org.netbeans.modules.php.blade.editor.navigator.BladeStructureItem.DirectiveInlineStructureItem;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrParser;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrParserBaseListener;
import org.netbeans.modules.php.editor.parser.PHPParseResult;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;

/**
 *
 * @author bhaidu
 */
public class BladeParserResult<T extends Parser> extends ParserResult {

    public final List<Error> errors = new ArrayList<>();
    public final Map<String, Reference> references = new TreeMap<>();
    private final Map<String, Reference> yieldReferences = new TreeMap<>();
    private final Map<String, Reference> stackReferences = new TreeMap<>();
    public final Map<OffsetRange, Reference> occurancesForDeclaration = new TreeMap<>();
    public final Map<OffsetRange, Reference> customDirectivesReferences = new TreeMap<>();
    public final Map<OffsetRange, Set<String>> scopedVariables = new TreeMap<>();

    public final Set<String> includeFilePaths = new LinkedHashSet<>();
    public final List<BladeStructureItem> structure = new ArrayList<>();
    public final List<OffsetRange> folds = new ArrayList<>();

    protected PHPParseResult phpParserResult;

    protected BladeIndex bladeIndex = null;

    volatile boolean finished = false;
    volatile boolean indexLoaded = false;

    public enum ReferenceType {
        YIELD, STACK, SECTION, PUSH, INCLUDE, EXTENDS, EACH, HAS_SECTION, USE,
        CUSTOM_DIRECTIVE, PHP_INLINE, PHP_BLADE
    }

    public enum ParserContext {
        EXTENDS(BladeAntlrParser.ExtendsContext.class.getSimpleName()),
        INCLUDE(BladeAntlrParser.IncludeContext.class.getSimpleName()),
        YIELD(BladeAntlrParser.YieldDContext.class.getSimpleName()),
        STACK(BladeAntlrParser.StackContext.class.getSimpleName()),
        SECTION(BladeAntlrParser.SectionContext.class.getSimpleName()),
        SECTION_INLINE(BladeAntlrParser.Section_inlineContext.class.getSimpleName()),
        PUSH(BladeAntlrParser.PushContext.class.getSimpleName()),
        HAS_SECTION(BladeAntlrParser.HasSectionContext.class.getSimpleName()),
        EACH(BladeAntlrParser.EachContext.class.getSimpleName()),
        USE(BladeAntlrParser.UseDContext.class.getSimpleName());

        String className;

        ParserContext(String className) {
            this.className = className;
        }

        public static ParserContext getValue(String name) {

            for (ParserContext c : ParserContext.values()) {
                if (c.className.equals(name)) {
                    return c;
                }
            }

            return null;
        }
    }

    public BladeParserResult(Snapshot snapshot) {
        super(snapshot);
    }

    protected BladeAntlrParser createParser(Snapshot snapshot) {
        CharStream cs = CharStreams.fromString(String.valueOf(snapshot.getText()));
        BladeAntlrLexer lexer = new BladeAntlrLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BladeAntlrParser ret = new BladeAntlrParser(tokens);
        ret.removeErrorListener(ConsoleErrorListener.INSTANCE);
        return ret;
    }

    public BladeParserResult get() {
        if (!finished) {
            BladeAntlrParser parser = createParser(getSnapshot());
            parser.addErrorListener(createErrorListener());
//            parser.addParseListener(createFoldListener());
            parser.addParseListener(createDeclarationReferencesListener());
            parser.addParseListener(createVariableListener());
            parser.addParseListener(createLayoutTreeListener());
            parser.addParseListener(createStructureListener());
            parser.addParseListener(createSemanticsListener());
            evaluateParser(parser);
            BladePhpCompiler phpCompiler = new BladePhpCompiler();
            phpParserResult = phpCompiler.extractPhpContent(
                    this.getSnapshot()).getPhpParserResult();

            if (phpParserResult != null) {
                //double errors for php inline
                this.errors.addAll(phpParserResult.getDiagnostics());
            }

            finished = true;
        }
        return this;
    }

    protected void evaluateParser(BladeAntlrParser parser) {
        parser.file();
    }

    protected ParseTreeListener createDeclarationReferencesListener() {

        return new BladeAntlrParserBaseListener() {

            @Override
            public void exitIdentifiableArgument(BladeAntlrParser.IdentifiableArgumentContext ctx) {
                // ctx.each_path.BL_PARAM_STRING();
                addIdentifiableOccurenceForDeclaration(ctx);
            }

            @Override
            public void exitCustom_directive(BladeAntlrParser.Custom_directiveContext ctx) {
                String directiveName = ctx.getStart().getText();
                OffsetRange range = new OffsetRange(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex() + 1);
                occurancesForDeclaration.put(range, new Reference(ReferenceType.CUSTOM_DIRECTIVE, directiveName, range));
            }

            @Override
            public void exitPhpInline(BladeAntlrParser.PhpInlineContext ctx) {
                OffsetRange range = new OffsetRange(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex() + 1);
                //no need to store php_inline text, but who knows ?
                occurancesForDeclaration.put(range, new Reference(ReferenceType.PHP_INLINE, "php_inline", range));
            }

            @Override
            public void exitPhp_blade(BladeAntlrParser.Php_bladeContext ctx) {
                OffsetRange range = new OffsetRange(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex() + 1);
                //no need to store php_inline text, but who knows ?
                occurancesForDeclaration.put(range, new Reference(ReferenceType.PHP_BLADE, "php_blade", range));
            }

            /**
             * - adds occurences for declaration - stores specific type
             * references
             */
            private void addIdentifiableOccurenceForDeclaration(BladeAntlrParser.IdentifiableArgumentContext ctx) {
                if (ctx.BL_PARAM_STRING() == null) {
                    return;
                }

                String className = ctx.getParent().getClass().getSimpleName();

                if (className.endsWith("WrapperContext")) {
                    className = ctx.getParent().getParent().getClass().getSimpleName();
                }

                ParserContext classType = ParserContext.getValue(className);

                if (classType == null) {
                    return;
                }

                ReferenceType type = getReferenceType(classType);

                if (type == null) {
                    //not handled
                    return;
                }

                Token paramString = ctx.BL_PARAM_STRING().getSymbol();
                String bladeParamText = paramString.getText();
                bladeParamText = bladeParamText.substring(1, bladeParamText.length() - 1);
                OffsetRange range = new OffsetRange(paramString.getStartIndex(), paramString.getStopIndex());
                Reference ref = new Reference(type, bladeParamText, range);

                //to add include path ??
                occurancesForDeclaration.put(range, ref);

                //adding references to be indexed
                switch (type) {
                    case YIELD:
                        addYieldReference(ReferenceType.YIELD, bladeParamText, range);
                        break;
                    case STACK:
                        addStackReference(ReferenceType.STACK, bladeParamText, range);
                        break;
                }
            }
        };

    }

    private ParseTreeListener createVariableListener() {
        return new BladeAntlrParserBaseListener() {
            ForeachVariables foreachVariables;

            @Override
            public void exitSimple_foreach_expr(BladeAntlrParser.Simple_foreach_exprContext ctx) {
                foreachVariables = new ForeachVariables();
                foreachVariables.arrayVariable = ctx.loop_array.getText();
                if (ctx.item != null) {
                    foreachVariables.keyVariable = ctx.key.getText();
                    foreachVariables.itemVariable = ctx.item.getText();
                } else {

                    foreachVariables.itemVariable = ctx.key.getText();
                }
            }

            @Override public void exitForeach(BladeAntlrParser.ForeachContext ctx) { 
                if (foreachVariables != null){
                    Set<String> varList = new LinkedHashSet<>();
                    varList.add(foreachVariables.arrayVariable);
                    if (foreachVariables.keyVariable != null){
                        varList.add(foreachVariables.keyVariable);
                    }
                    varList.add(foreachVariables.itemVariable);
                    OffsetRange range = new OffsetRange(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex()+1);
                    scopedVariables.put(range, varList);
                }
                //reset
                foreachVariables = null;
            }
        };
    }

    private ParseTreeListener createStructureListener() {

        return new BladeAntlrParserBaseListener() {

            final List<BladeStructureItem> lexerStructure = new ArrayList<>();
            int blockBalance = 0;

            @Override
            public void exitInline_directive(BladeAntlrParser.Inline_directiveContext ctx) {
                ParseTree rootRule = ctx.getChild(0);
                if (rootRule instanceof ParserRuleContext) {
                    ParseTree directive = ((ParserRuleContext) rootRule).getChild(0);
                    if (directive instanceof TerminalNode) {
                        Token directiveToken = ((TerminalNode) directive).getSymbol();
                        if (directiveToken == null) {
                            return;
                        }
                        String directiveName = directiveToken.getText();
                        DirectiveInlineStructureItem inlineElement = new DirectiveInlineStructureItem(directiveName,
                                getFileObject(), directiveToken.getStartIndex(), directiveToken.getStopIndex() + 1);

                        if (blockBalance > 0) {
                            lexerStructure.add(inlineElement);
                        } else {
                            structure.add(inlineElement);
                        }

                    }

                }
            }

            @Override
            public void enterBlock_statement(BladeAntlrParser.Block_statementContext ctx) {
                blockBalance++;
            }

            @Override
            public void exitBlock_statement(BladeAntlrParser.Block_statementContext ctx) {
                ParseTree rootRule = ctx.getChild(0);
                blockBalance--;
                if (rootRule instanceof ParserRuleContext) {
                    ParseTree directive = ((ParserRuleContext) rootRule).getChild(0);
                    if (directive instanceof TerminalNode) {
                        Token directiveToken = ((TerminalNode) directive).getSymbol();
                        if (directiveToken == null) {
                            return;
                        }
                        String directiveName = directiveToken.getText();
                        DirectiveBlockStructureItem blockItem = new DirectiveBlockStructureItem(directiveName,
                                getFileObject(), ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex() + 1);

                        blockItem.nestedItems.addAll(lexerStructure);
                        lexerStructure.clear();
                        if (blockBalance > 0) {
                            lexerStructure.add(blockItem);
                        } else {
                            structure.add(blockItem);
                        }

                    }

                }
            }
        };
    }

    private ReferenceType getReferenceType(ParserContext classType) {
        switch (classType) {
            case EACH:
                return ReferenceType.EACH;
            case EXTENDS:
                return ReferenceType.EXTENDS;
            case INCLUDE:
                return ReferenceType.INCLUDE;
            case YIELD:
                return ReferenceType.YIELD;
            case STACK:
                return ReferenceType.STACK;
            case SECTION:
            case SECTION_INLINE:
                return ReferenceType.SECTION;
            case PUSH:
                return ReferenceType.PUSH;
            case HAS_SECTION:
                return ReferenceType.HAS_SECTION;
            case USE:
                return ReferenceType.USE;
            default:
                return null;
        }
    }

    public Reference findReferenceForDeclaration(int offset) {

        for (Map.Entry<OffsetRange, Reference> entry : occurancesForDeclaration.entrySet()) {
            OffsetRange range = entry.getKey();

            if (offset < range.getStart()) {
                //excedeed the offset range
                return null;
            }

            if (range.containsInclusive(offset)) {
                return entry.getValue();
            }
        }

        return null;
    }

    //todo append variables
    public Set<String> findVariablesForScope(int offset) {

        for (Map.Entry<OffsetRange, Set<String>> entry : scopedVariables.entrySet()) {
            OffsetRange range = entry.getKey();

            if (offset < range.getStart()) {
                //excedeed the offset range
                return null;
            }

            if (range.containsInclusive(offset)) {
                return entry.getValue();
            }
        }

        return null;
    }
    
    /**
     * to be implemented in the future
     *
     * @return
     */
    protected ParseTreeListener createLayoutTreeListener() {

        return new BladeAntlrParserBaseListener() {
            boolean includeContext = true;

            @Override
            public void enterFile(BladeAntlrParser.FileContext ctx) {
//                BladeIndex index = getIndex();
//                if (index == null) {
//                    return;
//                }
//                String fileName = getFileObject().getName().replace(".blade", "");
//                //maybe move in index ??
//                index.getFileObjectPathOccurences(fileName);
            }

            @Override
            public void enterInclude(BladeAntlrParser.IncludeContext ctx) {
                includeContext = true;
            }

            @Override
            public void exitParamAssign(BladeAntlrParser.ParamAssignContext ctx) {
                String variableName = ctx.BL_PARAM_STRING(0).getSymbol().getText();
                int y = 1;
            }

            @Override
            public void exitInclude(BladeAntlrParser.IncludeContext ctx) {
                includeContext = false;
            }
        };
    }

    private ParseTreeListener createSemanticsListener() {
        return new BladeAntlrParserBaseListener() {
            int ifBalance = 0;
            int ifStart = 0;

            @Override
            public void exitCustom_directive(BladeAntlrParser.Custom_directiveContext ctx) {
                String directiveName = ctx.getStart().getText();
                OffsetRange range = new OffsetRange(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex() + 1);
                customDirectivesReferences.put(range, new Reference(ReferenceType.CUSTOM_DIRECTIVE, directiveName, range));
            }

            @Override
            public void enterIf(BladeAntlrParser.IfContext ctx) {
                ifBalance++;
                ifStart = ctx.getStart().getStartIndex();
            }

            @Override
            public void exitEndif(BladeAntlrParser.EndifContext ctx) {
                ifBalance--;
            }

            @Override
            public void exitFile(BladeAntlrParser.FileContext ctx) {
                if (ifBalance != 0) {
                    errors.add(new BladeError(null, "Unclosed @if", null, getFileObject(), ifStart, ctx.getStart().getStopIndex(), Severity.ERROR));
                }
            }

        };
    }

    public void addYieldReference(ReferenceType type, String yieldId, OffsetRange range) {
        Reference ref = new Reference(type, yieldId, range);
        yieldReferences.put(ref.name, ref);
    }

    public void addStackReference(ReferenceType type, String stackId, OffsetRange range) {
        Reference ref = new Reference(type, stackId, range);
        stackReferences.put(ref.name, ref);
    }

    protected BladeIndex getIndex() {
        if (this.indexLoaded) {
            return bladeIndex;
        }
        Project project = FileOwnerQuery.getOwner(this.getFileObject());

        try {
            bladeIndex = BladeIndex.get(project);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        this.indexLoaded = true;
        return bladeIndex;
    }

    @Override
    protected boolean processingFinished() {
        return finished;
    }

    @Override
    public List<? extends Error> getDiagnostics() {
        return errors;
    }

    @Override
    protected void invalidate() {
        //references.clear();
    }

    public Map<String, Reference> getYieldReferences() {
        return yieldReferences;
    }

    public Map<String, Reference> getStackReferences() {
        return stackReferences;
    }

    public PHPParseResult getPhpParserResult() {
        return phpParserResult;
    }

    protected ANTLRErrorListener createErrorListener() {
        return new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                int errorPosition = 0;
                if (offendingSymbol instanceof Token) {
                    Token offendingToken = (Token) offendingSymbol;
                    errorPosition = offendingToken.getStartIndex();
                }
                errors.add(new BladeError(null, msg, null, getFileObject(), errorPosition, errorPosition, Severity.ERROR));
            }

        };
    }

    public final FileObject getFileObject() {
        return getSnapshot().getSource().getFileObject();
    }

    public static class Reference {

        public final ReferenceType type;
        public final String name;
        public final OffsetRange defOffset;

        public Reference(ReferenceType type, String name, OffsetRange defOffset) {
            this.type = type;
            this.name = name;
            this.defOffset = defOffset;
        }
    }

    public class ForeachVariables {

        public String arrayVariable;
        public String keyVariable;
        public String itemVariable;
    }
}
