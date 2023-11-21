lexer grammar BladeAntlrColoringLexer;

@header{
  package org.netbeans.modules.php.blade.syntax.antlr4;
}

options { superClass = LexerAdaptor; }
 
tokens { TOKEN_REF,
 RULE_REF,
 LEXER_CHAR_SET,
 PHP_EXPRESSION_WS,
 PHP_ENTITY_NAME,
 PHP_OPERATORS,
 BLADE_DIRECTIVE,
 BLADE_DIRECTIVE_NO_EXPRESSION,
 QUOTED_STRING,
 BLADE_PHP_CONTENT,
 ERROR   
}

//GENERAL FRAGMENTS
fragment 
QUOTED_STRING_FRG : '"' ([\\"] | . )*? '"'
| '\'' (~('\'' | '\\') | '\\' . )* '\'';

fragment NAME_STRING : [a-zA-Z_\u0080-\ufffe][a-zA-Z0-9_\u0080-\ufffe]*;

//blade fragments
fragment BLADE_CONDITIONAL_START_FRAGMENTS : '@if' | '@can';

//php fragments
fragment PHP_OPEN_FRAGMENT : '<?php';
//html fragments
fragment HTML_TEXT_FRAGMENT : '<' { this._input.LA(1) != '?'}? (.)+? { this._input.LA(1) != '@' && this._input.LA(1) != '<' }? '>';    
    
//===============================
//Tokens

//display
ESCAPED_DOUBLE_CURLY : '@{{';
BLADE_ESCAPED_ECHO_START : '{{' ->pushMode(INSIDE_ESCAPED_ECHO);

//directives
//css directives
CSS_DIRECTIVES : ('@media' | '@layer' | '@tailwind' | '@apply' | '@-webkit-keyframes' | '@keyframes') ->type(HTML_TEXT);
ESCAPED_DIRECTIVE : '@@' ->type(HTML_TEXT);

//conditionals
BLADE_CONDITIONALS_START : 
    BLADE_CONDITIONAL_START_FRAGMENTS->pushMode(INSIDE_BLADE_IF_EXPRESSION);

BLADE_ELSE_IF : '@elseif'->pushMode(INSIDE_BLADE_IF_EXPRESSION);
BLADE_ELSE : '@else';
BLADE_ENDIF : '@endif';

//includes
BLADE_INCLUDE : '@include'->pushMode(INSIDE_INCLUDE_EXPRESSION);

//php
PHP_OPEN : PHP_OPEN_FRAGMENT;
//html
HTML_TEXT : HTML_TEXT_FRAGMENT+ | NAME_STRING;

NL :[\r\n]->type(HTML_TEXT);
WS :[\t ]+->type(HTML_TEXT);

OTHER : . ->type(HTML_TEXT);

//modes
mode INSIDE_ESCAPED_ECHO;

BLADE_ESCAPED_CONTENT : (.)+? { this._input.LA(1) == '}' && this._input.LA(2) == '}' }? ->type(BLADE_PHP_CONTENT);

BLADE_ESCAPED_ECHO_END : ('}}') ->popMode;

//pop only on new line for better display
NL_ECHO : [\r\n]->type(ERROR),popMode;
ERROR_BLADE_ESCAPED : . ->type(ERROR);

//
mode INSIDE_INCLUDE_EXPRESSION;

INC_VARIABLE: [$] NAME_STRING;
INC_QUOTED_STRING : QUOTED_STRING_FRG ->type(QUOTED_STRING);

OPEN_INC_LPAREN : {this.roundParenBalance == 0}? '(' {this.increaseRoundParenBalance();};
//todo store last paren position
CLOSE_INC_RPAREN: {this.roundParenBalance == 1}? ')' {this.decreaseRoundParenBalance();}->popMode;
INC_LPAREN : {this.roundParenBalance > 0}? '('  {this.increaseRoundParenBalance();};
INC_RPAREN : {this.roundParenBalance > 0}? ')' {this.decreaseRoundParenBalance();};

INC_WS : ([\t ] | [\r\n])->type(PHP_EXPRESSION_WS);

INC_EXIT_RPAREN : ')' {this.roundParenBalance == 0}?->type(CLOSE_INC_RPAREN),popMode;
OTHER_BLADE_INC_EXPRESSION : .  ->type(PHP_OPERATORS) ;
//
mode INSIDE_BLADE_IF_EXPRESSION;

IF_VARIABLE: [$] NAME_STRING;
IF_QUOTED_STRING : QUOTED_STRING_FRG ->type(QUOTED_STRING);

OPEN_IF_LPAREN : {this.roundParenBalance == 0}? '(' {this.increaseRoundParenBalance();};
//todo store last paren position
CLOSE_IF_RPAREN: {this.roundParenBalance == 1}? ')' {this.decreaseRoundParenBalance();}->popMode;
IF_LPAREN : {this.roundParenBalance > 0}? '('  {this.increaseRoundParenBalance();};
IF_RPAREN : {this.roundParenBalance > 0}? ')' {this.decreaseRoundParenBalance();};

IF_PHP_OPERATORS : ('.' | ':' | '->' ) ->type(PHP_OPERATORS);
IF_PHP_LOGICAL_OPERATORS : ('&&' | '&' | '||' ) ->type(PHP_OPERATORS);

IF_PHP_ENTITY_NAME: NAME_STRING->type(PHP_ENTITY_NAME);
IF_WS : ([\t ] | [\r\n])->type(PHP_EXPRESSION_WS);

IF_EXIT_RPAREN : ')' {this.roundParenBalance == 0}?->type(CLOSE_IF_RPAREN),popMode;
OTHER_BLADE_IF_EXPRESSION : .  ->type(PHP_OPERATORS) ;