parser grammar BladeAntlrParser;

@header{
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
    extends
    | section_inline
    | yield
    | include
    | (D_CLASS | D_STYLE) php_expression
    | (D_CHECKED | D_SELECTED | D_READONLY | D_REQUIRED) php_expression
    | echo
    | echo_ne
    | custom_directive
    | PHP_INLINE
    ;


block_statement: 
    section
    | hasSection
    | if
    | elseif
    | else
    | while
    | foreach
    | verbatim_block
    | php_blade
    ;

non_blade_statement:
    html
    ;


extends : D_EXTENDS blade_params_expression;
section_inline: D_SECTION bl_sg_default_param;
section : D_SECTION bl_sg_default_param general_statement* D_ENDSECTION;

if : D_IF php_expression general_statement* D_ENDIF? ~(D_IF | D_ELSEIF | D_ELSE);
elseif : D_ELSEIF php_expression general_statement* D_ENDIF? ~(D_IF | D_ELSEIF | D_ELSE);
else : D_ELSE general_statement* D_ENDIF? ~(D_IF | D_ELSEIF | D_ELSE);

//loops
while : D_WHILE php_expression general_statement* D_ENDWHILE;
foreach : D_FOREACH php_expression general_statement* D_ENDFOREACH;

//layout
yield : D_YIELD bl_sg_default_param;
include : D_INCLUDE blade_params_expression;
hasSection : D_HAS_SECTION bl_sg_param general_statement* D_ENDIF;

custom_directive : D_CUSTOM blade_params_expression;
    
php_blade : D_PHP BLADE_PHP_INLINE D_ENDPHP;

//echo

echo : ESCAPED_ECHO_START BLADE_PHP_ECHO_EXPR ESCAPED_ECHO_END;
echo_ne : NE_ECHO_START BLADE_PHP_ECHO_EXPR NE_ECHO_END;

php_expression: WS_EXPR? PHP_EXPRESSION;

bl_sg_param :BLADE_PARAM_LPAREN BL_PARAM_WS* blade_parameter default_blade_param_expression? BL_PARAM_WS* BLADE_PARAM_RPAREN
;

bl_sg_default_param :BLADE_PARAM_LPAREN BL_PARAM_WS* blade_parameter default_blade_param_expression?  BL_PARAM_WS* BLADE_PARAM_RPAREN
;

default_blade_param_expression :
BL_PARAM_WS* BL_PARAM_COMMA BL_PARAM_WS* blade_parameter;
    
blade_params_expression :BLADE_PARAM_LPAREN BL_PARAM_WS* (blade_parameter BL_PARAM_WS* BL_PARAM_COMMA? BL_PARAM_WS*)+ BL_PARAM_WS* BLADE_PARAM_RPAREN
;

blade_parameter :  BL_PARAM_STRING 
| (BLADE_PARAM_EXTRA | BL_PARAM_PHP_VARIABLE | BL_PARAM_WS | BL_PARAM_CONCAT_OPERATOR | BL_PARAM_STRING | BL_NAME_STRING | BL_COMMA)+ ;

verbatim_block : D_VERBATIM non_blade_statement+ D_ENDVERBATIM;

//html
html : HTML+;
