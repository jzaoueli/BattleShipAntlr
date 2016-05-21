// Generated from C:/Users/Jihed/IdeaProjects/firstAntlr/src/auf2\fieldgram.g4 by ANTLR 4.5.1
package auf2.genrated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class fieldgramLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Row=1, Finalrow=2, Teil=3, Value=4, LineBreak=5, Separator=6;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"Row", "Finalrow", "Teil", "Value", "LineBreak", "Separator"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Row", "Finalrow", "Teil", "Value", "LineBreak", "Separator"
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


	public fieldgramLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "fieldgram.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\b.\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\5\6\'\n\6"+
		"\3\6\3\6\5\6+\n\6\3\7\3\7\2\2\b\3\3\5\4\7\5\t\6\13\7\r\b\3\2\3\4\2uuy"+
		"y/\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3"+
		"\2\2\2\3\17\3\2\2\2\5\30\3\2\2\2\7 \3\2\2\2\t#\3\2\2\2\13*\3\2\2\2\r,"+
		"\3\2\2\2\17\20\5\7\4\2\20\21\5\7\4\2\21\22\5\7\4\2\22\23\5\7\4\2\23\24"+
		"\5\7\4\2\24\25\5\7\4\2\25\26\5\t\5\2\26\27\5\13\6\2\27\4\3\2\2\2\30\31"+
		"\5\7\4\2\31\32\5\7\4\2\32\33\5\7\4\2\33\34\5\7\4\2\34\35\5\7\4\2\35\36"+
		"\5\7\4\2\36\37\5\t\5\2\37\6\3\2\2\2 !\5\t\5\2!\"\5\r\7\2\"\b\3\2\2\2#"+
		"$\t\2\2\2$\n\3\2\2\2%\'\7\17\2\2&%\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2(+\7\f"+
		"\2\2)+\7\17\2\2*&\3\2\2\2*)\3\2\2\2+\f\3\2\2\2,-\7=\2\2-\16\3\2\2\2\5"+
		"\2&*\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}