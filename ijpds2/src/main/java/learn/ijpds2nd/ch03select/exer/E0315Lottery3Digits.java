package learn.ijpds2nd.ch03select.exer;

import java.util.Arrays;
import java.util.Scanner;

public class E0315Lottery3Digits {

    public static final int WHOLE_MATCH = 12_000;
    public static final int ALL_DIGITS = 5_000;
    public static final int ONE_DIGIT = 2_000;
    public static final int NO_MATCH = 0;

    public static void main(String[] args) {
        int lottery = (int) (Math.random() * 1000);
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your lottery pick (three digits): ");
        int guess = in.nextInt();
        int award = calculateAward(lottery, guess);

        int lotteryDigit1 = lottery / 10;
        int lotteryDigit2 = lottery % 10;

        int guessDigit1 = guess / 10;
        int guessDigit2 = guess % 10;

        System.out.println("The lottery number is " + lottery);

        if (guess == lottery) {
            System.out.println("Exact match: you win $10,000");
        } else if (guessDigit2 == lotteryDigit1 && guessDigit1 == lotteryDigit2) {
            System.out.println("Match all digits: you win $3,000");
        } else if (guessDigit1 == lotteryDigit1
                || guessDigit1 == lotteryDigit2
                || guessDigit2 == lotteryDigit1
                || guessDigit2 == lotteryDigit2) {
            System.out.println("Match one digit: you win $1,000");
        } else {
            System.out.println("Sorry , no match");
        }
    }

    static int calculateAward(int lottery, int guess) {
        if (lottery == guess) {
            return WHOLE_MATCH;
        } else {
            int d1 = digit(1, lottery);
            int d2 = digit(2, lottery);
            int d3 = digit(3, lottery);
            int g1 = digit(1, guess);
            int g2 = digit(2, guess);
            int g3 = digit(3, guess);
            int[] lotteryDigits = new int[]{d1, d2, d3};
            int[] guessDigits = new int[]{g1, g2, g3};
            sortThreeDigits(lotteryDigits);
            sortThreeDigits(guessDigits);
            if (Arrays.equals(lotteryDigits, guessDigits)) {
                return ALL_DIGITS;
            }
            if (d1 == g1 || d1 == g2 || d1 == g3
                    || d2 == g1 || d2 == g2 || d2 == g3
                    || d3 == g1 || d3 == g2 || d3 == g3) {
                return ONE_DIGIT;
            }
            return NO_MATCH;
        }
    }

    static void sortThreeDigits(int[] a) {
        if (a[0] > a[1]) {
            swap(a, 0, 1);
        }
        if (a[1] > a[2]) {
            swap(a, 1, 2);
        }
        if (a[0] > a[1]) {
            swap(a, 0, 1);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static int digit(int idx, int number) {
        switch (idx) {
            case 1:
                return number / 100;
            case 2:
                return number / 10 % 10;
            case 3:
                return number % 10;
            default:
                throw new IllegalArgumentException("Not allowed index: " + idx);
        }
    }
}
