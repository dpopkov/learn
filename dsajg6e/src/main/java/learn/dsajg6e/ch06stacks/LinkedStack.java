package learn.dsajg6e.ch06stacks;

import learn.dsajg6e.ch03fund.linked.SinglyLinkedList;

/**
 * CF 6.4
 * Implementation of the {@link Stack} interface using a singly linked list as a storage.
 * @param <E> type of the elements
 */
@SuppressWarnings("unused")
public class LinkedStack<E> implements Stack<E> {
    private final SinglyLinkedList<E> list = new SinglyLinkedList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E top() {
        return list.first();
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @SuppressWarnings("unchecked")
    public static <E> LinkedStack<E> of(E... values) {
        LinkedStack<E> stack = new LinkedStack<>();
        for (E v : values) {
            stack.push(v);
        }
        return stack;
    }
}
