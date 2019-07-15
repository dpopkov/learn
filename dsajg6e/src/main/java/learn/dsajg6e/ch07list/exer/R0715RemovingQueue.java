package learn.dsajg6e.ch07list.exer;

import learn.dsajg6e.ch06stacks.Queue;
import learn.dsajg6e.ch07list.positional.LinkedPositionalList;
import learn.dsajg6e.ch07list.positional.Position;

/**
 * A queue in which entries may be deleted using method {@link #remove(Position)}
 * before they reach the front.
 * @param <E> type of elements in the queue
 */
public class R0715RemovingQueue<E> implements Queue<E> {
    private final LinkedPositionalList<E> data = new LinkedPositionalList<>();

    /** Returns the number of elements in the queue. */
    @Override
    public int size() {
        return data.size();
    }

    /** Tests whether the queue is empty. */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /** Inserts an element at the rear of the queue. */
    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }

    /** Inserts an element at the rear of the queue and returns position associated with the element. */
    public Position<E> enqueueWithPosition(E e) {
        return data.addLast(e);
    }

    /** Returns, but does not remove, the first element of the queue (null if empty). */
    @Override
    public E first() {
        return data.first().getElement();
    }

    /**
     * Removes and returns the first element of the queue (null if empty).
     */
    @Override
    public E dequeue() {
        return data.remove(data.first());
    }

    /** Removes the element associated with position p. */
    public void remove(Position<E> position) {
        data.remove(position);
    }
}
