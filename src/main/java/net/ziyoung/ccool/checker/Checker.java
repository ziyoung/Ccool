package net.ziyoung.ccool.checker;

import net.ziyoung.ccool.scope.FunctionScope;
import net.ziyoung.ccool.scope.Symbol;
import net.ziyoung.ccool.type.Types;
import net.ziyoung.ccool.compiler.Compiler;

public class Checker {
    private final Compiler compiler;

    public Checker(Compiler compiler) {
        this.compiler = compiler;
    }

    public void checkMainFunction(Symbol symbol) {
        if (symbol == null) {
            compiler.error(null, "No main function in global.");
            return;
        }
        if (!(symbol instanceof FunctionScope)) {
            compiler.error(null, "'main' is not a function.");
            return;
        }
        FunctionScope functionSymbol = (FunctionScope) symbol;
        if (!Types.isIntType(functionSymbol.getType())) {
            compiler.error(functionSymbol.getToken(), "return type of main is not int.");
        }
    }
}
