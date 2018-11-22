package learn.dsai.ch05.lists;

import java.util.StringJoiner;

public class LinkList {
    private Link first;

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int iData, double dData) {
        Link link = new Link(iData, dData);
        link.next = first;
        first = link;
    }

    public Link deleteFirst() {
        Link result = first;
        first = first.next;
        result.next = null;
        return result;
    }

    public Link find(int key) {
        Link current = first;
        while (current != null) {
            if (current.iData == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public Link delete(int key) {
        Link prev = null;
        Link current = first;
        Link found = null;
        while (current != null) {
            if (current.iData == key) {
                found = current;
                if (current == first) {
                    first = first.next;
                } else {
                    prev.next = current.next;
                }
                found.next = null;
                break;
            }
            prev = current;
            current = current.next;
        }
        return found;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" ");
        Link current = first;
        while (current != null) {
            joiner.add(current.toString());
            current = current.next;
        }
        return joiner.toString();
    }

    public void display() {
        System.out.println("List (first-->last): " + toString());
    }
}
