package learn.ijpds2nd.ch08multiarrays.exer;

import java.util.Scanner;

public class E0809TicTac {
    public static void main(String[] args) {
        E0809TicTac game = new E0809TicTac();
        game.start();
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        E0809Grid grid = new E0809Grid();
        char mark = 'X';
        char winner = 0;
        while (winner == 0) {
            System.out.println(grid);
            System.out.printf("Enter row and column for %s: ", mark);
            int row = in.nextInt();
            int col = in.nextInt();
            grid.set(row, col, mark);
            mark = mark == 'X' ? 'O' : 'X';
            winner = grid.getWinner();
        }
        System.out.println(grid);
        System.out.println("The winner is " + winner);
    }
}
