package net.ziyoung.ccool.phase.visitor;

import net.ziyoung.ccool.ast.AstBaseVisitor;
import net.ziyoung.ccool.ast.expression.AssignExpression;
import net.ziyoung.ccool.ast.expression.CallExpression;
import net.ziyoung.ccool.ast.expression.Expression;
import net.ziyoung.ccool.ast.expression.VariableExpression;
import net.ziyoung.ccool.ast.expression.literal.Literal;
import net.ziyoung.ccool.context.Context;
import net.ziyoung.ccool.context.Definition;
import net.ziyoung.ccool.context.MethodDefinition;
import net.ziyoung.ccool.error.SemanticErrors;
import net.ziyoung.ccool.type.Type;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

// For a expression, we expect to get type after visiting it.
public class ExpressionTypeResolver extends AstBaseVisitor<Type, Context> {
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
            Token token = ((VariableExpression) expression).getToken();
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

    @Override
    public Type visitAssignExpression(AssignExpression node, Context context) {
        Type type = visitExpression(node.getRhs(), context);
        node.setType(type);
        return type;
    }

    @Override
    public Type visitLiteral(Literal node, Context context) {
        return node.getType();
    }
}
