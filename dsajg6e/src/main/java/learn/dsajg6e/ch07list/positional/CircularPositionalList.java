package learn.dsajg6e.ch07list.positional;

public interface CircularPositionalList<E> extends PositionalList<E> {
    /** Moves the first element to the end of the list. */
    void rotate();
}
