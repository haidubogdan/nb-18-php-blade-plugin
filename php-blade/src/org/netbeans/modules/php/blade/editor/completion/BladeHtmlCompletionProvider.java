package org.netbeans.modules.php.blade.editor.completion;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.Document;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.netbeans.api.editor.document.EditorDocumentUtils;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.api.editor.mimelookup.MimeRegistrations;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.netbeans.lib.editor.codetemplates.api.CodeTemplateManager;
import org.netbeans.lib.editor.util.swing.DocumentUtilities;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.directives.CustomDirectives;
import org.netbeans.modules.php.blade.editor.directives.CustomDirectives.FilterCallback;
import org.netbeans.modules.php.blade.editor.indexing.BladeIndex;
import org.netbeans.modules.php.blade.editor.indexing.BladeIndex.IndexedReferenceId;
import org.netbeans.modules.php.blade.editor.path.PathUtils;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer;
import static org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer.*;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrUtils;
import org.netbeans.spi.editor.completion.CompletionDocumentation;
import org.netbeans.spi.editor.completion.CompletionItem;
import org.netbeans.spi.editor.completion.CompletionProvider;
import org.netbeans.spi.editor.completion.CompletionResultSet;
import org.netbeans.spi.editor.completion.CompletionTask;
import org.netbeans.spi.editor.completion.support.AsyncCompletionQuery;
import org.netbeans.spi.editor.completion.support.AsyncCompletionTask;
import org.netbeans.spi.editor.completion.support.CompletionUtilities;
import org.netbeans.spi.editor.completion.support.CompletionUtilities.CompletionItemBuilder;
import org.netbeans.spi.lexer.antlr4.AntlrTokenSequence;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;

/**
 *
 * @author bhaidu
 */
@MimeRegistrations(value = {
    @MimeRegistration(mimeType = "text/html", service = CompletionProvider.class)
})
public class BladeHtmlCompletionProvider implements CompletionProvider {

    private static final Logger LOGGER = Logger.getLogger(BladeHtmlCompletionProvider.class.getName());

    public enum CompletionType {
        BLADE_PATH,
        YIELD_ID,
        DIRECTIVE
    }

    @Override
    public CompletionTask createTask(int queryType, JTextComponent component) {
        return new AsyncCompletionTask(new BladeCompletionQuery(), component);
    }

    @Override
    public int getAutoQueryTypes(JTextComponent component, String typedText) {
        FileObject fo = EditorDocumentUtils.getFileObject(component.getDocument());
        if (fo == null || !fo.getMIMEType().equals(BladeLanguage.MIME_TYPE)) {
            return 0;
        }
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
            long startTime = 0;
            if (LOGGER.isLoggable(Level.FINE)) {
                startTime = System.currentTimeMillis();
            }
            AbstractDocument adoc = (AbstractDocument) doc;
            try {
                FileObject fo = EditorDocumentUtils.getFileObject(doc);

                if (fo == null || !fo.getMIMEType().equals(BladeLanguage.MIME_TYPE)) {
                    return;
                }

                String prefix;
                String lineText = "";
                adoc.readLock();
                AntlrTokenSequence tokens;
                try {
                    lineText = doc.getText(0, doc.getLength());
                    tokens = new AntlrTokenSequence(new BladeAntlrLexer(CharStreams.fromString(lineText)));
                } catch (BadLocationException ex) {
                    return;
                } finally {
                    adoc.readUnlock();
                }

                if (tokens.isEmpty()) {
                    return;
                }

                if (lineText.endsWith("\n") && caretOffset > 1) {
                    tokens.seekTo(caretOffset - 1);
                } else {
                    tokens.seekTo(caretOffset);
                }

                String closeTag = null;

                if (tokens.hasNext()) {
                    Token nt = tokens.next().get();

                    switch (nt.getType()) {
                        case ESCAPED_ECHO_START:
                            closeTag = "}}"; //NOI18N
                            break;
                        case NE_ECHO_START:
                            closeTag = "!!}"; //NOI18N
                            break;
                    }

                    if (closeTag != null) {
                        completeCloseTag(nt, doc, closeTag, caretOffset, resultSet);
                        return;
                    }

                    if (!tokens.hasPrevious()) {
                        return;
                    }

//                    Token pt = null;
                    switch (nt.getType()) {
                        case BLADE_COMMENT:
                        case ESCAPED_ECHO_END:
                            return;
                        case PHP_EXPRESSION:
                            return;
                    }

                    switch (nt.getType()) {
                        case HTML:
                            String nText = nt.getText();
                            if (nText.startsWith("@")) {
                                completeDirectives(nText, doc, caretOffset, resultSet);
                            }
                            break;
                    }
                } else if (tokens.hasPrevious()) {
                    Token pt = tokens.previous().get();
                    if (pt == null) {
                        return;
                    }
                    if (pt.getType() == PHP_EXPRESSION || pt.getType() == BLADE_PHP_ECHO_EXPR) {
                        return;
                    }

                    String pText = pt.getText();
                    if (pText.startsWith("@")) {
                        prefix = pt.getText();
                        completeDirectives(prefix, doc, caretOffset, resultSet);
                    }
                }

            } finally {
                if (LOGGER.isLoggable(Level.FINE)) {
                    long time = System.currentTimeMillis() - startTime;
                    LOGGER.fine(String.format("complete() took %d ms", time));
                }
                resultSet.finish();
            }
        }
    }

    @SuppressWarnings("rawtypes")
    private void completeDirectives(String prefix, Document doc, int carretOffset, CompletionResultSet resultSet) {
        int startOffset = carretOffset - prefix.length();
        HashMap<String, HashMap> yamlCompletionList = BladeCompletionService.getDirectiveCompletionList();

        for (String group : yamlCompletionList.keySet()) {
            Set<Entry<String, HashMap>> directiveList = yamlCompletionList.get(group).entrySet();
            for (Entry directiveEntry : directiveList) {
                String directive = (String) directiveEntry.getKey();
                Object info = directiveEntry.getValue();
                String hasArgument = null, description = null, endtag = null;
                if (info instanceof HashMap) {
                    HashMap<String, String> infoList = (HashMap) info;
                    hasArgument = infoList.get("takes_parameter");
                    description = infoList.get("description");
                    endtag = infoList.get("end_tag");
                }

                if (directive.startsWith(prefix)) {
                    if (hasArgument != null && hasArgument.equals("1")) {
                        resultSet.addItem(DirectiveCompletionBuilder.itemWithArg(
                                startOffset, carretOffset, prefix, directive, description, doc));
                        if (endtag != null) {
                            resultSet.addItem(DirectiveCompletionBuilder.itemWithArg(
                                    startOffset, carretOffset, prefix, directive, endtag, description, doc));
                        }
                    } else {
                        resultSet.addItem(DirectiveCompletionBuilder.simpleItem(
                                startOffset, directive, description));
                        if (endtag != null) {
                            resultSet.addItem(DirectiveCompletionBuilder.simpleItem(
                                    startOffset, carretOffset, prefix, directive, endtag, description, doc));
                        }
                    }
                }
            }
        }
        FileObject fo = EditorDocumentUtils.getFileObject(doc);
        Project project = FileOwnerQuery.getOwner(fo);

        CustomDirectives.getInstance(project).filterAction(new FilterCallback() {
            @Override
            public void filterDirectiveName(String directiveName, FileObject file) {
                if (directiveName.startsWith(prefix)) {
                    resultSet.addItem(DirectiveCompletionBuilder.itemWithArg(
                            startOffset, carretOffset, prefix, directiveName,
                            "custom directive", doc, file));
                }
            }
        });
    }

    private void completeYieldIdFromIndex(String prefixIdentifier, FileObject fo,
            int caretOffset, CompletionResultSet resultSet) {
        BladeIndex bladeIndex;
        Project project = FileOwnerQuery.getOwner(fo);
        int insertOffset = caretOffset - prefixIdentifier.length();
        try {
            bladeIndex = BladeIndex.get(project);
            List<IndexedReferenceId> indexedReferences = bladeIndex.getYieldIds(prefixIdentifier);
            for (IndexedReferenceId indexReference : indexedReferences) {
                addYieldIdCompletionItem(indexReference.getIdenfiier(), indexReference.getOriginFile(),
                        insertOffset, resultSet);
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    private void completeCloseTag(Token curlyStartToken, Document doc, String closeTag,
            int caretOffset, CompletionResultSet resultSet) {
        final String finalCloseTag = closeTag;
        CompletionItem item = CompletionUtilities.newCompletionItemBuilder(closeTag)
                .iconResource(getReferenceIcon())
                .startOffset(caretOffset)
                .leftHtmlText(closeTag)
                .rightHtmlText(null)
                .onSelect(ctx -> {
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append(" ");
                        sb.append("${cursor} ");
                        sb.append(finalCloseTag);
                        CodeTemplateManager.get(doc).createTemporary(sb.toString()).insert(ctx.getComponent());
                        if (curlyStartToken.getStopIndex() == (caretOffset - 1)) {
                            doc.insertString(caretOffset, " ", null);
                        }
                    } catch (BadLocationException ex) {
                        Exceptions.printStackTrace(ex);
                    }
                })
                .build();
        resultSet.addItem(item);
    }

    private void completeBladePath(String bladePath, FileObject originFile,
            int caretOffset, CompletionResultSet resultSet) {

        String filePath = originFile.getPath();
        int viewsPos = filePath.indexOf("/views/");

        CompletionItem item = CompletionUtilities.newCompletionItemBuilder(bladePath)
                .iconResource(getReferenceIcon(originFile))
                .startOffset(caretOffset)
                .leftHtmlText(bladePath)
                .rightHtmlText(filePath.substring(viewsPos, filePath.length()))
                .sortPriority(1)
                .build();
        resultSet.addItem(item);
    }

    private void addYieldIdCompletionItem(String identifier, FileObject fo,
            int caretOffset, CompletionResultSet resultSet) {

        String filePath = fo.getPath();
        int viewsPos = filePath.indexOf("/views/");

        CompletionItem item = CompletionUtilities.newCompletionItemBuilder(identifier)
                .iconResource(getReferenceIcon(CompletionType.YIELD_ID))
                .startOffset(caretOffset)
                .leftHtmlText(identifier)
                .rightHtmlText(filePath.substring(viewsPos, filePath.length()))
                .sortPriority(1)
                .build();
        resultSet.addItem(item);
    }

    private static final String ICON_BASE = "org/netbeans/modules/php/blade/resources/"; //NOI18N

    private static String getReferenceIcon() {
        return ICON_BASE + "icons/at.png"; //NOI18N
    }

    private static String getReferenceIcon(CompletionType type) {
        switch (type) {
            case YIELD_ID:
                return ICON_BASE + "icons/layout.png"; //NOI18N
        }
        return ICON_BASE + "icons/at.png";
    }

    private static String getReferenceIcon(FileObject file) {
        if (file.isFolder()) {
            return "org/openide/loaders/defaultFolder.gif"; //NOI18N
        }
        return ICON_BASE + "icons/file.png"; //NOI18N
    }

}
