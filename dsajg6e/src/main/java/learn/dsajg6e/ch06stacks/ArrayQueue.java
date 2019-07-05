package learn.dsajg6e.ch06stacks;

/**
 * CF 6.10
 * Array based implementation of a {@link Queue} interface.
 * @param <E> the type of elements held in this queue
 */
public class ArrayQueue<E> implements Queue<E> {
    protected final E[] data;
    /** Index of the front element. */
    protected int front;
    /** Number of elements in the queue. */
    protected int size;

    @SuppressWarnings("unchecked")
    protected ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (size == data.length) {
            throw new IllegalStateException("Queue is full");
        }
        int next = (front + size) % data.length;
        data[next] = e;
        size++;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return data[front];
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E element = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return element;
    }
}
