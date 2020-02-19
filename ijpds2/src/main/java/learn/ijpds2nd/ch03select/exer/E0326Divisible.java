package learn.ijpds2nd.ch03select.exer;

import java.util.Scanner;

public class E0326Divisible {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = in.nextInt();
        boolean by4 = n % 4 == 0;
        boolean by5 = n % 5 == 0;
        if (by4 && by5) {
            System.out.printf("%d is divisible by 4 and divisible by 5%n", n);
        }
        if (by4 || by5) {
            System.out.printf("%d is divisible by 4 or divisible by 5%n", n);
        }
        if (by4 ^ by5) {
            System.out.printf("%d is divisible by 4 or divisible by 5 but not both%n", n);
        }
    }
}
