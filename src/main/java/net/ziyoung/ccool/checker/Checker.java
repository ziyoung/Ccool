package net.ziyoung.ccool.checker;

import net.ziyoung.ccool.ast.expression.Expression;
import net.ziyoung.ccool.context.MethodContext;
import net.ziyoung.ccool.context.VariableDefinition;

import java.util.List;

public class Checker {
    public static boolean checkArgumentsType(MethodContext methodContext, List<Expression> expressionList) {
        List<VariableDefinition> parameters = methodContext.getParameters();
        int parameterSize = parameters.size();
        int argumentSize = expressionList.size();
//        if (parameterSize != argumentSize) {
//        }
        return true;
    }
}
