package learn.dsajg6e.ch07list.exer;

import learn.dsajg6e.ch07list.positional.LinkedPositionalList;

public class C0751BubbleSortPositionalList<E extends Comparable<E>> extends LinkedPositionalList<E> {
    public void bubbleSort() {
        if (size() < 2) {
            return;
        }
        int last = size() - 1;
        for (int i = 0; i < last; i++) {
            Node<E> node = headerSentinel.getNext();
            for (int j = 0; j < last - i; j++) {
                Node<E> next = node.getNext();
                if (node.getElement().compareTo(next.getElement()) > 0) {
                    swap(node, next);
                } else {
                    node = node.getNext();
                }
            }
        }
    }

    private void swap(Node<E> prev, Node<E> next) {
        Node<E> prevPrev = prev.getPrev();
        Node<E> nextNext = next.getNext();
        next.setNext(prev);
        next.setPrev(prevPrev);
        prev.setNext(nextNext);
        prev.setPrev(next);
        prevPrev.setNext(next);
        nextNext.setPrev(prev);
    }
}
