package learn.ijpds2nd.ch04functions.exer;

import java.util.Scanner;

public class E0412Hex2Bin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a hex digit: ");
        char hex = in.nextLine().charAt(0);
        int n = hex2Dec(hex);
        String s = toBin(n);
        System.out.printf("%s%n", s);
    }

    private static String toBin(int n) {
        StringBuilder s = new StringBuilder();
        while (n != 0) {
            s.insert(0, n % 2);
            n /= 2;
        }
        return s.toString();
    }

    private static int hex2Dec(char h) {
        int r;
        if ('0' <= h && h <= '9') {
            r = h - '0';
        } else {
            h = Character.toLowerCase(h);
            if ('a' <= h && h <= 'f') {
                r =  h - 'a' + 10;
            } else {
                throw new IllegalArgumentException("Invalid hex char: " + h);
            }
        }
        return r;
    }
}
