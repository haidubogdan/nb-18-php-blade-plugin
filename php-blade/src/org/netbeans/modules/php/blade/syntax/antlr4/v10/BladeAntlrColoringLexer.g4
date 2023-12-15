lexer grammar BladeAntlrColoringLexer;

@header{
  package org.netbeans.modules.php.blade.syntax.antlr4.v10;
}

options { superClass = LexerAdaptor; }

channels {PHP_CODE}

tokens { TOKEN_REF,
 RULE_REF,
 LEXER_CHAR_SET,
 DIRECTIVE,
 PHP_EXPRESSION,
 BLADE_PHP_ECHO_EXPR,
 ERROR
}

fragment
NameString : [a-zA-Z_\u0080-\ufffe][a-zA-Z0-9_\u0080-\ufffe]*;    

fragment ESC_DOUBLE_QUOTED_STRING 
    : [\\"];

fragment DOUBLE_QUOTED_STRING_FRAGMENT 
    : '"' (ESC_DOUBLE_QUOTED_STRING | . )*? '"';

fragment SINGLE_QUOTED_STRING_FRAGMENT 
    : '\'' (~('\'' | '\\') | '\\' . )* '\'';
  
fragment
NEKUDO_WHITELIST_MATCH : '::' | '?:' | ' : ';

fragment Digit
    : ('0'..'9');

BLADE_COMMENT : '{{--' .*? '--}}';

PHP_INLINE : '<?=' .*? '?>' | '<?php' .*? '?>';

EMAIL_SUBSTRING : ('@' NameString '.')->type(HTML);

VERSION_WITH_AT: '@' (Digit '.')+->type(HTML); 

//escapes
D_ESCAPES 
    : (
      '@@'
    | '@media'
    | '@charset'
    | '@import'
    | '@namespace'
    | '@document'
    | '@font-face'
    | '@page'
    | '@supports'
    | '@layer'
    | '@tailwind'
    | '@apply' 
    | '@-webkit-keyframes' 
    | '@keyframes'
    )->type(HTML);

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

D_VERBATIM : '@verbatim' ->pushMode(VERBATIM_MODE);
D_ENDVERBATIM : '@endverbatim';

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
ESCAPE_ECHO : '@{' ->type(HTML);
ESCAPED_ECHO_START : '{{' ->pushMode(ESCAPED_ECHO);
NE_ECHO_START : '{!!' ->pushMode(NE_ECHO);

HTML : ~[<?@{!]+;

OTHER : . ->type(HTML);

mode ESCAPED_ECHO;

ESCAPED_ECHO_END : ('}}')->popMode;
//hack due to a netbeans php embedding issue when adding or deleting ':' chars
ECHO_DOUBLE_NEKODU : NEKUDO_WHITELIST_MATCH ->more;
ECHO_PHP_FREEZE_SYNTAX : ':' ->type(ERROR);
ESCAPED_ECHO_EXPR : ~[:{}]+ ->type(BLADE_PHP_ECHO_EXPR);
ESCAPED_ECHO_EXPR_MORE : . ->more;
EXIT_ESCAPED_ECHO_EOF : EOF->type(ERROR),popMode;

//not escaped blade echo
mode NE_ECHO;

NE_ECHO_END : ('!!}')->popMode;
//hack due to a netbeans php embedding issue when adding or deleting ':' chars
NE_ECHO_DOUBLE_NEKODU : NEKUDO_WHITELIST_MATCH ->more;
NE_ECHO_PHP_FREEZE_SYNTAX : ':' ->type(ERROR);
NE_ECHO_EXPR : ~[:!{}]+ ->type(BLADE_PHP_ECHO_EXPR);
NE_ECHO_EXPR_MORE : . ->more;
EXIT_NE_ECHO_EOF : EOF->type(ERROR),popMode;

mode LOOK_FOR_PHP_EXPRESSION;

WS_EXPR : [ ]+ {this._input.LA(1) == '('}? ->pushMode(INSIDE_PHP_EXPRESSION);
OPEN_EXPR_PAREN_MORE : '(' {this.increaseRoundParenBalance();} ->more,pushMode(INSIDE_PHP_EXPRESSION);

L_OTHER : . ->type(HTML), popMode;

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

PHP_FREEZE_SYNTAX : ':' ->type(ERROR);

PHP_EXPRESSION_MORE : . ->more;

EXIT_EOF : EOF->type(ERROR),popMode;

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

mode VERBATIM_MODE;

D_ENDVERBATIM_IN_MODE : '@endverbatim'->type(D_ENDVERBATIM), popMode;

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
