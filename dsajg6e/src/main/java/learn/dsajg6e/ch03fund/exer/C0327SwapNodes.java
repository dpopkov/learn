package learn.dsajg6e.ch03fund.exer;

import learn.dsajg6e.ch03fund.linked.SinglyLinkedList;

public class C0327SwapNodes<E> extends SinglyLinkedList<E> {
    void swap(Node<E> x, Node<E> y) {
        if (x == y) {
            return;
        }
        Node<E> prevX = null;
        Node<E> prevY;
        if (x != head) {
            prevX = head;
            while (prevX.getNext() != x) {
                prevX = prevX.getNext();
            }
        }
        prevY = head;
        while (prevY.getNext() != y) {
            prevY = prevY.getNext();
        }
        Node<E> yNext = y.getNext();
        Node<E> xNext = x.getNext();
        if (prevX != null) {
            prevX.setNext(y);
        } else {
            head = y;
        }
        if (xNext != y) {
            y.setNext(xNext);
            prevY.setNext(x);
        } else {
            y.setNext(x);
        }
        x.setNext(yNext);
        if (y == tail) {
            tail = x;
        }
    }

    Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    public static void main(String[] args) {
        var list = new C0327SwapNodes<Integer>();
        list.addLast(1);
        list.addLast(2);
        list.swap(list.getNode(0), list.getNode(1));
        System.out.println(list);
    }
}
