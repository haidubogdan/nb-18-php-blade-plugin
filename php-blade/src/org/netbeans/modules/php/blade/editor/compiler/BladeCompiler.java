/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor.compiler;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrParser;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrParserBaseListener;

/**
 *
 * @author bogdan
 */
public class BladeCompiler {

    boolean finished = false;
    int caretOffset = -1;

    public BladeCompiler(int caretOffset) {
        this.caretOffset = caretOffset;
    }

    protected BladeAntlrParser createParser(Snapshot snapshot) {
        CharStream cs = CharStreams.fromString(String.valueOf(snapshot.getText()));
        BladeAntlrLexer lexer = new BladeAntlrLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BladeAntlrParser ret = new BladeAntlrParser(tokens);
        ret.removeErrorListener(ConsoleErrorListener.INSTANCE);
        return ret;
    }

    public BladeCompiler get(Snapshot snapshot) {
        if (!finished) {
            BladeAntlrParser parser = createParser(snapshot);
            //            parser.addParseListener(createFoldListener());
            parser.addParseListener(createPhpCompiledTextListener());

            evaluateParser(parser);

            finished = true;
        }
        return this;
    }

    protected ParseTreeListener createPhpCompiledTextListener() {

        return new BladeAntlrParserBaseListener() {

        };
    }

    protected void evaluateParser(BladeAntlrParser parser) {
        parser.file();
    }

}
