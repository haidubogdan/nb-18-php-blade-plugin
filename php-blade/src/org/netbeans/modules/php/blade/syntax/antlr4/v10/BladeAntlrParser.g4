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
    extends
    | section_inline
    | yield
    | include
    | (D_CLASS | D_STYLE) php_expression
    | D_HTML_ATTR_EXPR php_expression
    //using basic inline case statement to not add complexity to parser
    | D_CASE php_expression
    | D_DEFAULT
    | loop_action
    | echo
    | echo_ne
    | custom_directive
    | PHP_INLINE
    ;


block_statement: 
    section
    | hasSection
    | D_ONCE general_statement+ D_ENDONCE
    | if
    | elseif
    | else
    | switch
    | D_EMPTY php_expression general_statement+ D_ENDEMPTY
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
    ;

extends : D_EXTENDS blade_params_expression;
section_inline: D_SECTION bl_sg_default_param;
section : D_SECTION bl_sg_default_param general_statement* D_ENDSECTION;

if : D_IF php_expression general_statement* D_ENDIF? ~(D_IF | D_ELSEIF | D_ELSE);
elseif : D_ELSEIF php_expression general_statement* D_ENDIF? ~(D_IF | D_ELSEIF | D_ELSE);
else : D_ELSE general_statement* D_ENDIF? ~(D_IF | D_ELSEIF | D_ELSE);

//the consistency for these blocks need to be checked inside the parser
conditional_block : D_COND_BLOCK_START php_expression general_statement+ D_COND_BLOCK_END;
auth_block : D_AUTH_START bl_sg_param general_statement+ D_AUTH_END;

//no need to add complexity to parser
switch: D_SWITCH php_expression (general_statement | D_BREAK)+ D_ENDSWITCH;

//loops
while : D_WHILE php_expression (general_statement)+ D_ENDWHILE;
for : D_FOR php_expression (general_statement)+ D_ENDFOR;
foreach : D_FOREACH php_expression (general_statement)+ D_ENDFOREACH;
forelse : D_FORELSE php_expression (general_statement | D_EMPTY)+ D_ENDFORELSE;

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

bl_sg_param :BLADE_PARAM_LPAREN BL_PARAM_WS* blade_parameter BL_PARAM_WS* BLADE_PARAM_RPAREN
;

bl_sg_default_param :BLADE_PARAM_LPAREN BL_PARAM_WS* blade_parameter default_blade_param_expression?  BL_PARAM_WS* BLADE_PARAM_RPAREN
;

default_blade_param_expression :
BL_PARAM_WS* BL_PARAM_COMMA BL_PARAM_WS* blade_parameter;
    
blade_params_expression :BLADE_PARAM_LPAREN BL_PARAM_WS* (blade_parameter BL_PARAM_WS* BL_PARAM_COMMA? BL_PARAM_WS*)+ BL_PARAM_WS* BLADE_PARAM_RPAREN
;

blade_parameter :  BL_PARAM_STRING 
| (BLADE_PARAM_EXTRA | PHP_VARIABLE | BL_PARAM_WS | BL_PARAM_CONCAT_OPERATOR | BL_PARAM_STRING | BL_NAME_STRING | BL_COMMA)+ ;

verbatim_block : D_VERBATIM non_blade_statement+ D_ENDVERBATIM;

loop_action : (D_LOOP_ACTION | D_BREAK) php_expression?;


//html
html : HTML+;
