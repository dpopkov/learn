package learn.dsajg6e.ch03fund.linked;

/**
 * My research implementation of a singly linked list.
 * @param <E>
 */
public class MyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public int size() {
        return size;
    }

    public void add(E element) {
        Node<E> node = new Node<>(element);
        node.next = head;
        if (head == null) {
            tail = node;
        }
        head = node;
        size++;
    }

    public void addLast(E element) {
        Node<E> node = new Node<>(element);
        if (tail != null) {
            tail.next = node;
        } else {
            head = node;
        }
        tail = node;
        size++;
    }

    public E tail() {
        return tail.element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (head != null) {
            sb.append(head);
            Node<E> n = head.next;
            while (n != null) {
                sb.append(", ");
                sb.append(n);
                n = n.next;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
        System.out.println("list.tail = " + list.tail());
        list.addLast("aTail");
        System.out.println(list);
        System.out.println("list.tail = " + list.tail());
    }

    public E remove() {
        Node<E> n = head;
        E element = n.element;
        head = head.next;
        n.element = null;
        n.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return element;
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }
}
