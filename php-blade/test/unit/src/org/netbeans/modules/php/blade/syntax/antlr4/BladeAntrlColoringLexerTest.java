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

    @Test
    public void test_last_token_exception() throws Exception {
        performTest("lexer/last_token_exception.blade.php");
    }

    @Test
    public void test_concatenated_string_issue() throws Exception {
        performTest("coloring_lexer/concatenated_string_issue.blade.php");
    }

    @Test
    public void test_style_css_escapes_issue() throws Exception {
        performTest("coloring_lexer/style_css_escapes.blade.php");
    }

    @Test
    public void test_custom_directive_with_no_arg() throws Exception {
        performTest("coloring_lexer/custom_directive_with_no_arg.blade.php");
    }
}
