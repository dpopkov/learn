package learn.dsajg6e.ch06stacks.exer;

import learn.dsajg6e.ch06stacks.Deque;
import learn.dsajg6e.ch06stacks.Stack;

/*
Give a simple adapter that implements the stack ADT while using an instance of
a deque for storage.
 */
@SuppressWarnings("unused")
public class R0610StackOnDeque<E> implements Stack<E> {
    private final Deque<E> deque;

    public R0610StackOnDeque(Deque<E> deque) {
        this.deque = deque;
    }

    @Override
    public int size() {
        return deque.size();
    }

    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public void push(E e) {
        deque.addLast(e);
    }

    @Override
    public E top() {
        return deque.last();
    }

    @Override
    public E pop() {
        return deque.removeLast();
    }
}
