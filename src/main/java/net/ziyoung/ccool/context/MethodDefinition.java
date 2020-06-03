package net.ziyoung.ccool.context;

import net.ziyoung.ccool.error.SemanticErrors;
import net.ziyoung.ccool.type.Type;
import org.antlr.v4.runtime.Token;

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

    public void checkCallArguments(Token token, List<Type> types) {
        int parameterSize = parameters.size();
        int argumentSize = types.size();
        if (parameterSize != argumentSize) {
            SemanticErrors.error(token, String.format("function %s needs %d parameters but gets %d", token.getText(), parameterSize, argumentSize));
            return;
        }
        for (int i = 0; i < argumentSize; i++) {
            Type type = parameters.get(i).getType();
            Type type1 = types.get(i);
            if (type != null && type1 != null && !type1.equals(type)) {
                SemanticErrors.error(token, String.format("argument %d expected type is %s but got %s", i, type, type1));
            }
        }
    }
}
