package learn.dsai.ch04.queues;

import java.util.StringJoiner;

/**
 * My implementation of queue.
 */
public abstract class AbstractArrayQueue implements Queue {
    protected long[] values;
    protected int rear;
    protected int front;
    protected int size;

    public boolean isFull() {
        return size == values.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public long peekFront() {
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
