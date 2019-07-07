package learn.dsajg6e.ch06stacks.exer;

import learn.dsajg6e.ch06stacks.LinkedCircularQueue;
import learn.dsajg6e.ch06stacks.Queue;
import learn.dsajg6e.ch06stacks.Stack;

public class C0624ScanInStack<E> {
    private final Queue<E> queue = new LinkedCircularQueue<>();

    public boolean findIn(Stack<E> stack, E e) {
        boolean found = false;
        while (!stack.isEmpty()) {
            E tmp = stack.pop();
            if (tmp.equals(e)) {
                found = true;
            }
            queue.enqueue(tmp);
        }
        reverseBackTo(stack);
        return found;
    }

    private void reverseBackTo(Stack<E> stack) {
        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }
        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }
    }
}
