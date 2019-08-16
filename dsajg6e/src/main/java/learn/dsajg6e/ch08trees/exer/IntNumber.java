package learn.dsajg6e.ch08trees.exer;

import java.util.Objects;
import java.util.regex.Pattern;

class IntNumber implements Expression {
    private static final Pattern numberPattern = Pattern.compile("\\d+");

    private final int value;

    public IntNumber(String value) {
        this(Integer.parseInt(value));
    }

    public IntNumber(int value) {
        this.value = value;
    }

    @Override
    public int value() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        return value == ((IntNumber) other).value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    static boolean isNumber(String s) {
        return numberPattern.matcher(s).matches();
    }
}
