package learn.dsajg6e.ch03fund.exer;

import learn.dsajg6e.ch03fund.linked.CircularlyLinkedList;

/*
Given a circularly linked list L containing an even number of nodes,
describe how to split L into two circularly linked lists of half the size.
 */
public class C0330SplitList<E> extends CircularlyLinkedList<E> {
    public C0330SplitList<E> split() {
        C0330SplitList<E> first = new C0330SplitList<>();
        int len = size() / 2;
        for (int i = 0; i < len; i++) {
            E e = this.removeFirst();
            first.addLast(e);
        }
        return first;
    }
}
