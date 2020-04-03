package learn.ijpds2nd.ch06methods.exer;

import java.util.Scanner;

public class E0602SumDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = in.nextInt();
        System.out.println(n + " has sum of digits = " + sumDigits(n));
    }

    private static int sumDigits(int n) {
        n = Math.abs(n);
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
