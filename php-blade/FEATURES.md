# NETBEANS PHP BLADE EDITOR PLANNED FEATURES

## What features can be considered as api

- blade antlr parser
- blade paths?

## versioning and deprecation 

start from 10

- bracesmatcher
- completion

## Completion

- Completion for directives 50% (to add more directives)
- Completion for custom directives 0%
- Completion for echo tags 80% (to add icon and possible description)
- Completion for blade files 80% (to add icon)
- Completion for yield names 70% (to add icon, for the moment no context is added)

! Most probably `BladeCompletionHandler` will not be used. The main completion service will be `BladeCompletionProvider`

## Braces matcher

- forward
- backward

Achieved : 98 %

Check for formating and code optimisation

## Declaration finder

- blade paths reference file 70% (handle multiple references location) !
- blade yield ids 80%
- stacks + push ?
- components

! we will have to wait for the Project Custom Blade path config

## Html embedding

tags are not paired

## Php embedding

## Reformating

## Lexer coloring

80%

Could simplify lexer coloring for directives after we have a full parser

should lookout for the freezing nekudo

verbatim should embed php code

extract all css directives

## ANTLR

see if we can have optimisaiton using channels
might use a common .g4 file for some tokens for (coloring and lexer)
try to see optimisation on the grammar (coloring + lexer)
see if alias can help us with simple param extraction on listener
might simplify generic block statment parsing which are not relevant for data extractio ex: block statements like @can, @isset ...

## Unit tests

- lexer
- completion

## file wizard refactor

TemplateWizardIterator

Not sure if it's possible, not a priority.
The msin issue is the FileObject geName and getExt methods on .blade.php

## linked documentation in markdown ?

might check how it would work / parse

## plugins ?

livewire


---

## CONDITION FOR COMPLETE

Project considered complete when : 

- has good lexer coloring for all embedding context : html, javascript, css, php
    - should not freeze IDE when using ":" in php embedding context
    - should have unit tests for known lexer issues on the previous project
- has brace match highlight for html and blade directives and output tags
- supports project config for : 
    - custom directives
    - custom blade template paths



