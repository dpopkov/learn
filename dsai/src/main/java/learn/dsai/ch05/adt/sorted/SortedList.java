package learn.dsai.ch05.adt.sorted;

import learn.dsai.ch05.adt.Link;

import java.util.StringJoiner;

/**
 * Sorted single linked list that stores elements of type {@code long} in
 * ascending order.
 */
public class SortedList {
    private Link first;

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(long value) {
        Link link = new Link(value);
        Link prev = null;
        Link current = first;
        while (current != null && value > current.data) {
            prev = current;
            current = current.next;
        }
        if (prev == null) {
            first = link;
        } else {
            prev.next = link;
        }
        link.next = current;
    }

    public long remove() {
        Link link = first;
        first = first.next;
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

    public void display() {
        System.out.println("List (first-->last): " + toString());
    }
}
