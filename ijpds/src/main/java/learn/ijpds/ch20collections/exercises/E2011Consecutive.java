/*
20.11
Write a program that reads 10 integers and
displays them in the reversed order.
Remove consecutive integers.
Implement using only stack.
 */
package learn.ijpds.ch20collections.exercises;

import learn.csia.utils.CliAppArgs;

import java.util.ArrayDeque;
import java.util.Deque;

public class E2011Consecutive {
    public static void main(String[] args) {
        CliAppArgs cli = new CliAppArgs(args);
        Deque<Integer> numbers = new ArrayDeque<>();
        final int amount = 10;
        System.out.printf("Enter %d numbers:%n", amount);
        for (int i = 0; i < amount; i++) {
            int n = cli.nextInt();
            if (numbers.isEmpty() || numbers.peek() != n) {
                numbers.push(n);
            }
        }
        while (!numbers.isEmpty()) {
            System.out.print(numbers.pop() + " ");
        }
    }
}
