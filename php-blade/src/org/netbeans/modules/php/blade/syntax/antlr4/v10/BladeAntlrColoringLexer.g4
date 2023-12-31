lexer grammar BladeAntlrColoringLexer;
import BladeCommonLexer;

@header{
  package org.netbeans.modules.php.blade.syntax.antlr4.v10;
}

options { superClass = LexerAdaptor; }

channels {PHP_CODE}

tokens {
 DIRECTIVE,
 PHP_EXPRESSION,
 BLADE_PHP_ECHO_EXPR,
 HTML,
 ERROR
}

fragment
NEKUDO_WHITELIST_MATCH : '::' | '?:' | ' : ';

//conditionals
D_IF : '@if'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ELSEIF : '@elseif'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ELSE : '@else'->type(DIRECTIVE);
D_ENDIF : '@endif'->type(DIRECTIVE);
D_SWITCH : '@switch'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_CASE : '@case'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ENDSWITCH : '@endswitch'->type(DIRECTIVE);
D_UNLESS : '@unless'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ENDUNLESS : '@endunless'->type(DIRECTIVE);

//loops
D_EACH : '@each'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_FOREACH : '@foreach'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ENDFOREACH : '@endforeach'->type(DIRECTIVE);
D_FOR : '@for'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ENDFOR : '@endfor'->type(DIRECTIVE);
D_FORELSE : '@forelse'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ENDFORELSE : '@endforelse'->type(DIRECTIVE);
D_WHILE : '@while'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ENDWHILE : '@endwhile'->type(DIRECTIVE);
D_CONTINUE : '@continue'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_BREAK : '@break'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);

//includes
D_INCLUDE : '@include'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_INCLUDE_IF : '@includeIf'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_INCLUDE_WHEN : '@includeWhen'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_INCLUDE_FIRST : '@includeFirst'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_INCLUDE_UNLESS : '@includeUnless'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);

//layout
D_EXTENDS : '@extends'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_JS : '@js'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_SECTION : '@section'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_HAS_SECTION : '@hasSection'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_SECTION_MISSING : '@sectionMissing'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ENDSECTION : '@endsection'->type(DIRECTIVE);
D_YIELD : '@yield'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_PARENT : '@parent'->type(DIRECTIVE);
D_SHOW : '@show'->type(DIRECTIVE);
D_OVERWRITE : '@overwrite'->type(DIRECTIVE);
D_ONCE : '@once'->type(DIRECTIVE);
D_ENDONCE : '@endonce'->type(DIRECTIVE);
D_PUSH : '@push'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ENDPUSH : '@endpush'->type(DIRECTIVE);
D_PUSH_ONCE : '@pushOnce'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ENDPUSH_ONCE : '@endPushOnce';
D_PROPS : '@props'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);

//forms
D_METHOD : '@method'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ERROR : '@error'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ENDERROR : '@enderror'->type(DIRECTIVE);

//env
D_PRODUCTION : '@production'->type(DIRECTIVE);
D_ENDPRODUCTION : '@endproduction'->type(DIRECTIVE);

//styles, attributes
D_CLASS : '@class'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_STYLE : '@style'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_AWARE : '@aware'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);

//misc
D_EMPTY : '@empty'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ENDEMPTY : '@endempty'->type(DIRECTIVE);
D_JSON  : '@json'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_INJECT : '@inject'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_DD : '@dd'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);

D_PHP : '@php'->pushMode(BLADE_INLINE_PHP);

D_VERBATIM : '@verbatim' ->pushMode(VERBATIM_MODE), type(DIRECTIVE);
D_ENDVERBATIM : '@endverbatim'->type(DIRECTIVE);

//starting the optimisation
//D_WITH_EXPR: ''
//lazy end match
D_WITH_EXPR : ('@break' | '@continue' | '@selected' | '@disabled' | '@readonly' |
               '@required')->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_SIMPLE : ('@stop' | '@csrf' | '@default')->type(DIRECTIVE);
D_END : ('@end' NameString) ->type(DIRECTIVE);

//we will decide that a custom directive has expression to avoid email matching
D_CUSTOM : ('@' NameString {this._input.LA(1) == '(' || 
        (this._input.LA(1) == ' ' && this._input.LA(2) == '(')}? ) ->pushMode(LOOK_FOR_PHP_EXPRESSION);

//display
ESCAPED_ECHO_START : '{{' ->pushMode(ESCAPED_ECHO);
NE_ECHO_START : '{!!' ->pushMode(NE_ECHO);

//might not be necessary
STYLE_OPEN : '<style' .*? '>'->type(HTML);
STYLE_CLOSE : '</style>'->type(HTML);
SCRIPT_OPEN : '<script' .*? '>'->type(HTML);
SCRIPT_CLOSE : '</script>'->type(HTML);

HTML_CLOSE_TAG : '<' '/'?  NameString '>'->type(HTML); 

//hack for the last unclosed tags
UNCLOSED_TAG : '<' NameString [\r\n]+; 

LAST_NL : [\r\n]+ EOF; 

HTML : ~[<?@{!]+;

OTHER : . ->type(HTML);

// {{  }}
mode ESCAPED_ECHO;

ESCAPED_ECHO_END : ('}}')->popMode;
//hack due to a netbeans php embedding issue when adding or deleting ':' chars
ECHO_DOUBLE_NEKODU : NEKUDO_WHITELIST_MATCH ->more;
ECHO_STRING_LITERAL : (SINGLE_QUOTED_STRING_FRAGMENT)->more;
ECHO_PHP_FREEZE_SYNTAX : ':' ->skip;

GREEDY_ESCAPED_ECHO_EXPR_END : ~[ ':{}]+ {
        this._input.LA(1) == '}' &&
        this._input.LA(2) == '}' }?->type(BLADE_PHP_ECHO_EXPR);

ESCAPED_ECHO_EXPR : ~[ ':{}]+ ->more;

ESCAPED_ECHO_EXPR_END : . [ ]* {
        this._input.LA(1) == '}' &&
        this._input.LA(2) == '}' }? ->type(BLADE_PHP_ECHO_EXPR);

ESCAPED_ECHO_EXPR_MORE : . ->more;
EXIT_ESCAPED_ECHO_EOF : EOF->type(ERROR),popMode;

// {!!  !!}
mode NE_ECHO;

NE_ECHO_END : ('!!}')->popMode;
//hack due to a netbeans php embedding issue when adding or deleting ':' chars
NE_ECHO_DOUBLE_NEKODU : NEKUDO_WHITELIST_MATCH ->more;
NE_STRING_LITERAL : (SINGLE_QUOTED_STRING_FRAGMENT)->more;
NE_ECHO_PHP_FREEZE_SYNTAX : ':' ->skip;
NE_ECHO_EXPR : ~[ ':!{}]+ ->more;
NE_ECHO_EXPR_END : . [ ]* {
        this._input.LA(1) == '!' &&
        this._input.LA(2) == '!' &&
        this._input.LA(3) == '}'
    }? ->type(BLADE_PHP_ECHO_EXPR);
NE_ECHO_EXPR_MORE : . ->more;
EXIT_NE_ECHO_EOF : EOF->type(ERROR),popMode;

// @directive ()?
mode LOOK_FOR_PHP_EXPRESSION;

WS_EXPR : [ ]+ {this._input.LA(1) == '('}? ->pushMode(INSIDE_PHP_EXPRESSION);
OPEN_EXPR_PAREN_MORE : '(' {this.increaseRoundParenBalance();} ->more,pushMode(INSIDE_PHP_EXPRESSION);

L_OTHER : . ->type(HTML), popMode;

// @directive (?)
mode INSIDE_PHP_EXPRESSION;

OPEN_EXPR_PAREN : {this.roundParenBalance == 0}? '(' {this.increaseRoundParenBalance();} ->more;
CLOSE_EXPR_PAREN : {this.roundParenBalance == 1}? ')' 
    {this.decreaseRoundParenBalance();}->type(PHP_EXPRESSION),mode(DEFAULT_MODE);

LPAREN : {this.roundParenBalance > 0}? '(' {this.increaseRoundParenBalance();}->more;
RPAREN : {this.roundParenBalance > 0}? ')' {this.decreaseRoundParenBalance();}->more;

//in case of lexer restart context
EXIT_RPAREN : ')' {this.roundParenBalance == 0}?->type(PHP_EXPRESSION),mode(DEFAULT_MODE);

//hack due to a netbeans php embedding issue when adding or deleting ':' chars
DOUBLE_NEKODU : NEKUDO_WHITELIST_MATCH ->more;

//no string interpolation for the moment
//freeze issue
EXPR_STRING_LITERAL : (SINGLE_QUOTED_STRING_FRAGMENT)->more;

PHP_FREEZE_SYNTAX : ':' ->skip;

PHP_EXPRESSION_MORE : . ->more;

EXIT_EOF : EOF->type(ERROR),popMode;

// @php
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
      }?->channel(PHP_CODE) ;
BLADE_PHP_INLINE_MORE : . ->more;

EXIT_INLINE_PHP_EOF : EOF->type(ERROR),popMode;

// @verbatim
mode VERBATIM_MODE;

D_ENDVERBATIM_IN_MODE : '@endverbatim'->type(DIRECTIVE), popMode;

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

EXIT_VERBATIM_MOD_EOF : EOF->type(ERROR),popMode;
