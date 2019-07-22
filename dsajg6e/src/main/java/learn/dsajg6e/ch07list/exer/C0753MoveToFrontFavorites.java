package learn.dsajg6e.ch07list.exer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Favorites list, with the move-to-front heuristic, such that elements that have not been accessed
 * in the most recent n accesses are automatically purged from the list.
 */
public class C0753MoveToFrontFavorites<E> {
    private final LinkedList<Item<E>> data = new LinkedList<>();
    private final int numberOfRecentAccesses;

    public C0753MoveToFrontFavorites(int numberOfRecentAccesses) {
        this.numberOfRecentAccesses = numberOfRecentAccesses;
    }

    public void access(E element) {
        traverseItems(element);
        data.addFirst(new Item<>(element, numberOfRecentAccesses));
    }

    private void traverseItems(E targetElement) {
        ListIterator<Item<E>> it = data.listIterator(data.size());
        while (it.hasPrevious()) {
            Item<E> item = it.previous();
            item.decrement();
            if (item.isToRemove() || item.getElement().equals(targetElement)) {
                it.remove();
            }
        }
    }

    public Iterable<E> getFavorites() {
        List<E> rst = new ArrayList<>();
        for (Item<E> item : data) {
            rst.add(item.getElement());
        }
        return rst;
    }

    public int size() {
        return data.size();
    }

    private static class Item<E> {
        private final E element;
        private int countDown;

        public Item(E element, int countDown) {
            this.element = element;
            this.countDown = countDown;
        }

        public E getElement() {
            return element;
        }

        public void decrement() {
            countDown--;
        }

        public boolean isToRemove() {
            return countDown == 0;
        }
    }
}
