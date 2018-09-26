package learn.ijpds.ch19generics.exercises;

import java.util.ArrayList;

/*
Implement stack using inheritance.
 */
public class E1902Stack<E> extends ArrayList<E> implements Stack<E> {

    @Override
    public int getSize() {
        return super.size();
    }

    @Override
    public E peek() {
        return super.get(getSize() - 1);
    }

    @Override
    public void push(E o) {
        super.add(o);
    }

    @Override
    public E pop() {
        return super.remove(getSize() - 1);
    }

    public static void main(String[] args) {
        E1902Stack<String> stack = new E1902Stack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        stack.push("Four");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
