package learn.dsajg6e.ch03fund.exer;

import learn.dsajg6e.ch03fund.linked.AbstractDoublyLinkedList;

/*
Implement a circular version of a doubly linked list, without any sentinels,
that supports all the public behaviors of the original as well as two new update
methods, rotate() and rotateBackwards().
 */
public class C0332CircularDoublyLinkedList<E> extends AbstractDoublyLinkedList<E> {
    private Node<E> head;

    @Override
    protected Node<E> firstNode() {
        return head;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    @Override
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return head.getPrev().getElement();
    }

    @Override
    public void addFirst(E e) {
        if (isEmpty()) {
            head = new Node<>(e, null, null);
            head.setNext(head);
            head.setPrev(head);
        } else {
            head = new Node<>(e, head, head.getPrev());
        }
        size++;
    }

    @Override
    public void addLast(E e) {
        if (isEmpty()) {
            head = new Node<>(e, null, null);
            head.setNext(head);
            head.setPrev(head);
        } else {
            Node<E> node = new Node<>(e, head, head.getPrev());
            head.getPrev().setNext(node);
            head.setPrev(node);
        }
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> node = head;
        head = head.getNext();
        head.setPrev(node.getPrev());
        node.getPrev().setNext(head);
        size--;
        return node.getElement();
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> node = head.getPrev();
        head.setPrev(node.getPrev());
        node.getPrev().setNext(head);
        size--;
        return node.getElement();
    }

    public void rotate() {
        if (isEmpty()) {
            return;
        }
        head = head.getNext();
    }

    public void rotateBackward() {
        if (isEmpty()) {
            return;
        }
        head = head.getPrev();
    }
}
