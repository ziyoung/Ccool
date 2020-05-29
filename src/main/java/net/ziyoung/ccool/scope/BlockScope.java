package net.ziyoung.ccool.scope;

public class BlockScope extends BaseScope {
    public BlockScope(Scope enclosingScope) {
        super(enclosingScope);
    }

    @Override
    public String getScopeName() {
        return "block";
    }
}
