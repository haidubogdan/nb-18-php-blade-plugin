package org.netbeans.modules.php.blade.antlr4.formatter;

import org.netbeans.modules.php.blade.syntax.antlr4.*;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.netbeans.junit.NbTestCase;
import static org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer.*;

/**
 *
 * @author bhaidu
 */
public class BladeAntlrFormatterLexerTestBase extends NbTestCase {

    public BladeAntlrFormatterLexerTestBase(String testName) {
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
        CommonTokenStream tokenStream = BladeUtils.getFormatTokenStream(content);
        System.out.print("\n---Formatter Lexer scan for <<" + filename + ">>\n\n");
        return createResult(tokenStream);
    }

    protected String createResult(CommonTokenStream tokenStream) throws Exception {
        StringBuilder result = new StringBuilder();

        for (Token token : tokenStream.getTokens()) {
            int channel = token.getChannel();
            switch (token.getType()) {
                default:
                    result.append(token.getType());
                    result.append(" ");
                    break;
            }

            String text = replaceLinesAndTabs(token.getText());
            result.append(text);
            result.append(";");
            result.append("\n");
        }

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
