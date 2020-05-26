// Generated from /src/main/java/net/ziyoung/ccool/antlr/Ccool.g4 by ANTLR 4.8
package net.ziyoung.ccool.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CcoolParser}.
 */
public interface CcoolListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CcoolParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(CcoolParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link CcoolParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(CcoolParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link CcoolParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void enterClassDefinition(CcoolParser.ClassDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CcoolParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void exitClassDefinition(CcoolParser.ClassDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CcoolParser#superClass}.
	 * @param ctx the parse tree
	 */
	void enterSuperClass(CcoolParser.SuperClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link CcoolParser#superClass}.
	 * @param ctx the parse tree
	 */
	void exitSuperClass(CcoolParser.SuperClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link CcoolParser#classMember}.
	 * @param ctx the parse tree
	 */
	void enterClassMember(CcoolParser.ClassMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link CcoolParser#classMember}.
	 * @param ctx the parse tree
	 */
	void exitClassMember(CcoolParser.ClassMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link CcoolParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(CcoolParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CcoolParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(CcoolParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CcoolParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(CcoolParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link CcoolParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(CcoolParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link CcoolParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(CcoolParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CcoolParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(CcoolParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CcoolParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(CcoolParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CcoolParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(CcoolParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CcoolParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(CcoolParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CcoolParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(CcoolParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CcoolParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CcoolParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CcoolParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CcoolParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CcoolParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CcoolParser.ExpressionContext ctx);
}