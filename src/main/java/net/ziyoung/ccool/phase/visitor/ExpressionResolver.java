package net.ziyoung.ccool.phase.visitor;

import net.ziyoung.ccool.ast.AstBaseVisitor;
import net.ziyoung.ccool.ast.expression.*;
import net.ziyoung.ccool.ast.expression.arithmetic.AddExpression;
import net.ziyoung.ccool.ast.expression.arithmetic.DivisionExpression;
import net.ziyoung.ccool.ast.expression.arithmetic.MinusExpression;
import net.ziyoung.ccool.ast.expression.arithmetic.MultiplyExpression;
import net.ziyoung.ccool.ast.expression.literal.Literal;
import net.ziyoung.ccool.context.Context;
import net.ziyoung.ccool.context.Definition;
import net.ziyoung.ccool.context.MethodDefinition;
import net.ziyoung.ccool.error.SemanticErrors;
import net.ziyoung.ccool.type.Type;
import net.ziyoung.ccool.type.Types;
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
        Token token = node.getToken();
        Expression rhs = node.getRhs();
        Type type = visitExpression(rhs, context);
        if (!(type != null && type.isBool())) {
            SemanticErrors.errorUnmatchedType(token, type, Types._bool);
        }
        return Types._bool;
    }

    @Override
    public Type visitGroupExpression(GroupExpression node, Context context) {
        Expression expression = node.getRhs();
        return visitExpression(expression, context);
    }
    // Unary expressions end.

    // Binary expressions start.
    @Override
    public Type visitMultiplyExpression(MultiplyExpression node, Context context) {
        Token token = node.getToken();
        Type lhsType = visitExpression(node.getLhs(), context);
        Type rhsType = visitExpression(node.getRhs(), context);
        if (!(rhsType != null && lhsType == rhsType)) {
            SemanticErrors.errorUnmatchedType(token, lhsType, rhsType);
        }
        return lhsType;
    }

    @Override
    public Type visitDivisionExpression(DivisionExpression node, Context context) {
        return super.visitDivisionExpression(node, context);
    }

    @Override
    public Type visitAddExpression(AddExpression node, Context context) {
        return super.visitAddExpression(node, context);
    }

    @Override
    public Type visitMinusExpression(MinusExpression node, Context context) {
        return super.visitMinusExpression(node, context);
    }

    @Override
    public Type visitAssignExpression(AssignExpression node, Context context) {
        Type type = visitExpression(node.getRhs(), context);
        node.setType(type);
        return type;
    }
    // Binary expressions end.

    @Override
    public Type visitLiteral(Literal node, Context context) {
        return node.getType();
    }
}
