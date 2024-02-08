lexer grammar BladeAntlrLexer;
import BladeCommonLexer;

@header{
  package org.netbeans.modules.php.blade.syntax.antlr4.v10;
}

options { 
    superClass = LexerAdaptor;
    caseInsensitive = true;
}
 
tokens {
   PHP_EXPRESSION,
   PHP_VARIABLE,
   PHP_KEYWORD,
   PHP_IDENTIFIER,
   PHP_STATIC_ACCESS,
   BLADE_PARAM_EXTRA,
   BLADE_PARAM_LPAREN,
   BLADE_PARAM_RPAREN,
   BLADE_EXPR_LPAREN,
   BLADE_EXPR_RPAREN,
   BL_SQ_LPAREN,
   BL_SQ_LRAREN,
   BL_PARAM_STRING,
   BL_PARAM_ASSIGN,
   BLADE_PHP_ECHO_EXPR,
   BL_COMMA,
   BL_PARAM_COMMA,
   ERROR
}
 
channels { COMMENT, PHP_CODE }

//RULES


//conditionals
D_IF : '@if'->pushMode(LOOK_FOR_PHP_COMPOSED_EXPRESSION);
D_ELSEIF : '@elseif'->pushMode(LOOK_FOR_PHP_COMPOSED_EXPRESSION);
D_ELSE : '@else';
D_ENDIF : '@endif';
D_SWITCH : '@switch'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_CASE : '@case'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_DEFAULT : '@default';
D_ENDSWITCH : '@endswitch';

D_EMPTY : '@empty'->pushMode(LOOK_FOR_PHP_COMPOSED_EXPRESSION);
D_ENDEMPTY : '@endempty';

D_COND_BLOCK_START : ('@unless' | '@isset')->pushMode(LOOK_FOR_PHP_COMPOSED_EXPRESSION);
D_COND_BLOCK_END : ('@endunless' | '@endisset');

//loops
D_FOREACH : '@foreach'->pushMode(FOREACH_LOOP_EXPRESSION);
D_ENDFOREACH : '@endforeach';
D_FOR : '@for'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_ENDFOR : '@endfor';
D_FORELSE : '@forelse'->pushMode(FOREACH_LOOP_EXPRESSION);
D_ENDFORELSE : '@endforelse';
D_WHILE : '@while'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_ENDWHILE : '@endwhile';
D_BREAK : '@break'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_LOOP_ACTION : ('@continue')->pushMode(LOOK_FOR_PHP_EXPRESSION);

//includes
D_INCLUDE : '@include'->pushMode(LOOK_FOR_BLADE_PARAMETERS);
D_INCLUDE_IF : '@includeIf'->pushMode(LOOK_FOR_BLADE_PARAMETERS);
D_INCLUDE_WHEN : '@includeWhen'->pushMode(LOOK_FOR_BLADE_PARAMETERS);
D_INCLUDE_FIRST : '@includeFirst'->pushMode(LOOK_FOR_BLADE_PARAMETERS);
D_INCLUDE_UNLESS : '@includeUnless'->pushMode(LOOK_FOR_BLADE_PARAMETERS);
D_EACH : '@each'->pushMode(LOOK_FOR_BLADE_PARAMETERS);

//layout
D_EXTENDS : '@extends'->pushMode(LOOK_FOR_BLADE_PARAMETERS);
D_JS : '@js'->pushMode(LOOK_FOR_BLADE_PARAMETERS);
D_SECTION : '@section'->pushMode(LOOK_FOR_BLADE_PARAMETERS);
D_HAS_SECTION : '@hasSection'->pushMode(LOOK_FOR_BLADE_PARAMETERS);
D_SECTION_MISSING : '@sectionMissing'->pushMode(LOOK_FOR_BLADE_PARAMETERS);
D_ENDSECTION : '@endsection';
D_YIELD : '@yield'->pushMode(LOOK_FOR_BLADE_PARAMETERS);
D_PARENT : '@parent';
D_SHOW : '@show';
D_OVERWRITE : '@overwrite';
D_STOP : '@stop';
D_ONCE : '@once';
D_ENDONCE : '@endonce';
D_STACK : '@stack'->pushMode(LOOK_FOR_BLADE_PARAMETERS);
D_PUSH : '@push'->pushMode(LOOK_FOR_BLADE_PARAMETERS);
D_ENDPUSH : '@endpush';
D_PUSH_ONCE : '@pushOnce'->pushMode(LOOK_FOR_BLADE_PARAMETERS);
D_ENDPUSH_ONCE : '@endPushOnce';
D_PROPS : '@props'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_LANG : '@lang'->pushMode(LOOK_FOR_BLADE_PARAMETERS);

//forms
D_CSRF  : '@csrf';
D_METHOD : '@method'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_ERROR : '@error'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_ENDERROR : '@enderror';

//env
D_PRODUCTION : '@production';
D_ENDPRODUCTION : '@endproduction';
D_ENV : '@env'->pushMode(LOOK_FOR_BLADE_PARAMETERS);
D_ENDENV : '@endenv';

//auth and roles
D_AUTH_START : ('@auth' | '@guest')->pushMode(LOOK_FOR_BLADE_PARAMETERS);
D_AUTH_END : ('@endauth' | '@endguest');

//styles, attributes
D_CLASS : '@class'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_STYLE : '@style'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_HTML_ATTR_EXPR : ('@checked' | '@disabled' | '@readonly' | '@required' | '@selected')->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_AWARE : '@aware'->pushMode(LOOK_FOR_PHP_EXPRESSION);

D_JSON  : '@json'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_DD : '@dd'->pushMode(LOOK_FOR_PHP_EXPRESSION);

//php injection
D_USE : '@use'->pushMode(LOOK_FOR_BLADE_PARAMETERS);
D_INJECT : '@inject'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_PHP_SHORT : '@php' (' ')? {this._input.LA(1) == '('}? ->type(D_PHP),pushMode(LOOK_FOR_PHP_COMPOSED_EXPRESSION);
D_PHP : '@php' {this._input.LA(1) == ' ' || this._input.LA(1) == '\n'}?->pushMode(BLADE_INLINE_PHP);

D_VERBATIM : '@verbatim' ->pushMode(VERBATIM_MODE);
D_ENDVERBATIM : '@endverbatim';

//we will decide that a custom directive has expression to avoid email matching
D_CUSTOM : ('@' NameString {this._input.LA(1) == '(' || 
        (this._input.LA(1) == ' ' && this._input.LA(2) == '(')}? ) ->pushMode(LOOK_FOR_BLADE_PARAMETERS);

D_UNKNOWN : '@' NameString->type(HTML);
//display
ESCAPED_ECHO_START : '{{' ->pushMode(ESCAPED_ECHO);
NE_ECHO_START : '{!!' ->pushMode(NE_ECHO);

AT : '@';

PHP_INLINE_START : ('<?php' | '<?=')->pushMode(INSIDE_PHP_INLINE);

HTML_CLOSE_TAG : '<' '/'?  NameString '>'->type(HTML); 
HTML : ~[<?@{!]+;

OTHER : . ->type(HTML);

/**
* MODES
*
*/

mode ESCAPED_ECHO;

ESCAPED_ECHO_PHP_VAR : PhpVariable->type(PHP_VARIABLE);
ESCAPED_ECHO_KEYWORD : PhpKeyword->type(PHP_KEYWORD);
ESCAPED_ECHO_PHP_IDENTIFIER : NameString->type(PHP_IDENTIFIER);
ESCAPED_ECHO_STATIC_ACCESS : '::'->type(PHP_STATIC_ACCESS);
ESCAPED_ECHO_END : ('}}')->popMode;
ESCAPED_ECHO_LPAREN : '(' ->type(BLADE_EXPR_LPAREN);
ESCAPED_ECHO_RPAREN : ')' ->type(BLADE_EXPR_RPAREN);
ESCAPED_ECHO_EXPR_MORE : . ->type(PHP_EXPRESSION);
EXIT_ESCAPED_ECHO_EOF : EOF->type(ERROR),popMode;

//not escaped blade echo
mode NE_ECHO;

NE_ECHO_PHP_VAR : PhpVariable->type(PHP_VARIABLE);
NE_ECHO_KEYWORD : PhpKeyword->type(PHP_KEYWORD);
NE_ECHO_PHP_IDENTIFIER : NameString->type(PHP_IDENTIFIER);
NE_ECHO_STATIC_ACCESS : '::'->type(PHP_STATIC_ACCESS);
NE_ECHO_END : ('!!}')->popMode;
NE_ECHO_LPAREN : '(' ->type(BLADE_EXPR_LPAREN);
NE_ECHO_RPAREN : ')' ->type(BLADE_EXPR_RPAREN);
NE_ECHO_EXPR_MORE : . ->type(PHP_EXPRESSION);
EXIT_NE_ECHO_EOF : EOF->type(ERROR),popMode;

mode LOOK_FOR_PHP_EXPRESSION;

WS_EXPR : [ ]+->skip;
OPEN_EXPR_PAREN_MORE : '(' ->more,pushMode(INSIDE_PHP_EXPRESSION);

L_OTHER : . ->type(HTML), popMode;

//{{}}, @if, @foreach
mode INSIDE_PHP_EXPRESSION;

OPEN_EXPR_PAREN : {this.roundParenBalance == 0}? '(' {this.increaseRoundParenBalance();} ->more;
CLOSE_EXPR_PAREN : {this.roundParenBalance == 1}? ')' 
    {this.decreaseRoundParenBalance();}->type(PHP_EXPRESSION),mode(DEFAULT_MODE);

LPAREN : {this.roundParenBalance > 0}? '(' {this.increaseRoundParenBalance();}->more;
RPAREN : {this.roundParenBalance > 0}? ')' {this.decreaseRoundParenBalance();}->more;

//in case of lexer restart context
EXIT_RPAREN : ')' {this.roundParenBalance == 0}?->type(PHP_EXPRESSION),mode(DEFAULT_MODE);

PHP_EXPRESSION_MORE : . ->more;

EXIT_EOF : EOF->type(ERROR),popMode;

//@if
mode LOOK_FOR_PHP_COMPOSED_EXPRESSION;

WS_COMPOSED_EXPR : [ ]+->skip;
BLADE_EXPR_LPAREN : '(' {this.roundParenBalance = 0;} ->pushMode(INSIDE_PHP_COMPOSED_EXPRESSION);

L_COMPOSED_EXPR_OTHER : . ->type(HTML), popMode;

//{{}}, @if, @foreach
mode INSIDE_PHP_COMPOSED_EXPRESSION;

EXPR_SQ_LPAREN : '[' {this.squareParenBalance++;}->type(PHP_EXPRESSION);
EXPR_SQ_RPAREN : ']' {this.squareParenBalance--;}->type(PHP_EXPRESSION);

EXPR_CURLY_LPAREN : '{' {this.curlyParenBalance++;}->type(PHP_EXPRESSION);
EXPR_CURLY_RPAREN : '}' {this.curlyParenBalance--;}->type(PHP_EXPRESSION);

EXPR_STRING : DOUBLE_QUOTED_STRING_FRAGMENT | SINGLE_QUOTED_STRING_FRAGMENT;

//EXPR_ASSIGN : '=>'->type(BL_PARAM_ASSIGN);

COMPOSED_EXPR_PHP_VAR : PhpVariable->type(PHP_VARIABLE);
COMPOSED_PHP_KEYWORD : PhpKeyword->type(PHP_KEYWORD);
COMPOSED_EXPR_PHP_IDENTIFIER : NameString->type(PHP_IDENTIFIER);
COMPOSED_EXPR_STATIC_ACCESS : '::'->type(PHP_STATIC_ACCESS);

COMPOSED_EXPR_LPAREN : '(' {this.increaseRoundParenBalance();}->type(BLADE_EXPR_LPAREN);
COMPOSED_EXPR_RPAREN : ')' {consumeExprRParen();};

PHP_COMPOSED_EXPRESSION : . ->type(PHP_EXPRESSION);

EXIT_COMPOSED_EXPRESSION_EOF : EOF->type(ERROR),popMode;

//@section, @include etc
mode LOOK_FOR_BLADE_PARAMETERS;

WS_BL_PARAM : [ ]+->skip;
OPEN_BL_PARAM_PAREN_MORE : '(' {this.roundParenBalance = 0;} ->type(BLADE_PARAM_LPAREN),pushMode(INSIDE_BLADE_PARAMETERS);

L_BL_PARAM_OTHER : . ->type(HTML), popMode;

mode FOREACH_LOOP_EXPRESSION;

FOREACH_WS_EXPR : [ ]+->skip;
FOREACH_LOOP_LPAREN : '(' {this.increaseRoundParenBalance();};
FOREACH_LOOP_RPAREN : ')' {this.decreaseRoundParenBalance(); if (this.roundParenBalance == 0){this.popMode();}};

FOREACH_AS : 'as';

FOREACH_PHP_VARIABLE : PhpVariable->type(PHP_VARIABLE);

FOREACH_PARAM_ASSIGN : '=>';

LOOP_PHP_EXPRESSION : . ->type(PHP_EXPRESSION);
FOREACH_EOF : EOF->type(ERROR),popMode;
//( )
mode INSIDE_BLADE_PARAMETERS;

BL_PARAM_LINE_COMMENT : LineComment->channel(COMMENT);

BL_SQ_LPAREN : '[' {this.squareParenBalance++;};
BL_SQ_RPAREN : ']' {this.squareParenBalance--;};

BL_CURLY_LPAREN : '{' {this.curlyParenBalance++;}->type(BLADE_PARAM_EXTRA);
BL_CURLY_RPAREN : '}' {this.curlyParenBalance--;}->type(BLADE_PARAM_EXTRA);

BL_PARAM_LPAREN : '(' {this.increaseRoundParenBalance();}->type(BLADE_PARAM_EXTRA);
BL_PARAM_RPAREN : ')' {consumeParamRParen();};

BL_PARAM_STRING : DOUBLE_QUOTED_STRING_FRAGMENT | SINGLE_QUOTED_STRING_FRAGMENT;

BL_PARAM_PHP_VARIABLE : PhpVariable->type(PHP_VARIABLE);

BL_PARAM_ASSIGN : '=>';

BL_PARAM_PHP_KEYWORD : PhpKeyword->type(PHP_KEYWORD);

BL_PARAM_CONCAT_OPERATOR : '.';

BL_COMMA_EL : ','  {this.consumeBladeParamComma();};

BL_PARAM_WS : [ \t\r\n]+;

BL_NAME_STRING : NameString;

BL_PARAM_MORE : . ->type(BLADE_PARAM_EXTRA);

BL_PARAM_EXIT_EOF : EOF->type(ERROR),popMode;

//@php @endphp
mode BLADE_INLINE_PHP;

D_ENDPHP : '@endphp'->popMode;

//hack to merge all php inputs into one token
PHP_D_EXPR_SQ_LPAREN : '[' ->type(PHP_EXPRESSION);
PHP_D_EXPR_SQ_RPAREN : ']' ->type(PHP_EXPRESSION);

PHP_D_EXPR_CURLY_LPAREN : '{' ->type(PHP_EXPRESSION);
PHP_D_EXPR_CURLY_RPAREN : '}' ->type(PHP_EXPRESSION);

PHP_D_EXPR_STRING : DOUBLE_QUOTED_STRING_FRAGMENT | SINGLE_QUOTED_STRING_FRAGMENT;

//EXPR_ASSIGN : '=>'->type(BL_PARAM_ASSIGN);

PHP_D_COMPOSED_EXPR_PHP_VAR : PhpVariable->type(PHP_VARIABLE);
PHP_D_COMPOSED_PHP_KEYWORD : PhpKeyword->type(PHP_KEYWORD);
PHP_D_COMPOSED_EXPR_PHP_IDENTIFIER : NameString->type(PHP_IDENTIFIER);
PHP_D_COMPOSED_EXPR_STATIC_ACCESS : '::'->type(PHP_STATIC_ACCESS);

PHP_D_COMPOSED_EXPR_LPAREN : '('->type(BLADE_EXPR_LPAREN);
PHP_D_COMPOSED_EXPR_RPAREN : ')' ->type(BLADE_EXPR_RPAREN);

PHP_D_PHP_COMPOSED_EXPRESSION : . ->type(PHP_EXPRESSION);

PHP_D_EXIT_COMPOSED_EXPRESSION_EOF : EOF->type(ERROR),popMode;

//php inline <?php ?>
mode INSIDE_PHP_INLINE;

PHP_EXIT : '?>'->popMode;

//hack to merge all php inputs into one token
PHP_EXPR_SQ_LPAREN : '[' ->type(PHP_EXPRESSION);
PHP_EXPR_SQ_RPAREN : ']' ->type(PHP_EXPRESSION);

PHP_EXPR_CURLY_LPAREN : '{' ->type(PHP_EXPRESSION);
PHP_EXPR_CURLY_RPAREN : '}' ->type(PHP_EXPRESSION);

PHP_EXPR_STRING : DOUBLE_QUOTED_STRING_FRAGMENT | SINGLE_QUOTED_STRING_FRAGMENT;

//EXPR_ASSIGN : '=>'->type(BL_PARAM_ASSIGN);

PHP_COMPOSED_EXPR_PHP_VAR : PhpVariable->type(PHP_VARIABLE);
PHP_COMPOSED_PHP_KEYWORD : PhpKeyword->type(PHP_KEYWORD);
PHP_COMPOSED_EXPR_PHP_IDENTIFIER : NameString->type(PHP_IDENTIFIER);
PHP_COMPOSED_EXPR_STATIC_ACCESS : '::'->type(PHP_STATIC_ACCESS);

PHP_COMPOSED_EXPR_LPAREN : '('->type(BLADE_EXPR_LPAREN);
PHP_COMPOSED_EXPR_RPAREN : ')' ->type(BLADE_EXPR_RPAREN);

PHP_PHP_COMPOSED_EXPRESSION : . ->type(PHP_EXPRESSION);

PHP_EXIT_COMPOSED_EXPRESSION_EOF : EOF->type(PHP_EXPRESSION),popMode;

mode VERBATIM_MODE;

D_ENDVERBATIM_IN_MODE : '@endverbatim'->type(D_ENDVERBATIM), mode(DEFAULT_MODE);

//hack to merge all php inputs into one token
VERBATIM_HTML : . {
        this._input.LA(1) == '@' &&
        this._input.LA(2) == 'e' &&
        this._input.LA(3) == 'n' &&
        this._input.LA(4) == 'd' &&
        this._input.LA(5) == 'v' &&
        this._input.LA(6) == 'e' &&
        this._input.LA(7) == 'r'
      }? ->type(HTML);
VERBATIM_HTML_MORE : . ->more;

EXIT_VERBATIM_MOD_EOF : EOF->type(ERROR),mode(DEFAULT_MODE);
