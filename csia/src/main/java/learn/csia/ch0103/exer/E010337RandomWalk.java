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
    private enum Direction {
        RIGHT(1, 0), DOWN(0, 1), LEFT(-1, 0), UP(0, -1);

        private final int dx;
        private final int dy;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
    }

    private static final Direction[] directions = Direction.values();
    private static final Random random = new Random();

    private int x;
    private int y;

    public E010337RandomWalk() {
        this.x = 0;
        this.y = 0;
    }

    public void simulate(int n) {
        while (-n <= x && x <= n && -n <= y && y <= n) {
            step();
            System.out.printf("(%d, %d)%n", x, y);
        }
    }

    private void step() {
        Direction dir = directions[random.nextInt(directions.length)];
        x += dir.dx;
        y += dir.dy;
    }

    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter size of square");
        int n = in.nextInt();
        new E010337RandomWalk().simulate(n);
    }
}
