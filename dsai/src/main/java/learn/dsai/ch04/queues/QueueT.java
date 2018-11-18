package learn.dsai.ch04.queues;

/**
 * Textbook implementation of queue.
 */
public class QueueT extends AbstractArrayQueue implements Queue {
    private final int maxSize;

    public QueueT(int maxSize) {
        this.maxSize = maxSize;
        values = new long[maxSize];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public void insert(long value) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        values[++rear] = value;
        size++;
    }

    @Override
    public long remove() {
        long temp = values[front++];
        if (front == maxSize) {
            front = 0;
        }
        size--;
        return temp;
    }
}
