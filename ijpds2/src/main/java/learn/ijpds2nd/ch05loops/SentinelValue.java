package learn.ijpds2nd.ch05loops;

import java.util.Scanner;

/* Listing 5.5 */
public class SentinelValue {
    private static final int SENTINEL = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = 0;
        System.out.println("Enter numbers (the input ends if it is 0):");
        System.out.print("> ");
        int value = in.nextInt();
        while (value != SENTINEL) {
            sum += value;
            System.out.print("> ");
            value = in.nextInt();
        }
        System.out.println("sum = " + sum);
    }
}
