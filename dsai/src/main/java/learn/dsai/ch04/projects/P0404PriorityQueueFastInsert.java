package learn.dsai.ch04.projects;

import learn.dsai.ch04.queues.Queue;

import java.util.StringJoiner;

/**
 * Implements queue that has fast insertion time but slower removal
 * of high-priority item.
 */
public class P0404PriorityQueueFastInsert implements Queue {
    private final long[] values;
    private int size;

    public P0404PriorityQueueFastInsert(int capacity) {
        values = new long[capacity];
        size = 0;
    }

    @Override
    public boolean isFull() {
        return size == values.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(long value) {
        values[size++] = value;
    }

    @Override
    public long remove() {
        int min = findMin();
        long value = values[min];
        System.arraycopy(values, min + 1, values, min, size - min - 1);
        size--;
        return value;
    }

    @Override
    public long peekFront() {
        return values[findMin()];
    }

    private int findMin() {
        int minIdx = 0;
        long minValue = values[minIdx];
        for (int i = 1; i < size; i++) {
            if (values[i] < minValue) {
                minIdx = i;
                minValue = values[i];
            }
        }
        return minIdx;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            joiner.add(Long.toString(values[i]));
        }
        return joiner.toString();
    }
}
