package learn.dsajg6e.ch03fund.exer;

import learn.dsajg6e.ch03fund.linked.AbstractDoublyLinkedList;

/*
The previous implementation of a doubly linked list relies on two
sentinel nodes, header and trailer, but a single node that guards both ends
of the list should suffice.
 */
public class C0331OneSentinel<E> extends AbstractDoublyLinkedList<E> {
    private final Node<E> sentinel;

    public C0331OneSentinel() {
        sentinel = new Node<>();
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
    }

    @Override
    protected Node<E> firstNode() {
        return sentinel.getNext();
    }

    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return sentinel.getNext().getElement();
    }

    @Override
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return sentinel.getPrev().getElement();
    }

    @Override
    public void addFirst(E e) {
        addBetween(sentinel, sentinel.getNext(), e);
    }

    @Override
    public void addLast(E e) {
        addBetween(sentinel.getPrev(), sentinel, e);
    }

    private void addBetween(Node<E> before, Node<E> after, E e) {
        Node<E> n = new Node<>(e, after, before);
        before.setNext(n);
        after.setPrev(n);
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        return removeBetween(sentinel, sentinel.getNext().getNext());
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        return removeBetween(sentinel.getPrev().getPrev(), sentinel);
    }

    private E removeBetween(Node<E> before, Node<E> after) {
        Node<E> node = before.getNext();
        before.setNext(node.getNext());
        after.setPrev(node.getPrev());
        size--;
        return node.getElement();
    }
}
