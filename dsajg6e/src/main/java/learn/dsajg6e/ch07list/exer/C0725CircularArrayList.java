package learn.dsajg6e.ch07list.exer;

/**
 * Array-based list implementation with fixed capacity, treating the array
 * circularly so that it achieves O(1) time for insertions and removals at index 0, as
 * well as insertions and removals at the end of the array list.
 */
public class C0725CircularArrayList<E> extends RandomAccessAbstractList<E> {
    protected E[] data;
    protected int front;

    @SuppressWarnings("unchecked")
    public C0725CircularArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i);
        return data[position(i)];
    }

    protected int position(int index) {
        return (front + index) % data.length;
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i);
        return data[position(i)] = e;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkSize();
        if (i == 0) {
            front = (front - 1 + data.length) % data.length;
            data[front] = e;
        } else {
            int numShifted = size - i;
            for (int k = numShifted; k > 0; k--) {
                int targetIdx = i + k;
                int sourceIdx = targetIdx - 1;
                int targetPos = position(targetIdx);
                int sourcePos = position(sourceIdx);
                data[targetPos] = data[sourcePos];
            }
            int pos = position(i);
            data[pos] = e;
        }
        size++;
    }

    @Override
    public void add(E e) {
        checkSize();
        data[position(size++)] = e;
    }

    private void checkIndex(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
    }

    private void checkSize() {
        if (size == data.length) {
            throw new IllegalStateException("Array list is full");
        }
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i);
        int pos = position(i);
        E e = data[pos];
        data[pos] = null;
        if (i == 0) {
            front = (front + 1) % data.length;
        } else if (i < size - 1) {
            int numShifted = size - i - 1;
            for (int k = 0; k < numShifted; k++) {
                int target = i + k;
                int source = target + 1;
                int targetPos = position(target);
                int sourcePos = position(source);
                data[targetPos] = data[sourcePos];
            }
            data[position(i + numShifted)] = null;
        }
        size--;
        return e;
    }
}
