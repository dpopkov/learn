package learn.dsai.ch11ht.chained;

import java.util.StringJoiner;

public class SortedList {
    private Link first;

    public void insert(Link link) {
        long key = link.getKey();
        Link prev = null;
        Link current = first;
        while (current != null && key > current.getKey()) {
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

    public Link delete(long key) {
        Link prev = null;
        Link link = first;
        while (link != null && link.getKey() != key) {
            prev = link;
            link = link.next;
        }
        if (link != null) {
            if (prev == null) {
                first = link.next;
            } else {
                prev.next = link.next;
            }
            link.next = null;
        }
        return link;
    }

    public Link find(long key) {
        Link lnk = first;
        while (lnk != null && lnk.getKey() <= key) {
            if (lnk.getKey() == key) {
                return lnk;
            }
            lnk = lnk.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        Link lnk = first;
        while (lnk != null) {
            joiner.add(lnk.toString());
            lnk = lnk.next;
        }
        return joiner.toString();
    }
}
