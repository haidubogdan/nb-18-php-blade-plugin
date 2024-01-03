# NETBEANS PHP BLADE EDITOR PLANNED FEATURES

## What features can be considered as api

- blade antlr parser
- blade paths?

## versioning and deprecation 

start from 10

- bracesmatcher
- completion

## Completion

- Completion for directives 80% (might add some documentation)
- Completion for custom directives 80%
- Completion for echo tags 80% (to add icon and possible description)
- Completion for blade files 100%
- Completion for yield names 80% (for the moment no context is added)
- Completion inside echo statement 0%

?? the include statement

## validation

if conditions are broken

## Braces matcher

- forward
- backward

Achieved : 98 %

Check for formating and code optimisation

## Declaration finder

- blade paths reference file 70% (handle multiple references location) !
- blade yield ids 80%
- stacks + push 80%
- components
- refactor code

## Html embedding

tags are not paired

## Php embedding

- added a simple embedding for standard <?= > <?php ?> cases

## Reformating

## Navigation

## Lexer coloring

80%

Could simplify lexer coloring for directives after we have a full parser

should lookout for the freezing nekudo

verbatim should embed php code

extract all css directives

## ANTLR

see if alias can help us with simple param extraction on listener
might simplify generic block statment parsing which are not relevant for data extractio ex: block statements like @can, @isset ...

## Unit tests

- lexer
- completion

## Type searcher

- working for blade paths 90%

## Hints

- added a basic hint provider for custom direcvies 

!TODO link it with the custom direcvie config

## file wizard refactor

TemplateWizardIterator

Not sure if it's possible, not a priority.
The msin issue is the FileObject geName and getExt methods on .blade.php

## linked documentation in markdown ?

might check how it would work / parse

## Licence

add a GPL licence 0%

## plugins ?

livewire


---

## CONDITION FOR COMPLETE

Project considered complete when : 

- has good lexer coloring for all embedding context : html, javascript, css, php
    - should not freeze IDE when using ":" in php embedding context
    - should have unit tests for known lexer issues on the previous project
- has brace match highlight for html and blade directives and output tags
- navigator
- supports project config for : 
    - custom directives
    - custom blade template paths
- analyze with profiler the memory usage



