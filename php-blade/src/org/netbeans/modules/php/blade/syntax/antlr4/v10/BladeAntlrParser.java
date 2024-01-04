// Generated from BladeAntlrParser.g4 by ANTLR 4.13.0

  /**
   * Parser generated for netbeans blade editor
   * Some elements have been simplified to optimize parser speed
   * For example
   * - switch statement have a loos validation
   * - generic block statement "@isset" | "@unless" are grouped togehter
   * - the start match and end match will be checked in the parser
   */
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
		PHP_EXPRESSION=1, PHP_VARIABLE=2, PHP_KEYWORD=3, BLADE_PARAM_EXTRA=4, 
		BLADE_PARAM_LPAREN=5, BLADE_PARAM_RPAREN=6, BLADE_PHP_ECHO_EXPR=7, ERROR=8, 
		HTML=9, D_IF=10, D_ELSEIF=11, D_ELSE=12, D_ENDIF=13, D_SWITCH=14, D_CASE=15, 
		D_DEFAULT=16, D_ENDSWITCH=17, D_EMPTY=18, D_ENDEMPTY=19, D_COND_BLOCK_START=20, 
		D_COND_BLOCK_END=21, D_FOREACH=22, D_ENDFOREACH=23, D_FOR=24, D_ENDFOR=25, 
		D_FORELSE=26, D_ENDFORELSE=27, D_WHILE=28, D_ENDWHILE=29, D_BREAK=30, 
		D_LOOP_ACTION=31, D_INCLUDE=32, D_INCLUDE_IF=33, D_INCLUDE_WHEN=34, D_INCLUDE_FIRST=35, 
		D_INCLUDE_UNLESS=36, D_EACH=37, D_EXTENDS=38, D_JS=39, D_SECTION=40, D_HAS_SECTION=41, 
		D_SECTION_MISSING=42, D_ENDSECTION=43, D_YIELD=44, D_PARENT=45, D_SHOW=46, 
		D_OVERWRITE=47, D_STOP=48, D_ONCE=49, D_ENDONCE=50, D_STACK=51, D_PUSH=52, 
		D_ENDPUSH=53, D_PUSH_ONCE=54, D_ENDPUSH_ONCE=55, D_PROPS=56, D_CSRF=57, 
		D_METHOD=58, D_ERROR=59, D_ENDERROR=60, D_PRODUCTION=61, D_ENDPRODUCTION=62, 
		D_ENV=63, D_ENDENV=64, D_AUTH_START=65, D_AUTH_END=66, D_CLASS=67, D_STYLE=68, 
		D_HTML_ATTR_EXPR=69, D_AWARE=70, D_JSON=71, D_DD=72, D_USE=73, D_INJECT=74, 
		D_PHP=75, D_VERBATIM=76, D_ENDVERBATIM=77, D_CUSTOM=78, ESCAPED_ECHO_START=79, 
		NE_ECHO_START=80, AT=81, BLADE_COMMENT=82, PHP_INLINE=83, ESCAPED_ECHO_END=84, 
		NE_ECHO_END=85, WS_EXPR=86, WS_BL_PARAM=87, FOREACH_WS_EXPR=88, FOREACH_LOOP_LPAREN=89, 
		FOREACH_LOOP_RPAREN=90, FOREACH_AS=91, FOREACH_PARAM_ASSIGN=92, BL_PARAM_LINE_COMMENT=93, 
		BL_SQ_LPAREN=94, BL_SQ_RPAREN=95, BL_PARAM_STRING=96, BL_PARAM_ASSIGN=97, 
		BL_PARAM_CONCAT_OPERATOR=98, BL_PARAM_COMMA=99, BL_COMMA=100, BL_PARAM_WS=101, 
		BL_NAME_STRING=102, D_ENDPHP=103, BLADE_PHP_INLINE=104, OPEN_EXPR_PAREN_MORE=105;
	public static final int
		RULE_file = 0, RULE_general_statement = 1, RULE_inline_statement = 2, 
		RULE_inline_directive = 3, RULE_block_statement = 4, RULE_non_blade_statement = 5, 
		RULE_extends = 6, RULE_section_inline = 7, RULE_section = 8, RULE_push = 9, 
		RULE_pushOnce = 10, RULE_if = 11, RULE_elseif = 12, RULE_else = 13, RULE_endif = 14, 
		RULE_conditional_block = 15, RULE_auth_block = 16, RULE_switch = 17, RULE_while = 18, 
		RULE_for = 19, RULE_foreach = 20, RULE_forelse = 21, RULE_yieldD = 22, 
		RULE_stack = 23, RULE_useD = 24, RULE_include = 25, RULE_includeIf = 26, 
		RULE_includeCond = 27, RULE_includeFirst = 28, RULE_each = 29, RULE_hasSection = 30, 
		RULE_custom_directive = 31, RULE_php_blade = 32, RULE_phpInline = 33, 
		RULE_echo = 34, RULE_echo_ne = 35, RULE_php_expression = 36, RULE_loop_expression = 37, 
		RULE_simple_foreach_expr = 38, RULE_singleArgWrapper = 39, RULE_singleArgAndDefaultWrapper = 40, 
		RULE_doubleArgWrapper = 41, RULE_multiArgWrapper = 42, RULE_identifiableArgument = 43, 
		RULE_composedArgument = 44, RULE_phpExpr = 45, RULE_identifiableArray = 46, 
		RULE_array = 47, RULE_paramAssign = 48, RULE_verbatim_block = 49, RULE_loop_action = 50, 
		RULE_html = 51;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "general_statement", "inline_statement", "inline_directive", 
			"block_statement", "non_blade_statement", "extends", "section_inline", 
			"section", "push", "pushOnce", "if", "elseif", "else", "endif", "conditional_block", 
			"auth_block", "switch", "while", "for", "foreach", "forelse", "yieldD", 
			"stack", "useD", "include", "includeIf", "includeCond", "includeFirst", 
			"each", "hasSection", "custom_directive", "php_blade", "phpInline", "echo", 
			"echo_ne", "php_expression", "loop_expression", "simple_foreach_expr", 
			"singleArgWrapper", "singleArgAndDefaultWrapper", "doubleArgWrapper", 
			"multiArgWrapper", "identifiableArgument", "composedArgument", "phpExpr", 
			"identifiableArray", "array", "paramAssign", "verbatim_block", "loop_action", 
			"html"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "'@if'", 
			"'@elseif'", "'@else'", "'@endif'", "'@switch'", "'@case'", "'@default'", 
			"'@endswitch'", "'@empty'", "'@endempty'", null, null, "'@foreach'", 
			"'@endforeach'", "'@for'", "'@endfor'", "'@forelse'", "'@endforelse'", 
			"'@while'", "'@endwhile'", "'@break'", null, "'@include'", "'@includeIf'", 
			"'@includeWhen'", "'@includeFirst'", "'@includeUnless'", "'@each'", "'@extends'", 
			"'@js'", "'@section'", "'@hasSection'", "'@sectionMissing'", "'@endsection'", 
			"'@yield'", "'@parent'", "'@show'", "'@overwrite'", "'@stop'", "'@once'", 
			"'@endonce'", "'@stack'", "'@push'", "'@endpush'", "'@pushOnce'", "'@endPushOnce'", 
			"'@props'", "'@csrf'", "'@method'", "'@error'", "'@enderror'", "'@production'", 
			"'@endproduction'", "'@env'", "'@endenv'", null, null, "'@class'", "'@style'", 
			null, "'@aware'", "'@json'", "'@dd'", "'@use'", "'@inject'", "'@php'", 
			"'@verbatim'", "'@endverbatim'", null, "'{{'", "'{!!'", "'@'", null, 
			null, null, null, null, null, null, null, "')'", "'as'", null, null, 
			"'['", "']'", null, null, "'.'", null, "','", null, null, "'@endphp'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PHP_EXPRESSION", "PHP_VARIABLE", "PHP_KEYWORD", "BLADE_PARAM_EXTRA", 
			"BLADE_PARAM_LPAREN", "BLADE_PARAM_RPAREN", "BLADE_PHP_ECHO_EXPR", "ERROR", 
			"HTML", "D_IF", "D_ELSEIF", "D_ELSE", "D_ENDIF", "D_SWITCH", "D_CASE", 
			"D_DEFAULT", "D_ENDSWITCH", "D_EMPTY", "D_ENDEMPTY", "D_COND_BLOCK_START", 
			"D_COND_BLOCK_END", "D_FOREACH", "D_ENDFOREACH", "D_FOR", "D_ENDFOR", 
			"D_FORELSE", "D_ENDFORELSE", "D_WHILE", "D_ENDWHILE", "D_BREAK", "D_LOOP_ACTION", 
			"D_INCLUDE", "D_INCLUDE_IF", "D_INCLUDE_WHEN", "D_INCLUDE_FIRST", "D_INCLUDE_UNLESS", 
			"D_EACH", "D_EXTENDS", "D_JS", "D_SECTION", "D_HAS_SECTION", "D_SECTION_MISSING", 
			"D_ENDSECTION", "D_YIELD", "D_PARENT", "D_SHOW", "D_OVERWRITE", "D_STOP", 
			"D_ONCE", "D_ENDONCE", "D_STACK", "D_PUSH", "D_ENDPUSH", "D_PUSH_ONCE", 
			"D_ENDPUSH_ONCE", "D_PROPS", "D_CSRF", "D_METHOD", "D_ERROR", "D_ENDERROR", 
			"D_PRODUCTION", "D_ENDPRODUCTION", "D_ENV", "D_ENDENV", "D_AUTH_START", 
			"D_AUTH_END", "D_CLASS", "D_STYLE", "D_HTML_ATTR_EXPR", "D_AWARE", "D_JSON", 
			"D_DD", "D_USE", "D_INJECT", "D_PHP", "D_VERBATIM", "D_ENDVERBATIM", 
			"D_CUSTOM", "ESCAPED_ECHO_START", "NE_ECHO_START", "AT", "BLADE_COMMENT", 
			"PHP_INLINE", "ESCAPED_ECHO_END", "NE_ECHO_END", "WS_EXPR", "WS_BL_PARAM", 
			"FOREACH_WS_EXPR", "FOREACH_LOOP_LPAREN", "FOREACH_LOOP_RPAREN", "FOREACH_AS", 
			"FOREACH_PARAM_ASSIGN", "BL_PARAM_LINE_COMMENT", "BL_SQ_LPAREN", "BL_SQ_RPAREN", 
			"BL_PARAM_STRING", "BL_PARAM_ASSIGN", "BL_PARAM_CONCAT_OPERATOR", "BL_PARAM_COMMA", 
			"BL_COMMA", "BL_PARAM_WS", "BL_NAME_STRING", "D_ENDPHP", "BLADE_PHP_INLINE", 
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
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8135168337130430976L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 454429L) != 0)) {
				{
				{
				setState(104);
				general_statement();
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(110);
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
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				inline_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				block_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(114);
				match(BLADE_COMMENT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(115);
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
		public Inline_directiveContext inline_directive() {
			return getRuleContext(Inline_directiveContext.class,0);
		}
		public EchoContext echo() {
			return getRuleContext(EchoContext.class,0);
		}
		public Echo_neContext echo_ne() {
			return getRuleContext(Echo_neContext.class,0);
		}
		public PhpInlineContext phpInline() {
			return getRuleContext(PhpInlineContext.class,0);
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
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_CASE:
			case D_DEFAULT:
			case D_BREAK:
			case D_LOOP_ACTION:
			case D_INCLUDE:
			case D_INCLUDE_IF:
			case D_INCLUDE_WHEN:
			case D_INCLUDE_FIRST:
			case D_INCLUDE_UNLESS:
			case D_EACH:
			case D_EXTENDS:
			case D_SECTION:
			case D_YIELD:
			case D_STACK:
			case D_PROPS:
			case D_CSRF:
			case D_METHOD:
			case D_CLASS:
			case D_STYLE:
			case D_HTML_ATTR_EXPR:
			case D_USE:
			case D_INJECT:
			case D_CUSTOM:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				inline_directive();
				}
				break;
			case ESCAPED_ECHO_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				echo();
				}
				break;
			case NE_ECHO_START:
				enterOuterAlt(_localctx, 3);
				{
				setState(120);
				echo_ne();
				}
				break;
			case PHP_INLINE:
				enterOuterAlt(_localctx, 4);
				{
				setState(121);
				phpInline();
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
	public static class Inline_directiveContext extends ParserRuleContext {
		public ExtendsContext extends_() {
			return getRuleContext(ExtendsContext.class,0);
		}
		public Section_inlineContext section_inline() {
			return getRuleContext(Section_inlineContext.class,0);
		}
		public YieldDContext yieldD() {
			return getRuleContext(YieldDContext.class,0);
		}
		public StackContext stack() {
			return getRuleContext(StackContext.class,0);
		}
		public IncludeContext include() {
			return getRuleContext(IncludeContext.class,0);
		}
		public IncludeIfContext includeIf() {
			return getRuleContext(IncludeIfContext.class,0);
		}
		public IncludeCondContext includeCond() {
			return getRuleContext(IncludeCondContext.class,0);
		}
		public IncludeFirstContext includeFirst() {
			return getRuleContext(IncludeFirstContext.class,0);
		}
		public EachContext each() {
			return getRuleContext(EachContext.class,0);
		}
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public TerminalNode D_CLASS() { return getToken(BladeAntlrParser.D_CLASS, 0); }
		public TerminalNode D_STYLE() { return getToken(BladeAntlrParser.D_STYLE, 0); }
		public TerminalNode D_METHOD() { return getToken(BladeAntlrParser.D_METHOD, 0); }
		public TerminalNode D_PROPS() { return getToken(BladeAntlrParser.D_PROPS, 0); }
		public TerminalNode D_CSRF() { return getToken(BladeAntlrParser.D_CSRF, 0); }
		public UseDContext useD() {
			return getRuleContext(UseDContext.class,0);
		}
		public TerminalNode D_INJECT() { return getToken(BladeAntlrParser.D_INJECT, 0); }
		public DoubleArgWrapperContext doubleArgWrapper() {
			return getRuleContext(DoubleArgWrapperContext.class,0);
		}
		public TerminalNode D_HTML_ATTR_EXPR() { return getToken(BladeAntlrParser.D_HTML_ATTR_EXPR, 0); }
		public TerminalNode D_CASE() { return getToken(BladeAntlrParser.D_CASE, 0); }
		public TerminalNode D_DEFAULT() { return getToken(BladeAntlrParser.D_DEFAULT, 0); }
		public Loop_actionContext loop_action() {
			return getRuleContext(Loop_actionContext.class,0);
		}
		public Custom_directiveContext custom_directive() {
			return getRuleContext(Custom_directiveContext.class,0);
		}
		public Inline_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inline_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterInline_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitInline_directive(this);
		}
	}

	public final Inline_directiveContext inline_directive() throws RecognitionException {
		Inline_directiveContext _localctx = new Inline_directiveContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_inline_directive);
		int _la;
		try {
			setState(150);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_EXTENDS:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				extends_();
				}
				break;
			case D_SECTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				section_inline();
				}
				break;
			case D_YIELD:
				enterOuterAlt(_localctx, 3);
				{
				setState(126);
				yieldD();
				}
				break;
			case D_STACK:
				enterOuterAlt(_localctx, 4);
				{
				setState(127);
				stack();
				}
				break;
			case D_INCLUDE:
				enterOuterAlt(_localctx, 5);
				{
				setState(128);
				include();
				}
				break;
			case D_INCLUDE_IF:
				enterOuterAlt(_localctx, 6);
				{
				setState(129);
				includeIf();
				}
				break;
			case D_INCLUDE_WHEN:
			case D_INCLUDE_UNLESS:
				enterOuterAlt(_localctx, 7);
				{
				setState(130);
				includeCond();
				}
				break;
			case D_INCLUDE_FIRST:
				enterOuterAlt(_localctx, 8);
				{
				setState(131);
				includeFirst();
				}
				break;
			case D_EACH:
				enterOuterAlt(_localctx, 9);
				{
				setState(132);
				each();
				}
				break;
			case D_CLASS:
			case D_STYLE:
				enterOuterAlt(_localctx, 10);
				{
				setState(133);
				_la = _input.LA(1);
				if ( !(_la==D_CLASS || _la==D_STYLE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(134);
				php_expression();
				}
				break;
			case D_METHOD:
				enterOuterAlt(_localctx, 11);
				{
				{
				setState(135);
				match(D_METHOD);
				}
				setState(136);
				php_expression();
				}
				break;
			case D_PROPS:
				enterOuterAlt(_localctx, 12);
				{
				setState(137);
				match(D_PROPS);
				setState(138);
				php_expression();
				}
				break;
			case D_CSRF:
				enterOuterAlt(_localctx, 13);
				{
				setState(139);
				match(D_CSRF);
				}
				break;
			case D_USE:
				enterOuterAlt(_localctx, 14);
				{
				setState(140);
				useD();
				}
				break;
			case D_INJECT:
				enterOuterAlt(_localctx, 15);
				{
				setState(141);
				match(D_INJECT);
				setState(142);
				doubleArgWrapper();
				}
				break;
			case D_HTML_ATTR_EXPR:
				enterOuterAlt(_localctx, 16);
				{
				setState(143);
				match(D_HTML_ATTR_EXPR);
				setState(144);
				php_expression();
				}
				break;
			case D_CASE:
				enterOuterAlt(_localctx, 17);
				{
				setState(145);
				match(D_CASE);
				setState(146);
				php_expression();
				}
				break;
			case D_DEFAULT:
				enterOuterAlt(_localctx, 18);
				{
				setState(147);
				match(D_DEFAULT);
				}
				break;
			case D_BREAK:
			case D_LOOP_ACTION:
				enterOuterAlt(_localctx, 19);
				{
				setState(148);
				loop_action();
				}
				break;
			case D_CUSTOM:
				enterOuterAlt(_localctx, 20);
				{
				setState(149);
				custom_directive();
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
		public PushContext push() {
			return getRuleContext(PushContext.class,0);
		}
		public TerminalNode D_ONCE() { return getToken(BladeAntlrParser.D_ONCE, 0); }
		public TerminalNode D_ENDONCE() { return getToken(BladeAntlrParser.D_ENDONCE, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
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
		public SwitchContext switch_() {
			return getRuleContext(SwitchContext.class,0);
		}
		public TerminalNode D_ENV() { return getToken(BladeAntlrParser.D_ENV, 0); }
		public SingleArgWrapperContext singleArgWrapper() {
			return getRuleContext(SingleArgWrapperContext.class,0);
		}
		public TerminalNode D_ENDENV() { return getToken(BladeAntlrParser.D_ENDENV, 0); }
		public TerminalNode D_EMPTY() { return getToken(BladeAntlrParser.D_EMPTY, 0); }
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public TerminalNode D_ENDEMPTY() { return getToken(BladeAntlrParser.D_ENDEMPTY, 0); }
		public TerminalNode D_ERROR() { return getToken(BladeAntlrParser.D_ERROR, 0); }
		public TerminalNode D_ENDERROR() { return getToken(BladeAntlrParser.D_ENDERROR, 0); }
		public Conditional_blockContext conditional_block() {
			return getRuleContext(Conditional_blockContext.class,0);
		}
		public Auth_blockContext auth_block() {
			return getRuleContext(Auth_blockContext.class,0);
		}
		public WhileContext while_() {
			return getRuleContext(WhileContext.class,0);
		}
		public ForContext for_() {
			return getRuleContext(ForContext.class,0);
		}
		public ForeachContext foreach() {
			return getRuleContext(ForeachContext.class,0);
		}
		public ForelseContext forelse() {
			return getRuleContext(ForelseContext.class,0);
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
		enterRule(_localctx, 8, RULE_block_statement);
		int _la;
		try {
			setState(202);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SECTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				section();
				}
				break;
			case D_HAS_SECTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				hasSection();
				}
				break;
			case D_PUSH:
				enterOuterAlt(_localctx, 3);
				{
				setState(154);
				push();
				}
				break;
			case D_ONCE:
				enterOuterAlt(_localctx, 4);
				{
				setState(155);
				match(D_ONCE);
				setState(157); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(156);
					general_statement();
					}
					}
					setState(159); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -8135168337130430976L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 454429L) != 0) );
				setState(161);
				match(D_ENDONCE);
				}
				break;
			case D_IF:
				enterOuterAlt(_localctx, 5);
				{
				setState(163);
				if_();
				}
				break;
			case D_ELSEIF:
				enterOuterAlt(_localctx, 6);
				{
				setState(164);
				elseif();
				}
				break;
			case D_ELSE:
				enterOuterAlt(_localctx, 7);
				{
				setState(165);
				else_();
				}
				break;
			case D_SWITCH:
				enterOuterAlt(_localctx, 8);
				{
				setState(166);
				switch_();
				}
				break;
			case D_ENV:
				enterOuterAlt(_localctx, 9);
				{
				setState(167);
				match(D_ENV);
				setState(168);
				singleArgWrapper();
				setState(170); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(169);
					general_statement();
					}
					}
					setState(172); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -8135168337130430976L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 454429L) != 0) );
				setState(174);
				match(D_ENDENV);
				}
				break;
			case D_EMPTY:
				enterOuterAlt(_localctx, 10);
				{
				setState(176);
				match(D_EMPTY);
				setState(177);
				php_expression();
				setState(179); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(178);
					general_statement();
					}
					}
					setState(181); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -8135168337130430976L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 454429L) != 0) );
				setState(183);
				match(D_ENDEMPTY);
				}
				break;
			case D_ERROR:
				enterOuterAlt(_localctx, 11);
				{
				setState(185);
				match(D_ERROR);
				setState(186);
				php_expression();
				setState(188); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(187);
					general_statement();
					}
					}
					setState(190); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -8135168337130430976L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 454429L) != 0) );
				setState(192);
				match(D_ENDERROR);
				}
				break;
			case D_COND_BLOCK_START:
				enterOuterAlt(_localctx, 12);
				{
				setState(194);
				conditional_block();
				}
				break;
			case D_AUTH_START:
				enterOuterAlt(_localctx, 13);
				{
				setState(195);
				auth_block();
				}
				break;
			case D_WHILE:
				enterOuterAlt(_localctx, 14);
				{
				setState(196);
				while_();
				}
				break;
			case D_FOR:
				enterOuterAlt(_localctx, 15);
				{
				setState(197);
				for_();
				}
				break;
			case D_FOREACH:
				enterOuterAlt(_localctx, 16);
				{
				setState(198);
				foreach();
				}
				break;
			case D_FORELSE:
				enterOuterAlt(_localctx, 17);
				{
				setState(199);
				forelse();
				}
				break;
			case D_VERBATIM:
				enterOuterAlt(_localctx, 18);
				{
				setState(200);
				verbatim_block();
				}
				break;
			case D_PHP:
				enterOuterAlt(_localctx, 19);
				{
				setState(201);
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
		public PhpInlineContext phpInline() {
			return getRuleContext(PhpInlineContext.class,0);
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
			setState(206);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HTML:
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				html();
				}
				break;
			case PHP_INLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				phpInline();
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
		public SingleArgWrapperContext singleArgWrapper() {
			return getRuleContext(SingleArgWrapperContext.class,0);
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
		enterRule(_localctx, 12, RULE_extends);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(D_EXTENDS);
			setState(209);
			singleArgWrapper();
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
		public DoubleArgWrapperContext doubleArgWrapper() {
			return getRuleContext(DoubleArgWrapperContext.class,0);
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
			setState(211);
			match(D_SECTION);
			setState(212);
			doubleArgWrapper();
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
		public SingleArgWrapperContext singleArgWrapper() {
			return getRuleContext(SingleArgWrapperContext.class,0);
		}
		public TerminalNode D_SHOW() { return getToken(BladeAntlrParser.D_SHOW, 0); }
		public TerminalNode D_STOP() { return getToken(BladeAntlrParser.D_STOP, 0); }
		public TerminalNode D_OVERWRITE() { return getToken(BladeAntlrParser.D_OVERWRITE, 0); }
		public TerminalNode D_ENDSECTION() { return getToken(BladeAntlrParser.D_ENDSECTION, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public List<TerminalNode> D_PARENT() { return getTokens(BladeAntlrParser.D_PARENT); }
		public TerminalNode D_PARENT(int i) {
			return getToken(BladeAntlrParser.D_PARENT, i);
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
		enterRule(_localctx, 16, RULE_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(D_SECTION);
			setState(215);
			singleArgWrapper();
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8135133152758342144L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 454429L) != 0)) {
				{
				setState(218);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case HTML:
				case D_IF:
				case D_ELSEIF:
				case D_ELSE:
				case D_SWITCH:
				case D_CASE:
				case D_DEFAULT:
				case D_EMPTY:
				case D_COND_BLOCK_START:
				case D_FOREACH:
				case D_FOR:
				case D_FORELSE:
				case D_WHILE:
				case D_BREAK:
				case D_LOOP_ACTION:
				case D_INCLUDE:
				case D_INCLUDE_IF:
				case D_INCLUDE_WHEN:
				case D_INCLUDE_FIRST:
				case D_INCLUDE_UNLESS:
				case D_EACH:
				case D_EXTENDS:
				case D_SECTION:
				case D_HAS_SECTION:
				case D_YIELD:
				case D_ONCE:
				case D_STACK:
				case D_PUSH:
				case D_PROPS:
				case D_CSRF:
				case D_METHOD:
				case D_ERROR:
				case D_ENV:
				case D_AUTH_START:
				case D_CLASS:
				case D_STYLE:
				case D_HTML_ATTR_EXPR:
				case D_USE:
				case D_INJECT:
				case D_PHP:
				case D_VERBATIM:
				case D_CUSTOM:
				case ESCAPED_ECHO_START:
				case NE_ECHO_START:
				case BLADE_COMMENT:
				case PHP_INLINE:
					{
					setState(216);
					general_statement();
					}
					break;
				case D_PARENT:
					{
					setState(217);
					match(D_PARENT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(223);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 501377302265856L) != 0)) ) {
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
	public static class PushContext extends ParserRuleContext {
		public TerminalNode D_PUSH() { return getToken(BladeAntlrParser.D_PUSH, 0); }
		public SingleArgWrapperContext singleArgWrapper() {
			return getRuleContext(SingleArgWrapperContext.class,0);
		}
		public TerminalNode D_ENDPUSH() { return getToken(BladeAntlrParser.D_ENDPUSH, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public PushContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_push; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterPush(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitPush(this);
		}
	}

	public final PushContext push() throws RecognitionException {
		PushContext _localctx = new PushContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_push);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(D_PUSH);
			setState(226);
			singleArgWrapper();
			setState(228); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(227);
				general_statement();
				}
				}
				setState(230); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -8135168337130430976L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 454429L) != 0) );
			setState(232);
			match(D_ENDPUSH);
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
	public static class PushOnceContext extends ParserRuleContext {
		public TerminalNode D_PUSH_ONCE() { return getToken(BladeAntlrParser.D_PUSH_ONCE, 0); }
		public SingleArgWrapperContext singleArgWrapper() {
			return getRuleContext(SingleArgWrapperContext.class,0);
		}
		public TerminalNode D_ENDPUSH_ONCE() { return getToken(BladeAntlrParser.D_ENDPUSH_ONCE, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public PushOnceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pushOnce; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterPushOnce(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitPushOnce(this);
		}
	}

	public final PushOnceContext pushOnce() throws RecognitionException {
		PushOnceContext _localctx = new PushOnceContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_pushOnce);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(D_PUSH_ONCE);
			setState(235);
			singleArgWrapper();
			setState(237); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(236);
				general_statement();
				}
				}
				setState(239); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -8135168337130430976L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 454429L) != 0) );
			setState(241);
			match(D_ENDPUSH_ONCE);
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
		public TerminalNode D_IF() { return getToken(BladeAntlrParser.D_IF, 0); }
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public EndifContext endif() {
			return getRuleContext(EndifContext.class,0);
		}
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
		enterRule(_localctx, 22, RULE_if);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(D_IF);
			setState(244);
			php_expression();
			setState(246); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(245);
					general_statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(248); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(251);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(250);
				endif();
				}
				break;
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
		public TerminalNode D_ELSEIF() { return getToken(BladeAntlrParser.D_ELSEIF, 0); }
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public EndifContext endif() {
			return getRuleContext(EndifContext.class,0);
		}
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
		enterRule(_localctx, 24, RULE_elseif);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(D_ELSEIF);
			setState(254);
			php_expression();
			setState(256); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(255);
					general_statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(258); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(261);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(260);
				endif();
				}
				break;
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
		public TerminalNode D_ELSE() { return getToken(BladeAntlrParser.D_ELSE, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public EndifContext endif() {
			return getRuleContext(EndifContext.class,0);
		}
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
		enterRule(_localctx, 26, RULE_else);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(D_ELSE);
			setState(265); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(264);
					general_statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(267); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(270);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(269);
				endif();
				}
				break;
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
	public static class EndifContext extends ParserRuleContext {
		public TerminalNode D_ENDIF() { return getToken(BladeAntlrParser.D_ENDIF, 0); }
		public EndifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterEndif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitEndif(this);
		}
	}

	public final EndifContext endif() throws RecognitionException {
		EndifContext _localctx = new EndifContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_endif);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
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
	public static class Conditional_blockContext extends ParserRuleContext {
		public TerminalNode D_COND_BLOCK_START() { return getToken(BladeAntlrParser.D_COND_BLOCK_START, 0); }
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public TerminalNode D_COND_BLOCK_END() { return getToken(BladeAntlrParser.D_COND_BLOCK_END, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public Conditional_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterConditional_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitConditional_block(this);
		}
	}

	public final Conditional_blockContext conditional_block() throws RecognitionException {
		Conditional_blockContext _localctx = new Conditional_blockContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_conditional_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(D_COND_BLOCK_START);
			setState(275);
			php_expression();
			setState(277); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(276);
				general_statement();
				}
				}
				setState(279); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -8135168337130430976L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 454429L) != 0) );
			setState(281);
			match(D_COND_BLOCK_END);
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
	public static class Auth_blockContext extends ParserRuleContext {
		public TerminalNode D_AUTH_START() { return getToken(BladeAntlrParser.D_AUTH_START, 0); }
		public TerminalNode D_AUTH_END() { return getToken(BladeAntlrParser.D_AUTH_END, 0); }
		public List<SingleArgWrapperContext> singleArgWrapper() {
			return getRuleContexts(SingleArgWrapperContext.class);
		}
		public SingleArgWrapperContext singleArgWrapper(int i) {
			return getRuleContext(SingleArgWrapperContext.class,i);
		}
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public Auth_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_auth_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterAuth_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitAuth_block(this);
		}
	}

	public final Auth_blockContext auth_block() throws RecognitionException {
		Auth_blockContext _localctx = new Auth_blockContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_auth_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(D_AUTH_START);
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BLADE_PARAM_LPAREN) {
				{
				{
				setState(284);
				singleArgWrapper();
				}
				}
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(291); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(290);
				general_statement();
				}
				}
				setState(293); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -8135168337130430976L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 454429L) != 0) );
			setState(295);
			match(D_AUTH_END);
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
	public static class SwitchContext extends ParserRuleContext {
		public TerminalNode D_SWITCH() { return getToken(BladeAntlrParser.D_SWITCH, 0); }
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public TerminalNode D_ENDSWITCH() { return getToken(BladeAntlrParser.D_ENDSWITCH, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public List<TerminalNode> D_BREAK() { return getTokens(BladeAntlrParser.D_BREAK); }
		public TerminalNode D_BREAK(int i) {
			return getToken(BladeAntlrParser.D_BREAK, i);
		}
		public SwitchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterSwitch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitSwitch(this);
		}
	}

	public final SwitchContext switch_() throws RecognitionException {
		SwitchContext _localctx = new SwitchContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_switch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(D_SWITCH);
			setState(298);
			php_expression();
			setState(301); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(301);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(299);
					general_statement();
					}
					break;
				case 2:
					{
					setState(300);
					match(D_BREAK);
					}
					break;
				}
				}
				setState(303); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -8135168337130430976L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 454429L) != 0) );
			setState(305);
			match(D_ENDSWITCH);
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
		enterRule(_localctx, 36, RULE_while);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			match(D_WHILE);
			setState(308);
			php_expression();
			setState(310); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(309);
				general_statement();
				}
				}
				setState(312); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -8135168337130430976L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 454429L) != 0) );
			setState(314);
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
	public static class ForContext extends ParserRuleContext {
		public TerminalNode D_FOR() { return getToken(BladeAntlrParser.D_FOR, 0); }
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public TerminalNode D_ENDFOR() { return getToken(BladeAntlrParser.D_ENDFOR, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public ForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitFor(this);
		}
	}

	public final ForContext for_() throws RecognitionException {
		ForContext _localctx = new ForContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_for);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			match(D_FOR);
			setState(317);
			php_expression();
			setState(319); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(318);
				general_statement();
				}
				}
				setState(321); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -8135168337130430976L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 454429L) != 0) );
			setState(323);
			match(D_ENDFOR);
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
		public TerminalNode FOREACH_LOOP_LPAREN() { return getToken(BladeAntlrParser.FOREACH_LOOP_LPAREN, 0); }
		public Loop_expressionContext loop_expression() {
			return getRuleContext(Loop_expressionContext.class,0);
		}
		public TerminalNode FOREACH_LOOP_RPAREN() { return getToken(BladeAntlrParser.FOREACH_LOOP_RPAREN, 0); }
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
		enterRule(_localctx, 40, RULE_foreach);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			match(D_FOREACH);
			setState(326);
			match(FOREACH_LOOP_LPAREN);
			setState(327);
			loop_expression();
			setState(328);
			match(FOREACH_LOOP_RPAREN);
			setState(330); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(329);
				general_statement();
				}
				}
				setState(332); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -8135168337130430976L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 454429L) != 0) );
			setState(334);
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
	public static class ForelseContext extends ParserRuleContext {
		public TerminalNode D_FORELSE() { return getToken(BladeAntlrParser.D_FORELSE, 0); }
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public TerminalNode D_ENDFORELSE() { return getToken(BladeAntlrParser.D_ENDFORELSE, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public List<TerminalNode> D_EMPTY() { return getTokens(BladeAntlrParser.D_EMPTY); }
		public TerminalNode D_EMPTY(int i) {
			return getToken(BladeAntlrParser.D_EMPTY, i);
		}
		public ForelseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forelse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterForelse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitForelse(this);
		}
	}

	public final ForelseContext forelse() throws RecognitionException {
		ForelseContext _localctx = new ForelseContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_forelse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(D_FORELSE);
			setState(337);
			php_expression();
			setState(340); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(340);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(338);
					general_statement();
					}
					break;
				case 2:
					{
					setState(339);
					match(D_EMPTY);
					}
					break;
				}
				}
				setState(342); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -8135168337130430976L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 454429L) != 0) );
			setState(344);
			match(D_ENDFORELSE);
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
	public static class YieldDContext extends ParserRuleContext {
		public TerminalNode D_YIELD() { return getToken(BladeAntlrParser.D_YIELD, 0); }
		public SingleArgWrapperContext singleArgWrapper() {
			return getRuleContext(SingleArgWrapperContext.class,0);
		}
		public YieldDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yieldD; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterYieldD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitYieldD(this);
		}
	}

	public final YieldDContext yieldD() throws RecognitionException {
		YieldDContext _localctx = new YieldDContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_yieldD);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			match(D_YIELD);
			setState(347);
			singleArgWrapper();
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
	public static class StackContext extends ParserRuleContext {
		public TerminalNode D_STACK() { return getToken(BladeAntlrParser.D_STACK, 0); }
		public SingleArgWrapperContext singleArgWrapper() {
			return getRuleContext(SingleArgWrapperContext.class,0);
		}
		public StackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stack; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterStack(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitStack(this);
		}
	}

	public final StackContext stack() throws RecognitionException {
		StackContext _localctx = new StackContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_stack);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(D_STACK);
			setState(350);
			singleArgWrapper();
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
	public static class UseDContext extends ParserRuleContext {
		public TerminalNode D_USE() { return getToken(BladeAntlrParser.D_USE, 0); }
		public SingleArgWrapperContext singleArgWrapper() {
			return getRuleContext(SingleArgWrapperContext.class,0);
		}
		public UseDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_useD; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterUseD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitUseD(this);
		}
	}

	public final UseDContext useD() throws RecognitionException {
		UseDContext _localctx = new UseDContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_useD);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			match(D_USE);
			setState(353);
			singleArgWrapper();
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
		public SingleArgAndDefaultWrapperContext singleArgAndDefaultWrapper() {
			return getRuleContext(SingleArgAndDefaultWrapperContext.class,0);
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
		enterRule(_localctx, 50, RULE_include);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			match(D_INCLUDE);
			setState(356);
			singleArgAndDefaultWrapper();
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
	public static class IncludeIfContext extends ParserRuleContext {
		public TerminalNode D_INCLUDE_IF() { return getToken(BladeAntlrParser.D_INCLUDE_IF, 0); }
		public SingleArgAndDefaultWrapperContext singleArgAndDefaultWrapper() {
			return getRuleContext(SingleArgAndDefaultWrapperContext.class,0);
		}
		public IncludeIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_includeIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterIncludeIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitIncludeIf(this);
		}
	}

	public final IncludeIfContext includeIf() throws RecognitionException {
		IncludeIfContext _localctx = new IncludeIfContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_includeIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			match(D_INCLUDE_IF);
			setState(359);
			singleArgAndDefaultWrapper();
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
	public static class IncludeCondContext extends ParserRuleContext {
		public TerminalNode BLADE_PARAM_LPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, 0); }
		public List<ComposedArgumentContext> composedArgument() {
			return getRuleContexts(ComposedArgumentContext.class);
		}
		public ComposedArgumentContext composedArgument(int i) {
			return getRuleContext(ComposedArgumentContext.class,i);
		}
		public List<TerminalNode> BL_COMMA() { return getTokens(BladeAntlrParser.BL_COMMA); }
		public TerminalNode BL_COMMA(int i) {
			return getToken(BladeAntlrParser.BL_COMMA, i);
		}
		public TerminalNode BLADE_PARAM_RPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, 0); }
		public TerminalNode D_INCLUDE_WHEN() { return getToken(BladeAntlrParser.D_INCLUDE_WHEN, 0); }
		public TerminalNode D_INCLUDE_UNLESS() { return getToken(BladeAntlrParser.D_INCLUDE_UNLESS, 0); }
		public IdentifiableArgumentContext identifiableArgument() {
			return getRuleContext(IdentifiableArgumentContext.class,0);
		}
		public IncludeCondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_includeCond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterIncludeCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitIncludeCond(this);
		}
	}

	public final IncludeCondContext includeCond() throws RecognitionException {
		IncludeCondContext _localctx = new IncludeCondContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_includeCond);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			_la = _input.LA(1);
			if ( !(_la==D_INCLUDE_WHEN || _la==D_INCLUDE_UNLESS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(362);
			match(BLADE_PARAM_LPAREN);
			setState(363);
			composedArgument();
			setState(364);
			match(BL_COMMA);
			setState(367);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(365);
				identifiableArgument();
				}
				break;
			case 2:
				{
				setState(366);
				composedArgument();
				}
				break;
			}
			setState(371);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BL_COMMA) {
				{
				setState(369);
				match(BL_COMMA);
				setState(370);
				composedArgument();
				}
			}

			setState(373);
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
	public static class IncludeFirstContext extends ParserRuleContext {
		public TerminalNode D_INCLUDE_FIRST() { return getToken(BladeAntlrParser.D_INCLUDE_FIRST, 0); }
		public SingleArgAndDefaultWrapperContext singleArgAndDefaultWrapper() {
			return getRuleContext(SingleArgAndDefaultWrapperContext.class,0);
		}
		public IncludeFirstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_includeFirst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterIncludeFirst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitIncludeFirst(this);
		}
	}

	public final IncludeFirstContext includeFirst() throws RecognitionException {
		IncludeFirstContext _localctx = new IncludeFirstContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_includeFirst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			match(D_INCLUDE_FIRST);
			setState(376);
			singleArgAndDefaultWrapper();
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
	public static class EachContext extends ParserRuleContext {
		public TerminalNode D_EACH() { return getToken(BladeAntlrParser.D_EACH, 0); }
		public TerminalNode BLADE_PARAM_LPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, 0); }
		public List<TerminalNode> BL_COMMA() { return getTokens(BladeAntlrParser.BL_COMMA); }
		public TerminalNode BL_COMMA(int i) {
			return getToken(BladeAntlrParser.BL_COMMA, i);
		}
		public List<ComposedArgumentContext> composedArgument() {
			return getRuleContexts(ComposedArgumentContext.class);
		}
		public ComposedArgumentContext composedArgument(int i) {
			return getRuleContext(ComposedArgumentContext.class,i);
		}
		public TerminalNode BLADE_PARAM_RPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, 0); }
		public List<IdentifiableArgumentContext> identifiableArgument() {
			return getRuleContexts(IdentifiableArgumentContext.class);
		}
		public IdentifiableArgumentContext identifiableArgument(int i) {
			return getRuleContext(IdentifiableArgumentContext.class,i);
		}
		public EachContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_each; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterEach(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitEach(this);
		}
	}

	public final EachContext each() throws RecognitionException {
		EachContext _localctx = new EachContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_each);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			match(D_EACH);
			setState(379);
			match(BLADE_PARAM_LPAREN);
			setState(382);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(380);
				identifiableArgument();
				}
				break;
			case 2:
				{
				setState(381);
				composedArgument();
				}
				break;
			}
			setState(384);
			match(BL_COMMA);
			setState(385);
			composedArgument();
			setState(386);
			match(BL_COMMA);
			setState(387);
			composedArgument();
			setState(393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BL_COMMA) {
				{
				setState(388);
				match(BL_COMMA);
				setState(391);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(389);
					identifiableArgument();
					}
					break;
				case 2:
					{
					setState(390);
					composedArgument();
					}
					break;
				}
				}
			}

			setState(395);
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
	public static class HasSectionContext extends ParserRuleContext {
		public TerminalNode D_HAS_SECTION() { return getToken(BladeAntlrParser.D_HAS_SECTION, 0); }
		public SingleArgWrapperContext singleArgWrapper() {
			return getRuleContext(SingleArgWrapperContext.class,0);
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
		enterRule(_localctx, 60, RULE_hasSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			match(D_HAS_SECTION);
			setState(398);
			singleArgWrapper();
			setState(402);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8135168337130430976L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 454429L) != 0)) {
				{
				{
				setState(399);
				general_statement();
				}
				}
				setState(404);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(405);
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
		public MultiArgWrapperContext multiArgWrapper() {
			return getRuleContext(MultiArgWrapperContext.class,0);
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
		enterRule(_localctx, 62, RULE_custom_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			match(D_CUSTOM);
			setState(408);
			multiArgWrapper();
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
		enterRule(_localctx, 64, RULE_php_blade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			match(D_PHP);
			setState(411);
			match(BLADE_PHP_INLINE);
			setState(412);
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
	public static class PhpInlineContext extends ParserRuleContext {
		public TerminalNode PHP_INLINE() { return getToken(BladeAntlrParser.PHP_INLINE, 0); }
		public PhpInlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phpInline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterPhpInline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitPhpInline(this);
		}
	}

	public final PhpInlineContext phpInline() throws RecognitionException {
		PhpInlineContext _localctx = new PhpInlineContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_phpInline);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			match(PHP_INLINE);
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
		public TerminalNode ESCAPED_ECHO_END() { return getToken(BladeAntlrParser.ESCAPED_ECHO_END, 0); }
		public List<TerminalNode> BLADE_PHP_ECHO_EXPR() { return getTokens(BladeAntlrParser.BLADE_PHP_ECHO_EXPR); }
		public TerminalNode BLADE_PHP_ECHO_EXPR(int i) {
			return getToken(BladeAntlrParser.BLADE_PHP_ECHO_EXPR, i);
		}
		public List<TerminalNode> PHP_VARIABLE() { return getTokens(BladeAntlrParser.PHP_VARIABLE); }
		public TerminalNode PHP_VARIABLE(int i) {
			return getToken(BladeAntlrParser.PHP_VARIABLE, i);
		}
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
		enterRule(_localctx, 68, RULE_echo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			match(ESCAPED_ECHO_START);
			setState(420);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PHP_VARIABLE || _la==BLADE_PHP_ECHO_EXPR) {
				{
				{
				setState(417);
				_la = _input.LA(1);
				if ( !(_la==PHP_VARIABLE || _la==BLADE_PHP_ECHO_EXPR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(422);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(423);
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
		public TerminalNode NE_ECHO_END() { return getToken(BladeAntlrParser.NE_ECHO_END, 0); }
		public List<TerminalNode> BLADE_PHP_ECHO_EXPR() { return getTokens(BladeAntlrParser.BLADE_PHP_ECHO_EXPR); }
		public TerminalNode BLADE_PHP_ECHO_EXPR(int i) {
			return getToken(BladeAntlrParser.BLADE_PHP_ECHO_EXPR, i);
		}
		public List<TerminalNode> PHP_VARIABLE() { return getTokens(BladeAntlrParser.PHP_VARIABLE); }
		public TerminalNode PHP_VARIABLE(int i) {
			return getToken(BladeAntlrParser.PHP_VARIABLE, i);
		}
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
		enterRule(_localctx, 70, RULE_echo_ne);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			match(NE_ECHO_START);
			setState(429);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PHP_VARIABLE || _la==BLADE_PHP_ECHO_EXPR) {
				{
				{
				setState(426);
				_la = _input.LA(1);
				if ( !(_la==PHP_VARIABLE || _la==BLADE_PHP_ECHO_EXPR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(431);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(432);
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
		enterRule(_localctx, 72, RULE_php_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
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
	public static class Loop_expressionContext extends ParserRuleContext {
		public Simple_foreach_exprContext simple_foreach_expr() {
			return getRuleContext(Simple_foreach_exprContext.class,0);
		}
		public List<TerminalNode> PHP_VARIABLE() { return getTokens(BladeAntlrParser.PHP_VARIABLE); }
		public TerminalNode PHP_VARIABLE(int i) {
			return getToken(BladeAntlrParser.PHP_VARIABLE, i);
		}
		public List<TerminalNode> PHP_EXPRESSION() { return getTokens(BladeAntlrParser.PHP_EXPRESSION); }
		public TerminalNode PHP_EXPRESSION(int i) {
			return getToken(BladeAntlrParser.PHP_EXPRESSION, i);
		}
		public List<TerminalNode> FOREACH_PARAM_ASSIGN() { return getTokens(BladeAntlrParser.FOREACH_PARAM_ASSIGN); }
		public TerminalNode FOREACH_PARAM_ASSIGN(int i) {
			return getToken(BladeAntlrParser.FOREACH_PARAM_ASSIGN, i);
		}
		public List<TerminalNode> FOREACH_LOOP_LPAREN() { return getTokens(BladeAntlrParser.FOREACH_LOOP_LPAREN); }
		public TerminalNode FOREACH_LOOP_LPAREN(int i) {
			return getToken(BladeAntlrParser.FOREACH_LOOP_LPAREN, i);
		}
		public List<TerminalNode> FOREACH_LOOP_RPAREN() { return getTokens(BladeAntlrParser.FOREACH_LOOP_RPAREN); }
		public TerminalNode FOREACH_LOOP_RPAREN(int i) {
			return getToken(BladeAntlrParser.FOREACH_LOOP_RPAREN, i);
		}
		public List<TerminalNode> FOREACH_AS() { return getTokens(BladeAntlrParser.FOREACH_AS); }
		public TerminalNode FOREACH_AS(int i) {
			return getToken(BladeAntlrParser.FOREACH_AS, i);
		}
		public Loop_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterLoop_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitLoop_expression(this);
		}
	}

	public final Loop_expressionContext loop_expression() throws RecognitionException {
		Loop_expressionContext _localctx = new Loop_expressionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_loop_expression);
		int _la;
		try {
			int _alt;
			setState(442);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(436);
				simple_foreach_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(438); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(437);
						_la = _input.LA(1);
						if ( !(_la==PHP_EXPRESSION || _la==PHP_VARIABLE || ((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 15L) != 0)) ) {
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
					setState(440); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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
	public static class Simple_foreach_exprContext extends ParserRuleContext {
		public Token loop_array;
		public Token key;
		public Token item;
		public TerminalNode FOREACH_AS() { return getToken(BladeAntlrParser.FOREACH_AS, 0); }
		public List<TerminalNode> PHP_VARIABLE() { return getTokens(BladeAntlrParser.PHP_VARIABLE); }
		public TerminalNode PHP_VARIABLE(int i) {
			return getToken(BladeAntlrParser.PHP_VARIABLE, i);
		}
		public TerminalNode FOREACH_PARAM_ASSIGN() { return getToken(BladeAntlrParser.FOREACH_PARAM_ASSIGN, 0); }
		public Simple_foreach_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_foreach_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterSimple_foreach_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitSimple_foreach_expr(this);
		}
	}

	public final Simple_foreach_exprContext simple_foreach_expr() throws RecognitionException {
		Simple_foreach_exprContext _localctx = new Simple_foreach_exprContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_simple_foreach_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			((Simple_foreach_exprContext)_localctx).loop_array = match(PHP_VARIABLE);
			setState(445);
			match(FOREACH_AS);
			setState(446);
			((Simple_foreach_exprContext)_localctx).key = match(PHP_VARIABLE);
			setState(449);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FOREACH_PARAM_ASSIGN) {
				{
				setState(447);
				match(FOREACH_PARAM_ASSIGN);
				setState(448);
				((Simple_foreach_exprContext)_localctx).item = match(PHP_VARIABLE);
				}
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
	public static class SingleArgWrapperContext extends ParserRuleContext {
		public TerminalNode BLADE_PARAM_LPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, 0); }
		public TerminalNode BLADE_PARAM_RPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, 0); }
		public IdentifiableArgumentContext identifiableArgument() {
			return getRuleContext(IdentifiableArgumentContext.class,0);
		}
		public ComposedArgumentContext composedArgument() {
			return getRuleContext(ComposedArgumentContext.class,0);
		}
		public SingleArgWrapperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleArgWrapper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterSingleArgWrapper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitSingleArgWrapper(this);
		}
	}

	public final SingleArgWrapperContext singleArgWrapper() throws RecognitionException {
		SingleArgWrapperContext _localctx = new SingleArgWrapperContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_singleArgWrapper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			match(BLADE_PARAM_LPAREN);
			setState(454);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(452);
				identifiableArgument();
				}
				break;
			case 2:
				{
				setState(453);
				composedArgument();
				}
				break;
			}
			setState(456);
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
	public static class SingleArgAndDefaultWrapperContext extends ParserRuleContext {
		public TerminalNode BLADE_PARAM_LPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, 0); }
		public TerminalNode BLADE_PARAM_RPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, 0); }
		public IdentifiableArgumentContext identifiableArgument() {
			return getRuleContext(IdentifiableArgumentContext.class,0);
		}
		public List<ComposedArgumentContext> composedArgument() {
			return getRuleContexts(ComposedArgumentContext.class);
		}
		public ComposedArgumentContext composedArgument(int i) {
			return getRuleContext(ComposedArgumentContext.class,i);
		}
		public TerminalNode BL_COMMA() { return getToken(BladeAntlrParser.BL_COMMA, 0); }
		public SingleArgAndDefaultWrapperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleArgAndDefaultWrapper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterSingleArgAndDefaultWrapper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitSingleArgAndDefaultWrapper(this);
		}
	}

	public final SingleArgAndDefaultWrapperContext singleArgAndDefaultWrapper() throws RecognitionException {
		SingleArgAndDefaultWrapperContext _localctx = new SingleArgAndDefaultWrapperContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_singleArgAndDefaultWrapper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			match(BLADE_PARAM_LPAREN);
			setState(461);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(459);
				identifiableArgument();
				}
				break;
			case 2:
				{
				setState(460);
				composedArgument();
				}
				break;
			}
			setState(465);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BL_COMMA) {
				{
				setState(463);
				match(BL_COMMA);
				setState(464);
				composedArgument();
				}
			}

			setState(467);
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
	public static class DoubleArgWrapperContext extends ParserRuleContext {
		public TerminalNode BLADE_PARAM_LPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, 0); }
		public TerminalNode BL_COMMA() { return getToken(BladeAntlrParser.BL_COMMA, 0); }
		public List<ComposedArgumentContext> composedArgument() {
			return getRuleContexts(ComposedArgumentContext.class);
		}
		public ComposedArgumentContext composedArgument(int i) {
			return getRuleContext(ComposedArgumentContext.class,i);
		}
		public TerminalNode BLADE_PARAM_RPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, 0); }
		public IdentifiableArgumentContext identifiableArgument() {
			return getRuleContext(IdentifiableArgumentContext.class,0);
		}
		public DoubleArgWrapperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleArgWrapper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterDoubleArgWrapper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitDoubleArgWrapper(this);
		}
	}

	public final DoubleArgWrapperContext doubleArgWrapper() throws RecognitionException {
		DoubleArgWrapperContext _localctx = new DoubleArgWrapperContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_doubleArgWrapper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			match(BLADE_PARAM_LPAREN);
			setState(472);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(470);
				identifiableArgument();
				}
				break;
			case 2:
				{
				setState(471);
				composedArgument();
				}
				break;
			}
			setState(474);
			match(BL_COMMA);
			setState(475);
			composedArgument();
			setState(476);
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
	public static class MultiArgWrapperContext extends ParserRuleContext {
		public TerminalNode BLADE_PARAM_LPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, 0); }
		public TerminalNode BLADE_PARAM_RPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, 0); }
		public IdentifiableArgumentContext identifiableArgument() {
			return getRuleContext(IdentifiableArgumentContext.class,0);
		}
		public List<ComposedArgumentContext> composedArgument() {
			return getRuleContexts(ComposedArgumentContext.class);
		}
		public ComposedArgumentContext composedArgument(int i) {
			return getRuleContext(ComposedArgumentContext.class,i);
		}
		public TerminalNode BL_COMMA() { return getToken(BladeAntlrParser.BL_COMMA, 0); }
		public MultiArgWrapperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiArgWrapper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterMultiArgWrapper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitMultiArgWrapper(this);
		}
	}

	public final MultiArgWrapperContext multiArgWrapper() throws RecognitionException {
		MultiArgWrapperContext _localctx = new MultiArgWrapperContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_multiArgWrapper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			match(BLADE_PARAM_LPAREN);
			setState(481);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(479);
				identifiableArgument();
				}
				break;
			case 2:
				{
				setState(480);
				composedArgument();
				}
				break;
			}
			setState(485);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BL_COMMA) {
				{
				setState(483);
				match(BL_COMMA);
				setState(484);
				composedArgument();
				}
			}

			setState(487);
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
	public static class IdentifiableArgumentContext extends ParserRuleContext {
		public TerminalNode BL_PARAM_STRING() { return getToken(BladeAntlrParser.BL_PARAM_STRING, 0); }
		public List<TerminalNode> BL_PARAM_WS() { return getTokens(BladeAntlrParser.BL_PARAM_WS); }
		public TerminalNode BL_PARAM_WS(int i) {
			return getToken(BladeAntlrParser.BL_PARAM_WS, i);
		}
		public IdentifiableArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifiableArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterIdentifiableArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitIdentifiableArgument(this);
		}
	}

	public final IdentifiableArgumentContext identifiableArgument() throws RecognitionException {
		IdentifiableArgumentContext _localctx = new IdentifiableArgumentContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_identifiableArgument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(492);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_PARAM_WS) {
				{
				{
				setState(489);
				match(BL_PARAM_WS);
				}
				}
				setState(494);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(495);
			match(BL_PARAM_STRING);
			setState(499);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_PARAM_WS) {
				{
				{
				setState(496);
				match(BL_PARAM_WS);
				}
				}
				setState(501);
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
	public static class ComposedArgumentContext extends ParserRuleContext {
		public List<TerminalNode> BL_PARAM_WS() { return getTokens(BladeAntlrParser.BL_PARAM_WS); }
		public TerminalNode BL_PARAM_WS(int i) {
			return getToken(BladeAntlrParser.BL_PARAM_WS, i);
		}
		public List<PhpExprContext> phpExpr() {
			return getRuleContexts(PhpExprContext.class);
		}
		public PhpExprContext phpExpr(int i) {
			return getRuleContext(PhpExprContext.class,i);
		}
		public ComposedArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_composedArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterComposedArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitComposedArgument(this);
		}
	}

	public final ComposedArgumentContext composedArgument() throws RecognitionException {
		ComposedArgumentContext _localctx = new ComposedArgumentContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_composedArgument);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(502);
					match(BL_PARAM_WS);
					}
					} 
				}
				setState(507);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			}
			setState(509); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(508);
					phpExpr();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(511); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(516);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_PARAM_WS) {
				{
				{
				setState(513);
				match(BL_PARAM_WS);
				}
				}
				setState(518);
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
	public static class PhpExprContext extends ParserRuleContext {
		public IdentifiableArrayContext identifiableArray() {
			return getRuleContext(IdentifiableArrayContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode BLADE_PARAM_EXTRA() { return getToken(BladeAntlrParser.BLADE_PARAM_EXTRA, 0); }
		public TerminalNode PHP_VARIABLE() { return getToken(BladeAntlrParser.PHP_VARIABLE, 0); }
		public TerminalNode PHP_KEYWORD() { return getToken(BladeAntlrParser.PHP_KEYWORD, 0); }
		public TerminalNode BL_PARAM_WS() { return getToken(BladeAntlrParser.BL_PARAM_WS, 0); }
		public TerminalNode BL_PARAM_CONCAT_OPERATOR() { return getToken(BladeAntlrParser.BL_PARAM_CONCAT_OPERATOR, 0); }
		public TerminalNode BL_PARAM_STRING() { return getToken(BladeAntlrParser.BL_PARAM_STRING, 0); }
		public TerminalNode BL_PARAM_ASSIGN() { return getToken(BladeAntlrParser.BL_PARAM_ASSIGN, 0); }
		public TerminalNode BL_NAME_STRING() { return getToken(BladeAntlrParser.BL_NAME_STRING, 0); }
		public TerminalNode BL_COMMA() { return getToken(BladeAntlrParser.BL_COMMA, 0); }
		public PhpExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phpExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterPhpExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitPhpExpr(this);
		}
	}

	public final PhpExprContext phpExpr() throws RecognitionException {
		PhpExprContext _localctx = new PhpExprContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_phpExpr);
		try {
			setState(530);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(519);
				identifiableArray();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(520);
				array();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(521);
				match(BLADE_PARAM_EXTRA);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(522);
				match(PHP_VARIABLE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(523);
				match(PHP_KEYWORD);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(524);
				match(BL_PARAM_WS);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(525);
				match(BL_PARAM_CONCAT_OPERATOR);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(526);
				match(BL_PARAM_STRING);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(527);
				match(BL_PARAM_ASSIGN);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(528);
				match(BL_NAME_STRING);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(529);
				match(BL_COMMA);
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
	public static class IdentifiableArrayContext extends ParserRuleContext {
		public TerminalNode BL_SQ_LPAREN() { return getToken(BladeAntlrParser.BL_SQ_LPAREN, 0); }
		public TerminalNode BL_SQ_RPAREN() { return getToken(BladeAntlrParser.BL_SQ_RPAREN, 0); }
		public List<ParamAssignContext> paramAssign() {
			return getRuleContexts(ParamAssignContext.class);
		}
		public ParamAssignContext paramAssign(int i) {
			return getRuleContext(ParamAssignContext.class,i);
		}
		public IdentifiableArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifiableArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterIdentifiableArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitIdentifiableArray(this);
		}
	}

	public final IdentifiableArrayContext identifiableArray() throws RecognitionException {
		IdentifiableArrayContext _localctx = new IdentifiableArrayContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_identifiableArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(532);
			match(BL_SQ_LPAREN);
			setState(534); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(533);
				paramAssign();
				}
				}
				setState(536); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==BL_PARAM_STRING );
			setState(538);
			match(BL_SQ_RPAREN);
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
	public static class ArrayContext extends ParserRuleContext {
		public TerminalNode BL_SQ_LPAREN() { return getToken(BladeAntlrParser.BL_SQ_LPAREN, 0); }
		public TerminalNode BL_SQ_RPAREN() { return getToken(BladeAntlrParser.BL_SQ_RPAREN, 0); }
		public List<PhpExprContext> phpExpr() {
			return getRuleContexts(PhpExprContext.class);
		}
		public PhpExprContext phpExpr(int i) {
			return getRuleContext(PhpExprContext.class,i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitArray(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_array);
		int _la;
		try {
			setState(550);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(540);
				match(BL_SQ_LPAREN);
				setState(542); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(541);
					phpExpr();
					}
					}
					setState(544); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 28L) != 0) || ((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & 477L) != 0) );
				setState(546);
				match(BL_SQ_RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(548);
				match(BL_SQ_LPAREN);
				setState(549);
				match(BL_SQ_RPAREN);
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
	public static class ParamAssignContext extends ParserRuleContext {
		public List<TerminalNode> BL_PARAM_STRING() { return getTokens(BladeAntlrParser.BL_PARAM_STRING); }
		public TerminalNode BL_PARAM_STRING(int i) {
			return getToken(BladeAntlrParser.BL_PARAM_STRING, i);
		}
		public TerminalNode BL_PARAM_ASSIGN() { return getToken(BladeAntlrParser.BL_PARAM_ASSIGN, 0); }
		public TerminalNode PHP_VARIABLE() { return getToken(BladeAntlrParser.PHP_VARIABLE, 0); }
		public TerminalNode PHP_KEYWORD() { return getToken(BladeAntlrParser.PHP_KEYWORD, 0); }
		public List<TerminalNode> BL_PARAM_WS() { return getTokens(BladeAntlrParser.BL_PARAM_WS); }
		public TerminalNode BL_PARAM_WS(int i) {
			return getToken(BladeAntlrParser.BL_PARAM_WS, i);
		}
		public ParamAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterParamAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitParamAssign(this);
		}
	}

	public final ParamAssignContext paramAssign() throws RecognitionException {
		ParamAssignContext _localctx = new ParamAssignContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_paramAssign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(552);
			match(BL_PARAM_STRING);
			setState(556);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_PARAM_WS) {
				{
				{
				setState(553);
				match(BL_PARAM_WS);
				}
				}
				setState(558);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(559);
			match(BL_PARAM_ASSIGN);
			setState(563);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_PARAM_WS) {
				{
				{
				setState(560);
				match(BL_PARAM_WS);
				}
				}
				setState(565);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(566);
			_la = _input.LA(1);
			if ( !(_la==PHP_VARIABLE || _la==PHP_KEYWORD || _la==BL_PARAM_STRING) ) {
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
		enterRule(_localctx, 98, RULE_verbatim_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568);
			match(D_VERBATIM);
			setState(570); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(569);
				non_blade_statement();
				}
				}
				setState(572); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==HTML || _la==PHP_INLINE );
			setState(574);
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
	public static class Loop_actionContext extends ParserRuleContext {
		public TerminalNode D_LOOP_ACTION() { return getToken(BladeAntlrParser.D_LOOP_ACTION, 0); }
		public TerminalNode D_BREAK() { return getToken(BladeAntlrParser.D_BREAK, 0); }
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public Loop_actionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterLoop_action(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitLoop_action(this);
		}
	}

	public final Loop_actionContext loop_action() throws RecognitionException {
		Loop_actionContext _localctx = new Loop_actionContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_loop_action);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(576);
			_la = _input.LA(1);
			if ( !(_la==D_BREAK || _la==D_LOOP_ACTION) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(578);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PHP_EXPRESSION) {
				{
				setState(577);
				php_expression();
				}
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
		enterRule(_localctx, 102, RULE_html);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(581); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(580);
					match(HTML);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(583); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
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
		"\u0004\u0001i\u024a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u0001\u0000\u0005\u0000j\b\u0000\n\u0000\f\u0000"+
		"m\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001u\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002{\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"\u0097\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0004\u0004\u009e\b\u0004\u000b\u0004\f\u0004\u009f\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0004\u0004\u00ab\b\u0004\u000b\u0004\f\u0004\u00ac"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004"+
		"\u00b4\b\u0004\u000b\u0004\f\u0004\u00b5\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0004\u0004\u00bd\b\u0004\u000b\u0004\f"+
		"\u0004\u00be\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"\u00cb\b\u0004\u0001\u0005\u0001\u0005\u0003\u0005\u00cf\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0005\b\u00db\b\b\n\b\f\b\u00de\t\b\u0001\b"+
		"\u0001\b\u0001\t\u0001\t\u0001\t\u0004\t\u00e5\b\t\u000b\t\f\t\u00e6\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0004\n\u00ee\b\n\u000b\n\f\n\u00ef"+
		"\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0004\u000b\u00f7"+
		"\b\u000b\u000b\u000b\f\u000b\u00f8\u0001\u000b\u0003\u000b\u00fc\b\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0004\f\u0101\b\f\u000b\f\f\f\u0102\u0001\f\u0003"+
		"\f\u0106\b\f\u0001\r\u0001\r\u0004\r\u010a\b\r\u000b\r\f\r\u010b\u0001"+
		"\r\u0003\r\u010f\b\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0004\u000f\u0116\b\u000f\u000b\u000f\f\u000f\u0117\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0005\u0010\u011e\b\u0010\n\u0010"+
		"\f\u0010\u0121\t\u0010\u0001\u0010\u0004\u0010\u0124\b\u0010\u000b\u0010"+
		"\f\u0010\u0125\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0004\u0011\u012e\b\u0011\u000b\u0011\f\u0011\u012f\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0004\u0012\u0137"+
		"\b\u0012\u000b\u0012\f\u0012\u0138\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0004\u0013\u0140\b\u0013\u000b\u0013\f\u0013"+
		"\u0141\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0004\u0014\u014b\b\u0014\u000b\u0014\f\u0014\u014c"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0004\u0015\u0155\b\u0015\u000b\u0015\f\u0015\u0156\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u0170\b\u001b\u0001"+
		"\u001b\u0001\u001b\u0003\u001b\u0174\b\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0003\u001d\u017f\b\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u0188\b\u001d\u0003"+
		"\u001d\u018a\b\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0005\u001e\u0191\b\u001e\n\u001e\f\u001e\u0194\t\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 "+
		"\u0001 \u0001!\u0001!\u0001\"\u0001\"\u0005\"\u01a3\b\"\n\"\f\"\u01a6"+
		"\t\"\u0001\"\u0001\"\u0001#\u0001#\u0005#\u01ac\b#\n#\f#\u01af\t#\u0001"+
		"#\u0001#\u0001$\u0001$\u0001%\u0001%\u0004%\u01b7\b%\u000b%\f%\u01b8\u0003"+
		"%\u01bb\b%\u0001&\u0001&\u0001&\u0001&\u0001&\u0003&\u01c2\b&\u0001\'"+
		"\u0001\'\u0001\'\u0003\'\u01c7\b\'\u0001\'\u0001\'\u0001(\u0001(\u0001"+
		"(\u0003(\u01ce\b(\u0001(\u0001(\u0003(\u01d2\b(\u0001(\u0001(\u0001)\u0001"+
		")\u0001)\u0003)\u01d9\b)\u0001)\u0001)\u0001)\u0001)\u0001*\u0001*\u0001"+
		"*\u0003*\u01e2\b*\u0001*\u0001*\u0003*\u01e6\b*\u0001*\u0001*\u0001+\u0005"+
		"+\u01eb\b+\n+\f+\u01ee\t+\u0001+\u0001+\u0005+\u01f2\b+\n+\f+\u01f5\t"+
		"+\u0001,\u0005,\u01f8\b,\n,\f,\u01fb\t,\u0001,\u0004,\u01fe\b,\u000b,"+
		"\f,\u01ff\u0001,\u0005,\u0203\b,\n,\f,\u0206\t,\u0001-\u0001-\u0001-\u0001"+
		"-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0003-\u0213\b-\u0001"+
		".\u0001.\u0004.\u0217\b.\u000b.\f.\u0218\u0001.\u0001.\u0001/\u0001/\u0004"+
		"/\u021f\b/\u000b/\f/\u0220\u0001/\u0001/\u0001/\u0001/\u0003/\u0227\b"+
		"/\u00010\u00010\u00050\u022b\b0\n0\f0\u022e\t0\u00010\u00010\u00050\u0232"+
		"\b0\n0\f0\u0235\t0\u00010\u00010\u00011\u00011\u00041\u023b\b1\u000b1"+
		"\f1\u023c\u00011\u00011\u00012\u00012\u00032\u0243\b2\u00013\u00043\u0246"+
		"\b3\u000b3\f3\u0247\u00013\u0000\u00004\u0000\u0002\u0004\u0006\b\n\f"+
		"\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:"+
		"<>@BDFHJLNPRTVXZ\\^`bdf\u0000\u0007\u0001\u0000CD\u0002\u0000++.0\u0002"+
		"\u0000\"\"$$\u0002\u0000\u0002\u0002\u0007\u0007\u0002\u0000\u0001\u0002"+
		"Y\\\u0002\u0000\u0002\u0003``\u0001\u0000\u001e\u001f\u0282\u0000k\u0001"+
		"\u0000\u0000\u0000\u0002t\u0001\u0000\u0000\u0000\u0004z\u0001\u0000\u0000"+
		"\u0000\u0006\u0096\u0001\u0000\u0000\u0000\b\u00ca\u0001\u0000\u0000\u0000"+
		"\n\u00ce\u0001\u0000\u0000\u0000\f\u00d0\u0001\u0000\u0000\u0000\u000e"+
		"\u00d3\u0001\u0000\u0000\u0000\u0010\u00d6\u0001\u0000\u0000\u0000\u0012"+
		"\u00e1\u0001\u0000\u0000\u0000\u0014\u00ea\u0001\u0000\u0000\u0000\u0016"+
		"\u00f3\u0001\u0000\u0000\u0000\u0018\u00fd\u0001\u0000\u0000\u0000\u001a"+
		"\u0107\u0001\u0000\u0000\u0000\u001c\u0110\u0001\u0000\u0000\u0000\u001e"+
		"\u0112\u0001\u0000\u0000\u0000 \u011b\u0001\u0000\u0000\u0000\"\u0129"+
		"\u0001\u0000\u0000\u0000$\u0133\u0001\u0000\u0000\u0000&\u013c\u0001\u0000"+
		"\u0000\u0000(\u0145\u0001\u0000\u0000\u0000*\u0150\u0001\u0000\u0000\u0000"+
		",\u015a\u0001\u0000\u0000\u0000.\u015d\u0001\u0000\u0000\u00000\u0160"+
		"\u0001\u0000\u0000\u00002\u0163\u0001\u0000\u0000\u00004\u0166\u0001\u0000"+
		"\u0000\u00006\u0169\u0001\u0000\u0000\u00008\u0177\u0001\u0000\u0000\u0000"+
		":\u017a\u0001\u0000\u0000\u0000<\u018d\u0001\u0000\u0000\u0000>\u0197"+
		"\u0001\u0000\u0000\u0000@\u019a\u0001\u0000\u0000\u0000B\u019e\u0001\u0000"+
		"\u0000\u0000D\u01a0\u0001\u0000\u0000\u0000F\u01a9\u0001\u0000\u0000\u0000"+
		"H\u01b2\u0001\u0000\u0000\u0000J\u01ba\u0001\u0000\u0000\u0000L\u01bc"+
		"\u0001\u0000\u0000\u0000N\u01c3\u0001\u0000\u0000\u0000P\u01ca\u0001\u0000"+
		"\u0000\u0000R\u01d5\u0001\u0000\u0000\u0000T\u01de\u0001\u0000\u0000\u0000"+
		"V\u01ec\u0001\u0000\u0000\u0000X\u01f9\u0001\u0000\u0000\u0000Z\u0212"+
		"\u0001\u0000\u0000\u0000\\\u0214\u0001\u0000\u0000\u0000^\u0226\u0001"+
		"\u0000\u0000\u0000`\u0228\u0001\u0000\u0000\u0000b\u0238\u0001\u0000\u0000"+
		"\u0000d\u0240\u0001\u0000\u0000\u0000f\u0245\u0001\u0000\u0000\u0000h"+
		"j\u0003\u0002\u0001\u0000ih\u0001\u0000\u0000\u0000jm\u0001\u0000\u0000"+
		"\u0000ki\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000ln\u0001\u0000"+
		"\u0000\u0000mk\u0001\u0000\u0000\u0000no\u0005\u0000\u0000\u0001o\u0001"+
		"\u0001\u0000\u0000\u0000pu\u0003\u0004\u0002\u0000qu\u0003\b\u0004\u0000"+
		"ru\u0005R\u0000\u0000su\u0003f3\u0000tp\u0001\u0000\u0000\u0000tq\u0001"+
		"\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000ts\u0001\u0000\u0000\u0000"+
		"u\u0003\u0001\u0000\u0000\u0000v{\u0003\u0006\u0003\u0000w{\u0003D\"\u0000"+
		"x{\u0003F#\u0000y{\u0003B!\u0000zv\u0001\u0000\u0000\u0000zw\u0001\u0000"+
		"\u0000\u0000zx\u0001\u0000\u0000\u0000zy\u0001\u0000\u0000\u0000{\u0005"+
		"\u0001\u0000\u0000\u0000|\u0097\u0003\f\u0006\u0000}\u0097\u0003\u000e"+
		"\u0007\u0000~\u0097\u0003,\u0016\u0000\u007f\u0097\u0003.\u0017\u0000"+
		"\u0080\u0097\u00032\u0019\u0000\u0081\u0097\u00034\u001a\u0000\u0082\u0097"+
		"\u00036\u001b\u0000\u0083\u0097\u00038\u001c\u0000\u0084\u0097\u0003:"+
		"\u001d\u0000\u0085\u0086\u0007\u0000\u0000\u0000\u0086\u0097\u0003H$\u0000"+
		"\u0087\u0088\u0005:\u0000\u0000\u0088\u0097\u0003H$\u0000\u0089\u008a"+
		"\u00058\u0000\u0000\u008a\u0097\u0003H$\u0000\u008b\u0097\u00059\u0000"+
		"\u0000\u008c\u0097\u00030\u0018\u0000\u008d\u008e\u0005J\u0000\u0000\u008e"+
		"\u0097\u0003R)\u0000\u008f\u0090\u0005E\u0000\u0000\u0090\u0097\u0003"+
		"H$\u0000\u0091\u0092\u0005\u000f\u0000\u0000\u0092\u0097\u0003H$\u0000"+
		"\u0093\u0097\u0005\u0010\u0000\u0000\u0094\u0097\u0003d2\u0000\u0095\u0097"+
		"\u0003>\u001f\u0000\u0096|\u0001\u0000\u0000\u0000\u0096}\u0001\u0000"+
		"\u0000\u0000\u0096~\u0001\u0000\u0000\u0000\u0096\u007f\u0001\u0000\u0000"+
		"\u0000\u0096\u0080\u0001\u0000\u0000\u0000\u0096\u0081\u0001\u0000\u0000"+
		"\u0000\u0096\u0082\u0001\u0000\u0000\u0000\u0096\u0083\u0001\u0000\u0000"+
		"\u0000\u0096\u0084\u0001\u0000\u0000\u0000\u0096\u0085\u0001\u0000\u0000"+
		"\u0000\u0096\u0087\u0001\u0000\u0000\u0000\u0096\u0089\u0001\u0000\u0000"+
		"\u0000\u0096\u008b\u0001\u0000\u0000\u0000\u0096\u008c\u0001\u0000\u0000"+
		"\u0000\u0096\u008d\u0001\u0000\u0000\u0000\u0096\u008f\u0001\u0000\u0000"+
		"\u0000\u0096\u0091\u0001\u0000\u0000\u0000\u0096\u0093\u0001\u0000\u0000"+
		"\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0096\u0095\u0001\u0000\u0000"+
		"\u0000\u0097\u0007\u0001\u0000\u0000\u0000\u0098\u00cb\u0003\u0010\b\u0000"+
		"\u0099\u00cb\u0003<\u001e\u0000\u009a\u00cb\u0003\u0012\t\u0000\u009b"+
		"\u009d\u00051\u0000\u0000\u009c\u009e\u0003\u0002\u0001\u0000\u009d\u009c"+
		"\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u009d"+
		"\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a2\u00052\u0000\u0000\u00a2\u00cb\u0001"+
		"\u0000\u0000\u0000\u00a3\u00cb\u0003\u0016\u000b\u0000\u00a4\u00cb\u0003"+
		"\u0018\f\u0000\u00a5\u00cb\u0003\u001a\r\u0000\u00a6\u00cb\u0003\"\u0011"+
		"\u0000\u00a7\u00a8\u0005?\u0000\u0000\u00a8\u00aa\u0003N\'\u0000\u00a9"+
		"\u00ab\u0003\u0002\u0001\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00ab"+
		"\u00ac\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ac"+
		"\u00ad\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae"+
		"\u00af\u0005@\u0000\u0000\u00af\u00cb\u0001\u0000\u0000\u0000\u00b0\u00b1"+
		"\u0005\u0012\u0000\u0000\u00b1\u00b3\u0003H$\u0000\u00b2\u00b4\u0003\u0002"+
		"\u0001\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005\u0013"+
		"\u0000\u0000\u00b8\u00cb\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005;\u0000"+
		"\u0000\u00ba\u00bc\u0003H$\u0000\u00bb\u00bd\u0003\u0002\u0001\u0000\u00bc"+
		"\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be"+
		"\u00bc\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005<\u0000\u0000\u00c1\u00cb"+
		"\u0001\u0000\u0000\u0000\u00c2\u00cb\u0003\u001e\u000f\u0000\u00c3\u00cb"+
		"\u0003 \u0010\u0000\u00c4\u00cb\u0003$\u0012\u0000\u00c5\u00cb\u0003&"+
		"\u0013\u0000\u00c6\u00cb\u0003(\u0014\u0000\u00c7\u00cb\u0003*\u0015\u0000"+
		"\u00c8\u00cb\u0003b1\u0000\u00c9\u00cb\u0003@ \u0000\u00ca\u0098\u0001"+
		"\u0000\u0000\u0000\u00ca\u0099\u0001\u0000\u0000\u0000\u00ca\u009a\u0001"+
		"\u0000\u0000\u0000\u00ca\u009b\u0001\u0000\u0000\u0000\u00ca\u00a3\u0001"+
		"\u0000\u0000\u0000\u00ca\u00a4\u0001\u0000\u0000\u0000\u00ca\u00a5\u0001"+
		"\u0000\u0000\u0000\u00ca\u00a6\u0001\u0000\u0000\u0000\u00ca\u00a7\u0001"+
		"\u0000\u0000\u0000\u00ca\u00b0\u0001\u0000\u0000\u0000\u00ca\u00b9\u0001"+
		"\u0000\u0000\u0000\u00ca\u00c2\u0001\u0000\u0000\u0000\u00ca\u00c3\u0001"+
		"\u0000\u0000\u0000\u00ca\u00c4\u0001\u0000\u0000\u0000\u00ca\u00c5\u0001"+
		"\u0000\u0000\u0000\u00ca\u00c6\u0001\u0000\u0000\u0000\u00ca\u00c7\u0001"+
		"\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00ca\u00c9\u0001"+
		"\u0000\u0000\u0000\u00cb\t\u0001\u0000\u0000\u0000\u00cc\u00cf\u0003f"+
		"3\u0000\u00cd\u00cf\u0003B!\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000"+
		"\u00ce\u00cd\u0001\u0000\u0000\u0000\u00cf\u000b\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d1\u0005&\u0000\u0000\u00d1\u00d2\u0003N\'\u0000\u00d2\r\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d4\u0005(\u0000\u0000\u00d4\u00d5\u0003R)"+
		"\u0000\u00d5\u000f\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005(\u0000\u0000"+
		"\u00d7\u00dc\u0003N\'\u0000\u00d8\u00db\u0003\u0002\u0001\u0000\u00d9"+
		"\u00db\u0005-\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da\u00d9"+
		"\u0001\u0000\u0000\u0000\u00db\u00de\u0001\u0000\u0000\u0000\u00dc\u00da"+
		"\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd\u00df"+
		"\u0001\u0000\u0000\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00df\u00e0"+
		"\u0007\u0001\u0000\u0000\u00e0\u0011\u0001\u0000\u0000\u0000\u00e1\u00e2"+
		"\u00054\u0000\u0000\u00e2\u00e4\u0003N\'\u0000\u00e3\u00e5\u0003\u0002"+
		"\u0001\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000"+
		"\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000"+
		"\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8\u00e9\u00055\u0000"+
		"\u0000\u00e9\u0013\u0001\u0000\u0000\u0000\u00ea\u00eb\u00056\u0000\u0000"+
		"\u00eb\u00ed\u0003N\'\u0000\u00ec\u00ee\u0003\u0002\u0001\u0000\u00ed"+
		"\u00ec\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef"+
		"\u00ed\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0"+
		"\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f2\u00057\u0000\u0000\u00f2\u0015"+
		"\u0001\u0000\u0000\u0000\u00f3\u00f4\u0005\n\u0000\u0000\u00f4\u00f6\u0003"+
		"H$\u0000\u00f5\u00f7\u0003\u0002\u0001\u0000\u00f6\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8\u00f6\u0001\u0000\u0000"+
		"\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9\u00fb\u0001\u0000\u0000"+
		"\u0000\u00fa\u00fc\u0003\u001c\u000e\u0000\u00fb\u00fa\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u0017\u0001\u0000\u0000"+
		"\u0000\u00fd\u00fe\u0005\u000b\u0000\u0000\u00fe\u0100\u0003H$\u0000\u00ff"+
		"\u0101\u0003\u0002\u0001\u0000\u0100\u00ff\u0001\u0000\u0000\u0000\u0101"+
		"\u0102\u0001\u0000\u0000\u0000\u0102\u0100\u0001\u0000\u0000\u0000\u0102"+
		"\u0103\u0001\u0000\u0000\u0000\u0103\u0105\u0001\u0000\u0000\u0000\u0104"+
		"\u0106\u0003\u001c\u000e\u0000\u0105\u0104\u0001\u0000\u0000\u0000\u0105"+
		"\u0106\u0001\u0000\u0000\u0000\u0106\u0019\u0001\u0000\u0000\u0000\u0107"+
		"\u0109\u0005\f\u0000\u0000\u0108\u010a\u0003\u0002\u0001\u0000\u0109\u0108"+
		"\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b\u0109"+
		"\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010e"+
		"\u0001\u0000\u0000\u0000\u010d\u010f\u0003\u001c\u000e\u0000\u010e\u010d"+
		"\u0001\u0000\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u001b"+
		"\u0001\u0000\u0000\u0000\u0110\u0111\u0005\r\u0000\u0000\u0111\u001d\u0001"+
		"\u0000\u0000\u0000\u0112\u0113\u0005\u0014\u0000\u0000\u0113\u0115\u0003"+
		"H$\u0000\u0114\u0116\u0003\u0002\u0001\u0000\u0115\u0114\u0001\u0000\u0000"+
		"\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0117\u0115\u0001\u0000\u0000"+
		"\u0000\u0117\u0118\u0001\u0000\u0000\u0000\u0118\u0119\u0001\u0000\u0000"+
		"\u0000\u0119\u011a\u0005\u0015\u0000\u0000\u011a\u001f\u0001\u0000\u0000"+
		"\u0000\u011b\u011f\u0005A\u0000\u0000\u011c\u011e\u0003N\'\u0000\u011d"+
		"\u011c\u0001\u0000\u0000\u0000\u011e\u0121\u0001\u0000\u0000\u0000\u011f"+
		"\u011d\u0001\u0000\u0000\u0000\u011f\u0120\u0001\u0000\u0000\u0000\u0120"+
		"\u0123\u0001\u0000\u0000\u0000\u0121\u011f\u0001\u0000\u0000\u0000\u0122"+
		"\u0124\u0003\u0002\u0001\u0000\u0123\u0122\u0001\u0000\u0000\u0000\u0124"+
		"\u0125\u0001\u0000\u0000\u0000\u0125\u0123\u0001\u0000\u0000\u0000\u0125"+
		"\u0126\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127"+
		"\u0128\u0005B\u0000\u0000\u0128!\u0001\u0000\u0000\u0000\u0129\u012a\u0005"+
		"\u000e\u0000\u0000\u012a\u012d\u0003H$\u0000\u012b\u012e\u0003\u0002\u0001"+
		"\u0000\u012c\u012e\u0005\u001e\u0000\u0000\u012d\u012b\u0001\u0000\u0000"+
		"\u0000\u012d\u012c\u0001\u0000\u0000\u0000\u012e\u012f\u0001\u0000\u0000"+
		"\u0000\u012f\u012d\u0001\u0000\u0000\u0000\u012f\u0130\u0001\u0000\u0000"+
		"\u0000\u0130\u0131\u0001\u0000\u0000\u0000\u0131\u0132\u0005\u0011\u0000"+
		"\u0000\u0132#\u0001\u0000\u0000\u0000\u0133\u0134\u0005\u001c\u0000\u0000"+
		"\u0134\u0136\u0003H$\u0000\u0135\u0137\u0003\u0002\u0001\u0000\u0136\u0135"+
		"\u0001\u0000\u0000\u0000\u0137\u0138\u0001\u0000\u0000\u0000\u0138\u0136"+
		"\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139\u013a"+
		"\u0001\u0000\u0000\u0000\u013a\u013b\u0005\u001d\u0000\u0000\u013b%\u0001"+
		"\u0000\u0000\u0000\u013c\u013d\u0005\u0018\u0000\u0000\u013d\u013f\u0003"+
		"H$\u0000\u013e\u0140\u0003\u0002\u0001\u0000\u013f\u013e\u0001\u0000\u0000"+
		"\u0000\u0140\u0141\u0001\u0000\u0000\u0000\u0141\u013f\u0001\u0000\u0000"+
		"\u0000\u0141\u0142\u0001\u0000\u0000\u0000\u0142\u0143\u0001\u0000\u0000"+
		"\u0000\u0143\u0144\u0005\u0019\u0000\u0000\u0144\'\u0001\u0000\u0000\u0000"+
		"\u0145\u0146\u0005\u0016\u0000\u0000\u0146\u0147\u0005Y\u0000\u0000\u0147"+
		"\u0148\u0003J%\u0000\u0148\u014a\u0005Z\u0000\u0000\u0149\u014b\u0003"+
		"\u0002\u0001\u0000\u014a\u0149\u0001\u0000\u0000\u0000\u014b\u014c\u0001"+
		"\u0000\u0000\u0000\u014c\u014a\u0001\u0000\u0000\u0000\u014c\u014d\u0001"+
		"\u0000\u0000\u0000\u014d\u014e\u0001\u0000\u0000\u0000\u014e\u014f\u0005"+
		"\u0017\u0000\u0000\u014f)\u0001\u0000\u0000\u0000\u0150\u0151\u0005\u001a"+
		"\u0000\u0000\u0151\u0154\u0003H$\u0000\u0152\u0155\u0003\u0002\u0001\u0000"+
		"\u0153\u0155\u0005\u0012\u0000\u0000\u0154\u0152\u0001\u0000\u0000\u0000"+
		"\u0154\u0153\u0001\u0000\u0000\u0000\u0155\u0156\u0001\u0000\u0000\u0000"+
		"\u0156\u0154\u0001\u0000\u0000\u0000\u0156\u0157\u0001\u0000\u0000\u0000"+
		"\u0157\u0158\u0001\u0000\u0000\u0000\u0158\u0159\u0005\u001b\u0000\u0000"+
		"\u0159+\u0001\u0000\u0000\u0000\u015a\u015b\u0005,\u0000\u0000\u015b\u015c"+
		"\u0003N\'\u0000\u015c-\u0001\u0000\u0000\u0000\u015d\u015e\u00053\u0000"+
		"\u0000\u015e\u015f\u0003N\'\u0000\u015f/\u0001\u0000\u0000\u0000\u0160"+
		"\u0161\u0005I\u0000\u0000\u0161\u0162\u0003N\'\u0000\u01621\u0001\u0000"+
		"\u0000\u0000\u0163\u0164\u0005 \u0000\u0000\u0164\u0165\u0003P(\u0000"+
		"\u01653\u0001\u0000\u0000\u0000\u0166\u0167\u0005!\u0000\u0000\u0167\u0168"+
		"\u0003P(\u0000\u01685\u0001\u0000\u0000\u0000\u0169\u016a\u0007\u0002"+
		"\u0000\u0000\u016a\u016b\u0005\u0005\u0000\u0000\u016b\u016c\u0003X,\u0000"+
		"\u016c\u016f\u0005d\u0000\u0000\u016d\u0170\u0003V+\u0000\u016e\u0170"+
		"\u0003X,\u0000\u016f\u016d\u0001\u0000\u0000\u0000\u016f\u016e\u0001\u0000"+
		"\u0000\u0000\u0170\u0173\u0001\u0000\u0000\u0000\u0171\u0172\u0005d\u0000"+
		"\u0000\u0172\u0174\u0003X,\u0000\u0173\u0171\u0001\u0000\u0000\u0000\u0173"+
		"\u0174\u0001\u0000\u0000\u0000\u0174\u0175\u0001\u0000\u0000\u0000\u0175"+
		"\u0176\u0005\u0006\u0000\u0000\u01767\u0001\u0000\u0000\u0000\u0177\u0178"+
		"\u0005#\u0000\u0000\u0178\u0179\u0003P(\u0000\u01799\u0001\u0000\u0000"+
		"\u0000\u017a\u017b\u0005%\u0000\u0000\u017b\u017e\u0005\u0005\u0000\u0000"+
		"\u017c\u017f\u0003V+\u0000\u017d\u017f\u0003X,\u0000\u017e\u017c\u0001"+
		"\u0000\u0000\u0000\u017e\u017d\u0001\u0000\u0000\u0000\u017f\u0180\u0001"+
		"\u0000\u0000\u0000\u0180\u0181\u0005d\u0000\u0000\u0181\u0182\u0003X,"+
		"\u0000\u0182\u0183\u0005d\u0000\u0000\u0183\u0189\u0003X,\u0000\u0184"+
		"\u0187\u0005d\u0000\u0000\u0185\u0188\u0003V+\u0000\u0186\u0188\u0003"+
		"X,\u0000\u0187\u0185\u0001\u0000\u0000\u0000\u0187\u0186\u0001\u0000\u0000"+
		"\u0000\u0188\u018a\u0001\u0000\u0000\u0000\u0189\u0184\u0001\u0000\u0000"+
		"\u0000\u0189\u018a\u0001\u0000\u0000\u0000\u018a\u018b\u0001\u0000\u0000"+
		"\u0000\u018b\u018c\u0005\u0006\u0000\u0000\u018c;\u0001\u0000\u0000\u0000"+
		"\u018d\u018e\u0005)\u0000\u0000\u018e\u0192\u0003N\'\u0000\u018f\u0191"+
		"\u0003\u0002\u0001\u0000\u0190\u018f\u0001\u0000\u0000\u0000\u0191\u0194"+
		"\u0001\u0000\u0000\u0000\u0192\u0190\u0001\u0000\u0000\u0000\u0192\u0193"+
		"\u0001\u0000\u0000\u0000\u0193\u0195\u0001\u0000\u0000\u0000\u0194\u0192"+
		"\u0001\u0000\u0000\u0000\u0195\u0196\u0005\r\u0000\u0000\u0196=\u0001"+
		"\u0000\u0000\u0000\u0197\u0198\u0005N\u0000\u0000\u0198\u0199\u0003T*"+
		"\u0000\u0199?\u0001\u0000\u0000\u0000\u019a\u019b\u0005K\u0000\u0000\u019b"+
		"\u019c\u0005h\u0000\u0000\u019c\u019d\u0005g\u0000\u0000\u019dA\u0001"+
		"\u0000\u0000\u0000\u019e\u019f\u0005S\u0000\u0000\u019fC\u0001\u0000\u0000"+
		"\u0000\u01a0\u01a4\u0005O\u0000\u0000\u01a1\u01a3\u0007\u0003\u0000\u0000"+
		"\u01a2\u01a1\u0001\u0000\u0000\u0000\u01a3\u01a6\u0001\u0000\u0000\u0000"+
		"\u01a4\u01a2\u0001\u0000\u0000\u0000\u01a4\u01a5\u0001\u0000\u0000\u0000"+
		"\u01a5\u01a7\u0001\u0000\u0000\u0000\u01a6\u01a4\u0001\u0000\u0000\u0000"+
		"\u01a7\u01a8\u0005T\u0000\u0000\u01a8E\u0001\u0000\u0000\u0000\u01a9\u01ad"+
		"\u0005P\u0000\u0000\u01aa\u01ac\u0007\u0003\u0000\u0000\u01ab\u01aa\u0001"+
		"\u0000\u0000\u0000\u01ac\u01af\u0001\u0000\u0000\u0000\u01ad\u01ab\u0001"+
		"\u0000\u0000\u0000\u01ad\u01ae\u0001\u0000\u0000\u0000\u01ae\u01b0\u0001"+
		"\u0000\u0000\u0000\u01af\u01ad\u0001\u0000\u0000\u0000\u01b0\u01b1\u0005"+
		"U\u0000\u0000\u01b1G\u0001\u0000\u0000\u0000\u01b2\u01b3\u0005\u0001\u0000"+
		"\u0000\u01b3I\u0001\u0000\u0000\u0000\u01b4\u01bb\u0003L&\u0000\u01b5"+
		"\u01b7\u0007\u0004\u0000\u0000\u01b6\u01b5\u0001\u0000\u0000\u0000\u01b7"+
		"\u01b8\u0001\u0000\u0000\u0000\u01b8\u01b6\u0001\u0000\u0000\u0000\u01b8"+
		"\u01b9\u0001\u0000\u0000\u0000\u01b9\u01bb\u0001\u0000\u0000\u0000\u01ba"+
		"\u01b4\u0001\u0000\u0000\u0000\u01ba\u01b6\u0001\u0000\u0000\u0000\u01bb"+
		"K\u0001\u0000\u0000\u0000\u01bc\u01bd\u0005\u0002\u0000\u0000\u01bd\u01be"+
		"\u0005[\u0000\u0000\u01be\u01c1\u0005\u0002\u0000\u0000\u01bf\u01c0\u0005"+
		"\\\u0000\u0000\u01c0\u01c2\u0005\u0002\u0000\u0000\u01c1\u01bf\u0001\u0000"+
		"\u0000\u0000\u01c1\u01c2\u0001\u0000\u0000\u0000\u01c2M\u0001\u0000\u0000"+
		"\u0000\u01c3\u01c6\u0005\u0005\u0000\u0000\u01c4\u01c7\u0003V+\u0000\u01c5"+
		"\u01c7\u0003X,\u0000\u01c6\u01c4\u0001\u0000\u0000\u0000\u01c6\u01c5\u0001"+
		"\u0000\u0000\u0000\u01c7\u01c8\u0001\u0000\u0000\u0000\u01c8\u01c9\u0005"+
		"\u0006\u0000\u0000\u01c9O\u0001\u0000\u0000\u0000\u01ca\u01cd\u0005\u0005"+
		"\u0000\u0000\u01cb\u01ce\u0003V+\u0000\u01cc\u01ce\u0003X,\u0000\u01cd"+
		"\u01cb\u0001\u0000\u0000\u0000\u01cd\u01cc\u0001\u0000\u0000\u0000\u01ce"+
		"\u01d1\u0001\u0000\u0000\u0000\u01cf\u01d0\u0005d\u0000\u0000\u01d0\u01d2"+
		"\u0003X,\u0000\u01d1\u01cf\u0001\u0000\u0000\u0000\u01d1\u01d2\u0001\u0000"+
		"\u0000\u0000\u01d2\u01d3\u0001\u0000\u0000\u0000\u01d3\u01d4\u0005\u0006"+
		"\u0000\u0000\u01d4Q\u0001\u0000\u0000\u0000\u01d5\u01d8\u0005\u0005\u0000"+
		"\u0000\u01d6\u01d9\u0003V+\u0000\u01d7\u01d9\u0003X,\u0000\u01d8\u01d6"+
		"\u0001\u0000\u0000\u0000\u01d8\u01d7\u0001\u0000\u0000\u0000\u01d9\u01da"+
		"\u0001\u0000\u0000\u0000\u01da\u01db\u0005d\u0000\u0000\u01db\u01dc\u0003"+
		"X,\u0000\u01dc\u01dd\u0005\u0006\u0000\u0000\u01ddS\u0001\u0000\u0000"+
		"\u0000\u01de\u01e1\u0005\u0005\u0000\u0000\u01df\u01e2\u0003V+\u0000\u01e0"+
		"\u01e2\u0003X,\u0000\u01e1\u01df\u0001\u0000\u0000\u0000\u01e1\u01e0\u0001"+
		"\u0000\u0000\u0000\u01e2\u01e5\u0001\u0000\u0000\u0000\u01e3\u01e4\u0005"+
		"d\u0000\u0000\u01e4\u01e6\u0003X,\u0000\u01e5\u01e3\u0001\u0000\u0000"+
		"\u0000\u01e5\u01e6\u0001\u0000\u0000\u0000\u01e6\u01e7\u0001\u0000\u0000"+
		"\u0000\u01e7\u01e8\u0005\u0006\u0000\u0000\u01e8U\u0001\u0000\u0000\u0000"+
		"\u01e9\u01eb\u0005e\u0000\u0000\u01ea\u01e9\u0001\u0000\u0000\u0000\u01eb"+
		"\u01ee\u0001\u0000\u0000\u0000\u01ec\u01ea\u0001\u0000\u0000\u0000\u01ec"+
		"\u01ed\u0001\u0000\u0000\u0000\u01ed\u01ef\u0001\u0000\u0000\u0000\u01ee"+
		"\u01ec\u0001\u0000\u0000\u0000\u01ef\u01f3\u0005`\u0000\u0000\u01f0\u01f2"+
		"\u0005e\u0000\u0000\u01f1\u01f0\u0001\u0000\u0000\u0000\u01f2\u01f5\u0001"+
		"\u0000\u0000\u0000\u01f3\u01f1\u0001\u0000\u0000\u0000\u01f3\u01f4\u0001"+
		"\u0000\u0000\u0000\u01f4W\u0001\u0000\u0000\u0000\u01f5\u01f3\u0001\u0000"+
		"\u0000\u0000\u01f6\u01f8\u0005e\u0000\u0000\u01f7\u01f6\u0001\u0000\u0000"+
		"\u0000\u01f8\u01fb\u0001\u0000\u0000\u0000\u01f9\u01f7\u0001\u0000\u0000"+
		"\u0000\u01f9\u01fa\u0001\u0000\u0000\u0000\u01fa\u01fd\u0001\u0000\u0000"+
		"\u0000\u01fb\u01f9\u0001\u0000\u0000\u0000\u01fc\u01fe\u0003Z-\u0000\u01fd"+
		"\u01fc\u0001\u0000\u0000\u0000\u01fe\u01ff\u0001\u0000\u0000\u0000\u01ff"+
		"\u01fd\u0001\u0000\u0000\u0000\u01ff\u0200\u0001\u0000\u0000\u0000\u0200"+
		"\u0204\u0001\u0000\u0000\u0000\u0201\u0203\u0005e\u0000\u0000\u0202\u0201"+
		"\u0001\u0000\u0000\u0000\u0203\u0206\u0001\u0000\u0000\u0000\u0204\u0202"+
		"\u0001\u0000\u0000\u0000\u0204\u0205\u0001\u0000\u0000\u0000\u0205Y\u0001"+
		"\u0000\u0000\u0000\u0206\u0204\u0001\u0000\u0000\u0000\u0207\u0213\u0003"+
		"\\.\u0000\u0208\u0213\u0003^/\u0000\u0209\u0213\u0005\u0004\u0000\u0000"+
		"\u020a\u0213\u0005\u0002\u0000\u0000\u020b\u0213\u0005\u0003\u0000\u0000"+
		"\u020c\u0213\u0005e\u0000\u0000\u020d\u0213\u0005b\u0000\u0000\u020e\u0213"+
		"\u0005`\u0000\u0000\u020f\u0213\u0005a\u0000\u0000\u0210\u0213\u0005f"+
		"\u0000\u0000\u0211\u0213\u0005d\u0000\u0000\u0212\u0207\u0001\u0000\u0000"+
		"\u0000\u0212\u0208\u0001\u0000\u0000\u0000\u0212\u0209\u0001\u0000\u0000"+
		"\u0000\u0212\u020a\u0001\u0000\u0000\u0000\u0212\u020b\u0001\u0000\u0000"+
		"\u0000\u0212\u020c\u0001\u0000\u0000\u0000\u0212\u020d\u0001\u0000\u0000"+
		"\u0000\u0212\u020e\u0001\u0000\u0000\u0000\u0212\u020f\u0001\u0000\u0000"+
		"\u0000\u0212\u0210\u0001\u0000\u0000\u0000\u0212\u0211\u0001\u0000\u0000"+
		"\u0000\u0213[\u0001\u0000\u0000\u0000\u0214\u0216\u0005^\u0000\u0000\u0215"+
		"\u0217\u0003`0\u0000\u0216\u0215\u0001\u0000\u0000\u0000\u0217\u0218\u0001"+
		"\u0000\u0000\u0000\u0218\u0216\u0001\u0000\u0000\u0000\u0218\u0219\u0001"+
		"\u0000\u0000\u0000\u0219\u021a\u0001\u0000\u0000\u0000\u021a\u021b\u0005"+
		"_\u0000\u0000\u021b]\u0001\u0000\u0000\u0000\u021c\u021e\u0005^\u0000"+
		"\u0000\u021d\u021f\u0003Z-\u0000\u021e\u021d\u0001\u0000\u0000\u0000\u021f"+
		"\u0220\u0001\u0000\u0000\u0000\u0220\u021e\u0001\u0000\u0000\u0000\u0220"+
		"\u0221\u0001\u0000\u0000\u0000\u0221\u0222\u0001\u0000\u0000\u0000\u0222"+
		"\u0223\u0005_\u0000\u0000\u0223\u0227\u0001\u0000\u0000\u0000\u0224\u0225"+
		"\u0005^\u0000\u0000\u0225\u0227\u0005_\u0000\u0000\u0226\u021c\u0001\u0000"+
		"\u0000\u0000\u0226\u0224\u0001\u0000\u0000\u0000\u0227_\u0001\u0000\u0000"+
		"\u0000\u0228\u022c\u0005`\u0000\u0000\u0229\u022b\u0005e\u0000\u0000\u022a"+
		"\u0229\u0001\u0000\u0000\u0000\u022b\u022e\u0001\u0000\u0000\u0000\u022c"+
		"\u022a\u0001\u0000\u0000\u0000\u022c\u022d\u0001\u0000\u0000\u0000\u022d"+
		"\u022f\u0001\u0000\u0000\u0000\u022e\u022c\u0001\u0000\u0000\u0000\u022f"+
		"\u0233\u0005a\u0000\u0000\u0230\u0232\u0005e\u0000\u0000\u0231\u0230\u0001"+
		"\u0000\u0000\u0000\u0232\u0235\u0001\u0000\u0000\u0000\u0233\u0231\u0001"+
		"\u0000\u0000\u0000\u0233\u0234\u0001\u0000\u0000\u0000\u0234\u0236\u0001"+
		"\u0000\u0000\u0000\u0235\u0233\u0001\u0000\u0000\u0000\u0236\u0237\u0007"+
		"\u0005\u0000\u0000\u0237a\u0001\u0000\u0000\u0000\u0238\u023a\u0005L\u0000"+
		"\u0000\u0239\u023b\u0003\n\u0005\u0000\u023a\u0239\u0001\u0000\u0000\u0000"+
		"\u023b\u023c\u0001\u0000\u0000\u0000\u023c\u023a\u0001\u0000\u0000\u0000"+
		"\u023c\u023d\u0001\u0000\u0000\u0000\u023d\u023e\u0001\u0000\u0000\u0000"+
		"\u023e\u023f\u0005M\u0000\u0000\u023fc\u0001\u0000\u0000\u0000\u0240\u0242"+
		"\u0007\u0006\u0000\u0000\u0241\u0243\u0003H$\u0000\u0242\u0241\u0001\u0000"+
		"\u0000\u0000\u0242\u0243\u0001\u0000\u0000\u0000\u0243e\u0001\u0000\u0000"+
		"\u0000\u0244\u0246\u0005\t\u0000\u0000\u0245\u0244\u0001\u0000\u0000\u0000"+
		"\u0246\u0247\u0001\u0000\u0000\u0000\u0247\u0245\u0001\u0000\u0000\u0000"+
		"\u0247\u0248\u0001\u0000\u0000\u0000\u0248g\u0001\u0000\u0000\u0000=k"+
		"tz\u0096\u009f\u00ac\u00b5\u00be\u00ca\u00ce\u00da\u00dc\u00e6\u00ef\u00f8"+
		"\u00fb\u0102\u0105\u010b\u010e\u0117\u011f\u0125\u012d\u012f\u0138\u0141"+
		"\u014c\u0154\u0156\u016f\u0173\u017e\u0187\u0189\u0192\u01a4\u01ad\u01b8"+
		"\u01ba\u01c1\u01c6\u01cd\u01d1\u01d8\u01e1\u01e5\u01ec\u01f3\u01f9\u01ff"+
		"\u0204\u0212\u0218\u0220\u0226\u022c\u0233\u023c\u0242\u0247";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}