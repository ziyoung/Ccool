package net.ziyoung.ccool.context;

import net.ziyoung.ccool.ast.statement.MethodDeclaration;
import net.ziyoung.ccool.type.Type;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MethodContext extends LocalContext {
    private int localsSize;
    private final Type returnType;
    private final Map<String, VariableDefinition> parameterDefinitions = new LinkedHashMap<>();

    public MethodContext(MethodDeclaration owner, ClassContext classContext, Type returnType) {
        super(owner, classContext, classContext);
        this.returnType = returnType;
    }

    public int getLocalsSize() {
        return localsSize;
    }

    public void setLocalsSize(int localsSize) {
        this.localsSize = localsSize;
    }

    public Type getReturnType() {
        return returnType;
    }

    public List<VariableDefinition> getParameters() {
        return new ArrayList<>(parameterDefinitions.values());
    }

    public VariableDefinition resolveParameter(String name) {
        return parameterDefinitions.get(name);
    }

    public void defineParameter(Type type, String name) {
        int offset = nextOffset();
        parameterDefinitions.put(name, new VariableDefinition(type, offset));
    }

    @Override
    public Definition resolve(String name) {
        VariableDefinition variableDefinition = resolveParameter(name);
        if (variableDefinition != null) {
            return variableDefinition;
        }
        return classContext.resolve(name);
    }
}
