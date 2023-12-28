package org.netbeans.modules.php.blade.syntax.antlr4.compiler;

import org.netbeans.modules.php.blade.syntax.antlr4.*;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.netbeans.junit.NbTestCase;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.compiler.BladeAntlrCompilerLexer;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.compiler.BladeAntlrCompilerParser;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.compiler.BladeAntlrCompilerParserBaseListener;

/**
 *
 * @author bhaidu
 */
public class BladeAntlrCompilerParserTestBase extends NbTestCase {

    public BladeAntlrCompilerParserTestBase(String testName) {
        super(testName);
    }

    public File getDataDir() {
        URL codebase = getClass().getProtectionDomain().getCodeSource().getLocation();
        File dataDir = null;
        try {
            dataDir = new File(new File(codebase.toURI()), "data");
        } catch (URISyntaxException x) {
            throw new Error(x);
        }
        return dataDir;
    }

    protected void performTest(String filename) throws Exception {
        performTest(filename, null);
    }

    protected String getTestResult(String filename, String caretLine) throws Exception {
        return getTestResult(filename);
    }

    protected void performTest(String filename, String caretLine) throws Exception {
        // parse the file
        String result = getTestResult(filename, caretLine);
        System.out.print(result);
    }

    protected String getTestResult(String filename) throws Exception {
        String content = BladeUtils.getFileContent(new File(getDataDir(), "testfiles/" + filename));
        CharStream stream = new ANTLRInputStream(content);
        BladeAntlrCompilerLexer lexer = new BladeAntlrCompilerLexer(stream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        tokenStream.fill();
        System.out.print("\n---Psrser scan for <<" + filename + ">>\n\n");
        BladeAntlrCompilerParser parser = new BladeAntlrCompilerParser(tokenStream);
        final Map<OffsetRange, Integer> correctionOffsets = new TreeMap<>();
        StringBuilder result = new StringBuilder();
        ParseTreeListener listener = new BladeAntlrCompilerParserBaseListener(){
            int correctionOffset = 0;
            int lastPhpOffset = 0;
            @Override public void exitPhp_blade(BladeAntlrCompilerParser.Php_bladeContext ctx) {
                int startOffset =  ctx.getStart().getStartIndex();
                if (lastPhpOffset > 0 && ctx.getStart().getStartIndex() > 0){
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
                result.append(replaceLinesAndTabs(ctx.php_blade_code().getText()));
                System.out.println("Correction offset " + correctionOffset);
                //a bit of hack
                result.append("     ?>");
                lastPhpOffset = statementRange.getEnd() + correctionOffset;
            }
        };
        parser.addParseListener(listener);
        parser.file();
        
        return result.toString();
    }

    public static String replaceLinesAndTabs(String input) {
        String escapedString = input;
        escapedString = escapedString.replaceAll("\n", "\\\\n"); //NOI18N
        escapedString = escapedString.replaceAll("\r", "\\\\r"); //NOI18N
        escapedString = escapedString.replaceAll("\t", "\\\\t"); //NOI18N
        return escapedString;
    }
}
