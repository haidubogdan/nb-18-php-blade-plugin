package org.netbeans.modules.php.blade.editor.completion;

import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.Document;
import org.antlr.v4.runtime.CharStreams;
import org.netbeans.api.editor.document.EditorDocumentUtils;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.api.editor.mimelookup.MimeRegistrations;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.syntax.antlr4.BladeAntlrLexer;
import org.netbeans.spi.editor.completion.CompletionProvider;
import org.netbeans.spi.editor.completion.CompletionItem;
import org.netbeans.spi.editor.completion.CompletionProvider;
import org.netbeans.spi.editor.completion.CompletionResultSet;
import org.netbeans.spi.editor.completion.CompletionTask;
import org.netbeans.spi.editor.completion.support.AsyncCompletionQuery;
import org.netbeans.spi.editor.completion.support.AsyncCompletionTask;
import org.netbeans.spi.editor.completion.support.CompletionUtilities;
import org.netbeans.spi.lexer.antlr4.AntlrTokenSequence;
import org.openide.filesystems.FileObject;
import org.snakeyaml.engine.v2.api.LoadSettings;
import org.snakeyaml.engine.v2.parser.ParserImpl;
import org.snakeyaml.engine.v2.scanner.ScannerImpl;
import org.snakeyaml.engine.v2.scanner.StreamReader;

/**
 *
 * @author bhaidu
 */
@MimeRegistrations(value = {
    @MimeRegistration(mimeType = BladeLanguage.MIME_TYPE, service = CompletionProvider.class),
    @MimeRegistration(mimeType = "text/xhtml", service = CompletionProvider.class),
    @MimeRegistration(mimeType = "text/html", service = CompletionProvider.class)
})
public class BladeCompletionProvider implements CompletionProvider {

    @Override
    public CompletionTask createTask(int queryType, JTextComponent component) {
        return new AsyncCompletionTask(new BladeCompletionQuery(), component);
    }

    @Override
    public int getAutoQueryTypes(JTextComponent component, String typedText) {
        if (typedText.equals("@")) {
            return COMPLETION_QUERY_TYPE;
        }
        return 0;
    }

    private class BladeCompletionQuery extends AsyncCompletionQuery {

        private final LoadSettings SETTINGS = LoadSettings.builder().build();

        public BladeCompletionQuery() {
        }

        @Override
        protected void query(CompletionResultSet resultSet, Document doc, int caretOffset) {
            AbstractDocument adoc = (AbstractDocument) doc;
            try {
                FileObject fo = EditorDocumentUtils.getFileObject(doc);

                if (fo == null) {
                    return;
                }
                ScannerImpl scanner = new ScannerImpl(SETTINGS, new StreamReader(SETTINGS, "test"));
                ParserImpl parser = new ParserImpl(SETTINGS, scanner);
                String prefix = "";
                adoc.readLock();
                AntlrTokenSequence tokens;
                try {
                    String text = doc.getText(0, doc.getLength());
                    tokens = new AntlrTokenSequence(new BladeAntlrLexer(CharStreams.fromString(text)));
                } catch (BadLocationException ex) {
                    return;
                } finally {
                    adoc.readUnlock();
                }
            } finally {
                resultSet.finish();
            }
        }
    }
}
