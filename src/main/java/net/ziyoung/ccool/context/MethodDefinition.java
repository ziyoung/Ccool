package net.ziyoung.ccool.context;

import net.ziyoung.ccool.type.Type;

import java.util.List;

public class MethodDefinition implements Definition {
    private final Type returnType;
    private final List<VariableDefinition> parameters;

    public MethodDefinition(Type returnType, List<VariableDefinition> parameters) {
        this.returnType = returnType;
        this.parameters = parameters;
    }

    public Type getReturnType() {
        return returnType;
    }

    public List<VariableDefinition> getParameters() {
        return parameters;
    }

    @Override
    public Type getType() {
        return null;
    }
}
