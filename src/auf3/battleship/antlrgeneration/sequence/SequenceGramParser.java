// Generated from C:/Users/Jihed/IdeaProjects/firstAntlr/src/auf3/grammar\SequenceGram.g4 by ANTLR 4.5.1
package auf3.battleship.antlrgeneration.sequence;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SequenceGramParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, Text = 2, Value = 3, Zeile = 4, Spalte = 5, LineBreak = 6;
    public static final int
            RULE_file = 0, RULE_line = 1, RULE_eol = 2;
    public static final String[] ruleNames = {
            "file", "line", "eol"
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
    public ATN getATN() {
        return _ATN;
    }

    public SequenceGramParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class FileContext extends ParserRuleContext {
        public TerminalNode EOF() {
            return getToken(SequenceGramParser.EOF, 0);
        }

        public List<LineContext> line() {
            return getRuleContexts(LineContext.class);
        }

        public LineContext line(int i) {
            return getRuleContext(LineContext.class, i);
        }

        public FileContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_file;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof SequenceGramListener) ((SequenceGramListener) listener).enterFile(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof SequenceGramListener) ((SequenceGramListener) listener).exitFile(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof SequenceGramVisitor)
                return ((SequenceGramVisitor<? extends T>) visitor).visitFile(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FileContext file() throws RecognitionException {
        FileContext _localctx = new FileContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_file);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(7);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(6);
                            line();
                        }
                    }
                    setState(9);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == Text);
                setState(11);
                match(EOF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class LineContext extends ParserRuleContext {
        public TerminalNode Text() {
            return getToken(SequenceGramParser.Text, 0);
        }

        public TerminalNode Value() {
            return getToken(SequenceGramParser.Value, 0);
        }

        public EolContext eol() {
            return getRuleContext(EolContext.class, 0);
        }

        public TerminalNode LineBreak() {
            return getToken(SequenceGramParser.LineBreak, 0);
        }

        public LineContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_line;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof SequenceGramListener) ((SequenceGramListener) listener).enterLine(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof SequenceGramListener) ((SequenceGramListener) listener).exitLine(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof SequenceGramVisitor)
                return ((SequenceGramVisitor<? extends T>) visitor).visitLine(this);
            else return visitor.visitChildren(this);
        }
    }

    public final LineContext line() throws RecognitionException {
        LineContext _localctx = new LineContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_line);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(13);
                match(Text);
                setState(14);
                match(Value);
                setState(15);
                eol();
                setState(16);
                match(LineBreak);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class EolContext extends ParserRuleContext {
        public EolContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_eol;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof SequenceGramListener) ((SequenceGramListener) listener).enterEol(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof SequenceGramListener) ((SequenceGramListener) listener).exitEol(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof SequenceGramVisitor)
                return ((SequenceGramVisitor<? extends T>) visitor).visitEol(this);
            else return visitor.visitChildren(this);
        }
    }

    public final EolContext eol() throws RecognitionException {
        EolContext _localctx = new EolContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_eol);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(18);
                match(T__0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static final String _serializedATN =
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\b\27\4\2\t\2\4\3" +
                    "\t\3\4\4\t\4\3\2\6\2\n\n\2\r\2\16\2\13\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4" +
                    "\3\4\3\4\2\2\5\2\4\6\2\2\24\2\t\3\2\2\2\4\17\3\2\2\2\6\24\3\2\2\2\b\n" +
                    "\5\4\3\2\t\b\3\2\2\2\n\13\3\2\2\2\13\t\3\2\2\2\13\f\3\2\2\2\f\r\3\2\2" +
                    "\2\r\16\7\2\2\3\16\3\3\2\2\2\17\20\7\4\2\2\20\21\7\5\2\2\21\22\5\6\4\2" +
                    "\22\23\7\b\2\2\23\5\3\2\2\2\24\25\7\3\2\2\25\7\3\2\2\2\3\13";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}