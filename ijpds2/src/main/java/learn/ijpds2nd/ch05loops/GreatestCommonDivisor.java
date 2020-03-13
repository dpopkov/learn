package learn.ijpds2nd.ch05loops;

import java.util.Scanner;

/* Listing 5.10 (changed) */
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        int a = in.nextInt();
        int b = in.nextInt();
        int r = gcd(a, b);
        System.out.println("The greatest common divisor is " + r);
    }

    private static int gcd(int a, int b) {
        int r = 1;
        int k = 2;
        while (k <= a && k <= b) {
            if (a % k == 0 && b % k == 0) {
                r = k;
            }
            k++;
        }
        return r;
    }
}
