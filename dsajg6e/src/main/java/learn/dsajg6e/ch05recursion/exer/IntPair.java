package learn.dsajg6e.ch05recursion.exer;

import java.util.Objects;

public class IntPair {
    public final int x;
    public final int y;

    public IntPair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        IntPair intPair = (IntPair) obj;
        return x == intPair.x && y == intPair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
