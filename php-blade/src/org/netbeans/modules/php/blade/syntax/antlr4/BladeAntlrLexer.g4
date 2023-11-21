lexer grammar BladeAntlrLexer;

@header{
  package org.netbeans.modules.php.blade.syntax.antlr4;
}

options { superClass = LexerAdaptor; }
 
tokens { TOKEN_REF ,
 RULE_REF , LEXER_CHAR_SET,
 PHP_EXPRESSION_WS,
 PHP_ENTITY_NAME,
 PHP_OPERATORS,
 DOUBLE_QUOTED_STRING,
 SINGLE_QUOTED_STRING   
 }

 //display
ESCAPED_DOUBLE_CURLY : '@{{';
BLADE_ESCAPED_ECHO_START : '{{' ->pushMode(INSIDE_ESCAPED_ECHO);   
    
//directives
ESCAPED_DIRECTIVE : '@@' ->type(HTML_TEXT);

BLADE_IF : '@if' ->pushMode(INSIDE_BLADE_IF_EXPRESSION);
BLADE_ELSE : '@else';
BLADE_ELSEIF : '@elseif';
BLADE_ENDIF : '@endif';

//php
PHP_OPEN : PHP_OPEN_FRAGMENT;
//html
HTML_TEXT : HTML_TEXT_FRAGMENT+;

WS :[\t ]+->type(HTML_TEXT);
OTHER : . ->type(HTML_TEXT);

//GENERAL FRAGMENTS
fragment ESC_DOUBLE_QUOTED_STRING : [\\"];
fragment DOUBLE_QUOTED_STRING_FRAGMENT : '"' (ESC_DOUBLE_QUOTED_STRING | . )*? '"';
fragment SINGLE_QUOTED_STRING_FRAGMENT : '\'' (~('\'' | '\\') | '\\' . )* '\'';
fragment NAME_STRING : [a-zA-Z_\u0080-\ufffe][a-zA-Z0-9_\u0080-\ufffe]*;

//php fragments
fragment PHP_OPEN_FRAGMENT : '<?php';
//html fragments
fragment HTML_TEXT_FRAGMENT : '<' (.)+? ~('@' | '<' | '?');

mode INSIDE_ESCAPED_ECHO;

BLADE_ESCAPED_CONTENT : (.)+? { this._input.LA(1) == '}' }?;

BLADE_ESCAPED_ECHO_END : ('}}')->popMode;

ERROR_BLADE_ESCAPED : . ->type(HTML_TEXT);

mode INSIDE_BLADE_IF_EXPRESSION;

IF_DOUBLE_QUOTED_STRING : DOUBLE_QUOTED_STRING_FRAGMENT ->type(DOUBLE_QUOTED_STRING);
IF_SINGLE_QUOTED_STRING : SINGLE_QUOTED_STRING_FRAGMENT->type(SINGLE_QUOTED_STRING);

OPEN_IF_LPAREN: {this.roundParenBalance == 0}? '(' {this.increaseRoundParenBalance();};
CLOSE_IF_RPAREN: {this.roundParenBalance == 1}? ')' {this.decreaseRoundParenBalance();}->popMode;
IF_LPAREN: {this.roundParenBalance > 0}? '('  {this.increaseRoundParenBalance();};
IF_RPAREN: {this.roundParenBalance > 0}? ')' {this.decreaseRoundParenBalance();};

IF_PHP_OPERATORS: ('.' | ':' | '->') ->type(PHP_OPERATORS);

IF_VARIABLE: '$' NAME_STRING;

IF_PHP_ENTITY_NAME: NAME_STRING->type(PHP_ENTITY_NAME);

IF_WS : [\t ]->type(PHP_EXPRESSION_WS);

OTHER_BLADE_IF_EXPRESSION : . ;

  
