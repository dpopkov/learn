package learn.dsajg6e.ch07list.exer;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Implementation of a sparse array that uses list where each entry keeps index of the element
 * and the element itself.
 * @param <E> type elements stored in the array
 */
public class C0747SparseArray<E> {
    private final LinkedList<PositionInArray<E>> list;
    private final int length;

    public C0747SparseArray(int length) {
        this.length = length;
        list = new LinkedList<>();
    }

    public int length() {
        return length;
    }

    public void set(int i, E e) {
        checkIndex(i);
        ListIterator<PositionInArray<E>> it = list.listIterator();
        boolean modified = false;
        while (it.hasNext()) {
            PositionInArray<E> pos = it.next();
            if (pos.getIndex() == i) {
                pos.setElement(e);
                modified = true;
            } else if (pos.getIndex() > i) {
                PositionInArray<E> posBefore = new PositionInArray<>(i, e);
                it.previous();
                it.add(posBefore);
                it.next();
                modified = true;
            }
        }
        if (!modified) {
            PositionInArray<E> pos = new PositionInArray<>(i, e);
            list.addLast(pos);
        }
    }

    public E get(int i) {
        checkIndex(i);
        for (PositionInArray<E> pos : list) {
            if (pos.getIndex() == i) {
                return pos.getElement();
            } else if (pos.getIndex() > i) {
                return null;
            }
        }
        return null;
    }

    private void checkIndex(int i) {
        if (i < 0 || length <= i) {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
    }
}
