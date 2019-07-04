package learn.dsajg6e.ch06stacks;

/**
 * CF 6.9
 * Defines the queue ADT, with a standard first-in first-out (FIFO) protocol for insertions and removals.
 * @param <E> type of the elements
 */
public interface Queue<E> {
    /** Returns the number of elements in the queue. */
    int size();
    /** Tests whether the queue is empty. */
    boolean isEmpty();
    /** Inserts an element at the rear of the queue. */
    void enqueue(E e);
    /** Returns, but does not remove, the first element of the queue (null if empty). */
    E first();
    /** Removes and returns the first element of the queue (null if empty). */
    E dequeue();
}
