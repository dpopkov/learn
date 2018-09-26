package learn.ijpds.ch19generics.exercises;

@SuppressWarnings("unused")
public interface Stack<E> {
    int getSize();
    E peek();
    void push(E o);
    E pop();
    boolean isEmpty();
}
