package learn.dsajg6e.ch03fund.exer;

import learn.dsajg6e.ch03fund.GameEntry;

public class P0338ScoresDoubleList {
    private static final int DEFAULT_LIMIT = 10;

    private final int limit;
    private final Node header;
    private final Node trailer;
    private int size;

    public P0338ScoresDoubleList() {
        this(DEFAULT_LIMIT);
    }

    public P0338ScoresDoubleList(int limit) {
        this.limit = limit;
        header = new Node(null, null, null);
        trailer = new Node(null, null, null);
        header.setNext(trailer);
        trailer.setPrev(header);
    }

    public int size() {
        return size;
    }

    public void add(GameEntry e) {
        Node current = header;
        int hops = 0;
        while (current.next != trailer && current.next.entry.getScore() > e.getScore()) {
            current = current.next;
            hops++;
        }
        if (hops < limit) {
            Node added = addAfter(current, e);
            if (size > limit) {
                trimToLimit(added, hops + 1);
            }
        }
    }

    private void trimToLimit(Node start, int nodePosition) {
        Node prev = start;
        for (int pos = nodePosition; pos < limit; pos++) {
            prev = prev.next;
        }
        prev.setNext(null);
        size = limit;
    }

    private Node addAfter(Node after, GameEntry entry) {
        Node next = after.next;
        Node newNode = new Node(entry, after, next);
        after.setNext(newNode);
        if (next != null) {
            next.setPrev(newNode);
        }
        size++;
        return newNode;
    }

    public void remove(int index) {
        if (index < size / 2) {
            Node prev = header;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            removeAfter(prev);
        } else {
            Node next = trailer;
            int numHops = size - index -1;
            for (int i = 0; i < numHops; i++) {
                next = next.prev;
            }
            removeBefore(next);
        }
        size--;
    }

    private void removeAfter(Node prev) {
        Node next = prev.next.next;
        prev.setNext(next);
        next.setPrev(prev);
    }

    private void removeBefore(Node next) {
        Node prev = next.prev.prev;
        prev.setNext(next);
        next.setPrev(prev);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if (size > 0) {
            Node node = header.next;
            sb.append(node.entry);
            for (int i = 1; i < size; i++) {
                node = node.next;
                sb.append(", ");
                sb.append(node.entry);
            }
        }
        sb.append(']');
        return sb.toString();
    }

    static class Node {
        private final GameEntry entry;
        private Node prev;
        private Node next;

        public Node(GameEntry entry, Node prev, Node next) {
            this.entry = entry;
            this.prev = prev;
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return entry.toString();
        }
    }
}
