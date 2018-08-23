package learn.csia.ch0102;

import java.util.Scanner;

public class RandomInt {
    public static void main(String[] args) {
        int n;
        if (args.length > 0) {
            n = Integer.parseInt(args[0]);
        } else {
            Scanner in = new Scanner(System.in);
            n = in.nextInt();
        }
        double r = Math.random();
        int value = (int) (r * n);
        System.out.println(value);
    }
}
