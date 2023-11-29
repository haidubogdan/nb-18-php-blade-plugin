// Generated from BladeAntlrParser.g4 by ANTLR 4.13.0

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
	 * Enter a parse tree produced by {@link BladeAntlrParser#bl_sg_param}.
	 * @param ctx the parse tree
	 */
	void enterBl_sg_param(BladeAntlrParser.Bl_sg_paramContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#bl_sg_param}.
	 * @param ctx the parse tree
	 */
	void exitBl_sg_param(BladeAntlrParser.Bl_sg_paramContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#bl_sg_default_param}.
	 * @param ctx the parse tree
	 */
	void enterBl_sg_default_param(BladeAntlrParser.Bl_sg_default_paramContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#bl_sg_default_param}.
	 * @param ctx the parse tree
	 */
	void exitBl_sg_default_param(BladeAntlrParser.Bl_sg_default_paramContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#default_blade_param_expression}.
	 * @param ctx the parse tree
	 */
	void enterDefault_blade_param_expression(BladeAntlrParser.Default_blade_param_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#default_blade_param_expression}.
	 * @param ctx the parse tree
	 */
	void exitDefault_blade_param_expression(BladeAntlrParser.Default_blade_param_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#blade_params_expression}.
	 * @param ctx the parse tree
	 */
	void enterBlade_params_expression(BladeAntlrParser.Blade_params_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#blade_params_expression}.
	 * @param ctx the parse tree
	 */
	void exitBlade_params_expression(BladeAntlrParser.Blade_params_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#blade_parameter}.
	 * @param ctx the parse tree
	 */
	void enterBlade_parameter(BladeAntlrParser.Blade_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#blade_parameter}.
	 * @param ctx the parse tree
	 */
	void exitBlade_parameter(BladeAntlrParser.Blade_parameterContext ctx);
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