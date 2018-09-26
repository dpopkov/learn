package learn.ijpds.ch19generics.exercises;

import java.util.StringJoiner;

/*
Implement generic stack using an array rather than an ArrayList
 */
@SuppressWarnings("unused")
public class E1901Stack<E> implements Stack<E> {
    @SuppressWarnings("unchecked")
    private E[] list = (E[])new Object[1];
    private int size = 0;

    public int getSize() {
        return this.size;
    }

    public E peek() {
        return list[size - 1];
    }

    public void push(E o) {
        ensureCapacity(size + 1);
        list[size++] = o;
    }

    private void ensureCapacity(int capacity) {
        if (list.length < capacity) {
            int newCapacity = list.length * 2;
            @SuppressWarnings("unchecked")
            E[] newList = (E[])new Object[newCapacity];
            System.arraycopy(list, 0, newList, 0, size);
            list = newList;
        }
    }

    public E pop() {
        return list[--size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "stack: ", "");
        for (int i = 0; i < size; i++) {
            joiner.add(list[i].toString());
        }
        return joiner.toString();
    }

    public static void main(String[] args) {
        E1901Stack<String> stack1 = new E1901Stack<>();
        stack1.push("London");
        stack1.push("Paris");
        stack1.push("Berlin");
        System.out.println(stack1);
        E1901Stack<Integer> stack2 = new E1901Stack<>();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        System.out.println(stack2);
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1);
    }
}
