/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.syntax.antlr4.v10;

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
    public int squareParenBalance = 0;
    public int curlyParenBalance = 0;
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

    public void increaseRoundParenBalance() {
        this.roundParenBalance++;
    }

    public void decreaseRoundParenBalance() {
        this.roundParenBalance--;
    }

    public boolean hasNoBladeParamOpenBracket() {
        return this.roundParenBalance == 0
                && this.squareParenBalance == 0
                && this.curlyParenBalance == 0;
    }
    
    public void consumeBladeParamComma(){
        if (this.hasNoBladeParamOpenBracket()){
            this.setType(BladeAntlrLexer.BL_COMMA);
        } else {
            this.setType(BladeAntlrLexer.BL_PARAM_COMMA);
        }
    }
    
    public void consumeRParen(){
        //we start from 0 balance
        this.roundParenBalance--;
        if (this.roundParenBalance < 0) {
            this.roundParenBalance = 0;
            this.setType(BladeAntlrLexer.BLADE_PARAM_RPAREN);
            this.mode(DEFAULT_MODE);
        } else {
             this.setType(BladeAntlrLexer.BLADE_PARAM_EXTRA);
        }
    }

    public void consumeParamRParen(){
        //we start from 0 balance
        this.roundParenBalance--;
        if (this.roundParenBalance < 0) {
            this.roundParenBalance = 0;
            this.setType(BladeAntlrLexer.BLADE_PARAM_RPAREN);
            this.mode(DEFAULT_MODE);
        } else {
             this.setType(BladeAntlrLexer.BLADE_PARAM_EXTRA);
        }
    }
    
    public void consumeExprRParen(){
        //we start from 0 balance
        this.roundParenBalance--;
        this.setType(BladeAntlrLexer.BLADE_EXPR_RPAREN);
        if (this.roundParenBalance < 0) {
            this.roundParenBalance = 0;
            this.mode(DEFAULT_MODE);
        }
    }
    
    //blade coloring lexer
    public void consumeEscapedEchoToken() {
        if (this._input.LA(1) == '}' && this._input.LA(2) == '}') {
            this.setType(BladeAntlrColoringLexer.BLADE_PHP_ECHO_EXPR);
        } else {
            this.more();
        }
    }

    //blade coloring lexer
    public void consumeNotEscapedEchoToken() {
        if (this._input.LA(1) == '!' && this._input.LA(2) == '!' && this._input.LA(3) == '}') {
            this.setType(BladeAntlrColoringLexer.BLADE_PHP_ECHO_EXPR);
        } else {
            this.more();
        }
    }
}
