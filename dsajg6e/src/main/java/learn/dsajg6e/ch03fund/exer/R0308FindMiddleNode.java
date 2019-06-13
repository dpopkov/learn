package learn.dsajg6e.ch03fund.exer;

import learn.dsajg6e.ch03fund.linked.DoublyLinkedList;

public class R0308FindMiddleNode<E> extends DoublyLinkedList<E> {
    public E findMiddle() {
        Node<E> front = super.header.getNext();
        if (front == null) {
            return null;
        }
        Node<E> back = super.trailer.getPrev();
        while (true) {
            if (front == back) {
                break;
            }
            back = back.getPrev();
            if (front == back) {
                break;
            }
            front = front.getNext();
        }
        return front.getElement();
    }
}
