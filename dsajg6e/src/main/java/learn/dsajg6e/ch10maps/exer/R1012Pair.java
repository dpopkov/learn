package learn.dsajg6e.ch10maps.exer;

import java.util.Objects;

public class R1012Pair<A, B> {
    private final A first;
    private final B second;

    public R1012Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        R1012Pair other = (R1012Pair) obj;
        return ((first == null && other.getFirst() == null)
                    || first != null && first.equals(other.getFirst()))
                && ((second == null && other.getSecond() == null)
                    || second != null && second.equals(other.getSecond()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
