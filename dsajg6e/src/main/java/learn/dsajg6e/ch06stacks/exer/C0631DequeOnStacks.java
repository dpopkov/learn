package learn.dsajg6e.ch06stacks.exer;

import learn.dsajg6e.ch06stacks.Deque;
import learn.dsajg6e.ch06stacks.LinkedStack;
import learn.dsajg6e.ch06stacks.Stack;

public class C0631DequeOnStacks<E> implements Deque<E> {
    private final Stack<E> st1 = new LinkedStack<>();
    private final Stack<E> st2 = new LinkedStack<>();

    @Override
    public int size() {
        return st1.size() + st2.size();
    }

    @Override
    public boolean isEmpty() {
        return st1.isEmpty() && st2.isEmpty();
    }

    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        if (st2.isEmpty()) {
            move(st1, st2);
        }
        return st2.top();
    }

    @Override
    public E last() {
        if (isEmpty()) {
            return null;
        }
        if (st1.isEmpty()) {
            move(st2, st1);
        }
        return st1.top();
    }

    @Override
    public void addFirst(E e) {
        move(st1, st2);
        st1.push(e);
        move(st1, st2);
    }

    @Override
    public void addLast(E e) {
        move(st2, st1);
        st2.push(e);
        move(st2, st1);
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (st2.isEmpty()) {
            move(st1, st2);
        }
        return st2.pop();
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (st1.isEmpty()) {
            move(st2, st1);
        }
        return st1.pop();
    }

    private void move(Stack<E> from, Stack<E> to) {
        while (!from.isEmpty()) {
            to.push(from.pop());
        }
    }
}
