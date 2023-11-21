package org.netbeans.modules.php.blade.syntax.antlr4;

import org.junit.Test;

/**
 *
 * @author bhaidu
 */
public class BladeAntrlLexerTest extends BladeAntlrLexerTestBase {

    public BladeAntrlLexerTest(String testName) {
        super(testName);
    }

    @Test
    public void test_general_syntax() throws Exception {
        performTest("lexer/general_syntax.blade.php");
    }

}
