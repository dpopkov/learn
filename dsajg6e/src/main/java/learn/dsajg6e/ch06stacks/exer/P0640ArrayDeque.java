package learn.dsajg6e.ch06stacks.exer;

import learn.dsajg6e.ch06stacks.Deque;

/**
 * Implementation of the {@link Deque} ADT using a fixed-sized array.
 * @param <E> type of elements in the deque
 */
public class P0640ArrayDeque<E> implements Deque<E> {
    private final E[] data;
    private int size;
    private int front;

    @SuppressWarnings("unchecked")
    public P0640ArrayDeque(int capacity) {
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

    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return data[front];
    }

    @Override
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return data[backIndex()];
    }

    @Override
    public void addFirst(E element) {
        if (isFull()) {
            throw new IllegalStateException("Deque is full");
        }
        front = (front - 1 + data.length) % data.length;
        data[front] = element;
        size++;
    }

    @Override
    public void addLast(E element) {
        if (isFull()) {
            throw new IllegalStateException("Deque is full");
        }
        int back = backIndex();
        back = (back + 1) % data.length;
        data[back] = element;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E element = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return element;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        int back = backIndex();
        E element = data[back];
        data[back] = null;
        size--;
        return element;
    }

    private int backIndex() {
        return (front + size - 1) % data.length;
    }
}
