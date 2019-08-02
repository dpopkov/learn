package learn.dsajg6e.ch08trees.exer;

public class IntElement implements Int {
    private int value;

    public IntElement(int value) {
        this.value = value;
    }

    @Override
    public int getInt() {
        return value;
    }

    @Override
    public void setInt(int intValue) {
        value = intValue;
    }

    @Override
    public String toString() {
        return "IntElement{" + value + '}';
    }

    public static IntElement zero() {
        return new IntElement(0);
    }
}
