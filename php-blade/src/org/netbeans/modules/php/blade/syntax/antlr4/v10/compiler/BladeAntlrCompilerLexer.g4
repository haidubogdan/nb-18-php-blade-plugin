lexer grammar BladeAntlrCompilerLexer;

@header{
  package org.netbeans.modules.php.blade.syntax.antlr4.v10.compiler;
}

options { superClass = LexerAdaptor; }
 
//we will hide html in the end
tokens {HTML}
 
channels { COMMENT }

//
D_ESCAPES 
    : (
      '@@'
    | '@{'
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

D_IF : '@if';
