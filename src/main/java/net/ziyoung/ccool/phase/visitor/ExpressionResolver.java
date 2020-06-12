package net.ziyoung.ccool.phase.visitor;

import net.ziyoung.ccool.ast.AstBaseVisitor;
import net.ziyoung.ccool.ast.expression.*;
import net.ziyoung.ccool.ast.expression.arithmetic.AddExpression;
import net.ziyoung.ccool.ast.expression.literal.Literal;
import net.ziyoung.ccool.context.Context;
import net.ziyoung.ccool.context.Definition;
import net.ziyoung.ccool.context.MethodDefinition;
import net.ziyoung.ccool.error.SemanticErrors;
import net.ziyoung.ccool.type.Type;
import net.ziyoung.ccool.type.TypeChecker;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

// For a expression, we expect to get type after visiting it.
public class ExpressionResolver extends AstBaseVisitor<Type, Context> {
    @Override
    public Type visitVariableExpression(VariableExpression node, Context context) {
        Token token = node.getToken();
        Definition definition = context.resolve(token.getText());
        if (definition == null) {
            SemanticErrors.errorUndefinedVariable(token);
            return null;
        }
        Type type = definition.getType();
        node.setType(type);
        return type;
    }

    @Override
    public Type visitCallExpression(CallExpression node, Context context) {
        Expression expression = node.getLhs();
        // FIXME: more features need to be added.
        if (expression instanceof VariableExpression) {
            Token token = expression.getToken();
            MethodDefinition methodDefinition = context.resolveMethod(token.getText());
            if (methodDefinition == null) {
                SemanticErrors.errorUndefinedMethod(token);
            } else {
                List<Expression> arguments = node.getArguments();
                List<Type> types = new ArrayList<>(arguments.size());
                for (Expression argument : arguments) {
                    types.add(visitExpression(argument, context));
                }
                methodDefinition.checkCallArguments(token, types);
            }
            Type type = methodDefinition == null ? null : methodDefinition.getReturnType();
            node.setType(type);
            return type;
        }
        return null;
    }

    // Unary expressions start.
    @Override
    public Type visitNegativeExpression(NegativeExpression node, Context context) {
        Expression rhs = node.getRhs();
        Type type = visitExpression(rhs, context);
        node.setType(type);
        return TypeChecker.negativeOp(node);
    }

    @Override
    public Type visitGroupExpression(GroupExpression node, Context context) {
        Expression expression = node.getRhs();
        Type type = visitExpression(expression, context);
        node.setType(type);
        return type;
    }
    // Unary expressions end.

    // Binary expressions start.
    @Override
    public Type visitBinaryExpression(BinaryExpression node, Context context) {
        if (node instanceof AssignExpression) {
            return visitAssignExpression((AssignExpression) node, context);
        }
        // TODO: support string concatenation.
//        if (node instanceof AddExpression) {
//            return visitAddExpression((AddExpression) node, context);
//        }
        return visitArithmeticExpression(node, context);
    }

    private Type visitArithmeticExpression(BinaryExpression node, Context context) {
        visitExpression(node.getLhs(), context);
        visitExpression(node.getRhs(), context);
        Type type = TypeChecker.binaryOp(node.getLhs(), node.getRhs());
        node.setType(type);
        return type;
    }

//    @Override
//    public Type visitMultiplyExpression(MultiplyExpression node, Context context) {
//        visitExpression(node.getLhs(), context);
//        visitExpression(node.getRhs(), context);
//        Type type = TypeChecker.binaryOp(node.getLhs(), node.getRhs());
//        node.setType(type);
//        return type;
//    }
//
//    @Override
//    public Type visitDivisionExpression(DivisionExpression node, Context context) {
//        return super.visitDivisionExpression(node, context);
//    }

    @Override
    public Type visitAddExpression(AddExpression node, Context context) {
        return super.visitAddExpression(node, context);
    }

//    @Override
//    public Type visitMinusExpression(MinusExpression node, Context context) {
//        return super.visitMinusExpression(node, context);
//    }

    @Override
    public Type visitAssignExpression(AssignExpression node, Context context) {
        visitExpression(node.getLhs(), context);
        visitExpression(node.getRhs(), context);
        return TypeChecker.assignOp(node.getLhs(), node.getRhs());
    }
    // Binary expressions end.

    @Override
    public Type visitLiteral(Literal node, Context context) {
        return node.getType();
    }
}
