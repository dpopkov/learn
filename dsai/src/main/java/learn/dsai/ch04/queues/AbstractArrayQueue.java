package learn.dsai.ch04.queues;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * My implementation of queue.
 */
public abstract class AbstractArrayQueue implements Queue {
    protected long[] values;
    protected int rear;
    protected int front;
    protected int size;

    public AbstractArrayQueue(int capacity) {
        values = new long[capacity];
        rear = -1;
        front = 0;
        size = 0;
    }

    public boolean isFull() {
        return size == values.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public long peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return values[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        int idx = front;
        for (int j = 0; j < size; j++) {
            joiner.add(Long.toString(values[idx]));
            idx++;
            idx = idx == values.length ? 0 : idx;
        }
        return joiner.toString();
    }
}
