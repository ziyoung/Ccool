package net.ziyoung.ccool.phase;

import net.ziyoung.ccool.ast.AstBaseVisitor;
import net.ziyoung.ccool.ast.CompilationUnit;
import net.ziyoung.ccool.ast.expression.Expression;
import net.ziyoung.ccool.ast.statement.*;
import net.ziyoung.ccool.context.*;
import net.ziyoung.ccool.error.SemanticErrors;
import net.ziyoung.ccool.phase.visitor.ExpressionResolver;
import net.ziyoung.ccool.type.Type;
import net.ziyoung.ccool.type.TypeName;
import net.ziyoung.ccool.type.Types;
import org.antlr.v4.runtime.Token;

// AnalysePhase just visits statements.
public class AnalysePhase extends AstBaseVisitor<Void, Context> {
    private final ExpressionResolver typeResolver;
    private ClassContext classContext;
    private int stackSize;
    private int localsSize;

    public AnalysePhase() {
        typeResolver = new ExpressionResolver();
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
        // Reset stack size and local variables size.
        restoreStackSize();
        restoreLocalsSize(methodContext.getOffset() + 1);

        visitBlockStatement(node.getBody(), methodContext);

        // After traverse, update method's stack size and local variables size.
        methodContext.setStackSize(stackSize);
        methodContext.setLocalsSize(localsSize);
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
            Type rightType = typeResolver.visitExpression(node.getExpression(), context);
            if (type != null && rightType != null && !type.equals(rightType)) {
                SemanticErrors.errorUnmatchedType(typeNameToken, rightType, type);
            }
        }

        Token token = node.getToken();
        int offset = ((LocalContext) context).nextOffset(type);
        // Update stack size and local variables size.
        setStackSize(Types.getTypeSize(type) + 1);
        setLocalsSize(offset + 1);

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

    // getStackSize is only used for testing.
    public int getStackSize() {
        return stackSize;
    }

    private void restoreStackSize() {
        stackSize = 2;
    }

    private void setStackSize(int size) {
        if (size > stackSize) {
            stackSize = size;
        }
    }

    // getLocalsSize is only used for testing.
    public int getLocalsSize() {
        return localsSize;
    }

    private void restoreLocalsSize(int size) {
        localsSize = size;
    }

    private void setLocalsSize(int size) {
        if (size > localsSize) {
            localsSize = size;
        }
    }

}
