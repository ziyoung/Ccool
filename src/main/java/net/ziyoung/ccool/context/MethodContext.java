package net.ziyoung.ccool.context;

import net.ziyoung.ccool.ast.statement.MethodDeclaration;
import net.ziyoung.ccool.type.Type;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MethodContext extends LocalContext {
    private final Type returnType;
    private final Map<String, VariableDefinition> definitionMap = new LinkedHashMap<>();

    public MethodContext(MethodDeclaration owner, ClassContext classContext, Type returnType) {
        super(owner, classContext, classContext);
        this.returnType = returnType;
    }

    public Type getReturnType() {
        return returnType;
    }

    public List<VariableDefinition> getParameters() {
        return new ArrayList<>(definitionMap.values());
    }

    public VariableDefinition resolveParameter(String name) {
        return definitionMap.get(name);
    }

    public void defineParameter(Type type, String name) {
        int offset = this.nextOffset();
        definitionMap.put(name, new VariableDefinition(type, offset));
    }
}
