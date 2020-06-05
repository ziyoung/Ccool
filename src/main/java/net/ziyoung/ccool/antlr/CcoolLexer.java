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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, INT=19, DOUBLE=20, BOOL=21, NULL=22, STRING=23, CLASSID=24, 
		ID=25, WS=26, SINGLE_LINE_COMMENT=27, MULTI_LINE_COMMENT=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "LETTER", "INT", "INTEGER", "DOUBLE", "BOOL", "NULL", "STRING", 
			"CLASSID", "ID", "ESC", "UNICODE", "HEX", "WS", "SINGLE_LINE_COMMENT", 
			"MULTI_LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'{'", "'}'", "'extend'", "'('", "')'", "','", "'int'", 
			"'double'", "'string'", "'bool'", "'void'", "'='", "';'", "'-'", "'*'", 
			"'/'", "'+'", null, null, null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "INT", "DOUBLE", "BOOL", "NULL", 
			"STRING", "CLASSID", "ID", "WS", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\36\u00f3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3"+
		"\23\3\23\3\24\3\24\3\25\5\25\u0088\n\25\3\25\3\25\3\26\3\26\3\26\7\26"+
		"\u008f\n\26\f\26\16\26\u0092\13\26\5\26\u0094\n\26\3\27\3\27\3\27\6\27"+
		"\u0099\n\27\r\27\16\27\u009a\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\5\30\u00a6\n\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\7\32\u00b0"+
		"\n\32\f\32\16\32\u00b3\13\32\3\32\3\32\3\33\3\33\3\33\7\33\u00ba\n\33"+
		"\f\33\16\33\u00bd\13\33\3\34\3\34\3\34\7\34\u00c2\n\34\f\34\16\34\u00c5"+
		"\13\34\3\35\3\35\3\35\5\35\u00ca\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\37\3\37\3 \6 \u00d5\n \r \16 \u00d6\3 \3 \3!\3!\3!\3!\7!\u00df\n!\f!"+
		"\16!\u00e2\13!\3!\3!\3\"\3\"\3\"\3\"\7\"\u00ea\n\"\f\"\16\"\u00ed\13\""+
		"\3\"\3\"\3\"\3\"\3\"\3\u00eb\2#\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\2)\25+\2-\26/\27\61"+
		"\30\63\31\65\32\67\339\2;\2=\2?\34A\35C\36\3\2\13\4\2C\\c|\3\2\63;\3\2"+
		"\62;\4\2$$^^\3\2C\\\n\2$$\61\61^^ddhhppttvv\5\2\62;CHch\5\2\13\f\17\17"+
		"\"\"\4\2\f\f\17\17\2\u00fc\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2)\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2?\3\2\2\2\2A\3"+
		"\2\2\2\2C\3\2\2\2\3E\3\2\2\2\5K\3\2\2\2\7M\3\2\2\2\tO\3\2\2\2\13V\3\2"+
		"\2\2\rX\3\2\2\2\17Z\3\2\2\2\21\\\3\2\2\2\23`\3\2\2\2\25g\3\2\2\2\27n\3"+
		"\2\2\2\31s\3\2\2\2\33x\3\2\2\2\35z\3\2\2\2\37|\3\2\2\2!~\3\2\2\2#\u0080"+
		"\3\2\2\2%\u0082\3\2\2\2\'\u0084\3\2\2\2)\u0087\3\2\2\2+\u0093\3\2\2\2"+
		"-\u0095\3\2\2\2/\u00a5\3\2\2\2\61\u00a7\3\2\2\2\63\u00ac\3\2\2\2\65\u00b6"+
		"\3\2\2\2\67\u00be\3\2\2\29\u00c6\3\2\2\2;\u00cb\3\2\2\2=\u00d1\3\2\2\2"+
		"?\u00d4\3\2\2\2A\u00da\3\2\2\2C\u00e5\3\2\2\2EF\7e\2\2FG\7n\2\2GH\7c\2"+
		"\2HI\7u\2\2IJ\7u\2\2J\4\3\2\2\2KL\7}\2\2L\6\3\2\2\2MN\7\177\2\2N\b\3\2"+
		"\2\2OP\7g\2\2PQ\7z\2\2QR\7v\2\2RS\7g\2\2ST\7p\2\2TU\7f\2\2U\n\3\2\2\2"+
		"VW\7*\2\2W\f\3\2\2\2XY\7+\2\2Y\16\3\2\2\2Z[\7.\2\2[\20\3\2\2\2\\]\7k\2"+
		"\2]^\7p\2\2^_\7v\2\2_\22\3\2\2\2`a\7f\2\2ab\7q\2\2bc\7w\2\2cd\7d\2\2d"+
		"e\7n\2\2ef\7g\2\2f\24\3\2\2\2gh\7u\2\2hi\7v\2\2ij\7t\2\2jk\7k\2\2kl\7"+
		"p\2\2lm\7i\2\2m\26\3\2\2\2no\7d\2\2op\7q\2\2pq\7q\2\2qr\7n\2\2r\30\3\2"+
		"\2\2st\7x\2\2tu\7q\2\2uv\7k\2\2vw\7f\2\2w\32\3\2\2\2xy\7?\2\2y\34\3\2"+
		"\2\2z{\7=\2\2{\36\3\2\2\2|}\7/\2\2} \3\2\2\2~\177\7,\2\2\177\"\3\2\2\2"+
		"\u0080\u0081\7\61\2\2\u0081$\3\2\2\2\u0082\u0083\7-\2\2\u0083&\3\2\2\2"+
		"\u0084\u0085\t\2\2\2\u0085(\3\2\2\2\u0086\u0088\7/\2\2\u0087\u0086\3\2"+
		"\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\5+\26\2\u008a"+
		"*\3\2\2\2\u008b\u0094\7\62\2\2\u008c\u0090\t\3\2\2\u008d\u008f\t\4\2\2"+
		"\u008e\u008d\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091"+
		"\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u008b\3\2\2\2\u0093"+
		"\u008c\3\2\2\2\u0094,\3\2\2\2\u0095\u0096\5)\25\2\u0096\u0098\7\60\2\2"+
		"\u0097\u0099\t\4\2\2\u0098\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u0098"+
		"\3\2\2\2\u009a\u009b\3\2\2\2\u009b.\3\2\2\2\u009c\u009d\7v\2\2\u009d\u009e"+
		"\7t\2\2\u009e\u009f\7w\2\2\u009f\u00a6\7g\2\2\u00a0\u00a1\7h\2\2\u00a1"+
		"\u00a2\7c\2\2\u00a2\u00a3\7n\2\2\u00a3\u00a4\7u\2\2\u00a4\u00a6\7g\2\2"+
		"\u00a5\u009c\3\2\2\2\u00a5\u00a0\3\2\2\2\u00a6\60\3\2\2\2\u00a7\u00a8"+
		"\7p\2\2\u00a8\u00a9\7w\2\2\u00a9\u00aa\7n\2\2\u00aa\u00ab\7n\2\2\u00ab"+
		"\62\3\2\2\2\u00ac\u00b1\7$\2\2\u00ad\u00b0\59\35\2\u00ae\u00b0\n\5\2\2"+
		"\u00af\u00ad\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af"+
		"\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4"+
		"\u00b5\7$\2\2\u00b5\64\3\2\2\2\u00b6\u00bb\t\6\2\2\u00b7\u00ba\5\'\24"+
		"\2\u00b8\u00ba\t\4\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd"+
		"\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\66\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00be\u00c3\5\'\24\2\u00bf\u00c2\5\'\24\2\u00c0\u00c2\t"+
		"\4\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3"+
		"\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c48\3\2\2\2\u00c5\u00c3\3\2\2\2"+
		"\u00c6\u00c9\7^\2\2\u00c7\u00ca\t\7\2\2\u00c8\u00ca\5;\36\2\u00c9\u00c7"+
		"\3\2\2\2\u00c9\u00c8\3\2\2\2\u00ca:\3\2\2\2\u00cb\u00cc\7w\2\2\u00cc\u00cd"+
		"\5=\37\2\u00cd\u00ce\5=\37\2\u00ce\u00cf\5=\37\2\u00cf\u00d0\5=\37\2\u00d0"+
		"<\3\2\2\2\u00d1\u00d2\t\b\2\2\u00d2>\3\2\2\2\u00d3\u00d5\t\t\2\2\u00d4"+
		"\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2"+
		"\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\b \2\2\u00d9@\3\2\2\2\u00da\u00db"+
		"\7\61\2\2\u00db\u00dc\7\61\2\2\u00dc\u00e0\3\2\2\2\u00dd\u00df\n\n\2\2"+
		"\u00de\u00dd\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1"+
		"\3\2\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e4\b!\2\2\u00e4"+
		"B\3\2\2\2\u00e5\u00e6\7\61\2\2\u00e6\u00e7\7,\2\2\u00e7\u00eb\3\2\2\2"+
		"\u00e8\u00ea\13\2\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00ec"+
		"\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee"+
		"\u00ef\7,\2\2\u00ef\u00f0\7\61\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\b\""+
		"\2\2\u00f2D\3\2\2\2\22\2\u0087\u0090\u0093\u009a\u00a5\u00af\u00b1\u00b9"+
		"\u00bb\u00c1\u00c3\u00c9\u00d6\u00e0\u00eb\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}