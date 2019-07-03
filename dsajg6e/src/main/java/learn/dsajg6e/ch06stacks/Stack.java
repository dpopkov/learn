package learn.dsajg6e.ch06stacks;

/**
 * CF 6.1
 * A collection of objects that are pushed and popped according to the last-in
 * first-out principle (LIFO).
 * @param <E> type of the elements
 */
@SuppressWarnings("unused")
public interface Stack<E> {
    /** Returns the number of elements in the stack. */
    int size();

    /** Tests whether the stack is empty. */
    boolean isEmpty();

    /** Inserts an element to the top of the stack. */
    void push(E e);

    /** Returns, but does not remove, the element at the top of the stack. */
    E top();

    /** Removes and returns the element at the top of the stack. */
    E pop();
}
