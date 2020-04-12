package learn.ijpds2nd.ch07arrays.exer;

import java.util.Arrays;

public class E0706SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 50;
        if (args.length == 1) {
            n = Integer.parseInt(args[0]);
        }
        boolean[] flags = new boolean[n + 1];
        Arrays.fill(flags, true);
        for (int i = 2; i < flags.length; i++) {
            if (flags[i]) {
                for (int j = i * 2; j < flags.length; j += i) {
                    flags[j] = false;
                }
            }
        }
        for (int i = 2; i < flags.length; i++) {
            if (flags[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
