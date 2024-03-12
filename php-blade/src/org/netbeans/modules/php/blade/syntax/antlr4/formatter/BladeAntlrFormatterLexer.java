// Generated from java-escape by ANTLR 4.11.1

  package org.netbeans.modules.php.blade.syntax.antlr4.formatter;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BladeAntlrFormatterLexer extends LexerAdaptor {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HTML=1, PHP_CODE=2, PHP_INLINE=3, D_IF=4, D_ENDIF=5, D_FOREACH=6, D_ENDFOREACH=7, 
		NON_PARAM_DIRECTIVE=8, D_INLINE_DIRECTIVE=9, SG_QUOTE=10, DB_QUOTE=11, 
		HTML_OPEN_TAG_START=12, IDENTIFIER=13, EQ=14, SIMPLE_STR=15, HTML_CLOSE_TAG=16, 
		GT_SYMBOL=17, D_PHP=18, AT=19, WS=20, NL=21, OTHER=22, D_ARG_LPAREN=23, 
		D_ARG_RPAREN=24, PHP_EXPR=25, EXIT_EOF=26, D_ENDPHP=27;
	public static final int
		COMMENT=2;
	public static final int
		DIRECTIVE_ARG=1, BLADE_INLINE_PHP=2;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN", "COMMENT"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "DIRECTIVE_ARG", "BLADE_INLINE_PHP"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DirectiveLabel", "DirectiveArgLookup", "PHP_INLINE", "D_ESCAPES", "D_IF", 
			"D_ENDIF", "D_FOREACH", "D_ENDFOREACH", "NON_PARAM_DIRECTIVE", "D_INLINE_DIRECTIVE", 
			"SG_QUOTE", "DB_QUOTE", "HTML_OPEN_TAG_START", "IDENTIFIER", "EQ", "SIMPLE_STR", 
			"HTML_CLOSE_TAG", "GT_SYMBOL", "ESC_DOUBLE_QUOTED_STRING", "DOUBLE_QUOTED_STRING_FRAGMENT", 
			"SINGLE_QUOTED_STRING_FRAGMENT", "D_PHP", "AT", "WS", "NL", "OTHER", 
			"D_ARG_LPAREN", "D_ARG_RPAREN", "D_ARG_NL", "PHP_EXPR", "EXIT_EOF", "D_ENDPHP", 
			"PHP_CODE_GREEDY", "PHP_CODE_COMPLETION"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'@endif'", null, "'@endforeach'", null, 
			null, "'''", "'\"'", null, null, "'='", null, null, "'>'", null, "'@'", 
			null, null, null, "'('", "')'", null, null, "'@endphp'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "HTML", "PHP_CODE", "PHP_INLINE", "D_IF", "D_ENDIF", "D_FOREACH", 
			"D_ENDFOREACH", "NON_PARAM_DIRECTIVE", "D_INLINE_DIRECTIVE", "SG_QUOTE", 
			"DB_QUOTE", "HTML_OPEN_TAG_START", "IDENTIFIER", "EQ", "SIMPLE_STR", 
			"HTML_CLOSE_TAG", "GT_SYMBOL", "D_PHP", "AT", "WS", "NL", "OTHER", "D_ARG_LPAREN", 
			"D_ARG_RPAREN", "PHP_EXPR", "EXIT_EOF", "D_ENDPHP"
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


	public BladeAntlrFormatterLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BladeAntlrFormatterLexer.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 26:
			D_ARG_LPAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 27:
			D_ARG_RPAREN_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void D_ARG_LPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			this.consumeDirectiveArgLParen();
			break;
		}
	}
	private void D_ARG_RPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			this.consumeDirectiveArgRParen();
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return DirectiveArgLookup_sempred((RuleContext)_localctx, predIndex);
		case 21:
			return D_PHP_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean DirectiveArgLookup_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return this._input.LA(1) == '(';
		}
		return true;
	}
	private boolean D_PHP_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return this._input.LA(1) == ' ' || this._input.LA(1) == '\n';
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0000\u001b\u01c8\u0006\uffff\uffff\u0006\uffff\uffff\u0006\uffff"+
		"\uffff\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002\u0007"+
		"\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005\u0007"+
		"\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007\b"+
		"\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002\f\u0007"+
		"\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f\u0002"+
		"\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012\u0002"+
		"\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015\u0002"+
		"\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018\u0002"+
		"\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b\u0002"+
		"\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e\u0002"+
		"\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0001\u0000\u0001\u0000"+
		"\u0005\u0000J\b\u0000\n\u0000\f\u0000M\t\u0000\u0001\u0001\u0005\u0001"+
		"P\b\u0001\n\u0001\f\u0001S\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\\\b\u0002"+
		"\n\u0002\f\u0002_\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"j\b\u0002\n\u0002\f\u0002m\t\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"q\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003z\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003\u0080\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003\u008a\b\u0003\n\u0003\f\u0003\u008d\t\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00fa\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0135\b\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0005\f\u0142\b\f\n\f\f\f\u0145\t\f\u0001\r\u0001\r\u0005\r"+
		"\u0149\b\r\n\r\f\r\u014c\t\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u0152\b\u000f\u0001\u0010\u0001\u0010\u0005\u0010\u0156"+
		"\b\u0010\n\u0010\f\u0010\u0159\t\u0010\u0001\u0010\u0001\u0010\u0005\u0010"+
		"\u015d\b\u0010\n\u0010\f\u0010\u0160\t\u0010\u0001\u0010\u0001\u0010\u0005"+
		"\u0010\u0164\b\u0010\n\u0010\f\u0010\u0167\t\u0010\u0001\u0010\u0005\u0010"+
		"\u016a\b\u0010\n\u0010\f\u0010\u016d\t\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0005\u0013\u0178\b\u0013\n\u0013\f\u0013\u017b\t\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014"+
		"\u0183\b\u0014\n\u0014\f\u0014\u0186\t\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0004\u0017\u0198\b\u0017\u000b\u0017\f\u0017\u0199"+
		"\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0004 \u01bf\b"+
		" \u000b \f \u01c0\u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0003]k\u0179"+
		"\u0000\"\u0003\u0000\u0005\u0000\u0007\u0003\t\u0000\u000b\u0004\r\u0005"+
		"\u000f\u0006\u0011\u0007\u0013\b\u0015\t\u0017\n\u0019\u000b\u001b\f\u001d"+
		"\r\u001f\u000e!\u000f#\u0010%\u0011\'\u0000)\u0000+\u0000-\u0012/\u0013"+
		"1\u00143\u00155\u00167\u00179\u0018;\u0000=\u0019?\u001aA\u001bC\u0000"+
		"E\u0000\u0003\u0000\u0001\u0002\u001d\u0003\u0000AZaz\u0080\u8000\ufffe"+
		"\u0006\u0000..09AZ__az\u0080\u8000\ufffe\u0002\u0000PPpp\u0002\u0000H"+
		"Hhh\u0002\u0000MMmm\u0002\u0000EEee\u0002\u0000DDdd\u0002\u0000IIii\u0002"+
		"\u0000AAaa\u0001\u0000  \u0002\u0000CCcc\u0002\u0000RRrr\u0002\u0000S"+
		"Sss\u0002\u0000TTtt\u0002\u0000OOoo\u0002\u0000NNnn\u0002\u0000UUuu\u0002"+
		"\u0000FFff\u0002\u0000GGgg\u0002\u0000LLll\u0002\u0000YYyy\u0002\u0000"+
		"WWww\u0002\u0000BBbb\u0002\u0000KKkk\u0002\u0000\"\"\\\\\u0002\u0000\'"+
		"\'\\\\\u0002\u0000\t\t  \u0002\u0000\n\n\r\r\u0001\u0000@@\u01e5\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000"+
		"/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001"+
		"\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00017\u0001\u0000\u0000"+
		"\u0000\u00019\u0001\u0000\u0000\u0000\u0001;\u0001\u0000\u0000\u0000\u0001"+
		"=\u0001\u0000\u0000\u0000\u0001?\u0001\u0000\u0000\u0000\u0002A\u0001"+
		"\u0000\u0000\u0000\u0002C\u0001\u0000\u0000\u0000\u0002E\u0001\u0000\u0000"+
		"\u0000\u0003G\u0001\u0000\u0000\u0000\u0005Q\u0001\u0000\u0000\u0000\u0007"+
		"p\u0001\u0000\u0000\u0000\t\u00f9\u0001\u0000\u0000\u0000\u000b\u00fd"+
		"\u0001\u0000\u0000\u0000\r\u0105\u0001\u0000\u0000\u0000\u000f\u010c\u0001"+
		"\u0000\u0000\u0000\u0011\u0119\u0001\u0000\u0000\u0000\u0013\u0134\u0001"+
		"\u0000\u0000\u0000\u0015\u0136\u0001\u0000\u0000\u0000\u0017\u013a\u0001"+
		"\u0000\u0000\u0000\u0019\u013c\u0001\u0000\u0000\u0000\u001b\u013e\u0001"+
		"\u0000\u0000\u0000\u001d\u0146\u0001\u0000\u0000\u0000\u001f\u014d\u0001"+
		"\u0000\u0000\u0000!\u0151\u0001\u0000\u0000\u0000#\u0153\u0001\u0000\u0000"+
		"\u0000%\u0170\u0001\u0000\u0000\u0000\'\u0172\u0001\u0000\u0000\u0000"+
		")\u0174\u0001\u0000\u0000\u0000+\u017e\u0001\u0000\u0000\u0000-\u0189"+
		"\u0001\u0000\u0000\u0000/\u0192\u0001\u0000\u0000\u00001\u0197\u0001\u0000"+
		"\u0000\u00003\u019b\u0001\u0000\u0000\u00005\u019d\u0001\u0000\u0000\u0000"+
		"7\u01a1\u0001\u0000\u0000\u00009\u01a4\u0001\u0000\u0000\u0000;\u01a7"+
		"\u0001\u0000\u0000\u0000=\u01ab\u0001\u0000\u0000\u0000?\u01af\u0001\u0000"+
		"\u0000\u0000A\u01b3\u0001\u0000\u0000\u0000C\u01be\u0001\u0000\u0000\u0000"+
		"E\u01c4\u0001\u0000\u0000\u0000GK\u0007\u0000\u0000\u0000HJ\u0007\u0001"+
		"\u0000\u0000IH\u0001\u0000\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001"+
		"\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000L\u0004\u0001\u0000\u0000"+
		"\u0000MK\u0001\u0000\u0000\u0000NP\u0005 \u0000\u0000ON\u0001\u0000\u0000"+
		"\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000"+
		"\u0000\u0000RT\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000TU\u0004"+
		"\u0001\u0000\u0000U\u0006\u0001\u0000\u0000\u0000VW\u0005<\u0000\u0000"+
		"WX\u0005?\u0000\u0000XY\u0005=\u0000\u0000Y]\u0001\u0000\u0000\u0000Z"+
		"\\\t\u0000\u0000\u0000[Z\u0001\u0000\u0000\u0000\\_\u0001\u0000\u0000"+
		"\u0000]^\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000^`\u0001\u0000"+
		"\u0000\u0000_]\u0001\u0000\u0000\u0000`a\u0005?\u0000\u0000aq\u0005>\u0000"+
		"\u0000bc\u0005<\u0000\u0000cd\u0005?\u0000\u0000de\u0007\u0002\u0000\u0000"+
		"ef\u0007\u0003\u0000\u0000fg\u0007\u0002\u0000\u0000gk\u0001\u0000\u0000"+
		"\u0000hj\t\u0000\u0000\u0000ih\u0001\u0000\u0000\u0000jm\u0001\u0000\u0000"+
		"\u0000kl\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000ln\u0001\u0000"+
		"\u0000\u0000mk\u0001\u0000\u0000\u0000no\u0005?\u0000\u0000oq\u0005>\u0000"+
		"\u0000pV\u0001\u0000\u0000\u0000pb\u0001\u0000\u0000\u0000q\b\u0001\u0000"+
		"\u0000\u0000rs\u0005{\u0000\u0000st\u0005{\u0000\u0000t\u00fa\u0005{\u0000"+
		"\u0000uv\u0005@\u0000\u0000vw\u0005@\u0000\u0000wy\u0001\u0000\u0000\u0000"+
		"xz\u0005@\u0000\u0000yx\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000"+
		"z\u00fa\u0001\u0000\u0000\u0000{|\u0005@\u0000\u0000|}\u0005{\u0000\u0000"+
		"}\u007f\u0001\u0000\u0000\u0000~\u0080\u0005{\u0000\u0000\u007f~\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u00fa\u0001"+
		"\u0000\u0000\u0000\u0081\u0082\u0005@\u0000\u0000\u0082\u0083\u0007\u0004"+
		"\u0000\u0000\u0083\u0084\u0007\u0005\u0000\u0000\u0084\u0085\u0007\u0006"+
		"\u0000\u0000\u0085\u0086\u0007\u0007\u0000\u0000\u0086\u0087\u0007\b\u0000"+
		"\u0000\u0087\u008b\u0001\u0000\u0000\u0000\u0088\u008a\u0007\t\u0000\u0000"+
		"\u0089\u0088\u0001\u0000\u0000\u0000\u008a\u008d\u0001\u0000\u0000\u0000"+
		"\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000"+
		"\u008c\u00fa\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000"+
		"\u008e\u008f\u0005@\u0000\u0000\u008f\u0090\u0007\n\u0000\u0000\u0090"+
		"\u0091\u0007\u0003\u0000\u0000\u0091\u0092\u0007\b\u0000\u0000\u0092\u0093"+
		"\u0007\u000b\u0000\u0000\u0093\u0094\u0007\f\u0000\u0000\u0094\u0095\u0007"+
		"\u0005\u0000\u0000\u0095\u00fa\u0007\r\u0000\u0000\u0096\u0097\u0005@"+
		"\u0000\u0000\u0097\u0098\u0007\u0007\u0000\u0000\u0098\u0099\u0007\u0004"+
		"\u0000\u0000\u0099\u009a\u0007\u0002\u0000\u0000\u009a\u009b\u0007\u000e"+
		"\u0000\u0000\u009b\u009c\u0007\u000b\u0000\u0000\u009c\u00fa\u0007\r\u0000"+
		"\u0000\u009d\u009e\u0005@\u0000\u0000\u009e\u009f\u0007\u000f\u0000\u0000"+
		"\u009f\u00a0\u0007\b\u0000\u0000\u00a0\u00a1\u0007\u0004\u0000\u0000\u00a1"+
		"\u00a2\u0007\u0005\u0000\u0000\u00a2\u00a3\u0007\f\u0000\u0000\u00a3\u00a4"+
		"\u0007\u0002\u0000\u0000\u00a4\u00a5\u0007\b\u0000\u0000\u00a5\u00a6\u0007"+
		"\n\u0000\u0000\u00a6\u00fa\u0007\u0005\u0000\u0000\u00a7\u00a8\u0005@"+
		"\u0000\u0000\u00a8\u00a9\u0007\u0006\u0000\u0000\u00a9\u00aa\u0007\u000e"+
		"\u0000\u0000\u00aa\u00ab\u0007\n\u0000\u0000\u00ab\u00ac\u0007\u0010\u0000"+
		"\u0000\u00ac\u00ad\u0007\u0004\u0000\u0000\u00ad\u00ae\u0007\u0005\u0000"+
		"\u0000\u00ae\u00af\u0007\u000f\u0000\u0000\u00af\u00fa\u0007\r\u0000\u0000"+
		"\u00b0\u00b1\u0005@\u0000\u0000\u00b1\u00b2\u0007\u0011\u0000\u0000\u00b2"+
		"\u00b3\u0007\u000e\u0000\u0000\u00b3\u00b4\u0007\u000f\u0000\u0000\u00b4"+
		"\u00b5\u0007\r\u0000\u0000\u00b5\u00b6\u0005-\u0000\u0000\u00b6\u00b7"+
		"\u0007\u0011\u0000\u0000\u00b7\u00b8\u0007\b\u0000\u0000\u00b8\u00b9\u0007"+
		"\n\u0000\u0000\u00b9\u00fa\u0007\u0005\u0000\u0000\u00ba\u00bb\u0005@"+
		"\u0000\u0000\u00bb\u00bc\u0007\u0002\u0000\u0000\u00bc\u00bd\u0007\b\u0000"+
		"\u0000\u00bd\u00be\u0007\u0012\u0000\u0000\u00be\u00fa\u0007\u0005\u0000"+
		"\u0000\u00bf\u00c0\u0005@\u0000\u0000\u00c0\u00c1\u0007\f\u0000\u0000"+
		"\u00c1\u00c2\u0007\u0010\u0000\u0000\u00c2\u00c3\u0007\u0002\u0000\u0000"+
		"\u00c3\u00c4\u0007\u0002\u0000\u0000\u00c4\u00c5\u0007\u000e\u0000\u0000"+
		"\u00c5\u00c6\u0007\u000b\u0000\u0000\u00c6\u00c7\u0007\r\u0000\u0000\u00c7"+
		"\u00fa\u0007\f\u0000\u0000\u00c8\u00c9\u0005@\u0000\u0000\u00c9\u00ca"+
		"\u0007\u0013\u0000\u0000\u00ca\u00cb\u0007\b\u0000\u0000\u00cb\u00cc\u0007"+
		"\u0014\u0000\u0000\u00cc\u00cd\u0007\u0005\u0000\u0000\u00cd\u00fa\u0007"+
		"\u000b\u0000\u0000\u00ce\u00cf\u0005@\u0000\u0000\u00cf\u00d0\u0007\r"+
		"\u0000\u0000\u00d0\u00d1\u0007\b\u0000\u0000\u00d1\u00d2\u0007\u0007\u0000"+
		"\u0000\u00d2\u00d3\u0007\u0013\u0000\u0000\u00d3\u00d4\u0007\u0015\u0000"+
		"\u0000\u00d4\u00d5\u0007\u0007\u0000\u0000\u00d5\u00d6\u0007\u000f\u0000"+
		"\u0000\u00d6\u00fa\u0007\u0006\u0000\u0000\u00d7\u00d8\u0005@\u0000\u0000"+
		"\u00d8\u00d9\u0007\b\u0000\u0000\u00d9\u00da\u0007\u0002\u0000\u0000\u00da"+
		"\u00db\u0007\u0002\u0000\u0000\u00db\u00dc\u0007\u0013\u0000\u0000\u00dc"+
		"\u00fa\u0007\u0014\u0000\u0000\u00dd\u00de\u0005@\u0000\u0000\u00de\u00df"+
		"\u0005-\u0000\u0000\u00df\u00e0\u0007\u0015\u0000\u0000\u00e0\u00e1\u0007"+
		"\u0005\u0000\u0000\u00e1\u00e2\u0007\u0016\u0000\u0000\u00e2\u00e3\u0007"+
		"\u0017\u0000\u0000\u00e3\u00e4\u0007\u0007\u0000\u0000\u00e4\u00e5\u0007"+
		"\r\u0000\u0000\u00e5\u00e6\u0005-\u0000\u0000\u00e6\u00e7\u0007\u0017"+
		"\u0000\u0000\u00e7\u00e8\u0007\u0005\u0000\u0000\u00e8\u00e9\u0007\u0014"+
		"\u0000\u0000\u00e9\u00ea\u0007\u0011\u0000\u0000\u00ea\u00eb\u0007\u000b"+
		"\u0000\u0000\u00eb\u00ec\u0007\b\u0000\u0000\u00ec\u00ed\u0007\u0004\u0000"+
		"\u0000\u00ed\u00ee\u0007\u0005\u0000\u0000\u00ee\u00fa\u0007\f\u0000\u0000"+
		"\u00ef\u00f0\u0005@\u0000\u0000\u00f0\u00f1\u0007\u0017\u0000\u0000\u00f1"+
		"\u00f2\u0007\u0005\u0000\u0000\u00f2\u00f3\u0007\u0014\u0000\u0000\u00f3"+
		"\u00f4\u0007\u0011\u0000\u0000\u00f4\u00f5\u0007\u000b\u0000\u0000\u00f5"+
		"\u00f6\u0007\b\u0000\u0000\u00f6\u00f7\u0007\u0004\u0000\u0000\u00f7\u00f8"+
		"\u0007\u0005\u0000\u0000\u00f8\u00fa\u0007\f\u0000\u0000\u00f9r\u0001"+
		"\u0000\u0000\u0000\u00f9u\u0001\u0000\u0000\u0000\u00f9{\u0001\u0000\u0000"+
		"\u0000\u00f9\u0081\u0001\u0000\u0000\u0000\u00f9\u008e\u0001\u0000\u0000"+
		"\u0000\u00f9\u0096\u0001\u0000\u0000\u0000\u00f9\u009d\u0001\u0000\u0000"+
		"\u0000\u00f9\u00a7\u0001\u0000\u0000\u0000\u00f9\u00b0\u0001\u0000\u0000"+
		"\u0000\u00f9\u00ba\u0001\u0000\u0000\u0000\u00f9\u00bf\u0001\u0000\u0000"+
		"\u0000\u00f9\u00c8\u0001\u0000\u0000\u0000\u00f9\u00ce\u0001\u0000\u0000"+
		"\u0000\u00f9\u00d7\u0001\u0000\u0000\u0000\u00f9\u00dd\u0001\u0000\u0000"+
		"\u0000\u00f9\u00ef\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fc\u0006\u0003\u0000\u0000\u00fc\n\u0001\u0000\u0000\u0000"+
		"\u00fd\u00fe\u0005@\u0000\u0000\u00fe\u00ff\u0007\u0007\u0000\u0000\u00ff"+
		"\u0100\u0007\u0011\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000\u0101"+
		"\u0102\u0003\u0005\u0001\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103"+
		"\u0104\u0006\u0004\u0001\u0000\u0104\f\u0001\u0000\u0000\u0000\u0105\u0106"+
		"\u0005@\u0000\u0000\u0106\u0107\u0007\u0005\u0000\u0000\u0107\u0108\u0007"+
		"\u000f\u0000\u0000\u0108\u0109\u0007\u0006\u0000\u0000\u0109\u010a\u0007"+
		"\u0007\u0000\u0000\u010a\u010b\u0007\u0011\u0000\u0000\u010b\u000e\u0001"+
		"\u0000\u0000\u0000\u010c\u010d\u0005@\u0000\u0000\u010d\u010e\u0007\u0011"+
		"\u0000\u0000\u010e\u010f\u0007\u000e\u0000\u0000\u010f\u0110\u0007\u000b"+
		"\u0000\u0000\u0110\u0111\u0007\u0005\u0000\u0000\u0111\u0112\u0007\b\u0000"+
		"\u0000\u0112\u0113\u0007\n\u0000\u0000\u0113\u0114\u0007\u0003\u0000\u0000"+
		"\u0114\u0115\u0001\u0000\u0000\u0000\u0115\u0116\u0003\u0005\u0001\u0000"+
		"\u0116\u0117\u0001\u0000\u0000\u0000\u0117\u0118\u0006\u0006\u0001\u0000"+
		"\u0118\u0010\u0001\u0000\u0000\u0000\u0119\u011a\u0005@\u0000\u0000\u011a"+
		"\u011b\u0007\u0005\u0000\u0000\u011b\u011c\u0007\u000f\u0000\u0000\u011c"+
		"\u011d\u0007\u0006\u0000\u0000\u011d\u011e\u0007\u0011\u0000\u0000\u011e"+
		"\u011f\u0007\u000e\u0000\u0000\u011f\u0120\u0007\u000b\u0000\u0000\u0120"+
		"\u0121\u0007\u0005\u0000\u0000\u0121\u0122\u0007\b\u0000\u0000\u0122\u0123"+
		"\u0007\n\u0000\u0000\u0123\u0124\u0007\u0003\u0000\u0000\u0124\u0012\u0001"+
		"\u0000\u0000\u0000\u0125\u0126\u0005@\u0000\u0000\u0126\u0127\u0007\n"+
		"\u0000\u0000\u0127\u0128\u0007\u000e\u0000\u0000\u0128\u0129\u0007\u000f"+
		"\u0000\u0000\u0129\u012a\u0007\r\u0000\u0000\u012a\u012b\u0007\u0007\u0000"+
		"\u0000\u012b\u012c\u0007\u000f\u0000\u0000\u012c\u012d\u0007\u0010\u0000"+
		"\u0000\u012d\u0135\u0007\u0005\u0000\u0000\u012e\u012f\u0005@\u0000\u0000"+
		"\u012f\u0130\u0007\u0016\u0000\u0000\u0130\u0131\u0007\u000b\u0000\u0000"+
		"\u0131\u0132\u0007\u0005\u0000\u0000\u0132\u0133\u0007\b\u0000\u0000\u0133"+
		"\u0135\u0007\u0017\u0000\u0000\u0134\u0125\u0001\u0000\u0000\u0000\u0134"+
		"\u012e\u0001\u0000\u0000\u0000\u0135\u0014\u0001\u0000\u0000\u0000\u0136"+
		"\u0137\u0005@\u0000\u0000\u0137\u0138\u0003\u0003\u0000\u0000\u0138\u0139"+
		"\u0003\u0005\u0001\u0000\u0139\u0016\u0001\u0000\u0000\u0000\u013a\u013b"+
		"\u0005\'\u0000\u0000\u013b\u0018\u0001\u0000\u0000\u0000\u013c\u013d\u0005"+
		"\"\u0000\u0000\u013d\u001a\u0001\u0000\u0000\u0000\u013e\u013f\u0005<"+
		"\u0000\u0000\u013f\u0143\u0007\u0000\u0000\u0000\u0140\u0142\u0007\u0001"+
		"\u0000\u0000\u0141\u0140\u0001\u0000\u0000\u0000\u0142\u0145\u0001\u0000"+
		"\u0000\u0000\u0143\u0141\u0001\u0000\u0000\u0000\u0143\u0144\u0001\u0000"+
		"\u0000\u0000\u0144\u001c\u0001\u0000\u0000\u0000\u0145\u0143\u0001\u0000"+
		"\u0000\u0000\u0146\u014a\u0007\u0000\u0000\u0000\u0147\u0149\u0007\u0001"+
		"\u0000\u0000\u0148\u0147\u0001\u0000\u0000\u0000\u0149\u014c\u0001\u0000"+
		"\u0000\u0000\u014a\u0148\u0001\u0000\u0000\u0000\u014a\u014b\u0001\u0000"+
		"\u0000\u0000\u014b\u001e\u0001\u0000\u0000\u0000\u014c\u014a\u0001\u0000"+
		"\u0000\u0000\u014d\u014e\u0005=\u0000\u0000\u014e \u0001\u0000\u0000\u0000"+
		"\u014f\u0152\u0003)\u0013\u0000\u0150\u0152\u0003+\u0014\u0000\u0151\u014f"+
		"\u0001\u0000\u0000\u0000\u0151\u0150\u0001\u0000\u0000\u0000\u0152\"\u0001"+
		"\u0000\u0000\u0000\u0153\u0157\u0005<\u0000\u0000\u0154\u0156\u0005 \u0000"+
		"\u0000\u0155\u0154\u0001\u0000\u0000\u0000\u0156\u0159\u0001\u0000\u0000"+
		"\u0000\u0157\u0155\u0001\u0000\u0000\u0000\u0157\u0158\u0001\u0000\u0000"+
		"\u0000\u0158\u015a\u0001\u0000\u0000\u0000\u0159\u0157\u0001\u0000\u0000"+
		"\u0000\u015a\u015e\u0005/\u0000\u0000\u015b\u015d\u0005 \u0000\u0000\u015c"+
		"\u015b\u0001\u0000\u0000\u0000\u015d\u0160\u0001\u0000\u0000\u0000\u015e"+
		"\u015c\u0001\u0000\u0000\u0000\u015e\u015f\u0001\u0000\u0000\u0000\u015f"+
		"\u0161\u0001\u0000\u0000\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0161"+
		"\u0165\u0007\u0000\u0000\u0000\u0162\u0164\u0007\u0001\u0000\u0000\u0163"+
		"\u0162\u0001\u0000\u0000\u0000\u0164\u0167\u0001\u0000\u0000\u0000\u0165"+
		"\u0163\u0001\u0000\u0000\u0000\u0165\u0166\u0001\u0000\u0000\u0000\u0166"+
		"\u016b\u0001\u0000\u0000\u0000\u0167\u0165\u0001\u0000\u0000\u0000\u0168"+
		"\u016a\u0005 \u0000\u0000\u0169\u0168\u0001\u0000\u0000\u0000\u016a\u016d"+
		"\u0001\u0000\u0000\u0000\u016b\u0169\u0001\u0000\u0000\u0000\u016b\u016c"+
		"\u0001\u0000\u0000\u0000\u016c\u016e\u0001\u0000\u0000\u0000\u016d\u016b"+
		"\u0001\u0000\u0000\u0000\u016e\u016f\u0005>\u0000\u0000\u016f$\u0001\u0000"+
		"\u0000\u0000\u0170\u0171\u0005>\u0000\u0000\u0171&\u0001\u0000\u0000\u0000"+
		"\u0172\u0173\u0007\u0018\u0000\u0000\u0173(\u0001\u0000\u0000\u0000\u0174"+
		"\u0179\u0005\"\u0000\u0000\u0175\u0178\u0003\'\u0012\u0000\u0176\u0178"+
		"\t\u0000\u0000\u0000\u0177\u0175\u0001\u0000\u0000\u0000\u0177\u0176\u0001"+
		"\u0000\u0000\u0000\u0178\u017b\u0001\u0000\u0000\u0000\u0179\u017a\u0001"+
		"\u0000\u0000\u0000\u0179\u0177\u0001\u0000\u0000\u0000\u017a\u017c\u0001"+
		"\u0000\u0000\u0000\u017b\u0179\u0001\u0000\u0000\u0000\u017c\u017d\u0005"+
		"\"\u0000\u0000\u017d*\u0001\u0000\u0000\u0000\u017e\u0184\u0005\'\u0000"+
		"\u0000\u017f\u0183\b\u0019\u0000\u0000\u0180\u0181\u0005\\\u0000\u0000"+
		"\u0181\u0183\t\u0000\u0000\u0000\u0182\u017f\u0001\u0000\u0000\u0000\u0182"+
		"\u0180\u0001\u0000\u0000\u0000\u0183\u0186\u0001\u0000\u0000\u0000\u0184"+
		"\u0182\u0001\u0000\u0000\u0000\u0184\u0185\u0001\u0000\u0000\u0000\u0185"+
		"\u0187\u0001\u0000\u0000\u0000\u0186\u0184\u0001\u0000\u0000\u0000\u0187"+
		"\u0188\u0005\'\u0000\u0000\u0188,\u0001\u0000\u0000\u0000\u0189\u018a"+
		"\u0005@\u0000\u0000\u018a\u018b\u0007\u0002\u0000\u0000\u018b\u018c\u0007"+
		"\u0003\u0000\u0000\u018c\u018d\u0007\u0002\u0000\u0000\u018d\u018e\u0001"+
		"\u0000\u0000\u0000\u018e\u018f\u0004\u0015\u0001\u0000\u018f\u0190\u0001"+
		"\u0000\u0000\u0000\u0190\u0191\u0006\u0015\u0002\u0000\u0191.\u0001\u0000"+
		"\u0000\u0000\u0192\u0193\u0005@\u0000\u0000\u0193\u0194\u0001\u0000\u0000"+
		"\u0000\u0194\u0195\u0006\u0016\u0003\u0000\u01950\u0001\u0000\u0000\u0000"+
		"\u0196\u0198\u0007\u001a\u0000\u0000\u0197\u0196\u0001\u0000\u0000\u0000"+
		"\u0198\u0199\u0001\u0000\u0000\u0000\u0199\u0197\u0001\u0000\u0000\u0000"+
		"\u0199\u019a\u0001\u0000\u0000\u0000\u019a2\u0001\u0000\u0000\u0000\u019b"+
		"\u019c\u0007\u001b\u0000\u0000\u019c4\u0001\u0000\u0000\u0000\u019d\u019e"+
		"\t\u0000\u0000\u0000\u019e\u019f\u0001\u0000\u0000\u0000\u019f\u01a0\u0006"+
		"\u0019\u0003\u0000\u01a06\u0001\u0000\u0000\u0000\u01a1\u01a2\u0005(\u0000"+
		"\u0000\u01a2\u01a3\u0006\u001a\u0004\u0000\u01a38\u0001\u0000\u0000\u0000"+
		"\u01a4\u01a5\u0005)\u0000\u0000\u01a5\u01a6\u0006\u001b\u0005\u0000\u01a6"+
		":\u0001\u0000\u0000\u0000\u01a7\u01a8\u0007\u001b\u0000\u0000\u01a8\u01a9"+
		"\u0001\u0000\u0000\u0000\u01a9\u01aa\u0006\u001c\u0006\u0000\u01aa<\u0001"+
		"\u0000\u0000\u0000\u01ab\u01ac\t\u0000\u0000\u0000\u01ac\u01ad\u0001\u0000"+
		"\u0000\u0000\u01ad\u01ae\u0006\u001d\u0003\u0000\u01ae>\u0001\u0000\u0000"+
		"\u0000\u01af\u01b0\u0005\u0000\u0000\u0001\u01b0\u01b1\u0001\u0000\u0000"+
		"\u0000\u01b1\u01b2\u0006\u001e\u0007\u0000\u01b2@\u0001\u0000\u0000\u0000"+
		"\u01b3\u01b4\u0005@\u0000\u0000\u01b4\u01b5\u0007\u0005\u0000\u0000\u01b5"+
		"\u01b6\u0007\u000f\u0000\u0000\u01b6\u01b7\u0007\u0006\u0000\u0000\u01b7"+
		"\u01b8\u0007\u0002\u0000\u0000\u01b8\u01b9\u0007\u0003\u0000\u0000\u01b9"+
		"\u01ba\u0007\u0002\u0000\u0000\u01ba\u01bb\u0001\u0000\u0000\u0000\u01bb"+
		"\u01bc\u0006\u001f\u0007\u0000\u01bcB\u0001\u0000\u0000\u0000\u01bd\u01bf"+
		"\b\u001c\u0000\u0000\u01be\u01bd\u0001\u0000\u0000\u0000\u01bf\u01c0\u0001"+
		"\u0000\u0000\u0000\u01c0\u01be\u0001\u0000\u0000\u0000\u01c0\u01c1\u0001"+
		"\u0000\u0000\u0000\u01c1\u01c2\u0001\u0000\u0000\u0000\u01c2\u01c3\u0006"+
		" \b\u0000\u01c3D\u0001\u0000\u0000\u0000\u01c4\u01c5\t\u0000\u0000\u0000"+
		"\u01c5\u01c6\u0001\u0000\u0000\u0000\u01c6\u01c7\u0006!\b\u0000\u01c7"+
		"F\u0001\u0000\u0000\u0000\u001b\u0000\u0001\u0002KQ]kpy\u007f\u008b\u00f9"+
		"\u0134\u0143\u014a\u0151\u0157\u015e\u0165\u016b\u0177\u0179\u0182\u0184"+
		"\u0197\u0199\u01c0\t\u0007\u0001\u0000\u0005\u0001\u0000\u0005\u0002\u0000"+
		"\u0006\u0000\u0000\u0001\u001a\u0000\u0001\u001b\u0001\u0007\u0015\u0000"+
		"\u0004\u0000\u0000\u0007\u0002\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}