package learn.dsajg6e.ch03fund.linked;

public interface IList<E> {
    int size();
    boolean isEmpty();
    E first();
    E last();
    void addFirst(E e);
    void addLast(E e);
    E removeFirst();
}
