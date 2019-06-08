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
    }

    /** Puts an X or O mark at position i, j. */
    public void putMark(int i, int j) {
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
        // TODO: implement
        return false;
    }

    public int winner() {
        if (isWin(X)) {
            return X;
        } else if (isWin(O)) {
            return O;
        } else {
            return EMPTY;
        }
    }

    @Override
    public String toString() {
        // TODO: implement
        return super.toString();
    }

    public static void main(String[] args) {
        // TODO: implement
    }
}
