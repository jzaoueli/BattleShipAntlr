grammar SequenceGram;
file : line+ EOF;

line : Text Value eol LineBreak;

Text : 'Der Computer feuert auf ';

Value : Zeile Spalte;

Zeile : [A-G];

Spalte : [1-7];

eol : '.';

LineBreak : '\r'?'\n' |'\r' ;