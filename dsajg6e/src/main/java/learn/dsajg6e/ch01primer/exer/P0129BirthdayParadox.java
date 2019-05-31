package learn.dsajg6e.ch01primer.exer;

import java.util.Random;
import java.util.Scanner;

/**
 * Tests the birthday paradox by a series of experiments on randomly generated birthdays.
 * <br>
 * The birthday paradox says that the probability that two people in a room will
 * have the same birthday is more than half, provided n, the number of people in the
 * room, is more than 23.
 */
public class P0129BirthdayParadox {
    private static final int NUM_TESTS = 100;
    private static final int DAYS_PER_YEAR = 365;
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of people in the room: ");
        int numPeople = in.nextInt();
        int count = 0;
        for (int i = 0; i < NUM_TESTS; i++) {
            int[] birthdays = makeBirthdays(numPeople);
            boolean haveSameBirthdays = checkSameDays(birthdays);
            if (haveSameBirthdays) {
                count++;
            }
        }
        double rate = (double) count / NUM_TESTS;
        System.out.printf("Rate is %.2f%n", rate);
    }

    private static boolean checkSameDays(int[] days) {
        for (int i = 0; i < days.length - 1; i++) {
            for (int j = i + 1; j < days.length; j++) {
                if (days[i] == days[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int[] makeBirthdays(int numPeople) {
        int[] arr = new int[numPeople];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 + random.nextInt(DAYS_PER_YEAR);
        }
        return arr;
    }
}
