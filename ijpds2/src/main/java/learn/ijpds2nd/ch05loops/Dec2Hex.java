package learn.ijpds2nd.ch05loops;

import java.util.Scanner;

/* Listing 5.11 (Changed) */
public class Dec2Hex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer in decimal format: ");
        int n = in.nextInt();
        String h = dec2hex(n);
        System.out.println("Hex: " + h);
    }

    private static String dec2hex(int decimal) {
        StringBuilder s = new StringBuilder();
        while (decimal != 0) {
            int digit = decimal % 16;
            int offset = digit < 10 ? '0' : 'A' - 10;
            char character = (char) (digit + offset);
            s.insert(0, character);
            decimal /= 16;
        }
        if (s.length() == 0) {
            s.append("0");
        }
        s.insert(0, "0x");
        return s.toString();
    }
}
