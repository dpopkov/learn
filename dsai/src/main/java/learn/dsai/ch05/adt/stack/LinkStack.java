package learn.dsai.ch05.adt.stack;

import learn.dsai.ch05.adt.LinkList;

public class LinkStack {
    private LinkList list = new LinkList();

    public void push(long value) {
        list.insert(value);
    }

    public long pop() {
        return list.delete();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void display() {
        System.out.println("Stack (top-->bottom): " + list);
    }
}
