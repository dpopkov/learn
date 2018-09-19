package learn.ijpds.ch12exceptions.exercises;

import learn.csia.utils.CliAppArgs;

public class E1209Binary {
    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter binary number");
        String bin = in.nextString();
        int decimal = new E1209Binary().binToDecimal(bin);
        System.out.println(decimal);
    }

    private int binToDecimal(String bin) {
        int decimal = 0;
        for (int i = 0; i < bin.length(); i++) {
            char ch = bin.charAt(i);
            int digit;
            if (ch == '1') {
                digit = 1;
            } else if (ch == '0') {
                digit = 0;
            } else {
                throw new BinaryFormatException("Non binary character " + ch);
            }
            decimal = decimal * 2 + digit;
        }
        return decimal;
    }
}
