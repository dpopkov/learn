package learn.hfdp.ch09iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DinnerMenuIterator implements Iterator<MenuItem> {
    private final MenuItem[] items;
    private final int size;
    private int position;

    public DinnerMenuIterator(MenuItem[] items, int size) {
        this.items = items;
        if (size > items.length) {
            throw new IllegalArgumentException("Size cannot be greater that length of the array");
        }
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return position < size;
    }


    /**
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public MenuItem next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return items[position++];
    }
}
