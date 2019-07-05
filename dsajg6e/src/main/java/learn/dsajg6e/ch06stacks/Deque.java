package learn.dsajg6e.ch06stacks;

/**
 * Interface for a double-ended queue.
 * Elements can be inserted and removed at both ends.
 */
public interface Deque<E> {
    int size();

    boolean isEmpty();

    E first();

    E last();

    void addFirst(E e);

    void addLast(E e);

    E removeFirst();

    E removeLast();
}
