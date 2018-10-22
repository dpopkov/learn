/* 1.4.4    Self-avoiding random walks. */
package learn.csia.ch0104;

import learn.csia.utils.CliAppArgs;

public class SelfAvoidingWalk {
    public static void main(String[] args) {
        CliAppArgs cli = new CliAppArgs(args, "Enter lattice size", "Enter number of trails");
        int n = cli.nextInt();
        int trials = cli.nextInt();
        int deadEnds = 0;
        for (int t = 0; t < trials; t++) {
            boolean[][] a = new boolean[n][n];
            int x = n / 2, y = n / 2;
            while (x > 0 && x < n - 1 && y > 0 && y < n - 1) {
                a[x][y] = true;
                if (a[x - 1][y] && a[x + 1][y] && a[x][y - 1] && a[x][y + 1]) {
                    deadEnds++;
                    break;
                }
                double r = Math.random();
                if (r < 0.25 && !a[x + 1][y]) {
                    x++;
                } else if (r < 0.5 && !a[x - 1][y]) {
                    x--;
                } else if (r < 0.75 && !a[x][y + 1]) {
                    y++;
                } else if (r < 1.0 && !a[x][y - 1]) {
                    y--;
                }
            }
        }
        System.out.println(100 * deadEnds / trials + "% dead ends");
    }
}
