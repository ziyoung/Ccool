// Generated from Ccool.g4 by ANTLR 4.8
package net.ziyoung.ccool.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CcoolLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, INT=15, DOUBLE=16, BOOL=17, 
		NULL=18, STRING=19, ID=20, WS=21, SINGLE_LINE_COMMENT=22, MULTI_LINE_COMMENT=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "LETTER", "INT", "INTEGER", 
			"DOUBLE", "BOOL", "NULL", "STRING", "ID", "ESC", "UNICODE", "HEX", "WS", 
			"SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'{'", "'}'", "'extend'", "'('", "')'", "','", "'int'", 
			"'double'", "'string'", "'bool'", "'void'", "'='", "';'", null, null, 
			null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "INT", "DOUBLE", "BOOL", "NULL", "STRING", "ID", "WS", 
			"SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public CcoolLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Ccool.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u00d9\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3"+
		"\20\3\20\3\21\5\21v\n\21\3\21\3\21\3\22\3\22\3\22\7\22}\n\22\f\22\16\22"+
		"\u0080\13\22\5\22\u0082\n\22\3\23\3\23\3\23\6\23\u0087\n\23\r\23\16\23"+
		"\u0088\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0094\n\24\3"+
		"\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\7\26\u009e\n\26\f\26\16\26\u00a1"+
		"\13\26\3\26\3\26\3\27\3\27\3\27\7\27\u00a8\n\27\f\27\16\27\u00ab\13\27"+
		"\3\30\3\30\3\30\5\30\u00b0\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\33\6\33\u00bb\n\33\r\33\16\33\u00bc\3\33\3\33\3\34\3\34\3\34\3\34\7"+
		"\34\u00c5\n\34\f\34\16\34\u00c8\13\34\3\34\3\34\3\35\3\35\3\35\3\35\7"+
		"\35\u00d0\n\35\f\35\16\35\u00d3\13\35\3\35\3\35\3\35\3\35\3\35\3\u00d1"+
		"\2\36\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\2!\21#\2%\22\'\23)\24+\25-\26/\2\61\2\63\2\65\27\67\309\31\3\2"+
		"\n\4\2C\\c|\3\2\63;\3\2\62;\4\2$$^^\n\2$$\61\61^^ddhhppttvv\5\2\62;CH"+
		"ch\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u00e0\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2!\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\3;\3\2\2\2\5A\3\2\2\2"+
		"\7C\3\2\2\2\tE\3\2\2\2\13L\3\2\2\2\rN\3\2\2\2\17P\3\2\2\2\21R\3\2\2\2"+
		"\23V\3\2\2\2\25]\3\2\2\2\27d\3\2\2\2\31i\3\2\2\2\33n\3\2\2\2\35p\3\2\2"+
		"\2\37r\3\2\2\2!u\3\2\2\2#\u0081\3\2\2\2%\u0083\3\2\2\2\'\u0093\3\2\2\2"+
		")\u0095\3\2\2\2+\u009a\3\2\2\2-\u00a4\3\2\2\2/\u00ac\3\2\2\2\61\u00b1"+
		"\3\2\2\2\63\u00b7\3\2\2\2\65\u00ba\3\2\2\2\67\u00c0\3\2\2\29\u00cb\3\2"+
		"\2\2;<\7e\2\2<=\7n\2\2=>\7c\2\2>?\7u\2\2?@\7u\2\2@\4\3\2\2\2AB\7}\2\2"+
		"B\6\3\2\2\2CD\7\177\2\2D\b\3\2\2\2EF\7g\2\2FG\7z\2\2GH\7v\2\2HI\7g\2\2"+
		"IJ\7p\2\2JK\7f\2\2K\n\3\2\2\2LM\7*\2\2M\f\3\2\2\2NO\7+\2\2O\16\3\2\2\2"+
		"PQ\7.\2\2Q\20\3\2\2\2RS\7k\2\2ST\7p\2\2TU\7v\2\2U\22\3\2\2\2VW\7f\2\2"+
		"WX\7q\2\2XY\7w\2\2YZ\7d\2\2Z[\7n\2\2[\\\7g\2\2\\\24\3\2\2\2]^\7u\2\2^"+
		"_\7v\2\2_`\7t\2\2`a\7k\2\2ab\7p\2\2bc\7i\2\2c\26\3\2\2\2de\7d\2\2ef\7"+
		"q\2\2fg\7q\2\2gh\7n\2\2h\30\3\2\2\2ij\7x\2\2jk\7q\2\2kl\7k\2\2lm\7f\2"+
		"\2m\32\3\2\2\2no\7?\2\2o\34\3\2\2\2pq\7=\2\2q\36\3\2\2\2rs\t\2\2\2s \3"+
		"\2\2\2tv\7/\2\2ut\3\2\2\2uv\3\2\2\2vw\3\2\2\2wx\5#\22\2x\"\3\2\2\2y\u0082"+
		"\7\62\2\2z~\t\3\2\2{}\t\4\2\2|{\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177"+
		"\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0081y\3\2\2\2\u0081z\3\2\2"+
		"\2\u0082$\3\2\2\2\u0083\u0084\5!\21\2\u0084\u0086\7\60\2\2\u0085\u0087"+
		"\t\4\2\2\u0086\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086\3\2\2\2\u0088"+
		"\u0089\3\2\2\2\u0089&\3\2\2\2\u008a\u008b\7v\2\2\u008b\u008c\7t\2\2\u008c"+
		"\u008d\7w\2\2\u008d\u0094\7g\2\2\u008e\u008f\7h\2\2\u008f\u0090\7c\2\2"+
		"\u0090\u0091\7n\2\2\u0091\u0092\7u\2\2\u0092\u0094\7g\2\2\u0093\u008a"+
		"\3\2\2\2\u0093\u008e\3\2\2\2\u0094(\3\2\2\2\u0095\u0096\7p\2\2\u0096\u0097"+
		"\7w\2\2\u0097\u0098\7n\2\2\u0098\u0099\7n\2\2\u0099*\3\2\2\2\u009a\u009f"+
		"\7$\2\2\u009b\u009e\5/\30\2\u009c\u009e\n\5\2\2\u009d\u009b\3\2\2\2\u009d"+
		"\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\7$\2\2\u00a3"+
		",\3\2\2\2\u00a4\u00a9\5\37\20\2\u00a5\u00a8\5\37\20\2\u00a6\u00a8\t\4"+
		"\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa.\3\2\2\2\u00ab\u00a9\3\2\2\2"+
		"\u00ac\u00af\7^\2\2\u00ad\u00b0\t\6\2\2\u00ae\u00b0\5\61\31\2\u00af\u00ad"+
		"\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0\60\3\2\2\2\u00b1\u00b2\7w\2\2\u00b2"+
		"\u00b3\5\63\32\2\u00b3\u00b4\5\63\32\2\u00b4\u00b5\5\63\32\2\u00b5\u00b6"+
		"\5\63\32\2\u00b6\62\3\2\2\2\u00b7\u00b8\t\7\2\2\u00b8\64\3\2\2\2\u00b9"+
		"\u00bb\t\b\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00ba\3\2"+
		"\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\b\33\2\2\u00bf"+
		"\66\3\2\2\2\u00c0\u00c1\7\61\2\2\u00c1\u00c2\7\61\2\2\u00c2\u00c6\3\2"+
		"\2\2\u00c3\u00c5\n\t\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00c6\3\2"+
		"\2\2\u00c9\u00ca\b\34\2\2\u00ca8\3\2\2\2\u00cb\u00cc\7\61\2\2\u00cc\u00cd"+
		"\7,\2\2\u00cd\u00d1\3\2\2\2\u00ce\u00d0\13\2\2\2\u00cf\u00ce\3\2\2\2\u00d0"+
		"\u00d3\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d4\3\2"+
		"\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d5\7,\2\2\u00d5\u00d6\7\61\2\2\u00d6"+
		"\u00d7\3\2\2\2\u00d7\u00d8\b\35\2\2\u00d8:\3\2\2\2\20\2u~\u0081\u0088"+
		"\u0093\u009d\u009f\u00a7\u00a9\u00af\u00bc\u00c6\u00d1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}