package learn.dsajg6e.ch06stacks.exer;

import learn.dsajg6e.ch06stacks.Stack;

/**
 * When push is invoked with the stack at full capacity, the pushed element is accepted
 * at the top while the oldest element is "leaking" from the bottom to make room.
 * @param <E>
 */
public class P0638LeakyStack<E> implements Stack<E> {
    private final E[] data;
    private int size;
    private int bottom;

    @SuppressWarnings("unchecked")
    public P0638LeakyStack(int maximumCapacity) {
        data = (E[]) new Object[maximumCapacity];
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
    public void push(E e) {
        int newTop = (bottom + size) % data.length;
        if (size == data.length) {
            bottom = (bottom + 1) % data.length;
        }
        data[newTop] = e;
        size = Math.min(size + 1, data.length);
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        int top = (bottom + size - 1) % data.length;
        return data[top];
    }

    @Override
    public E pop() {
        int top = (bottom + size - 1) % data.length;
        E e = data[top];
        data[top] = null;
        size--;
        return e;
    }
}
