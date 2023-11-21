// Generated from BladeAntlrColoringLexer.g4 by ANTLR 4.13.0

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
public class BladeAntlrColoringLexer extends LexerAdaptor {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TOKEN_REF=1, RULE_REF=2, LEXER_CHAR_SET=3, PHP_EXPRESSION_WS=4, PHP_ENTITY_NAME=5, 
		PHP_OPERATORS=6, BLADE_DIRECTIVE=7, BLADE_DIRECTIVE_NO_EXPRESSION=8, DOUBLE_QUOTED_STRING=9, 
		SINGLE_QUOTED_STRING=10, BLADE_PHP_CONTENT=11, ERROR=12, ESCAPED_DOUBLE_CURLY=13, 
		BLADE_ESCAPED_ECHO_START=14, BLADE_CONDITIONALS_START=15, BLADE_ELSE_IF=16, 
		BLADE_ELSE=17, BLADE_ENDIF=18, BLADE_INCLUDE=19, PHP_OPEN=20, HTML_TEXT=21, 
		BLADE_ESCAPED_ECHO_END=22, INC_VARIABLE=23, OPEN_INC_LPAREN=24, CLOSE_INC_RPAREN=25, 
		INC_LPAREN=26, INC_RPAREN=27, IF_VARIABLE=28, OPEN_IF_LPAREN=29, CLOSE_IF_RPAREN=30, 
		IF_LPAREN=31, IF_RPAREN=32, ESCAPED_DIRECTIVE=33;
	public static final int
		INSIDE_ESCAPED_ECHO=1, INSIDE_INCLUDE_EXPRESSION=2, INSIDE_BLADE_IF_EXPRESSION=3;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "INSIDE_ESCAPED_ECHO", "INSIDE_INCLUDE_EXPRESSION", "INSIDE_BLADE_IF_EXPRESSION"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DOUBLE_QUOTED_STRING_FRAGMENT", "SINGLE_QUOTED_STRING_FRAGMENT", "NAME_STRING", 
			"BLADE_CONDITIONAL_START_FRAGMENTS", "PHP_OPEN_FRAGMENT", "HTML_TEXT_FRAGMENT", 
			"ESCAPED_DOUBLE_CURLY", "BLADE_ESCAPED_ECHO_START", "CSS_DIRECTIVES", 
			"ESCAPED_DIRECTIVE", "BLADE_CONDITIONALS_START", "BLADE_ELSE_IF", "BLADE_ELSE", 
			"BLADE_ENDIF", "BLADE_INCLUDE", "PHP_OPEN", "HTML_TEXT", "NL", "WS", 
			"OTHER", "BLADE_ESCAPED_CONTENT", "BLADE_ESCAPED_ECHO_END", "NL_ECHO", 
			"ERROR_BLADE_ESCAPED", "INC_VARIABLE", "INC_DOUBLE_QUOTED_STRING", "INC_SINGLE_QUOTED_STRING", 
			"OPEN_INC_LPAREN", "CLOSE_INC_RPAREN", "INC_LPAREN", "INC_RPAREN", "INC_WS", 
			"INC_EXIT_RPAREN", "OTHER_BLADE_INC_EXPRESSION", "IF_VARIABLE", "IF_DOUBLE_QUOTED_STRING", 
			"IF_SINGLE_QUOTED_STRING", "OPEN_IF_LPAREN", "CLOSE_IF_RPAREN", "IF_LPAREN", 
			"IF_RPAREN", "IF_PHP_OPERATORS", "IF_PHP_LOGICAL_OPERATORS", "IF_PHP_ENTITY_NAME", 
			"IF_WS", "IF_EXIT_RPAREN", "OTHER_BLADE_IF_EXPRESSION"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "'@{{'", "'{{'", null, "'@elseif'", "'@else'", "'@endif'", "'@include'", 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "'@@'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TOKEN_REF", "RULE_REF", "LEXER_CHAR_SET", "PHP_EXPRESSION_WS", 
			"PHP_ENTITY_NAME", "PHP_OPERATORS", "BLADE_DIRECTIVE", "BLADE_DIRECTIVE_NO_EXPRESSION", 
			"DOUBLE_QUOTED_STRING", "SINGLE_QUOTED_STRING", "BLADE_PHP_CONTENT", 
			"ERROR", "ESCAPED_DOUBLE_CURLY", "BLADE_ESCAPED_ECHO_START", "BLADE_CONDITIONALS_START", 
			"BLADE_ELSE_IF", "BLADE_ELSE", "BLADE_ENDIF", "BLADE_INCLUDE", "PHP_OPEN", 
			"HTML_TEXT", "BLADE_ESCAPED_ECHO_END", "INC_VARIABLE", "OPEN_INC_LPAREN", 
			"CLOSE_INC_RPAREN", "INC_LPAREN", "INC_RPAREN", "IF_VARIABLE", "OPEN_IF_LPAREN", 
			"CLOSE_IF_RPAREN", "IF_LPAREN", "IF_RPAREN", "ESCAPED_DIRECTIVE"
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


	public BladeAntlrColoringLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BladeAntlrColoringLexer.g4"; }

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
		case 27:
			OPEN_INC_LPAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 28:
			CLOSE_INC_RPAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 29:
			INC_LPAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 30:
			INC_RPAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 37:
			OPEN_IF_LPAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 38:
			CLOSE_IF_RPAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 39:
			IF_LPAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 40:
			IF_RPAREN_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void OPEN_INC_LPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			this.increaseRoundParenBalance();
			break;
		}
	}
	private void CLOSE_INC_RPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			this.decreaseRoundParenBalance();
			break;
		}
	}
	private void INC_LPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			this.increaseRoundParenBalance();
			break;
		}
	}
	private void INC_RPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			this.decreaseRoundParenBalance();
			break;
		}
	}
	private void OPEN_IF_LPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			this.increaseRoundParenBalance();
			break;
		}
	}
	private void CLOSE_IF_RPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			this.decreaseRoundParenBalance();
			break;
		}
	}
	private void IF_LPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			this.increaseRoundParenBalance();
			break;
		}
	}
	private void IF_RPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:
			this.decreaseRoundParenBalance();
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return HTML_TEXT_FRAGMENT_sempred((RuleContext)_localctx, predIndex);
		case 20:
			return BLADE_ESCAPED_CONTENT_sempred((RuleContext)_localctx, predIndex);
		case 27:
			return OPEN_INC_LPAREN_sempred((RuleContext)_localctx, predIndex);
		case 28:
			return CLOSE_INC_RPAREN_sempred((RuleContext)_localctx, predIndex);
		case 29:
			return INC_LPAREN_sempred((RuleContext)_localctx, predIndex);
		case 30:
			return INC_RPAREN_sempred((RuleContext)_localctx, predIndex);
		case 32:
			return INC_EXIT_RPAREN_sempred((RuleContext)_localctx, predIndex);
		case 37:
			return OPEN_IF_LPAREN_sempred((RuleContext)_localctx, predIndex);
		case 38:
			return CLOSE_IF_RPAREN_sempred((RuleContext)_localctx, predIndex);
		case 39:
			return IF_LPAREN_sempred((RuleContext)_localctx, predIndex);
		case 40:
			return IF_RPAREN_sempred((RuleContext)_localctx, predIndex);
		case 45:
			return IF_EXIT_RPAREN_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean HTML_TEXT_FRAGMENT_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return  this._input.LA(1) != '?';
		case 1:
			return  this._input.LA(1) != '@' && this._input.LA(1) != '<' ;
		}
		return true;
	}
	private boolean BLADE_ESCAPED_CONTENT_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return  this._input.LA(1) == '}' && this._input.LA(2) == '}' ;
		}
		return true;
	}
	private boolean OPEN_INC_LPAREN_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return this.roundParenBalance == 0;
		}
		return true;
	}
	private boolean CLOSE_INC_RPAREN_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return this.roundParenBalance == 1;
		}
		return true;
	}
	private boolean INC_LPAREN_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return this.roundParenBalance > 0;
		}
		return true;
	}
	private boolean INC_RPAREN_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return this.roundParenBalance > 0;
		}
		return true;
	}
	private boolean INC_EXIT_RPAREN_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return this.roundParenBalance == 0;
		}
		return true;
	}
	private boolean OPEN_IF_LPAREN_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return this.roundParenBalance == 0;
		}
		return true;
	}
	private boolean CLOSE_IF_RPAREN_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return this.roundParenBalance == 1;
		}
		return true;
	}
	private boolean IF_LPAREN_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return this.roundParenBalance > 0;
		}
		return true;
	}
	private boolean IF_RPAREN_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return this.roundParenBalance > 0;
		}
		return true;
	}
	private boolean IF_EXIT_RPAREN_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return this.roundParenBalance == 0;
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0000!\u01a2\u0006\uffff\uffff\u0006\uffff\uffff\u0006\uffff\uffff"+
		"\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		"f\b\u0000\n\u0000\f\u0000i\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001q\b\u0001\n\u0001\f\u0001"+
		"t\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0005\u0002"+
		"z\b\u0002\n\u0002\f\u0002}\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u0086\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005\u0091\b\u0005\u000b\u0005"+
		"\f\u0005\u0092\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\b\u00d8\b\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0004\u0010\u010a\b\u0010\u000b\u0010\f\u0010\u010b\u0001"+
		"\u0010\u0003\u0010\u010f\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0004\u0012\u0116\b\u0012\u000b\u0012\f\u0012\u0117"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0004\u0014\u0121\b\u0014\u000b\u0014\f\u0014\u0122\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0003"+
		"\u001f\u0155\b\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001"+
		"#\u0001#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001$\u0001%\u0001%\u0001"+
		"%\u0001%\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001)\u0001)\u0001)\u0003)\u0183"+
		"\b)\u0001)\u0001)\u0001*\u0001*\u0001*\u0001*\u0001*\u0003*\u018c\b*\u0001"+
		"*\u0001*\u0001+\u0001+\u0001+\u0001+\u0001,\u0003,\u0195\b,\u0001,\u0001"+
		",\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001.\u0001.\u0001.\u0001"+
		".\u0003g\u0092\u0122\u0000/\u0004\u0000\u0006\u0000\b\u0000\n\u0000\f"+
		"\u0000\u000e\u0000\u0010\r\u0012\u000e\u0014\u0000\u0016!\u0018\u000f"+
		"\u001a\u0010\u001c\u0011\u001e\u0012 \u0013\"\u0014$\u0015&\u0000(\u0000"+
		"*\u0000,\u0000.\u00160\u00002\u00004\u00176\u00008\u0000:\u0018<\u0019"+
		">\u001a@\u001bB\u0000D\u0000F\u0000H\u001cJ\u0000L\u0000N\u001dP\u001e"+
		"R\u001fT V\u0000X\u0000Z\u0000\\\u0000^\u0000`\u0000\u0004\u0000\u0001"+
		"\u0002\u0003\t\u0002\u0000\"\"\\\\\u0002\u0000\'\'\\\\\u0004\u0000AZ_"+
		"_az\u0080\u8000\ufffe\u0005\u000009AZ__az\u0080\u8000\ufffe\u0002\u0000"+
		"\n\n\r\r\u0002\u0000\t\t  \u0001\u0000$$\u0003\u0000\t\n\r\r  \u0002\u0000"+
		"..::\u01ab\u0000\u0010\u0001\u0000\u0000\u0000\u0000\u0012\u0001\u0000"+
		"\u0000\u0000\u0000\u0014\u0001\u0000\u0000\u0000\u0000\u0016\u0001\u0000"+
		"\u0000\u0000\u0000\u0018\u0001\u0000\u0000\u0000\u0000\u001a\u0001\u0000"+
		"\u0000\u0000\u0000\u001c\u0001\u0000\u0000\u0000\u0000\u001e\u0001\u0000"+
		"\u0000\u0000\u0000 \u0001\u0000\u0000\u0000\u0000\"\u0001\u0000\u0000"+
		"\u0000\u0000$\u0001\u0000\u0000\u0000\u0000&\u0001\u0000\u0000\u0000\u0000"+
		"(\u0001\u0000\u0000\u0000\u0000*\u0001\u0000\u0000\u0000\u0001,\u0001"+
		"\u0000\u0000\u0000\u0001.\u0001\u0000\u0000\u0000\u00010\u0001\u0000\u0000"+
		"\u0000\u00012\u0001\u0000\u0000\u0000\u00024\u0001\u0000\u0000\u0000\u0002"+
		"6\u0001\u0000\u0000\u0000\u00028\u0001\u0000\u0000\u0000\u0002:\u0001"+
		"\u0000\u0000\u0000\u0002<\u0001\u0000\u0000\u0000\u0002>\u0001\u0000\u0000"+
		"\u0000\u0002@\u0001\u0000\u0000\u0000\u0002B\u0001\u0000\u0000\u0000\u0002"+
		"D\u0001\u0000\u0000\u0000\u0002F\u0001\u0000\u0000\u0000\u0003H\u0001"+
		"\u0000\u0000\u0000\u0003J\u0001\u0000\u0000\u0000\u0003L\u0001\u0000\u0000"+
		"\u0000\u0003N\u0001\u0000\u0000\u0000\u0003P\u0001\u0000\u0000\u0000\u0003"+
		"R\u0001\u0000\u0000\u0000\u0003T\u0001\u0000\u0000\u0000\u0003V\u0001"+
		"\u0000\u0000\u0000\u0003X\u0001\u0000\u0000\u0000\u0003Z\u0001\u0000\u0000"+
		"\u0000\u0003\\\u0001\u0000\u0000\u0000\u0003^\u0001\u0000\u0000\u0000"+
		"\u0003`\u0001\u0000\u0000\u0000\u0004b\u0001\u0000\u0000\u0000\u0006l"+
		"\u0001\u0000\u0000\u0000\bw\u0001\u0000\u0000\u0000\n\u0085\u0001\u0000"+
		"\u0000\u0000\f\u0087\u0001\u0000\u0000\u0000\u000e\u008d\u0001\u0000\u0000"+
		"\u0000\u0010\u0097\u0001\u0000\u0000\u0000\u0012\u009b\u0001\u0000\u0000"+
		"\u0000\u0014\u00d7\u0001\u0000\u0000\u0000\u0016\u00db\u0001\u0000\u0000"+
		"\u0000\u0018\u00e0\u0001\u0000\u0000\u0000\u001a\u00e4\u0001\u0000\u0000"+
		"\u0000\u001c\u00ee\u0001\u0000\u0000\u0000\u001e\u00f4\u0001\u0000\u0000"+
		"\u0000 \u00fb\u0001\u0000\u0000\u0000\"\u0106\u0001\u0000\u0000\u0000"+
		"$\u010e\u0001\u0000\u0000\u0000&\u0110\u0001\u0000\u0000\u0000(\u0115"+
		"\u0001\u0000\u0000\u0000*\u011b\u0001\u0000\u0000\u0000,\u0120\u0001\u0000"+
		"\u0000\u0000.\u0128\u0001\u0000\u0000\u00000\u012d\u0001\u0000\u0000\u0000"+
		"2\u0132\u0001\u0000\u0000\u00004\u0136\u0001\u0000\u0000\u00006\u0139"+
		"\u0001\u0000\u0000\u00008\u013d\u0001\u0000\u0000\u0000:\u0141\u0001\u0000"+
		"\u0000\u0000<\u0145\u0001\u0000\u0000\u0000>\u014b\u0001\u0000\u0000\u0000"+
		"@\u014f\u0001\u0000\u0000\u0000B\u0154\u0001\u0000\u0000\u0000D\u0158"+
		"\u0001\u0000\u0000\u0000F\u015e\u0001\u0000\u0000\u0000H\u0162\u0001\u0000"+
		"\u0000\u0000J\u0165\u0001\u0000\u0000\u0000L\u0169\u0001\u0000\u0000\u0000"+
		"N\u016d\u0001\u0000\u0000\u0000P\u0171\u0001\u0000\u0000\u0000R\u0177"+
		"\u0001\u0000\u0000\u0000T\u017b\u0001\u0000\u0000\u0000V\u0182\u0001\u0000"+
		"\u0000\u0000X\u018b\u0001\u0000\u0000\u0000Z\u018f\u0001\u0000\u0000\u0000"+
		"\\\u0194\u0001\u0000\u0000\u0000^\u0198\u0001\u0000\u0000\u0000`\u019e"+
		"\u0001\u0000\u0000\u0000bg\u0005\"\u0000\u0000cf\u0007\u0000\u0000\u0000"+
		"df\t\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000ed\u0001\u0000\u0000\u0000"+
		"fi\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000"+
		"\u0000hj\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000jk\u0005\"\u0000"+
		"\u0000k\u0005\u0001\u0000\u0000\u0000lr\u0005\'\u0000\u0000mq\b\u0001"+
		"\u0000\u0000no\u0005\\\u0000\u0000oq\t\u0000\u0000\u0000pm\u0001\u0000"+
		"\u0000\u0000pn\u0001\u0000\u0000\u0000qt\u0001\u0000\u0000\u0000rp\u0001"+
		"\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000su\u0001\u0000\u0000\u0000"+
		"tr\u0001\u0000\u0000\u0000uv\u0005\'\u0000\u0000v\u0007\u0001\u0000\u0000"+
		"\u0000w{\u0007\u0002\u0000\u0000xz\u0007\u0003\u0000\u0000yx\u0001\u0000"+
		"\u0000\u0000z}\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001"+
		"\u0000\u0000\u0000|\t\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000"+
		"~\u007f\u0005@\u0000\u0000\u007f\u0080\u0005i\u0000\u0000\u0080\u0086"+
		"\u0005f\u0000\u0000\u0081\u0082\u0005@\u0000\u0000\u0082\u0083\u0005c"+
		"\u0000\u0000\u0083\u0084\u0005a\u0000\u0000\u0084\u0086\u0005n\u0000\u0000"+
		"\u0085~\u0001\u0000\u0000\u0000\u0085\u0081\u0001\u0000\u0000\u0000\u0086"+
		"\u000b\u0001\u0000\u0000\u0000\u0087\u0088\u0005<\u0000\u0000\u0088\u0089"+
		"\u0005?\u0000\u0000\u0089\u008a\u0005p\u0000\u0000\u008a\u008b\u0005h"+
		"\u0000\u0000\u008b\u008c\u0005p\u0000\u0000\u008c\r\u0001\u0000\u0000"+
		"\u0000\u008d\u008e\u0005<\u0000\u0000\u008e\u0090\u0004\u0005\u0000\u0000"+
		"\u008f\u0091\t\u0000\u0000\u0000\u0090\u008f\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0092"+
		"\u0090\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094"+
		"\u0095\u0004\u0005\u0001\u0000\u0095\u0096\u0005>\u0000\u0000\u0096\u000f"+
		"\u0001\u0000\u0000\u0000\u0097\u0098\u0005@\u0000\u0000\u0098\u0099\u0005"+
		"{\u0000\u0000\u0099\u009a\u0005{\u0000\u0000\u009a\u0011\u0001\u0000\u0000"+
		"\u0000\u009b\u009c\u0005{\u0000\u0000\u009c\u009d\u0005{\u0000\u0000\u009d"+
		"\u009e\u0001\u0000\u0000\u0000\u009e\u009f\u0006\u0007\u0000\u0000\u009f"+
		"\u0013\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005@\u0000\u0000\u00a1\u00a2"+
		"\u0005m\u0000\u0000\u00a2\u00a3\u0005e\u0000\u0000\u00a3\u00a4\u0005d"+
		"\u0000\u0000\u00a4\u00a5\u0005i\u0000\u0000\u00a5\u00d8\u0005a\u0000\u0000"+
		"\u00a6\u00a7\u0005@\u0000\u0000\u00a7\u00a8\u0005l\u0000\u0000\u00a8\u00a9"+
		"\u0005a\u0000\u0000\u00a9\u00aa\u0005y\u0000\u0000\u00aa\u00ab\u0005e"+
		"\u0000\u0000\u00ab\u00d8\u0005r\u0000\u0000\u00ac\u00ad\u0005@\u0000\u0000"+
		"\u00ad\u00ae\u0005t\u0000\u0000\u00ae\u00af\u0005a\u0000\u0000\u00af\u00b0"+
		"\u0005i\u0000\u0000\u00b0\u00b1\u0005l\u0000\u0000\u00b1\u00b2\u0005w"+
		"\u0000\u0000\u00b2\u00b3\u0005i\u0000\u0000\u00b3\u00b4\u0005n\u0000\u0000"+
		"\u00b4\u00d8\u0005d\u0000\u0000\u00b5\u00b6\u0005@\u0000\u0000\u00b6\u00b7"+
		"\u0005a\u0000\u0000\u00b7\u00b8\u0005p\u0000\u0000\u00b8\u00b9\u0005p"+
		"\u0000\u0000\u00b9\u00ba\u0005l\u0000\u0000\u00ba\u00d8\u0005y\u0000\u0000"+
		"\u00bb\u00bc\u0005@\u0000\u0000\u00bc\u00bd\u0005-\u0000\u0000\u00bd\u00be"+
		"\u0005w\u0000\u0000\u00be\u00bf\u0005e\u0000\u0000\u00bf\u00c0\u0005b"+
		"\u0000\u0000\u00c0\u00c1\u0005k\u0000\u0000\u00c1\u00c2\u0005i\u0000\u0000"+
		"\u00c2\u00c3\u0005t\u0000\u0000\u00c3\u00c4\u0005-\u0000\u0000\u00c4\u00c5"+
		"\u0005k\u0000\u0000\u00c5\u00c6\u0005e\u0000\u0000\u00c6\u00c7\u0005y"+
		"\u0000\u0000\u00c7\u00c8\u0005f\u0000\u0000\u00c8\u00c9\u0005r\u0000\u0000"+
		"\u00c9\u00ca\u0005a\u0000\u0000\u00ca\u00cb\u0005m\u0000\u0000\u00cb\u00cc"+
		"\u0005e\u0000\u0000\u00cc\u00d8\u0005s\u0000\u0000\u00cd\u00ce\u0005@"+
		"\u0000\u0000\u00ce\u00cf\u0005k\u0000\u0000\u00cf\u00d0\u0005e\u0000\u0000"+
		"\u00d0\u00d1\u0005y\u0000\u0000\u00d1\u00d2\u0005f\u0000\u0000\u00d2\u00d3"+
		"\u0005r\u0000\u0000\u00d3\u00d4\u0005a\u0000\u0000\u00d4\u00d5\u0005m"+
		"\u0000\u0000\u00d5\u00d6\u0005e\u0000\u0000\u00d6\u00d8\u0005s\u0000\u0000"+
		"\u00d7\u00a0\u0001\u0000\u0000\u0000\u00d7\u00a6\u0001\u0000\u0000\u0000"+
		"\u00d7\u00ac\u0001\u0000\u0000\u0000\u00d7\u00b5\u0001\u0000\u0000\u0000"+
		"\u00d7\u00bb\u0001\u0000\u0000\u0000\u00d7\u00cd\u0001\u0000\u0000\u0000"+
		"\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00da\u0006\b\u0001\u0000\u00da"+
		"\u0015\u0001\u0000\u0000\u0000\u00db\u00dc\u0005@\u0000\u0000\u00dc\u00dd"+
		"\u0005@\u0000\u0000\u00dd\u00de\u0001\u0000\u0000\u0000\u00de\u00df\u0006"+
		"\t\u0001\u0000\u00df\u0017\u0001\u0000\u0000\u0000\u00e0\u00e1\u0003\n"+
		"\u0003\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2\u00e3\u0006\n\u0002"+
		"\u0000\u00e3\u0019\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005@\u0000\u0000"+
		"\u00e5\u00e6\u0005e\u0000\u0000\u00e6\u00e7\u0005l\u0000\u0000\u00e7\u00e8"+
		"\u0005s\u0000\u0000\u00e8\u00e9\u0005e\u0000\u0000\u00e9\u00ea\u0005i"+
		"\u0000\u0000\u00ea\u00eb\u0005f\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000"+
		"\u0000\u00ec\u00ed\u0006\u000b\u0002\u0000\u00ed\u001b\u0001\u0000\u0000"+
		"\u0000\u00ee\u00ef\u0005@\u0000\u0000\u00ef\u00f0\u0005e\u0000\u0000\u00f0"+
		"\u00f1\u0005l\u0000\u0000\u00f1\u00f2\u0005s\u0000\u0000\u00f2\u00f3\u0005"+
		"e\u0000\u0000\u00f3\u001d\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005@\u0000"+
		"\u0000\u00f5\u00f6\u0005e\u0000\u0000\u00f6\u00f7\u0005n\u0000\u0000\u00f7"+
		"\u00f8\u0005d\u0000\u0000\u00f8\u00f9\u0005i\u0000\u0000\u00f9\u00fa\u0005"+
		"f\u0000\u0000\u00fa\u001f\u0001\u0000\u0000\u0000\u00fb\u00fc\u0005@\u0000"+
		"\u0000\u00fc\u00fd\u0005i\u0000\u0000\u00fd\u00fe\u0005n\u0000\u0000\u00fe"+
		"\u00ff\u0005c\u0000\u0000\u00ff\u0100\u0005l\u0000\u0000\u0100\u0101\u0005"+
		"u\u0000\u0000\u0101\u0102\u0005d\u0000\u0000\u0102\u0103\u0005e\u0000"+
		"\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u0105\u0006\u000e\u0003"+
		"\u0000\u0105!\u0001\u0000\u0000\u0000\u0106\u0107\u0003\f\u0004\u0000"+
		"\u0107#\u0001\u0000\u0000\u0000\u0108\u010a\u0003\u000e\u0005\u0000\u0109"+
		"\u0108\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b"+
		"\u0109\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c"+
		"\u010f\u0001\u0000\u0000\u0000\u010d\u010f\u0003\b\u0002\u0000\u010e\u0109"+
		"\u0001\u0000\u0000\u0000\u010e\u010d\u0001\u0000\u0000\u0000\u010f%\u0001"+
		"\u0000\u0000\u0000\u0110\u0111\u0007\u0004\u0000\u0000\u0111\u0112\u0001"+
		"\u0000\u0000\u0000\u0112\u0113\u0006\u0011\u0001\u0000\u0113\'\u0001\u0000"+
		"\u0000\u0000\u0114\u0116\u0007\u0005\u0000\u0000\u0115\u0114\u0001\u0000"+
		"\u0000\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0117\u0115\u0001\u0000"+
		"\u0000\u0000\u0117\u0118\u0001\u0000\u0000\u0000\u0118\u0119\u0001\u0000"+
		"\u0000\u0000\u0119\u011a\u0006\u0012\u0001\u0000\u011a)\u0001\u0000\u0000"+
		"\u0000\u011b\u011c\t\u0000\u0000\u0000\u011c\u011d\u0001\u0000\u0000\u0000"+
		"\u011d\u011e\u0006\u0013\u0001\u0000\u011e+\u0001\u0000\u0000\u0000\u011f"+
		"\u0121\t\u0000\u0000\u0000\u0120\u011f\u0001\u0000\u0000\u0000\u0121\u0122"+
		"\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0122\u0120"+
		"\u0001\u0000\u0000\u0000\u0123\u0124\u0001\u0000\u0000\u0000\u0124\u0125"+
		"\u0004\u0014\u0002\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126\u0127"+
		"\u0006\u0014\u0004\u0000\u0127-\u0001\u0000\u0000\u0000\u0128\u0129\u0005"+
		"}\u0000\u0000\u0129\u012a\u0005}\u0000\u0000\u012a\u012b\u0001\u0000\u0000"+
		"\u0000\u012b\u012c\u0006\u0015\u0005\u0000\u012c/\u0001\u0000\u0000\u0000"+
		"\u012d\u012e\u0007\u0004\u0000\u0000\u012e\u012f\u0001\u0000\u0000\u0000"+
		"\u012f\u0130\u0006\u0016\u0006\u0000\u0130\u0131\u0006\u0016\u0005\u0000"+
		"\u01311\u0001\u0000\u0000\u0000\u0132\u0133\t\u0000\u0000\u0000\u0133"+
		"\u0134\u0001\u0000\u0000\u0000\u0134\u0135\u0006\u0017\u0006\u0000\u0135"+
		"3\u0001\u0000\u0000\u0000\u0136\u0137\u0007\u0006\u0000\u0000\u0137\u0138"+
		"\u0003\b\u0002\u0000\u01385\u0001\u0000\u0000\u0000\u0139\u013a\u0003"+
		"\u0004\u0000\u0000\u013a\u013b\u0001\u0000\u0000\u0000\u013b\u013c\u0006"+
		"\u0019\u0007\u0000\u013c7\u0001\u0000\u0000\u0000\u013d\u013e\u0003\u0006"+
		"\u0001\u0000\u013e\u013f\u0001\u0000\u0000\u0000\u013f\u0140\u0006\u001a"+
		"\b\u0000\u01409\u0001\u0000\u0000\u0000\u0141\u0142\u0004\u001b\u0003"+
		"\u0000\u0142\u0143\u0005(\u0000\u0000\u0143\u0144\u0006\u001b\t\u0000"+
		"\u0144;\u0001\u0000\u0000\u0000\u0145\u0146\u0004\u001c\u0004\u0000\u0146"+
		"\u0147\u0005)\u0000\u0000\u0147\u0148\u0006\u001c\n\u0000\u0148\u0149"+
		"\u0001\u0000\u0000\u0000\u0149\u014a\u0006\u001c\u0005\u0000\u014a=\u0001"+
		"\u0000\u0000\u0000\u014b\u014c\u0004\u001d\u0005\u0000\u014c\u014d\u0005"+
		"(\u0000\u0000\u014d\u014e\u0006\u001d\u000b\u0000\u014e?\u0001\u0000\u0000"+
		"\u0000\u014f\u0150\u0004\u001e\u0006\u0000\u0150\u0151\u0005)\u0000\u0000"+
		"\u0151\u0152\u0006\u001e\f\u0000\u0152A\u0001\u0000\u0000\u0000\u0153"+
		"\u0155\u0007\u0007\u0000\u0000\u0154\u0153\u0001\u0000\u0000\u0000\u0155"+
		"\u0156\u0001\u0000\u0000\u0000\u0156\u0157\u0006\u001f\r\u0000\u0157C"+
		"\u0001\u0000\u0000\u0000\u0158\u0159\u0005)\u0000\u0000\u0159\u015a\u0004"+
		" \u0007\u0000\u015a\u015b\u0001\u0000\u0000\u0000\u015b\u015c\u0006 \u000e"+
		"\u0000\u015c\u015d\u0006 \u0005\u0000\u015dE\u0001\u0000\u0000\u0000\u015e"+
		"\u015f\t\u0000\u0000\u0000\u015f\u0160\u0001\u0000\u0000\u0000\u0160\u0161"+
		"\u0006!\u000f\u0000\u0161G\u0001\u0000\u0000\u0000\u0162\u0163\u0007\u0006"+
		"\u0000\u0000\u0163\u0164\u0003\b\u0002\u0000\u0164I\u0001\u0000\u0000"+
		"\u0000\u0165\u0166\u0003\u0004\u0000\u0000\u0166\u0167\u0001\u0000\u0000"+
		"\u0000\u0167\u0168\u0006#\u0007\u0000\u0168K\u0001\u0000\u0000\u0000\u0169"+
		"\u016a\u0003\u0006\u0001\u0000\u016a\u016b\u0001\u0000\u0000\u0000\u016b"+
		"\u016c\u0006$\b\u0000\u016cM\u0001\u0000\u0000\u0000\u016d\u016e\u0004"+
		"%\b\u0000\u016e\u016f\u0005(\u0000\u0000\u016f\u0170\u0006%\u0010\u0000"+
		"\u0170O\u0001\u0000\u0000\u0000\u0171\u0172\u0004&\t\u0000\u0172\u0173"+
		"\u0005)\u0000\u0000\u0173\u0174\u0006&\u0011\u0000\u0174\u0175\u0001\u0000"+
		"\u0000\u0000\u0175\u0176\u0006&\u0005\u0000\u0176Q\u0001\u0000\u0000\u0000"+
		"\u0177\u0178\u0004\'\n\u0000\u0178\u0179\u0005(\u0000\u0000\u0179\u017a"+
		"\u0006\'\u0012\u0000\u017aS\u0001\u0000\u0000\u0000\u017b\u017c\u0004"+
		"(\u000b\u0000\u017c\u017d\u0005)\u0000\u0000\u017d\u017e\u0006(\u0013"+
		"\u0000\u017eU\u0001\u0000\u0000\u0000\u017f\u0183\u0007\b\u0000\u0000"+
		"\u0180\u0181\u0005-\u0000\u0000\u0181\u0183\u0005>\u0000\u0000\u0182\u017f"+
		"\u0001\u0000\u0000\u0000\u0182\u0180\u0001\u0000\u0000\u0000\u0183\u0184"+
		"\u0001\u0000\u0000\u0000\u0184\u0185\u0006)\u000f\u0000\u0185W\u0001\u0000"+
		"\u0000\u0000\u0186\u0187\u0005&\u0000\u0000\u0187\u018c\u0005&\u0000\u0000"+
		"\u0188\u018c\u0005&\u0000\u0000\u0189\u018a\u0005|\u0000\u0000\u018a\u018c"+
		"\u0005|\u0000\u0000\u018b\u0186\u0001\u0000\u0000\u0000\u018b\u0188\u0001"+
		"\u0000\u0000\u0000\u018b\u0189\u0001\u0000\u0000\u0000\u018c\u018d\u0001"+
		"\u0000\u0000\u0000\u018d\u018e\u0006*\u000f\u0000\u018eY\u0001\u0000\u0000"+
		"\u0000\u018f\u0190\u0003\b\u0002\u0000\u0190\u0191\u0001\u0000\u0000\u0000"+
		"\u0191\u0192\u0006+\u0014\u0000\u0192[\u0001\u0000\u0000\u0000\u0193\u0195"+
		"\u0007\u0007\u0000\u0000\u0194\u0193\u0001\u0000\u0000\u0000\u0195\u0196"+
		"\u0001\u0000\u0000\u0000\u0196\u0197\u0006,\r\u0000\u0197]\u0001\u0000"+
		"\u0000\u0000\u0198\u0199\u0005)\u0000\u0000\u0199\u019a\u0004-\f\u0000"+
		"\u019a\u019b\u0001\u0000\u0000\u0000\u019b\u019c\u0006-\u0015\u0000\u019c"+
		"\u019d\u0006-\u0005\u0000\u019d_\u0001\u0000\u0000\u0000\u019e\u019f\t"+
		"\u0000\u0000\u0000\u019f\u01a0\u0001\u0000\u0000\u0000\u01a0\u01a1\u0006"+
		".\u000f\u0000\u01a1a\u0001\u0000\u0000\u0000\u0014\u0000\u0001\u0002\u0003"+
		"egpr{\u0085\u0092\u00d7\u010b\u010e\u0117\u0122\u0154\u0182\u018b\u0194"+
		"\u0016\u0005\u0001\u0000\u0007\u0015\u0000\u0005\u0003\u0000\u0005\u0002"+
		"\u0000\u0007\u000b\u0000\u0004\u0000\u0000\u0007\f\u0000\u0007\t\u0000"+
		"\u0007\n\u0000\u0001\u001b\u0000\u0001\u001c\u0001\u0001\u001d\u0002\u0001"+
		"\u001e\u0003\u0007\u0004\u0000\u0007\u0019\u0000\u0007\u0006\u0000\u0001"+
		"%\u0004\u0001&\u0005\u0001\'\u0006\u0001(\u0007\u0007\u0005\u0000\u0007"+
		"\u001e\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}