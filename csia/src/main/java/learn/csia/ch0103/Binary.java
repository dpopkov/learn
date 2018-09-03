package learn.csia.ch0103;

import learn.csia.utils.CliAppArgs;

public class Binary {
    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter integer to convert");
        int n = in.nextInt();
        int power = 1;
        while (power <= n / 2) {
            power *= 2;
        }
        while (power > 0) {
            if (n < power) {
                System.out.print(0);
            } else {
                System.out.print(1);
                n -= power;
            }
            power /= 2;
        }
        System.out.println();
    }
}
