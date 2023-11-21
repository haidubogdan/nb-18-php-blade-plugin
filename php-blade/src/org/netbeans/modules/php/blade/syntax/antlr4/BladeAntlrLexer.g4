lexer grammar BladeAntlrLexer;

@header{
  package org.netbeans.modules.php.blade.syntax.antlr4;
}

options { superClass = LexerAdaptor; }
 
tokens { TOKEN_REF,
 RULE_REF,
 LEXER_CHAR_SET,
 PHP_EXPRESSION,
 BLADE_PHP_ECHO_EXPR,
 ERROR
}

fragment
NameString : [a-zA-Z_\u0080-\ufffe][a-zA-Z0-9_\u0080-\ufffe]*;    
    
BLADE_COMMENT : '{{--' .*? '--}}';

PHP_INLINE : '<?=' .*? '?>' | '<?php' .*? '?>';

EMAIL_SUBSTRING : ('@' NameString '.')->type(HTML);

//escapes
D_ESCAPES 
    : (
      '@@'
    | '@media'
    | '@layer'
    | '@tailwind'
    | '@apply' 
    | '@-webkit-keyframes' 
    | '@keyframes'
    )->type(HTML);

//conditionals
D_IF : '@if'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_ELSEIF : '@elseif'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_ELSE : '@else';
D_ENDIF : '@endif';
D_SWITCH : '@switch'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_CASE : '@case'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_ENDSWITCH : '@endswitch';

//loops
D_EACH : '@each'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_FOREACH : '@foreach'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_ENDFOREACH : '@endforeach';
D_FOR : '@for'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_ENDFOR : '@endfor';
D_FORELSE : '@forelse'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_ENDFORELSE : '@endforelse';
D_WHILE : '@while'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_ENDWHILE : '@endwhile';
D_CONTINUE : '@continue'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_BREAK : '@break'->pushMode(LOOK_FOR_PHP_EXPRESSION);

//includes
D_INCLUDE : '@include'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_INCLUDE_IF : '@includeIf'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_INCLUDE_WHEN : '@includeWhen'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_INCLUDE_FIRST : '@includeFirst'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_INCLUDE_UNLESS : '@includeUnless'->pushMode(LOOK_FOR_PHP_EXPRESSION);

//layout
D_EXTENDS : '@extends'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_JS : '@js'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_SECTION : '@section'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_HAS_SECTION : '@hasSection'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_SECTION_MISSING : '@sectionMissing'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_ENDSECTION : '@endsection';
D_YIELD : '@yield'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_PARENT : '@parent';
D_SHOW : '@show';
D_OVERWRITE : '@overwrite';
D_STOP : '@stop';
D_ONCE : '@once';
D_ENDONCE : '@endonce';
D_PUSH : '@push'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_ENDPUSH : '@endpush';
D_PUSH_ONCE : '@pushOnce'->pushMode(LOOK_FOR_PHP_EXPRESSION);
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

//styles, attributes
D_CLASS : '@class'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_STYLE : '@style'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_SELECTED : '@selected'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_DISABLED : '@disabled'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_READONLY : '@readonly'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_REQUIRED : '@required'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_AWARE : '@aware'->pushMode(LOOK_FOR_PHP_EXPRESSION);

//misc
D_EMPTY : '@empty'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_ENDEMPTY : '@endempty';
D_JSON  : '@json'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_INJECT : '@inject'->pushMode(LOOK_FOR_PHP_EXPRESSION);
D_DD : '@dd'->pushMode(LOOK_FOR_PHP_EXPRESSION);

D_PHP : '@php'->pushMode(BLADE_INLINE_PHP);

//todo all content between verbatim and verbatim should be rendered as html
D_VERBATIM : '@verbatim';
D_ENDVERBATIM : '@endverbatim';

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

WS_EXPR : [ ]+ {this._input.LA(1) == '('}? ->pushMode(INSIDE_PHP_EXPRESSION);
OPEN_EXPR_PAREN_MORE : '(' ->more,pushMode(INSIDE_PHP_EXPRESSION);

L_OTHER : . ->type(HTML), popMode;

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
