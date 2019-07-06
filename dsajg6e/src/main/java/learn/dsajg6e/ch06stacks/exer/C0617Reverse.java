package learn.dsajg6e.ch06stacks.exer;

import learn.dsajg6e.ch06stacks.ArrayStack;
import learn.dsajg6e.ch06stacks.Stack;

/*
R-6.4
Implement a method with signature transfer(S, T ) that transfers all elements
from stack S onto stack T , so that the element that starts at the top of S is the first
to be inserted onto T , and the element at the bottom of S ends up at the top of T .
C-6.17
Implement method reverse(Stack).
 */
public class C0617Reverse {
    static <E> void transfer(Stack<E> source, Stack<E> target) {
        while (!source.isEmpty()) {
            target.push(source.pop());
        }
    }

    static <E> void reverse(Stack<E> stack) {
        Stack<E> t0 = new ArrayStack<>(stack.size());
        Stack<E> t1 = new ArrayStack<>(stack.size());
        transfer(stack, t0);
        transfer(t0, t1);
        transfer(t1, stack);
    }
}
