package learn.csia.ch0103.exer;

import learn.csia.utils.CliAppArgs;

import java.util.Random;

/**
 * 1.3.37 2D random walk. A two-dimensional random walk simulates the behavior
 * of a particle moving in a grid of points. At each step, the random walker moves
 * north, south, east, or west with probability equal to 1/4, independent of previous
 * moves. Write a program RandomWalker that takes an integer command-line argument n and
 * estimates how long it will take a random walker to hit the boundary of
 * a 2n-by-2n square centered at the starting point.
 */
public class E010337RandomWalk {
    private Random random = new Random();

    public void simulate(int n) {
        int x = 0;
        int y = 0;
        while (-n <= x && x <= n && -n <= y && y <= n) {
            int direction = random.nextInt(4);
            switch (direction) {
                case 0: x++; break;
                case 1: y--; break;
                case 2: x--; break;
                case 3: y++; break;
            }
            System.out.printf("(%d, %d)%n", x, y);
        }
    }

    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter size of square");
        int n = in.nextInt();
        new E010337RandomWalk().simulate(n);
    }
}
