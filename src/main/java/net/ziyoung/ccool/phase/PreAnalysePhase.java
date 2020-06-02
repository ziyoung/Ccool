package net.ziyoung.ccool.phase;

import net.ziyoung.ccool.ast.AstBaseVisitor;
import net.ziyoung.ccool.ast.CompilationUnit;
import net.ziyoung.ccool.ast.expression.Parameter;
import net.ziyoung.ccool.ast.statement.ClassDeclaration;
import net.ziyoung.ccool.ast.statement.MethodDeclaration;
import net.ziyoung.ccool.ast.statement.Statement;
import net.ziyoung.ccool.ast.statement.VariableDeclaration;
import net.ziyoung.ccool.context.*;
import net.ziyoung.ccool.error.SemanticErrors;
import net.ziyoung.ccool.type.PrimaryType;
import net.ziyoung.ccool.type.Type;
import net.ziyoung.ccool.type.TypeName;
import net.ziyoung.ccool.type.Types;
import org.antlr.v4.runtime.Token;

public class PreAnalysePhase extends AstBaseVisitor<Void, Context> {
    @Override
    public Void visitCompilationUnit(CompilationUnit node, Context context) {
        CompilationUnitContext compilationUnitContext = new CompilationUnitContext(node);
        for (PrimaryType primaryType : Types.getPrimaryTypes()) {
            compilationUnitContext.definePrimaryType(primaryType);
        }
        for (ClassDeclaration declaration : node.getDeclarations()) {
            visitClassDeclaration(declaration, compilationUnitContext);
        }
        return null;
    }

    @Override
    public Void visitClassDeclaration(ClassDeclaration node, Context context) {
        // Nested class is not supported.
        CompilationUnitContext compilationUnitContext = (CompilationUnitContext) context;
        Token token = node.getToken();
        String name = token.getText();
        if (compilationUnitContext.resolve(name) != null) {
            SemanticErrors.error(token, String.format("class %s has been declared", name));
        }

        Type type = Types.createUserDefinedType(name);
        compilationUnitContext.defineUserType(token, type);
        ClassContext classContext = new ClassContext(node, compilationUnitContext);
        node.setContext(classContext);
        for (Statement declaration : node.getMembers()) {
            if (declaration instanceof VariableDeclaration) {
                visitVariableDeclaration((VariableDeclaration) declaration, classContext);
            } else if (declaration instanceof MethodDeclaration) {
                visitMethodDeclaration((MethodDeclaration) declaration, classContext);
            }
        }
        return null;
    }

    @Override
    public Void visitMethodDeclaration(MethodDeclaration node, Context context) {
        boolean invalid = context instanceof ClassContext;
        if (!invalid) {
            SemanticErrors.error(node.getToken(), "function is allowed to declare in a Class");
            return null;
        }
        Type type = node.getTypeName().resolve(context);
        if (type == null) {
            SemanticErrors.errorUndefinedType(node.getTypeName().getToken());
        }
        MethodContext methodContext = new MethodContext(node, (ClassContext) context, type);
        node.setContext(methodContext);
        for (Parameter parameter : node.getParameters()) {
            visitParameter(parameter, methodContext);
        }
        return null;
    }

    @Override
    public Void visitParameter(Parameter node, Context context) {
        MethodContext methodContext = (MethodContext) context;
        TypeName typeName = node.getTypeName();
        Type type = typeName.resolve(methodContext);
        Token token = node.getToken();
        String parameterName = token.getText();
        if (type == null) {
            SemanticErrors.errorUndefinedType(typeName.getToken());
        } else if (methodContext.resolveParameter(parameterName) != null) {
            SemanticErrors.errorReDefine(token, "parameter");
        }
        methodContext.defineParameter(type, parameterName);
        return null;
    }

    @Override
    public Void visitVariableDeclaration(VariableDeclaration node, Context context) {
        // In PreAnalyse phase, just visit PropertyDeclaration which is also VariableDeclaration.
        if (context instanceof ClassContext) {
            ClassContext classContext = (ClassContext) context;
            TypeName typeName = node.getTypeName();
            Type type = typeName.resolve(context);
            if (type == null) {
                SemanticErrors.errorUndefinedType(typeName.getToken());
            }
            FieldDefinition fieldDefinition = new FieldDefinition(type, node.getToken().getText());
            classContext.define(node.getToken(), fieldDefinition);
        }
        return null;
    }
}
