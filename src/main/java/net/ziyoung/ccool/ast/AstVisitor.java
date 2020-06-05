package net.ziyoung.ccool.ast;

import net.ziyoung.ccool.ast.expression.*;
import net.ziyoung.ccool.ast.expression.arithmetic.AddExpression;
import net.ziyoung.ccool.ast.expression.arithmetic.DivisionExpression;
import net.ziyoung.ccool.ast.expression.arithmetic.MinusExpression;
import net.ziyoung.ccool.ast.expression.arithmetic.MultiplyExpression;
import net.ziyoung.ccool.ast.expression.literal.*;
import net.ziyoung.ccool.ast.statement.*;

public interface AstVisitor<R, C> {
    default R visitNode(Node node, C context) {
        return null;
    }

    default R visitStatement(Statement node, C context) {
        return visitNode(node, context);
    }

    default R visitExpression(Expression node, C context) {
        return visitNode(node, context);
    }

    default R visitLiteral(Literal node, C context) {
        return visitExpression(node, context);
    }

    R visitBoolLiteral(BoolLiteral node, C context);

    R visitIntLiteral(IntLiteral node, C context);

    R visitDoubleLiteral(DoubleLiteral node, C context);

    R visitStringLiteral(StringLiteral node, C context);

    R visitNullLiteral(NullLiteral node, C context);

    R visitVariableExpression(VariableExpression node, C context);

    R visitParameter(Parameter node, C context);

    R visitCallExpression(CallExpression node, C context);

    R visitNegativeExpression(NegativeExpression node, C context);

    R visitMultiplyExpression(MultiplyExpression node, C context);

    R visitDivisionExpression(DivisionExpression node, C context);

    R visitAddExpression(AddExpression node, C context);

    R visitMinusExpression(MinusExpression node, C context);

    R visitGroupExpression(GroupExpression node, C context);

    R visitAssignExpression(AssignExpression node, C context);

    R visitExpressionStatement(ExpressionStatement node, C context);

    R visitVariableDeclaration(VariableDeclaration node, C context);

    R visitBlockStatement(BlockStatement node, C context);

    R visitMethodDeclaration(MethodDeclaration node, C context);

    R visitClassDeclaration(ClassDeclaration node, C context);

    R visitCompilationUnit(CompilationUnit node, C context);
}
