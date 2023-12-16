// Generated from BladeAntlrCompilerParser.g4 by ANTLR 4.13.0

  /**
   * Parser generated for netbeans blade editor
   * Some elements have been simplified to optimize parser speed
   * For example
   * - switch statement have a loos validation
   * - generic block statement "@isset" | "@unless" are grouped togehter
   * - the start match and end match will be checked in the parser
   */
  package org.netbeans.modules.php.blade.syntax.antlr4.v10.compiler;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BladeAntlrCompilerParser}.
 */
public interface BladeAntlrCompilerParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(BladeAntlrCompilerParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(BladeAntlrCompilerParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#general_statement}.
	 * @param ctx the parse tree
	 */
	void enterGeneral_statement(BladeAntlrCompilerParser.General_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#general_statement}.
	 * @param ctx the parse tree
	 */
	void exitGeneral_statement(BladeAntlrCompilerParser.General_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#inline_statement}.
	 * @param ctx the parse tree
	 */
	void enterInline_statement(BladeAntlrCompilerParser.Inline_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#inline_statement}.
	 * @param ctx the parse tree
	 */
	void exitInline_statement(BladeAntlrCompilerParser.Inline_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#inline_directive}.
	 * @param ctx the parse tree
	 */
	void enterInline_directive(BladeAntlrCompilerParser.Inline_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#inline_directive}.
	 * @param ctx the parse tree
	 */
	void exitInline_directive(BladeAntlrCompilerParser.Inline_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void enterBlock_statement(BladeAntlrCompilerParser.Block_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void exitBlock_statement(BladeAntlrCompilerParser.Block_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#non_blade_statement}.
	 * @param ctx the parse tree
	 */
	void enterNon_blade_statement(BladeAntlrCompilerParser.Non_blade_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#non_blade_statement}.
	 * @param ctx the parse tree
	 */
	void exitNon_blade_statement(BladeAntlrCompilerParser.Non_blade_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#extends}.
	 * @param ctx the parse tree
	 */
	void enterExtends(BladeAntlrCompilerParser.ExtendsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#extends}.
	 * @param ctx the parse tree
	 */
	void exitExtends(BladeAntlrCompilerParser.ExtendsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#section_inline}.
	 * @param ctx the parse tree
	 */
	void enterSection_inline(BladeAntlrCompilerParser.Section_inlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#section_inline}.
	 * @param ctx the parse tree
	 */
	void exitSection_inline(BladeAntlrCompilerParser.Section_inlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(BladeAntlrCompilerParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(BladeAntlrCompilerParser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#push}.
	 * @param ctx the parse tree
	 */
	void enterPush(BladeAntlrCompilerParser.PushContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#push}.
	 * @param ctx the parse tree
	 */
	void exitPush(BladeAntlrCompilerParser.PushContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#pushOnce}.
	 * @param ctx the parse tree
	 */
	void enterPushOnce(BladeAntlrCompilerParser.PushOnceContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#pushOnce}.
	 * @param ctx the parse tree
	 */
	void exitPushOnce(BladeAntlrCompilerParser.PushOnceContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#if}.
	 * @param ctx the parse tree
	 */
	void enterIf(BladeAntlrCompilerParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#if}.
	 * @param ctx the parse tree
	 */
	void exitIf(BladeAntlrCompilerParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#elseif}.
	 * @param ctx the parse tree
	 */
	void enterElseif(BladeAntlrCompilerParser.ElseifContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#elseif}.
	 * @param ctx the parse tree
	 */
	void exitElseif(BladeAntlrCompilerParser.ElseifContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#else}.
	 * @param ctx the parse tree
	 */
	void enterElse(BladeAntlrCompilerParser.ElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#else}.
	 * @param ctx the parse tree
	 */
	void exitElse(BladeAntlrCompilerParser.ElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#endif}.
	 * @param ctx the parse tree
	 */
	void enterEndif(BladeAntlrCompilerParser.EndifContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#endif}.
	 * @param ctx the parse tree
	 */
	void exitEndif(BladeAntlrCompilerParser.EndifContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#conditional_block}.
	 * @param ctx the parse tree
	 */
	void enterConditional_block(BladeAntlrCompilerParser.Conditional_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#conditional_block}.
	 * @param ctx the parse tree
	 */
	void exitConditional_block(BladeAntlrCompilerParser.Conditional_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#auth_block}.
	 * @param ctx the parse tree
	 */
	void enterAuth_block(BladeAntlrCompilerParser.Auth_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#auth_block}.
	 * @param ctx the parse tree
	 */
	void exitAuth_block(BladeAntlrCompilerParser.Auth_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#switch}.
	 * @param ctx the parse tree
	 */
	void enterSwitch(BladeAntlrCompilerParser.SwitchContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#switch}.
	 * @param ctx the parse tree
	 */
	void exitSwitch(BladeAntlrCompilerParser.SwitchContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#while}.
	 * @param ctx the parse tree
	 */
	void enterWhile(BladeAntlrCompilerParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#while}.
	 * @param ctx the parse tree
	 */
	void exitWhile(BladeAntlrCompilerParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#for}.
	 * @param ctx the parse tree
	 */
	void enterFor(BladeAntlrCompilerParser.ForContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#for}.
	 * @param ctx the parse tree
	 */
	void exitFor(BladeAntlrCompilerParser.ForContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#foreach}.
	 * @param ctx the parse tree
	 */
	void enterForeach(BladeAntlrCompilerParser.ForeachContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#foreach}.
	 * @param ctx the parse tree
	 */
	void exitForeach(BladeAntlrCompilerParser.ForeachContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#forelse}.
	 * @param ctx the parse tree
	 */
	void enterForelse(BladeAntlrCompilerParser.ForelseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#forelse}.
	 * @param ctx the parse tree
	 */
	void exitForelse(BladeAntlrCompilerParser.ForelseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#yield}.
	 * @param ctx the parse tree
	 */
	void enterYield(BladeAntlrCompilerParser.YieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#yield}.
	 * @param ctx the parse tree
	 */
	void exitYield(BladeAntlrCompilerParser.YieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#stack}.
	 * @param ctx the parse tree
	 */
	void enterStack(BladeAntlrCompilerParser.StackContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#stack}.
	 * @param ctx the parse tree
	 */
	void exitStack(BladeAntlrCompilerParser.StackContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#include}.
	 * @param ctx the parse tree
	 */
	void enterInclude(BladeAntlrCompilerParser.IncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#include}.
	 * @param ctx the parse tree
	 */
	void exitInclude(BladeAntlrCompilerParser.IncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#includeIf}.
	 * @param ctx the parse tree
	 */
	void enterIncludeIf(BladeAntlrCompilerParser.IncludeIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#includeIf}.
	 * @param ctx the parse tree
	 */
	void exitIncludeIf(BladeAntlrCompilerParser.IncludeIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#includeCond}.
	 * @param ctx the parse tree
	 */
	void enterIncludeCond(BladeAntlrCompilerParser.IncludeCondContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#includeCond}.
	 * @param ctx the parse tree
	 */
	void exitIncludeCond(BladeAntlrCompilerParser.IncludeCondContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#includeFirst}.
	 * @param ctx the parse tree
	 */
	void enterIncludeFirst(BladeAntlrCompilerParser.IncludeFirstContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#includeFirst}.
	 * @param ctx the parse tree
	 */
	void exitIncludeFirst(BladeAntlrCompilerParser.IncludeFirstContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#each}.
	 * @param ctx the parse tree
	 */
	void enterEach(BladeAntlrCompilerParser.EachContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#each}.
	 * @param ctx the parse tree
	 */
	void exitEach(BladeAntlrCompilerParser.EachContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#hasSection}.
	 * @param ctx the parse tree
	 */
	void enterHasSection(BladeAntlrCompilerParser.HasSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#hasSection}.
	 * @param ctx the parse tree
	 */
	void exitHasSection(BladeAntlrCompilerParser.HasSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#custom_directive}.
	 * @param ctx the parse tree
	 */
	void enterCustom_directive(BladeAntlrCompilerParser.Custom_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#custom_directive}.
	 * @param ctx the parse tree
	 */
	void exitCustom_directive(BladeAntlrCompilerParser.Custom_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#php_blade}.
	 * @param ctx the parse tree
	 */
	void enterPhp_blade(BladeAntlrCompilerParser.Php_bladeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#php_blade}.
	 * @param ctx the parse tree
	 */
	void exitPhp_blade(BladeAntlrCompilerParser.Php_bladeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#phpInline}.
	 * @param ctx the parse tree
	 */
	void enterPhpInline(BladeAntlrCompilerParser.PhpInlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#phpInline}.
	 * @param ctx the parse tree
	 */
	void exitPhpInline(BladeAntlrCompilerParser.PhpInlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#echo}.
	 * @param ctx the parse tree
	 */
	void enterEcho(BladeAntlrCompilerParser.EchoContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#echo}.
	 * @param ctx the parse tree
	 */
	void exitEcho(BladeAntlrCompilerParser.EchoContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#echo_ne}.
	 * @param ctx the parse tree
	 */
	void enterEcho_ne(BladeAntlrCompilerParser.Echo_neContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#echo_ne}.
	 * @param ctx the parse tree
	 */
	void exitEcho_ne(BladeAntlrCompilerParser.Echo_neContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#php_expression}.
	 * @param ctx the parse tree
	 */
	void enterPhp_expression(BladeAntlrCompilerParser.Php_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#php_expression}.
	 * @param ctx the parse tree
	 */
	void exitPhp_expression(BladeAntlrCompilerParser.Php_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#singleArgWrapper}.
	 * @param ctx the parse tree
	 */
	void enterSingleArgWrapper(BladeAntlrCompilerParser.SingleArgWrapperContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#singleArgWrapper}.
	 * @param ctx the parse tree
	 */
	void exitSingleArgWrapper(BladeAntlrCompilerParser.SingleArgWrapperContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#singleArgAndDefaultWrapper}.
	 * @param ctx the parse tree
	 */
	void enterSingleArgAndDefaultWrapper(BladeAntlrCompilerParser.SingleArgAndDefaultWrapperContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#singleArgAndDefaultWrapper}.
	 * @param ctx the parse tree
	 */
	void exitSingleArgAndDefaultWrapper(BladeAntlrCompilerParser.SingleArgAndDefaultWrapperContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#doubleArgWrapper}.
	 * @param ctx the parse tree
	 */
	void enterDoubleArgWrapper(BladeAntlrCompilerParser.DoubleArgWrapperContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#doubleArgWrapper}.
	 * @param ctx the parse tree
	 */
	void exitDoubleArgWrapper(BladeAntlrCompilerParser.DoubleArgWrapperContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#multiArgWrapper}.
	 * @param ctx the parse tree
	 */
	void enterMultiArgWrapper(BladeAntlrCompilerParser.MultiArgWrapperContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#multiArgWrapper}.
	 * @param ctx the parse tree
	 */
	void exitMultiArgWrapper(BladeAntlrCompilerParser.MultiArgWrapperContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#identifiableArgument}.
	 * @param ctx the parse tree
	 */
	void enterIdentifiableArgument(BladeAntlrCompilerParser.IdentifiableArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#identifiableArgument}.
	 * @param ctx the parse tree
	 */
	void exitIdentifiableArgument(BladeAntlrCompilerParser.IdentifiableArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#composedArgument}.
	 * @param ctx the parse tree
	 */
	void enterComposedArgument(BladeAntlrCompilerParser.ComposedArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#composedArgument}.
	 * @param ctx the parse tree
	 */
	void exitComposedArgument(BladeAntlrCompilerParser.ComposedArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#paramAssign}.
	 * @param ctx the parse tree
	 */
	void enterParamAssign(BladeAntlrCompilerParser.ParamAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#paramAssign}.
	 * @param ctx the parse tree
	 */
	void exitParamAssign(BladeAntlrCompilerParser.ParamAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#verbatim_block}.
	 * @param ctx the parse tree
	 */
	void enterVerbatim_block(BladeAntlrCompilerParser.Verbatim_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#verbatim_block}.
	 * @param ctx the parse tree
	 */
	void exitVerbatim_block(BladeAntlrCompilerParser.Verbatim_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#loop_action}.
	 * @param ctx the parse tree
	 */
	void enterLoop_action(BladeAntlrCompilerParser.Loop_actionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#loop_action}.
	 * @param ctx the parse tree
	 */
	void exitLoop_action(BladeAntlrCompilerParser.Loop_actionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#html}.
	 * @param ctx the parse tree
	 */
	void enterHtml(BladeAntlrCompilerParser.HtmlContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#html}.
	 * @param ctx the parse tree
	 */
	void exitHtml(BladeAntlrCompilerParser.HtmlContext ctx);
}