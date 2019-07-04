package learn.dsajg6e.ch06stacks;

import learn.dsajg6e.ch03fund.linked.IList;
import learn.dsajg6e.ch03fund.linked.SinglyLinkedList;

public class LinkedQueue<E> implements Queue<E> {
    private final IList<E> data = new SinglyLinkedList<>();

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
