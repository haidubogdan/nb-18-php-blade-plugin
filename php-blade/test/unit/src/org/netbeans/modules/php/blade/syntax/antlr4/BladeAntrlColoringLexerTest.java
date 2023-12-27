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

    @Test
    public void test_freeze_nekudo_coloring_issue() throws Exception {
        performTest("lexer/freeze_nekudo.blade.php");
    }
}
