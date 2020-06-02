package net.ziyoung.ccool.ast;

import net.ziyoung.ccool.ast.expression.*;
import net.ziyoung.ccool.ast.expression.literal.*;
import net.ziyoung.ccool.ast.statement.*;

public abstract class AstBaseVisitor<R, C> implements AstVisitor<R, C> {
    @Override
    public R visitStatement(Statement node, C context) {
        if (node instanceof BlockStatement) {
            return visitBlockStatement((BlockStatement) node, context);
        } else if (node instanceof ExpressionStatement) {
            return visitExpressionStatement((ExpressionStatement) node, context);
        } else if (node instanceof VariableDeclaration) {
            return visitVariableDeclaration((VariableDeclaration) node, context);
        }
        return null;
    }

    @Override
    public R visitExpression(Expression node, C context) {
        if (node instanceof AssignExpression) {
            return visitAssignExpression((AssignExpression) node, context);
        } else if (node instanceof CallExpression) {
            return visitCallExpression((CallExpression) node, context);
        } else if (node instanceof VariableExpression) {
            return visitVariableExpression((VariableExpression) node, context);
        } else if (node instanceof Literal) {
            return visitLiteral((Literal) node, context);
        }
        return null;
    }

    @Override
    public R visitLiteral(Literal node, C context) {
        if (node instanceof BoolLiteral) {
            return visitBoolLiteral((BoolLiteral) node, context);
        } else if (node instanceof IntLiteral) {
            return visitIntLiteral((IntLiteral) node, context);
        } else if (node instanceof DoubleLiteral) {
            return visitDoubleLiteral((DoubleLiteral) node, context);
        } else if (node instanceof StringLiteral) {
            return visitStringLiteral((StringLiteral) node, context);
        } else if (node instanceof NullLiteral) {
            return visitNullLiteral((NullLiteral) node, context);
        }
        return null;
    }

    @Override
    public R visitBoolLiteral(BoolLiteral node, C context) {
        return null;
    }

    @Override
    public R visitIntLiteral(IntLiteral node, C context) {
        return null;
    }

    @Override
    public R visitDoubleLiteral(DoubleLiteral node, C context) {
        return null;
    }

    @Override
    public R visitStringLiteral(StringLiteral node, C context) {
        return null;
    }

    @Override
    public R visitNullLiteral(NullLiteral node, C context) {
        return null;
    }

    @Override
    public R visitVariableExpression(VariableExpression node, C context) {
        return null;
    }

    @Override
    public R visitParameter(Parameter node, C context) {
        return null;
    }

    @Override
    public R visitCallExpression(CallExpression node, C context) {
        return null;
    }

    @Override
    public R visitAssignExpression(AssignExpression node, C context) {
        return null;
    }

    @Override
    public R visitExpressionStatement(ExpressionStatement node, C context) {
        Expression expression = node.getExpression();
        // We can ignore this statement.
        if (expression instanceof VariableExpression) {
            return null;
        }
        return visitExpression(expression, context);
    }

    @Override
    public R visitVariableDeclaration(VariableDeclaration node, C context) {
        return null;
    }

    @Override
    public R visitBlockStatement(BlockStatement node, C context) {
        return null;
    }

    @Override
    public R visitMethodDeclaration(MethodDeclaration node, C context) {
        return null;
    }

    @Override
    public R visitClassDeclaration(ClassDeclaration node, C context) {
        return null;
    }

    @Override
    public R visitCompilationUnit(CompilationUnit node, C context) {
        return null;
    }
}
