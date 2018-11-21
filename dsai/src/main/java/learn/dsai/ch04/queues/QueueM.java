package learn.dsai.ch04.queues;

import java.util.NoSuchElementException;

/**
 * My implementation of queue.
 */
public class QueueM extends AbstractArrayQueue implements Queue {
    public QueueM(int capacity) {
        super(capacity);
    }

    public void insert(long value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = nextIndex(rear);
        values[rear] = value;
        size++;
    }

    public long remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        long value = values[front];
        front = nextIndex(front);
        size--;
        return value;
    }

    private int nextIndex(int index) {
        return (index == values.length - 1) ? 0 : index + 1;
    }
}
