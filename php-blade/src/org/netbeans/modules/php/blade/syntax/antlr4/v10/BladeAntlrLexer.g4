lexer grammar BladeAntlrLexer;
import BladeCommonLexer;

@header{
  package org.netbeans.modules.php.blade.syntax.antlr4.v10;
}

options { superClass = LexerAdaptor; }
 
tokens {
 PHP_EXPRESSION,
 PHP_VARIABLE,
 PHP_KEYWORD,
 BLADE_PARAM_EXTRA,
 BLADE_PARAM_LPAREN,
 BLADE_PARAM_RPAREN,
 BLADE_PHP_ECHO_EXPR,
 ERROR
}
 
channels { COMMENT, PHP_CODE }

//RULES


//conditionals
D_IF : '@if'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_ELSEIF : '@elseif'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_ELSE : '@else';
D_ENDIF : '@endif';
D_SWITCH : '@switch'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_CASE : '@case'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_DEFAULT : '@default';
D_ENDSWITCH : '@endswitch';

D_EMPTY : '@empty'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_ENDEMPTY : '@endempty';

D_COND_BLOCK_START : ('@unless' | '@isset')->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_COND_BLOCK_END : ('@endunless' | '@endisset');

//loops
D_FOREACH : '@foreach'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_ENDFOREACH : '@endforeach';
D_FOR : '@for'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_ENDFOR : '@endfor';
D_FORELSE : '@forelse'->pushMode(LOOK_FOR_PHP_EXPRESSION);
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
D_SECTION_MISSING : '@sectionMissing'->pushMode(LOOK_FOR_PHP_EXPRESSION);
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
D_PHP : '@php'->pushMode(BLADE_INLINE_PHP);

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

HTML_CLOSE_TAG : '<' '/'?  NameString '>'->type(HTML); 
HTML : ~[<?@{!]+;

OTHER : . ->type(HTML);

mode ESCAPED_ECHO;

ESCAPED_ECHO_END : ('}}')->popMode;
ESCAPED_ECHO_EXPR : ~[{}]+ ->type(BLADE_PHP_ECHO_EXPR);
ESCAPED_ECHO_EXPR_MORE : . ->more;
EXIT_ESCAPED_ECHO_EOF : EOF->type(ERROR),popMode;

//not escaped blade echo
mode NE_ECHO;

NE_ECHO_END : ('!!}')->popMode;
NE_ECHO_EXPR : ~[!{}]+ ->type(BLADE_PHP_ECHO_EXPR);
NE_ECHO_EXPR_MORE : . ->more;
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

//@section, @include etc
mode LOOK_FOR_BLADE_PARAMETERS;

WS_BL_PARAM : [ ]+->skip;
OPEN_BL_PARAM_PAREN_MORE : '(' ->type(BLADE_PARAM_LPAREN),pushMode(INSIDE_BLADE_PARAMETERS);

L_BL_PARAM_OTHER : . ->type(HTML), popMode;

//( )
mode INSIDE_BLADE_PARAMETERS;

BL_PARAM_LINE_COMMENT : LineComment->channel(COMMENT);

CLOSE_BL_PARAM_PAREN : {this.roundParenBalance <= 0}? ')' 
    {this.roundParenBalance = 0;}->type(BLADE_PARAM_RPAREN),mode(DEFAULT_MODE);

BL_PARAM_LPAREN : {this.roundParenBalance >= 0}? '(' {this.increaseRoundParenBalance();}->type(BLADE_PARAM_EXTRA);
BL_PARAM_RPAREN : {this.roundParenBalance > 0}? ')' {this.decreaseRoundParenBalance();}->type(BLADE_PARAM_EXTRA);

BL_SQ_LPAREN : '[' {this.squareParenBalance++;}->type(BLADE_PARAM_EXTRA);
BL_SQ_RPAREN : '[' {this.squareParenBalance--;}->type(BLADE_PARAM_EXTRA);

BL_CURLY_LPAREN : '{' {this.curlyParenBalance++;}->type(BLADE_PARAM_EXTRA);
BL_CURLY_RPAREN : '}' {this.curlyParenBalance--;}->type(BLADE_PARAM_EXTRA);

BL_PARAM_STRING : DOUBLE_QUOTED_STRING_FRAGMENT | SINGLE_QUOTED_STRING_FRAGMENT;

BL_PARAM_PHP_VARIABLE : PhpVariable->type(PHP_VARIABLE);

BL_PARAM_ASSIGN : '=>';

BL_PARAM_PHP_KEYWORD : PhpKeyword->type(PHP_KEYWORD);

BL_PARAM_CONCAT_OPERATOR : '.';

BL_PARAM_COMMA : {this.hasNoBladeParamOpenBracket()}? ',' ;

BL_COMMA : ',';

BL_PARAM_WS : [ \t\r\n]+;

BL_NAME_STRING : NameString;

BL_PARAM_MORE : . ->type(BLADE_PARAM_EXTRA);

BL_PARAM_EXIT_EOF : EOF->type(ERROR),popMode;

//@php @endphp
mode BLADE_INLINE_PHP;

D_ENDPHP : '@endphp'->popMode;

//hack to merge all php inputs into one token
BLADE_PHP_INLINE : . {
        this._input.LA(1) == '@' &&
        this._input.LA(2) == 'e' &&
        this._input.LA(3) == 'n' &&
        this._input.LA(4) == 'd' &&
        this._input.LA(5) == 'p' &&
        this._input.LA(6) == 'h' &&
        this._input.LA(7) == 'p'
      }? ;
BLADE_PHP_INLINE_MORE : . ->more;

EXIT_INLINE_PHP_EOF : EOF->type(ERROR),popMode; 

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
