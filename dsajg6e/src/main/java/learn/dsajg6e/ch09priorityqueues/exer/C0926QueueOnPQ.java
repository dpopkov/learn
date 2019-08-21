package learn.dsajg6e.ch09priorityqueues.exer;

import learn.dsajg6e.ch06stacks.Queue;
import learn.dsajg6e.ch09priorityqueues.HeapPriorityQueue;

/** An implementation of Queue ADT that uses a priority queue. */
public class C0926QueueOnPQ<E> implements Queue<E> {
    private final HeapPriorityQueue<Integer, E> queue = new HeapPriorityQueue<>();
    private int lastKey;

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.size() == 0;
    }

    @Override
    public void enqueue(E e) {
        queue.insert(lastKey++, e);
    }

    @Override
    public E first() {
        return queue.min().getValue();
    }

    @Override
    public E dequeue() {
        return queue.removeMin().getValue();
    }
}
