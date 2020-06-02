package net.ziyoung.ccool.context;

import net.ziyoung.ccool.ast.statement.Statement;

public class LocalContext extends Context {
    // index of local variable in stack.
    protected int offset;

    public LocalContext(Statement owner, Context enclosingContext, ClassContext classContext) {
        super(owner, enclosingContext, classContext, classContext.compilationUnitContext);
        initOffset(enclosingContext);
    }

    protected void initOffset(Context enclosingContext) {
        if (enclosingContext instanceof LocalContext) {
            offset = ((LocalContext) enclosingContext).getOffset();
        } else {
            offset = 0;
        }
    }

    public int getOffset() {
        return offset;
    }

    public int nextOffset() {
        return offset++;
    }

    @Override
    public String getContextName() {
        return "Local";
    }
}
