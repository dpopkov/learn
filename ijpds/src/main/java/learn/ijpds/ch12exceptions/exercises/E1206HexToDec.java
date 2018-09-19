package learn.ijpds.ch12exceptions.exercises;

import learn.csia.utils.CliAppArgs;

public class E1206HexToDec {
    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter a hex number");
        String hex = in.nextString();
        int decimal = new E1206HexToDec().hexToDecimal(hex);
        System.out.println(decimal);
    }

    public int hexToDecimal(String hex) {
        int decimal = 0;
        hex = hex.toUpperCase();
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            decimal = decimal * 16 + hexCharToDecimal(hexChar);
        }
        return decimal;
    }

    /**
     * Converts hexadecimal character to decimal number.
     * @param ch hexadecimal character
     * @return decimal number
     * @throws NumberFormatException when specified character is not hexadecimal
     */
    private int hexCharToDecimal(char ch) throws NumberFormatException {
        if (ch >= 'A' && ch <= 'F') {
            return 10 + ch - 'A';
        } else if (ch >= '0' && ch <= '9') {
            return ch - '0';
        } else {
            throw new NumberFormatException("Not hexadecimal character " + ch);
        }
    }
}
