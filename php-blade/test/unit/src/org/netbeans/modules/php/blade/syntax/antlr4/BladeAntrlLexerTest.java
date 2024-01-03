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

    @Test
    public void test_layout_directives() throws Exception {
        performTest("lexer/layout_directives.blade.php");
    }

    @Test
    public void test_paren_balance_issue_in_includes() throws Exception {
        performTest("lexer/paren_balance_issue.blade.php");
    }
    
    @Test
    public void test_verbatim_issue() throws Exception {
        performTest("lexer/verbatim_issue.blade.php");
    }

    @Test
    public void test_format_issue() throws Exception {
        performTest("lexer/format_issue.blade.php");
    }
    
    @Test
    public void test_include_array() throws Exception {
        performTest("lexer/include_array_var.blade.php");
    }
    
    @Test
    public void test_foreach_loop() throws Exception {
        performTest("lexer/foreach_loop.blade.php");
    }
}
