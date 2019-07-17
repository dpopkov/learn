package learn.dsajg6e.ch07list.exer;

/**
 * Dynamic circular array with unbounded capacity.
 */
public class C0726CircularDynamicArrayList<E> extends C0725CircularArrayList<E> {
    protected static final int DEFAULT_CAPACITY = 16;

    public C0726CircularDynamicArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public C0726CircularDynamicArrayList(int capacity) {
        super(capacity);
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i);
        checkCapacity();
        super.add(i, e);
    }

    @Override
    public void add(E e) {
        checkCapacity();
        super.add(e);
    }

    @SuppressWarnings("unchecked")
    private void checkCapacity() {
        if (size == data.length) {
            E[] newData = (E[]) new Object[data.length * 2];
            int num1 = data.length - front;
            System.arraycopy(data, front, newData, 0, num1);
            if (front > 0) {
                System.arraycopy(data, 0, newData, num1, front);
            }
            data = newData;
            front = 0;
        }
    }

    private void checkIndex(int i) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
    }
}
