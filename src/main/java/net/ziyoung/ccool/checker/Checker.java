package net.ziyoung.ccool.checker;

import net.ziyoung.ccool.ast.FunctionSymbolScope;
import net.ziyoung.ccool.ast.Symbol;
import net.ziyoung.ccool.ast.SymbolTable;
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
        if (!(symbol instanceof FunctionSymbolScope)) {
            compiler.error(null, "'main' is not a function.");
            return;
        }
        FunctionSymbolScope functionSymbol = (FunctionSymbolScope) symbol;
        if (!SymbolTable.isIntType(functionSymbol.getType())) {
            compiler.error(functionSymbol.getToken(), "return type of main is not int.");
        }
    }
}
