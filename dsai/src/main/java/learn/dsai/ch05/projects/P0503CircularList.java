package learn.dsai.ch05.projects;

import learn.dsai.ch05.adt.Link;

import java.util.StringJoiner;

public class P0503CircularList {
    private Link current;
    private int size;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return current == null;
    }

    /**
     * Inserts value after the current link.
     * If the list is empty then the inserted link becomes current.
     * @param value value to insert
     */
    public void insert(long value) {
        Link link = new Link(value);
        if (isEmpty()) {
            current = link;
            link.next = link;
        } else {
            link.next = current.next;
            current.next = link;
        }
        size++;
    }

    public Link search(long key) {
        if (isEmpty()) {
            return null;
        }
        Link found = null;
        Link lnk = current;
        do {
            if (lnk.data == key) {
                found = lnk;
                break;
            }
            lnk = lnk.next;
        } while (lnk != current);
        return found;
    }

    public boolean deleteBy(long key) {
        if (isEmpty()) {
            return false;
        }
        Link prev = null;
        Link lnk = current;
        do {
            if (lnk.data == key) {
                if (prev == null) {     // first or single
                    prev = findPrevious(lnk);
                    if (prev == lnk) {  // single
                        current = null;
                    } else {            // first
                        prev.next = lnk.next;
                        current = lnk.next;
                    }
                } else {
                    prev.next = lnk.next;
                }
                lnk.next = null;
                size--;
                return true;
            }
            prev = lnk;
            lnk = lnk.next;
        } while (lnk != current);
        return false;
    }

    /**
     * Deletes value after the current node.
     * @return deleted value
     */
    public long delete() {
        Link link = current.next;
        if (link == current) {
            current = null;
        } else {
            current.next = current.next.next;
        }
        link.next = null;
        size--;
        return link.data;
    }

    /** Moves the current link along to the next link. */
    public void step() {
        checkEmptiness();
        current = current.next;
    }

    public long getCurrent() {
        checkEmptiness();
        return current.data;
    }

    private Link findPrevious(Link start) {
        Link prev = start;
        Link lnk = start.next;
        while (lnk != start) {
            prev = lnk;
            lnk = lnk.next;
        }
        return prev;
    }

    private void checkEmptiness() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }
        StringJoiner joiner = new StringJoiner(" ");
        Link lnk = current;
        do {
            joiner.add(Long.toString(lnk.data));
            lnk = lnk.next;
        } while (lnk != current);
        return joiner.toString();
    }
}
