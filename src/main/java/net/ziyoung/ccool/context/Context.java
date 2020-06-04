package net.ziyoung.ccool.context;

import net.ziyoung.ccool.ast.Node;
import net.ziyoung.ccool.error.SemanticErrors;
import net.ziyoung.ccool.type.Type;
import org.antlr.v4.runtime.Token;

import java.util.HashMap;
import java.util.Map;

public abstract class Context {
    protected Node owner;
    protected Context enclosingContext;
    protected ClassContext classContext;
    protected CompilationUnitContext compilationUnitContext;

    protected Map<String, Definition> definitions = new HashMap<>();

    public Context(Node owner, Context enclosingContext, ClassContext classContext, CompilationUnitContext compilationUnitContext) {
        this.owner = owner;
        this.enclosingContext = enclosingContext;
        this.classContext = classContext;
        this.compilationUnitContext = compilationUnitContext;
    }

    public void define(Token token, Definition definition) {
        String name = token.getText();
        if (definitions.containsKey(name)) {
            SemanticErrors.error(token, String.format("variable %s has been defined", name));
            return;
        }
        definitions.put(name, definition);
    }

    public void define(String name, Definition definition) {
        definitions.put(name, definition);
    }

    public Definition resolve(String name) {
        Definition definition = definitions.get(name);
        if (definition != null) {
            return definition;
        }
        if (enclosingContext != null) {
            return enclosingContext.resolve(name);
        }
        return null;
    }

    public Type resolveType(String name) {
        TypeDefinition typeDefinition = (TypeDefinition) compilationUnitContext.resolve(name);
        return typeDefinition == null ? null : typeDefinition.getType();
    }

    public MethodDefinition resolveMethod(String name) {
        return (MethodDefinition) classContext.resolve(name);
    }

    public Node getOwner() {
        return owner;
    }

    public ClassContext getClassContext() {
        return classContext;
    }

    public abstract String getContextName();
}
