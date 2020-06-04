package net.ziyoung.ccool.phase;

import net.ziyoung.ccool.ast.AstBaseVisitor;
import net.ziyoung.ccool.ast.CompilationUnit;
import net.ziyoung.ccool.ast.expression.Expression;
import net.ziyoung.ccool.ast.statement.*;
import net.ziyoung.ccool.context.*;
import net.ziyoung.ccool.error.SemanticErrors;
import net.ziyoung.ccool.phase.visitor.ExpressionTypeResolver;
import net.ziyoung.ccool.type.Type;
import net.ziyoung.ccool.type.TypeName;
import org.antlr.v4.runtime.Token;

// AnalysePhase just visits statements.
public class AnalysePhase extends AstBaseVisitor<Void, Context> {
    private final ExpressionTypeResolver typeResolver;
    private ClassContext classContext;

    public AnalysePhase() {
        typeResolver = new ExpressionTypeResolver();
    }

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

    @Override
    public Void visitVariableDeclaration(VariableDeclaration node, Context context) {
        TypeName typeName = node.getTypeName();
        Token typeNameToken = typeName.getToken();
        Type type = typeName.resolve(context);
        if (type == null) {
            SemanticErrors.errorUndefinedType(typeNameToken);
        }
        Expression expression = node.getExpression();
        if (expression != null) {
            Type type1 = typeResolver.visitExpression(node.getExpression(), context);
            if (type != null && type1 != null && !type.equals(type1)) {
                SemanticErrors.errorUnmatchedType(typeNameToken, type, type1);
            }
        }
        Token token = node.getToken();
        int offset = ((LocalContext) context).nextOffset();
        VariableDefinition variableDefinition = new VariableDefinition(type, offset);
        context.define(token, variableDefinition);
        return null;
    }

    // visitBlockStatement may be called recursively.
    @Override
    public Void visitBlockStatement(BlockStatement node, Context context) {
        LocalContext localContext = new LocalContext(node, context, this.classContext);
        node.setContext(localContext);
        for (Statement statement : node.getStatements()) {
            visitStatement(statement, localContext);
        }
        return null;
    }

    @Override
    public Void visitExpression(Expression node, Context context) {
        typeResolver.visitExpression(node, context);
        return null;
    }
}
