package learn.dsajg6e.ch07list;

/**
 * Simple dynamic implementation of {@link List} with unbounded capacity.
 * @param <E> type of elements in the list
 */
public class ArrayList<E> implements List<E> {
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
}
