package learn.ijpds2nd.ch08multiarrays.exer;

import java.util.Arrays;

public class E0809Grid {
    private static final String NL = System.lineSeparator();
    private static final int SIZE = 3;
    private static final char EMPTY = ' ';

    private final char[][] grid;

    public E0809Grid() {
        grid = new char[SIZE][SIZE];
        initGrid();
    }

    private void initGrid() {
        for (int row = 0; row < SIZE; row++) {
            Arrays.fill(grid[row], EMPTY);
        }
    }

    public void set(int row, int col, char mark) {
        grid[row][col] = mark;
    }

    public char getWinner() {
        char leftDiagonalCell = grid[0][0];
        boolean leftDiagonalWins = leftDiagonalCell != EMPTY;
        char rightDiagonalCell = grid[0][SIZE - 1];
        boolean rightDiagonalWinds = rightDiagonalCell != EMPTY;
        for (int i = 0; i < SIZE; i++) {
            char rowCell = grid[i][0];
            boolean rowWins = rowCell != EMPTY;
            char colCell = grid[0][i];
            boolean colWins = colCell != EMPTY;
            for (int j = 1; (rowWins || colWins) && j < SIZE; j++) {
                if (grid[i][j] != rowCell) {
                    rowWins = false;
                }
                if (grid[j][i] != colCell) {
                    colWins = false;
                }
            }
            if (rowWins) {
                return rowCell;
            }
            if (colWins) {
                return colCell;
            }
            if (grid[i][i] != leftDiagonalCell) {
                leftDiagonalWins = false;
            }
            if (grid[i][SIZE - i - 1] != rightDiagonalCell) {
                rightDiagonalWinds = false;
            }
        }
        if (leftDiagonalWins) {
            return leftDiagonalCell;
        }
        if (rightDiagonalWinds) {
            return rightDiagonalCell;
        }
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------").append(NL);
        for (int i = 0; i < SIZE; i++) {
            sb.append("|");
            for (int j = 0; j < SIZE; j++) {
                sb.append(" ").append(grid[i][j]).append(" ");
                sb.append("|");
            }
            sb.append(NL);
            sb.append("-------------").append(NL);
        }
        return sb.toString();
    }
}
