package org.netbeans.modules.php.blade.syntax.antlr4;

import org.junit.Test;

/**
 *
 * @author bhaidu
 */
public class BladeAntrlColoringLexerTest extends BladeAntlrColoringLexerTestBase {

    public BladeAntrlColoringLexerTest(String testName) {
        super(testName);
    }

    @Test
    public void test_general_syntax() throws Exception {
        performTest("lexer/general_syntax.blade.php");
    }

}
