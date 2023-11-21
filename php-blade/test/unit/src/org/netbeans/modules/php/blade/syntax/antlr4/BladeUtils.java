package org.netbeans.modules.php.blade.syntax.antlr4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import org.antlr.v4.runtime.*;

/**
 *
 * @author bhaidu
 */
public class BladeUtils {

    public static String getFileContent(File file) throws Exception {
        StringBuffer sb = new StringBuffer();
        String lineSep = "\n";//NOI18N
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            sb.append(lineSep);
            line = br.readLine();
        }
        br.close();
        return sb.toString();
    }

    public static CommonTokenStream getTokenStream(String content) {
        CharStream stream = new ANTLRInputStream(content);
        BladeAntlrLexer lexer = new BladeAntlrLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();
        return tokens;
    }
    
    public static CommonTokenStream getColoringTokenStream(String content) {
        CharStream stream = new ANTLRInputStream(content);
        BladeAntlrColoringLexer lexer = new BladeAntlrColoringLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();
        return tokens;
    }
}
