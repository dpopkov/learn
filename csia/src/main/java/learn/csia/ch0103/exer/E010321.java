package learn.csia.ch0103.exer;

import learn.csia.utils.NumberArgs;

/**
 * 1.3.21 Modify Binary to get a program that takes two integer commandline
 * arguments i and k and converts i to base k. Assume that i is an integer in Java’s
 * long data type and that k is an integer between 2 and 16.
 */
public class E010321 {
    private static final String[] digitCharacters = "0123456789ABCDEF".split("");

    public static void main(String[] args) {
        NumberArgs in = new NumberArgs(args, "Number to convert", "Base");
        long i = in.nextLong();
        int k = in.nextInt();

        String result = new E010321().convert(i, k);
        System.out.println(result);
    }

    /**
     * Converts number to specified base.
     * @param number number to convert
     * @param base base of number system (between 2 and 16)
     * @return string representation of the number in given number system
     */
    public String convert(long number, int base) {
        StringBuilder sb = new StringBuilder();
        int power = 1;
        while (power <= number / base) {
            power *= base;
        }
        int digit;
        while (power > 0) {
            if (number < power) {
                sb.append("0");
            } else {
                digit = (int)(number / power);
                sb.append(digitCharacters[digit]);
                number %= power;
            }
            power /= base;
        }
        return sb.toString();
    }
}
