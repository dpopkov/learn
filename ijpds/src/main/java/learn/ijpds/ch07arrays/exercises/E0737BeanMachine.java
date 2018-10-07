/*
7.37
Bean machine.
 */
package learn.ijpds.ch07arrays.exercises;

import learn.csia.utils.CliAppArgs;

public class E0737BeanMachine {
    public static void main(String[] args) {
        CliAppArgs cli = new CliAppArgs(args, "Number of slots", "Number of balls");
        int numSlots = cli.nextInt();
        int numBalls = cli.nextInt();
        int[] slots = new int[numSlots];
        for (int i = 0; i < numBalls; i++) {
            String path = generatePath(numSlots);
            int index = count(path, 'R');
            slots[index]++;
        }
        for (int i = 0; i < slots.length; i++) {
            System.out.printf("%2d : %d : %.1f%%%n", i, slots[i], (double)slots[i] / numBalls * 100);
        }
    }

    @SuppressWarnings("SameParameterValue")
    private static int count(String s, char ch) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            if (ch == s.charAt(i)) {
                total++;
            }
        }
        return total;
    }

    private static String generatePath(int numSlots) {
        int length = numSlots - 1;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(Math.random() > 0.5 ? 'L' : 'R');
        }
        return sb.toString();
    }
}
