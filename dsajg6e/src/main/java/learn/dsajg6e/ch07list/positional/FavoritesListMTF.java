package learn.dsajg6e.ch07list.positional;

/**
 * CF 7.18
 * Maintains a list of elements ordered with move-to-front heuristic.
 */
public class FavoritesListMTF<E> extends FavoritesList<E> {
    /** Moves accessed item at Position p to the front of the list. */
    @Override
    protected void moveUp(Position<Item<E>> p) {
        if (p != list.first()) {
            list.addFirst(list.remove(p));
        }
    }

    /** Returns an iterable collection of the k most frequently accessed elements. */
    @Override
    public Iterable<E> getFavorites(int k) {
        if (k < 0 || list.size() < k) {
            throw new IllegalArgumentException("Invalid k: " + k);
        }
        PositionalList<Item<E>> temp = new LinkedPositionalList<>();
        for (Item<E> item : list) {
            temp.addLast(item);
        }
        LinkedPositionalList<E> result = new LinkedPositionalList<>();
        for (int i = 0; i < k; i++) {
            Position<Item<E>> highPos = temp.first();
            Position<Item<E>> walk = temp.after(highPos);
            while (walk != null) {
                if (count(walk) > count(highPos)) {
                    highPos = walk;
                }
                walk = temp.after(walk);
            }
            result.addLast(value(highPos));
            temp.remove(highPos);
        }
        return result;
    }
}
