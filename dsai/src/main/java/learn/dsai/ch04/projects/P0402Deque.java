package learn.dsai.ch04.projects;

import learn.dsai.ch04.queues.AbstractArrayQueue;

public class P0402Deque extends AbstractArrayQueue implements Deque {
    private static final int DEFAULT_SIZE = 10;

    public P0402Deque() {
        this(DEFAULT_SIZE);
    }

    public P0402Deque(int capacity) {
        super(capacity);
    }

    @Override
    public void insert(long value) {
        rear++;
        if (rear == values.length) {
            rear = 0;
        }
        values[rear] = value;
        size++;
    }

    @Override
    public long remove() {
        long value = values[front];
        front++;
        if (front == values.length) {
            front = 0;
        }
        size--;
        return value;
    }

    @Override
    public void insertLeft(long value) {
        front--;
        if (front < 0) {
            front = values.length - 1;
        }
        values[front] = value;
        size++;
    }

    @Override
    public void insertRight(long value) {
        insert(value);
    }

    @Override
    public long removeLeft() {
        return remove();
    }

    @Override
    public long removeRight() {
        long value = values[rear];
        rear--;
        if (rear < 0) {
            rear = values.length - 1;
        }
        size--;
        return value;
    }
}
