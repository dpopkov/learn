package learn.dsajg6e.ch03fund.linked;

/**
 * CF 3.14-15
 * @param <E>
 */
@SuppressWarnings("unused")
public class SinglyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> n = new Node<>(e, null);
        if (size == 0) {
            head = n;
        } else {
            tail.setNext(n);
        }
        tail = n;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E e = head.element;
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return e;
    }

    private static class Node<E> {
        /** Element stored at this node. */
        private E element;
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
