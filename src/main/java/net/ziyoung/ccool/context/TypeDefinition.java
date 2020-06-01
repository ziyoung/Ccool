package net.ziyoung.ccool.context;

import net.ziyoung.ccool.type.Type;

public class TypeDefinition implements Definition {
    private final Type type;

    public TypeDefinition(Type type) {
        this.type = type;
    }

    @Override
    public Type getType() {
        return type;
    }
}
