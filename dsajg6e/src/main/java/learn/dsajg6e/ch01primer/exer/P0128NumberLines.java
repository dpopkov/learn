package learn.dsajg6e.ch01primer.exer;

import java.util.Random;

public class P0128NumberLines {
    private static final int NUM_TYPOS = 8;
    private static final Random random = new Random();

    public static void main(String[] args) {
        final String line = "I will never spam my friends again";
        final int numLines = 100;

        for (int i = 0; i < numLines; i++) {
            printNumbered(i + 1, line);
        }
    }

    @SuppressWarnings("SameParameterValue")
    private static void printNumbered(int lineNumber, String line) {
        int[] idxTypos = new int[NUM_TYPOS];
        for (int i = 0; i < idxTypos.length; i++) {
            idxTypos[i] = random.nextInt(line.length());
        }
        StringBuilder sb = new StringBuilder(line);
        makeTypos(sb, idxTypos);
        System.out.printf("%02d : %s%n", lineNumber, sb);
    }

    private static void makeTypos(StringBuilder buffer, int[] typos) {
        int length = buffer.length();
        for (int i : typos) {
            int left, right;
            if (i == 0) {
                left = 0;
                right = 1;
            } else if (i == length - 1) {
                right = i;
                left = i - 1;
            } else {
                if (random.nextDouble() < 0.5) {
                    left = i - 1;
                    right = i;
                } else {
                    left = i;
                    right = i + 1;
                }
            }
            swap(buffer, left, right);
        }
    }

    private static void swap(StringBuilder buffer, int i, int j) {
        char ch = buffer.charAt(i);
        buffer.setCharAt(i, buffer.charAt(j));
        buffer.setCharAt(j, ch);
    }
}
