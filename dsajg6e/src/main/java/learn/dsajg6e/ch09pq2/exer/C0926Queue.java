package learn.dsajg6e.ch09pq2.exer;

import learn.dsajg6e.ch06stacks.Queue;
import learn.dsajg6e.ch09pq2.HeapPriorityQueue;

/**
 * C-9.26
 * Queue that uses a priority queue.
 */
public class C0926Queue<E> implements Queue<E> {
    private final HeapPriorityQueue<Long, E> queue = new HeapPriorityQueue<>();
    private long lastId = 0;

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        queue.insert(++lastId, e);
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
