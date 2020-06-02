package net.ziyoung.ccool.phase;

import net.ziyoung.ccool.ast.AstBaseVisitor;
import net.ziyoung.ccool.ast.CompilationUnit;
import net.ziyoung.ccool.ast.expression.AssignExpression;
import net.ziyoung.ccool.ast.expression.CallExpression;
import net.ziyoung.ccool.ast.expression.Expression;
import net.ziyoung.ccool.ast.expression.VariableExpression;
import net.ziyoung.ccool.ast.expression.literal.*;
import net.ziyoung.ccool.ast.statement.*;
import net.ziyoung.ccool.context.*;
import net.ziyoung.ccool.error.SemanticErrors;
import net.ziyoung.ccool.type.Type;
import net.ziyoung.ccool.type.TypeName;
import net.ziyoung.ccool.type.Types;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

// For a expression, we expect to get type after visiting it.
class ExpressionVisitor extends AstBaseVisitor<Type, Context> {
    @Override
    public Type visitVariableExpression(VariableExpression node, Context context) {
        Token token = node.getToken();
        Definition definition = context.resolve(token.getText());
        System.out.println("my visitor --> visitVariableExpression");
        System.out.println(token.getText());
        if (definition == null) {
            SemanticErrors.errorUndefinedVariable(token);
            return null;
        }
        return definition.getType();
    }

    @Override
    public Type visitCallExpression(CallExpression node, Context context) {
        Expression expression = node.getLhs();
        // FIXME: more features need to be added.
        if (expression instanceof VariableExpression) {
            System.out.println("visitCallExpression --> visitCallExpression");
            Token token = ((VariableExpression) expression).getToken();
            MethodDefinition methodDefinition = context.resolveMethod(token.getText());
            if (methodDefinition == null) {
                SemanticErrors.errorUndefinedMethod(token);
            } else {
                List<Expression> arguments = node.getArguments();
                List<Type> types = new ArrayList<>(arguments.size());
                for (int i = 0; i < arguments.size(); i++) {
                    types.set(i, visitExpression(arguments.get(i), context));
                }
                checkArgumentType(token, methodDefinition, types);
            }
            return methodDefinition == null ? null : methodDefinition.getReturnType();
        }
        return null;
    }

    @Override
    public Type visitAssignExpression(AssignExpression node, Context context) {
        return visitExpression(node.getRhs(), context);
    }

    @Override
    public Type visitBoolLiteral(BoolLiteral node, Context context) {
        return Types._bool;
    }

    @Override
    public Type visitIntLiteral(IntLiteral node, Context context) {
        return Types._int;
    }

    @Override
    public Type visitDoubleLiteral(DoubleLiteral node, Context context) {
        return Types._double;
    }

    @Override
    public Type visitStringLiteral(StringLiteral node, Context context) {
        return Types._string;
    }

    @Override
    public Type visitNullLiteral(NullLiteral node, Context context) {
        // FIXME: which type null represents?
        return null;
    }

    public void checkArgumentType(Token token, MethodDefinition methodDefinition, List<Type> types) {
        List<VariableDefinition> parameters = methodDefinition.getParameters();
        int parameterSize = parameters.size();
        int argumentSize = types.size();
        if (parameterSize != argumentSize) {
            SemanticErrors.error(token, String.format("function %s needs %d parameters but gets %d", token.getText(), parameterSize, argumentSize));
            return;
        }
        for (int i = 0; i < argumentSize; i++) {
            Type type = parameters.get(i).getType();
            Type type1 = types.get(i);
            if (type != null && type1 != null && !type1.equals(type)) {
                SemanticErrors.error(token, String.format("for argument %d, expected type is %s but got %s", i, type, type1));
            }
        }
    }

}

// AnalysePhase just visits statements.
public class AnalysePhase extends AstBaseVisitor<Void, Context> {
    private ClassContext classContext;
    private final ExpressionVisitor expressionVisitor = new ExpressionVisitor();

    @Override
    public Void visitCompilationUnit(CompilationUnit node, Context context) {
        CompilationUnitContext compilationUnitContext = node.getContext();
        for (ClassDeclaration declaration : node.getDeclarations()) {
            this.classContext = declaration.getContext();
            visitClassDeclaration(declaration, compilationUnitContext);
        }
        return null;
    }

    @Override
    public Void visitClassDeclaration(ClassDeclaration node, Context context) {
        ClassContext classContext = node.getContext();
        for (Statement member : node.getMembers()) {
            if (member instanceof MethodDeclaration) {
                visitMethodDeclaration((MethodDeclaration) member, classContext);
            }
        }
        return null;
    }

    @Override
    public Void visitMethodDeclaration(MethodDeclaration node, Context context) {
        MethodContext methodContext = node.getContext();
        visitBlockStatement(node.getBody(), methodContext);
        return null;
    }

    // visitBlockStatement may be called recursively.
    @Override
    public Void visitBlockStatement(BlockStatement node, Context context) {
        LocalContext localContext = new LocalContext(node, context, this.classContext);
        for (Statement statement : node.getStatements()) {
            visitStatement(statement, localContext);
        }
        return null;
    }

    @Override
    public Void visitVariableDeclaration(VariableDeclaration node, Context context) {
        TypeName typeName = node.getTypeName();
        Token token = typeName.getToken();
        Type type = typeName.resolve(context);
        if (type == null) {
            SemanticErrors.errorUndefinedType(token);
        }
        Expression expression = node.getExpression();
        if (expression != null) {
            Type type1 = expressionVisitor.visitExpression(node.getExpression(), context);
            if (type != null && type1 != null && !type.equals(type1)) {
                SemanticErrors.errorUnmatchedType(token, type, type1);
            }
        }
        return null;
    }

    @Override
    public Void visitExpression(Expression node, Context context) {
        System.out.println("visitExpression---->");
        System.out.println(node);
        expressionVisitor.visitExpression(node, context);
        return null;
    }
}
