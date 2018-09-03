package learn.csia.ch0103;

import learn.csia.utils.CliAppArgs;

public class DivisorPattern {
    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter number of rows and columns");
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if ((i % j == 0) || (j % i == 0)) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println(i);
        }
    }
}
