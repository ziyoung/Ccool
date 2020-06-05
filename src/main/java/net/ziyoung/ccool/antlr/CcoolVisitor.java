// Generated from Ccool.g4 by ANTLR 4.8
package net.ziyoung.ccool.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CcoolParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CcoolVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CcoolParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(CcoolParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link CcoolParser#classDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDefinition(CcoolParser.ClassDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CcoolParser#superClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperClass(CcoolParser.SuperClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link CcoolParser#classMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMember(CcoolParser.ClassMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link CcoolParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(CcoolParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CcoolParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(CcoolParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link CcoolParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(CcoolParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CcoolParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(CcoolParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CcoolParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(CcoolParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CcoolParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CcoolParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(CcoolParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Call}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(CcoolParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Group}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup(CcoolParser.GroupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Negative}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegative(CcoolParser.NegativeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Liter}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiter(CcoolParser.LiterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(CcoolParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiply(CcoolParser.MultiplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(CcoolParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(CcoolParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(CcoolParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link CcoolParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(CcoolParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CcoolParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(CcoolParser.LiteralContext ctx);
}