// Generated from C:/Users/Jihed/IdeaProjects/firstAntlr/src/auf3/grammar\SequenceGram.g4 by ANTLR 4.5.1
package auf3.battleship.antlrgeneration.sequence;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SequenceGramLexer extends Lexer {
    static {
        RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, Text = 2, Value = 3, Zeile = 4, Spalte = 5, LineBreak = 6;
    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    public static final String[] ruleNames = {
            "T__0", "Text", "Value", "Zeile", "Spalte", "LineBreak"
    };

    private static final String[] _LITERAL_NAMES = {
            null, "'.'", "'Der Computer feuert auf '"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, null, "Text", "Value", "Zeile", "Spalte", "LineBreak"
    };
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }


    public SequenceGramLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    public String getGrammarFileName() {
        return "SequenceGram.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public static final String _serializedATN =
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\b8\b\1\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3" +
                    "\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3" +
                    "\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\5\7\63\n\7\3\7\3\7\5\7\67\n\7\2" +
                    "\2\b\3\3\5\4\7\5\t\6\13\7\r\b\3\2\4\3\2CI\3\2\6399\2\3\3\2\2\2\2\5\3\2" +
                    "\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\3\17\3\2\2\2\5\21" +
                    "\3\2\2\2\7*\3\2\2\2\t-\3\2\2\2\13/\3\2\2\2\r\66\3\2\2\2\17\20\7\60\2\2" +
                    "\20\4\3\2\2\2\21\22\7F\2\2\22\23\7g\2\2\23\24\7t\2\2\24\25\7\"\2\2\25" +
                    "\26\7E\2\2\26\27\7q\2\2\27\30\7o\2\2\30\31\7r\2\2\31\32\7w\2\2\32\33\7" +
                    "v\2\2\33\34\7g\2\2\34\35\7t\2\2\35\36\7\"\2\2\36\37\7h\2\2\37 \7g\2\2" +
                    " !\7w\2\2!\"\7g\2\2\"#\7t\2\2#$\7v\2\2$%\7\"\2\2%&\7c\2\2&\'\7w\2\2\'" +
                    "(\7h\2\2()\7\"\2\2)\6\3\2\2\2*+\5\t\5\2+,\5\13\6\2,\b\3\2\2\2-.\t\2\2" +
                    "\2.\n\3\2\2\2/\60\t\3\2\2\60\f\3\2\2\2\61\63\7\17\2\2\62\61\3\2\2\2\62" +
                    "\63\3\2\2\2\63\64\3\2\2\2\64\67\7\f\2\2\65\67\7\17\2\2\66\62\3\2\2\2\66" +
                    "\65\3\2\2\2\67\16\3\2\2\2\5\2\62\66\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}