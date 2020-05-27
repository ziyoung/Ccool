package net.ziyoung.ccool.ast;

public class BlockScope extends BaseScope {
    public BlockScope(Scope enclosingScope) {
        super(enclosingScope);
    }

    @Override
    public String getScopeName() {
        return "block";
    }
}
