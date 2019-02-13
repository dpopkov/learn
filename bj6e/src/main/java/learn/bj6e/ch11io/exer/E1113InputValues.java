package learn.bj6e.ch11io.exer;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Prompts the user to input a set of floating-point values.
 * When the user enters a value that is not a number, gives the user
 * a second chance to enter the value. After two chances, quits reading input.
 * Prints the sum of entered values.
 */
public class E1113InputValues {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double sum = 0;
        boolean running = true;
        int errors = 0;
        while (running) {
            System.out.print("Enter a value: ");
            try {
                double d = in.nextDouble();
                sum += d;
                errors = 0;
            } catch (InputMismatchException e) {
                if (errors == 1) {
                    System.out.println("This is the second invalid input. Exit.");
                    running = false;
                } else {
                    in.nextLine();
                    System.out.println("Invalid number. Try one more time.");
                    errors++;
                }
            }
        }
        System.out.println("sum = " + sum);
    }
}
