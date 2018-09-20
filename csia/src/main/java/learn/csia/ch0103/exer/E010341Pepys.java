package learn.csia.ch0103.exer;

import learn.csia.utils.Format;

import java.util.Random;

/**
 * 1.3.41 Pepys problem. In 1693 Samuel Pepys asked Isaac Newton which is more
 * likely: getting 1 at least once when rolling a fair die six times or getting 1 at least
 * twice when rolling it 12 times. Write a program that could have provided Newton
 * with a quick answer.
 */
public class E010341Pepys {
    private static final Random random = new Random();

    public static void main(String[] args) {
        int numTests = 10000;
        int atLeastOne = 0;
        int atLeastTwo = 0;
        for (int i = 0; i < numTests; i++) {
            if (containsOneAtLeast(rollNumTimes(6), 1)) {
                atLeastOne++;
            }
            if (containsOneAtLeast(rollNumTimes(12), 2)) {
                atLeastTwo++;
            }
        }
        System.out.println("once when six times: " + Format.percent(atLeastOne, numTests));
        System.out.println("twice when 12 times: " + Format.percent(atLeastTwo, numTests));
    }

    private static boolean containsOneAtLeast(int[] values, int numTimes) {
        return countOnes(values) >= numTimes;
    }

    private static int countOnes(int[] values) {
        int total = 0;
        for (int n : values) {
            if (1 == n) {
                total++;
            }
        }
        return total;
    }

    private static int[] rollNumTimes(int number) {
        int[] result = new int[number];
        for (int i = 0; i < number; i++) {
            result[i] = random.nextInt(6) + 1;
        }
        return result;
    }


}
