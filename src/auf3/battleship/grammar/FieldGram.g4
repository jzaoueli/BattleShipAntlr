grammar FieldGram;
file : Row Row Row Row Row Row Finalrow EOF ;
Row : Teil Teil Teil Teil Teil Teil Value LineBreak;
Finalrow : Teil Teil Teil Teil Teil Teil Value ;
Teil : (Value Separator);
Value : 'w' | 's';
LineBreak : '\r'?'\n' |'\r' ;
Separator : ';' ;

/*
file
    :
    line+
    ;

line
    :
    key COLON eol
    ;

key
    : SHIFF | WASSER
    ;

eol
    : NEWLINE | EOF
    ;

COLON   : ';' ;
SHIFF   : 's' ;
WASSER  : 'w' ;
NEWLINE : '\r'? '\n' | '\r' ;
*/