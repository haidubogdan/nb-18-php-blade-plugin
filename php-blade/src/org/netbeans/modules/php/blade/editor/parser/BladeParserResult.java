package org.netbeans.modules.php.blade.editor.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.BaseErrorListener;

import org.netbeans.modules.csl.spi.DefaultError;
import org.netbeans.modules.csl.api.Error;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.spi.Parser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.netbeans.modules.csl.api.Severity;
import org.netbeans.modules.php.blade.editor.indexing.BladeIndex;
import org.netbeans.modules.php.blade.editor.path.PathUtils;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrParser;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrParserBaseListener;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;

/**
 *
 * @author bhaidu
 */
public class BladeParserResult<T extends Parser> extends ParserResult {

    public final List<DefaultError> errors = new ArrayList<>();
    public final Map<String, Reference> references = new TreeMap<>();
    public final Map<String, Reference> yieldReferences = new TreeMap<>();
    public final Map<OffsetRange, Reference> occurancesForDeclaration = new TreeMap<>();
    public final Set<String> includeFilePaths = new LinkedHashSet<>();
//    public final List<String> yields = new ArrayList<>();
//    public final Map<String, List<OffsetRange>> occurrences = new HashMap<>();
    //public MarkdownFile astMarkdownfile = null;
    protected BladeIndex bladeIndex = null;

    volatile boolean finished = false;
    volatile boolean indexLoaded = false;

    public enum ReferenceType {
        YIELD, SECTION, INCLUDE, EXTENDS
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
            parser.addParseListener(createElementsListener());
            parser.addParseListener(createExtendsListener());
            parser.addParseListener(createDeclarationReferencesListener());
            parser.addParseListener(createYieldsListener());
            parser.addParseListener(createLayoutTreeListener());
//            parser.addParseListener(createStructureListener());
//            parser.addParseListener(createOccurancesListener());
            evaluateParser(parser);

            finished = true;
        }
        return this;
    }

    protected void evaluateParser(BladeAntlrParser parser) {
        parser.file();
    }

    protected ParseTreeListener createElementsListener() {

        return new BladeAntlrParserBaseListener() {
            @Override
            public void enterFile(BladeAntlrParser.FileContext ctx) {
                int x = 1;
            }

            @Override
            public void exitFile(BladeAntlrParser.FileContext ctx) {
                int y = 1;
            }
        };
    }

    protected ParseTreeListener createDeclarationReferencesListener() {

        return new BladeAntlrParserBaseListener() {

            @Override
            public void exitExtends(BladeAntlrParser.ExtendsContext ctx) {
                BladeAntlrParser.Blade_params_expressionContext bladeParamExpression = ctx.blade_params_expression();
                addOccurenceForDeclaration(bladeParamExpression, ReferenceType.EXTENDS);
            }

            @Override
            public void exitInclude(BladeAntlrParser.IncludeContext ctx) {
                BladeAntlrParser.Blade_params_expressionContext bladeParamExpression = ctx.blade_params_expression();
                addOccurenceForDeclaration(bladeParamExpression, ReferenceType.INCLUDE);
            }

            @Override
            public void exitSection(BladeAntlrParser.SectionContext ctx) {
                BladeAntlrParser.Bl_sg_default_paramContext bladeParamExpression = ctx.bl_sg_default_param();
                addOccurenceForDeclaration(bladeParamExpression, ReferenceType.SECTION);
            }

            /**
             * storing occurences for declaration finder the occurence will
             * contain the type, range and identifier (blade path)
             */
            private void addOccurenceForDeclaration(BladeAntlrParser.Blade_params_expressionContext bladeParamExpression,
                    ReferenceType type) {
                if (bladeParamExpression == null) {
                    return;
                }

                if (bladeParamExpression.blade_parameter() == null || bladeParamExpression.blade_parameter().isEmpty()) {
                    return;
                }

                BladeAntlrParser.Blade_parameterContext bladeParam = bladeParamExpression.blade_parameter().get(0);

                if (bladeParam == null) {
                    return;
                }

                if (bladeParam.BL_PARAM_STRING(0) == null) {
                    return;
                }

                Token paramString = bladeParam.BL_PARAM_STRING(0).getSymbol();
                String bladeParamText = paramString.getText();
                bladeParamText = bladeParamText.substring(1, bladeParamText.length() - 1);

                if (bladeParamText.isEmpty()) {
                    return;
                }

                includeFilePaths.add(bladeParamText);

                OffsetRange range = new OffsetRange(paramString.getStartIndex(), paramString.getStopIndex());
                Reference ref = new Reference(type, bladeParamText, range);
                occurancesForDeclaration.put(range, ref);
            }

            private void addOccurenceForDeclaration(BladeAntlrParser.Bl_sg_default_paramContext bladeParamExpression,
                    ReferenceType type) {
                if (bladeParamExpression == null) {
                    return;
                }

                if (bladeParamExpression.blade_parameter() == null || bladeParamExpression.blade_parameter().isEmpty()) {
                    return;
                }

                BladeAntlrParser.Blade_parameterContext bladeParam = bladeParamExpression.blade_parameter();

                if (bladeParam == null) {
                    return;
                }

                if (bladeParam.BL_PARAM_STRING(0) == null) {
                    return;
                }

                Token paramString = bladeParam.BL_PARAM_STRING(0).getSymbol();
                String bladeParamText = paramString.getText();
                bladeParamText = bladeParamText.substring(1, bladeParamText.length() - 1);

                if (bladeParamText.isEmpty()) {
                    return;
                }

                OffsetRange range = new OffsetRange(paramString.getStartIndex(), paramString.getStopIndex());
                Reference ref = new Reference(type, bladeParamText, range);
                occurancesForDeclaration.put(range, ref);
            }

        };

    }

    protected ParseTreeListener createExtendsListener() {

        return new BladeAntlrParserBaseListener() {
            @Override
            public void exitExtends(BladeAntlrParser.ExtendsContext ctx) {

            }
        };
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

    protected ParseTreeListener createYieldsListener() {

        return new BladeAntlrParserBaseListener() {
            @Override
            public void exitExtends(BladeAntlrParser.ExtendsContext ctx) {
                int x = 1;
            }

            public void exitYield(BladeAntlrParser.YieldContext ctx) {
                BladeAntlrParser.Bl_sg_default_paramContext bladeParamExpression = ctx.bl_sg_default_param();
                if (bladeParamExpression == null) {
                    return;
                }
                //first we can add in a reference ?
                //and then in a list?
                BladeAntlrParser.Blade_parameterContext bladeParam = bladeParamExpression.blade_parameter();
                if (bladeParam == null) {
                    return;
                }
                if (bladeParam.BL_PARAM_STRING().size() == 1) {
                    String yieldName = bladeParam.BL_PARAM_STRING(0).getText();
                    if (yieldName == null || yieldName.isEmpty()) {
                        return;
                    }
                    yieldName = yieldName.substring(1, yieldName.length() - 1);
                    if (yieldName.isEmpty()) {
                        return;
                    }

                    addYieldReference(ReferenceType.YIELD, bladeParam.BL_PARAM_STRING(0).getSymbol());
                }
            }
        };
    }

    //it will be used for scope
    protected ParseTreeListener createLayoutTreeListener() {

        return new BladeAntlrParserBaseListener() {
            @Override
            public void enterFile(BladeAntlrParser.FileContext ctx) {
                BladeIndex index = getIndex();
                if (index == null) {
                    return;
                }
                String fileName = getFileObject().getName().replace(".blade", "");
                //maybe move in index ??
                index.getFileObjectPathOccurences(fileName);
            }
        };
    }

    protected String extractStringParamFromParameterContext(BladeAntlrParser.Bl_sg_default_paramContext bladeParamExpression) {
        String param = null;

        if (bladeParamExpression == null) {
            return param;
        }
        //first we can add in a reference ?
        //and then in a list?
        BladeAntlrParser.Blade_parameterContext bladeParam = bladeParamExpression.blade_parameter();
        if (bladeParam.BL_PARAM_STRING().size() == 1) {
            param = bladeParam.BL_PARAM_STRING(0).getText();
            if (param == null || param.isEmpty()) {
                return param;
            }
            param = param.substring(1, param.length() - 1);
            if (param.isEmpty()) {
                return param;
            }
            return param;
        }
        return param;
    }

    public void addYieldReference(ReferenceType type, Token token) {
        OffsetRange range = new OffsetRange(token.getStartIndex(), token.getStopIndex() + 1);
        String name = token.getText().substring(1, token.getText().length() - 1);
        if (name.isEmpty()) {
            return;
        }
        Reference ref = new Reference(type, name, range);
        yieldReferences.put(ref.name, ref);
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
}
