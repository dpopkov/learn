package learn.ijpds2nd.ch06methods.exer;

import java.util.function.IntConsumer;

public class E0632CrapsStatistics {
    public static void main(String[] args) {
        E0630Dice dice1 = new E0630Dice();
        E0630Dice dice2 = new E0630Dice();
        int total = 0;
        int totalWins = 0;
        E0630Roller roller = () -> dice1.roll() + dice2.roll();
        IntConsumer dummyPrinter = sum -> { };
        for (int i = 0; i < 15_000; i++) {
            E0630CrapsGame game = new E0630CrapsGame(roller, dummyPrinter);
            boolean playing;
            do {
                playing = game.roll();
            } while (playing);
            total++;
            if (game.youWin()) {
                totalWins++;
            }
        }
        double rate = (double) totalWins / total;
        System.out.printf("Number of wins: %d from %d%n", totalWins, total);
        System.out.printf("Chance of winning is %.2f%%%n", rate * 100);
    }
}
