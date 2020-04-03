package learn.ijpds2nd.ch06methods.exer;

import java.util.Scanner;

public class E0603PalindromeInteger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = in.nextInt();
        boolean p = isPalindrome(n);
        System.out.printf("%d %s a palindrome%n", n, p ? "is" : "is not");
    }

    private static boolean isPalindrome(int n) {
        return n == reverse(n);
    }

    private static int reverse(int n) {
        int r = 0;
        while (n != 0) {
            int d = n % 10;
            n /= 10;
            r = r * 10 + d;
        }
        return r;
    }
}
