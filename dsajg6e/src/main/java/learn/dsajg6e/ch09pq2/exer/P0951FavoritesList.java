package learn.dsajg6e.ch09pq2.exer;

import learn.dsajg6e.ch07list.positional.FavoritesList;
import learn.dsajg6e.ch07list.positional.LinkedPositionalList;
import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch09pq2.HeapPriorityQueue;
import learn.dsajg6e.ch09pq2.PriorityQueue;

import java.util.Comparator;

/**
 * Use the approach of either exercise C-9.39 or C-9.40 to re-implement the method
 * getFavorites of the FavoritesListMTF class from Section 7.7.2.
 * Make sure that results are generated from largest to smallest.
 */
public class P0951FavoritesList<E> extends FavoritesList<E> {
    /** Moves accessed item at Position p to the front of the list. */
    @Override
    protected void moveUp(Position<Item<E>> p) {
        if (p != list.first()) {
            list.addFirst(list.remove(p));
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<E> getFavorites(int k) {
        Item<E>[] items = (Item<E>[]) new Item[list.size()];
        int j = 0;
        for (Item<E> item : list) {
            items[j] = item;
            j++;
        }
        Comparator<Item<E>> comparator = (a, b) -> Integer.compare(b.getCount(), a.getCount());
        PriorityQueue<Item<E>, Item<E>> queue = new HeapPriorityQueue<>(comparator, items, items);
        LinkedPositionalList<E> result = new LinkedPositionalList<>();
        for (int i = 0; i < k; i++) {
            Item<E> item = queue.removeMin().getValue();
            result.addLast(item.getValue());
        }
        return result;
    }
}
