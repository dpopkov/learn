package learn.dsajg6e.ch07list;

import java.util.Arrays;
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
        if (i == size) {
            ensureCapacity(size + 1);
        } else if (i < size) {
            if (size + 1 > data.length) {
                /* Improved resizing so that the elements are copied into their final place
                in the new array (R-7.9). */
                resizeWidthGapForInsert(increasedCapacity(), i);
            } else {
                System.arraycopy(data, i, data, i + 1, size - i);
            }
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
        /* C-7.29 */
        checkForShrinking();
        return removed;
    }

    /* C-7.29 */
    private void checkForShrinking() {
        if (size < data.length / 4) {
            resize(data.length / 2);
        }
    }

    /* R-7.18 */
    /** Checks whether this list contains the specified value. */
    public boolean contains(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    /* R-7.19 */
    /** Removes oll elements from the list. */
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    /* Implemented as R-7.5 */
    /** Trims the capacity of the list to the current size. */
    public void trimToSize() {
        if (size < data.length) {
            data = Arrays.copyOf(data, size);
        }
    }

    /* C-.52 */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if (size > 1) {
            sb.append(data[0]);
            for (int i = 1; i < size; i++) {
                sb.append(", ");
                sb.append(data[i]);
            }
        }
        sb.append(']');
        return sb.toString();
    }

    /** Checks that the index is in the range from 0 to the specified upperBound (exclusive). */
    private void checkIndex(int i, int upperBound) {
        if (i < 0 || i >= upperBound) {
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }

    private void ensureCapacity(int capacity) {
        if (capacity > data.length) {
            resize(increasedCapacity());
        }
    }

    private int increasedCapacity() {
        return data.length * 2;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        System.arraycopy(data, 0, temp, 0, size);
        data = temp;
    }

    @SuppressWarnings("unchecked")
    private void resizeWidthGapForInsert(int capacity, int newElementIdx) {
        E[] temp = (E[]) new Object[capacity];
        System.arraycopy(data, 0, temp, 0, newElementIdx);
        System.arraycopy(data, newElementIdx, temp, newElementIdx + 1, data.length - newElementIdx);
        data = temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    /* Returns capacity of the list for testing purposes */
    int getCapacity() {
        return data.length;
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
