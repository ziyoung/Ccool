package net.ziyoung.ccool.context;

import net.ziyoung.ccool.type.Type;

public class FieldDefinition implements Definition {
    private final Type type;
    private final String name;

    public FieldDefinition(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
