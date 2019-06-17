package learn.dsajg6e.ch03fund.linked;

/**
 * CF 3.17-18
 * @param <E>
 */
public class DoublyLinkedList<E> implements IDoublyList<E> {
    protected final Node<E> header;
    protected final Node<E> trailer;
    private int size;

    public DoublyLinkedList() {
        header = new Node<>();
        trailer = new Node<>();
        header.setNext(trailer);
        trailer.setPrev(header);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (size == 0) {
            return null;
        } else {
            return header.getNext().getElement();
        }
    }

    public E last() {
        if (size == 0) {
            return null;
        } else {
            return trailer.getPrev().getElement();
        }
    }

    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    public E removeFirst() {
        if (size == 0) {
            return null;
        }
        return remove(header.getNext());
    }

    public E removeLast() {
        if (size == 0) {
            return null;
        }
        return remove(trailer.getPrev());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if (size > 0) {
            Node<E> cur = header.getNext();
            sb.append(cur.getElement());
            for (int i = 1; i < size; i++) {
                cur = cur.getNext();
                sb.append(", ");
                sb.append(cur.getElement());
            }
        }
        sb.append(']');
        return sb.toString();
    }

    private void addBetween(E e, Node<E> before, Node<E> after) {
        Node<E> n = new Node<>(e, after, before);
        before.setNext(n);
        after.setPrev(n);
        size++;
    }

    private E remove(Node<E> n) {
        n.getPrev().setNext(n.getNext());
        n.getNext().setPrev(n.getPrev());
        size--;
        return n.getElement();
    }

    protected static class Node<E> {

        /** Element stored at this node. */
        private final E element;
        /** Previous node in the list. */
        private Node<E> prev;
        /** Subsequent node in the list. */
        private Node<E> next;

        private Node() {
            this.element = null;
        }

        private Node(E element, Node<E> next, Node<E> prev) {
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
    }
}
