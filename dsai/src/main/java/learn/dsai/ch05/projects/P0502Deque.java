package learn.dsai.ch05.projects;

import learn.dsai.ch04.projects.Deque;
import learn.dsai.ch05.doubly.DoublyLinkedList;

/**
 * Deque based on a doubly linked list.
 */
public class P0502Deque implements Deque {
    private final DoublyLinkedList list = new DoublyLinkedList();

    @Override
    public void insertLeft(long value) {
        list.insertFirst(value);
    }

    @Override
    public void insertRight(long value) {
        list.insertLast(value);
    }

    @Override
    public long removeLeft() {
        return list.deleteFirst();
    }

    @Override
    public long removeRight() {
        return list.deleteLast();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
