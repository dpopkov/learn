package learn.dsajg6e.ch06stacks;

import java.util.Arrays;

/**
 * CF 6.2
 * Array-based implementation of the {@link Stack} interface.
 * @param <E> type of the elements
 */
@SuppressWarnings("unused")
public class ArrayStack<E> implements Stack<E>, Cloneable {
    public static final int DEFAULT_CAPACITY = 1000;
    private E[] data;
    private int topIdx = -1;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return topIdx + 1;
    }

    @Override
    public boolean isEmpty() {
        return topIdx == -1;
    }

    @Override
    public void push(E e) {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[++topIdx] = e;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return data[topIdx];
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E e = data[topIdx];
        data[topIdx] = null;
        topIdx--;
        return e;
    }

    /* Method clone() implemented as C-6.27 */
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        ArrayStack<E> cloned = null;
        try {
            cloned = (ArrayStack<E>) super.clone();
            cloned.data = Arrays.copyOf(this.data, this.data.length);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace(); // this should not happen
        }
        return cloned;
    }
}
