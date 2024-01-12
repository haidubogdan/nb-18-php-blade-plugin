package org.netbeans.modules.php.blade.syntax.antlr4;

import org.junit.Test;

/**
 *
 * @author bhaidu
 */
public class BladeAntrlParserTest extends BladeAntlrParserTestBase {

    public BladeAntrlParserTest(String testName) {
        super(testName);
    }

    @Test
    public void test_general_syntax() throws Exception {
        performTest("parser/general_syntax.blade.php");
    }

    @Test
    public void test_layout_directives() throws Exception {
        performTest("lexer/layout_directives.blade.php");
    }
    
    @Test
    public void test_echo_class_occurence() throws Exception {
        performTest("parser/echo_class_occurence.blade.php");
    }
}
