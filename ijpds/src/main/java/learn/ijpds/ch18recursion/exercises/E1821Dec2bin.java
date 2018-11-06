package learn.ijpds.ch18recursion.exercises;

import java.util.Scanner;

public class E1821Dec2bin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter decimal number: ");
        int n = in.nextInt();
        String bin = decToBinInserting(n);
        System.out.println(bin);
        String bin32 = decToBinAppending(n);
        System.out.println(bin32);
    }

    private static String decToBinInserting(int n) {
        StringBuilder builder = new StringBuilder();
        return decToBinInserting(builder, n);
    }

    private static String decToBinInserting(StringBuilder builder, int n) {
        if (n == 0) {
            return builder.toString();
        }
        builder.insert(0, (char) (n % 2 + '0'));
        return decToBinInserting(builder, n / 2);
    }

    private static String decToBinAppending(int n) {
        StringBuilder builder = new StringBuilder();
        int mask = 0b10000000_00000000_00000000_00000000;
        return decToBinAppending(builder, mask, n);
    }

    private static String decToBinAppending(StringBuilder builder, int mask, int n) {
        if (mask == 0) {
            return builder.toString();
        }
        int digit = ((n & mask) == mask) ? 1 : 0;
        builder.append((char) (digit + '0'));
        return decToBinAppending(builder, mask >>> 1, n);
    }
}
