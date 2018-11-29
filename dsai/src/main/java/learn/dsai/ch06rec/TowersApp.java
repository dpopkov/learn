package learn.dsai.ch06rec;

/**
 * Solves the towers of Hanoi puzzle.
 */
public class TowersApp {
    private static final int NUM_DISKS = 3;

    public static void main(String[] args) {
        int numDisks = NUM_DISKS;
        if (args.length > 0) {
            numDisks = Integer.parseInt(args[0]);
        }
        doTowers(numDisks, 'A', 'B', 'C');
    }

    /**
     * Moves the specified number of disks from the source tower to the destination tower.
     * @param topN number of disks to be moved.
     * @param from source tower
     * @param inter intermediate tower
     * @param to destination tower
     */
    private static void doTowers(int topN, char from, char inter, char to) {
        if (topN == 1) {
            System.out.println("Disk 1 from " + from + " to " + to);
        } else {
            doTowers(topN - 1, from, to, inter);
            System.out.println("Disk " + topN + " from " + from + " to " + to);
            doTowers(topN - 1, inter, from, to);
        }
    }
}
