package learn.ijpds2nd.tools;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private final T[] elements;
    private final int numElements;
    private int currentIdx;

    public ArrayIterator(T[] elements, int numElements) {
        this.elements = elements;
        this.numElements = numElements;
    }

    @Override
    public boolean hasNext() {
        return currentIdx < numElements;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return elements[currentIdx++];
    }
}
