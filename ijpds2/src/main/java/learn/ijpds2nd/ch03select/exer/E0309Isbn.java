package learn.ijpds2nd.ch03select.exer;

import java.util.Scanner;

public class E0309Isbn {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the first 9 digits of an ISBN as integer: ");
        int isbn9 = in.nextInt();
        String isbn10 = isbn9ToIsbn10(isbn9);
        System.out.println("The ISBN-10 number is " + isbn10);
    }

    static String isbn9ToIsbn10(int isbn9) {
        char d10 = charOfChecksum(isbn9);
        return String.format("%09d%c", isbn9, d10);
    }

    private static char charOfChecksum(int isbn9) {
        int sum = 0;
        int divisor = 100000000;
        for (int i = 1; i <= 9; i++) {
            int digit = isbn9 / divisor;
            isbn9 %= divisor;
            int t = digit * i;
            sum += t;
            divisor /= 10;
        }
        int ch = sum % 11;
        return (ch == 10) ? 'X' : (char)('0' + ch);
    }
}
