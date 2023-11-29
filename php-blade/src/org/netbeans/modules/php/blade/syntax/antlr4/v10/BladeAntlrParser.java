// Generated from BladeAntlrParser.g4 by ANTLR 4.13.0

  package org.netbeans.modules.php.blade.syntax.antlr4.v10;

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
		TOKEN_REF=1, RULE_REF=2, LEXER_CHAR_SET=3, PHP_EXPRESSION=4, PHP_VARIABLE=5, 
		PHP_KEYWORD=6, BLADE_PARAM_EXTRA=7, BLADE_PARAM_LPAREN=8, BLADE_PARAM_RPAREN=9, 
		BLADE_PHP_ECHO_EXPR=10, ERROR=11, BLADE_COMMENT=12, PHP_INLINE=13, D_IF=14, 
		D_ELSEIF=15, D_ELSE=16, D_ENDIF=17, D_SWITCH=18, D_CASE=19, D_ENDSWITCH=20, 
		D_EACH=21, D_FOREACH=22, D_ENDFOREACH=23, D_FOR=24, D_ENDFOR=25, D_FORELSE=26, 
		D_ENDFORELSE=27, D_WHILE=28, D_ENDWHILE=29, D_CONTINUE=30, D_BREAK=31, 
		D_INCLUDE=32, D_INCLUDE_IF=33, D_INCLUDE_WHEN=34, D_INCLUDE_FIRST=35, 
		D_INCLUDE_UNLESS=36, D_EXTENDS=37, D_JS=38, D_SECTION=39, D_HAS_SECTION=40, 
		D_SECTION_MISSING=41, D_ENDSECTION=42, D_YIELD=43, D_PARENT=44, D_SHOW=45, 
		D_OVERWRITE=46, D_STOP=47, D_ONCE=48, D_ENDONCE=49, D_PUSH=50, D_ENDPUSH=51, 
		D_PUSH_ONCE=52, D_ENDPUSH_ONCE=53, D_PROPS=54, D_CSRF=55, D_METHOD=56, 
		D_ERROR=57, D_ENDERROR=58, D_PRODUCTION=59, D_ENDPRODUCTION=60, D_CLASS=61, 
		D_STYLE=62, D_CHECKED=63, D_SELECTED=64, D_DISABLED=65, D_READONLY=66, 
		D_REQUIRED=67, D_AWARE=68, D_EMPTY=69, D_ENDEMPTY=70, D_JSON=71, D_INJECT=72, 
		D_DD=73, D_PHP=74, D_VERBATIM=75, D_ENDVERBATIM=76, D_CUSTOM=77, ESCAPED_ECHO_START=78, 
		NE_ECHO_START=79, AT=80, HTML=81, ESCAPED_ECHO_END=82, NE_ECHO_END=83, 
		WS_EXPR=84, WS_BL_PARAM=85, BL_PARAM_LINE_COMMENT=86, BL_PARAM_STRING=87, 
		BL_PARAM_CONCAT_OPERATOR=88, BL_PARAM_COMMA=89, BL_COMMA=90, BL_PARAM_WS=91, 
		BL_NAME_STRING=92, D_ENDPHP=93, BLADE_PHP_INLINE=94, ESCAPE_ECHO=95, OPEN_EXPR_PAREN_MORE=96, 
		BL_PARAM_PHP_VARIABLE=97;
	public static final int
		RULE_file = 0, RULE_general_statement = 1, RULE_inline_statement = 2, 
		RULE_block_statement = 3, RULE_non_blade_statement = 4, RULE_extends = 5, 
		RULE_section_inline = 6, RULE_section = 7, RULE_if = 8, RULE_elseif = 9, 
		RULE_else = 10, RULE_while = 11, RULE_foreach = 12, RULE_yield = 13, RULE_include = 14, 
		RULE_hasSection = 15, RULE_custom_directive = 16, RULE_php_blade = 17, 
		RULE_echo = 18, RULE_echo_ne = 19, RULE_php_expression = 20, RULE_bl_sg_param = 21, 
		RULE_bl_sg_default_param = 22, RULE_default_blade_param_expression = 23, 
		RULE_blade_params_expression = 24, RULE_blade_parameter = 25, RULE_verbatim_block = 26, 
		RULE_html = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "general_statement", "inline_statement", "block_statement", "non_blade_statement", 
			"extends", "section_inline", "section", "if", "elseif", "else", "while", 
			"foreach", "yield", "include", "hasSection", "custom_directive", "php_blade", 
			"echo", "echo_ne", "php_expression", "bl_sg_param", "bl_sg_default_param", 
			"default_blade_param_expression", "blade_params_expression", "blade_parameter", 
			"verbatim_block", "html"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "'@if'", "'@elseif'", "'@else'", "'@endif'", "'@switch'", 
			"'@case'", "'@endswitch'", "'@each'", "'@foreach'", "'@endforeach'", 
			"'@for'", "'@endfor'", "'@forelse'", "'@endforelse'", "'@while'", "'@endwhile'", 
			"'@continue'", "'@break'", "'@include'", "'@includeIf'", "'@includeWhen'", 
			"'@includeFirst'", "'@includeUnless'", "'@extends'", "'@js'", "'@section'", 
			"'@hasSection'", "'@sectionMissing'", "'@endsection'", "'@yield'", "'@parent'", 
			"'@show'", "'@overwrite'", "'@stop'", "'@once'", "'@endonce'", "'@push'", 
			"'@endpush'", "'@pushOnce'", "'@endPushOnce'", "'@props'", "'@csrf'", 
			"'@method'", "'@error'", "'@enderror'", "'@production'", "'@endproduction'", 
			"'@class'", "'@style'", "'@checked'", "'@selected'", "'@disabled'", "'@readonly'", 
			"'@required'", "'@aware'", "'@empty'", "'@endempty'", "'@json'", "'@inject'", 
			"'@dd'", "'@php'", "'@verbatim'", null, null, "'{{'", "'{!!'", "'@'", 
			null, null, null, null, null, null, null, "'.'", null, "','", null, null, 
			"'@endphp'", null, "'@{'", "'('"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TOKEN_REF", "RULE_REF", "LEXER_CHAR_SET", "PHP_EXPRESSION", "PHP_VARIABLE", 
			"PHP_KEYWORD", "BLADE_PARAM_EXTRA", "BLADE_PARAM_LPAREN", "BLADE_PARAM_RPAREN", 
			"BLADE_PHP_ECHO_EXPR", "ERROR", "BLADE_COMMENT", "PHP_INLINE", "D_IF", 
			"D_ELSEIF", "D_ELSE", "D_ENDIF", "D_SWITCH", "D_CASE", "D_ENDSWITCH", 
			"D_EACH", "D_FOREACH", "D_ENDFOREACH", "D_FOR", "D_ENDFOR", "D_FORELSE", 
			"D_ENDFORELSE", "D_WHILE", "D_ENDWHILE", "D_CONTINUE", "D_BREAK", "D_INCLUDE", 
			"D_INCLUDE_IF", "D_INCLUDE_WHEN", "D_INCLUDE_FIRST", "D_INCLUDE_UNLESS", 
			"D_EXTENDS", "D_JS", "D_SECTION", "D_HAS_SECTION", "D_SECTION_MISSING", 
			"D_ENDSECTION", "D_YIELD", "D_PARENT", "D_SHOW", "D_OVERWRITE", "D_STOP", 
			"D_ONCE", "D_ENDONCE", "D_PUSH", "D_ENDPUSH", "D_PUSH_ONCE", "D_ENDPUSH_ONCE", 
			"D_PROPS", "D_CSRF", "D_METHOD", "D_ERROR", "D_ENDERROR", "D_PRODUCTION", 
			"D_ENDPRODUCTION", "D_CLASS", "D_STYLE", "D_CHECKED", "D_SELECTED", "D_DISABLED", 
			"D_READONLY", "D_REQUIRED", "D_AWARE", "D_EMPTY", "D_ENDEMPTY", "D_JSON", 
			"D_INJECT", "D_DD", "D_PHP", "D_VERBATIM", "D_ENDVERBATIM", "D_CUSTOM", 
			"ESCAPED_ECHO_START", "NE_ECHO_START", "AT", "HTML", "ESCAPED_ECHO_END", 
			"NE_ECHO_END", "WS_EXPR", "WS_BL_PARAM", "BL_PARAM_LINE_COMMENT", "BL_PARAM_STRING", 
			"BL_PARAM_CONCAT_OPERATOR", "BL_PARAM_COMMA", "BL_COMMA", "BL_PARAM_WS", 
			"BL_NAME_STRING", "D_ENDPHP", "BLADE_PHP_INLINE", "ESCAPE_ECHO", "OPEN_EXPR_PAREN_MORE", 
			"BL_PARAM_PHP_VARIABLE"
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
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2305832421846552576L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 191501L) != 0)) {
				{
				{
				setState(56);
				general_statement();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
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
		public TerminalNode BLADE_COMMENT() { return getToken(BladeAntlrParser.BLADE_COMMENT, 0); }
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
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				inline_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				block_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				match(BLADE_COMMENT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
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
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public TerminalNode D_CLASS() { return getToken(BladeAntlrParser.D_CLASS, 0); }
		public TerminalNode D_STYLE() { return getToken(BladeAntlrParser.D_STYLE, 0); }
		public TerminalNode D_CHECKED() { return getToken(BladeAntlrParser.D_CHECKED, 0); }
		public TerminalNode D_SELECTED() { return getToken(BladeAntlrParser.D_SELECTED, 0); }
		public TerminalNode D_READONLY() { return getToken(BladeAntlrParser.D_READONLY, 0); }
		public TerminalNode D_REQUIRED() { return getToken(BladeAntlrParser.D_REQUIRED, 0); }
		public EchoContext echo() {
			return getRuleContext(EchoContext.class,0);
		}
		public Echo_neContext echo_ne() {
			return getRuleContext(Echo_neContext.class,0);
		}
		public Custom_directiveContext custom_directive() {
			return getRuleContext(Custom_directiveContext.class,0);
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
		int _la;
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_EXTENDS:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				extends_();
				}
				break;
			case D_SECTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				section_inline();
				}
				break;
			case D_YIELD:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				yield();
				}
				break;
			case D_INCLUDE:
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				include();
				}
				break;
			case D_CLASS:
			case D_STYLE:
				enterOuterAlt(_localctx, 5);
				{
				setState(74);
				_la = _input.LA(1);
				if ( !(_la==D_CLASS || _la==D_STYLE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(75);
				php_expression();
				}
				break;
			case D_CHECKED:
			case D_SELECTED:
			case D_READONLY:
			case D_REQUIRED:
				enterOuterAlt(_localctx, 6);
				{
				setState(76);
				_la = _input.LA(1);
				if ( !(((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & 27L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(77);
				php_expression();
				}
				break;
			case ESCAPED_ECHO_START:
				enterOuterAlt(_localctx, 7);
				{
				setState(78);
				echo();
				}
				break;
			case NE_ECHO_START:
				enterOuterAlt(_localctx, 8);
				{
				setState(79);
				echo_ne();
				}
				break;
			case D_CUSTOM:
				enterOuterAlt(_localctx, 9);
				{
				setState(80);
				custom_directive();
				}
				break;
			case PHP_INLINE:
				enterOuterAlt(_localctx, 10);
				{
				setState(81);
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
	public static class Block_statementContext extends ParserRuleContext {
		public SectionContext section() {
			return getRuleContext(SectionContext.class,0);
		}
		public HasSectionContext hasSection() {
			return getRuleContext(HasSectionContext.class,0);
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
		public WhileContext while_() {
			return getRuleContext(WhileContext.class,0);
		}
		public ForeachContext foreach() {
			return getRuleContext(ForeachContext.class,0);
		}
		public Verbatim_blockContext verbatim_block() {
			return getRuleContext(Verbatim_blockContext.class,0);
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
		enterRule(_localctx, 6, RULE_block_statement);
		try {
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SECTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				section();
				}
				break;
			case D_HAS_SECTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				hasSection();
				}
				break;
			case D_IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
				if_();
				}
				break;
			case D_ELSEIF:
				enterOuterAlt(_localctx, 4);
				{
				setState(87);
				elseif();
				}
				break;
			case D_ELSE:
				enterOuterAlt(_localctx, 5);
				{
				setState(88);
				else_();
				}
				break;
			case D_WHILE:
				enterOuterAlt(_localctx, 6);
				{
				setState(89);
				while_();
				}
				break;
			case D_FOREACH:
				enterOuterAlt(_localctx, 7);
				{
				setState(90);
				foreach();
				}
				break;
			case D_VERBATIM:
				enterOuterAlt(_localctx, 8);
				{
				setState(91);
				verbatim_block();
				}
				break;
			case D_PHP:
				enterOuterAlt(_localctx, 9);
				{
				setState(92);
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
		enterRule(_localctx, 8, RULE_non_blade_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
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
	public static class ExtendsContext extends ParserRuleContext {
		public TerminalNode D_EXTENDS() { return getToken(BladeAntlrParser.D_EXTENDS, 0); }
		public Blade_params_expressionContext blade_params_expression() {
			return getRuleContext(Blade_params_expressionContext.class,0);
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
		enterRule(_localctx, 10, RULE_extends);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(D_EXTENDS);
			setState(98);
			blade_params_expression();
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
		public Bl_sg_default_paramContext bl_sg_default_param() {
			return getRuleContext(Bl_sg_default_paramContext.class,0);
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
		enterRule(_localctx, 12, RULE_section_inline);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(D_SECTION);
			setState(101);
			bl_sg_default_param();
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
		public Bl_sg_default_paramContext bl_sg_default_param() {
			return getRuleContext(Bl_sg_default_paramContext.class,0);
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
		enterRule(_localctx, 14, RULE_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(D_SECTION);
			setState(104);
			bl_sg_default_param();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2305832421846552576L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 191501L) != 0)) {
				{
				{
				setState(105);
				general_statement();
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111);
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
			setState(113);
			match(D_IF);
			setState(114);
			php_expression();
			setState(118);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(115);
					general_statement();
					}
					} 
				}
				setState(120);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(121);
				match(D_ENDIF);
				}
				break;
			}
			setState(124);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & 114688L) != 0)) ) {
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
			setState(126);
			match(D_ELSEIF);
			setState(127);
			php_expression();
			setState(131);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(128);
					general_statement();
					}
					} 
				}
				setState(133);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(134);
				match(D_ENDIF);
				}
				break;
			}
			setState(137);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & 114688L) != 0)) ) {
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
			setState(139);
			match(D_ELSE);
			setState(143);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(140);
					general_statement();
					}
					} 
				}
				setState(145);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(146);
				match(D_ENDIF);
				}
				break;
			}
			setState(149);
			_la = _input.LA(1);
			if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & 114688L) != 0)) ) {
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
	public static class WhileContext extends ParserRuleContext {
		public TerminalNode D_WHILE() { return getToken(BladeAntlrParser.D_WHILE, 0); }
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public TerminalNode D_ENDWHILE() { return getToken(BladeAntlrParser.D_ENDWHILE, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public WhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitWhile(this);
		}
	}

	public final WhileContext while_() throws RecognitionException {
		WhileContext _localctx = new WhileContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_while);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(D_WHILE);
			setState(152);
			php_expression();
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2305832421846552576L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 191501L) != 0)) {
				{
				{
				setState(153);
				general_statement();
				}
				}
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(159);
			match(D_ENDWHILE);
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
	public static class ForeachContext extends ParserRuleContext {
		public TerminalNode D_FOREACH() { return getToken(BladeAntlrParser.D_FOREACH, 0); }
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public TerminalNode D_ENDFOREACH() { return getToken(BladeAntlrParser.D_ENDFOREACH, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public ForeachContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreach; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterForeach(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitForeach(this);
		}
	}

	public final ForeachContext foreach() throws RecognitionException {
		ForeachContext _localctx = new ForeachContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_foreach);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(D_FOREACH);
			setState(162);
			php_expression();
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2305832421846552576L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 191501L) != 0)) {
				{
				{
				setState(163);
				general_statement();
				}
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(169);
			match(D_ENDFOREACH);
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
		public Bl_sg_default_paramContext bl_sg_default_param() {
			return getRuleContext(Bl_sg_default_paramContext.class,0);
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
		enterRule(_localctx, 26, RULE_yield);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(D_YIELD);
			setState(172);
			bl_sg_default_param();
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
		public Blade_params_expressionContext blade_params_expression() {
			return getRuleContext(Blade_params_expressionContext.class,0);
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
		enterRule(_localctx, 28, RULE_include);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(D_INCLUDE);
			setState(175);
			blade_params_expression();
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
	public static class HasSectionContext extends ParserRuleContext {
		public TerminalNode D_HAS_SECTION() { return getToken(BladeAntlrParser.D_HAS_SECTION, 0); }
		public Bl_sg_paramContext bl_sg_param() {
			return getRuleContext(Bl_sg_paramContext.class,0);
		}
		public TerminalNode D_ENDIF() { return getToken(BladeAntlrParser.D_ENDIF, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public HasSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hasSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterHasSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitHasSection(this);
		}
	}

	public final HasSectionContext hasSection() throws RecognitionException {
		HasSectionContext _localctx = new HasSectionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_hasSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(D_HAS_SECTION);
			setState(178);
			bl_sg_param();
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2305832421846552576L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 191501L) != 0)) {
				{
				{
				setState(179);
				general_statement();
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(185);
			match(D_ENDIF);
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
		public Blade_params_expressionContext blade_params_expression() {
			return getRuleContext(Blade_params_expressionContext.class,0);
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
		enterRule(_localctx, 32, RULE_custom_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(D_CUSTOM);
			setState(188);
			blade_params_expression();
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
		enterRule(_localctx, 34, RULE_php_blade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(D_PHP);
			setState(191);
			match(BLADE_PHP_INLINE);
			setState(192);
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
		enterRule(_localctx, 36, RULE_echo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(ESCAPED_ECHO_START);
			setState(195);
			match(BLADE_PHP_ECHO_EXPR);
			setState(196);
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
		enterRule(_localctx, 38, RULE_echo_ne);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(NE_ECHO_START);
			setState(199);
			match(BLADE_PHP_ECHO_EXPR);
			setState(200);
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
		enterRule(_localctx, 40, RULE_php_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS_EXPR) {
				{
				setState(202);
				match(WS_EXPR);
				}
			}

			setState(205);
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
	public static class Bl_sg_paramContext extends ParserRuleContext {
		public TerminalNode BLADE_PARAM_LPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, 0); }
		public Blade_parameterContext blade_parameter() {
			return getRuleContext(Blade_parameterContext.class,0);
		}
		public TerminalNode BLADE_PARAM_RPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, 0); }
		public List<TerminalNode> BL_PARAM_WS() { return getTokens(BladeAntlrParser.BL_PARAM_WS); }
		public TerminalNode BL_PARAM_WS(int i) {
			return getToken(BladeAntlrParser.BL_PARAM_WS, i);
		}
		public Default_blade_param_expressionContext default_blade_param_expression() {
			return getRuleContext(Default_blade_param_expressionContext.class,0);
		}
		public Bl_sg_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bl_sg_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterBl_sg_param(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitBl_sg_param(this);
		}
	}

	public final Bl_sg_paramContext bl_sg_param() throws RecognitionException {
		Bl_sg_paramContext _localctx = new Bl_sg_paramContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_bl_sg_param);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(BLADE_PARAM_LPAREN);
			setState(211);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(208);
					match(BL_PARAM_WS);
					}
					} 
				}
				setState(213);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(214);
			blade_parameter();
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(215);
				default_blade_param_expression();
				}
				break;
			}
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_PARAM_WS) {
				{
				{
				setState(218);
				match(BL_PARAM_WS);
				}
				}
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(224);
			match(BLADE_PARAM_RPAREN);
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
	public static class Bl_sg_default_paramContext extends ParserRuleContext {
		public TerminalNode BLADE_PARAM_LPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, 0); }
		public Blade_parameterContext blade_parameter() {
			return getRuleContext(Blade_parameterContext.class,0);
		}
		public TerminalNode BLADE_PARAM_RPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, 0); }
		public List<TerminalNode> BL_PARAM_WS() { return getTokens(BladeAntlrParser.BL_PARAM_WS); }
		public TerminalNode BL_PARAM_WS(int i) {
			return getToken(BladeAntlrParser.BL_PARAM_WS, i);
		}
		public Default_blade_param_expressionContext default_blade_param_expression() {
			return getRuleContext(Default_blade_param_expressionContext.class,0);
		}
		public Bl_sg_default_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bl_sg_default_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterBl_sg_default_param(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitBl_sg_default_param(this);
		}
	}

	public final Bl_sg_default_paramContext bl_sg_default_param() throws RecognitionException {
		Bl_sg_default_paramContext _localctx = new Bl_sg_default_paramContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_bl_sg_default_param);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(BLADE_PARAM_LPAREN);
			setState(230);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(227);
					match(BL_PARAM_WS);
					}
					} 
				}
				setState(232);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			setState(233);
			blade_parameter();
			setState(235);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(234);
				default_blade_param_expression();
				}
				break;
			}
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_PARAM_WS) {
				{
				{
				setState(237);
				match(BL_PARAM_WS);
				}
				}
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(243);
			match(BLADE_PARAM_RPAREN);
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
	public static class Default_blade_param_expressionContext extends ParserRuleContext {
		public TerminalNode BL_PARAM_COMMA() { return getToken(BladeAntlrParser.BL_PARAM_COMMA, 0); }
		public Blade_parameterContext blade_parameter() {
			return getRuleContext(Blade_parameterContext.class,0);
		}
		public List<TerminalNode> BL_PARAM_WS() { return getTokens(BladeAntlrParser.BL_PARAM_WS); }
		public TerminalNode BL_PARAM_WS(int i) {
			return getToken(BladeAntlrParser.BL_PARAM_WS, i);
		}
		public Default_blade_param_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_default_blade_param_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterDefault_blade_param_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitDefault_blade_param_expression(this);
		}
	}

	public final Default_blade_param_expressionContext default_blade_param_expression() throws RecognitionException {
		Default_blade_param_expressionContext _localctx = new Default_blade_param_expressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_default_blade_param_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_PARAM_WS) {
				{
				{
				setState(245);
				match(BL_PARAM_WS);
				}
				}
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(251);
			match(BL_PARAM_COMMA);
			setState(255);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(252);
					match(BL_PARAM_WS);
					}
					} 
				}
				setState(257);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(258);
			blade_parameter();
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
	public static class Blade_params_expressionContext extends ParserRuleContext {
		public TerminalNode BLADE_PARAM_LPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, 0); }
		public TerminalNode BLADE_PARAM_RPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, 0); }
		public List<TerminalNode> BL_PARAM_WS() { return getTokens(BladeAntlrParser.BL_PARAM_WS); }
		public TerminalNode BL_PARAM_WS(int i) {
			return getToken(BladeAntlrParser.BL_PARAM_WS, i);
		}
		public List<Blade_parameterContext> blade_parameter() {
			return getRuleContexts(Blade_parameterContext.class);
		}
		public Blade_parameterContext blade_parameter(int i) {
			return getRuleContext(Blade_parameterContext.class,i);
		}
		public List<TerminalNode> BL_PARAM_COMMA() { return getTokens(BladeAntlrParser.BL_PARAM_COMMA); }
		public TerminalNode BL_PARAM_COMMA(int i) {
			return getToken(BladeAntlrParser.BL_PARAM_COMMA, i);
		}
		public Blade_params_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blade_params_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterBlade_params_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitBlade_params_expression(this);
		}
	}

	public final Blade_params_expressionContext blade_params_expression() throws RecognitionException {
		Blade_params_expressionContext _localctx = new Blade_params_expressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_blade_params_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(BLADE_PARAM_LPAREN);
			setState(264);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(261);
					match(BL_PARAM_WS);
					}
					} 
				}
				setState(266);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			setState(283); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(267);
					blade_parameter();
					setState(271);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(268);
							match(BL_PARAM_WS);
							}
							} 
						}
						setState(273);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
					}
					setState(275);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==BL_PARAM_COMMA) {
						{
						setState(274);
						match(BL_PARAM_COMMA);
						}
					}

					setState(280);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(277);
							match(BL_PARAM_WS);
							}
							} 
						}
						setState(282);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(285); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_PARAM_WS) {
				{
				{
				setState(287);
				match(BL_PARAM_WS);
				}
				}
				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(293);
			match(BLADE_PARAM_RPAREN);
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
	public static class Blade_parameterContext extends ParserRuleContext {
		public List<TerminalNode> BL_PARAM_STRING() { return getTokens(BladeAntlrParser.BL_PARAM_STRING); }
		public TerminalNode BL_PARAM_STRING(int i) {
			return getToken(BladeAntlrParser.BL_PARAM_STRING, i);
		}
		public List<TerminalNode> BLADE_PARAM_EXTRA() { return getTokens(BladeAntlrParser.BLADE_PARAM_EXTRA); }
		public TerminalNode BLADE_PARAM_EXTRA(int i) {
			return getToken(BladeAntlrParser.BLADE_PARAM_EXTRA, i);
		}
		public List<TerminalNode> BL_PARAM_PHP_VARIABLE() { return getTokens(BladeAntlrParser.BL_PARAM_PHP_VARIABLE); }
		public TerminalNode BL_PARAM_PHP_VARIABLE(int i) {
			return getToken(BladeAntlrParser.BL_PARAM_PHP_VARIABLE, i);
		}
		public List<TerminalNode> BL_PARAM_WS() { return getTokens(BladeAntlrParser.BL_PARAM_WS); }
		public TerminalNode BL_PARAM_WS(int i) {
			return getToken(BladeAntlrParser.BL_PARAM_WS, i);
		}
		public List<TerminalNode> BL_PARAM_CONCAT_OPERATOR() { return getTokens(BladeAntlrParser.BL_PARAM_CONCAT_OPERATOR); }
		public TerminalNode BL_PARAM_CONCAT_OPERATOR(int i) {
			return getToken(BladeAntlrParser.BL_PARAM_CONCAT_OPERATOR, i);
		}
		public List<TerminalNode> BL_NAME_STRING() { return getTokens(BladeAntlrParser.BL_NAME_STRING); }
		public TerminalNode BL_NAME_STRING(int i) {
			return getToken(BladeAntlrParser.BL_NAME_STRING, i);
		}
		public List<TerminalNode> BL_COMMA() { return getTokens(BladeAntlrParser.BL_COMMA); }
		public TerminalNode BL_COMMA(int i) {
			return getToken(BladeAntlrParser.BL_COMMA, i);
		}
		public Blade_parameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blade_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterBlade_parameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitBlade_parameter(this);
		}
	}

	public final Blade_parameterContext blade_parameter() throws RecognitionException {
		Blade_parameterContext _localctx = new Blade_parameterContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_blade_parameter);
		int _la;
		try {
			int _alt;
			setState(301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				match(BL_PARAM_STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(297); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(296);
						_la = _input.LA(1);
						if ( !(_la==BLADE_PARAM_EXTRA || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & 1083L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(299); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		enterRule(_localctx, 52, RULE_verbatim_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			match(D_VERBATIM);
			setState(305); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(304);
				non_blade_statement();
				}
				}
				setState(307); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==HTML );
			setState(309);
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
		enterRule(_localctx, 54, RULE_html);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(312); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(311);
					match(HTML);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(314); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
		"\u0004\u0001a\u013d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0001\u0000\u0005\u0000:\b\u0000\n\u0000\f\u0000=\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"E\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002S\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003^\b\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007k\b\u0007\n\u0007\f\u0007n\t\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005\bu\b\b\n\b\f\bx\t\b\u0001\b"+
		"\u0003\b{\b\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0005\t\u0082\b"+
		"\t\n\t\f\t\u0085\t\t\u0001\t\u0003\t\u0088\b\t\u0001\t\u0001\t\u0001\n"+
		"\u0001\n\u0005\n\u008e\b\n\n\n\f\n\u0091\t\n\u0001\n\u0003\n\u0094\b\n"+
		"\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u009b"+
		"\b\u000b\n\u000b\f\u000b\u009e\t\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0005\f\u00a5\b\f\n\f\f\f\u00a8\t\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0005\u000f\u00b5\b\u000f\n\u000f\f\u000f\u00b8\t\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0003\u0014\u00cc\b\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0005\u0015\u00d2\b\u0015\n\u0015\f\u0015\u00d5\t\u0015\u0001\u0015\u0001"+
		"\u0015\u0003\u0015\u00d9\b\u0015\u0001\u0015\u0005\u0015\u00dc\b\u0015"+
		"\n\u0015\f\u0015\u00df\t\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0005\u0016\u00e5\b\u0016\n\u0016\f\u0016\u00e8\t\u0016\u0001\u0016"+
		"\u0001\u0016\u0003\u0016\u00ec\b\u0016\u0001\u0016\u0005\u0016\u00ef\b"+
		"\u0016\n\u0016\f\u0016\u00f2\t\u0016\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0005\u0017\u00f7\b\u0017\n\u0017\f\u0017\u00fa\t\u0017\u0001\u0017\u0001"+
		"\u0017\u0005\u0017\u00fe\b\u0017\n\u0017\f\u0017\u0101\t\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0005\u0018\u0107\b\u0018\n\u0018"+
		"\f\u0018\u010a\t\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u010e\b\u0018"+
		"\n\u0018\f\u0018\u0111\t\u0018\u0001\u0018\u0003\u0018\u0114\b\u0018\u0001"+
		"\u0018\u0005\u0018\u0117\b\u0018\n\u0018\f\u0018\u011a\t\u0018\u0004\u0018"+
		"\u011c\b\u0018\u000b\u0018\f\u0018\u011d\u0001\u0018\u0005\u0018\u0121"+
		"\b\u0018\n\u0018\f\u0018\u0124\t\u0018\u0001\u0018\u0001\u0018\u0001\u0019"+
		"\u0001\u0019\u0004\u0019\u012a\b\u0019\u000b\u0019\f\u0019\u012b\u0003"+
		"\u0019\u012e\b\u0019\u0001\u001a\u0001\u001a\u0004\u001a\u0132\b\u001a"+
		"\u000b\u001a\f\u001a\u0133\u0001\u001a\u0001\u001a\u0001\u001b\u0004\u001b"+
		"\u0139\b\u001b\u000b\u001b\f\u001b\u013a\u0001\u001b\u0000\u0000\u001c"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.0246\u0000\u0004\u0001\u0000=>\u0002\u0000?@BC\u0001"+
		"\u0000\u000e\u0010\u0004\u0000\u0007\u0007WXZ\\aa\u0152\u0000;\u0001\u0000"+
		"\u0000\u0000\u0002D\u0001\u0000\u0000\u0000\u0004R\u0001\u0000\u0000\u0000"+
		"\u0006]\u0001\u0000\u0000\u0000\b_\u0001\u0000\u0000\u0000\na\u0001\u0000"+
		"\u0000\u0000\fd\u0001\u0000\u0000\u0000\u000eg\u0001\u0000\u0000\u0000"+
		"\u0010q\u0001\u0000\u0000\u0000\u0012~\u0001\u0000\u0000\u0000\u0014\u008b"+
		"\u0001\u0000\u0000\u0000\u0016\u0097\u0001\u0000\u0000\u0000\u0018\u00a1"+
		"\u0001\u0000\u0000\u0000\u001a\u00ab\u0001\u0000\u0000\u0000\u001c\u00ae"+
		"\u0001\u0000\u0000\u0000\u001e\u00b1\u0001\u0000\u0000\u0000 \u00bb\u0001"+
		"\u0000\u0000\u0000\"\u00be\u0001\u0000\u0000\u0000$\u00c2\u0001\u0000"+
		"\u0000\u0000&\u00c6\u0001\u0000\u0000\u0000(\u00cb\u0001\u0000\u0000\u0000"+
		"*\u00cf\u0001\u0000\u0000\u0000,\u00e2\u0001\u0000\u0000\u0000.\u00f8"+
		"\u0001\u0000\u0000\u00000\u0104\u0001\u0000\u0000\u00002\u012d\u0001\u0000"+
		"\u0000\u00004\u012f\u0001\u0000\u0000\u00006\u0138\u0001\u0000\u0000\u0000"+
		"8:\u0003\u0002\u0001\u000098\u0001\u0000\u0000\u0000:=\u0001\u0000\u0000"+
		"\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<>\u0001\u0000"+
		"\u0000\u0000=;\u0001\u0000\u0000\u0000>?\u0005\u0000\u0000\u0001?\u0001"+
		"\u0001\u0000\u0000\u0000@E\u0003\u0004\u0002\u0000AE\u0003\u0006\u0003"+
		"\u0000BE\u0005\f\u0000\u0000CE\u00036\u001b\u0000D@\u0001\u0000\u0000"+
		"\u0000DA\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000DC\u0001\u0000"+
		"\u0000\u0000E\u0003\u0001\u0000\u0000\u0000FS\u0003\n\u0005\u0000GS\u0003"+
		"\f\u0006\u0000HS\u0003\u001a\r\u0000IS\u0003\u001c\u000e\u0000JK\u0007"+
		"\u0000\u0000\u0000KS\u0003(\u0014\u0000LM\u0007\u0001\u0000\u0000MS\u0003"+
		"(\u0014\u0000NS\u0003$\u0012\u0000OS\u0003&\u0013\u0000PS\u0003 \u0010"+
		"\u0000QS\u0005\r\u0000\u0000RF\u0001\u0000\u0000\u0000RG\u0001\u0000\u0000"+
		"\u0000RH\u0001\u0000\u0000\u0000RI\u0001\u0000\u0000\u0000RJ\u0001\u0000"+
		"\u0000\u0000RL\u0001\u0000\u0000\u0000RN\u0001\u0000\u0000\u0000RO\u0001"+
		"\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RQ\u0001\u0000\u0000\u0000"+
		"S\u0005\u0001\u0000\u0000\u0000T^\u0003\u000e\u0007\u0000U^\u0003\u001e"+
		"\u000f\u0000V^\u0003\u0010\b\u0000W^\u0003\u0012\t\u0000X^\u0003\u0014"+
		"\n\u0000Y^\u0003\u0016\u000b\u0000Z^\u0003\u0018\f\u0000[^\u00034\u001a"+
		"\u0000\\^\u0003\"\u0011\u0000]T\u0001\u0000\u0000\u0000]U\u0001\u0000"+
		"\u0000\u0000]V\u0001\u0000\u0000\u0000]W\u0001\u0000\u0000\u0000]X\u0001"+
		"\u0000\u0000\u0000]Y\u0001\u0000\u0000\u0000]Z\u0001\u0000\u0000\u0000"+
		"][\u0001\u0000\u0000\u0000]\\\u0001\u0000\u0000\u0000^\u0007\u0001\u0000"+
		"\u0000\u0000_`\u00036\u001b\u0000`\t\u0001\u0000\u0000\u0000ab\u0005%"+
		"\u0000\u0000bc\u00030\u0018\u0000c\u000b\u0001\u0000\u0000\u0000de\u0005"+
		"\'\u0000\u0000ef\u0003,\u0016\u0000f\r\u0001\u0000\u0000\u0000gh\u0005"+
		"\'\u0000\u0000hl\u0003,\u0016\u0000ik\u0003\u0002\u0001\u0000ji\u0001"+
		"\u0000\u0000\u0000kn\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000"+
		"lm\u0001\u0000\u0000\u0000mo\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000"+
		"\u0000op\u0005*\u0000\u0000p\u000f\u0001\u0000\u0000\u0000qr\u0005\u000e"+
		"\u0000\u0000rv\u0003(\u0014\u0000su\u0003\u0002\u0001\u0000ts\u0001\u0000"+
		"\u0000\u0000ux\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001"+
		"\u0000\u0000\u0000wz\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000"+
		"y{\u0005\u0011\u0000\u0000zy\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000"+
		"\u0000{|\u0001\u0000\u0000\u0000|}\b\u0002\u0000\u0000}\u0011\u0001\u0000"+
		"\u0000\u0000~\u007f\u0005\u000f\u0000\u0000\u007f\u0083\u0003(\u0014\u0000"+
		"\u0080\u0082\u0003\u0002\u0001\u0000\u0081\u0080\u0001\u0000\u0000\u0000"+
		"\u0082\u0085\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000"+
		"\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0087\u0001\u0000\u0000\u0000"+
		"\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u0088\u0005\u0011\u0000\u0000"+
		"\u0087\u0086\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000"+
		"\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008a\b\u0002\u0000\u0000\u008a"+
		"\u0013\u0001\u0000\u0000\u0000\u008b\u008f\u0005\u0010\u0000\u0000\u008c"+
		"\u008e\u0003\u0002\u0001\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008e"+
		"\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0001\u0000\u0000\u0000\u0090\u0093\u0001\u0000\u0000\u0000\u0091"+
		"\u008f\u0001\u0000\u0000\u0000\u0092\u0094\u0005\u0011\u0000\u0000\u0093"+
		"\u0092\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094"+
		"\u0095\u0001\u0000\u0000\u0000\u0095\u0096\b\u0002\u0000\u0000\u0096\u0015"+
		"\u0001\u0000\u0000\u0000\u0097\u0098\u0005\u001c\u0000\u0000\u0098\u009c"+
		"\u0003(\u0014\u0000\u0099\u009b\u0003\u0002\u0001\u0000\u009a\u0099\u0001"+
		"\u0000\u0000\u0000\u009b\u009e\u0001\u0000\u0000\u0000\u009c\u009a\u0001"+
		"\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009f\u0001"+
		"\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009f\u00a0\u0005"+
		"\u001d\u0000\u0000\u00a0\u0017\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005"+
		"\u0016\u0000\u0000\u00a2\u00a6\u0003(\u0014\u0000\u00a3\u00a5\u0003\u0002"+
		"\u0001\u0000\u00a4\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a8\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a9\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001\u0000"+
		"\u0000\u0000\u00a9\u00aa\u0005\u0017\u0000\u0000\u00aa\u0019\u0001\u0000"+
		"\u0000\u0000\u00ab\u00ac\u0005+\u0000\u0000\u00ac\u00ad\u0003,\u0016\u0000"+
		"\u00ad\u001b\u0001\u0000\u0000\u0000\u00ae\u00af\u0005 \u0000\u0000\u00af"+
		"\u00b0\u00030\u0018\u0000\u00b0\u001d\u0001\u0000\u0000\u0000\u00b1\u00b2"+
		"\u0005(\u0000\u0000\u00b2\u00b6\u0003*\u0015\u0000\u00b3\u00b5\u0003\u0002"+
		"\u0001\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b8\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000"+
		"\u0000\u0000\u00b7\u00b9\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b9\u00ba\u0005\u0011\u0000\u0000\u00ba\u001f\u0001\u0000"+
		"\u0000\u0000\u00bb\u00bc\u0005M\u0000\u0000\u00bc\u00bd\u00030\u0018\u0000"+
		"\u00bd!\u0001\u0000\u0000\u0000\u00be\u00bf\u0005J\u0000\u0000\u00bf\u00c0"+
		"\u0005^\u0000\u0000\u00c0\u00c1\u0005]\u0000\u0000\u00c1#\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c3\u0005N\u0000\u0000\u00c3\u00c4\u0005\n\u0000"+
		"\u0000\u00c4\u00c5\u0005R\u0000\u0000\u00c5%\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c7\u0005O\u0000\u0000\u00c7\u00c8\u0005\n\u0000\u0000\u00c8\u00c9"+
		"\u0005S\u0000\u0000\u00c9\'\u0001\u0000\u0000\u0000\u00ca\u00cc\u0005"+
		"T\u0000\u0000\u00cb\u00ca\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000"+
		"\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005\u0004"+
		"\u0000\u0000\u00ce)\u0001\u0000\u0000\u0000\u00cf\u00d3\u0005\b\u0000"+
		"\u0000\u00d0\u00d2\u0005[\u0000\u0000\u00d1\u00d0\u0001\u0000\u0000\u0000"+
		"\u00d2\u00d5\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000"+
		"\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d6\u0001\u0000\u0000\u0000"+
		"\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d6\u00d8\u00032\u0019\u0000\u00d7"+
		"\u00d9\u0003.\u0017\u0000\u00d8\u00d7\u0001\u0000\u0000\u0000\u00d8\u00d9"+
		"\u0001\u0000\u0000\u0000\u00d9\u00dd\u0001\u0000\u0000\u0000\u00da\u00dc"+
		"\u0005[\u0000\u0000\u00db\u00da\u0001\u0000\u0000\u0000\u00dc\u00df\u0001"+
		"\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00dd\u00de\u0001"+
		"\u0000\u0000\u0000\u00de\u00e0\u0001\u0000\u0000\u0000\u00df\u00dd\u0001"+
		"\u0000\u0000\u0000\u00e0\u00e1\u0005\t\u0000\u0000\u00e1+\u0001\u0000"+
		"\u0000\u0000\u00e2\u00e6\u0005\b\u0000\u0000\u00e3\u00e5\u0005[\u0000"+
		"\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e8\u0001\u0000\u0000"+
		"\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000"+
		"\u0000\u00e7\u00e9\u0001\u0000\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000"+
		"\u0000\u00e9\u00eb\u00032\u0019\u0000\u00ea\u00ec\u0003.\u0017\u0000\u00eb"+
		"\u00ea\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec"+
		"\u00f0\u0001\u0000\u0000\u0000\u00ed\u00ef\u0005[\u0000\u0000\u00ee\u00ed"+
		"\u0001\u0000\u0000\u0000\u00ef\u00f2\u0001\u0000\u0000\u0000\u00f0\u00ee"+
		"\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f3\u00f4"+
		"\u0005\t\u0000\u0000\u00f4-\u0001\u0000\u0000\u0000\u00f5\u00f7\u0005"+
		"[\u0000\u0000\u00f6\u00f5\u0001\u0000\u0000\u0000\u00f7\u00fa\u0001\u0000"+
		"\u0000\u0000\u00f8\u00f6\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000"+
		"\u0000\u0000\u00f9\u00fb\u0001\u0000\u0000\u0000\u00fa\u00f8\u0001\u0000"+
		"\u0000\u0000\u00fb\u00ff\u0005Y\u0000\u0000\u00fc\u00fe\u0005[\u0000\u0000"+
		"\u00fd\u00fc\u0001\u0000\u0000\u0000\u00fe\u0101\u0001\u0000\u0000\u0000"+
		"\u00ff\u00fd\u0001\u0000\u0000\u0000\u00ff\u0100\u0001\u0000\u0000\u0000"+
		"\u0100\u0102\u0001\u0000\u0000\u0000\u0101\u00ff\u0001\u0000\u0000\u0000"+
		"\u0102\u0103\u00032\u0019\u0000\u0103/\u0001\u0000\u0000\u0000\u0104\u0108"+
		"\u0005\b\u0000\u0000\u0105\u0107\u0005[\u0000\u0000\u0106\u0105\u0001"+
		"\u0000\u0000\u0000\u0107\u010a\u0001\u0000\u0000\u0000\u0108\u0106\u0001"+
		"\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109\u011b\u0001"+
		"\u0000\u0000\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010b\u010f\u0003"+
		"2\u0019\u0000\u010c\u010e\u0005[\u0000\u0000\u010d\u010c\u0001\u0000\u0000"+
		"\u0000\u010e\u0111\u0001\u0000\u0000\u0000\u010f\u010d\u0001\u0000\u0000"+
		"\u0000\u010f\u0110\u0001\u0000\u0000\u0000\u0110\u0113\u0001\u0000\u0000"+
		"\u0000\u0111\u010f\u0001\u0000\u0000\u0000\u0112\u0114\u0005Y\u0000\u0000"+
		"\u0113\u0112\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000"+
		"\u0114\u0118\u0001\u0000\u0000\u0000\u0115\u0117\u0005[\u0000\u0000\u0116"+
		"\u0115\u0001\u0000\u0000\u0000\u0117\u011a\u0001\u0000\u0000\u0000\u0118"+
		"\u0116\u0001\u0000\u0000\u0000\u0118\u0119\u0001\u0000\u0000\u0000\u0119"+
		"\u011c\u0001\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000\u0000\u011b"+
		"\u010b\u0001\u0000\u0000\u0000\u011c\u011d\u0001\u0000\u0000\u0000\u011d"+
		"\u011b\u0001\u0000\u0000\u0000\u011d\u011e\u0001\u0000\u0000\u0000\u011e"+
		"\u0122\u0001\u0000\u0000\u0000\u011f\u0121\u0005[\u0000\u0000\u0120\u011f"+
		"\u0001\u0000\u0000\u0000\u0121\u0124\u0001\u0000\u0000\u0000\u0122\u0120"+
		"\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123\u0125"+
		"\u0001\u0000\u0000\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0125\u0126"+
		"\u0005\t\u0000\u0000\u01261\u0001\u0000\u0000\u0000\u0127\u012e\u0005"+
		"W\u0000\u0000\u0128\u012a\u0007\u0003\u0000\u0000\u0129\u0128\u0001\u0000"+
		"\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000\u012b\u0129\u0001\u0000"+
		"\u0000\u0000\u012b\u012c\u0001\u0000\u0000\u0000\u012c\u012e\u0001\u0000"+
		"\u0000\u0000\u012d\u0127\u0001\u0000\u0000\u0000\u012d\u0129\u0001\u0000"+
		"\u0000\u0000\u012e3\u0001\u0000\u0000\u0000\u012f\u0131\u0005K\u0000\u0000"+
		"\u0130\u0132\u0003\b\u0004\u0000\u0131\u0130\u0001\u0000\u0000\u0000\u0132"+
		"\u0133\u0001\u0000\u0000\u0000\u0133\u0131\u0001\u0000\u0000\u0000\u0133"+
		"\u0134\u0001\u0000\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000\u0135"+
		"\u0136\u0005L\u0000\u0000\u01365\u0001\u0000\u0000\u0000\u0137\u0139\u0005"+
		"Q\u0000\u0000\u0138\u0137\u0001\u0000\u0000\u0000\u0139\u013a\u0001\u0000"+
		"\u0000\u0000\u013a\u0138\u0001\u0000\u0000\u0000\u013a\u013b\u0001\u0000"+
		"\u0000\u0000\u013b7\u0001\u0000\u0000\u0000!;DR]lvz\u0083\u0087\u008f"+
		"\u0093\u009c\u00a6\u00b6\u00cb\u00d3\u00d8\u00dd\u00e6\u00eb\u00f0\u00f8"+
		"\u00ff\u0108\u010f\u0113\u0118\u011d\u0122\u012b\u012d\u0133\u013a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}