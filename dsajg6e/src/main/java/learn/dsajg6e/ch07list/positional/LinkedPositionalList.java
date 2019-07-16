package learn.dsajg6e.ch07list.positional;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * CF 7.9-7.12
 * Implementation of a positional list stored as a doubly linked list.
 * @param <E> type of elements in the list
 */
public class LinkedPositionalList<E> implements PositionalList<E>, Iterable<E> {
    private final Node<E> headerSentinel;
    private final Node<E> trailerSentinel;
    private int size;

    public LinkedPositionalList() {
        headerSentinel = new Node<>(null, null, null);
        trailerSentinel = new Node<>(null, headerSentinel, null);
        headerSentinel.setNext(trailerSentinel);
    }

    /** Returns the first position in the list (or null, if empty). */
    @Override
    public Position<E> first() {
        return position(headerSentinel.getNext());
    }

    /** Returns the last position in the list (or null, if empty). */
    @Override
    public Position<E> last() {
        return position(trailerSentinel.getPrev());
    }

    /** Returns the position immediately before position p (or null, if empty). */
    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    /** Returns the position immediately after position p (or null, if empty). */
    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    /** Tests whether the list is empty. */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the number of elements in the list. */
    @Override
    public int size() {
        return size;
    }

    /** Inserts element e at the front of the list and returns its new position. */
    @Override
    public Position<E> addFirst(E e) {
        return addBetween(e, headerSentinel, headerSentinel.getNext());
    }

    /** Inserts element e at the back of the list and returns its new position. */
    @Override
    public Position<E> addLast(E e) {
        return addBetween(e, trailerSentinel.getPrev(), trailerSentinel);
    }

    /** Inserts element e immediately before position p and returns its new position. */
    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    /** Inserts element e immediately after position p and returns its new position. */
    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    /** Replaces the element stored at position p and returns the replaced element. */
    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E replaced = node.getElement();
        node.setElement(e);
        return replaced;
    }

    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        successor.setPrev(predecessor);
        predecessor.setNext(successor);
        size--;
        E removed = node.getElement();
        node.setNext(null);
        node.setNext(null);
        node.setPrev(null);
        return removed;
    }

    /* R-7.12 */
    /**
     * Returns the current index of the element stored at position p.
     * @param p position of the element
     */
    @Override
    public int indexOf(Position<E> p) {
        Node<E> node = validate(p);
        Node<E> current = headerSentinel.getNext();
        int index = 0;
        while (current != trailerSentinel && current != node) {
            current = current.getNext();
            index++;
        }
        if (current == node) {
            return index;
        } else {
            return -1;
        }
    }

    /* R-7.13 */
    /**
     * Returns the first position containing an element equal to e or null if not found.
     * @param e element
     */
    @Override
    public Position<E> findPosition(E e) {
        Position<E> pos = first();
        while (pos != null && !pos.getElement().equals(e)) {
            pos = after(pos);
        }
        return pos;
    }

    private Position<E> addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> node = new Node<>(e, predecessor, successor);
        predecessor.setNext(node);
        successor.setPrev(node);
        size++;
        return node;
    }

    /** Validates the position and returns it as a node. */
    private Node<E> validate(Position<E> position) throws IllegalArgumentException {
        if (!(position instanceof Node)) {
            throw new IllegalArgumentException("Invalid position");
        }
        Node<E> node = (Node<E>) position;
        if (node.getNext() == null) {
            throw new IllegalArgumentException("position is no longer in the list");
        }
        return node;
    }

    /** Returns the given node as a Position (or null, if it is a sentinel). */
    private Position<E> position(Node<E> node) {
        if (node == headerSentinel || node == trailerSentinel) {
            return null;
        }
        return node;
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    /** Returns an iterable representation o the list's positions. */
    public Iterable<Position<E>> positions() {
        return new PositionIterable();
    }

    /** Adapts the iteration produced by {@link #positions()} to return elements. */
    protected class ElementIterator implements Iterator<E> {
        private final Iterator<Position<E>> posIterator = new PositionIterator();

        @Override
        public boolean hasNext() {
            return posIterator.hasNext();
        }

        @Override
        public E next() throws NoSuchElementException {
            return posIterator.next().getElement();
        }

        @Override
        public void remove() throws IllegalStateException {
            posIterator.remove();
        }
    }

    private class PositionIterable implements Iterable<Position<E>> {
        @Override
        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }
    }

    private class PositionIterator implements Iterator<Position<E>> {
        /** Position of the next element to report. */
        private Position<E> cursor = LinkedPositionalList.this.first();
        /** Position of last reported element. */
        private Position<E> recent = null;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Position<E> next() {
            if (cursor == null) {
                throw new NoSuchElementException("Nothing left");
            }
            recent = cursor;
            cursor = LinkedPositionalList.this.after(cursor);
            return recent;
        }

        @Override
        public void remove() throws IllegalStateException {
            if (recent == null) {
                throw new IllegalStateException("Nothing to remove");
            }
            LinkedPositionalList.this.remove(recent);
            recent = null;
        }

        @Override
        public String toString() {
            return "(" + cursor + ")";
        }
    }

    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public E getElement() throws IllegalStateException {
            if (next == null) {
                throw new IllegalStateException("Position no longer valid");
            }
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{element=" + element + '}';
        }
    }
}
