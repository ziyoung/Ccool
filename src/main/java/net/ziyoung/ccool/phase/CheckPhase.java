package net.ziyoung.ccool.phase;

import net.ziyoung.ccool.antlr.CcoolBaseListener;
import net.ziyoung.ccool.antlr.CcoolParser;
import net.ziyoung.ccool.scope.FunctionScope;
import net.ziyoung.ccool.scope.GlobalScope;
import net.ziyoung.ccool.scope.Scope;
import net.ziyoung.ccool.scope.Symbol;
import net.ziyoung.ccool.checker.Checker;
import net.ziyoung.ccool.compiler.Compiler;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class CheckPhase extends CcoolBaseListener {
    private final Compiler compiler;
    private final ParseTreeProperty<Scope> scopes;
    private final GlobalScope globalScope;
    private Scope currentScope;
    private final Checker checker;

    public CheckPhase(Compiler compiler, ParseTreeProperty<Scope> scopes, GlobalScope globalScope) {
        this.compiler = compiler;
        this.scopes = scopes;
        this.globalScope = globalScope;
        checker = new Checker(compiler);
    }

    private void afterExit() {
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void enterCompilationUnit(CcoolParser.CompilationUnitContext ctx) {
        currentScope = globalScope;
        checker.checkMainFunction(currentScope.resolve("main"));
    }

    @Override
    public void enterMethodDeclaration(CcoolParser.MethodDeclarationContext ctx) {
        currentScope = scopes.get(ctx);
    }

    @Override
    public void exitMethodDeclaration(CcoolParser.MethodDeclarationContext ctx) {
        afterExit();
    }

    @Override
    public void enterBlock(CcoolParser.BlockContext ctx) {
        currentScope = scopes.get(ctx);
    }

    @Override
    public void exitBlock(CcoolParser.BlockContext ctx) {
        afterExit();
    }

    @Override
    public void exitVar(CcoolParser.VarContext ctx) {
        Token token = ctx.ID().getSymbol();
        String name = token.getText();
        Symbol symbol = currentScope.resolve(name);
        if (symbol == null) {
            compiler.error(token, "no such variable: " + name);
        }
        if (symbol instanceof FunctionScope) {
            compiler.error(token,  name + " is function but not a variable");
        }
    }
}
