package learn.dsajg6e.ch06stacks.exer;

import learn.dsajg6e.ch06stacks.ArrayStack;
import learn.dsajg6e.ch06stacks.Stack;

import java.util.Random;

/*
Suppose Alice has picked three distinct integers and placed them into a stack S in
random order. Write a short, straightline piece of pseudocode (with no loops or
recursion) that uses only one comparison and only one variable x, yet that results
in variable x storing the largest of Alice’s three integers with probability 2/3.
 */
public class C0616 {
    public static void main(String[] args) {
        Random random = new Random();
        Stack<Integer> stack = makeStack(random, 10);
        int x = stack.pop();
        if (x < stack.top()) {
            x = stack.pop();
        }
        System.out.println("x = " + x);
    }

    @SuppressWarnings("SameParameterValue")
    private static Stack<Integer> makeStack(Random random, int bound) {
        Stack<Integer> stack = new ArrayStack<>(3);
        for (int i = 0; i < 3; i++) {
            int n = random.nextInt(bound);
            System.out.println("n = " + n);
            stack.push(n);
        }
        return stack;
    }
}
