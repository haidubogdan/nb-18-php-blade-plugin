/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.syntax.antlr4.v10;

import java.util.List;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import org.netbeans.spi.lexer.antlr4.AntlrTokenSequence;

/**
 *
 * @author bogdan
 */
public class BladeAntlrUtils {

    public static AntlrTokenSequence getTokens(Document doc) {

        try {
            String text = doc.getText(0, doc.getLength());
            return new AntlrTokenSequence(new BladeAntlrLexer(CharStreams.fromString(text)));
        } catch (BadLocationException ex) {

        }
        return null;
    }

    public static Token getToken(Document doc, int offset) {
        AntlrTokenSequence tokens = getTokens(doc);
        if (tokens == null || tokens.isEmpty()) {
            return null;
        }

        tokens.seekTo(offset);

        if (!tokens.hasNext()) {
            return null;
        }

        return tokens.next().get();
    }

    public static Token findForward(Document doc, Token start,
            List<String> stopTokenText, List<String> openTokensText) {

        AntlrTokenSequence tokens = getTokens(doc);

        if (tokens == null || tokens.isEmpty()) {
            return null;
        }
        
        tokens.seekTo(start.getStopIndex() + 1);
        
        int openTokenBalance = 0;
        
        while(tokens.hasNext()){
            Token nt = tokens.next().get();
            if (nt == null){
                continue;
            }
            
            String tokenText = nt.getText();
            
            if (openTokensText.contains(tokenText)){
                openTokenBalance++;
                continue;
            }
            if (stopTokenText.contains(tokenText)){
                if (openTokenBalance > 0){
                    openTokenBalance--;
                } else {
                    return nt;
                }
            }
         }
        
        return null;
    }
    
    public static Token findBackward(Document doc, Token start,
            List<String> stopTokenText, List<String> openTokensText) {

        AntlrTokenSequence tokens = getTokens(doc);

        if (tokens == null || tokens.isEmpty()) {
            return null;
        }
        
        tokens.seekTo(start.getStartIndex() - 1);
        
        int openTokenBalance = 0;
        
        while(tokens.hasPrevious()){
            Token pt = tokens.previous().get();
            if (pt == null){
                continue;
            }
            
            String tokenText = pt.getText();
            
            if (openTokensText.contains(tokenText)){
                openTokenBalance++;
                continue;
            }
            if (stopTokenText.contains(tokenText)){
                if (openTokenBalance > 0){
                    openTokenBalance--;
                } else {
                    return pt;
                }
            }
         }
        
        return null;
    }
    
    public static Token findBackward(AntlrTokenSequence tokens,
            List<Integer> tokensMatch, List<Integer> tokensStop) {
        
        while(tokens.hasPrevious()){
            Token pt = tokens.previous().get();
            if (pt == null){
                continue;
            }
            
            if (tokensMatch.contains(pt.getType())){
                return pt;
            }
            
            if (tokensStop.contains(pt.getType())){
                return null;
            }
         }
        
        return null;
    }
}
