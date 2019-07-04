package learn.dsajg6e.ch06stacks;

import learn.dsajg6e.ch03fund.linked.CircularlyLinkedList;

public class LinkedCircularQueue<E> implements CircularQueue<E> {
    private final CircularlyLinkedList<E> data = new CircularlyLinkedList<>();

    @Override
    public void rotate() {
        data.rotate();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }

    @Override
    public E first() {
        return data.first();
    }

    @Override
    public E dequeue() {
        return data.removeFirst();
    }
}
