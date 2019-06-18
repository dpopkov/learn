package learn.dsajg6e.ch03fund.exer;

import learn.dsajg6e.ch03fund.GameEntry;

/**
 * Maintains the top ten scores for a game applications, implementing the add and remove methods,
 * using a singly linked list.
 */
public class P0337ScoresList {
    private Node head;
    private int size;

    public void add(GameEntry e) {
        if (head == null || head.getEntry().getScore() <= e.getScore()) {
            head = new Node(e, head);
        } else {
            Node prev = head;
            Node newNode = new Node(e);
            do {
                Node next = prev.getNext();
                if (next == null) {
                    prev.setNext(newNode);
                    break;
                } else if (next.getEntry().getScore() <= e.getScore()) {
                    newNode.setNext(next);
                    prev.setNext(newNode);
                    break;
                }
                prev = next;
            } while (true);
        }
        size++;
    }

    public boolean remove(GameEntry e) {
        if (size == 0) {
            return false;
        }
        if (head.getEntry().equals(e)) {
            head = head.getNext();
            size--;
            return true;
        }
        Node prev = head;
        while (prev.getNext() != null && !prev.getNext().getEntry().equals(e)) {
            prev = prev.getNext();
        }
        if (prev.getNext() != null) {
            prev.setNext(prev.getNext().getNext());
            size--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Node n = head;
        if (n != null) {
            sb.append(n.getEntry());
            for (int i = 1; i < size; i++) {
                n = n.next;
                sb.append(", ");
                sb.append(n.getEntry());
            }
        }
        sb.append(']');
        return sb.toString();
    }

    static class Node {
        private final GameEntry entry;
        private Node next;

        public Node(GameEntry entry) {
            this.entry = entry;
        }

        public Node(GameEntry entry, Node next) {
            this.entry = entry;
            this.next = next;
        }

        public GameEntry getEntry() {
            return entry;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        @Override
        public String toString() {
            return entry.toString();
        }
    }
}
