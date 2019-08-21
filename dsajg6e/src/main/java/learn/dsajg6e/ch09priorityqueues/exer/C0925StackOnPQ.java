package learn.dsajg6e.ch09priorityqueues.exer;

import learn.dsajg6e.ch06stacks.Stack;
import learn.dsajg6e.ch09priorityqueues.HeapPriorityQueue;

/** An implementation of Stack ADT that uses a priority queue. */
public class C0925StackOnPQ<E> implements Stack<E> {
    private final HeapPriorityQueue<Integer, E> queue = new HeapPriorityQueue<>();
    private int minKey;

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.size() == 0;
    }

    @Override
    public void push(E e) {
        queue.insert(--minKey, e);
    }

    @Override
    public E top() {
        return queue.min().getValue();
    }

    @Override
    public E pop() {
        return queue.removeMin().getValue();
    }
}
