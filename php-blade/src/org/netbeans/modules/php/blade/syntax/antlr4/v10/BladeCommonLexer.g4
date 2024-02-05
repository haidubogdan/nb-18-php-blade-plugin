lexer grammar BladeCommonLexer;

tokens {
    HTML, 
    BLADE_COMMENT
}

fragment NameString 
    : [a-zA-Z_\u0080-\ufffe][a-zA-Z0-9_\u0080-\ufffe]*;    
   
fragment BladeLabel 
    : [a-zA-Z\u0080-\ufffe][a-zA-Z0-9_.\u0080-\ufffe]*;   

fragment FullIdentifier 
    : [a-zA-Z_\u0080-\ufffe][a-zA-Z0-9_\u0080-\ufffe-]*;    
 
fragment ESC_DOUBLE_QUOTED_STRING 
    : [\\"];

fragment DOUBLE_QUOTED_STRING_FRAGMENT 
    : '"' (ESC_DOUBLE_QUOTED_STRING | . )*? '"';

fragment SINGLE_QUOTED_STRING_FRAGMENT 
    : '\'' (~('\'' | '\\') | '\\' . )* '\'';

fragment LineComment
    : '//' ~ [\r\n]*
    ;

fragment PhpVariable
    : '$' NameString;

fragment PhpKeyword
    : 'array' | 'class' | 'empty';

fragment Digit
    : ('0'..'9');

BLADE_COMMENT_START : '{{--' ->pushMode(INSIDE_BLADE_COMMENT);

PHP_INLINE : '<?=' .*? '?>' | '<?php' .*? ('?>' | EOF);

EMAIL_SUBSTRING : ('@' FullIdentifier '.')->type(HTML);

VERSION_WITH_AT: '@' (Digit '.'?)+->type(HTML);

//escapes
D_ESCAPES 
    : (
      '@@' '@'?
    | '@{' '{'?
    | '@media' [ ]*
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

mode INSIDE_BLADE_COMMENT;

BLADE_COMMENT_END : '--}}'->popMode;

//hack to merge all php inputs into one token
BLADE_COMMENT_PEEK : . {
        this._input.LA(1) == '-' &&
        this._input.LA(2) == '-' &&
        this._input.LA(3) == '}' &&
        this._input.LA(4) == '}'
      }? ->type(BLADE_COMMENT);
BLADE_COMMENT_MORE : . ->more;

BLADE_COMMENT_EOF : EOF->type(BLADE_COMMENT),popMode;