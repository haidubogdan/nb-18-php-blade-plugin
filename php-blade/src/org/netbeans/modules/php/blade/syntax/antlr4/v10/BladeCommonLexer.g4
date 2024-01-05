lexer grammar BladeCommonLexer;

tokens {
    HTML
}

fragment NameString 
    : [a-zA-Z_\u0080-\ufffe][a-zA-Z0-9_\u0080-\ufffe]*;    
    
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
    : 'array' | 'class';

fragment Digit
    : ('0'..'9');

BLADE_COMMENT : '{{--' .*? '--}}';

PHP_INLINE : '<?=' .*? '?>' | '<?php' .*? ('?>' | EOF);

EMAIL_SUBSTRING : ('@' NameString '.')->type(HTML);

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