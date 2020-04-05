package learn.ijpds2nd.ch06methods.exer;

public class E0630Craps {

    public static void main(String[] args) {
        E0630Dice dice1 = new E0630Dice();
        E0630Dice dice2 = new E0630Dice();
        E0630CrapsGame game = new E0630CrapsGame(
                () -> dice1.roll() + dice2.roll(),
                sum -> System.out.println("You rolled " + sum)
        );
        boolean playing;
        do {
            playing = game.roll();
        } while (playing);
        boolean win = game.youWin();
        System.out.println(win ? "You win!!!" : "You lose");
    }
}
