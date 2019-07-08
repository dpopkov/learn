package learn.dsajg6e.ch06stacks.exer;

import learn.dsajg6e.ch06stacks.Deque;
import learn.dsajg6e.ch06stacks.LinkedDeque;
import learn.dsajg6e.ch06stacks.Stack;

/*
There are two nonempty stacks S and T and a deque D.
How to use D so that S stores all the elements of T below all of its original elements,
with both sets of elements still in their original order?
 */
public class C0632MoveBelow {
    static <E> void moveBelow(Stack<E> dest, Stack<E> source) {
        Deque<E> buffer = new LinkedDeque<>();
        while (!source.isEmpty()) {
            buffer.addLast(source.pop());
        }
        while (!dest.isEmpty()) {
            source.push(dest.pop());
        }
        while (!source.isEmpty()) {
            buffer.addFirst(source.pop());
        }
        while (!buffer.isEmpty()) {
            dest.push(buffer.removeLast());
        }
    }
}
