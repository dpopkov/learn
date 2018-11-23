package learn.dsai.ch05.doubleend;

import java.util.StringJoiner;

public class FirstLastList {
    private Link first;
    private Link last;

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int data) {
        Link link = new Link(data);
        if (isEmpty()) {
            last = link;
        }
        link.next = first;
        first = link;
    }

    public void insertLast(int data) {
        Link link = new Link(data);
        if (isEmpty()) {
            first = link;
        } else {
            last.next = link;
        }
        last = link;
    }

    public int deleteFirst() {
        Link link = first;
        first = first.next;
        if (first == null) {
            last = null;
        }
        link.next = null;
        return link.data;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" ");
        for (Link current = first; current != null; current = current.next) {
            joiner.add(current.toString());
        }
        return joiner.toString();
    }
}
