package learn.dsajg6e.ch06stacks;

import learn.dsajg6e.ch03fund.linked.SinglyLinkedList;

import java.util.Objects;

public class LinkedQueue<E> implements Queue<E> {
    private final SinglyLinkedList<E> data = new SinglyLinkedList<>();

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }

    @Override
    public E first() {
        return data.first();
    }

    @Override
    public E dequeue() {
        return data.removeFirst();
    }

    /* Implemented for exercise C-6.29 */
    /**
     * Takes all elements from other queue and appends them to the end of this queue.
     * The other queue is empty after this operation.
     * @param other other queue
     */
    public void concatenate(LinkedQueue<E> other) {
        this.data.append(other.data);
    }

    /** Constructs an instance of {@code LinkedQueue} using the specified sequence of elements. */
    @SafeVarargs
    public static <K> LinkedQueue<K> from(K... elements) {
        LinkedQueue<K> queue = new LinkedQueue<>();
        for (K element : elements) {
            queue.enqueue(element);
        }
        return queue;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LinkedQueue<?> that = (LinkedQueue<?>) obj;
        return data.equals(that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
