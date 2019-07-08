package learn.dsajg6e.ch06stacks;

import learn.dsajg6e.ch03fund.linked.SinglyLinkedList;

public class LinkedQueue<E> implements Queue<E> {
    private final SinglyLinkedList<E> data = new SinglyLinkedList<>();

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

    /* Implemented for exercise C-6.29 */
    /**
     * Takes all elements from other queue and appends them to the end of this queue.
     * The other queue is empty after this operation.
     * @param other other queue
     */
    public void concatenate(LinkedQueue<E> other) {
        this.data.append(other.data);
    }
}
