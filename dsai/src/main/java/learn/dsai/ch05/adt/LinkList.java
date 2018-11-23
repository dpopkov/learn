package learn.dsai.ch05.adt;

import java.util.StringJoiner;

public class LinkList {
    private Link first;

    public void insert(long value) {
        Link link = new Link(value);
        link.next = first;
        first = link;
    }

    public long delete() {
        Link link = first;
        first = first.next;
        return link.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" ");
        for (Link c = first; c != null; c = c.next) {
            joiner.add(c.toString());
        }
        return joiner.toString();
    }
}
