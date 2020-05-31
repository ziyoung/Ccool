package net.ziyoung.ccool.phase;

import net.ziyoung.ccool.antlr.CcoolBaseListener;
import net.ziyoung.ccool.antlr.CcoolParser;
import net.ziyoung.ccool.compiler.Compiler;
import net.ziyoung.ccool.scope.*;
import net.ziyoung.ccool.type.Types;
import net.ziyoung.ccool.type.Type;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

public class DefinePhase extends CcoolBaseListener {
    private final Compiler compiler;
    private final ParseTreeProperty<Scope> scopes = new ParseTreeProperty<>();
    private final GlobalScope globalScope = new GlobalScope();
    private Scope currentScope;

    public DefinePhase(Compiler compiler) {
        this.compiler = compiler;
    }

    private void saveScope(ParserRuleContext context, Scope scope) {
        scopes.put(context, scope);
    }

    private void afterExit() {
        currentScope = currentScope.getEnclosingScope();
    }

    private void defineVar(CcoolParser.TypeContext typeContext, String name) {
        String typeText = typeContext.getText();
        Type type = Types.textToType(typeText);
        Symbol symbol = new Symbol(type, name);
        currentScope.define(symbol);
    }

    public ParseTreeProperty<Scope> getScopes() {
        return scopes;
    }

    public GlobalScope getGlobalScope() {
        return globalScope;
    }

    @Override
    public void enterCompilationUnit(CcoolParser.CompilationUnitContext ctx) {
        currentScope = globalScope;
    }

    @Override
    public void enterMethodDeclaration(CcoolParser.MethodDeclarationContext ctx) {
        Token token = ctx.ID().getSymbol();
        String typeText = ctx.type().getText();
        Type type = Types.textToType(typeText);
        FunctionScope functionScope = new FunctionScope(type, token, currentScope);
        currentScope.define(functionScope);
        saveScope(ctx, functionScope);
        currentScope = functionScope;
    }

    @Override
    public void exitMethodDeclaration(CcoolParser.MethodDeclarationContext ctx) {
        afterExit();
    }

    @Override
    public void enterFormalParameters(CcoolParser.FormalParametersContext ctx) {
        if (currentScope instanceof FunctionScope) {
            FunctionScope functionScope = (FunctionScope) currentScope;
            // TODO: use stream to refactor.
            int index = 0;
            for (TerminalNode node : ctx.ID()) {
                String name = node.getText();
                if (functionScope.exist(node.getText())) {
                    compiler.error(node.getSymbol(), String.format("duplicated argument %s", name));
                } else {
                    defineVar(ctx.type(index), name);
                }
                index++;
            }
            return;
        }

        throw new RuntimeException("currentScope is not FunctionSymbolScope");
    }

    @Override
    public void enterBlock(CcoolParser.BlockContext ctx) {
        currentScope = new LocalScope(currentScope);
        saveScope(ctx, currentScope);
    }

    @Override
    public void exitBlock(CcoolParser.BlockContext ctx) {
        afterExit();
    }

    @Override
    public void exitVarDeclaration(CcoolParser.VarDeclarationContext ctx) {
        defineVar(ctx.type(), ctx.ID().getText());
    }
}
