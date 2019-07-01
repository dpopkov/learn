package learn.dsajg6e.ch05recursion.exer;

public class C0525ReverseLinkedList {
    static Node reverse(Node head) {
        Node newHead = reverse(head, head.next);
        head.next = null;
        return newHead;
    }

    private static Node reverse(Node prev, Node next) {
        if (next == null) {
            return prev;
        }
        Node oldNext = next.next;
        next.next = prev;
        return reverse(next, oldNext);
    }

    static class Node {
        final long value;
        Node next;

        public Node(long value) {
            this(value, null);
        }

        public Node(long value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "(" + value + ")";
        }
    }

    static String listToString(Node head) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(head.toString());
        Node node = head.next;
        while (node != null) {
            sb.append(", ");
            sb.append(node.toString());
            node = node.next;
        }
        sb.append(']');
        return sb.toString();
    }
}
