package learn.ijpds.ch06methods;

import learn.csia.utils.CliAppArgs;

public class Hex2Dec {
    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter a hex number");
        String hex = in.nextString();
        int decimal = hexToDecimal(hex);
        System.out.println(decimal);
    }

    public static int hexToDecimal(String hex) {
        int decimal = 0;
        hex = hex.toUpperCase();
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            decimal = decimal * 16 + hexCharToDecimal(hexChar);
        }
        return decimal;
    }

    private static int hexCharToDecimal(char ch) {
        if (ch >= 'A' && ch <= 'F') {
            return 10 + ch - 'A';
        } else {
            return ch - '0';
        }
    }
}
