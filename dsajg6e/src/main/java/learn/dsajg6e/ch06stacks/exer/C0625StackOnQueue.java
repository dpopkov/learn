package learn.dsajg6e.ch06stacks.exer;

import learn.dsajg6e.ch06stacks.LinkedCircularQueue;
import learn.dsajg6e.ch06stacks.Queue;
import learn.dsajg6e.ch06stacks.Stack;

/**
 * Stack implementation using a single queue;
 */
public class C0625StackOnQueue<E> implements Stack<E> {
    private final Queue<E> queue = new LinkedCircularQueue<>();

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void push(E e) {
        queue.enqueue(e);
        int n = queue.size() - 1;
        for (int i = 0; i < n; i++) {
            E tmp = queue.dequeue();
            queue.enqueue(tmp);
        }
    }

    @Override
    public E top() {
        return queue.first();
    }

    @Override
    public E pop() {
        return queue.dequeue();
    }
}
