parser grammar BladeAntlrParser;

@header{
  package org.netbeans.modules.php.blade.syntax.antlr4;
}

options { tokenVocab = BladeAntlrLexer; }

file : general_statement+
| EOF;

general_statement: inline_statement
    | block_statement
    | html
;

inline_statement: extends
| section_inline;

extends : D_EXTENDS PHP_EXPRESSION;


block_statement: section;

section: D_SECTION PHP_EXPRESSION general_statement* D_ENDSECTION;
section_inline: D_SECTION PHP_EXPRESSION;

//html
html : HTML+;
