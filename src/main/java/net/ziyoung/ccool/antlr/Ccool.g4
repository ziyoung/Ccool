grammar Ccool;

// Cool manual: https://web.stanford.edu/class/cs143/materials/cool-manual.pdf
// Cool.g4: https://github.com/antlr/grammars-v4/blob/master/cool/COOL.g4
// All features in Cool need to be implemented.

compilationUnit
    : classDefinition+
    ;

classDefinition
    : 'class' CLASSID superClass? '{' classMember+ '}'
    ;

superClass
    : 'extend' CLASSID
    ;

classMember
    : varDeclaration
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
    | 'string'
    | 'bool'
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
    : ID '(' expressionList? ')'    # Call
    | '-' expression                # Negative
    | expression '*' expression     # Multiply
    | expression '/' expression     # Division
    | expression '+' expression     # Add
    | expression '-' expression     # Minus
    | '(' expression ')'            # Group
    | ID '=' expression             # Assign
    | literal                       # Liter
    | ID                            # Var
    ;

expressionList
    : expression (',' expression)*
    ;

fragment LETTER
    : [a-zA-Z]
    ;

literal
    : BOOL
    | INT
    | DOUBLE
    | STRING
    | NULL
    ;

INT : '-'? INTEGER
    ;

fragment INTEGER
    : '0' | [1-9] [0-9]*
    ;

DOUBLE
    : INT '.' [0-9]+
    ;

BOOL : 'true' | 'false'
    ;

NULL : 'null'
    ;

STRING
    : '"' (ESC | ~["\\])* '"'
    ;

CLASSID
    : [A-Z](LETTER | [0-9])*
    ;

ID  : LETTER (LETTER | [0-9])*
    ;

fragment ESC
    : '\\' (["\\/bfnrt] | UNICODE)
    ;

fragment UNICODE
    : 'u' HEX HEX HEX HEX
    ;

fragment HEX
    : [0-9a-fA-F]
    ;

WS  : [ \t\r\n]+ -> skip;

SINGLE_LINE_COMMENT
    : '//' ~[\r\n]* -> skip
    ;

MULTI_LINE_COMMENT
    : '/*' .*? '*/' -> skip
    ;