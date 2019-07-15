package learn.dsajg6e.ch07list.exer;

import learn.dsajg6e.ch06stacks.Stack;
import learn.dsajg6e.ch07list.ArrayList;
import learn.dsajg6e.ch07list.List;

/** Implementation of the stack ADT using an array list for storage. */
public class R0702Stack<E> implements Stack<E> {
    private final List<E> data = new ArrayList<>();

    /**
     * Returns the number of elements in the stack.
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * Tests whether the stack is empty.
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Inserts an element to the top of the stack.
     * @param e element to push
     */
    @Override
    public void push(E e) {
        data.add(e);
    }

    /**
     * Returns, but does not remove, the element at the top of the stack.
     */
    @Override
    public E top() {
        return data.get(lastIndex());
    }

    /**
     * Removes and returns the element at the top of the stack.
     */
    @Override
    public E pop() {
        return data.remove(lastIndex());
    }

    private int lastIndex() {
        return data.size() - 1;
    }
}
