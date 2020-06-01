package net.ziyoung.ccool.context;

import net.ziyoung.ccool.type.Type;

public class VariableDefinition implements Definition {
    private final Type type;
    private final int offset;

    public VariableDefinition(Type type, int offset) {
        this.type = type;
        this.offset = offset;
    }

    @Override
    public Type getType() {
        return type;
    }

    public int getOffset() {
        return offset;
    }
}
