package org.netbeans.modules.php.blade.editor.completion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.indexing.BladeIndex;
import org.netbeans.modules.php.blade.editor.indexing.BladeIndex.IndexedReferenceId;
import org.netbeans.modules.php.blade.editor.path.PathUtils;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer;
import static org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer.*;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrUtils;
import org.netbeans.spi.editor.completion.CompletionItem;
import org.netbeans.spi.editor.completion.CompletionProvider;
import org.netbeans.spi.editor.completion.CompletionResultSet;
import org.netbeans.spi.editor.completion.CompletionTask;
import org.netbeans.spi.editor.completion.support.AsyncCompletionQuery;
import org.netbeans.spi.editor.completion.support.AsyncCompletionTask;
import org.netbeans.spi.editor.completion.support.CompletionUtilities;
import org.netbeans.spi.lexer.antlr4.AntlrTokenSequence;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;

/**
 *
 * @author bhaidu
 */
@MimeRegistrations(value = {
    @MimeRegistration(mimeType = BladeLanguage.MIME_TYPE, service = CompletionProvider.class),
})
public class BladeCompletionProvider implements CompletionProvider {

    private static final Logger LOGGER = Logger.getLogger(BladeCompletionProvider.class.getName());

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
            case '>':
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
                        case BL_PARAM_STRING: {
                            String pathName = nt.getText().substring(1, nt.getText().length() - 1);
                            List<Integer> tokensMatch = Arrays.asList(new Integer[]{
                                D_EXTENDS, D_INCLUDE, D_SECTION, D_HAS_SECTION,
                                D_INCLUDE_IF, D_INCLUDE_WHEN, D_INCLUDE_UNLESS, D_INCLUDE_FIRST,
                                D_EACH, D_PUSH
                            });     //todo 
                            //we should have the stop tokens depending on context
                            List<Integer> tokensStop = Arrays.asList(new Integer[]{HTML, BL_COMMA, BL_PARAM_CONCAT_OPERATOR});
                            Token directiveToken = BladeAntlrUtils.findBackward(tokens, tokensMatch, tokensStop);
                            if (directiveToken == null) {
                                return;
                            }
                            switch (directiveToken.getType()) {
                                case D_EXTENDS:
                                case D_INCLUDE:
                                case D_INCLUDE_IF:
                                case D_INCLUDE_WHEN:
                                case D_INCLUDE_UNLESS:
                                case D_EACH:

                                    int lastDotPos;

                                    if (pathName.endsWith(".")) {
                                        lastDotPos = pathName.length();
                                    } else {
                                        lastDotPos = pathName.lastIndexOf(".");
                                    }
                                    int pathOffset;

                                    if (lastDotPos > 0) {
                                        pathOffset = caretOffset - pathName.length() + lastDotPos;
                                    } else {
                                        pathOffset = caretOffset - pathName.length();
                                    }
                                    List<FileObject> childrenFiles = PathUtils.getParentChildrenFromPrefixPath(fo, pathName);
                                    for (FileObject file : childrenFiles) {
                                        String pathFileName = file.getName();
                                        if (!file.isFolder()) {
                                            pathFileName = pathFileName.replace(".blade", "");
                                        }
                                        completeBladePath(pathFileName, file, pathOffset, resultSet);
                                    }
                                    return;
                                case D_SECTION:
                                case D_HAS_SECTION:
                                    completeYieldIdFromIndex(pathName, fo, caretOffset, resultSet);
                            }
                            break;
                        }
                        case BLADE_PHP_ECHO_EXPR: {
                            //completion {{ }} {!! !!}
                            List<Integer> tokensMatch = Arrays.asList(new Integer[]{ESCAPED_ECHO_START, NE_ECHO_START});
                            List<Integer> tokensStop = Arrays.asList(new Integer[]{HTML, ESCAPED_ECHO_END, NE_ECHO_END});
                            Token curlyStartToken = BladeAntlrUtils.findBackward(tokens, tokensMatch, tokensStop);
                            if (curlyStartToken != null) {
                                switch (curlyStartToken.getType()) {
                                    case ESCAPED_ECHO_START:
                                        closeTag = "}}"; //NOI18N
                                        break;
                                    case NE_ECHO_START:
                                        closeTag = "!!}"; //NOI18N
                                        break;
                                }

                                int matchTokenType = BladeAntlrUtils.getTagPairTokenType(curlyStartToken.getType());
                                List<Integer> skipableTokenTypes = new ArrayList<>();
                                skipableTokenTypes.add(BLADE_PHP_ECHO_EXPR);
                                skipableTokenTypes.add(PHP_VARIABLE);
                                skipableTokenTypes.add(PHP_IDENTIFIER);
                                skipableTokenTypes.add(PHP_STATIC_ACCESS);

                                Token curlyEndToken = BladeAntlrUtils.findForward(doc,
                                        curlyStartToken,
                                        matchTokenType,
                                        skipableTokenTypes);

                                if (curlyEndToken != null){
                                    return;
                                }

                                if (closeTag != null) {
                                    completeCloseTag(curlyStartToken, doc, closeTag, caretOffset, resultSet);
                                }
                            }
                            break;
                        }
                        default:
                            break;
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
