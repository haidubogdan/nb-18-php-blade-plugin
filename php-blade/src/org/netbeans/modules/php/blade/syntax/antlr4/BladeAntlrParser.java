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
		ESCAPED_ECHO_START=72, NE_ECHO_START=73, AT=74, HTML=75, ESCAPED_ECHO_END=76, 
		NE_ECHO_END=77, WS_EXPR=78, D_ENDPHP=79, BLADE_PHP_INLINE=80, ESCAPE_ECHO=81, 
		OPEN_EXPR_PAREN_MORE=82;
	public static final int
		RULE_file = 0, RULE_general_statement = 1, RULE_inline_statement = 2, 
		RULE_extends = 3, RULE_block_statement = 4, RULE_non_blade_statement = 5, 
		RULE_section = 6, RULE_section_inline = 7, RULE_if = 8, RULE_elseif = 9, 
		RULE_else = 10, RULE_yield = 11, RULE_include = 12, RULE_custom_directive = 13, 
		RULE_php_blade = 14, RULE_echo = 15, RULE_echo_ne = 16, RULE_php_expression = 17, 
		RULE_verbatim_block = 18, RULE_html = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "general_statement", "inline_statement", "extends", "block_statement", 
			"non_blade_statement", "section", "section_inline", "if", "elseif", "else", 
			"yield", "include", "custom_directive", "php_blade", "echo", "echo_ne", 
			"php_expression", "verbatim_block", "html"
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
			"'@json'", "'@inject'", "'@dd'", "'@php'", "'@verbatim'", null, null, 
			"'{{'", "'{!!'", "'@'", null, null, null, null, "'@endphp'", null, "'@{'", 
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
			"D_CUSTOM", "ESCAPED_ECHO_START", "NE_ECHO_START", "AT", "HTML", "ESCAPED_ECHO_END", 
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
		public TerminalNode EOF() { return getToken(BladeAntlrParser.EOF, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
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
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 296486964992L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 187L) != 0)) {
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
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				inline_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				block_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
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
		public YieldContext yield() {
			return getRuleContext(YieldContext.class,0);
		}
		public IncludeContext include() {
			return getRuleContext(IncludeContext.class,0);
		}
		public Custom_directiveContext custom_directive() {
			return getRuleContext(Custom_directiveContext.class,0);
		}
		public EchoContext echo() {
			return getRuleContext(EchoContext.class,0);
		}
		public Echo_neContext echo_ne() {
			return getRuleContext(Echo_neContext.class,0);
		}
		public Verbatim_blockContext verbatim_block() {
			return getRuleContext(Verbatim_blockContext.class,0);
		}
		public TerminalNode PHP_INLINE() { return getToken(BladeAntlrParser.PHP_INLINE, 0); }
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
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_EXTENDS:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				extends_();
				}
				break;
			case D_SECTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				section_inline();
				}
				break;
			case D_YIELD:
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				yield();
				}
				break;
			case D_INCLUDE:
				enterOuterAlt(_localctx, 4);
				{
				setState(56);
				include();
				}
				break;
			case D_CUSTOM:
				enterOuterAlt(_localctx, 5);
				{
				setState(57);
				custom_directive();
				}
				break;
			case ESCAPED_ECHO_START:
				enterOuterAlt(_localctx, 6);
				{
				setState(58);
				echo();
				}
				break;
			case NE_ECHO_START:
				enterOuterAlt(_localctx, 7);
				{
				setState(59);
				echo_ne();
				}
				break;
			case D_VERBATIM:
				enterOuterAlt(_localctx, 8);
				{
				setState(60);
				verbatim_block();
				}
				break;
			case PHP_INLINE:
				enterOuterAlt(_localctx, 9);
				{
				setState(61);
				match(PHP_INLINE);
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
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
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
			setState(64);
			match(D_EXTENDS);
			setState(65);
			php_expression();
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
		public IfContext if_() {
			return getRuleContext(IfContext.class,0);
		}
		public ElseifContext elseif() {
			return getRuleContext(ElseifContext.class,0);
		}
		public ElseContext else_() {
			return getRuleContext(ElseContext.class,0);
		}
		public Php_bladeContext php_blade() {
			return getRuleContext(Php_bladeContext.class,0);
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
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SECTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				section();
				}
				break;
			case D_IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				if_();
				}
				break;
			case D_ELSEIF:
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				elseif();
				}
				break;
			case D_ELSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
				else_();
				}
				break;
			case D_PHP:
				enterOuterAlt(_localctx, 5);
				{
				setState(71);
				php_blade();
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
	public static class Non_blade_statementContext extends ParserRuleContext {
		public HtmlContext html() {
			return getRuleContext(HtmlContext.class,0);
		}
		public Non_blade_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_blade_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterNon_blade_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitNon_blade_statement(this);
		}
	}

	public final Non_blade_statementContext non_blade_statement() throws RecognitionException {
		Non_blade_statementContext _localctx = new Non_blade_statementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_non_blade_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			html();
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
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
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
		enterRule(_localctx, 12, RULE_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(D_SECTION);
			setState(77);
			php_expression();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 296486964992L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 187L) != 0)) {
				{
				{
				setState(78);
				general_statement();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
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
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
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
		enterRule(_localctx, 14, RULE_section_inline);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(D_SECTION);
			setState(87);
			php_expression();
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
	public static class IfContext extends ParserRuleContext {
		public List<TerminalNode> D_IF() { return getTokens(BladeAntlrParser.D_IF); }
		public TerminalNode D_IF(int i) {
			return getToken(BladeAntlrParser.D_IF, i);
		}
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public TerminalNode D_ELSEIF() { return getToken(BladeAntlrParser.D_ELSEIF, 0); }
		public TerminalNode D_ELSE() { return getToken(BladeAntlrParser.D_ELSE, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public TerminalNode D_ENDIF() { return getToken(BladeAntlrParser.D_ENDIF, 0); }
		public IfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitIf(this);
		}
	}

	public final IfContext if_() throws RecognitionException {
		IfContext _localctx = new IfContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_if);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(D_IF);
			setState(90);
			php_expression();
			setState(94);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(91);
					general_statement();
					}
					} 
				}
				setState(96);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(97);
				match(D_ENDIF);
				}
				break;
			}
			setState(100);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3584L) != 0)) ) {
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
	public static class ElseifContext extends ParserRuleContext {
		public List<TerminalNode> D_ELSEIF() { return getTokens(BladeAntlrParser.D_ELSEIF); }
		public TerminalNode D_ELSEIF(int i) {
			return getToken(BladeAntlrParser.D_ELSEIF, i);
		}
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public TerminalNode D_IF() { return getToken(BladeAntlrParser.D_IF, 0); }
		public TerminalNode D_ELSE() { return getToken(BladeAntlrParser.D_ELSE, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public TerminalNode D_ENDIF() { return getToken(BladeAntlrParser.D_ENDIF, 0); }
		public ElseifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterElseif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitElseif(this);
		}
	}

	public final ElseifContext elseif() throws RecognitionException {
		ElseifContext _localctx = new ElseifContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_elseif);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(D_ELSEIF);
			setState(103);
			php_expression();
			setState(107);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(104);
					general_statement();
					}
					} 
				}
				setState(109);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(110);
				match(D_ENDIF);
				}
				break;
			}
			setState(113);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3584L) != 0)) ) {
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
	public static class ElseContext extends ParserRuleContext {
		public List<TerminalNode> D_ELSE() { return getTokens(BladeAntlrParser.D_ELSE); }
		public TerminalNode D_ELSE(int i) {
			return getToken(BladeAntlrParser.D_ELSE, i);
		}
		public TerminalNode D_IF() { return getToken(BladeAntlrParser.D_IF, 0); }
		public TerminalNode D_ELSEIF() { return getToken(BladeAntlrParser.D_ELSEIF, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public TerminalNode D_ENDIF() { return getToken(BladeAntlrParser.D_ENDIF, 0); }
		public ElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitElse(this);
		}
	}

	public final ElseContext else_() throws RecognitionException {
		ElseContext _localctx = new ElseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_else);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(D_ELSE);
			setState(119);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(116);
					general_statement();
					}
					} 
				}
				setState(121);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(122);
				match(D_ENDIF);
				}
				break;
			}
			setState(125);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3584L) != 0)) ) {
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
	public static class YieldContext extends ParserRuleContext {
		public TerminalNode D_YIELD() { return getToken(BladeAntlrParser.D_YIELD, 0); }
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public YieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yield; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterYield(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitYield(this);
		}
	}

	public final YieldContext yield() throws RecognitionException {
		YieldContext _localctx = new YieldContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_yield);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(D_YIELD);
			setState(128);
			php_expression();
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
	public static class IncludeContext extends ParserRuleContext {
		public TerminalNode D_INCLUDE() { return getToken(BladeAntlrParser.D_INCLUDE, 0); }
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public IncludeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterInclude(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitInclude(this);
		}
	}

	public final IncludeContext include() throws RecognitionException {
		IncludeContext _localctx = new IncludeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_include);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(D_INCLUDE);
			setState(131);
			php_expression();
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
	public static class Custom_directiveContext extends ParserRuleContext {
		public TerminalNode D_CUSTOM() { return getToken(BladeAntlrParser.D_CUSTOM, 0); }
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public Custom_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_custom_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterCustom_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitCustom_directive(this);
		}
	}

	public final Custom_directiveContext custom_directive() throws RecognitionException {
		Custom_directiveContext _localctx = new Custom_directiveContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_custom_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(D_CUSTOM);
			setState(134);
			php_expression();
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
	public static class Php_bladeContext extends ParserRuleContext {
		public TerminalNode D_PHP() { return getToken(BladeAntlrParser.D_PHP, 0); }
		public TerminalNode BLADE_PHP_INLINE() { return getToken(BladeAntlrParser.BLADE_PHP_INLINE, 0); }
		public TerminalNode D_ENDPHP() { return getToken(BladeAntlrParser.D_ENDPHP, 0); }
		public Php_bladeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_php_blade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterPhp_blade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitPhp_blade(this);
		}
	}

	public final Php_bladeContext php_blade() throws RecognitionException {
		Php_bladeContext _localctx = new Php_bladeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_php_blade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(D_PHP);
			setState(137);
			match(BLADE_PHP_INLINE);
			setState(138);
			match(D_ENDPHP);
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
	public static class EchoContext extends ParserRuleContext {
		public TerminalNode ESCAPED_ECHO_START() { return getToken(BladeAntlrParser.ESCAPED_ECHO_START, 0); }
		public TerminalNode BLADE_PHP_ECHO_EXPR() { return getToken(BladeAntlrParser.BLADE_PHP_ECHO_EXPR, 0); }
		public TerminalNode ESCAPED_ECHO_END() { return getToken(BladeAntlrParser.ESCAPED_ECHO_END, 0); }
		public EchoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_echo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterEcho(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitEcho(this);
		}
	}

	public final EchoContext echo() throws RecognitionException {
		EchoContext _localctx = new EchoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_echo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(ESCAPED_ECHO_START);
			setState(141);
			match(BLADE_PHP_ECHO_EXPR);
			setState(142);
			match(ESCAPED_ECHO_END);
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
	public static class Echo_neContext extends ParserRuleContext {
		public TerminalNode NE_ECHO_START() { return getToken(BladeAntlrParser.NE_ECHO_START, 0); }
		public TerminalNode BLADE_PHP_ECHO_EXPR() { return getToken(BladeAntlrParser.BLADE_PHP_ECHO_EXPR, 0); }
		public TerminalNode NE_ECHO_END() { return getToken(BladeAntlrParser.NE_ECHO_END, 0); }
		public Echo_neContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_echo_ne; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterEcho_ne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitEcho_ne(this);
		}
	}

	public final Echo_neContext echo_ne() throws RecognitionException {
		Echo_neContext _localctx = new Echo_neContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_echo_ne);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(NE_ECHO_START);
			setState(145);
			match(BLADE_PHP_ECHO_EXPR);
			setState(146);
			match(NE_ECHO_END);
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
	public static class Php_expressionContext extends ParserRuleContext {
		public TerminalNode PHP_EXPRESSION() { return getToken(BladeAntlrParser.PHP_EXPRESSION, 0); }
		public TerminalNode WS_EXPR() { return getToken(BladeAntlrParser.WS_EXPR, 0); }
		public Php_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_php_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterPhp_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitPhp_expression(this);
		}
	}

	public final Php_expressionContext php_expression() throws RecognitionException {
		Php_expressionContext _localctx = new Php_expressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_php_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS_EXPR) {
				{
				setState(148);
				match(WS_EXPR);
				}
			}

			setState(151);
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
	public static class Verbatim_blockContext extends ParserRuleContext {
		public TerminalNode D_VERBATIM() { return getToken(BladeAntlrParser.D_VERBATIM, 0); }
		public TerminalNode D_ENDVERBATIM() { return getToken(BladeAntlrParser.D_ENDVERBATIM, 0); }
		public List<Non_blade_statementContext> non_blade_statement() {
			return getRuleContexts(Non_blade_statementContext.class);
		}
		public Non_blade_statementContext non_blade_statement(int i) {
			return getRuleContext(Non_blade_statementContext.class,i);
		}
		public Verbatim_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verbatim_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterVerbatim_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitVerbatim_block(this);
		}
	}

	public final Verbatim_blockContext verbatim_block() throws RecognitionException {
		Verbatim_blockContext _localctx = new Verbatim_blockContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_verbatim_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(D_VERBATIM);
			setState(155); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(154);
				non_blade_statement();
				}
				}
				setState(157); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==HTML );
			setState(159);
			match(D_ENDVERBATIM);
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
		enterRule(_localctx, 38, RULE_html);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(162); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(161);
					match(HTML);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(164); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		"\u0004\u0001R\u00a7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0005\u0000*\b\u0000\n\u0000\f\u0000"+
		"-\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u00014\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"?\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004I\b\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006P\b\u0006"+
		"\n\u0006\f\u0006S\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005\b]\b\b\n\b\f\b`\t\b\u0001\b"+
		"\u0003\bc\b\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0005\tj\b\t\n\t"+
		"\f\tm\t\t\u0001\t\u0003\tp\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0005\n"+
		"v\b\n\n\n\f\ny\t\n\u0001\n\u0003\n|\b\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0003\u0011\u0096\b\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0004\u0012\u009c\b\u0012\u000b\u0012\f\u0012\u009d\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0004\u0013\u00a3\b\u0013\u000b\u0013\f\u0013"+
		"\u00a4\u0001\u0013\u0000\u0000\u0014\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&\u0000\u0001\u0001"+
		"\u0000\t\u000b\u00ab\u0000+\u0001\u0000\u0000\u0000\u00023\u0001\u0000"+
		"\u0000\u0000\u0004>\u0001\u0000\u0000\u0000\u0006@\u0001\u0000\u0000\u0000"+
		"\bH\u0001\u0000\u0000\u0000\nJ\u0001\u0000\u0000\u0000\fL\u0001\u0000"+
		"\u0000\u0000\u000eV\u0001\u0000\u0000\u0000\u0010Y\u0001\u0000\u0000\u0000"+
		"\u0012f\u0001\u0000\u0000\u0000\u0014s\u0001\u0000\u0000\u0000\u0016\u007f"+
		"\u0001\u0000\u0000\u0000\u0018\u0082\u0001\u0000\u0000\u0000\u001a\u0085"+
		"\u0001\u0000\u0000\u0000\u001c\u0088\u0001\u0000\u0000\u0000\u001e\u008c"+
		"\u0001\u0000\u0000\u0000 \u0090\u0001\u0000\u0000\u0000\"\u0095\u0001"+
		"\u0000\u0000\u0000$\u0099\u0001\u0000\u0000\u0000&\u00a2\u0001\u0000\u0000"+
		"\u0000(*\u0003\u0002\u0001\u0000)(\u0001\u0000\u0000\u0000*-\u0001\u0000"+
		"\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,.\u0001"+
		"\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000./\u0005\u0000\u0000\u0001"+
		"/\u0001\u0001\u0000\u0000\u000004\u0003\u0004\u0002\u000014\u0003\b\u0004"+
		"\u000024\u0003&\u0013\u000030\u0001\u0000\u0000\u000031\u0001\u0000\u0000"+
		"\u000032\u0001\u0000\u0000\u00004\u0003\u0001\u0000\u0000\u00005?\u0003"+
		"\u0006\u0003\u00006?\u0003\u000e\u0007\u00007?\u0003\u0016\u000b\u0000"+
		"8?\u0003\u0018\f\u00009?\u0003\u001a\r\u0000:?\u0003\u001e\u000f\u0000"+
		";?\u0003 \u0010\u0000<?\u0003$\u0012\u0000=?\u0005\b\u0000\u0000>5\u0001"+
		"\u0000\u0000\u0000>6\u0001\u0000\u0000\u0000>7\u0001\u0000\u0000\u0000"+
		">8\u0001\u0000\u0000\u0000>9\u0001\u0000\u0000\u0000>:\u0001\u0000\u0000"+
		"\u0000>;\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000>=\u0001\u0000"+
		"\u0000\u0000?\u0005\u0001\u0000\u0000\u0000@A\u0005 \u0000\u0000AB\u0003"+
		"\"\u0011\u0000B\u0007\u0001\u0000\u0000\u0000CI\u0003\f\u0006\u0000DI"+
		"\u0003\u0010\b\u0000EI\u0003\u0012\t\u0000FI\u0003\u0014\n\u0000GI\u0003"+
		"\u001c\u000e\u0000HC\u0001\u0000\u0000\u0000HD\u0001\u0000\u0000\u0000"+
		"HE\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HG\u0001\u0000\u0000"+
		"\u0000I\t\u0001\u0000\u0000\u0000JK\u0003&\u0013\u0000K\u000b\u0001\u0000"+
		"\u0000\u0000LM\u0005\"\u0000\u0000MQ\u0003\"\u0011\u0000NP\u0003\u0002"+
		"\u0001\u0000ON\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001"+
		"\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RT\u0001\u0000\u0000\u0000"+
		"SQ\u0001\u0000\u0000\u0000TU\u0005%\u0000\u0000U\r\u0001\u0000\u0000\u0000"+
		"VW\u0005\"\u0000\u0000WX\u0003\"\u0011\u0000X\u000f\u0001\u0000\u0000"+
		"\u0000YZ\u0005\t\u0000\u0000Z^\u0003\"\u0011\u0000[]\u0003\u0002\u0001"+
		"\u0000\\[\u0001\u0000\u0000\u0000]`\u0001\u0000\u0000\u0000^\\\u0001\u0000"+
		"\u0000\u0000^_\u0001\u0000\u0000\u0000_b\u0001\u0000\u0000\u0000`^\u0001"+
		"\u0000\u0000\u0000ac\u0005\f\u0000\u0000ba\u0001\u0000\u0000\u0000bc\u0001"+
		"\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000de\b\u0000\u0000\u0000e\u0011"+
		"\u0001\u0000\u0000\u0000fg\u0005\n\u0000\u0000gk\u0003\"\u0011\u0000h"+
		"j\u0003\u0002\u0001\u0000ih\u0001\u0000\u0000\u0000jm\u0001\u0000\u0000"+
		"\u0000ki\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lo\u0001\u0000"+
		"\u0000\u0000mk\u0001\u0000\u0000\u0000np\u0005\f\u0000\u0000on\u0001\u0000"+
		"\u0000\u0000op\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qr\b\u0000"+
		"\u0000\u0000r\u0013\u0001\u0000\u0000\u0000sw\u0005\u000b\u0000\u0000"+
		"tv\u0003\u0002\u0001\u0000ut\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000"+
		"\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000x{\u0001\u0000"+
		"\u0000\u0000yw\u0001\u0000\u0000\u0000z|\u0005\f\u0000\u0000{z\u0001\u0000"+
		"\u0000\u0000{|\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}~\b\u0000"+
		"\u0000\u0000~\u0015\u0001\u0000\u0000\u0000\u007f\u0080\u0005&\u0000\u0000"+
		"\u0080\u0081\u0003\"\u0011\u0000\u0081\u0017\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0005\u001b\u0000\u0000\u0083\u0084\u0003\"\u0011\u0000\u0084\u0019"+
		"\u0001\u0000\u0000\u0000\u0085\u0086\u0005G\u0000\u0000\u0086\u0087\u0003"+
		"\"\u0011\u0000\u0087\u001b\u0001\u0000\u0000\u0000\u0088\u0089\u0005D"+
		"\u0000\u0000\u0089\u008a\u0005P\u0000\u0000\u008a\u008b\u0005O\u0000\u0000"+
		"\u008b\u001d\u0001\u0000\u0000\u0000\u008c\u008d\u0005H\u0000\u0000\u008d"+
		"\u008e\u0005\u0005\u0000\u0000\u008e\u008f\u0005L\u0000\u0000\u008f\u001f"+
		"\u0001\u0000\u0000\u0000\u0090\u0091\u0005I\u0000\u0000\u0091\u0092\u0005"+
		"\u0005\u0000\u0000\u0092\u0093\u0005M\u0000\u0000\u0093!\u0001\u0000\u0000"+
		"\u0000\u0094\u0096\u0005N\u0000\u0000\u0095\u0094\u0001\u0000\u0000\u0000"+
		"\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000"+
		"\u0097\u0098\u0005\u0004\u0000\u0000\u0098#\u0001\u0000\u0000\u0000\u0099"+
		"\u009b\u0005E\u0000\u0000\u009a\u009c\u0003\n\u0005\u0000\u009b\u009a"+
		"\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009b"+
		"\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0001\u0000\u0000\u0000\u009f\u00a0\u0005F\u0000\u0000\u00a0%\u0001\u0000"+
		"\u0000\u0000\u00a1\u00a3\u0005K\u0000\u0000\u00a2\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\'\u0001\u0000\u0000\u0000"+
		"\u000e+3>HQ^bkow{\u0095\u009d\u00a4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}