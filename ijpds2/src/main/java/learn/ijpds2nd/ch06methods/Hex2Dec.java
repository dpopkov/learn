package learn.ijpds2nd.ch06methods;

import java.util.Scanner;

/* Listing 6.8 */
public class Hex2Dec {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a hex number: ");
        String hex = in.nextLine();
        System.out.println("The decimal value for hex number " + hex + " is " + hexToDecimal(hex.toUpperCase()));
    }

    private static int hexToDecimal(String hex) {
        int decimal = 0;
        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            decimal = decimal * 16 + hexCharToDecimal(c);
        }
        return decimal;
    }

    private static int hexCharToDecimal(char ch) {
        if ('0' <= ch && ch <= '9') {
            return ch - '0';
        } else {
            if ('A' <= ch && ch <= 'F') {
                return ch - 'A' + 10;
            } else {
                throw new IllegalArgumentException("Not Hex char: " + ch);
            }
        }
    }
}
