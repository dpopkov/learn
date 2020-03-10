package learn.ijpds2nd.ch04functions.exer;

import java.util.Scanner;

public class E0411Bin2Dec {
    public static void main(String[] args) {
        easy();
        medium();
    }

    private static void easy() {
        Scanner in = new Scanner(System.in);
        in.useRadix(2);
        System.out.print("Enter binary digits (0000 to 1111): ");
        int n = in.nextInt();
        System.out.println("The decimal value is " + n);
    }

    private static void medium() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter binary digits (0000 to 1111): ");
        String s = in.nextLine();
        int n = bin2dec(s);
        System.out.println("The decimal value is " + n);
    }

    private static int bin2dec(String s) {
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            r = r * 2 + s.charAt(i) - '0';
        }
        return r;
    }
}
