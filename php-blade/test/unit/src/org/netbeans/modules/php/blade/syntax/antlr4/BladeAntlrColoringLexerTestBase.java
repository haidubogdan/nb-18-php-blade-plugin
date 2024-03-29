package org.netbeans.modules.php.blade.syntax.antlr4;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.netbeans.junit.NbTestCase;
import static org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrColoringLexer.*;

/**
 *
 * @author bhaidu
 */
public class BladeAntlrColoringLexerTestBase extends NbTestCase {

    public BladeAntlrColoringLexerTestBase(String testName) {
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
        CommonTokenStream tokenStream = BladeUtils.getColoringTokenStream(content);
        System.out.print("\n---Lexer scan for <<" + filename + ">>\n\n");
        return createResult(tokenStream);
    }

    protected String createResult(CommonTokenStream tokenStream) throws Exception {
        StringBuilder result = new StringBuilder();

        for (Token token : tokenStream.getTokens()) {
            switch (token.getType()) {
                case HTML:
                    result.append("HTML ");
                    break;
                case RAW_TAG:
                    result.append("RAW_TAG ");
                    break;
                case PHP_EXPRESSION:
                    result.append("PHP_EXPRESSION ");
                    break;
                case BLADE_PHP_ECHO_EXPR:
                    result.append("PHP_BLADE_ECHO_EXPR ");
                    break;
                case BLADE_PHP_INLINE:
                    result.append("BLADE_PHP_INLINE ");
                    break;
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
