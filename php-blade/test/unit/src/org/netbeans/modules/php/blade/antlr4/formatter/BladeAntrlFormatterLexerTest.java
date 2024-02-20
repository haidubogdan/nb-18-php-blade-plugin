package org.netbeans.modules.php.blade.antlr4.formatter;

import org.netbeans.modules.php.blade.syntax.antlr4.*;
import org.junit.Test;

/**
 *
 * @author bhaidu
 */
public class BladeAntrlFormatterLexerTest extends BladeAntlrFormatterLexerTestBase {

    public BladeAntrlFormatterLexerTest(String testName) {
        super(testName);
    }

    @Test
    public void test_if_foreach_block() throws Exception {
        performTest("formatter/if_foreach_block.blade.php");
    }

}
