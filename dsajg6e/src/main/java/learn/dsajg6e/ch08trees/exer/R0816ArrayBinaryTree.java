package learn.dsajg6e.ch08trees.exer;

import java.util.Arrays;

public class R0816ArrayBinaryTree<E> {
    private final E[] data;
    private int size;
    private int maxIndex;

    @SuppressWarnings("unchecked")
    public R0816ArrayBinaryTree(int capacity) {
        this.data = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public E root() {
        return data[0];
    }

    public E parent(int k) {
        return data[(k - 1) / 2];
    }

    public E left(int k) {
        return data[k * 2 + 1];
    }

    public E right(int k) {
        return data[k * 2 + 2];
    }

    public boolean isExternal(int k) {
        return left(k) == null && right(k) == null;
    }

    public void add(int k, E value) {
        if (size == data.length) {
            throw new IllegalStateException("Tree is full");
        }
        data[k] = value;
        size++;
        maxIndex = Math.max(maxIndex, k);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, maxIndex + 1));
    }
}
