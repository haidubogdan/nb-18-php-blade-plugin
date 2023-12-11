/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.laravel.editor.completion;

import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.modules.php.api.util.FileUtils;
import org.netbeans.modules.php.editor.lexer.PHPTokenId;
import org.netbeans.modules.php.laravel.editor.EditorUtils;
import org.netbeans.spi.editor.completion.CompletionProvider;
import org.netbeans.spi.editor.completion.CompletionResultSet;
import org.netbeans.spi.editor.completion.CompletionTask;
import org.netbeans.spi.editor.completion.support.AsyncCompletionQuery;
import org.netbeans.spi.editor.completion.support.AsyncCompletionTask;

/**
 *
 * @author bogdan
 */
@MimeRegistration(mimeType = FileUtils.PHP_MIME_TYPE, service = CompletionProvider.class)
public class LaravelCompletionProvider implements CompletionProvider {

    @Override
    public CompletionTask createTask(int queryType, JTextComponent component) {
        TokenSequence<PHPTokenId> ts = EditorUtils.getTokenSequence(component.getDocument(), component.getCaretPosition());
        if (ts == null){
            return null;
        }
        while (ts.movePrevious()){
            Token<PHPTokenId> token = ts.token();
            if (token == null) {
                break;
            }
            PHPTokenId id = token.id();
            if (id == PHPTokenId.PHP_TOKEN){
                break;
            }
        }
        return new AsyncCompletionTask(new AsyncCompletionQueryImpl(), component);
        //final String methodName = getMethodName(ts);
//        Method method = Method.Factory.create(methodName, phpModule, fo);
//        if (method == null) {
//        }
        //return new AsyncCompletionTask(new AsyncCompletionQueryImpl(method, argCount), jtc);
    }

    @Override
    public int getAutoQueryTypes(JTextComponent component, String typedText) {
        return COMPLETION_QUERY_TYPE;
    }

    static class AsyncCompletionQueryImpl extends AsyncCompletionQuery {

        public AsyncCompletionQueryImpl() {
        }

        @Override
        protected void query(CompletionResultSet resultSet, Document doc, final int caretOffset) {
            int x = 1;
            try {
                TokenSequence<PHPTokenId> ts = EditorUtils.getTokenSequence(doc, caretOffset);
                if (ts == null) {
                    return;
                }
                ts.move(caretOffset);
                ts.moveNext();

                Token<PHPTokenId> token = ts.token();
                if (token == null) {
                    return;
                }

                PHPTokenId id = token.id();
                if (id != PHPTokenId.PHP_CONSTANT_ENCAPSED_STRING) {
                    return;
                }
                // current input text
                String currentInputText = token.text().toString();
                String inputText = ""; // NOI18N
                if (currentInputText.length() >= 2) {
                    int tokenStartPosition = ts.offset();
                    int endIndex = caretOffset - tokenStartPosition;
                    if (endIndex > 1) {
                        inputText = currentInputText.substring(1, endIndex);
                    }
                }

            } finally {
                resultSet.finish();
            }
        }

    }
}
