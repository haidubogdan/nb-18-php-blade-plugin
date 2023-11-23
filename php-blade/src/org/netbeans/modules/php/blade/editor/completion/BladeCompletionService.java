package org.netbeans.modules.php.blade.editor.completion;

import java.util.HashMap;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.netbeans.api.editor.document.EditorDocumentUtils;
import org.netbeans.modules.csl.api.CodeCompletionHandler.QueryType;
import org.netbeans.modules.php.blade.editor.YamlConfig;
import org.netbeans.modules.php.blade.syntax.antlr4.BladeAntlrLexer;
import static org.netbeans.modules.php.blade.syntax.antlr4.BladeAntlrLexer.*;
import static org.netbeans.spi.editor.completion.CompletionProvider.COMPLETION_QUERY_TYPE;
import org.netbeans.spi.lexer.antlr4.AntlrTokenSequence;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bhaidu
 */
public class BladeCompletionService {

    private static HashMap<String, HashMap> yamlCompletionConfig;

    public static QueryType getQueryType(JTextComponent component, String typedText) {
        Document doc = component.getDocument();
        AbstractDocument adoc = (AbstractDocument) doc;
        int caretOffset = component.getCaretPosition();

        adoc.readLock();
        AntlrTokenSequence tokens;
        try {
            String text = doc.getText(0, doc.getLength());
            tokens = new AntlrTokenSequence(new BladeAntlrLexer(CharStreams.fromString(text)));
        } catch (BadLocationException ex) {
            return QueryType.STOP;
        } finally {
            adoc.readUnlock();
        }

        if (tokens.isEmpty()) {
            return QueryType.STOP;
        }

        tokens.seekTo(caretOffset);

        if (tokens.hasNext()) {
            Token nt = tokens.next().get();
            switch (nt.getType()) {
                case HTML:
                case BLADE_COMMENT:
                    return QueryType.STOP;
                default:
                    return QueryType.ALL_COMPLETION;
            }
        }

        if (tokens.hasPrevious()) {
            Token pt = tokens.previous().get();
            if (pt == null) {
                return QueryType.STOP;
            }

            switch (pt.getType()) {
                case AT:
                    return QueryType.ALL_COMPLETION;
            }
        }
        return QueryType.STOP;
    }

    public static int getCompletionQueryType(JTextComponent component, String typedText) {
        Document doc = component.getDocument();
        AbstractDocument adoc = (AbstractDocument) doc;
        int caretOffset = component.getCaretPosition();
        int queryType = 0;
        try {
            FileObject fo = EditorDocumentUtils.getFileObject(doc);

            if (fo == null) {
                return 0;
            }

            String prefix = "";
            adoc.readLock();
            AntlrTokenSequence tokens;
            try {
                String text = doc.getText(0, doc.getLength());
                tokens = new AntlrTokenSequence(new BladeAntlrLexer(CharStreams.fromString(text)));
            } catch (BadLocationException ex) {
                return 0;
            } finally {
                adoc.readUnlock();
            }

            if (!tokens.isEmpty()) {
                tokens.seekTo(caretOffset);
                int tokenOffset = tokens.getOffset();

                if (tokens.hasNext()) {
                    Token nt = tokens.next().get();
                    switch (nt.getType()) {
                        case HTML:
                            return 0;
                        default:
                            queryType = COMPLETION_QUERY_TYPE;
                            return COMPLETION_QUERY_TYPE;
                    }
                }

                if (tokens.hasPrevious()) {
                    Token pt = tokens.previous().get();
                    if (pt == null) {
                        return 0;
                    }
                    String previousTokenText = pt.getText();
                    switch (pt.getType()) {
                        case AT:
                            queryType = COMPLETION_QUERY_TYPE;
                            return COMPLETION_QUERY_TYPE;
                    }
                }
            }
        } finally {
            return queryType;
        }
    }

    public static HashMap<String, HashMap> getDirectiveCompletionList() {

        if (yamlCompletionConfig == null) {
            yamlCompletionConfig = YamlConfig.getConfigMapping("directives_list.yml");
        }

        return yamlCompletionConfig;
    }
}
