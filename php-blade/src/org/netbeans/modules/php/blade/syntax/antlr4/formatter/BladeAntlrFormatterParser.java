// Generated from java-escape by ANTLR 4.11.1

  package org.netbeans.modules.php.blade.syntax.antlr4.formatter;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BladeAntlrFormatterParser extends Parser {
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
		RULE_file = 0, RULE_statement = 1, RULE_indetable_element = 2, RULE_html_open_tag = 3, 
		RULE_attr_assigment = 4, RULE_attr_value = 5, RULE_html_indent = 6, RULE_block_start = 7, 
		RULE_block_directive_name = 8, RULE_block_end = 9, RULE_inline_identable_element = 10, 
		RULE_nl_with_space_before = 11, RULE_nl_with_space = 12, RULE_ws = 13, 
		RULE_static_element = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "statement", "indetable_element", "html_open_tag", "attr_assigment", 
			"attr_value", "html_indent", "block_start", "block_directive_name", "block_end", 
			"inline_identable_element", "nl_with_space_before", "nl_with_space", 
			"ws", "static_element"
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

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BladeAntlrFormatterParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BladeAntlrFormatterParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 7806802L) != 0) {
				{
				{
				setState(30);
				statement();
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Html_open_tagContext html_open_tag() {
			return getRuleContext(Html_open_tagContext.class,0);
		}
		public Html_indentContext html_indent() {
			return getRuleContext(Html_indentContext.class,0);
		}
		public Indetable_elementContext indetable_element() {
			return getRuleContext(Indetable_elementContext.class,0);
		}
		public Inline_identable_elementContext inline_identable_element() {
			return getRuleContext(Inline_identable_elementContext.class,0);
		}
		public Static_elementContext static_element() {
			return getRuleContext(Static_elementContext.class,0);
		}
		public Nl_with_space_beforeContext nl_with_space_before() {
			return getRuleContext(Nl_with_space_beforeContext.class,0);
		}
		public TerminalNode SG_QUOTE() { return getToken(BladeAntlrFormatterParser.SG_QUOTE, 0); }
		public TerminalNode DB_QUOTE() { return getToken(BladeAntlrFormatterParser.DB_QUOTE, 0); }
		public TerminalNode GT_SYMBOL() { return getToken(BladeAntlrFormatterParser.GT_SYMBOL, 0); }
		public TerminalNode HTML_CLOSE_TAG() { return getToken(BladeAntlrFormatterParser.HTML_CLOSE_TAG, 0); }
		public TerminalNode NL() { return getToken(BladeAntlrFormatterParser.NL, 0); }
		public TerminalNode WS() { return getToken(BladeAntlrFormatterParser.WS, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			setState(48);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				html_open_tag();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				html_indent();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				indetable_element();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				inline_identable_element();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(42);
				static_element();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(43);
				nl_with_space_before();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(44);
				_la = _input.LA(1);
				if ( !(_la==SG_QUOTE || _la==DB_QUOTE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(45);
				match(GT_SYMBOL);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(46);
				match(HTML_CLOSE_TAG);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(47);
				_la = _input.LA(1);
				if ( !(_la==WS || _la==NL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Indetable_elementContext extends ParserRuleContext {
		public Block_startContext block_start() {
			return getRuleContext(Block_startContext.class,0);
		}
		public Block_endContext block_end() {
			return getRuleContext(Block_endContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Nl_with_spaceContext nl_with_space() {
			return getRuleContext(Nl_with_spaceContext.class,0);
		}
		public Indetable_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indetable_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterIndetable_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitIndetable_element(this);
		}
	}

	public final Indetable_elementContext indetable_element() throws RecognitionException {
		Indetable_elementContext _localctx = new Indetable_elementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_indetable_element);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			block_start();
			setState(52); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(51);
					statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(54); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(56);
				nl_with_space();
				}
			}

			setState(59);
			block_end();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Html_open_tagContext extends ParserRuleContext {
		public TerminalNode HTML_OPEN_TAG_START() { return getToken(BladeAntlrFormatterParser.HTML_OPEN_TAG_START, 0); }
		public TerminalNode GT_SYMBOL() { return getToken(BladeAntlrFormatterParser.GT_SYMBOL, 0); }
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<Attr_assigmentContext> attr_assigment() {
			return getRuleContexts(Attr_assigmentContext.class);
		}
		public Attr_assigmentContext attr_assigment(int i) {
			return getRuleContext(Attr_assigmentContext.class,i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BladeAntlrFormatterParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BladeAntlrFormatterParser.IDENTIFIER, i);
		}
		public Html_open_tagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_html_open_tag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterHtml_open_tag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitHtml_open_tag(this);
		}
	}

	public final Html_open_tagContext html_open_tag() throws RecognitionException {
		Html_open_tagContext _localctx = new Html_open_tagContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_html_open_tag);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(HTML_OPEN_TAG_START);
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(62);
					ws();
					}
					} 
				}
				setState(67);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				setState(70);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(68);
					attr_assigment();
					}
					break;
				case 2:
					{
					setState(69);
					match(IDENTIFIER);
					}
					break;
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS || _la==NL) {
				{
				{
				setState(75);
				ws();
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(81);
			match(GT_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Attr_assigmentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(BladeAntlrFormatterParser.IDENTIFIER, 0); }
		public TerminalNode EQ() { return getToken(BladeAntlrFormatterParser.EQ, 0); }
		public Attr_valueContext attr_value() {
			return getRuleContext(Attr_valueContext.class,0);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public Attr_assigmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_assigment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterAttr_assigment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitAttr_assigment(this);
		}
	}

	public final Attr_assigmentContext attr_assigment() throws RecognitionException {
		Attr_assigmentContext _localctx = new Attr_assigmentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attr_assigment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(IDENTIFIER);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS || _la==NL) {
				{
				{
				setState(84);
				ws();
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(90);
			match(EQ);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS || _la==NL) {
				{
				{
				setState(91);
				ws();
				}
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(97);
			attr_value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Attr_valueContext extends ParserRuleContext {
		public TerminalNode SIMPLE_STR() { return getToken(BladeAntlrFormatterParser.SIMPLE_STR, 0); }
		public Attr_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterAttr_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitAttr_value(this);
		}
	}

	public final Attr_valueContext attr_value() throws RecognitionException {
		Attr_valueContext _localctx = new Attr_valueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_attr_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(SIMPLE_STR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Html_indentContext extends ParserRuleContext {
		public TerminalNode GT_SYMBOL() { return getToken(BladeAntlrFormatterParser.GT_SYMBOL, 0); }
		public TerminalNode NL() { return getToken(BladeAntlrFormatterParser.NL, 0); }
		public List<TerminalNode> WS() { return getTokens(BladeAntlrFormatterParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(BladeAntlrFormatterParser.WS, i);
		}
		public Html_indentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_html_indent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterHtml_indent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitHtml_indent(this);
		}
	}

	public final Html_indentContext html_indent() throws RecognitionException {
		Html_indentContext _localctx = new Html_indentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_html_indent);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(GT_SYMBOL);
			setState(102);
			match(NL);
			setState(106);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(103);
					match(WS);
					}
					} 
				}
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Block_startContext extends ParserRuleContext {
		public Nl_with_space_beforeContext ws_before;
		public Block_directive_nameContext block_directive_name() {
			return getRuleContext(Block_directive_nameContext.class,0);
		}
		public TerminalNode D_ARG_LPAREN() { return getToken(BladeAntlrFormatterParser.D_ARG_LPAREN, 0); }
		public TerminalNode D_ARG_RPAREN() { return getToken(BladeAntlrFormatterParser.D_ARG_RPAREN, 0); }
		public Nl_with_space_beforeContext nl_with_space_before() {
			return getRuleContext(Nl_with_space_beforeContext.class,0);
		}
		public Block_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterBlock_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitBlock_start(this);
		}
	}

	public final Block_startContext block_start() throws RecognitionException {
		Block_startContext _localctx = new Block_startContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_block_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(109);
				((Block_startContext)_localctx).ws_before = nl_with_space_before();
				}
			}

			setState(112);
			block_directive_name();
			setState(113);
			match(D_ARG_LPAREN);
			setState(114);
			match(D_ARG_RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Block_directive_nameContext extends ParserRuleContext {
		public TerminalNode D_IF() { return getToken(BladeAntlrFormatterParser.D_IF, 0); }
		public TerminalNode D_FOREACH() { return getToken(BladeAntlrFormatterParser.D_FOREACH, 0); }
		public Block_directive_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_directive_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterBlock_directive_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitBlock_directive_name(this);
		}
	}

	public final Block_directive_nameContext block_directive_name() throws RecognitionException {
		Block_directive_nameContext _localctx = new Block_directive_nameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_block_directive_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_la = _input.LA(1);
			if ( !(_la==D_IF || _la==D_FOREACH) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Block_endContext extends ParserRuleContext {
		public TerminalNode D_ENDIF() { return getToken(BladeAntlrFormatterParser.D_ENDIF, 0); }
		public TerminalNode D_ENDFOREACH() { return getToken(BladeAntlrFormatterParser.D_ENDFOREACH, 0); }
		public Block_endContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterBlock_end(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitBlock_end(this);
		}
	}

	public final Block_endContext block_end() throws RecognitionException {
		Block_endContext _localctx = new Block_endContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_block_end);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_la = _input.LA(1);
			if ( !(_la==D_ENDIF || _la==D_ENDFOREACH) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Inline_identable_elementContext extends ParserRuleContext {
		public TerminalNode D_INLINE_DIRECTIVE() { return getToken(BladeAntlrFormatterParser.D_INLINE_DIRECTIVE, 0); }
		public TerminalNode NON_PARAM_DIRECTIVE() { return getToken(BladeAntlrFormatterParser.NON_PARAM_DIRECTIVE, 0); }
		public Inline_identable_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inline_identable_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterInline_identable_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitInline_identable_element(this);
		}
	}

	public final Inline_identable_elementContext inline_identable_element() throws RecognitionException {
		Inline_identable_elementContext _localctx = new Inline_identable_elementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_inline_identable_element);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_la = _input.LA(1);
			if ( !(_la==NON_PARAM_DIRECTIVE || _la==D_INLINE_DIRECTIVE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Nl_with_space_beforeContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(BladeAntlrFormatterParser.NL, 0); }
		public List<TerminalNode> WS() { return getTokens(BladeAntlrFormatterParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(BladeAntlrFormatterParser.WS, i);
		}
		public Nl_with_space_beforeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nl_with_space_before; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterNl_with_space_before(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitNl_with_space_before(this);
		}
	}

	public final Nl_with_space_beforeContext nl_with_space_before() throws RecognitionException {
		Nl_with_space_beforeContext _localctx = new Nl_with_space_beforeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_nl_with_space_before);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(NL);
			setState(126);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(123);
					match(WS);
					}
					} 
				}
				setState(128);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Nl_with_spaceContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(BladeAntlrFormatterParser.NL, 0); }
		public List<TerminalNode> WS() { return getTokens(BladeAntlrFormatterParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(BladeAntlrFormatterParser.WS, i);
		}
		public Nl_with_spaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nl_with_space; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterNl_with_space(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitNl_with_space(this);
		}
	}

	public final Nl_with_spaceContext nl_with_space() throws RecognitionException {
		Nl_with_spaceContext _localctx = new Nl_with_spaceContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_nl_with_space);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(NL);
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(130);
				match(WS);
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WsContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(BladeAntlrFormatterParser.NL, 0); }
		public TerminalNode WS() { return getToken(BladeAntlrFormatterParser.WS, 0); }
		public WsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ws; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterWs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitWs(this);
		}
	}

	public final WsContext ws() throws RecognitionException {
		WsContext _localctx = new WsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ws);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_la = _input.LA(1);
			if ( !(_la==WS || _la==NL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Static_elementContext extends ParserRuleContext {
		public TerminalNode D_PHP() { return getToken(BladeAntlrFormatterParser.D_PHP, 0); }
		public TerminalNode D_ENDPHP() { return getToken(BladeAntlrFormatterParser.D_ENDPHP, 0); }
		public List<TerminalNode> PHP_CODE() { return getTokens(BladeAntlrFormatterParser.PHP_CODE); }
		public TerminalNode PHP_CODE(int i) {
			return getToken(BladeAntlrFormatterParser.PHP_CODE, i);
		}
		public TerminalNode HTML() { return getToken(BladeAntlrFormatterParser.HTML, 0); }
		public TerminalNode OTHER() { return getToken(BladeAntlrFormatterParser.OTHER, 0); }
		public Static_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_static_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterStatic_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitStatic_element(this);
		}
	}

	public final Static_elementContext static_element() throws RecognitionException {
		Static_elementContext _localctx = new Static_elementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_static_element);
		int _la;
		try {
			setState(147);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_PHP:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				match(D_PHP);
				setState(140); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(139);
					match(PHP_CODE);
					}
					}
					setState(142); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==PHP_CODE );
				setState(144);
				match(D_ENDPHP);
				}
				break;
			case HTML:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				match(HTML);
				}
				break;
			case OTHER:
				enterOuterAlt(_localctx, 3);
				{
				setState(146);
				match(OTHER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001b\u0096\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0005"+
		"\u0000 \b\u0000\n\u0000\f\u0000#\t\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00011\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0004\u00025\b\u0002\u000b\u0002\f\u00026\u0001\u0002"+
		"\u0003\u0002:\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0005\u0003@\b\u0003\n\u0003\f\u0003C\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003G\b\u0003\n\u0003\f\u0003J\t\u0003\u0001\u0003\u0005\u0003"+
		"M\b\u0003\n\u0003\f\u0003P\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0005\u0004V\b\u0004\n\u0004\f\u0004Y\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004]\b\u0004\n\u0004\f\u0004`\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u0006i\b\u0006\n\u0006\f\u0006l\t\u0006\u0001\u0007\u0003\u0007"+
		"o\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0005\u000b"+
		"}\b\u000b\n\u000b\f\u000b\u0080\t\u000b\u0001\f\u0001\f\u0005\f\u0084"+
		"\b\f\n\f\f\f\u0087\t\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0004\u000e"+
		"\u008d\b\u000e\u000b\u000e\f\u000e\u008e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u0094\b\u000e\u0001\u000e\u0000\u0000\u000f\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000"+
		"\u0005\u0001\u0000\n\u000b\u0001\u0000\u0014\u0015\u0002\u0000\u0004\u0004"+
		"\u0006\u0006\u0002\u0000\u0005\u0005\u0007\u0007\u0001\u0000\b\t\u009f"+
		"\u0000!\u0001\u0000\u0000\u0000\u00020\u0001\u0000\u0000\u0000\u00042"+
		"\u0001\u0000\u0000\u0000\u0006=\u0001\u0000\u0000\u0000\bS\u0001\u0000"+
		"\u0000\u0000\nc\u0001\u0000\u0000\u0000\fe\u0001\u0000\u0000\u0000\u000e"+
		"n\u0001\u0000\u0000\u0000\u0010t\u0001\u0000\u0000\u0000\u0012v\u0001"+
		"\u0000\u0000\u0000\u0014x\u0001\u0000\u0000\u0000\u0016z\u0001\u0000\u0000"+
		"\u0000\u0018\u0081\u0001\u0000\u0000\u0000\u001a\u0088\u0001\u0000\u0000"+
		"\u0000\u001c\u0093\u0001\u0000\u0000\u0000\u001e \u0003\u0002\u0001\u0000"+
		"\u001f\u001e\u0001\u0000\u0000\u0000 #\u0001\u0000\u0000\u0000!\u001f"+
		"\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"$\u0001\u0000\u0000"+
		"\u0000#!\u0001\u0000\u0000\u0000$%\u0005\u0000\u0000\u0001%\u0001\u0001"+
		"\u0000\u0000\u0000&1\u0003\u0006\u0003\u0000\'1\u0003\f\u0006\u0000(1"+
		"\u0003\u0004\u0002\u0000)1\u0003\u0014\n\u0000*1\u0003\u001c\u000e\u0000"+
		"+1\u0003\u0016\u000b\u0000,1\u0007\u0000\u0000\u0000-1\u0005\u0011\u0000"+
		"\u0000.1\u0005\u0010\u0000\u0000/1\u0007\u0001\u0000\u00000&\u0001\u0000"+
		"\u0000\u00000\'\u0001\u0000\u0000\u00000(\u0001\u0000\u0000\u00000)\u0001"+
		"\u0000\u0000\u00000*\u0001\u0000\u0000\u00000+\u0001\u0000\u0000\u0000"+
		"0,\u0001\u0000\u0000\u00000-\u0001\u0000\u0000\u00000.\u0001\u0000\u0000"+
		"\u00000/\u0001\u0000\u0000\u00001\u0003\u0001\u0000\u0000\u000024\u0003"+
		"\u000e\u0007\u000035\u0003\u0002\u0001\u000043\u0001\u0000\u0000\u0000"+
		"56\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000067\u0001\u0000\u0000"+
		"\u000079\u0001\u0000\u0000\u00008:\u0003\u0018\f\u000098\u0001\u0000\u0000"+
		"\u00009:\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;<\u0003\u0012"+
		"\t\u0000<\u0005\u0001\u0000\u0000\u0000=A\u0005\f\u0000\u0000>@\u0003"+
		"\u001a\r\u0000?>\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000\u0000A?\u0001"+
		"\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BH\u0001\u0000\u0000\u0000"+
		"CA\u0001\u0000\u0000\u0000DG\u0003\b\u0004\u0000EG\u0005\r\u0000\u0000"+
		"FD\u0001\u0000\u0000\u0000FE\u0001\u0000\u0000\u0000GJ\u0001\u0000\u0000"+
		"\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IN\u0001\u0000"+
		"\u0000\u0000JH\u0001\u0000\u0000\u0000KM\u0003\u001a\r\u0000LK\u0001\u0000"+
		"\u0000\u0000MP\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000NO\u0001"+
		"\u0000\u0000\u0000OQ\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000"+
		"QR\u0005\u0011\u0000\u0000R\u0007\u0001\u0000\u0000\u0000SW\u0005\r\u0000"+
		"\u0000TV\u0003\u001a\r\u0000UT\u0001\u0000\u0000\u0000VY\u0001\u0000\u0000"+
		"\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XZ\u0001\u0000"+
		"\u0000\u0000YW\u0001\u0000\u0000\u0000Z^\u0005\u000e\u0000\u0000[]\u0003"+
		"\u001a\r\u0000\\[\u0001\u0000\u0000\u0000]`\u0001\u0000\u0000\u0000^\\"+
		"\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_a\u0001\u0000\u0000"+
		"\u0000`^\u0001\u0000\u0000\u0000ab\u0003\n\u0005\u0000b\t\u0001\u0000"+
		"\u0000\u0000cd\u0005\u000f\u0000\u0000d\u000b\u0001\u0000\u0000\u0000"+
		"ef\u0005\u0011\u0000\u0000fj\u0005\u0015\u0000\u0000gi\u0005\u0014\u0000"+
		"\u0000hg\u0001\u0000\u0000\u0000il\u0001\u0000\u0000\u0000jh\u0001\u0000"+
		"\u0000\u0000jk\u0001\u0000\u0000\u0000k\r\u0001\u0000\u0000\u0000lj\u0001"+
		"\u0000\u0000\u0000mo\u0003\u0016\u000b\u0000nm\u0001\u0000\u0000\u0000"+
		"no\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pq\u0003\u0010\b\u0000"+
		"qr\u0005\u0017\u0000\u0000rs\u0005\u0018\u0000\u0000s\u000f\u0001\u0000"+
		"\u0000\u0000tu\u0007\u0002\u0000\u0000u\u0011\u0001\u0000\u0000\u0000"+
		"vw\u0007\u0003\u0000\u0000w\u0013\u0001\u0000\u0000\u0000xy\u0007\u0004"+
		"\u0000\u0000y\u0015\u0001\u0000\u0000\u0000z~\u0005\u0015\u0000\u0000"+
		"{}\u0005\u0014\u0000\u0000|{\u0001\u0000\u0000\u0000}\u0080\u0001\u0000"+
		"\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000"+
		"\u007f\u0017\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0081"+
		"\u0085\u0005\u0015\u0000\u0000\u0082\u0084\u0005\u0014\u0000\u0000\u0083"+
		"\u0082\u0001\u0000\u0000\u0000\u0084\u0087\u0001\u0000\u0000\u0000\u0085"+
		"\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086"+
		"\u0019\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0088"+
		"\u0089\u0007\u0001\u0000\u0000\u0089\u001b\u0001\u0000\u0000\u0000\u008a"+
		"\u008c\u0005\u0012\u0000\u0000\u008b\u008d\u0005\u0002\u0000\u0000\u008c"+
		"\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e"+
		"\u008c\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0001\u0000\u0000\u0000\u0090\u0094\u0005\u001b\u0000\u0000\u0091"+
		"\u0094\u0005\u0001\u0000\u0000\u0092\u0094\u0005\u0016\u0000\u0000\u0093"+
		"\u008a\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0093"+
		"\u0092\u0001\u0000\u0000\u0000\u0094\u001d\u0001\u0000\u0000\u0000\u0010"+
		"!069AFHNW^jn~\u0085\u008e\u0093";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}