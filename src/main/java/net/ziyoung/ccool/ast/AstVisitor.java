package net.ziyoung.ccool.ast;

import net.ziyoung.ccool.ast.expression.*;
import net.ziyoung.ccool.ast.expression.literal.*;
import net.ziyoung.ccool.ast.statement.*;

public interface AstVisitor<R, C> {
    default public R visitNode(Node node, C context) {
        return null;
    }

    default public R visitStatement(Statement node, C context) {
        return visitNode(node, context);
    }

    default public R visitExpression(Expression node, C context) {
        return visitNode(node, context);
    }

    default public R visitLiteral(Literal node, C context) {
        return visitExpression(node, context);
    }

    public R visitStringLiteral(StringLiteral node, C context);

    public R visitBoolLiteral(BoolLiteral node, C context);

    public R visitIntLiteral(IntLiteral node, C context);

    public R visitDoubleLiteral(DoubleLiteral node, C context);

    public R visitVariableExpression(VariableExpression node, C context);

    public R visitParameter(Parameter node, C context);

    public R visitCallExpression(CallExpression node, C context);

    public R visitAssignExpression(AssignExpression node, C context);

    public R visitExpressionStatement(ExpressionStatement node, C context);

    public R visitVariableDeclaration(VariableDeclaration node, C context);

    public R visitBlockStatement(BlockStatement node, C context);

    public R visitFunctionStatement(FunctionStatement node, C context);

    public R visitCompilationUnit(CompilationUnit node, C context);
}
