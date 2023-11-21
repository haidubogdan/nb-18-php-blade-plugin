// Generated from BladeAntlrParser.g4 by ANTLR 4.13.0

  package org.netbeans.modules.php.blade.syntax.antlr4;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BladeAntlrParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TOKEN_REF=1, RULE_REF=2, LEXER_CHAR_SET=3, PHP_EXPRESSION=4, BLADE_PHP_ECHO_EXPR=5, 
		ERROR=6, BLADE_COMMENT=7, PHP_INLINE=8, D_IF=9, D_ELSEIF=10, D_ELSE=11, 
		D_ENDIF=12, D_SWITCH=13, D_CASE=14, D_ENDSWITCH=15, D_EACH=16, D_FOREACH=17, 
		D_ENDFOREACH=18, D_FOR=19, D_ENDFOR=20, D_FORELSE=21, D_ENDFORELSE=22, 
		D_WHILE=23, D_ENDWHILE=24, D_CONTINUE=25, D_BREAK=26, D_INCLUDE=27, D_INCLUDE_IF=28, 
		D_INCLUDE_WHEN=29, D_INCLUDE_FIRST=30, D_INCLUDE_UNLESS=31, D_EXTENDS=32, 
		D_JS=33, D_SECTION=34, D_HAS_SECTION=35, D_SECTION_MISSING=36, D_ENDSECTION=37, 
		D_YIELD=38, D_PARENT=39, D_SHOW=40, D_OVERWRITE=41, D_STOP=42, D_ONCE=43, 
		D_ENDONCE=44, D_PUSH=45, D_ENDPUSH=46, D_PUSH_ONCE=47, D_ENDPUSH_ONCE=48, 
		D_PROPS=49, D_CSRF=50, D_METHOD=51, D_ERROR=52, D_ENDERROR=53, D_PRODUCTION=54, 
		D_ENDPRODUCTION=55, D_CLASS=56, D_STYLE=57, D_SELECTED=58, D_DISABLED=59, 
		D_READONLY=60, D_REQUIRED=61, D_AWARE=62, D_EMPTY=63, D_ENDEMPTY=64, D_JSON=65, 
		D_INJECT=66, D_DD=67, D_PHP=68, D_VERBATIM=69, D_ENDVERBATIM=70, D_CUSTOM=71, 
		ESCAPED_ECHO_START=72, NE_ECHO_START=73, HTML=74, ESCAPED_ECHO_END=75, 
		NE_ECHO_END=76, WS_EXPR=77, D_ENDPHP=78, BLADE_PHP_INLINE=79, ESCAPE_ECHO=80, 
		OPEN_EXPR_PAREN_MORE=81;
	public static final int
		RULE_file = 0, RULE_general_statement = 1, RULE_inline_statement = 2, 
		RULE_extends = 3, RULE_block_statement = 4, RULE_section = 5, RULE_section_inline = 6, 
		RULE_html = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "general_statement", "inline_statement", "extends", "block_statement", 
			"section", "section_inline", "html"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "'@if'", "'@elseif'", 
			"'@else'", "'@endif'", "'@switch'", "'@case'", "'@endswitch'", "'@each'", 
			"'@foreach'", "'@endforeach'", "'@for'", "'@endfor'", "'@forelse'", "'@endforelse'", 
			"'@while'", "'@endwhile'", "'@continue'", "'@break'", "'@include'", "'@includeIf'", 
			"'@includeWhen'", "'@includeFirst'", "'@includeUnless'", "'@extends'", 
			"'@js'", "'@section'", "'@hasSection'", "'@sectionMissing'", "'@endsection'", 
			"'@yield'", "'@parent'", "'@show'", "'@overwrite'", "'@stop'", "'@once'", 
			"'@endonce'", "'@push'", "'@endpush'", "'@pushOnce'", "'@endPushOnce'", 
			"'@props'", "'@csrf'", "'@method'", "'@error'", "'@enderror'", "'@production'", 
			"'@endproduction'", "'@class'", "'@style'", "'@selected'", "'@disabled'", 
			"'@readonly'", "'@required'", "'@aware'", "'@empty'", "'@endempty'", 
			"'@json'", "'@inject'", "'@dd'", "'@php'", "'@verbatim'", "'@endverbatim'", 
			null, "'{{'", "'{!!'", null, null, null, null, "'@endphp'", null, "'@{'", 
			"'('"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TOKEN_REF", "RULE_REF", "LEXER_CHAR_SET", "PHP_EXPRESSION", "BLADE_PHP_ECHO_EXPR", 
			"ERROR", "BLADE_COMMENT", "PHP_INLINE", "D_IF", "D_ELSEIF", "D_ELSE", 
			"D_ENDIF", "D_SWITCH", "D_CASE", "D_ENDSWITCH", "D_EACH", "D_FOREACH", 
			"D_ENDFOREACH", "D_FOR", "D_ENDFOR", "D_FORELSE", "D_ENDFORELSE", "D_WHILE", 
			"D_ENDWHILE", "D_CONTINUE", "D_BREAK", "D_INCLUDE", "D_INCLUDE_IF", "D_INCLUDE_WHEN", 
			"D_INCLUDE_FIRST", "D_INCLUDE_UNLESS", "D_EXTENDS", "D_JS", "D_SECTION", 
			"D_HAS_SECTION", "D_SECTION_MISSING", "D_ENDSECTION", "D_YIELD", "D_PARENT", 
			"D_SHOW", "D_OVERWRITE", "D_STOP", "D_ONCE", "D_ENDONCE", "D_PUSH", "D_ENDPUSH", 
			"D_PUSH_ONCE", "D_ENDPUSH_ONCE", "D_PROPS", "D_CSRF", "D_METHOD", "D_ERROR", 
			"D_ENDERROR", "D_PRODUCTION", "D_ENDPRODUCTION", "D_CLASS", "D_STYLE", 
			"D_SELECTED", "D_DISABLED", "D_READONLY", "D_REQUIRED", "D_AWARE", "D_EMPTY", 
			"D_ENDEMPTY", "D_JSON", "D_INJECT", "D_DD", "D_PHP", "D_VERBATIM", "D_ENDVERBATIM", 
			"D_CUSTOM", "ESCAPED_ECHO_START", "NE_ECHO_START", "HTML", "ESCAPED_ECHO_END", 
			"NE_ECHO_END", "WS_EXPR", "D_ENDPHP", "BLADE_PHP_INLINE", "ESCAPE_ECHO", 
			"OPEN_EXPR_PAREN_MORE"
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
	public String getGrammarFileName() { return "BladeAntlrParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BladeAntlrParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FileContext extends ParserRuleContext {
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public TerminalNode EOF() { return getToken(BladeAntlrParser.EOF, 0); }
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			setState(22);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_EXTENDS:
			case D_SECTION:
			case HTML:
				enterOuterAlt(_localctx, 1);
				{
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(16);
					general_statement();
					}
					}
					setState(19); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 32)) & ~0x3f) == 0 && ((1L << (_la - 32)) & 4398046511109L) != 0) );
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
				match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class General_statementContext extends ParserRuleContext {
		public Inline_statementContext inline_statement() {
			return getRuleContext(Inline_statementContext.class,0);
		}
		public Block_statementContext block_statement() {
			return getRuleContext(Block_statementContext.class,0);
		}
		public HtmlContext html() {
			return getRuleContext(HtmlContext.class,0);
		}
		public General_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_general_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterGeneral_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitGeneral_statement(this);
		}
	}

	public final General_statementContext general_statement() throws RecognitionException {
		General_statementContext _localctx = new General_statementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_general_statement);
		try {
			setState(27);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				inline_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				block_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(26);
				html();
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
	public static class Inline_statementContext extends ParserRuleContext {
		public ExtendsContext extends_() {
			return getRuleContext(ExtendsContext.class,0);
		}
		public Section_inlineContext section_inline() {
			return getRuleContext(Section_inlineContext.class,0);
		}
		public Inline_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inline_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterInline_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitInline_statement(this);
		}
	}

	public final Inline_statementContext inline_statement() throws RecognitionException {
		Inline_statementContext _localctx = new Inline_statementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_inline_statement);
		try {
			setState(31);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_EXTENDS:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				extends_();
				}
				break;
			case D_SECTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				section_inline();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExtendsContext extends ParserRuleContext {
		public TerminalNode D_EXTENDS() { return getToken(BladeAntlrParser.D_EXTENDS, 0); }
		public TerminalNode PHP_EXPRESSION() { return getToken(BladeAntlrParser.PHP_EXPRESSION, 0); }
		public ExtendsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extends; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterExtends(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitExtends(this);
		}
	}

	public final ExtendsContext extends_() throws RecognitionException {
		ExtendsContext _localctx = new ExtendsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_extends);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(D_EXTENDS);
			setState(34);
			match(PHP_EXPRESSION);
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
	public static class Block_statementContext extends ParserRuleContext {
		public SectionContext section() {
			return getRuleContext(SectionContext.class,0);
		}
		public Block_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterBlock_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitBlock_statement(this);
		}
	}

	public final Block_statementContext block_statement() throws RecognitionException {
		Block_statementContext _localctx = new Block_statementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			section();
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
	public static class SectionContext extends ParserRuleContext {
		public TerminalNode D_SECTION() { return getToken(BladeAntlrParser.D_SECTION, 0); }
		public TerminalNode PHP_EXPRESSION() { return getToken(BladeAntlrParser.PHP_EXPRESSION, 0); }
		public TerminalNode D_ENDSECTION() { return getToken(BladeAntlrParser.D_ENDSECTION, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitSection(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(D_SECTION);
			setState(39);
			match(PHP_EXPRESSION);
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 32)) & ~0x3f) == 0 && ((1L << (_la - 32)) & 4398046511109L) != 0)) {
				{
				{
				setState(40);
				general_statement();
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
			match(D_ENDSECTION);
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
	public static class Section_inlineContext extends ParserRuleContext {
		public TerminalNode D_SECTION() { return getToken(BladeAntlrParser.D_SECTION, 0); }
		public TerminalNode PHP_EXPRESSION() { return getToken(BladeAntlrParser.PHP_EXPRESSION, 0); }
		public Section_inlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section_inline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterSection_inline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitSection_inline(this);
		}
	}

	public final Section_inlineContext section_inline() throws RecognitionException {
		Section_inlineContext _localctx = new Section_inlineContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_section_inline);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(D_SECTION);
			setState(49);
			match(PHP_EXPRESSION);
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
	public static class HtmlContext extends ParserRuleContext {
		public List<TerminalNode> HTML() { return getTokens(BladeAntlrParser.HTML); }
		public TerminalNode HTML(int i) {
			return getToken(BladeAntlrParser.HTML, i);
		}
		public HtmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_html; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterHtml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitHtml(this);
		}
	}

	public final HtmlContext html() throws RecognitionException {
		HtmlContext _localctx = new HtmlContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_html);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(52); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(51);
					match(HTML);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(54); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		"\u0004\u0001Q9\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001\u0000"+
		"\u0004\u0000\u0012\b\u0000\u000b\u0000\f\u0000\u0013\u0001\u0000\u0003"+
		"\u0000\u0017\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u001c"+
		"\b\u0001\u0001\u0002\u0001\u0002\u0003\u0002 \b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0005\u0005*\b\u0005\n\u0005\f\u0005-\t\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0004\u00075\b"+
		"\u0007\u000b\u0007\f\u00076\u0001\u0007\u0000\u0000\b\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0000\u00007\u0000\u0016\u0001\u0000\u0000\u0000\u0002"+
		"\u001b\u0001\u0000\u0000\u0000\u0004\u001f\u0001\u0000\u0000\u0000\u0006"+
		"!\u0001\u0000\u0000\u0000\b$\u0001\u0000\u0000\u0000\n&\u0001\u0000\u0000"+
		"\u0000\f0\u0001\u0000\u0000\u0000\u000e4\u0001\u0000\u0000\u0000\u0010"+
		"\u0012\u0003\u0002\u0001\u0000\u0011\u0010\u0001\u0000\u0000\u0000\u0012"+
		"\u0013\u0001\u0000\u0000\u0000\u0013\u0011\u0001\u0000\u0000\u0000\u0013"+
		"\u0014\u0001\u0000\u0000\u0000\u0014\u0017\u0001\u0000\u0000\u0000\u0015"+
		"\u0017\u0005\u0000\u0000\u0001\u0016\u0011\u0001\u0000\u0000\u0000\u0016"+
		"\u0015\u0001\u0000\u0000\u0000\u0017\u0001\u0001\u0000\u0000\u0000\u0018"+
		"\u001c\u0003\u0004\u0002\u0000\u0019\u001c\u0003\b\u0004\u0000\u001a\u001c"+
		"\u0003\u000e\u0007\u0000\u001b\u0018\u0001\u0000\u0000\u0000\u001b\u0019"+
		"\u0001\u0000\u0000\u0000\u001b\u001a\u0001\u0000\u0000\u0000\u001c\u0003"+
		"\u0001\u0000\u0000\u0000\u001d \u0003\u0006\u0003\u0000\u001e \u0003\f"+
		"\u0006\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f\u001e\u0001\u0000"+
		"\u0000\u0000 \u0005\u0001\u0000\u0000\u0000!\"\u0005 \u0000\u0000\"#\u0005"+
		"\u0004\u0000\u0000#\u0007\u0001\u0000\u0000\u0000$%\u0003\n\u0005\u0000"+
		"%\t\u0001\u0000\u0000\u0000&\'\u0005\"\u0000\u0000\'+\u0005\u0004\u0000"+
		"\u0000(*\u0003\u0002\u0001\u0000)(\u0001\u0000\u0000\u0000*-\u0001\u0000"+
		"\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,.\u0001"+
		"\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000./\u0005%\u0000\u0000/\u000b"+
		"\u0001\u0000\u0000\u000001\u0005\"\u0000\u000012\u0005\u0004\u0000\u0000"+
		"2\r\u0001\u0000\u0000\u000035\u0005J\u0000\u000043\u0001\u0000\u0000\u0000"+
		"56\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000067\u0001\u0000\u0000"+
		"\u00007\u000f\u0001\u0000\u0000\u0000\u0006\u0013\u0016\u001b\u001f+6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}