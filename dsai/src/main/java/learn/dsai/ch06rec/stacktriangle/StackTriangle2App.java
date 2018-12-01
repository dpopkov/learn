package learn.dsai.ch06rec.stacktriangle;

import learn.dsai.ch06rec.StackT;

import java.util.Scanner;

/**
 * Reworked stack triangle using stack-based approach.
 * The stack can be eliminated entirely and a simple loop
 * can be used. However in more complicated applications
 * the stack must remain.
 */
public class StackTriangle2App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = in.nextInt();
        int answer = recTriangle(number);
        System.out.println("Triangle = " + answer);
    }

    private static int recTriangle(int number) {
        StackT<Integer> stack = new StackT<>(100);
        int answer = 0;
        while (number > 0) {
            stack.push(number);
            number--;
        }
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        return answer;
    }
}
