package learn.dsai.ch04.queues;

import java.util.StringJoiner;

/**
 * Textbook no-count implementation of queue.
 */
public class QueueNC implements Queue {
    private final long[] values;
    private int front;
    private int rear;
    private final int maxSize;

    public QueueNC(int size) {
        maxSize = size + 1;
        values = new long[maxSize];
        front = 0;
        rear = -1;
    }

    @Override
    public boolean isFull() {
        return rear + 2 == front || front + maxSize - 2 == rear;
    }

    @Override
    public boolean isEmpty() {
        return rear + 1 == front || front + maxSize - 1 == rear;
    }

    @Override
    public void insert(long value) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        values[++rear] = value;
    }

    @Override
    public long remove() {
        long temp = values[front++];
        if (front == maxSize) {
            front = 0;
        }
        return temp;
    }

    @Override
    public long peekFront() {
        return values[front];
    }

    @Override
    public int size() {
        if (rear >= front) {
            return rear - front + 1;
        } else {
            return (maxSize - front) + (rear + 1);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        int idx = front;
        int size = size();
        for (int j = 0; j < size; j++) {
            joiner.add(Long.toString(values[idx]));
            idx++;
            idx = idx == values.length ? 0 : idx;
        }
        return joiner.toString();
    }
}
