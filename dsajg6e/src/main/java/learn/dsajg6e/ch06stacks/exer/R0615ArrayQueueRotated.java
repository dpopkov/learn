package learn.dsajg6e.ch06stacks.exer;

import learn.dsajg6e.ch06stacks.ArrayQueue;
import learn.dsajg6e.ch06stacks.CircularQueue;

/*
Augment the ArrayQueue implementation with a new rotate() method having
semantics identical to the combination, enqueue(dequeue()).
 */
public class R0615ArrayQueueRotated<E> extends ArrayQueue<E> implements CircularQueue<E> {
    public R0615ArrayQueueRotated(int capacity) {
        super(capacity);
    }

    @Override
    public void rotate() {
        if (isEmpty()) {
            return;
        }
        E e = data[front];
        data[front] = null;
        int next = (front + size) % data.length;
        front = (front + 1) % data.length;
        data[next] = e;
    }
}
