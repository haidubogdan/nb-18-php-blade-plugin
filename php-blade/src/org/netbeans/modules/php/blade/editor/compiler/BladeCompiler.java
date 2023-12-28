/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor.compiler;

import java.util.Map;
import java.util.TreeMap;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrParserBaseListener;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.compiler.BladeAntlrCompilerLexer;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.compiler.BladeAntlrCompilerParser;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.compiler.BladeAntlrCompilerParserBaseListener;

/**
 *
 * @author bogdan
 */
public class BladeCompiler {

    boolean finished = false;
    public StringBuilder result = new StringBuilder();
    final Map<OffsetRange, Integer> correctionOffsets = new TreeMap<>();
    int caretOffset = -1;

    public BladeCompiler(int caretOffset) {
        this.caretOffset = caretOffset;
    }

    protected BladeAntlrCompilerParser createParser(Snapshot snapshot) {
        CharStream cs = CharStreams.fromString(String.valueOf(snapshot.getText()));
        BladeAntlrCompilerLexer lexer = new BladeAntlrCompilerLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BladeAntlrCompilerParser ret = new BladeAntlrCompilerParser(tokens);
        ret.removeErrorListener(ConsoleErrorListener.INSTANCE);
        return ret;
    }

    public BladeCompiler get(Snapshot snapshot) {
        if (!finished) {
            BladeAntlrCompilerParser parser = createParser(snapshot);
            //            parser.addParseListener(createFoldListener());
            parser.addParseListener(createPhpCompiledTextListener());

            evaluateParser(parser);

            finished = true;
        }
        return this;
    }

    protected ParseTreeListener createPhpCompiledTextListener() {

        return new BladeAntlrCompilerParserBaseListener() {
            int correctionOffset = 0;
            int lastPhpOffset = 0;

            @Override
            public void exitPhp_blade(BladeAntlrCompilerParser.Php_bladeContext ctx) {
                int startOffset = ctx.getStart().getStartIndex();
                if (lastPhpOffset > 0 && startOffset > 0 && startOffset >= lastPhpOffset) {
                    //fill in the skipped content
                    result.append(new String(new char[startOffset - lastPhpOffset]).replace("\0", " "));
                }
                result.append("<?php");
                correctionOffset += 1;
                //correction range
                OffsetRange statementRange = new OffsetRange(
                        startOffset,
                        ctx.getStop().getStopIndex() + 1
                );
                correctionOffsets.put(statementRange, correctionOffset);
                result.append(ctx.php_blade_code().getText());
                System.out.println("Correction offset " + correctionOffset);
                //a bit of hack
                result.append("     ?>");
                lastPhpOffset = statementRange.getEnd() + correctionOffset;
            }
            
            @Override
            public void exitPhp_inline(BladeAntlrCompilerParser.Php_inlineContext ctx) {
                int startOffset = ctx.getStart().getStartIndex();
                if (lastPhpOffset > 0 && startOffset > 0 && startOffset >= lastPhpOffset) {
                    //fill in the skipped content
                    result.append(new String(new char[startOffset - lastPhpOffset]).replace("\0", " "));
                }

                result.append(ctx.PHP_INLINE().getSymbol().getText());

                lastPhpOffset = ctx.getStop().getStopIndex() + 1 + correctionOffset;
            }
        };
    }

    protected void evaluateParser(BladeAntlrCompilerParser parser) {
        parser.file();
    }

}
