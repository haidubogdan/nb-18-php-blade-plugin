package org.netbeans.modules.php.blade.editor.completion;

import java.util.HashMap;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.Document;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.netbeans.api.editor.document.EditorDocumentUtils;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.api.editor.mimelookup.MimeRegistrations;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.YamlConfig;
import org.netbeans.modules.php.blade.syntax.antlr4.BladeAntlrLexer;
import static org.netbeans.modules.php.blade.syntax.antlr4.BladeAntlrLexer.*;
import org.netbeans.spi.editor.completion.CompletionItem;
import org.netbeans.spi.editor.completion.CompletionProvider;
import org.netbeans.spi.editor.completion.CompletionResultSet;
import org.netbeans.spi.editor.completion.CompletionTask;
import org.netbeans.spi.editor.completion.support.AsyncCompletionQuery;
import org.netbeans.spi.editor.completion.support.AsyncCompletionTask;
import org.netbeans.spi.editor.completion.support.CompletionUtilities;
import org.netbeans.spi.lexer.antlr4.AntlrTokenSequence;
import org.openide.filesystems.FileObject;

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
        if (typedText.length() == 0) {
            return 0;
        }

        //don't autocomplete on space, \n, )
        if (typedText.trim().isEmpty()) {
            return 0;
        }

        char lastChar = typedText.charAt(typedText.length() - 1);
        switch (lastChar) {
            case ')':
            case '\n':
            case '<':
                return 0;
        }

        return COMPLETION_QUERY_TYPE;
    }

    private class BladeCompletionQuery extends AsyncCompletionQuery {

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

                if (tokens.isEmpty()) {
                    return;
                }
                tokens.seekTo(caretOffset);
                int tokenOffset = tokens.getOffset();

                if (tokens.hasNext()) {
                    Token nt = tokens.next().get();
                    Token pt = null;
                    switch (nt.getType()) {
                        case BLADE_COMMENT:
                        case PHP_EXPRESSION:
                            return;
                    }

                    if (!tokens.hasPrevious()) {
                        return;
                    }

                    if (nt.getType() == HTML) {
                        pt = tokens.previous().get();
                        if (pt == null) {
                            return;
                        }
                        if (pt.getText().trim().isEmpty()) {
                            pt = tokens.previous().get();
                        }

                        if (pt.getType() == PHP_EXPRESSION) {
                            return;
                        }
                        if (pt.equals(AT)) {
                            prefix = "@";
                        } else if (nt.getText().trim().isEmpty()) {
                            nt = pt;
                        }
                        String ptText = pt.getText();
                        int x = 1;
                    }

                    String nText = nt.getText();
                    if (pt != null) {
                        prefix = nt.getText();
                    } else {
                        prefix = prefix + nt.getText().substring(0, caretOffset - tokenOffset);
                    }
                    int startOffset = caretOffset - prefix.length();
                    HashMap<String, HashMap> yamlCompletionList = BladeCompletionService.getDirectiveCompletionList();
                    for (String group : yamlCompletionList.keySet()) {
                        for (Object directiveKey : yamlCompletionList.get(group).keySet()) {
                            String directive = directiveKey.toString();
                            String descr = (String) yamlCompletionList.get(group).get("description");
                            if (directive.startsWith(prefix)) {
                                CompletionItem item = CompletionUtilities.newCompletionItemBuilder(directive)
                                        .iconResource(getReferenceIcon())
                                        .startOffset(startOffset)
                                        .leftHtmlText(descr)
                                        .rightHtmlText("right")
                                        .sortText(directive)
                                        .build();
                                resultSet.addItem(item);
                            }
                        }
                    }

                } else if (tokens.hasPrevious()) {
                    Token pt = tokens.previous().get();
                    if (pt == null) {
                        return;
                    }

                    String pText = pt.getText();
                    if (pText.startsWith("@")) {
                        prefix = pt.getText();
                        int startOffset = caretOffset - prefix.length();
                        HashMap<String, HashMap> yamlCompletionList = BladeCompletionService.getDirectiveCompletionList();
                        for (String group : yamlCompletionList.keySet()) {
                            for (Object directiveKey : yamlCompletionList.get(group).keySet()) {
                                String directive = directiveKey.toString();
                                String descr = (String) yamlCompletionList.get(group).get("description");
                                if (directive.startsWith(prefix)) {
                                    CompletionItem item = CompletionUtilities.newCompletionItemBuilder(directive)
                                            .iconResource(getReferenceIcon())
                                            .startOffset(startOffset)
                                            .leftHtmlText(descr)
                                            .rightHtmlText("right")
                                            .sortText(directive)
                                            .build();
                                    resultSet.addItem(item);
                                }
                            }
                        }
                    }
                }

            } finally {
                resultSet.finish();
            }
        }
    }

    private static final String ICON_BASE = "org/netbeans/modules/php/blade/resources/";

    private static String getReferenceIcon() {
        return ICON_BASE + "icons/at.png";
    }
}
