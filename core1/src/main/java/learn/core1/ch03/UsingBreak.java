package learn.core1.ch03;

import java.util.Scanner;

/**
 * Example how to use <code>break</code> in inner loop.
 */
public class UsingBreak {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        read_data:
        while(true) {
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                System.out.print("Enter a number >= 0: ");
                n = in.nextInt();
                if (n < 0) {
                    break read_data;
                }
                sum += n;
            }
            System.out.printf("Sum of 4 numbers: %d%n", sum);
        }
        //noinspection ConstantConditions
        if (n < 0) {
            System.out.println("Negative input: " + n);
        } else {
            System.out.println("Everything was OK.");
        }
    }
}
