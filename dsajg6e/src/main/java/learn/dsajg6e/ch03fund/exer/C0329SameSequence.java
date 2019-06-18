package learn.dsajg6e.ch03fund.exer;

import learn.dsajg6e.ch03fund.linked.CircularlyLinkedList;

/*
Suppose you are given two circularly linked lists, L and M.
Describe an algorithm for telling if L and M store the same sequence
of elements (but perhaps with different starting points).
 */
public class C0329SameSequence<E> extends CircularlyLinkedList<E> {
    public boolean hasSameElementsAs(C0329SameSequence<E> other) {
        if (this.size() != other.size()) {
            return false;
        }
        Node<E> n0 = this.tail;
        Node<E> n1 = other.tail;
        int totalHops = 1;
        int equalsCount = 0;
        int missCount = 0;
        int length = size();
        while (n0 != null && n1 != null && totalHops < length * 2) {
            if (n0.getElement().equals(n1.getElement())) {
                equalsCount++;
                if (equalsCount == length) {
                    return true;
                }
                missCount = 0;
                n0 = n0.getNext();
                n1 = n1.getNext();
                totalHops++;
            } else {
                equalsCount = 0;
                missCount++;
                while (n1 != null && missCount < length) {
                    n1 = n1.getNext();
                    totalHops++;
                    if (n1 != null && n0.getElement().equals(n1.getElement())) {
                        break;
                    } else {
                        missCount++;
                    }
                }
                if (missCount >= length) {
                    return false;
                }
            }
        }
        return false;
    }
}
