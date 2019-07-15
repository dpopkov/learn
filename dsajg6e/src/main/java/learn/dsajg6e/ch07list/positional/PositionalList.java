package learn.dsajg6e.ch07list.positional;

/**
 * CF 7.8
 * An interface for positional lists.
 */
public interface PositionalList<E> {
    /** Returns the first position in the list (or null, if empty). */
    Position<E> first();

    /** Returns the last position in the list (or null, if empty). */
    Position<E> last();

    /** Returns the position immediately before position p (or null, if empty). */
    Position<E> before(Position<E> p);

    /** Returns the position immediately after position p (or null, if empty). */
    Position<E> after(Position<E> p);

    /** Tests whether the list is empty. */
    boolean isEmpty();

    /** Returns the number of elements in the list. */
    int size();

    /** Inserts element e at the front of the list and returns its new position. */
    Position<E> addFirst(E e);

    /** Inserts element e at the back of the list and returns its new position. */
    Position<E> addLast(E e);

    /** Inserts element e immediately before position p and returns its new position. */
    Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;

    /** Inserts element e immediately after position p and returns its new position. */
    Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;

    /** Replaces the element stored at position p and returns the replaced element. */
    E set(Position<E> p, E e) throws IllegalArgumentException;

    /** Removes the element stored at position p and returns it (invalidating p). */
    E remove(Position<E> p) throws IllegalArgumentException;

    /* R-7.12 */
    /** Returns the current index of the element stored at position p. */
    int indexOf(Position<E> p);

    /* R-7.13 */
    /** Returns the first position containing an element equal to e. */
    Position<E> findPosition(E e);

    /** Insertion sort of a list into non-decreasing order. */
    static <E extends Comparable<E>> void insertionSort(PositionalList<E> list) {
        if (list.size() < 2) {
            return;
        }
        Position<E> marker = list.first();
        while (marker != list.last()) {
            Position<E> pivot = list.after(marker);
            E value = pivot.getElement();
            if (value.compareTo(marker.getElement()) > 0) {
                marker = pivot;
            } else {
                Position<E> walk = marker;
                while (walk != list.first() && list.before(walk).getElement().compareTo(value) > 0) {
                    walk = list.before(walk);
                }
                list.remove(pivot);
                list.addBefore(walk, value);
            }
        }
    }
}
