grammar Ccool;

// Cool manual: https://web.stanford.edu/class/cs143/materials/cool-manual.pdf
// Cool.g4: https://github.com/antlr/grammars-v4/blob/master/cool/COOL.g4
// All features in Cool need to be implemented.

compilationUnit
    : (classDefinition | varDeclaration | methodDeclaration)+ EOF
    ;

classDefinition
    : 'class' ID superClass? '{' classMember+ '}'
    ;

superClass
    : 'extend' ID
    ;

classMember
    : type ID ('=' expression)? ';'
    | methodDeclaration
    ;

methodDeclaration
    : type ID '(' formalParameters? ')' block
    ;

formalParameters
    : type ID (',' type ID)*
    ;

type
    : 'int'
    | 'double'
    | 'void'
    | ID
    ;

block
    : '{' statement* '}'
    ;

varDeclaration
    : type ID ('=' expression)? ';'
    ;

statement
    : block
    | varDeclaration
    | expression ';'
    ;

expression
    : ID
    | INT
    | '(' expression ')'
    ;

ID  : LETTER (LETTER | [0-9])*
    ;

fragment LETTER
    : [a-zA-Z]
    ;

INT : [0-9]+
    ;

WS  : [ \t\r\n] -> skip;

SINGLE_LINE_COMMENT
    : '//' ~[\r\n] -> skip
    ;

MULTI_LINE_COMMENT
    : '/*' .*? '*/' -> skip
    ;