package learn.dsai.ch05.adt.queue;

import learn.dsai.ch05.doubleend.FirstLastList;

public class LinkQueue {
    private FirstLastList list = new FirstLastList();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void insert(int value) {
        list.insertLast(value);
    }

    public int remove() {
        return list.deleteFirst();
    }

    public void display() {
        System.out.println("Queue (front-->rear): " + list);
    }
}
