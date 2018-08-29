package learn.csia.ch0103.exer;

/**
1.3.5 Write a program RollLoadedDie that prints the result of rolling a loaded
die such that the probability of getting a 1, 2, 3, 4, or 5 is 1/8 and the probability of
getting a 6 is 3/8.
 */
public class E010305 {
    public static class RollLoadedDie {
        private static double ONE_EIGHTH = 1.0 / 8.0;

        int roll() {
            int choice = (int) (Math.random() / ONE_EIGHTH);   // 0 1 2 3 4 5 6 7
            if (choice < 5) {
                return choice + 1;
            } else {
                return 6;
            }
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        RollLoadedDie d = new RollLoadedDie();
        for (int i = 0, v; i < 10000; i++) {
            v = d.roll();
            counter.add(v);
        }
        System.out.println(counter);
    }
}
