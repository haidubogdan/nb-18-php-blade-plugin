/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.laravel.editor;

import javax.swing.text.Document;
import org.netbeans.*;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.php.editor.lexer.PHPTokenId;

/**
 *
 * @author bogdan
 */
public class EditorUtils {

    public static TokenSequence<PHPTokenId> getTokenSequence(Document doc, int offset) {
        BaseDocument bdoc = (BaseDocument) doc;
        TokenSequence<PHPTokenId> tokenSequence = null;
        bdoc.atomicLock();
        try {
            TokenHierarchy<Document> hierarchy = TokenHierarchy.get(bdoc);
            tokenSequence = hierarchy.tokenSequence(PHPTokenId.language());
        } finally {
            bdoc.atomicUnlock();
        }
        if (tokenSequence != null) {
            tokenSequence.move(offset);
            tokenSequence.moveNext();
        }
        return tokenSequence;

    }
}
