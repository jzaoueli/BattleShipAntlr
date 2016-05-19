grammar CSV;
file : row* EOF ;
row : value (Separator value)* (LineBreak | EOF) ;
value : SimpleValue | QuotedValue ;
Separator : ',' | ';' ;
// line break maybe with preceding line feed
LineBreak : '\r'?'\n' | '\r';
// Anything but a line-breaking, separator or quoting character is allowed
SimpleValue : ~(','|';'|'\r'|'\n'|'"')+ ;
// Anything but a quoting character is allowed
QuotedValue : '"'('""'|~'"')*'"' ;