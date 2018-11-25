package learn.dsai.ch05.iterators;

import learn.dsai.ch05.doubly.DoublyLinkedList;
import learn.dsai.ch05.doubly.Link;

public class ListIterator {
    private Link current;
    private final DoublyLinkedList list;

    public ListIterator(DoublyLinkedList list) {
        this.list = list;
        reset();
    }

    /** Set to start of list. */
    public void reset() {
        current = list.getFirst();
    }

    /**
     * @return true if the iterator is at the last element
     */
    public boolean atEnd() {
        return current.next == null;
    }

    public void nextLink() {
        current = current.next;
    }

    public Link getCurrent() {
        return current;
    }

    public void insertAfter(long data) {
        if (list.isEmpty()) {
            list.insertFirst(data);
            current = list.getFirst();
        } else if (atEnd()) {
            list.insertLast(data);
            current = list.getLast();
        } else {
            Link link = new Link(data);
            link.next = current.next;
            link.prev = current;
            current.next.prev = link;
            current.next = link;
            nextLink();
        }
    }

    public void insertBefore(long data) {
        if (list.isEmpty()) {
            list.insertFirst(data);
            current = list.getFirst();
        } else if (current.prev == null) {
            list.insertFirst(data);
        } else {
            Link link = new Link(data);
            link.next = current;
            link.prev = current.prev;
            current.prev.next = link;
            current.prev = link;
        }
    }

    public long deleteCurrent() {
        long data = current.data;
        if (current.next == null) {
            list.deleteLast();
        } else if (current.prev == null) {
            list.deleteFirst();
        } else {
            current.next.prev = current.prev;
            current.prev.next = current.next;
        }
        current = current.next;
        return data;
    }
}
