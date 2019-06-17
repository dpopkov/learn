package learn.dsajg6e.ch03fund.linked;

/**
 * CF 3.16
 * @param <E>
 */
public class CircularlyLinkedList<E> {
    protected Node<E> tail;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (tail == null) {
            return null;
        } else {
            return tail.getNext().getElement();
        }
    }

    public E last() {
        if (tail == null) {
            return null;
        } else {
            return tail.getElement();
        }
    }

    public void addFirst(E e) {
        if (tail != null) {
            tail.setNext(new Node<>(e, tail.getNext()));
        } else {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        }
        size++;
    }

    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    public E removeFirst() {
        if (tail == null) {
            return null;
        }
        E element = tail.getNext().getElement();
        if (size == 1) {
            tail = null;
        } else {
            tail.setNext(tail.getNext().getNext());
        }
        size--;
        return element;
    }

    /** Moves the first element to the end of the list. */
    public void rotate() {
        if (tail != null) {
            tail = tail.getNext();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (tail != null) {
            Node<E> n = tail.next;
            sb.append(n.getElement());
            for (int i = 1; i < size; i++) {
                n = n.next;
                sb.append(", ");
                sb.append(n.getElement());
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // R-3.15
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CircularlyLinkedList<?> that = (CircularlyLinkedList<?>) obj;
        if (size != that.size) {
            return false;
        }
        Node<E> n0 = this.tail.getNext();
        Node<?> n1 = that.tail.getNext();
        for (int i = 0; i < size && n0 != null && n1 != null; i++) {
            if (!n0.getElement().equals(n1.getElement())) {
                return false;
            }
            n0 = n0.getNext();
            n1 = n1.getNext();
        }
        return true;
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("Method hashCode is not implemented yet");
    }

    protected static class Node<E> {
        /** Element stored at this node. */
        private final E element;
        /** Subsequent node in the list. */
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
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
    }
}
