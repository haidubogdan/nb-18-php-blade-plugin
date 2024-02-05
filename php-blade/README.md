# Netbeans Php blade editor

Netbeans Php blade editor using Antlr Lexer and Parser.

## Features

- syntax php coloring for blade components
- find template usage

## Known issues

The duplicate file process can create a "blade_1.php" file due to the fact that the extension is considered "php" and not "blade.php"

HTML join embedding breaks indentation


```
java.lang.AssertionError: token:org.netbeans.lib.lexer.token.DefaultToken@6d99d689 ts=JoinedTokenSequence[ContextDataTokenSequence[ts=TokenSequence for text/x-blade/text/html at tokenIndex=0. TokenList contains 1 tokens:
*[0]: "<" <0,1> DECLARATION[14] ParT[1/3], @2d9826e7
...
```

Comment doesn't work if two types of embeddings are found.
for directives we need to surround the PHP_EXPRESSION with pure blade mime elements

## Variable completion

Variable completion from controller will not be implemented as it's a bit difficult and it needs more time