package net.ziyoung.ccool.phase;

import net.ziyoung.ccool.ast.AstBaseVisitor;
import net.ziyoung.ccool.ast.CompilationUnit;
import net.ziyoung.ccool.ast.statement.ClassDeclaration;
import net.ziyoung.ccool.ast.statement.MethodDeclaration;
import net.ziyoung.ccool.ast.statement.VariableDeclaration;
import net.ziyoung.ccool.context.CompilationUnitContext;
import net.ziyoung.ccool.context.Context;
import net.ziyoung.ccool.error.SemanticErrors;
import net.ziyoung.ccool.type.Type;
import net.ziyoung.ccool.type.TypeName;

public class AnalysePhase extends AstBaseVisitor<Void, Context> {

    @Override
    public Void visitCompilationUnit(CompilationUnit node, Context context) {
        CompilationUnitContext compilationUnitContext = node.getContext();
        for (ClassDeclaration declaration : node.getDeclarations()) {
            visitStatement(declaration, compilationUnitContext);
        }
        return null;
    }

    @Override
    public Void visitMethodDeclaration(MethodDeclaration node, Context context) {
        return super.visitMethodDeclaration(node, context);
    }

    @Override
    public Void visitVariableDeclaration(VariableDeclaration node, Context context) {
        TypeName typeName = node.getTypeName();
        Type type = typeName.resolve(context);
        if (type == null) {
            SemanticErrors.error(typeName.getToken(), String.format("Type %s is not defined", typeName.getName()));
        }
//        if (context instanceof LocalContext) {
//            int offset = ((LocalContext) context).getOffset();
//            return null;
//        }
//
//        if (context instanceof CompilationUnitContext) {
//            int offset = ((CompilationUnitContext) context);
//        }

//        VariableDefinition variableDefinition = new VariableDefinition(node.getTypeName())
//        context.define();
        return null;
    }
}
