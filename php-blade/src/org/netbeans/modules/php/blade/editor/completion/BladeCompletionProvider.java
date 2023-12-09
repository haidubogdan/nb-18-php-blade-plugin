package org.netbeans.modules.php.blade.editor.completion;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
import org.netbeans.modules.php.blade.csl.elements.CompletionElement;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.completion.BladeCompletionProposal.OutputCompletionItem;
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
    @MimeRegistration(mimeType = "text/xhtml", service = CompletionProvider.class),
    @MimeRegistration(mimeType = "text/html", service = CompletionProvider.class)
})
public class BladeCompletionProvider implements CompletionProvider {

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

                String prefix;
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
                String closeTag = null;

                if (tokens.hasNext()) {
                    Token nt = tokens.next().get();

                    switch (nt.getType()) {
                        case ESCAPED_ECHO_START:
                            closeTag = "}}";
                            break;
                        case NE_ECHO_START:
                            closeTag = "!!}";
                            break;
                    }

                    if (closeTag != null) {
                        completeCloseTag(nt, doc, closeTag, caretOffset, resultSet);
                        return;
                    }

                    if (!tokens.hasPrevious()) {
                        return;
                    }

                    Token pt = null;
                    switch (nt.getType()) {
                        case BLADE_COMMENT:
                        case PHP_EXPRESSION:
                        case ESCAPED_ECHO_END:
                            return;
                    }

                    if (nt.getType() == HTML) {
                        String nText = nt.getText();
                        if (nText.startsWith("@")) {
                            complete(nText, caretOffset, resultSet);
                            return;
                        }
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

                    } else if (nt.getType() == BL_PARAM_STRING) {
                        String pathName = nt.getText().substring(1, nt.getText().length() - 1);
                        List<Integer> tokensMatch = Arrays.asList(new Integer[]{D_EXTENDS, D_INCLUDE, D_SECTION});
                        List<Integer> tokensStop = Arrays.asList(new Integer[]{HTML, BL_PARAM_CONCAT_OPERATOR});
                        Token directiveToken = BladeAntlrUtils.findBackward(tokens, tokensMatch, tokensStop);

                        if (directiveToken == null) {
                            return;
                        }
                        switch (directiveToken.getType()) {
                            case D_INCLUDE:
                            case D_EXTENDS:

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
                                completeYieldIdFromIndex(pathName, fo, caretOffset, resultSet);
                                return;
                        }

                    } else if (nt.getType() == TOKEN_REF || nt.getType() == BLADE_PHP_ECHO_EXPR) {
                        //completion {{ }} {!! !!}
                        List<Integer> tokensMatch = Arrays.asList(new Integer[]{ESCAPED_ECHO_START, NE_ECHO_START});
                        List<Integer> tokensStop = Arrays.asList(new Integer[]{HTML});
                        Token curlyStartToken = BladeAntlrUtils.findBackward(tokens, tokensMatch, tokensStop);
                        if (curlyStartToken != null) {
                            switch (curlyStartToken.getType()) {
                                case ESCAPED_ECHO_START:
                                    closeTag = "}}";
                                    break;
                                case NE_ECHO_START:
                                    closeTag = "!!}";
                                    break;
                            }
                            tokens.seekTo(nt.getTokenIndex());
                            tokens.next();
                            tokens.next();

                            if (tokens.hasNext()) {
                                Token closeTagToken = tokens.next().get();
                                switch (closeTagToken.getType()) {
                                    case ESCAPED_ECHO_END:
                                    case NE_ECHO_END:
                                        return;
                                }
                            }

                            if (closeTag != null) {
                                completeCloseTag(curlyStartToken, doc, closeTag, caretOffset, resultSet);
                                return;
                            }
                        }
                    }

                    if (nt.getText().trim().isEmpty()) {
                        nt = pt;
                    }
                    completeFromIndex(pt, nt, caretOffset, tokenOffset, fo, resultSet);
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
                        complete(prefix, caretOffset, resultSet);
                    }
                }

            } finally {
                resultSet.finish();
            }
        }
    }

    private void complete(String prefix, int caretOffset, CompletionResultSet resultSet) {
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

    /**
     * @not implemented
     *
     * @param pt
     * @param nt
     * @param caretOffset
     * @param tokenOffset
     * @param fo
     * @param resultSet
     */
    private void completeFromIndex(Token pt, Token nt,
            int caretOffset, int tokenOffset, FileObject fo, CompletionResultSet resultSet) {
        String prefix;
        if (pt != null) {
            prefix = nt.getText();
        } else {
            //we are on the same token
            prefix = nt.getText().substring(0, caretOffset - tokenOffset);
        }

        BladeIndex bladeIndex;
        Project project = FileOwnerQuery.getOwner(fo);
        try {
            bladeIndex = BladeIndex.get(project);
            bladeIndex.getYieldIndexedReferencesIds(prefix);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }

        if (prefix.length() > 0) {
            complete(prefix, caretOffset, resultSet);
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

    private void completeBladePath(String bladePath, FileObject fo,
            int caretOffset, CompletionResultSet resultSet) {

        String filePath = fo.getPath();
        int viewsPos = filePath.indexOf("/views/");

        CompletionItem item = CompletionUtilities.newCompletionItemBuilder(bladePath)
                .iconResource(getReferenceIcon())
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
                .iconResource(getReferenceIcon())
                .startOffset(caretOffset)
                .leftHtmlText(identifier)
                .rightHtmlText(filePath.substring(viewsPos, filePath.length()))
                .sortPriority(1)
                .build();
        resultSet.addItem(item);
    }

    private static final String ICON_BASE = "org/netbeans/modules/php/blade/resources/";

    private static String getReferenceIcon() {
        return ICON_BASE + "icons/at.png";
    }
}
