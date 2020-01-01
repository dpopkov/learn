package learn.ijpds2nd.ch02elem.exerc;

import java.util.Scanner;

/** Multiplies the digits in an integer. */
public class Ex0206Digits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = in.nextInt();
        int multiplication = 1;
        while (n != 0) {
            multiplication *= n % 10;
            n /= 10;
        }
        System.out.printf("The multiplication of all digits in %d is %d%n", n, multiplication);
    }
}
