package learn.ijpds.ch18recursion.exercises;

import java.util.Scanner;

public class E1822DecToHex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter decimal number: ");
        int n = in.nextInt();
        String hex = decToHex(n);
        System.out.println("hex = " + hex);
    }

    private static String decToHex(int n) {
        StringBuilder builder = new StringBuilder();
        return decToHex(builder, n);
    }

    private static final char[] HEX_CHARS = "0123456789ABCDEF".toCharArray();

    private static String decToHex(StringBuilder builder, int n) {
        if (n == 0) {
            return builder.toString();
        }
        int digit = n % 16;
        builder.insert(0, HEX_CHARS[digit]);
        return decToHex(builder, n / 16);
    }
}
