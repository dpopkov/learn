package learn.ijpds2nd.ch10oop;

import java.util.Arrays;

public class StackOfIntegers {
    private int[] elements;
    private int size;

    public StackOfIntegers(int capacity) {
        elements = new int[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        return elements[size - 1];
    }

    public void push(int value) {
        ensureCapacity(size + 1);
        elements[size++] = value;
    }

    private void ensureCapacity(int newCapacity) {
        if (elements.length < newCapacity) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    public int pop() {
        return elements[--size];
    }

    public int size() {
        return size;
    }
}
