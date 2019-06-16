package learn.dsajg6e.ch03fund.exer;

public class C0328ReverseList {
    private Node head;

    public void add(long value) {
        head = new Node(value, head);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if (head != null) {
            sb.append(head.value);
            Node current = head.getNext();
            while (current != null) {
                sb.append(", ");
                sb.append(current.value);
                current = current.getNext();
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node currentNext = current.next;
            current.next = prev;
            prev = current;
            current = currentNext;
        }
        head = prev;
    }

    static class Node {
        private final long value;
        private Node next;

        public Node(long value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        @Override
        public String toString() {
            return "(" + value + ")";
        }
    }
}
