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
		TOKEN_REF=1, RULE_REF=2, LEXER_CHAR_SET=3, PHP_EXPRESSION=4, PHP_VARIABLE=5, 
		PHP_KEYWORD=6, BLADE_PARAM_EXTRA=7, BLADE_PARAM_LPAREN=8, BLADE_PARAM_RPAREN=9, 
		BLADE_PHP_ECHO_EXPR=10, ERROR=11, BLADE_COMMENT=12, PHP_INLINE=13, D_IF=14, 
		D_ELSEIF=15, D_ELSE=16, D_ENDIF=17, D_SWITCH=18, D_CASE=19, D_DEFAULT=20, 
		D_ENDSWITCH=21, D_EMPTY=22, D_ENDEMPTY=23, D_COND_BLOCK_START=24, D_COND_BLOCK_END=25, 
		D_EACH=26, D_FOREACH=27, D_ENDFOREACH=28, D_FOR=29, D_ENDFOR=30, D_FORELSE=31, 
		D_ENDFORELSE=32, D_WHILE=33, D_ENDWHILE=34, D_BREAK=35, D_LOOP_ACTION=36, 
		D_INCLUDE=37, D_INCLUDE_IF=38, D_INCLUDE_WHEN=39, D_INCLUDE_FIRST=40, 
		D_INCLUDE_UNLESS=41, D_EXTENDS=42, D_JS=43, D_SECTION=44, D_HAS_SECTION=45, 
		D_SECTION_MISSING=46, D_ENDSECTION=47, D_YIELD=48, D_PARENT=49, D_SHOW=50, 
		D_OVERWRITE=51, D_STOP=52, D_ONCE=53, D_ENDONCE=54, D_PUSH=55, D_ENDPUSH=56, 
		D_PUSH_ONCE=57, D_ENDPUSH_ONCE=58, D_PROPS=59, D_CSRF=60, D_METHOD=61, 
		D_ERROR=62, D_ENDERROR=63, D_PRODUCTION=64, D_ENDPRODUCTION=65, D_ENV=66, 
		D_ENDENV=67, D_AUTH_START=68, D_AUTH_END=69, D_CLASS=70, D_STYLE=71, D_HTML_ATTR_EXPR=72, 
		D_AWARE=73, D_JSON=74, D_INJECT=75, D_DD=76, D_USE=77, D_PHP=78, D_VERBATIM=79, 
		D_ENDVERBATIM=80, D_CUSTOM=81, ESCAPED_ECHO_START=82, NE_ECHO_START=83, 
		AT=84, HTML=85, ESCAPED_ECHO_END=86, NE_ECHO_END=87, WS_EXPR=88, WS_BL_PARAM=89, 
		BL_PARAM_LINE_COMMENT=90, BL_PARAM_STRING=91, BL_PARAM_CONCAT_OPERATOR=92, 
		BL_PARAM_COMMA=93, BL_COMMA=94, BL_PARAM_WS=95, BL_NAME_STRING=96, D_ENDPHP=97, 
		BLADE_PHP_INLINE=98, ESCAPE_ECHO=99, OPEN_EXPR_PAREN_MORE=100;
	public static final int
		RULE_file = 0, RULE_general_statement = 1, RULE_inline_statement = 2, 
		RULE_block_statement = 3, RULE_non_blade_statement = 4, RULE_extends = 5, 
		RULE_section_inline = 6, RULE_section = 7, RULE_if = 8, RULE_elseif = 9, 
		RULE_else = 10, RULE_conditional_block = 11, RULE_auth_block = 12, RULE_switch = 13, 
		RULE_while = 14, RULE_for = 15, RULE_foreach = 16, RULE_forelse = 17, 
		RULE_yield = 18, RULE_include = 19, RULE_hasSection = 20, RULE_custom_directive = 21, 
		RULE_php_blade = 22, RULE_echo = 23, RULE_echo_ne = 24, RULE_php_expression = 25, 
		RULE_bl_sg_param = 26, RULE_bl_sg_default_param = 27, RULE_default_blade_param_expression = 28, 
		RULE_blade_params_expression = 29, RULE_blade_parameter = 30, RULE_verbatim_block = 31, 
		RULE_loop_action = 32, RULE_html = 33;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "general_statement", "inline_statement", "block_statement", "non_blade_statement", 
			"extends", "section_inline", "section", "if", "elseif", "else", "conditional_block", 
			"auth_block", "switch", "while", "for", "foreach", "forelse", "yield", 
			"include", "hasSection", "custom_directive", "php_blade", "echo", "echo_ne", 
			"php_expression", "bl_sg_param", "bl_sg_default_param", "default_blade_param_expression", 
			"blade_params_expression", "blade_parameter", "verbatim_block", "loop_action", 
			"html"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "'@if'", "'@elseif'", "'@else'", "'@endif'", "'@switch'", 
			"'@case'", "'@default'", "'@endswitch'", "'@empty'", "'@endempty'", null, 
			null, "'@each'", "'@foreach'", "'@endforeach'", "'@for'", "'@endfor'", 
			"'@forelse'", "'@endforelse'", "'@while'", "'@endwhile'", "'@break'", 
			null, "'@include'", "'@includeIf'", "'@includeWhen'", "'@includeFirst'", 
			"'@includeUnless'", "'@extends'", "'@js'", "'@section'", "'@hasSection'", 
			"'@sectionMissing'", "'@endsection'", "'@yield'", "'@parent'", "'@show'", 
			"'@overwrite'", "'@stop'", "'@once'", "'@endonce'", "'@push'", "'@endpush'", 
			"'@pushOnce'", "'@endPushOnce'", "'@props'", "'@csrf'", "'@method'", 
			"'@error'", "'@enderror'", "'@production'", "'@endproduction'", "'@env'", 
			"'@endenv'", null, null, "'@class'", "'@style'", null, "'@aware'", "'@json'", 
			"'@inject'", "'@dd'", "'@use'", "'@php'", "'@verbatim'", null, null, 
			"'{{'", "'{!!'", "'@'", null, null, null, null, null, null, null, "'.'", 
			null, "','", null, null, "'@endphp'", null, "'@{'", "'('"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TOKEN_REF", "RULE_REF", "LEXER_CHAR_SET", "PHP_EXPRESSION", "PHP_VARIABLE", 
			"PHP_KEYWORD", "BLADE_PARAM_EXTRA", "BLADE_PARAM_LPAREN", "BLADE_PARAM_RPAREN", 
			"BLADE_PHP_ECHO_EXPR", "ERROR", "BLADE_COMMENT", "PHP_INLINE", "D_IF", 
			"D_ELSEIF", "D_ELSE", "D_ENDIF", "D_SWITCH", "D_CASE", "D_DEFAULT", "D_ENDSWITCH", 
			"D_EMPTY", "D_ENDEMPTY", "D_COND_BLOCK_START", "D_COND_BLOCK_END", "D_EACH", 
			"D_FOREACH", "D_ENDFOREACH", "D_FOR", "D_ENDFOR", "D_FORELSE", "D_ENDFORELSE", 
			"D_WHILE", "D_ENDWHILE", "D_BREAK", "D_LOOP_ACTION", "D_INCLUDE", "D_INCLUDE_IF", 
			"D_INCLUDE_WHEN", "D_INCLUDE_FIRST", "D_INCLUDE_UNLESS", "D_EXTENDS", 
			"D_JS", "D_SECTION", "D_HAS_SECTION", "D_SECTION_MISSING", "D_ENDSECTION", 
			"D_YIELD", "D_PARENT", "D_SHOW", "D_OVERWRITE", "D_STOP", "D_ONCE", "D_ENDONCE", 
			"D_PUSH", "D_ENDPUSH", "D_PUSH_ONCE", "D_ENDPUSH_ONCE", "D_PROPS", "D_CSRF", 
			"D_METHOD", "D_ERROR", "D_ENDERROR", "D_PRODUCTION", "D_ENDPRODUCTION", 
			"D_ENV", "D_ENDENV", "D_AUTH_START", "D_AUTH_END", "D_CLASS", "D_STYLE", 
			"D_HTML_ATTR_EXPR", "D_AWARE", "D_JSON", "D_INJECT", "D_DD", "D_USE", 
			"D_PHP", "D_VERBATIM", "D_ENDVERBATIM", "D_CUSTOM", "ESCAPED_ECHO_START", 
			"NE_ECHO_START", "AT", "HTML", "ESCAPED_ECHO_END", "NE_ECHO_END", "WS_EXPR", 
			"WS_BL_PARAM", "BL_PARAM_LINE_COMMENT", "BL_PARAM_STRING", "BL_PARAM_CONCAT_OPERATOR", 
			"BL_PARAM_COMMA", "BL_COMMA", "BL_PARAM_WS", "BL_NAME_STRING", "D_ENDPHP", 
			"BLADE_PHP_INLINE", "ESCAPE_ECHO", "OPEN_EXPR_PAREN_MORE"
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
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9346100785704960L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 191517L) != 0)) {
				{
				{
				setState(68);
				general_statement();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
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
			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				inline_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				block_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				match(BLADE_COMMENT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
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
		public TerminalNode D_HTML_ATTR_EXPR() { return getToken(BladeAntlrParser.D_HTML_ATTR_EXPR, 0); }
		public TerminalNode D_CASE() { return getToken(BladeAntlrParser.D_CASE, 0); }
		public TerminalNode D_DEFAULT() { return getToken(BladeAntlrParser.D_DEFAULT, 0); }
		public Loop_actionContext loop_action() {
			return getRuleContext(Loop_actionContext.class,0);
		}
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
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_EXTENDS:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				extends_();
				}
				break;
			case D_SECTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				section_inline();
				}
				break;
			case D_YIELD:
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				yield();
				}
				break;
			case D_INCLUDE:
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
				include();
				}
				break;
			case D_CLASS:
			case D_STYLE:
				enterOuterAlt(_localctx, 5);
				{
				setState(86);
				_la = _input.LA(1);
				if ( !(_la==D_CLASS || _la==D_STYLE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(87);
				php_expression();
				}
				break;
			case D_HTML_ATTR_EXPR:
				enterOuterAlt(_localctx, 6);
				{
				setState(88);
				match(D_HTML_ATTR_EXPR);
				setState(89);
				php_expression();
				}
				break;
			case D_CASE:
				enterOuterAlt(_localctx, 7);
				{
				setState(90);
				match(D_CASE);
				setState(91);
				php_expression();
				}
				break;
			case D_DEFAULT:
				enterOuterAlt(_localctx, 8);
				{
				setState(92);
				match(D_DEFAULT);
				}
				break;
			case D_BREAK:
			case D_LOOP_ACTION:
				enterOuterAlt(_localctx, 9);
				{
				setState(93);
				loop_action();
				}
				break;
			case ESCAPED_ECHO_START:
				enterOuterAlt(_localctx, 10);
				{
				setState(94);
				echo();
				}
				break;
			case NE_ECHO_START:
				enterOuterAlt(_localctx, 11);
				{
				setState(95);
				echo_ne();
				}
				break;
			case D_CUSTOM:
				enterOuterAlt(_localctx, 12);
				{
				setState(96);
				custom_directive();
				}
				break;
			case PHP_INLINE:
				enterOuterAlt(_localctx, 13);
				{
				setState(97);
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
		public TerminalNode D_EMPTY() { return getToken(BladeAntlrParser.D_EMPTY, 0); }
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public TerminalNode D_ENDEMPTY() { return getToken(BladeAntlrParser.D_ENDEMPTY, 0); }
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
		enterRule(_localctx, 6, RULE_block_statement);
		int _la;
		try {
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SECTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				section();
				}
				break;
			case D_HAS_SECTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				hasSection();
				}
				break;
			case D_ONCE:
				enterOuterAlt(_localctx, 3);
				{
				setState(102);
				match(D_ONCE);
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(103);
					general_statement();
					}
					}
					setState(106); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 9346100785704960L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 191517L) != 0) );
				setState(108);
				match(D_ENDONCE);
				}
				break;
			case D_IF:
				enterOuterAlt(_localctx, 4);
				{
				setState(110);
				if_();
				}
				break;
			case D_ELSEIF:
				enterOuterAlt(_localctx, 5);
				{
				setState(111);
				elseif();
				}
				break;
			case D_ELSE:
				enterOuterAlt(_localctx, 6);
				{
				setState(112);
				else_();
				}
				break;
			case D_SWITCH:
				enterOuterAlt(_localctx, 7);
				{
				setState(113);
				switch_();
				}
				break;
			case D_EMPTY:
				enterOuterAlt(_localctx, 8);
				{
				setState(114);
				match(D_EMPTY);
				setState(115);
				php_expression();
				setState(117); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(116);
					general_statement();
					}
					}
					setState(119); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 9346100785704960L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 191517L) != 0) );
				setState(121);
				match(D_ENDEMPTY);
				}
				break;
			case D_COND_BLOCK_START:
				enterOuterAlt(_localctx, 9);
				{
				setState(123);
				conditional_block();
				}
				break;
			case D_AUTH_START:
				enterOuterAlt(_localctx, 10);
				{
				setState(124);
				auth_block();
				}
				break;
			case D_WHILE:
				enterOuterAlt(_localctx, 11);
				{
				setState(125);
				while_();
				}
				break;
			case D_FOR:
				enterOuterAlt(_localctx, 12);
				{
				setState(126);
				for_();
				}
				break;
			case D_FOREACH:
				enterOuterAlt(_localctx, 13);
				{
				setState(127);
				foreach();
				}
				break;
			case D_FORELSE:
				enterOuterAlt(_localctx, 14);
				{
				setState(128);
				forelse();
				}
				break;
			case D_VERBATIM:
				enterOuterAlt(_localctx, 15);
				{
				setState(129);
				verbatim_block();
				}
				break;
			case D_PHP:
				enterOuterAlt(_localctx, 16);
				{
				setState(130);
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
			setState(133);
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
			setState(135);
			match(D_EXTENDS);
			setState(136);
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
			setState(138);
			match(D_SECTION);
			setState(139);
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
			setState(141);
			match(D_SECTION);
			setState(142);
			bl_sg_default_param();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9346100785704960L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 191517L) != 0)) {
				{
				{
				setState(143);
				general_statement();
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(149);
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
			setState(151);
			match(D_IF);
			setState(152);
			php_expression();
			setState(156);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(153);
					general_statement();
					}
					} 
				}
				setState(158);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(159);
				match(D_ENDIF);
				}
				break;
			}
			setState(162);
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
			setState(164);
			match(D_ELSEIF);
			setState(165);
			php_expression();
			setState(169);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(166);
					general_statement();
					}
					} 
				}
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(172);
				match(D_ENDIF);
				}
				break;
			}
			setState(175);
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
			setState(177);
			match(D_ELSE);
			setState(181);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(178);
					general_statement();
					}
					} 
				}
				setState(183);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(184);
				match(D_ENDIF);
				}
				break;
			}
			setState(187);
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
		enterRule(_localctx, 22, RULE_conditional_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(D_COND_BLOCK_START);
			setState(190);
			php_expression();
			setState(192); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(191);
				general_statement();
				}
				}
				setState(194); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 9346100785704960L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 191517L) != 0) );
			setState(196);
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
		public Bl_sg_paramContext bl_sg_param() {
			return getRuleContext(Bl_sg_paramContext.class,0);
		}
		public TerminalNode D_AUTH_END() { return getToken(BladeAntlrParser.D_AUTH_END, 0); }
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
		enterRule(_localctx, 24, RULE_auth_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(D_AUTH_START);
			setState(199);
			bl_sg_param();
			setState(201); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(200);
				general_statement();
				}
				}
				setState(203); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 9346100785704960L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 191517L) != 0) );
			setState(205);
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
		enterRule(_localctx, 26, RULE_switch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(D_SWITCH);
			setState(208);
			php_expression();
			setState(211); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(211);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(209);
					general_statement();
					}
					break;
				case 2:
					{
					setState(210);
					match(D_BREAK);
					}
					break;
				}
				}
				setState(213); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 9346100785704960L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 191517L) != 0) );
			setState(215);
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
		enterRule(_localctx, 28, RULE_while);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(D_WHILE);
			setState(218);
			php_expression();
			setState(220); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(219);
				general_statement();
				}
				}
				setState(222); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 9346100785704960L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 191517L) != 0) );
			setState(224);
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
		enterRule(_localctx, 30, RULE_for);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(D_FOR);
			setState(227);
			php_expression();
			setState(229); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(228);
				general_statement();
				}
				}
				setState(231); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 9346100785704960L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 191517L) != 0) );
			setState(233);
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
		enterRule(_localctx, 32, RULE_foreach);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(D_FOREACH);
			setState(236);
			php_expression();
			setState(238); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(237);
				general_statement();
				}
				}
				setState(240); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 9346100785704960L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 191517L) != 0) );
			setState(242);
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
		enterRule(_localctx, 34, RULE_forelse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(D_FORELSE);
			setState(245);
			php_expression();
			setState(248); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(248);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(246);
					general_statement();
					}
					break;
				case 2:
					{
					setState(247);
					match(D_EMPTY);
					}
					break;
				}
				}
				setState(250); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 9346100785704960L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 191517L) != 0) );
			setState(252);
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
		enterRule(_localctx, 36, RULE_yield);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(D_YIELD);
			setState(255);
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
		enterRule(_localctx, 38, RULE_include);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(D_INCLUDE);
			setState(258);
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
		enterRule(_localctx, 40, RULE_hasSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(D_HAS_SECTION);
			setState(261);
			bl_sg_param();
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9346100785704960L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 191517L) != 0)) {
				{
				{
				setState(262);
				general_statement();
				}
				}
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(268);
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
		enterRule(_localctx, 42, RULE_custom_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(D_CUSTOM);
			setState(271);
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
		enterRule(_localctx, 44, RULE_php_blade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(D_PHP);
			setState(274);
			match(BLADE_PHP_INLINE);
			setState(275);
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
		enterRule(_localctx, 46, RULE_echo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(ESCAPED_ECHO_START);
			setState(278);
			match(BLADE_PHP_ECHO_EXPR);
			setState(279);
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
		enterRule(_localctx, 48, RULE_echo_ne);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(NE_ECHO_START);
			setState(282);
			match(BLADE_PHP_ECHO_EXPR);
			setState(283);
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
		enterRule(_localctx, 50, RULE_php_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS_EXPR) {
				{
				setState(285);
				match(WS_EXPR);
				}
			}

			setState(288);
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
		enterRule(_localctx, 52, RULE_bl_sg_param);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(BLADE_PARAM_LPAREN);
			setState(294);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(291);
					match(BL_PARAM_WS);
					}
					} 
				}
				setState(296);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			setState(297);
			blade_parameter();
			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_PARAM_WS) {
				{
				{
				setState(298);
				match(BL_PARAM_WS);
				}
				}
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(304);
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
		enterRule(_localctx, 54, RULE_bl_sg_default_param);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(BLADE_PARAM_LPAREN);
			setState(310);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(307);
					match(BL_PARAM_WS);
					}
					} 
				}
				setState(312);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			setState(313);
			blade_parameter();
			setState(315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(314);
				default_blade_param_expression();
				}
				break;
			}
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_PARAM_WS) {
				{
				{
				setState(317);
				match(BL_PARAM_WS);
				}
				}
				setState(322);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(323);
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
		enterRule(_localctx, 56, RULE_default_blade_param_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_PARAM_WS) {
				{
				{
				setState(325);
				match(BL_PARAM_WS);
				}
				}
				setState(330);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(331);
			match(BL_PARAM_COMMA);
			setState(335);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(332);
					match(BL_PARAM_WS);
					}
					} 
				}
				setState(337);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			setState(338);
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
		enterRule(_localctx, 58, RULE_blade_params_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(BLADE_PARAM_LPAREN);
			setState(344);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(341);
					match(BL_PARAM_WS);
					}
					} 
				}
				setState(346);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			setState(363); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(347);
					blade_parameter();
					setState(351);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(348);
							match(BL_PARAM_WS);
							}
							} 
						}
						setState(353);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
					}
					setState(355);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==BL_PARAM_COMMA) {
						{
						setState(354);
						match(BL_PARAM_COMMA);
						}
					}

					setState(360);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(357);
							match(BL_PARAM_WS);
							}
							} 
						}
						setState(362);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(365); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_PARAM_WS) {
				{
				{
				setState(367);
				match(BL_PARAM_WS);
				}
				}
				setState(372);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class Blade_parameterContext extends ParserRuleContext {
		public List<TerminalNode> BL_PARAM_STRING() { return getTokens(BladeAntlrParser.BL_PARAM_STRING); }
		public TerminalNode BL_PARAM_STRING(int i) {
			return getToken(BladeAntlrParser.BL_PARAM_STRING, i);
		}
		public List<TerminalNode> BLADE_PARAM_EXTRA() { return getTokens(BladeAntlrParser.BLADE_PARAM_EXTRA); }
		public TerminalNode BLADE_PARAM_EXTRA(int i) {
			return getToken(BladeAntlrParser.BLADE_PARAM_EXTRA, i);
		}
		public List<TerminalNode> PHP_VARIABLE() { return getTokens(BladeAntlrParser.PHP_VARIABLE); }
		public TerminalNode PHP_VARIABLE(int i) {
			return getToken(BladeAntlrParser.PHP_VARIABLE, i);
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
		enterRule(_localctx, 60, RULE_blade_parameter);
		int _la;
		try {
			int _alt;
			setState(381);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(375);
				match(BL_PARAM_STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(377); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(376);
						_la = _input.LA(1);
						if ( !(_la==PHP_VARIABLE || _la==BLADE_PARAM_EXTRA || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 59L) != 0)) ) {
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
					setState(379); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
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
		enterRule(_localctx, 62, RULE_verbatim_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			match(D_VERBATIM);
			setState(385); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(384);
				non_blade_statement();
				}
				}
				setState(387); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==HTML );
			setState(389);
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
		enterRule(_localctx, 64, RULE_loop_action);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			_la = _input.LA(1);
			if ( !(_la==D_BREAK || _la==D_LOOP_ACTION) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(393);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				setState(392);
				php_expression();
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
		enterRule(_localctx, 66, RULE_html);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(396); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(395);
					match(HTML);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(398); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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
		"\u0004\u0001d\u0191\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0001\u0000\u0005"+
		"\u0000F\b\u0000\n\u0000\f\u0000I\t\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001Q\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002c\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003i\b\u0003\u000b"+
		"\u0003\f\u0003j\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003v\b"+
		"\u0003\u000b\u0003\f\u0003w\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003\u0084\b\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007\u0091\b\u0007\n\u0007\f\u0007\u0094\t\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005\b\u009b\b\b\n\b"+
		"\f\b\u009e\t\b\u0001\b\u0003\b\u00a1\b\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0005\t\u00a8\b\t\n\t\f\t\u00ab\t\t\u0001\t\u0003\t\u00ae\b"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0005\n\u00b4\b\n\n\n\f\n\u00b7\t\n"+
		"\u0001\n\u0003\n\u00ba\b\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0004\u000b\u00c1\b\u000b\u000b\u000b\f\u000b\u00c2\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0004\f\u00ca\b\f\u000b\f\f\f\u00cb"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0004\r\u00d4\b\r\u000b"+
		"\r\f\r\u00d5\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0004"+
		"\u000e\u00dd\b\u000e\u000b\u000e\f\u000e\u00de\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0004\u000f\u00e6\b\u000f\u000b\u000f"+
		"\f\u000f\u00e7\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0004\u0010\u00ef\b\u0010\u000b\u0010\f\u0010\u00f0\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0004\u0011\u00f9"+
		"\b\u0011\u000b\u0011\f\u0011\u00fa\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0005\u0014\u0108\b\u0014\n\u0014\f\u0014\u010b"+
		"\t\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0003\u0019\u011f\b\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0005\u001a\u0125\b\u001a\n\u001a\f\u001a\u0128\t\u001a\u0001\u001a"+
		"\u0001\u001a\u0005\u001a\u012c\b\u001a\n\u001a\f\u001a\u012f\t\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0005\u001b\u0135\b\u001b\n"+
		"\u001b\f\u001b\u0138\t\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u013c"+
		"\b\u001b\u0001\u001b\u0005\u001b\u013f\b\u001b\n\u001b\f\u001b\u0142\t"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0005\u001c\u0147\b\u001c\n"+
		"\u001c\f\u001c\u014a\t\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u014e"+
		"\b\u001c\n\u001c\f\u001c\u0151\t\u001c\u0001\u001c\u0001\u001c\u0001\u001d"+
		"\u0001\u001d\u0005\u001d\u0157\b\u001d\n\u001d\f\u001d\u015a\t\u001d\u0001"+
		"\u001d\u0001\u001d\u0005\u001d\u015e\b\u001d\n\u001d\f\u001d\u0161\t\u001d"+
		"\u0001\u001d\u0003\u001d\u0164\b\u001d\u0001\u001d\u0005\u001d\u0167\b"+
		"\u001d\n\u001d\f\u001d\u016a\t\u001d\u0004\u001d\u016c\b\u001d\u000b\u001d"+
		"\f\u001d\u016d\u0001\u001d\u0005\u001d\u0171\b\u001d\n\u001d\f\u001d\u0174"+
		"\t\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0004\u001e\u017a"+
		"\b\u001e\u000b\u001e\f\u001e\u017b\u0003\u001e\u017e\b\u001e\u0001\u001f"+
		"\u0001\u001f\u0004\u001f\u0182\b\u001f\u000b\u001f\f\u001f\u0183\u0001"+
		"\u001f\u0001\u001f\u0001 \u0001 \u0003 \u018a\b \u0001!\u0004!\u018d\b"+
		"!\u000b!\f!\u018e\u0001!\u0000\u0000\"\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@B\u0000"+
		"\u0004\u0001\u0000FG\u0001\u0000\u000e\u0010\u0004\u0000\u0005\u0005\u0007"+
		"\u0007[\\^`\u0001\u0000#$\u01b3\u0000G\u0001\u0000\u0000\u0000\u0002P"+
		"\u0001\u0000\u0000\u0000\u0004b\u0001\u0000\u0000\u0000\u0006\u0083\u0001"+
		"\u0000\u0000\u0000\b\u0085\u0001\u0000\u0000\u0000\n\u0087\u0001\u0000"+
		"\u0000\u0000\f\u008a\u0001\u0000\u0000\u0000\u000e\u008d\u0001\u0000\u0000"+
		"\u0000\u0010\u0097\u0001\u0000\u0000\u0000\u0012\u00a4\u0001\u0000\u0000"+
		"\u0000\u0014\u00b1\u0001\u0000\u0000\u0000\u0016\u00bd\u0001\u0000\u0000"+
		"\u0000\u0018\u00c6\u0001\u0000\u0000\u0000\u001a\u00cf\u0001\u0000\u0000"+
		"\u0000\u001c\u00d9\u0001\u0000\u0000\u0000\u001e\u00e2\u0001\u0000\u0000"+
		"\u0000 \u00eb\u0001\u0000\u0000\u0000\"\u00f4\u0001\u0000\u0000\u0000"+
		"$\u00fe\u0001\u0000\u0000\u0000&\u0101\u0001\u0000\u0000\u0000(\u0104"+
		"\u0001\u0000\u0000\u0000*\u010e\u0001\u0000\u0000\u0000,\u0111\u0001\u0000"+
		"\u0000\u0000.\u0115\u0001\u0000\u0000\u00000\u0119\u0001\u0000\u0000\u0000"+
		"2\u011e\u0001\u0000\u0000\u00004\u0122\u0001\u0000\u0000\u00006\u0132"+
		"\u0001\u0000\u0000\u00008\u0148\u0001\u0000\u0000\u0000:\u0154\u0001\u0000"+
		"\u0000\u0000<\u017d\u0001\u0000\u0000\u0000>\u017f\u0001\u0000\u0000\u0000"+
		"@\u0187\u0001\u0000\u0000\u0000B\u018c\u0001\u0000\u0000\u0000DF\u0003"+
		"\u0002\u0001\u0000ED\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000\u0000"+
		"GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HJ\u0001\u0000\u0000"+
		"\u0000IG\u0001\u0000\u0000\u0000JK\u0005\u0000\u0000\u0001K\u0001\u0001"+
		"\u0000\u0000\u0000LQ\u0003\u0004\u0002\u0000MQ\u0003\u0006\u0003\u0000"+
		"NQ\u0005\f\u0000\u0000OQ\u0003B!\u0000PL\u0001\u0000\u0000\u0000PM\u0001"+
		"\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PO\u0001\u0000\u0000\u0000"+
		"Q\u0003\u0001\u0000\u0000\u0000Rc\u0003\n\u0005\u0000Sc\u0003\f\u0006"+
		"\u0000Tc\u0003$\u0012\u0000Uc\u0003&\u0013\u0000VW\u0007\u0000\u0000\u0000"+
		"Wc\u00032\u0019\u0000XY\u0005H\u0000\u0000Yc\u00032\u0019\u0000Z[\u0005"+
		"\u0013\u0000\u0000[c\u00032\u0019\u0000\\c\u0005\u0014\u0000\u0000]c\u0003"+
		"@ \u0000^c\u0003.\u0017\u0000_c\u00030\u0018\u0000`c\u0003*\u0015\u0000"+
		"ac\u0005\r\u0000\u0000bR\u0001\u0000\u0000\u0000bS\u0001\u0000\u0000\u0000"+
		"bT\u0001\u0000\u0000\u0000bU\u0001\u0000\u0000\u0000bV\u0001\u0000\u0000"+
		"\u0000bX\u0001\u0000\u0000\u0000bZ\u0001\u0000\u0000\u0000b\\\u0001\u0000"+
		"\u0000\u0000b]\u0001\u0000\u0000\u0000b^\u0001\u0000\u0000\u0000b_\u0001"+
		"\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000ba\u0001\u0000\u0000\u0000"+
		"c\u0005\u0001\u0000\u0000\u0000d\u0084\u0003\u000e\u0007\u0000e\u0084"+
		"\u0003(\u0014\u0000fh\u00055\u0000\u0000gi\u0003\u0002\u0001\u0000hg\u0001"+
		"\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000"+
		"jk\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u00056\u0000\u0000"+
		"m\u0084\u0001\u0000\u0000\u0000n\u0084\u0003\u0010\b\u0000o\u0084\u0003"+
		"\u0012\t\u0000p\u0084\u0003\u0014\n\u0000q\u0084\u0003\u001a\r\u0000r"+
		"s\u0005\u0016\u0000\u0000su\u00032\u0019\u0000tv\u0003\u0002\u0001\u0000"+
		"ut\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000"+
		"\u0000wx\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0005\u0017"+
		"\u0000\u0000z\u0084\u0001\u0000\u0000\u0000{\u0084\u0003\u0016\u000b\u0000"+
		"|\u0084\u0003\u0018\f\u0000}\u0084\u0003\u001c\u000e\u0000~\u0084\u0003"+
		"\u001e\u000f\u0000\u007f\u0084\u0003 \u0010\u0000\u0080\u0084\u0003\""+
		"\u0011\u0000\u0081\u0084\u0003>\u001f\u0000\u0082\u0084\u0003,\u0016\u0000"+
		"\u0083d\u0001\u0000\u0000\u0000\u0083e\u0001\u0000\u0000\u0000\u0083f"+
		"\u0001\u0000\u0000\u0000\u0083n\u0001\u0000\u0000\u0000\u0083o\u0001\u0000"+
		"\u0000\u0000\u0083p\u0001\u0000\u0000\u0000\u0083q\u0001\u0000\u0000\u0000"+
		"\u0083r\u0001\u0000\u0000\u0000\u0083{\u0001\u0000\u0000\u0000\u0083|"+
		"\u0001\u0000\u0000\u0000\u0083}\u0001\u0000\u0000\u0000\u0083~\u0001\u0000"+
		"\u0000\u0000\u0083\u007f\u0001\u0000\u0000\u0000\u0083\u0080\u0001\u0000"+
		"\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0082\u0001\u0000"+
		"\u0000\u0000\u0084\u0007\u0001\u0000\u0000\u0000\u0085\u0086\u0003B!\u0000"+
		"\u0086\t\u0001\u0000\u0000\u0000\u0087\u0088\u0005*\u0000\u0000\u0088"+
		"\u0089\u0003:\u001d\u0000\u0089\u000b\u0001\u0000\u0000\u0000\u008a\u008b"+
		"\u0005,\u0000\u0000\u008b\u008c\u00036\u001b\u0000\u008c\r\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0005,\u0000\u0000\u008e\u0092\u00036\u001b\u0000"+
		"\u008f\u0091\u0003\u0002\u0001\u0000\u0090\u008f\u0001\u0000\u0000\u0000"+
		"\u0091\u0094\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000"+
		"\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0095\u0001\u0000\u0000\u0000"+
		"\u0094\u0092\u0001\u0000\u0000\u0000\u0095\u0096\u0005/\u0000\u0000\u0096"+
		"\u000f\u0001\u0000\u0000\u0000\u0097\u0098\u0005\u000e\u0000\u0000\u0098"+
		"\u009c\u00032\u0019\u0000\u0099\u009b\u0003\u0002\u0001\u0000\u009a\u0099"+
		"\u0001\u0000\u0000\u0000\u009b\u009e\u0001\u0000\u0000\u0000\u009c\u009a"+
		"\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u00a0"+
		"\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009f\u00a1"+
		"\u0005\u0011\u0000\u0000\u00a0\u009f\u0001\u0000\u0000\u0000\u00a0\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a3"+
		"\b\u0001\u0000\u0000\u00a3\u0011\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005"+
		"\u000f\u0000\u0000\u00a5\u00a9\u00032\u0019\u0000\u00a6\u00a8\u0003\u0002"+
		"\u0001\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a8\u00ab\u0001\u0000"+
		"\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ad\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000"+
		"\u0000\u0000\u00ac\u00ae\u0005\u0011\u0000\u0000\u00ad\u00ac\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000"+
		"\u0000\u0000\u00af\u00b0\b\u0001\u0000\u0000\u00b0\u0013\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b5\u0005\u0010\u0000\u0000\u00b2\u00b4\u0003\u0002\u0001"+
		"\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000"+
		"\u0000\u00b8\u00ba\u0005\u0011\u0000\u0000\u00b9\u00b8\u0001\u0000\u0000"+
		"\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000"+
		"\u0000\u00bb\u00bc\b\u0001\u0000\u0000\u00bc\u0015\u0001\u0000\u0000\u0000"+
		"\u00bd\u00be\u0005\u0018\u0000\u0000\u00be\u00c0\u00032\u0019\u0000\u00bf"+
		"\u00c1\u0003\u0002\u0001\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c5\u0005\u0019\u0000\u0000\u00c5\u0017\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c7\u0005D\u0000\u0000\u00c7\u00c9\u00034\u001a\u0000\u00c8\u00ca\u0003"+
		"\u0002\u0001\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001"+
		"\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001"+
		"\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005"+
		"E\u0000\u0000\u00ce\u0019\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005\u0012"+
		"\u0000\u0000\u00d0\u00d3\u00032\u0019\u0000\u00d1\u00d4\u0003\u0002\u0001"+
		"\u0000\u00d2\u00d4\u0005#\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000"+
		"\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000"+
		"\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000"+
		"\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u00d8\u0005\u0015\u0000\u0000"+
		"\u00d8\u001b\u0001\u0000\u0000\u0000\u00d9\u00da\u0005!\u0000\u0000\u00da"+
		"\u00dc\u00032\u0019\u0000\u00db\u00dd\u0003\u0002\u0001\u0000\u00dc\u00db"+
		"\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000\u0000\u00de\u00dc"+
		"\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000\u0000\u00df\u00e0"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005\"\u0000\u0000\u00e1\u001d\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e3\u0005\u001d\u0000\u0000\u00e3\u00e5\u0003"+
		"2\u0019\u0000\u00e4\u00e6\u0003\u0002\u0001\u0000\u00e5\u00e4\u0001\u0000"+
		"\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001\u0000"+
		"\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000"+
		"\u0000\u0000\u00e9\u00ea\u0005\u001e\u0000\u0000\u00ea\u001f\u0001\u0000"+
		"\u0000\u0000\u00eb\u00ec\u0005\u001b\u0000\u0000\u00ec\u00ee\u00032\u0019"+
		"\u0000\u00ed\u00ef\u0003\u0002\u0001\u0000\u00ee\u00ed\u0001\u0000\u0000"+
		"\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u00ee\u0001\u0000\u0000"+
		"\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000\u0000"+
		"\u0000\u00f2\u00f3\u0005\u001c\u0000\u0000\u00f3!\u0001\u0000\u0000\u0000"+
		"\u00f4\u00f5\u0005\u001f\u0000\u0000\u00f5\u00f8\u00032\u0019\u0000\u00f6"+
		"\u00f9\u0003\u0002\u0001\u0000\u00f7\u00f9\u0005\u0016\u0000\u0000\u00f8"+
		"\u00f6\u0001\u0000\u0000\u0000\u00f8\u00f7\u0001\u0000\u0000\u0000\u00f9"+
		"\u00fa\u0001\u0000\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fa"+
		"\u00fb\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc"+
		"\u00fd\u0005 \u0000\u0000\u00fd#\u0001\u0000\u0000\u0000\u00fe\u00ff\u0005"+
		"0\u0000\u0000\u00ff\u0100\u00036\u001b\u0000\u0100%\u0001\u0000\u0000"+
		"\u0000\u0101\u0102\u0005%\u0000\u0000\u0102\u0103\u0003:\u001d\u0000\u0103"+
		"\'\u0001\u0000\u0000\u0000\u0104\u0105\u0005-\u0000\u0000\u0105\u0109"+
		"\u00034\u001a\u0000\u0106\u0108\u0003\u0002\u0001\u0000\u0107\u0106\u0001"+
		"\u0000\u0000\u0000\u0108\u010b\u0001\u0000\u0000\u0000\u0109\u0107\u0001"+
		"\u0000\u0000\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a\u010c\u0001"+
		"\u0000\u0000\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010c\u010d\u0005"+
		"\u0011\u0000\u0000\u010d)\u0001\u0000\u0000\u0000\u010e\u010f\u0005Q\u0000"+
		"\u0000\u010f\u0110\u0003:\u001d\u0000\u0110+\u0001\u0000\u0000\u0000\u0111"+
		"\u0112\u0005N\u0000\u0000\u0112\u0113\u0005b\u0000\u0000\u0113\u0114\u0005"+
		"a\u0000\u0000\u0114-\u0001\u0000\u0000\u0000\u0115\u0116\u0005R\u0000"+
		"\u0000\u0116\u0117\u0005\n\u0000\u0000\u0117\u0118\u0005V\u0000\u0000"+
		"\u0118/\u0001\u0000\u0000\u0000\u0119\u011a\u0005S\u0000\u0000\u011a\u011b"+
		"\u0005\n\u0000\u0000\u011b\u011c\u0005W\u0000\u0000\u011c1\u0001\u0000"+
		"\u0000\u0000\u011d\u011f\u0005X\u0000\u0000\u011e\u011d\u0001\u0000\u0000"+
		"\u0000\u011e\u011f\u0001\u0000\u0000\u0000\u011f\u0120\u0001\u0000\u0000"+
		"\u0000\u0120\u0121\u0005\u0004\u0000\u0000\u01213\u0001\u0000\u0000\u0000"+
		"\u0122\u0126\u0005\b\u0000\u0000\u0123\u0125\u0005_\u0000\u0000\u0124"+
		"\u0123\u0001\u0000\u0000\u0000\u0125\u0128\u0001\u0000\u0000\u0000\u0126"+
		"\u0124\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127"+
		"\u0129\u0001\u0000\u0000\u0000\u0128\u0126\u0001\u0000\u0000\u0000\u0129"+
		"\u012d\u0003<\u001e\u0000\u012a\u012c\u0005_\u0000\u0000\u012b\u012a\u0001"+
		"\u0000\u0000\u0000\u012c\u012f\u0001\u0000\u0000\u0000\u012d\u012b\u0001"+
		"\u0000\u0000\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e\u0130\u0001"+
		"\u0000\u0000\u0000\u012f\u012d\u0001\u0000\u0000\u0000\u0130\u0131\u0005"+
		"\t\u0000\u0000\u01315\u0001\u0000\u0000\u0000\u0132\u0136\u0005\b\u0000"+
		"\u0000\u0133\u0135\u0005_\u0000\u0000\u0134\u0133\u0001\u0000\u0000\u0000"+
		"\u0135\u0138\u0001\u0000\u0000\u0000\u0136\u0134\u0001\u0000\u0000\u0000"+
		"\u0136\u0137\u0001\u0000\u0000\u0000\u0137\u0139\u0001\u0000\u0000\u0000"+
		"\u0138\u0136\u0001\u0000\u0000\u0000\u0139\u013b\u0003<\u001e\u0000\u013a"+
		"\u013c\u00038\u001c\u0000\u013b\u013a\u0001\u0000\u0000\u0000\u013b\u013c"+
		"\u0001\u0000\u0000\u0000\u013c\u0140\u0001\u0000\u0000\u0000\u013d\u013f"+
		"\u0005_\u0000\u0000\u013e\u013d\u0001\u0000\u0000\u0000\u013f\u0142\u0001"+
		"\u0000\u0000\u0000\u0140\u013e\u0001\u0000\u0000\u0000\u0140\u0141\u0001"+
		"\u0000\u0000\u0000\u0141\u0143\u0001\u0000\u0000\u0000\u0142\u0140\u0001"+
		"\u0000\u0000\u0000\u0143\u0144\u0005\t\u0000\u0000\u01447\u0001\u0000"+
		"\u0000\u0000\u0145\u0147\u0005_\u0000\u0000\u0146\u0145\u0001\u0000\u0000"+
		"\u0000\u0147\u014a\u0001\u0000\u0000\u0000\u0148\u0146\u0001\u0000\u0000"+
		"\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u014b\u0001\u0000\u0000"+
		"\u0000\u014a\u0148\u0001\u0000\u0000\u0000\u014b\u014f\u0005]\u0000\u0000"+
		"\u014c\u014e\u0005_\u0000\u0000\u014d\u014c\u0001\u0000\u0000\u0000\u014e"+
		"\u0151\u0001\u0000\u0000\u0000\u014f\u014d\u0001\u0000\u0000\u0000\u014f"+
		"\u0150\u0001\u0000\u0000\u0000\u0150\u0152\u0001\u0000\u0000\u0000\u0151"+
		"\u014f\u0001\u0000\u0000\u0000\u0152\u0153\u0003<\u001e\u0000\u01539\u0001"+
		"\u0000\u0000\u0000\u0154\u0158\u0005\b\u0000\u0000\u0155\u0157\u0005_"+
		"\u0000\u0000\u0156\u0155\u0001\u0000\u0000\u0000\u0157\u015a\u0001\u0000"+
		"\u0000\u0000\u0158\u0156\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000"+
		"\u0000\u0000\u0159\u016b\u0001\u0000\u0000\u0000\u015a\u0158\u0001\u0000"+
		"\u0000\u0000\u015b\u015f\u0003<\u001e\u0000\u015c\u015e\u0005_\u0000\u0000"+
		"\u015d\u015c\u0001\u0000\u0000\u0000\u015e\u0161\u0001\u0000\u0000\u0000"+
		"\u015f\u015d\u0001\u0000\u0000\u0000\u015f\u0160\u0001\u0000\u0000\u0000"+
		"\u0160\u0163\u0001\u0000\u0000\u0000\u0161\u015f\u0001\u0000\u0000\u0000"+
		"\u0162\u0164\u0005]\u0000\u0000\u0163\u0162\u0001\u0000\u0000\u0000\u0163"+
		"\u0164\u0001\u0000\u0000\u0000\u0164\u0168\u0001\u0000\u0000\u0000\u0165"+
		"\u0167\u0005_\u0000\u0000\u0166\u0165\u0001\u0000\u0000\u0000\u0167\u016a"+
		"\u0001\u0000\u0000\u0000\u0168\u0166\u0001\u0000\u0000\u0000\u0168\u0169"+
		"\u0001\u0000\u0000\u0000\u0169\u016c\u0001\u0000\u0000\u0000\u016a\u0168"+
		"\u0001\u0000\u0000\u0000\u016b\u015b\u0001\u0000\u0000\u0000\u016c\u016d"+
		"\u0001\u0000\u0000\u0000\u016d\u016b\u0001\u0000\u0000\u0000\u016d\u016e"+
		"\u0001\u0000\u0000\u0000\u016e\u0172\u0001\u0000\u0000\u0000\u016f\u0171"+
		"\u0005_\u0000\u0000\u0170\u016f\u0001\u0000\u0000\u0000\u0171\u0174\u0001"+
		"\u0000\u0000\u0000\u0172\u0170\u0001\u0000\u0000\u0000\u0172\u0173\u0001"+
		"\u0000\u0000\u0000\u0173\u0175\u0001\u0000\u0000\u0000\u0174\u0172\u0001"+
		"\u0000\u0000\u0000\u0175\u0176\u0005\t\u0000\u0000\u0176;\u0001\u0000"+
		"\u0000\u0000\u0177\u017e\u0005[\u0000\u0000\u0178\u017a\u0007\u0002\u0000"+
		"\u0000\u0179\u0178\u0001\u0000\u0000\u0000\u017a\u017b\u0001\u0000\u0000"+
		"\u0000\u017b\u0179\u0001\u0000\u0000\u0000\u017b\u017c\u0001\u0000\u0000"+
		"\u0000\u017c\u017e\u0001\u0000\u0000\u0000\u017d\u0177\u0001\u0000\u0000"+
		"\u0000\u017d\u0179\u0001\u0000\u0000\u0000\u017e=\u0001\u0000\u0000\u0000"+
		"\u017f\u0181\u0005O\u0000\u0000\u0180\u0182\u0003\b\u0004\u0000\u0181"+
		"\u0180\u0001\u0000\u0000\u0000\u0182\u0183\u0001\u0000\u0000\u0000\u0183"+
		"\u0181\u0001\u0000\u0000\u0000\u0183\u0184\u0001\u0000\u0000\u0000\u0184"+
		"\u0185\u0001\u0000\u0000\u0000\u0185\u0186\u0005P\u0000\u0000\u0186?\u0001"+
		"\u0000\u0000\u0000\u0187\u0189\u0007\u0003\u0000\u0000\u0188\u018a\u0003"+
		"2\u0019\u0000\u0189\u0188\u0001\u0000\u0000\u0000\u0189\u018a\u0001\u0000"+
		"\u0000\u0000\u018aA\u0001\u0000\u0000\u0000\u018b\u018d\u0005U\u0000\u0000"+
		"\u018c\u018b\u0001\u0000\u0000\u0000\u018d\u018e\u0001\u0000\u0000\u0000"+
		"\u018e\u018c\u0001\u0000\u0000\u0000\u018e\u018f\u0001\u0000\u0000\u0000"+
		"\u018fC\u0001\u0000\u0000\u0000*GPbjw\u0083\u0092\u009c\u00a0\u00a9\u00ad"+
		"\u00b5\u00b9\u00c2\u00cb\u00d3\u00d5\u00de\u00e7\u00f0\u00f8\u00fa\u0109"+
		"\u011e\u0126\u012d\u0136\u013b\u0140\u0148\u014f\u0158\u015f\u0163\u0168"+
		"\u016d\u0172\u017b\u017d\u0183\u0189\u018e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}