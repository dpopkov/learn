package learn.dsajg6e.ch07list.exer;

import learn.dsajg6e.ch07list.List;

/**
 * Abstract base class for random access lists that run {@code get(int)} method in constant time.
 */
public abstract class RandomAccessAbstractList<E> implements List<E> {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int length = size();
        if (length > 0) {
            sb.append(get(0));
            for (int i = 1; i < length; i++) {
                sb.append(", ");
                sb.append(get(i));
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
