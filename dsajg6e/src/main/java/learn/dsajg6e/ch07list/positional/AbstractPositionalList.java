package learn.dsajg6e.ch07list.positional;

public abstract class AbstractPositionalList<E> implements PositionalList<E> {
    protected int size;

    /** Tests whether the list is empty. */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the number of elements in the list. */
    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if (size > 0) {
            Position<E> pos = first();
            sb.append(pos.getElement());
            for (int i = 1; i < size; i++) {
                pos = after(pos);
                sb.append(", ");
                sb.append(pos.getElement());
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
