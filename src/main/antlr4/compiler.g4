grammar compiler;

program
   : DECLARE declarations BEGIN commands END
   | BEGIN commands END
   ;

declarations
   : declarations ',' PIDENTIFIER
   | declarations ',' PIDENTIFIER '(' NUM ':' NUM ')'
   | PIDENTIFIER
   | PIDENTIFIER '(' NUM ':' NUM ')'
   ;

commands
   : commands command
   | command
   ;

command
   : identifier ASSIGN expression ';' #assign
   | IF condition THEN commands ELSE commands ENDIF #ifElse
   | IF condition THEN commands ENDIF #if
   | WHILE condition DO commands ENDWHILE #while
   | DO commands WHILE condition ENDDO #doWhile
   | FOR PIDENTIFIER FROM value TO value DO commands ENDFOR #for
   | FOR PIDENTIFIER FROM value DOWNTO value DO commands ENDFOR #forDown
   | READ identifier ';' #read
   | WRITE value ';' #write
   ;

expression
   : value #singleValue
   | value op = (TIMES | DIV | MOD) value #multiplication
   | value op = (PLUS | MINUS) value #addition
   ;

condition
   : value op = (EQ | NEQ | LE | GE | LEQ | GEQ) value
   ;

value
   : NUM
   | identifier
   ;

identifier
   : PIDENTIFIER #simpleIdentifier
   | PIDENTIFIER '(' PIDENTIFIER ')' #complexArray
   | PIDENTIFIER '(' NUM ')' #simpleArray
   ;


NUM            :  [-]?[1-9][0-9]* | [0] ;
PLUS           : 'PLUS' ;
MINUS          : 'MINUS' ;
TIMES          : 'TIMES' ;
DIV            : 'DIV' ;
MOD            : 'MOD' ;
EQ             : 'EQ' ;
NEQ            : 'NEQ' ;
LE             : 'LE' ;
GE             : 'GE' ;
LEQ            : 'LEQ' ;
GEQ            : 'GEQ' ;
IF             : 'IF' ;
THEN           : 'THEN' ;
ELSE           : 'ELSE' ;
ENDIF          : 'ENDIF' ;
WHILE          : 'WHILE' ;
DO             : 'DO' ;
ENDDO          : 'ENDDO' ;
FOR            : 'FOR' ;
FROM           : 'FROM' ;
TO             : 'TO' ;
DOWNTO         : 'DOWNTO' ;
ENDFOR         : 'ENDFOR' ;
ENDWHILE       : 'ENDWHILE' ;
ASSIGN         : 'ASSIGN' ;
READ           : 'READ' ;
WRITE          : 'WRITE' ;
DECLARE        : 'DECLARE' ;
BEGIN          : 'BEGIN' ;
END            : 'END' ;
PIDENTIFIER    : [_a-z]+ ;
WHITE          : [ \t\r\n] -> skip ;
COMMENT        : '['.*?']'  -> skip;
OTHER          : . ;