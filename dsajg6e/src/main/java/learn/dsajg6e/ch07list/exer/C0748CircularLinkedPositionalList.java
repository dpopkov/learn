package learn.dsajg6e.ch07list.exer;

import learn.dsajg6e.ch07list.positional.CircularPositionalList;
import learn.dsajg6e.ch07list.positional.LinkedPositionalList;

public class C0748CircularLinkedPositionalList<E> extends LinkedPositionalList<E> implements CircularPositionalList<E> {
    @Override
    public void rotate() {
        Node<E> movedNode = headerSentinel.getNext();
        Node<E> next = movedNode.getNext();
        headerSentinel.setNext(next);
        next.setPrev(headerSentinel);
        Node<E> prev = trailerSentinel.getPrev();
        prev.setNext(movedNode);
        trailerSentinel.setPrev(movedNode);
        movedNode.setPrev(prev);
        movedNode.setNext(trailerSentinel);
    }
}
