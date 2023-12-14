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

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BladeAntlrParser}.
 */
public interface BladeAntlrParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(BladeAntlrParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(BladeAntlrParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#general_statement}.
	 * @param ctx the parse tree
	 */
	void enterGeneral_statement(BladeAntlrParser.General_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#general_statement}.
	 * @param ctx the parse tree
	 */
	void exitGeneral_statement(BladeAntlrParser.General_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#inline_statement}.
	 * @param ctx the parse tree
	 */
	void enterInline_statement(BladeAntlrParser.Inline_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#inline_statement}.
	 * @param ctx the parse tree
	 */
	void exitInline_statement(BladeAntlrParser.Inline_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#inline_directive}.
	 * @param ctx the parse tree
	 */
	void enterInline_directive(BladeAntlrParser.Inline_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#inline_directive}.
	 * @param ctx the parse tree
	 */
	void exitInline_directive(BladeAntlrParser.Inline_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void enterBlock_statement(BladeAntlrParser.Block_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void exitBlock_statement(BladeAntlrParser.Block_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#non_blade_statement}.
	 * @param ctx the parse tree
	 */
	void enterNon_blade_statement(BladeAntlrParser.Non_blade_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#non_blade_statement}.
	 * @param ctx the parse tree
	 */
	void exitNon_blade_statement(BladeAntlrParser.Non_blade_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#extends}.
	 * @param ctx the parse tree
	 */
	void enterExtends(BladeAntlrParser.ExtendsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#extends}.
	 * @param ctx the parse tree
	 */
	void exitExtends(BladeAntlrParser.ExtendsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#section_inline}.
	 * @param ctx the parse tree
	 */
	void enterSection_inline(BladeAntlrParser.Section_inlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#section_inline}.
	 * @param ctx the parse tree
	 */
	void exitSection_inline(BladeAntlrParser.Section_inlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(BladeAntlrParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(BladeAntlrParser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#push}.
	 * @param ctx the parse tree
	 */
	void enterPush(BladeAntlrParser.PushContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#push}.
	 * @param ctx the parse tree
	 */
	void exitPush(BladeAntlrParser.PushContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#pushOnce}.
	 * @param ctx the parse tree
	 */
	void enterPushOnce(BladeAntlrParser.PushOnceContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#pushOnce}.
	 * @param ctx the parse tree
	 */
	void exitPushOnce(BladeAntlrParser.PushOnceContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#if}.
	 * @param ctx the parse tree
	 */
	void enterIf(BladeAntlrParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#if}.
	 * @param ctx the parse tree
	 */
	void exitIf(BladeAntlrParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#elseif}.
	 * @param ctx the parse tree
	 */
	void enterElseif(BladeAntlrParser.ElseifContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#elseif}.
	 * @param ctx the parse tree
	 */
	void exitElseif(BladeAntlrParser.ElseifContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#else}.
	 * @param ctx the parse tree
	 */
	void enterElse(BladeAntlrParser.ElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#else}.
	 * @param ctx the parse tree
	 */
	void exitElse(BladeAntlrParser.ElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#endif}.
	 * @param ctx the parse tree
	 */
	void enterEndif(BladeAntlrParser.EndifContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#endif}.
	 * @param ctx the parse tree
	 */
	void exitEndif(BladeAntlrParser.EndifContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#conditional_block}.
	 * @param ctx the parse tree
	 */
	void enterConditional_block(BladeAntlrParser.Conditional_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#conditional_block}.
	 * @param ctx the parse tree
	 */
	void exitConditional_block(BladeAntlrParser.Conditional_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#auth_block}.
	 * @param ctx the parse tree
	 */
	void enterAuth_block(BladeAntlrParser.Auth_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#auth_block}.
	 * @param ctx the parse tree
	 */
	void exitAuth_block(BladeAntlrParser.Auth_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#switch}.
	 * @param ctx the parse tree
	 */
	void enterSwitch(BladeAntlrParser.SwitchContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#switch}.
	 * @param ctx the parse tree
	 */
	void exitSwitch(BladeAntlrParser.SwitchContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#while}.
	 * @param ctx the parse tree
	 */
	void enterWhile(BladeAntlrParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#while}.
	 * @param ctx the parse tree
	 */
	void exitWhile(BladeAntlrParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#for}.
	 * @param ctx the parse tree
	 */
	void enterFor(BladeAntlrParser.ForContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#for}.
	 * @param ctx the parse tree
	 */
	void exitFor(BladeAntlrParser.ForContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#foreach}.
	 * @param ctx the parse tree
	 */
	void enterForeach(BladeAntlrParser.ForeachContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#foreach}.
	 * @param ctx the parse tree
	 */
	void exitForeach(BladeAntlrParser.ForeachContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#forelse}.
	 * @param ctx the parse tree
	 */
	void enterForelse(BladeAntlrParser.ForelseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#forelse}.
	 * @param ctx the parse tree
	 */
	void exitForelse(BladeAntlrParser.ForelseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#yield}.
	 * @param ctx the parse tree
	 */
	void enterYield(BladeAntlrParser.YieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#yield}.
	 * @param ctx the parse tree
	 */
	void exitYield(BladeAntlrParser.YieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#stack}.
	 * @param ctx the parse tree
	 */
	void enterStack(BladeAntlrParser.StackContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#stack}.
	 * @param ctx the parse tree
	 */
	void exitStack(BladeAntlrParser.StackContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#include}.
	 * @param ctx the parse tree
	 */
	void enterInclude(BladeAntlrParser.IncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#include}.
	 * @param ctx the parse tree
	 */
	void exitInclude(BladeAntlrParser.IncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#includeIf}.
	 * @param ctx the parse tree
	 */
	void enterIncludeIf(BladeAntlrParser.IncludeIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#includeIf}.
	 * @param ctx the parse tree
	 */
	void exitIncludeIf(BladeAntlrParser.IncludeIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#includeCond}.
	 * @param ctx the parse tree
	 */
	void enterIncludeCond(BladeAntlrParser.IncludeCondContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#includeCond}.
	 * @param ctx the parse tree
	 */
	void exitIncludeCond(BladeAntlrParser.IncludeCondContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#includeFirst}.
	 * @param ctx the parse tree
	 */
	void enterIncludeFirst(BladeAntlrParser.IncludeFirstContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#includeFirst}.
	 * @param ctx the parse tree
	 */
	void exitIncludeFirst(BladeAntlrParser.IncludeFirstContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#each}.
	 * @param ctx the parse tree
	 */
	void enterEach(BladeAntlrParser.EachContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#each}.
	 * @param ctx the parse tree
	 */
	void exitEach(BladeAntlrParser.EachContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#hasSection}.
	 * @param ctx the parse tree
	 */
	void enterHasSection(BladeAntlrParser.HasSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#hasSection}.
	 * @param ctx the parse tree
	 */
	void exitHasSection(BladeAntlrParser.HasSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#custom_directive}.
	 * @param ctx the parse tree
	 */
	void enterCustom_directive(BladeAntlrParser.Custom_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#custom_directive}.
	 * @param ctx the parse tree
	 */
	void exitCustom_directive(BladeAntlrParser.Custom_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#php_blade}.
	 * @param ctx the parse tree
	 */
	void enterPhp_blade(BladeAntlrParser.Php_bladeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#php_blade}.
	 * @param ctx the parse tree
	 */
	void exitPhp_blade(BladeAntlrParser.Php_bladeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#echo}.
	 * @param ctx the parse tree
	 */
	void enterEcho(BladeAntlrParser.EchoContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#echo}.
	 * @param ctx the parse tree
	 */
	void exitEcho(BladeAntlrParser.EchoContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#echo_ne}.
	 * @param ctx the parse tree
	 */
	void enterEcho_ne(BladeAntlrParser.Echo_neContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#echo_ne}.
	 * @param ctx the parse tree
	 */
	void exitEcho_ne(BladeAntlrParser.Echo_neContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#php_expression}.
	 * @param ctx the parse tree
	 */
	void enterPhp_expression(BladeAntlrParser.Php_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#php_expression}.
	 * @param ctx the parse tree
	 */
	void exitPhp_expression(BladeAntlrParser.Php_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#singleArgWrapper}.
	 * @param ctx the parse tree
	 */
	void enterSingleArgWrapper(BladeAntlrParser.SingleArgWrapperContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#singleArgWrapper}.
	 * @param ctx the parse tree
	 */
	void exitSingleArgWrapper(BladeAntlrParser.SingleArgWrapperContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#singleArgAndDefaultWrapper}.
	 * @param ctx the parse tree
	 */
	void enterSingleArgAndDefaultWrapper(BladeAntlrParser.SingleArgAndDefaultWrapperContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#singleArgAndDefaultWrapper}.
	 * @param ctx the parse tree
	 */
	void exitSingleArgAndDefaultWrapper(BladeAntlrParser.SingleArgAndDefaultWrapperContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#doubleArgWrapper}.
	 * @param ctx the parse tree
	 */
	void enterDoubleArgWrapper(BladeAntlrParser.DoubleArgWrapperContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#doubleArgWrapper}.
	 * @param ctx the parse tree
	 */
	void exitDoubleArgWrapper(BladeAntlrParser.DoubleArgWrapperContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#multiArgWrapper}.
	 * @param ctx the parse tree
	 */
	void enterMultiArgWrapper(BladeAntlrParser.MultiArgWrapperContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#multiArgWrapper}.
	 * @param ctx the parse tree
	 */
	void exitMultiArgWrapper(BladeAntlrParser.MultiArgWrapperContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#identifiableArgument}.
	 * @param ctx the parse tree
	 */
	void enterIdentifiableArgument(BladeAntlrParser.IdentifiableArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#identifiableArgument}.
	 * @param ctx the parse tree
	 */
	void exitIdentifiableArgument(BladeAntlrParser.IdentifiableArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#composedArgument}.
	 * @param ctx the parse tree
	 */
	void enterComposedArgument(BladeAntlrParser.ComposedArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#composedArgument}.
	 * @param ctx the parse tree
	 */
	void exitComposedArgument(BladeAntlrParser.ComposedArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#paramAssign}.
	 * @param ctx the parse tree
	 */
	void enterParamAssign(BladeAntlrParser.ParamAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#paramAssign}.
	 * @param ctx the parse tree
	 */
	void exitParamAssign(BladeAntlrParser.ParamAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#verbatim_block}.
	 * @param ctx the parse tree
	 */
	void enterVerbatim_block(BladeAntlrParser.Verbatim_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#verbatim_block}.
	 * @param ctx the parse tree
	 */
	void exitVerbatim_block(BladeAntlrParser.Verbatim_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#loop_action}.
	 * @param ctx the parse tree
	 */
	void enterLoop_action(BladeAntlrParser.Loop_actionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#loop_action}.
	 * @param ctx the parse tree
	 */
	void exitLoop_action(BladeAntlrParser.Loop_actionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#html}.
	 * @param ctx the parse tree
	 */
	void enterHtml(BladeAntlrParser.HtmlContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#html}.
	 * @param ctx the parse tree
	 */
	void exitHtml(BladeAntlrParser.HtmlContext ctx);
}