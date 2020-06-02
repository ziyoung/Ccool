package net.ziyoung.ccool.context;

import net.ziyoung.ccool.ast.statement.ClassDeclaration;
import org.antlr.v4.runtime.Token;

import java.util.HashMap;
import java.util.Map;

public class ClassContext extends Context {
    private final Map<String, FieldDefinition> fields = new HashMap<>();
    private final Map<String, MethodDefinition> methods = new HashMap<>();

    public ClassContext(ClassDeclaration owner, CompilationUnitContext compilationUnitContext) {
        super(owner, compilationUnitContext, null, compilationUnitContext);
        this.classContext = this;
    }

    @Override
    public Definition resolve(String name) {
        if (fields.containsKey(name)) {
            return fields.get(name);
        }
        if (methods.containsKey(name)) {
            return methods.get(name);
        }
        return compilationUnitContext.resolve(name);
    }

    @Override
    public void define(Token token, Definition definition) {
        String name = token.getText();
        if (definition instanceof FieldDefinition) {
            fields.put(name, (FieldDefinition) definition);
        } else if (definition instanceof MethodDefinition) {
            methods.put(name, (MethodDefinition) definition);
        }
    }

    @Override
    public String getContextName() {
        return "Class";
    }
}
