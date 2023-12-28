package org.netbeans.modules.php.blade.syntax.antlr4.compiler;

import org.junit.Test;

/**
 *
 * @author bhaidu
 */
public class BladeAntrlCompilerParserTest extends BladeAntlrCompilerParserTestBase {

    public BladeAntrlCompilerParserTest(String testName) {
        super(testName);
    }

    @Test
    public void test_inline_php_compiler() throws Exception {
        performTest("compiler/php_inline.blade.php");
    }

}
