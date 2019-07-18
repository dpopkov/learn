package learn.dsajg6e.ch07list.exer;

import learn.dsajg6e.ch06stacks.Queue;

public class C0735DynamicArrayQueue<E> implements Queue<E> {
    private E[] data;
    private int size;
    private int front;

    @SuppressWarnings("unchecked")
    public C0735DynamicArrayQueue(int initialCapacity) {
        data = (E[]) new Object[initialCapacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E element) {
        if (size == data.length) {
            resize(data.length * 2);
        }
        data[indexAt(size)] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] temp = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            temp[i] = data[indexAt(i)];
        }
        data = temp;
        front = 0;
    }

    @Override
    public E first() {
        return data[front];
    }

    @Override
    public E dequeue() {
        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return e;
    }

    private int indexAt(int position) {
        return (front + position) % data.length;
    }
}
