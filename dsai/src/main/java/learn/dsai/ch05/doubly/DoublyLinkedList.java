package learn.dsai.ch05.doubly;

import learn.dsai.ch05.iterators.ListIterator;

import java.util.StringJoiner;

public class DoublyLinkedList {
    private Link first;
    private Link last;

    public Link getFirst() {
        return first;
    }

    public Link getLast() {
        return last;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long data) {
        Link link = new Link(data);
        if (isEmpty()) {
            last = link;
        } else {
            first.prev = link;
        }
        link.next = first;
        first = link;
    }

    public void insertLast(long data) {
        Link link = new Link(data);
        if (isEmpty()) {
            first = link;
        } else {
            last.next = link;
        }
        link.prev = last;
        last = link;
    }

    public long deleteFirst() {
        Link link = first;
        first = first.next;
        if (first != null) {
            first.prev = null;
        } else {
            last = null;
        }
        return link.data;
    }

    public long deleteLast() {
        Link link = last;
        last = last.prev;
        if (last != null) {
            last.next = null;
        } else {
            first = null;
        }
        return link.data;
    }

    public boolean insertAfter(long key, long data) {
        Link current = first;
        while (current != null && current.data != key) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        Link link = new Link(data);
        link.prev = current;
        link.next = current.next;
        if (current == last) {
            last = link;
        } else {
            current.next.prev = link;
        }
        current.next = link;
        return true;
    }

    public Link deleteKey(long key) {
        Link current = first;
        while (current != null && current.data != key) {
            current = current.next;
        }
        if (current == null) {
            return null;
        }
        if (current == first) {
            first = first.next;
        } else {
            current.prev.next = current.next;
        }
        if (current == last) {
            last = current.prev;
        } else {
            current.next.prev = current.prev;
        }
        current.next = null;
        current.prev = null;
        return current;
    }

    public void displayForward() {
        System.out.println("List (first-->last): " + toString(true));
    }

    public void displayBackward() {
        System.out.println("List (last-->first): " + toString(false));
    }

    public ListIterator getIterator() {
        return new ListIterator(this);
    }

    @Override
    public String toString() {
        return toString(true);
    }

    public String toString(boolean forward) {
        StringJoiner joiner = new StringJoiner(" ", "[", "]");
        if (forward) {
            for (Link lnk = first; lnk != null; lnk = lnk.next) {
                joiner.add(Long.toString(lnk.data));
            }
        } else {
            for (Link lnk = last; lnk != null; lnk = lnk.prev) {
                joiner.add(Long.toString(lnk.data));
            }
        }
        return joiner.toString();
    }
}
