package learn.dsajg6e.ch09pq2.exer;

import learn.dsajg6e.ch06stacks.Stack;
import learn.dsajg6e.ch09pq2.Entry;
import learn.dsajg6e.ch09pq2.HeapPriorityQueue;

/**
 * C-9.25
 * Stack that uses a priority queue.
 */
public class C0925Stack<E> implements Stack<E> {
    private final HeapPriorityQueue<Integer, E> queue;
    private int lastId = 0;

    public C0925Stack() {
        queue  = new HeapPriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
    }

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
        queue.insert(++lastId, e);
    }

    @Override
    public E top() {
        return queue.min().getValue();
    }

    @Override
    public E pop() {
        Entry<Integer, E> entry = queue.removeMin();
        lastId--;
        return entry.getValue();
    }
}
