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
    private CompilationUnitContext compilationUnitContext;
    private ClassContext classContext;

    @Override
    public Void visitCompilationUnit(CompilationUnit node, Context context) {
        CompilationUnitContext compilationUnitContext = new CompilationUnitContext(node);
        for (PrimaryType primaryType : Types.getPrimaryTypes()) {
            compilationUnitContext.definePrimaryType(primaryType);
        }
        for (ClassDeclaration declaration : node.getDeclarations()) {
            visitClassDeclaration(declaration, compilationUnitContext);
        }
        this.compilationUnitContext = compilationUnitContext;
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
            return null;
        }

        Type type = Types.createUserDefinedType(name);
        compilationUnitContext.defineUserType(token, type);
        ClassContext classContext = new ClassContext(node, compilationUnitContext);
        this.classContext = classContext;

        for (Statement declaration : node.getMembers()) {
            if (declaration instanceof VariableDeclaration) {
                visitVariableDeclaration((VariableDeclaration) declaration, classContext);
            } else if (declaration instanceof MethodDeclaration) {
                visitMethodDeclaration((MethodDeclaration) declaration, classContext);
            }
        }

        // Restore classContext.
        this.classContext = null;
        return null;
    }

    @Override
    public Void visitMethodDeclaration(MethodDeclaration node, Context context) {
        boolean invalid = context instanceof ClassContext;
        if (invalid) {
            MethodContext methodContext = new MethodContext(node, classContext, compilationUnitContext);
            for (Parameter parameter : node.getParameters()) {
                visitParameter(parameter, methodContext);
            }
            node.setContext(methodContext);
        } else {
            SemanticErrors.error(node.getToken(), "function is allowed to declare in a Class");
        }
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
                SemanticErrors.error(typeName.getToken(), String.format("type %s is not defined", typeName.getName()));
            } else {
                int offset = classContext.nextOffset();
                VariableDefinition variableDefinition = new VariableDefinition(type, offset);
                classContext.define(node.getToken(), variableDefinition);
            }
        }
        return null;
    }
}
