package learn.dsajg6e.ch07list;

/**
 * Simple implementation of {@link List} with bounded capacity.
 * @param <E> type of elements in the list
 */
public class ArrayList<E> implements List<E> {
    public static final int CAPACITY = 16;
    private final E[] data;
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
        checkSize();
        if (i < size) {
            System.arraycopy(data, i, data, i + 1, size - i);
        }
        data[i] = e;
        size++;
    }

    @Override
    public void add(E e) {
        checkSize();
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

    private void checkSize() {
        if (size == data.length) {
            throw new IllegalStateException("Array is full");
        }
    }
}
