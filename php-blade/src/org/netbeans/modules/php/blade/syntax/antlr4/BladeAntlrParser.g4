parser grammar BladeAntlrParser;

@header{
  package org.netbeans.modules.php.blade.syntax.antlr4;
}

options { tokenVocab = BladeAntlrLexer; }

file : general_statement* EOF;

general_statement: inline_statement
    | block_statement
    | html
;

inline_statement: 
  extends
| section_inline
| yield
| include
| custom_directive
| echo
| echo_ne
| verbatim_block    
| PHP_INLINE
;

extends : D_EXTENDS php_expression;


block_statement: 
  section
| if
| elseif   
| else    
| php_blade
;

non_blade_statement:
    html
;

section: D_SECTION php_expression general_statement* D_ENDSECTION;
section_inline: D_SECTION php_expression;

if : D_IF php_expression general_statement* D_ENDIF? ~(D_IF | D_ELSEIF | D_ELSE);
elseif : D_ELSEIF php_expression general_statement* D_ENDIF? ~(D_IF | D_ELSEIF | D_ELSE);
else : D_ELSE general_statement* D_ENDIF? ~(D_IF | D_ELSEIF | D_ELSE);

yield : D_YIELD php_expression;
include : D_INCLUDE php_expression;

custom_directive : D_CUSTOM php_expression;
    
php_blade : D_PHP BLADE_PHP_INLINE D_ENDPHP;

//echo

echo : ESCAPED_ECHO_START BLADE_PHP_ECHO_EXPR ESCAPED_ECHO_END;
echo_ne : NE_ECHO_START BLADE_PHP_ECHO_EXPR NE_ECHO_END;

php_expression: WS_EXPR? PHP_EXPRESSION;

verbatim_block : D_VERBATIM non_blade_statement+ D_ENDVERBATIM;

//html
html : HTML+;
