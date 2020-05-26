// Generated from /src/main/java/net/ziyoung/ccool/antlr/Ccool.g4 by ANTLR 4.8
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
		T__9=10, T__10=11, T__11=12, ID=13, INT=14, WS=15, SINGLE_LINE_COMMENT=16, 
		MULTI_LINE_COMMENT=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "ID", "LETTER", "INT", "WS", "SINGLE_LINE_COMMENT", 
			"MULTI_LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'{'", "'}'", "'extend'", "'='", "';'", "'('", "')'", 
			"','", "'int'", "'double'", "'void'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "ID", "INT", "WS", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23z\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\7\16V\n"+
		"\16\f\16\16\16Y\13\16\3\17\3\17\3\20\6\20^\n\20\r\20\16\20_\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\7\23"+
		"q\n\23\f\23\16\23t\13\23\3\23\3\23\3\23\3\23\3\23\3r\2\24\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\2\37\20!\21#\22"+
		"%\23\3\2\6\3\2\62;\4\2C\\c|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2|\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'"+
		"\3\2\2\2\5-\3\2\2\2\7/\3\2\2\2\t\61\3\2\2\2\138\3\2\2\2\r:\3\2\2\2\17"+
		"<\3\2\2\2\21>\3\2\2\2\23@\3\2\2\2\25B\3\2\2\2\27F\3\2\2\2\31M\3\2\2\2"+
		"\33R\3\2\2\2\35Z\3\2\2\2\37]\3\2\2\2!a\3\2\2\2#e\3\2\2\2%l\3\2\2\2\'("+
		"\7e\2\2()\7n\2\2)*\7c\2\2*+\7u\2\2+,\7u\2\2,\4\3\2\2\2-.\7}\2\2.\6\3\2"+
		"\2\2/\60\7\177\2\2\60\b\3\2\2\2\61\62\7g\2\2\62\63\7z\2\2\63\64\7v\2\2"+
		"\64\65\7g\2\2\65\66\7p\2\2\66\67\7f\2\2\67\n\3\2\2\289\7?\2\29\f\3\2\2"+
		"\2:;\7=\2\2;\16\3\2\2\2<=\7*\2\2=\20\3\2\2\2>?\7+\2\2?\22\3\2\2\2@A\7"+
		".\2\2A\24\3\2\2\2BC\7k\2\2CD\7p\2\2DE\7v\2\2E\26\3\2\2\2FG\7f\2\2GH\7"+
		"q\2\2HI\7w\2\2IJ\7d\2\2JK\7n\2\2KL\7g\2\2L\30\3\2\2\2MN\7x\2\2NO\7q\2"+
		"\2OP\7k\2\2PQ\7f\2\2Q\32\3\2\2\2RW\5\35\17\2SV\5\35\17\2TV\t\2\2\2US\3"+
		"\2\2\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\34\3\2\2\2YW\3\2\2\2Z"+
		"[\t\3\2\2[\36\3\2\2\2\\^\t\2\2\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3\2"+
		"\2\2` \3\2\2\2ab\t\4\2\2bc\3\2\2\2cd\b\21\2\2d\"\3\2\2\2ef\7\61\2\2fg"+
		"\7\61\2\2gh\3\2\2\2hi\n\5\2\2ij\3\2\2\2jk\b\22\2\2k$\3\2\2\2lm\7\61\2"+
		"\2mn\7,\2\2nr\3\2\2\2oq\13\2\2\2po\3\2\2\2qt\3\2\2\2rs\3\2\2\2rp\3\2\2"+
		"\2su\3\2\2\2tr\3\2\2\2uv\7,\2\2vw\7\61\2\2wx\3\2\2\2xy\b\23\2\2y&\3\2"+
		"\2\2\7\2UW_r\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}