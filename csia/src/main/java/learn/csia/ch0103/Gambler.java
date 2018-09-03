package learn.csia.ch0103;

import learn.csia.utils.CliAppArgs;

public class Gambler {
    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Initial stake", "Walkaway goal", "Number of trials");
        int stake = in.nextInt();
        int goal = in.nextInt();
        int trials = in.nextInt();
        int bets = 0;
        int wins = 0;
        for (int i = 0; i < trials; i++) {
            int cash = stake;
            while (cash > 0 && cash < goal) {
                bets++;
                if (Math.random() < 0.5) {
                    cash++;
                } else {
                    cash--;
                }
            }
            if (cash == goal) {
                wins++;
            }
        }
        System.out.println(100 * wins / trials + "% wins");
        System.out.println("Avg # bets: " + bets / trials);
    }
}
