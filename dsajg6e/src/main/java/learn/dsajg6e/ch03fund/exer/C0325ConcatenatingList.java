package learn.dsajg6e.ch03fund.exer;

import learn.dsajg6e.ch03fund.linked.SinglyLinkedList;

/**
 * Contains method for concatenating two singly linked lists.
 * @param <E>
 */
public class C0325ConcatenatingList<E> extends SinglyLinkedList<E> {
    public C0325ConcatenatingList<E> concatenate(C0325ConcatenatingList<E> second) {
        C0325ConcatenatingList<E> list = new C0325ConcatenatingList<>();
        Node<E> node;
        node = this.head;
        while (node != null) {
            list.addLast(node.getElement());
            node = node.getNext();
        }
        node = second.head;
        while (node != null) {
            list.addLast(node.getElement());
            node = node.getNext();
        }
        return list;
    }
}
