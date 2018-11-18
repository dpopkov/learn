package learn.dsai.ch04.queues;

import java.util.StringJoiner;

public class PriorityQueue implements Queue {
    private final long[] values;
    private int size;

    public PriorityQueue(int capacity) {
        values = new long[capacity];
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
        int i;
        for (i = size - 1; i >= 0 && values[i] < value; i--) {
                values[i + 1] = values[i];
        }
        values[i + 1] = value;
        size++;
    }

    @Override
    public long remove() {
        return values[--size];
    }

    @Override
    public long peekFront() {
        return values[size - 1];
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
