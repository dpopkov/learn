package learn.dsajg6e.ch03fund.exer;

import learn.dsajg6e.ch03fund.linked.DoublyLinkedList;

public class C0326ConcatenatingList<E> extends DoublyLinkedList<E> {
    public C0326ConcatenatingList<E> concatenate(C0326ConcatenatingList<E> second) {
        var list = new C0326ConcatenatingList<E>();
        Node<E> node;
        node = this.header.getNext();
        while (node != null && node != this.trailer) {
            list.addLast(node.getElement());
            node = node.getNext();
        }
        node = second.header.getNext();
        while (node != null && node != second.trailer) {
            list.addLast(node.getElement());
            node = node.getNext();
        }
        return list;
    }
}
