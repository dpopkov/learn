package learn.dsajg6e.ch03fund.exer;

import learn.dsajg6e.ch03fund.linked.SinglyLinkedList;

public class R0306FindLast<E> extends SinglyLinkedList<E> {
    public E findNthLastElement(int n) {
        if (n == 1) {
            return super.tail.getElement();
        }
        Node<E> node = super.head;
        for (int rightIdx = super.size; rightIdx > n; rightIdx--) {
            node = node.getNext();
        }
        return node.getElement();
    }
}
