/* 1.4.4    Self-avoiding random walks. */
package learn.csia.ch0104.exer;

import learn.csia.utils.CliAppArgs;

public class E010420SelfAvoidingWalk {
    public static void main(String[] args) {
        CliAppArgs cli = new CliAppArgs(args, "Enter lattice size", "Enter number of trails");
        int n = cli.nextInt();
        int trials = cli.nextInt();
        int deadEnds = 0;
        int deadEndsPaths = 0;
        int escapePaths = 0;
        for (int t = 0; t < trials; t++) {
            boolean[][] a = new boolean[n][n];
            int x = n / 2, y = n / 2;
            int path = 0;
            while (x > 0 && x < n - 1 && y > 0 && y < n - 1) {
                a[x][y] = true;
                if (a[x - 1][y] && a[x + 1][y] && a[x][y - 1] && a[x][y + 1]) {
                    deadEnds++;
                    deadEndsPaths += path;
                    break;
                }
                double r = Math.random();
                if (r < 0.25 && !a[x + 1][y]) {
                    x++;
                    path++;
                } else if (r < 0.5 && !a[x - 1][y]) {
                    x--;
                    path++;
                } else if (r < 0.75 && !a[x][y + 1]) {
                    y++;
                    path++;
                } else if (r < 1.0 && !a[x][y - 1]) {
                    y--;
                    path++;
                }
            }
            escapePaths += path;
        }
        System.out.println(100 * deadEnds / trials + "% dead ends");
        System.out.println((double) escapePaths / (trials - deadEnds) + " average escape path");
        System.out.println((double) deadEndsPaths / deadEnds + " average dead end path");
    }
}
