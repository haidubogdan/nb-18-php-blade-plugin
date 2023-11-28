package org.netbeans.modules.php.blade.editor.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import org.netbeans.modules.csl.api.Severity;
import org.netbeans.modules.php.blade.syntax.antlr4.BladeAntlrLexer;
import org.netbeans.modules.php.blade.syntax.antlr4.BladeAntlrParser;
import org.netbeans.modules.php.blade.syntax.antlr4.BladeAntlrParserBaseListener;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bhaidu
 */
public class BladeParserResult<T extends Parser> extends ParserResult {

    public final List<DefaultError> errors = new ArrayList<>();
    public final Map<String, Reference> references = new TreeMap<>();
    //public MarkdownFile astMarkdownfile = null;
    public static final Reference EOF = new Reference(ReferenceType.TOKEN, "EOF", OffsetRange.NONE); //NOI18N
    volatile boolean finished = false;

    public BladeParserResult(Snapshot snapshot) {
        super(snapshot);
        references.put(EOF.name, EOF);

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
//            parser.addParseListener(createImportListener());
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

    protected final FileObject getFileObject() {
        return getSnapshot().getSource().getFileObject();
    }

    public enum ReferenceType {
        FRAGMENT, TOKEN, RULE, CHANNEL, MODE
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
