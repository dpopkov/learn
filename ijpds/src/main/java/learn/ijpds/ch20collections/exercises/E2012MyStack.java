package learn.ijpds.ch20collections.exercises;

import java.util.List;
import java.util.Stack;

@SuppressWarnings("unused")
public class E2012MyStack<E> extends Stack<E> {
    public E2012MyStack(List<E> list) {
        for (E e : list) {
            this.push(e);
        }
    }
}
