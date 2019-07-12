package learn.dsajg6e.ch07list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Simple dynamic implementation of {@link List} with unbounded capacity.
 * @param <E> type of elements in the list
 */
public class ArrayList<E> implements List<E>, Iterable<E> {
    public static final int CAPACITY = 16;
    private E[] data;
    private int size = 0;

    public ArrayList() {
        this(CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
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

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E replaced = data[i];
        data[i] = e;
        return replaced;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size + 1);
        ensureCapacity(size + 1);
        if (i < size) {
            System.arraycopy(data, i, data, i + 1, size - i);
        }
        data[i] = e;
        size++;
    }

    @Override
    public void add(E e) {
        ensureCapacity(size + 1);
        data[size++] = e;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E removed = data[i];
        System.arraycopy(data, i + 1, data, i, size - i - 1);
        size--;
        data[size] = null;
        return removed;
    }

    private void checkIndex(int i, int upperBound) {
        if (i < 0 || i >= upperBound) {
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }

    private void ensureCapacity(int capacity) {
        if (capacity > data.length) {
            resize(data.length * 2);
        }
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<E> {
        /** Index of the next element to report. */
        private int j = 0;
        /** Flag - can remove be called at this time? */
        private boolean removable = false;

        /**
         * Tests whether the iterator has a next object.
         * @return true if there are further objects, false otherwise
         */
        @Override
        public boolean hasNext() {
            return j < ArrayList.this.size;
        }

        /**
         * Returns the next object in the iterator.
         * @return next object
         * @throws NoSuchElementException if there are no further elements
         */
        @Override
        public E next() throws NoSuchElementException {
            if (j == ArrayList.this.size) {
                throw new NoSuchElementException("No next element");
            }
            removable = true;
            return ArrayList.this.data[j++];
        }

        /**
         * Removes the element returned by most recent call to next.
         * @throws IllegalStateException if next has not yet been called
         *                               or if remove was already called since recent next.
         */
        @Override
        public void remove() throws IllegalStateException {
            if (!removable) {
                throw new IllegalStateException("Nothing to remove");
            }
            ArrayList.this.remove(j - 1);
            j--;
            removable = false;
        }
    }
}
