package learn.csia.ch0103.exer;

import learn.csia.utils.Format;

import java.util.Random;

/**
 * 1.3.42 A contestant is presented with three doors. Behind one of them is a valuable prize. After the contestant
 * chooses a door, the host opens one of the other two doors. The contestant is then given the opportunity
 * to switch to the other door. Should the contestant do so?
 * The program should take a commandline argument n, play the game n times using each of the two strategies,
 * and print the chance of success for each of the two strategies.
 */
public class E010342MontyHallGame {
    private static final Random RANDOM = new Random();
    private static final int NUM_DOORS = 3;

    private static final boolean[] doors;
    static {
        doors = new boolean[NUM_DOORS];
        doors[doors.length - 1] = true;
    }

    public static void main(String[] args) {
        int numTests = 10000;
        int wonSwitched = 0;
        int wonNotSwitched = 0;
        for (int i = 0; i < numTests; i++) {
            int choice1 = RANDOM.nextInt(NUM_DOORS);
            if (doors[choice1]) {
                wonNotSwitched++;
            }
            int notPrize = chooseRandomExceptRange(NUM_DOORS - 1, choice1);
            int choice2 = chooseRandomExceptRange(NUM_DOORS, choice1, notPrize);
            if (doors[choice2]) {
                wonSwitched++;
            }
        }
        System.out.println("    Switched: " + Format.percent(wonSwitched, numTests));
        System.out.println("Not Switched: " + Format.percent(wonNotSwitched, numTests));
    }

    private static int chooseRandomExceptRange(int limit, Integer... range) {
        int r;
        do {
            r = RANDOM.nextInt(limit);
        } while(inRange(r, range));
        return r;
    }

    private static boolean inRange(int r, Integer[] range) {
        boolean found = false;
        for (int n : range) {
            if (r == n) {
                found = true;
                break;
            }
        }
        return found;
    }
}
