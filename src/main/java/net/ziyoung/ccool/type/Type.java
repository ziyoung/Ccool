package net.ziyoung.ccool.type;

public class Type {
    private final String name;
    private final int index;

    public Type(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public Type() {
        name = null;
        index = Types.tInvalid;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public boolean canAssignTo(Type destType) {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Type) {
            String name = ((Type) obj).getName();
            int index = ((Type) obj).getIndex();
            return getName().equals(name) && getIndex() == index;
        }
        return false;
    }
}
