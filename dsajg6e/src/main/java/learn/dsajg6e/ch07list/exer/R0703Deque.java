package learn.dsajg6e.ch07list.exer;

import learn.dsajg6e.ch06stacks.Deque;
import learn.dsajg6e.ch07list.ArrayList;
import learn.dsajg6e.ch07list.List;

/** Implementation of the deque ADT using an array list for storage. */
public class R0703Deque<E> implements Deque<E> {
    private final List<E> data = new ArrayList<>();

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public E first() {
        return data.get(0);
    }

    @Override
    public E last() {
        return data.get(lastIndex());
    }

    @Override
    public void addFirst(E e) {
        data.add(0, e);
    }

    @Override
    public void addLast(E e) {
        data.add(e);
    }

    @Override
    public E removeFirst() {
        return data.remove(0);
    }

    @Override
    public E removeLast() {
        return data.remove(lastIndex());
    }

    private int lastIndex() {
        return data.size() - 1;
    }
}
