package learn.dsajg6e.ch03fund.linked;

/**
 * CF 3.14-15
 * @param <E>
 */
@SuppressWarnings("unused")
public class SinglyLinkedList<E> implements Cloneable {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SinglyLinkedList<?> that = (SinglyLinkedList<?>) obj;
        if (size != that.size) {
            return false;
        }
        Node<E> cur1 = head;
        Node<?> cur2 = that.head;
        while (cur1 != null) {
            if (!cur1.getElement().equals(cur2.getElement())) {
                return false;
            }
            cur1 = cur1.getNext();
            cur2 = cur2.getNext();
        }
        return true;
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("Method hashCode is not implemented yet");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        @SuppressWarnings("unchecked")
        SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone();
        if (head != null) {
            Node<E> newNode = new Node<>(head.getElement(), null);
            other.head = newNode;
            Node<E> walk = head.getNext();
            Node<E> destPrev = other.head;
            while (walk != null) {
                newNode = new Node<>(walk.getElement(), null);
                destPrev.setNext(newNode);
                destPrev = newNode;
                walk = walk.getNext();
            }
            other.tail = newNode;
        }
        return other;
    }

    private static class Node<E> {
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
