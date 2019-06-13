package learn.dsajg6e.ch03fund;

/**
 * CF 3.9-3.10
 * Simulation of a Tic-Tac-Toe game (does not do strategy).
 */
public class TicTacToe {
    public static final int X = 1, O = -1;
    public static final int EMPTY = 0;
    private static final int SIZE = 3;

    private final int[][] board = new int[SIZE][SIZE];
    private int player;
    private boolean gameOver;   // added for exercise R-3.4

    public TicTacToe() {
        clearBoard();
    }

    private void clearBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
        player = X;
        gameOver = false;
    }

    /** Puts an X or O mark at position i, j. */
    public void putMark(int i, int j) {
        if (gameOver) {
            throw new IllegalStateException("Game is over. You can not put marks.");
        }
        if (i < 0 || i > SIZE - 1 || j < 0 || j > SIZE - 1) {
            throw new IllegalArgumentException("Invalid board position");
        }
        if (board[i][j] != EMPTY) {
            throw new IllegalArgumentException("Board position occupied");
        }
        board[i][j] = player;
        player = -player;
    }

    public boolean isWin(int mark) {
        boolean leftDiagonalWins = true;
        boolean rightDiagonalWins = true;
        for (int i = 0; i < SIZE; i++) {
            boolean rowWins = true;
            boolean colWins = true;
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != mark) {
                    rowWins = false;
                }
                if (board[j][i] != mark) {
                    colWins = false;
                }
            }
            if (rowWins || colWins) {
                return true;
            }
            if (board[i][i] != mark) {
                leftDiagonalWins = false;
            }
            if (board[i][SIZE - 1 - i] != mark) {
                rightDiagonalWins = false;
            }
        }
        return leftDiagonalWins || rightDiagonalWins;
    }

    public int winner() {
        if (isWin(X)) {
            gameOver = true;
            return X;
        } else if (isWin(O)) {
            gameOver = true;
            return O;
        } else {
            return EMPTY;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sb.append(symbol(board[i][j]));
                sb.append(' ');
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private char symbol(int i) {
        if (i == X) {
            return 'X';
        } else if (i == O) {
            return 'O';
        } else {
            return ' ';
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        putMarks(game, 1, 1, 0, 2,
                2, 2, 0, 0,
                0, 1, 2, 1,
                1, 2, 1, 0,
                2, 0
        );
        System.out.println(game);
        int winning = game.winner();
        String[] outcome = {"O wins", "Tie", "X wins"};
        System.out.println(outcome[1 + winning]);
    }

    private static void putMarks(TicTacToe game, int... xy) {
        for (int i = 0; i < xy.length; i += 2) {
            game.putMark(xy[i], xy[i + 1]);
        }
    }
}
