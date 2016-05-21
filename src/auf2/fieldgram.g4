grammar fieldgram;
file : Row Row Row Row Row Row Finalrow EOF ;
Row : Teil Teil Teil Teil Teil Teil Value LineBreak;
Finalrow : Teil Teil Teil Teil Teil Teil Value ;
Teil : (Value Separator);
Value : 'w'| 's';
// line break maybe with preceding line feed
LineBreak : '\r'?'\n' |'\r' ;
Separator : ';' ;