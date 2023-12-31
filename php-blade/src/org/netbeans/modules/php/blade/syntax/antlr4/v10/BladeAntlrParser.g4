parser grammar BladeAntlrParser;

@header{
  /**
   * Parser generated for netbeans blade editor
   * Some elements have been simplified to optimize parser speed
   * For example
   * - switch statement have a loos validation
   * - generic block statement "@isset" | "@unless" are grouped togehter
   * - the start match and end match will be checked in the parser
   */
  package org.netbeans.modules.php.blade.syntax.antlr4.v10;
}

options { tokenVocab = BladeAntlrLexer; }

file : general_statement* EOF;

general_statement: inline_statement
    | block_statement
    | BLADE_COMMENT
    | html
    ;

inline_statement: 
    inline_directive
    | echo
    | echo_ne
    | phpInline
    ;

inline_directive: 
    extends
    | section_inline
    | yieldD //yield identifier will be used by antlr
    | stack
    | include
    | includeIf
    | includeCond
    | includeFirst
    | each
    | (D_CLASS | D_STYLE) php_expression
    | (D_METHOD) php_expression
    | D_PROPS php_expression
    | D_CSRF
    | useD
    | D_INJECT doubleArgWrapper
    | D_HTML_ATTR_EXPR php_expression
    //using basic inline case statement to not add complexity to parser
    | D_CASE php_expression
    | D_DEFAULT
    | loop_action
    | custom_directive
    ;

block_statement: 
    section
    | hasSection
    | sectionMissing
    | push
    | D_ONCE general_statement+ D_ENDONCE
    | if
    | elseif
    | else
    | switch
    | D_ENV  singleArgWrapper general_statement+ D_ENDENV
    | D_PRODUCTION general_statement+ D_ENDPRODUCTION
    | D_EMPTY php_expression general_statement+ D_ENDEMPTY
    | D_ERROR php_expression general_statement+ D_ENDERROR
    //we can consider the statements not being empty
    | conditional_block
    | auth_block
    | while
    | for
    | foreach
    | forelse
    | verbatim_block
    | php_blade
    ;

non_blade_statement:
    html
    | phpInline
    ;

extends : D_EXTENDS singleArgWrapper;
section_inline: D_SECTION doubleArgWrapper;
section : D_SECTION singleArgWrapper (general_statement | D_PARENT)* (D_SHOW | D_STOP | D_OVERWRITE | D_ENDSECTION);
push : D_PUSH singleArgWrapper general_statement+ D_ENDPUSH;
pushOnce : D_PUSH_ONCE singleArgWrapper general_statement+ D_ENDPUSH_ONCE;

if : D_IF php_expression general_statement+ endif?;
elseif : D_ELSEIF php_expression general_statement+ endif?;
else : D_ELSE general_statement+ endif?;
endif: D_ENDIF;

//the consistency for these blocks need to be checked inside the parser
conditional_block : D_COND_BLOCK_START php_expression general_statement+ D_COND_BLOCK_END;
auth_block : D_AUTH_START singleArgWrapper* general_statement+ D_AUTH_END;

//no need to add complexity to parser
switch: D_SWITCH php_expression (general_statement | D_BREAK)+ D_ENDSWITCH;

//loops
while : D_WHILE php_expression (general_statement)+ D_ENDWHILE;
for : D_FOR php_expression (general_statement)+ D_ENDFOR;
foreach : D_FOREACH FOREACH_LOOP_LPAREN loop_expression FOREACH_LOOP_RPAREN (general_statement)+ D_ENDFOREACH;
forelse : D_FORELSE FOREACH_LOOP_LPAREN loop_expression FOREACH_LOOP_RPAREN (general_statement | D_EMPTY)+ D_ENDFORELSE;

//layout
yieldD : D_YIELD singleArgWrapper;
stack : D_STACK singleArgWrapper;
useD : D_USE singleArgWrapper;

include : D_INCLUDE singleArgAndDefaultWrapper;
includeIf : D_INCLUDE_IF singleArgAndDefaultWrapper;
includeCond : (D_INCLUDE_WHEN | D_INCLUDE_UNLESS) BLADE_PARAM_LPAREN
    composedArgument
    BL_COMMA
    (identifiableArgument | composedArgument)
    (BL_COMMA composedArgument)?
    BLADE_PARAM_RPAREN;

includeFirst : D_INCLUDE_FIRST singleArgAndDefaultWrapper;

each : D_EACH BLADE_PARAM_LPAREN 
    (identifiableArgument | composedArgument) //default path
    BL_COMMA
    composedArgument
    BL_COMMA
    composedArgument
    (BL_COMMA
    (identifiableArgument | composedArgument))? //fallback
    BLADE_PARAM_RPAREN;

hasSection : D_HAS_SECTION singleArgWrapper general_statement* D_ENDIF;
sectionMissing : D_SECTION_MISSING singleArgWrapper general_statement* D_ENDIF;

custom_directive : D_CUSTOM (multiArgWrapper 
| (BLADE_PARAM_LPAREN BLADE_PARAM_RPAREN));
    
php_blade : D_PHP BLADE_PHP_INLINE D_ENDPHP;

phpInline : PHP_INLINE;
//echo

echo : ESCAPED_ECHO_START echo_expr* ESCAPED_ECHO_END;
echo_ne : NE_ECHO_START echo_expr* NE_ECHO_END;

echo_expr : (BLADE_PHP_ECHO_EXPR | PHP_VARIABLE | PHP_IDENTIFIER | PHP_STATIC_ACCESS);

php_expression: PHP_EXPRESSION;
loop_expression : simple_foreach_expr
| (PHP_VARIABLE | PHP_EXPRESSION | FOREACH_PARAM_ASSIGN | FOREACH_LOOP_LPAREN | FOREACH_LOOP_RPAREN | FOREACH_AS)+ //complex expression (lazy handling)
;

simple_foreach_expr: loop_array=PHP_VARIABLE FOREACH_AS key=PHP_VARIABLE (FOREACH_PARAM_ASSIGN item=PHP_VARIABLE)?;

singleArgWrapper:  BLADE_PARAM_LPAREN (identifiableArgument | composedArgument) BLADE_PARAM_RPAREN;
singleArgAndDefaultWrapper:  BLADE_PARAM_LPAREN (identifiableArgument | composedArgument) (BL_COMMA composedArgument)? (BL_COMMA BL_PARAM_WS*)? BLADE_PARAM_RPAREN;
doubleArgWrapper:  BLADE_PARAM_LPAREN (identifiableArgument | composedArgument) BL_COMMA composedArgument BLADE_PARAM_RPAREN;
multiArgWrapper :  BLADE_PARAM_LPAREN (identifiableArgument | composedArgument) (BL_COMMA composedArgument)? BLADE_PARAM_RPAREN;

identifiableArgument : BL_PARAM_WS* BL_PARAM_STRING BL_PARAM_WS*;
composedArgument : BL_PARAM_WS* (phpExpr)+ BL_PARAM_WS*;

phpExpr : identifiableArray | arrayDefine | BLADE_PARAM_EXTRA | PHP_VARIABLE | PHP_KEYWORD |  BL_PARAM_WS | BL_PARAM_CONCAT_OPERATOR | BL_PARAM_STRING | BL_PARAM_ASSIGN | BL_NAME_STRING | BL_PARAM_COMMA;

//['key' => $value]
identifiableArray : BL_SQ_LPAREN paramAssign (BL_PARAM_COMMA paramAssign)* BL_PARAM_COMMA? BL_SQ_RPAREN;
arrayDefine : BL_SQ_LPAREN phpExpr+ BL_SQ_RPAREN
| BL_SQ_LPAREN BL_SQ_RPAREN;

paramAssign : BL_PARAM_STRING BL_PARAM_WS* BL_PARAM_ASSIGN BL_PARAM_WS* (PHP_VARIABLE | PHP_KEYWORD | BL_PARAM_STRING);
verbatim_block : D_VERBATIM non_blade_statement+ D_ENDVERBATIM;

loop_action : (D_LOOP_ACTION | D_BREAK) php_expression?;


//html
html : HTML+;
