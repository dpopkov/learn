package learn.dsajg6e.ch03fund.linked;

/**
 * CF 3.17-18
 * @param <E>
 */
public class DoublyLinkedList<E> extends AbstractDoublyLinkedList<E> implements Cloneable {
    protected final Node<E> header;
    protected final Node<E> trailer;

    public DoublyLinkedList() {
        header = new Node<>();
        trailer = new Node<>();
        header.setNext(trailer);
        trailer.setPrev(header);
    }

    @Override
    protected Node<E> firstNode() {
        return header.getNext();
    }

    public E first() {
        if (size == 0) {
            return null;
        } else {
            return header.getNext().getElement();
        }
    }

    public E last() {
        if (size == 0) {
            return null;
        } else {
            return trailer.getPrev().getElement();
        }
    }

    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    public E removeFirst() {
        if (size == 0) {
            return null;
        }
        return remove(header.getNext());
    }

    public E removeLast() {
        if (size == 0) {
            return null;
        }
        return remove(trailer.getPrev());
    }

    private void addBetween(E e, Node<E> before, Node<E> after) {
        Node<E> n = new Node<>(e, after, before);
        before.setNext(n);
        after.setPrev(n);
        size++;
    }

    private E remove(Node<E> n) {
        n.getPrev().setNext(n.getNext());
        n.getNext().setPrev(n.getPrev());
        size--;
        return n.getElement();
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public Object clone() {
        DoublyLinkedList<E> cloned = new DoublyLinkedList<>();
        Node<E> source = this.header.getNext();
        while (source != this.trailer) {
            cloned.addLast(source.getElement());
            source = source.getNext();
        }
        return cloned;
    }
}
