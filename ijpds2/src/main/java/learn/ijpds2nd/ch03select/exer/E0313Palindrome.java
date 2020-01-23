package learn.ijpds2nd.ch03select.exer;

import java.util.Scanner;

public class E0313Palindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a three-digit integer: ");
        int n = in.nextInt();
        String answer = isPalindrome(n) ? "is" : "is not";
        System.out.println(n + " " + answer + " a palindrome");
    }

    static boolean isPalindrome(int n) {
        int divisor = 1;
        while (divisor <= n / 10) {
            divisor *= 10;
        }
        int left;
        int right;
        while (n != 0) {
            left = n / divisor;
            right = n % 10;
            if (left != right) {
                return false;
            }
            n %= divisor;
            n /= 10;
            divisor /= 100;
        }
        return true;
    }
}
