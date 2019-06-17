package learn.dsajg6e.ch03fund.linked;

public abstract class AbstractDoublyLinkedList<E> implements IDoublyList<E> {
    protected int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    protected abstract Node<E> firstNode();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if (size > 0) {
            Node<E> node = firstNode();
            sb.append(node.getElement());
            for (int i = 1; i < size; i++) {
                node = node.getNext();
                sb.append(", ");
                sb.append(node.getElement());
            }
        }
        sb.append(']');
        return sb.toString();
    }

    protected static class Node<E> {

        /** Element stored at this node. */
        private final E element;
        /** Previous node in the list. */
        private Node<E> prev;
        /** Subsequent node in the list. */
        private Node<E> next;

        public Node() {
            this.element = null;
        }

        public Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "(" + element + ")";
        }
    }
}
