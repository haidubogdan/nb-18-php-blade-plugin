// Generated from BladeAntlrLexer.g4 by ANTLR 4.13.0

  package org.netbeans.modules.php.blade.syntax.antlr4;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BladeAntlrLexer extends LexerAdaptor {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TOKEN_REF=1, RULE_REF=2, LEXER_CHAR_SET=3, PHP_EXPRESSION_WS=4, PHP_ENTITY_NAME=5, 
		PHP_OPERATORS=6, DOUBLE_QUOTED_STRING=7, SINGLE_QUOTED_STRING=8, ESCAPED_DOUBLE_CURLY=9, 
		BLADE_ESCAPED_ECHO_START=10, BLADE_IF=11, BLADE_ELSE=12, BLADE_ELSEIF=13, 
		BLADE_ENDIF=14, PHP_OPEN=15, HTML_TEXT=16, BLADE_ESCAPED_CONTENT=17, BLADE_ESCAPED_ECHO_END=18, 
		OPEN_IF_LPAREN=19, CLOSE_IF_RPAREN=20, IF_LPAREN=21, IF_RPAREN=22, IF_VARIABLE=23, 
		OTHER_BLADE_IF_EXPRESSION=24, ESCAPED_DIRECTIVE=25;
	public static final int
		INSIDE_ESCAPED_ECHO=1, INSIDE_BLADE_IF_EXPRESSION=2;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "INSIDE_ESCAPED_ECHO", "INSIDE_BLADE_IF_EXPRESSION"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ESCAPED_DOUBLE_CURLY", "BLADE_ESCAPED_ECHO_START", "ESCAPED_DIRECTIVE", 
			"BLADE_IF", "BLADE_ELSE", "BLADE_ELSEIF", "BLADE_ENDIF", "PHP_OPEN", 
			"HTML_TEXT", "WS", "OTHER", "ESC_DOUBLE_QUOTED_STRING", "DOUBLE_QUOTED_STRING_FRAGMENT", 
			"SINGLE_QUOTED_STRING_FRAGMENT", "NAME_STRING", "PHP_OPEN_FRAGMENT", 
			"HTML_TEXT_FRAGMENT", "BLADE_ESCAPED_CONTENT", "BLADE_ESCAPED_ECHO_END", 
			"ERROR_BLADE_ESCAPED", "IF_DOUBLE_QUOTED_STRING", "IF_SINGLE_QUOTED_STRING", 
			"OPEN_IF_LPAREN", "CLOSE_IF_RPAREN", "IF_LPAREN", "IF_RPAREN", "IF_PHP_OPERATORS", 
			"IF_VARIABLE", "IF_PHP_ENTITY_NAME", "IF_WS", "OTHER_BLADE_IF_EXPRESSION"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "'@{{'", "'{{'", 
			"'@if'", "'@else'", "'@elseif'", "'@endif'", null, null, null, null, 
			null, null, null, null, null, null, "'@@'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TOKEN_REF", "RULE_REF", "LEXER_CHAR_SET", "PHP_EXPRESSION_WS", 
			"PHP_ENTITY_NAME", "PHP_OPERATORS", "DOUBLE_QUOTED_STRING", "SINGLE_QUOTED_STRING", 
			"ESCAPED_DOUBLE_CURLY", "BLADE_ESCAPED_ECHO_START", "BLADE_IF", "BLADE_ELSE", 
			"BLADE_ELSEIF", "BLADE_ENDIF", "PHP_OPEN", "HTML_TEXT", "BLADE_ESCAPED_CONTENT", 
			"BLADE_ESCAPED_ECHO_END", "OPEN_IF_LPAREN", "CLOSE_IF_RPAREN", "IF_LPAREN", 
			"IF_RPAREN", "IF_VARIABLE", "OTHER_BLADE_IF_EXPRESSION", "ESCAPED_DIRECTIVE"
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


	public BladeAntlrLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BladeAntlrLexer.g4"; }

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
		case 22:
			OPEN_IF_LPAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 23:
			CLOSE_IF_RPAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 24:
			IF_LPAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 25:
			IF_RPAREN_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void OPEN_IF_LPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			this.increaseRoundParenBalance();
			break;
		}
	}
	private void CLOSE_IF_RPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			this.decreaseRoundParenBalance();
			break;
		}
	}
	private void IF_LPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			this.increaseRoundParenBalance();
			break;
		}
	}
	private void IF_RPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			this.decreaseRoundParenBalance();
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17:
			return BLADE_ESCAPED_CONTENT_sempred((RuleContext)_localctx, predIndex);
		case 22:
			return OPEN_IF_LPAREN_sempred((RuleContext)_localctx, predIndex);
		case 23:
			return CLOSE_IF_RPAREN_sempred((RuleContext)_localctx, predIndex);
		case 24:
			return IF_LPAREN_sempred((RuleContext)_localctx, predIndex);
		case 25:
			return IF_RPAREN_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean BLADE_ESCAPED_CONTENT_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return  this._input.LA(1) == '}' ;
		}
		return true;
	}
	private boolean OPEN_IF_LPAREN_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return this.roundParenBalance == 0;
		}
		return true;
	}
	private boolean CLOSE_IF_RPAREN_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return this.roundParenBalance == 1;
		}
		return true;
	}
	private boolean IF_LPAREN_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return this.roundParenBalance > 0;
		}
		return true;
	}
	private boolean IF_RPAREN_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return this.roundParenBalance > 0;
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0000\u0019\u00e6\u0006\uffff\uffff\u0006\uffff\uffff\u0006\uffff"+
		"\uffff\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002\u0007"+
		"\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005\u0007"+
		"\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007\b"+
		"\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002\f\u0007"+
		"\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f\u0002"+
		"\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012\u0002"+
		"\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015\u0002"+
		"\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018\u0002"+
		"\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b\u0002"+
		"\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0004\bn\b\b\u000b\b\f\bo\u0001\t\u0004\ts\b\t\u000b\t"+
		"\f\tt\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u0082\b\f\n\f\f\f\u0085\t\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u008d\b\r\n\r\f\r\u0090"+
		"\t\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0005\u000e\u0096\b\u000e"+
		"\n\u000e\f\u000e\u0099\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0004\u0010\u00a3"+
		"\b\u0010\u000b\u0010\f\u0010\u00a4\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0004\u0011\u00aa\b\u0011\u000b\u0011\f\u0011\u00ab\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u00d6\b\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001e\u0001\u001e\u0003\u0083\u00a4\u00ab\u0000\u001f\u0003\t\u0005\n"+
		"\u0007\u0019\t\u000b\u000b\f\r\r\u000f\u000e\u0011\u000f\u0013\u0010\u0015"+
		"\u0000\u0017\u0000\u0019\u0000\u001b\u0000\u001d\u0000\u001f\u0000!\u0000"+
		"#\u0000%\u0011\'\u0012)\u0000+\u0000-\u0000/\u00131\u00143\u00155\u0016"+
		"7\u00009\u0017;\u0000=\u0000?\u0018\u0003\u0000\u0001\u0002\u0007\u0002"+
		"\u0000\t\t  \u0002\u0000\"\"\\\\\u0002\u0000\'\'\\\\\u0004\u0000AZ__a"+
		"z\u0080\u8000\ufffe\u0005\u000009AZ__az\u0080\u8000\ufffe\u0002\u0000"+
		"<<?@\u0002\u0000..::\u00e7\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0001%\u0001\u0000\u0000"+
		"\u0000\u0001\'\u0001\u0000\u0000\u0000\u0001)\u0001\u0000\u0000\u0000"+
		"\u0002+\u0001\u0000\u0000\u0000\u0002-\u0001\u0000\u0000\u0000\u0002/"+
		"\u0001\u0000\u0000\u0000\u00021\u0001\u0000\u0000\u0000\u00023\u0001\u0000"+
		"\u0000\u0000\u00025\u0001\u0000\u0000\u0000\u00027\u0001\u0000\u0000\u0000"+
		"\u00029\u0001\u0000\u0000\u0000\u0002;\u0001\u0000\u0000\u0000\u0002="+
		"\u0001\u0000\u0000\u0000\u0002?\u0001\u0000\u0000\u0000\u0003A\u0001\u0000"+
		"\u0000\u0000\u0005E\u0001\u0000\u0000\u0000\u0007J\u0001\u0000\u0000\u0000"+
		"\tO\u0001\u0000\u0000\u0000\u000bU\u0001\u0000\u0000\u0000\r[\u0001\u0000"+
		"\u0000\u0000\u000fc\u0001\u0000\u0000\u0000\u0011j\u0001\u0000\u0000\u0000"+
		"\u0013m\u0001\u0000\u0000\u0000\u0015r\u0001\u0000\u0000\u0000\u0017x"+
		"\u0001\u0000\u0000\u0000\u0019|\u0001\u0000\u0000\u0000\u001b~\u0001\u0000"+
		"\u0000\u0000\u001d\u0088\u0001\u0000\u0000\u0000\u001f\u0093\u0001\u0000"+
		"\u0000\u0000!\u009a\u0001\u0000\u0000\u0000#\u00a0\u0001\u0000\u0000\u0000"+
		"%\u00a9\u0001\u0000\u0000\u0000\'\u00af\u0001\u0000\u0000\u0000)\u00b4"+
		"\u0001\u0000\u0000\u0000+\u00b8\u0001\u0000\u0000\u0000-\u00bc\u0001\u0000"+
		"\u0000\u0000/\u00c0\u0001\u0000\u0000\u00001\u00c4\u0001\u0000\u0000\u0000"+
		"3\u00ca\u0001\u0000\u0000\u00005\u00ce\u0001\u0000\u0000\u00007\u00d5"+
		"\u0001\u0000\u0000\u00009\u00d9\u0001\u0000\u0000\u0000;\u00dc\u0001\u0000"+
		"\u0000\u0000=\u00e0\u0001\u0000\u0000\u0000?\u00e4\u0001\u0000\u0000\u0000"+
		"AB\u0005@\u0000\u0000BC\u0005{\u0000\u0000CD\u0005{\u0000\u0000D\u0004"+
		"\u0001\u0000\u0000\u0000EF\u0005{\u0000\u0000FG\u0005{\u0000\u0000GH\u0001"+
		"\u0000\u0000\u0000HI\u0006\u0001\u0000\u0000I\u0006\u0001\u0000\u0000"+
		"\u0000JK\u0005@\u0000\u0000KL\u0005@\u0000\u0000LM\u0001\u0000\u0000\u0000"+
		"MN\u0006\u0002\u0001\u0000N\b\u0001\u0000\u0000\u0000OP\u0005@\u0000\u0000"+
		"PQ\u0005i\u0000\u0000QR\u0005f\u0000\u0000RS\u0001\u0000\u0000\u0000S"+
		"T\u0006\u0003\u0002\u0000T\n\u0001\u0000\u0000\u0000UV\u0005@\u0000\u0000"+
		"VW\u0005e\u0000\u0000WX\u0005l\u0000\u0000XY\u0005s\u0000\u0000YZ\u0005"+
		"e\u0000\u0000Z\f\u0001\u0000\u0000\u0000[\\\u0005@\u0000\u0000\\]\u0005"+
		"e\u0000\u0000]^\u0005l\u0000\u0000^_\u0005s\u0000\u0000_`\u0005e\u0000"+
		"\u0000`a\u0005i\u0000\u0000ab\u0005f\u0000\u0000b\u000e\u0001\u0000\u0000"+
		"\u0000cd\u0005@\u0000\u0000de\u0005e\u0000\u0000ef\u0005n\u0000\u0000"+
		"fg\u0005d\u0000\u0000gh\u0005i\u0000\u0000hi\u0005f\u0000\u0000i\u0010"+
		"\u0001\u0000\u0000\u0000jk\u0003!\u000f\u0000k\u0012\u0001\u0000\u0000"+
		"\u0000ln\u0003#\u0010\u0000ml\u0001\u0000\u0000\u0000no\u0001\u0000\u0000"+
		"\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000p\u0014\u0001"+
		"\u0000\u0000\u0000qs\u0007\u0000\u0000\u0000rq\u0001\u0000\u0000\u0000"+
		"st\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000"+
		"\u0000uv\u0001\u0000\u0000\u0000vw\u0006\t\u0001\u0000w\u0016\u0001\u0000"+
		"\u0000\u0000xy\t\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z{\u0006\n"+
		"\u0001\u0000{\u0018\u0001\u0000\u0000\u0000|}\u0007\u0001\u0000\u0000"+
		"}\u001a\u0001\u0000\u0000\u0000~\u0083\u0005\"\u0000\u0000\u007f\u0082"+
		"\u0003\u0019\u000b\u0000\u0080\u0082\t\u0000\u0000\u0000\u0081\u007f\u0001"+
		"\u0000\u0000\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0082\u0085\u0001"+
		"\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0083\u0081\u0001"+
		"\u0000\u0000\u0000\u0084\u0086\u0001\u0000\u0000\u0000\u0085\u0083\u0001"+
		"\u0000\u0000\u0000\u0086\u0087\u0005\"\u0000\u0000\u0087\u001c\u0001\u0000"+
		"\u0000\u0000\u0088\u008e\u0005\'\u0000\u0000\u0089\u008d\b\u0002\u0000"+
		"\u0000\u008a\u008b\u0005\\\u0000\u0000\u008b\u008d\t\u0000\u0000\u0000"+
		"\u008c\u0089\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000"+
		"\u008d\u0090\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000"+
		"\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0091\u0001\u0000\u0000\u0000"+
		"\u0090\u008e\u0001\u0000\u0000\u0000\u0091\u0092\u0005\'\u0000\u0000\u0092"+
		"\u001e\u0001\u0000\u0000\u0000\u0093\u0097\u0007\u0003\u0000\u0000\u0094"+
		"\u0096\u0007\u0004\u0000\u0000\u0095\u0094\u0001\u0000\u0000\u0000\u0096"+
		"\u0099\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0097"+
		"\u0098\u0001\u0000\u0000\u0000\u0098 \u0001\u0000\u0000\u0000\u0099\u0097"+
		"\u0001\u0000\u0000\u0000\u009a\u009b\u0005<\u0000\u0000\u009b\u009c\u0005"+
		"?\u0000\u0000\u009c\u009d\u0005p\u0000\u0000\u009d\u009e\u0005h\u0000"+
		"\u0000\u009e\u009f\u0005p\u0000\u0000\u009f\"\u0001\u0000\u0000\u0000"+
		"\u00a0\u00a2\u0005<\u0000\u0000\u00a1\u00a3\t\u0000\u0000\u0000\u00a2"+
		"\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a5\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a7\b\u0005\u0000\u0000\u00a7$"+
		"\u0001\u0000\u0000\u0000\u00a8\u00aa\t\u0000\u0000\u0000\u00a9\u00a8\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001"+
		"\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001"+
		"\u0000\u0000\u0000\u00ad\u00ae\u0004\u0011\u0000\u0000\u00ae&\u0001\u0000"+
		"\u0000\u0000\u00af\u00b0\u0005}\u0000\u0000\u00b0\u00b1\u0005}\u0000\u0000"+
		"\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b3\u0006\u0012\u0003\u0000"+
		"\u00b3(\u0001\u0000\u0000\u0000\u00b4\u00b5\t\u0000\u0000\u0000\u00b5"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b7\u0006\u0013\u0001\u0000\u00b7"+
		"*\u0001\u0000\u0000\u0000\u00b8\u00b9\u0003\u001b\f\u0000\u00b9\u00ba"+
		"\u0001\u0000\u0000\u0000\u00ba\u00bb\u0006\u0014\u0004\u0000\u00bb,\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bd\u0003\u001d\r\u0000\u00bd\u00be\u0001\u0000"+
		"\u0000\u0000\u00be\u00bf\u0006\u0015\u0005\u0000\u00bf.\u0001\u0000\u0000"+
		"\u0000\u00c0\u00c1\u0004\u0016\u0001\u0000\u00c1\u00c2\u0005(\u0000\u0000"+
		"\u00c2\u00c3\u0006\u0016\u0006\u0000\u00c30\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c5\u0004\u0017\u0002\u0000\u00c5\u00c6\u0005)\u0000\u0000\u00c6\u00c7"+
		"\u0006\u0017\u0007\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8\u00c9"+
		"\u0006\u0017\u0003\u0000\u00c92\u0001\u0000\u0000\u0000\u00ca\u00cb\u0004"+
		"\u0018\u0003\u0000\u00cb\u00cc\u0005(\u0000\u0000\u00cc\u00cd\u0006\u0018"+
		"\b\u0000\u00cd4\u0001\u0000\u0000\u0000\u00ce\u00cf\u0004\u0019\u0004"+
		"\u0000\u00cf\u00d0\u0005)\u0000\u0000\u00d0\u00d1\u0006\u0019\t\u0000"+
		"\u00d16\u0001\u0000\u0000\u0000\u00d2\u00d6\u0007\u0006\u0000\u0000\u00d3"+
		"\u00d4\u0005-\u0000\u0000\u00d4\u00d6\u0005>\u0000\u0000\u00d5\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001"+
		"\u0000\u0000\u0000\u00d7\u00d8\u0006\u001a\n\u0000\u00d88\u0001\u0000"+
		"\u0000\u0000\u00d9\u00da\u0005$\u0000\u0000\u00da\u00db\u0003\u001f\u000e"+
		"\u0000\u00db:\u0001\u0000\u0000\u0000\u00dc\u00dd\u0003\u001f\u000e\u0000"+
		"\u00dd\u00de\u0001\u0000\u0000\u0000\u00de\u00df\u0006\u001c\u000b\u0000"+
		"\u00df<\u0001\u0000\u0000\u0000\u00e0\u00e1\u0007\u0000\u0000\u0000\u00e1"+
		"\u00e2\u0001\u0000\u0000\u0000\u00e2\u00e3\u0006\u001d\f\u0000\u00e3>"+
		"\u0001\u0000\u0000\u0000\u00e4\u00e5\t\u0000\u0000\u0000\u00e5@\u0001"+
		"\u0000\u0000\u0000\r\u0000\u0001\u0002ot\u0081\u0083\u008c\u008e\u0097"+
		"\u00a4\u00ab\u00d5\r\u0005\u0001\u0000\u0007\u0010\u0000\u0005\u0002\u0000"+
		"\u0004\u0000\u0000\u0007\u0007\u0000\u0007\b\u0000\u0001\u0016\u0000\u0001"+
		"\u0017\u0001\u0001\u0018\u0002\u0001\u0019\u0003\u0007\u0006\u0000\u0007"+
		"\u0005\u0000\u0007\u0004\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}