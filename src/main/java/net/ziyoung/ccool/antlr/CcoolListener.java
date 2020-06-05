// Generated from Ccool.g4 by ANTLR 4.8
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
	 * Enter a parse tree produced by the {@code Add}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdd(CcoolParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdd(CcoolParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Call}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCall(CcoolParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Call}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCall(CcoolParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Group}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGroup(CcoolParser.GroupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Group}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGroup(CcoolParser.GroupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negative}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegative(CcoolParser.NegativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negative}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegative(CcoolParser.NegativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Liter}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiter(CcoolParser.LiterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Liter}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiter(CcoolParser.LiterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVar(CcoolParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVar(CcoolParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiply(CcoolParser.MultiplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiply(CcoolParser.MultiplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssign(CcoolParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssign(CcoolParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Division}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivision(CcoolParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivision(CcoolParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMinus(CcoolParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link CcoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMinus(CcoolParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by {@link CcoolParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(CcoolParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CcoolParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(CcoolParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CcoolParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(CcoolParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CcoolParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(CcoolParser.LiteralContext ctx);
}