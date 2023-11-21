/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.syntax.antlr4;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.misc.Interval;

/**
 *
 * @author bogdan
 */
public abstract class LexerAdaptor extends Lexer {

    private int _currentRuleType = Token.INVALID_TYPE;
    public int roundParenBalance = 0;
    public int exitIfModePosition = 0;

    public LexerAdaptor(CharStream input) {
        super(input);
    }

    public int getCurrentRuleType() {
        return _currentRuleType;
    }

    public void setCurrentRuleType(int ruleType) {
        this._currentRuleType = ruleType;
    }
    
    @Override
    public Token emit() {
        return super.emit();
    }
    
    @Override
    public void reset() {
        setCurrentRuleType(Token.INVALID_TYPE);
        super.reset();
    }

    /**
     * eager check to see if the character position in a line is at the start
     * 
     * @return 
     */
    public boolean IsNewLineOrStart(){
        return this._tokenStartCharPositionInLine <= 2;
    }
    
    public boolean peekNextChar(char peekChar){
        return (char) this._input.LA(1) == peekChar;
    }

    public boolean peekNextChars(char peekChar, int number){
        for (int i = 1;i< number ; i++){
            if((char) this._input.LA(i) != peekChar){
                return false;
            }
        }
        return true;
    }
    
    public void increaseRoundParenBalance(){
        this.roundParenBalance++;
    }
    
    public void decreaseRoundParenBalance(){
        this.roundParenBalance--;
    }
    
    public int getCurrentPosition(){
        System.out.println("char index " + this.getCharIndex());
        System.out.println(" input index" + this._input.index());
        return this.getCharPositionInLine();
    }
}
