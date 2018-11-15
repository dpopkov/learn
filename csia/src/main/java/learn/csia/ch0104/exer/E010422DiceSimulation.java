package learn.csia.ch0104.exer;

import learn.csia.utils.ArrayUtils;
import learn.csia.utils.CliAppArgs;

import java.util.Arrays;
import java.util.Random;

public class E010422DiceSimulation {
    private static final int MAXIMUM_DICE_VALUE = 6;
    private static final int MAXIMUM_SUM_OF_TWO_DICE = MAXIMUM_DICE_VALUE * 2;
    private static final int FREQUENCIES_LENGTH = MAXIMUM_SUM_OF_TWO_DICE + 1;

    private static Random random = new Random();

    public static void main(String[] args) {
        double[] exactProbabilities = getExactDistribution();
        CliAppArgs cli = new CliAppArgs(args, "Number of dice throws");
        int n = cli.nextInt();

        int[] frequencies = new int[FREQUENCIES_LENGTH];
        for (int i = 0; i < n; i++) {
            int value = throwDice() + throwDice();
            frequencies[value]++;
        }
        int sum = ArrayUtils.sum(frequencies);
        double[] probabilities = new double[FREQUENCIES_LENGTH];
        for (int k = 1; k < frequencies.length; k++) {
            probabilities[k] = (double) frequencies[k] / sum;
        }
        System.out.println("Calculated probabilities:");
        System.out.println(ArrayUtils.toString(probabilities, "%.3f"));
        double[] diffs = new double[probabilities.length];
        for (int i = 0; i < probabilities.length; i++) {
            diffs[i] = Math.abs(exactProbabilities[i] - probabilities[i]);
        }
        System.out.println("Differences:");
        System.out.println(ArrayUtils.toString(diffs, "%.3f"));
    }

    private static int throwDice() {
        return 1 + random.nextInt(MAXIMUM_DICE_VALUE);
    }

    private static double[] getExactDistribution() {
        int[] frequencies = new int[FREQUENCIES_LENGTH];
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                frequencies[i + j]++;
            }
        }
        int sum = ArrayUtils.sum(frequencies);
        System.out.println("Frequencies:");
        System.out.println(Arrays.toString(frequencies));
        double[] probabilities = new double[FREQUENCIES_LENGTH];
        for (int k = 1; k < frequencies.length; k++) {
            probabilities[k] = (double) frequencies[k] / sum;
        }
        System.out.println("Probabilities:");
        System.out.println(ArrayUtils.toString(probabilities, "%.3f"));
        return probabilities;
    }
}
