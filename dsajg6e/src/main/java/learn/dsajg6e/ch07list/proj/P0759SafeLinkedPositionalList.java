package learn.dsajg6e.ch07list.proj;

import learn.dsajg6e.ch07list.positional.AbstractPositionalList;
import learn.dsajg6e.ch07list.positional.Position;

public class P0759SafeLinkedPositionalList<E> extends AbstractPositionalList<E> {
    private final Node<E> headerSentinel;
    private final Node<E> trailerSentinel;

    public P0759SafeLinkedPositionalList() {
        headerSentinel = new Node<>(null, null, null);
        trailerSentinel = new Node<>(null, headerSentinel, null);
        headerSentinel.setNext(trailerSentinel);
    }

    @Override
    public Position<E> first() {
        return position(headerSentinel.getNext());
    }

    @Override
    public Position<E> last() {
        return position(trailerSentinel.getPrev());
    }

    @Override
    public Position<E> before(Position<E> p) {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException();
        }
        Node<E> n = (Node<E>) p;
        return position(n.getPrev());
    }

    @Override
    public Position<E> after(Position<E> p) {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException();
        }
        Node<E> n = (Node<E>) p;
        return position(n.getNext());
    }

    private Position<E> addBetween(Node<E> predecessor, Node<E> successor, E element) {
        Node<E> node = new Node<>(element, predecessor, successor);
        predecessor.setNext(node);
        successor.setPrev(node);
        size++;
        return node;
    }

    @Override
    public Position<E> addFirst(E element) {
        return addBetween(headerSentinel, headerSentinel.getNext(), element);
    }

    @Override
    public Position<E> addLast(E element) {
        return addBetween(trailerSentinel.getPrev(), trailerSentinel, element);
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(node.getPrev(), node, e);
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(node, node.getNext(), e);
    }

    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public int indexOf(Position<E> p) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Position<E> findPosition(E e) {
        throw new UnsupportedOperationException("Not implemented");
    }

    /** Validates the position and returns it as a node. */
    private Node<E> validate(Position<E> position) throws IllegalArgumentException {
        if (!(position instanceof Node)) {
            throw new IllegalArgumentException("Invalid position");
        }
        Node<E> node = (Node<E>) position;
        if (node.getContainingList() != P0759SafeLinkedPositionalList.this) {
            throw new IllegalArgumentException("Position from other list");
        }
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

    @SuppressWarnings("TypeParameterHidesVisibleType")
    protected class Node<E> implements Position<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        @SuppressWarnings("unchecked")
        public P0759SafeLinkedPositionalList<E> getContainingList() {
            return (P0759SafeLinkedPositionalList<E>) P0759SafeLinkedPositionalList.this;
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
