package learn.ijpds2nd.ch07arrays.exer;

public class E0736EightQueens {
    private static final char EMPTY = ' ';
    private static final char QUEEN = 'Q';

    private int size;
    private char[][] board;

    public E0736EightQueens(int size) {
        this.size = size;
        board = initBoard(size);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                sb.append("|").append(board[r][c]);
            }
            sb.append("|").append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void start() {
        for (int col = 0; col < size; col++) {
            boolean settled = tryToPutInColumn(col);
            if (!settled) {
                boolean movedToSafe = false;
                for (int altCol = 0; !movedToSafe && altCol < size; altCol++) {
                    if (altCol == col) {
                        continue;
                    }
                    int altRow = findRowWithQueenOnColumn(altCol);
                    if (altRow == -1) { // there is no Queen in this altCol - it is useless
                        continue;
                    }
                    for (int destRow = 0; !movedToSafe && destRow < size; destRow++) {
                        if (destRow == altRow) {
                            continue;
                        }
                        if (positionIsSafe(destRow, altCol)) {
                            moveWithinColumn(altCol, altRow, destRow);
                            movedToSafe = true;
                        } else {
                            destRow++;
                        }
                    }
                }
                if (movedToSafe) {
                    settled = tryToPutInColumn(col);
                    if (!settled) {
                        System.out.println("Was able to move other Queen but could not put this queen.");
                    }
                } else {
                    System.out.println("Could not move other Queens");
                }
            }
        }
        System.out.println(this);
    }

    private boolean tryToPutInColumn(int col) {
        for (int row = 0; row < size; row++) {
            // todo: m.b. I should count number of fired cells and choose minimal damage
            if (positionIsSafe(row, col)) {
                board[row][col] = QUEEN;
                return true;
            }
        }
        return false;
    }

    private int findRowWithMinimalDamage(int col) {
        // todo: find position where the queen fires through least number of cells
        return -1;
    }

    private void moveWithinColumn(int col, int fromRow, int toRow) {
        board[fromRow][col] = EMPTY;
        board[toRow][col] = QUEEN;
    }

    private int findRowWithQueenOnColumn(int col) {
        for (int row = 0; row < size; row++) {
            if (board[row][col] == QUEEN) {
                return row;
            }
        }
        return -1;
    }

    private static char[][] initBoard(int size) {
        char[][] board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = EMPTY;
            }
        }
        return board;
    }

    private boolean placeQueenOnNextRow(char[][] a, int row) {
        int col = 0;
        while (col < size) {
            if (countFreeCellsInColumn(a, col) != -1 && diagonalsAreFree(a, row, col)) {
                a[row][col] = QUEEN;
                return true;
            }
            col++;
        }
        return false;
    }

    private boolean positionIsSafe(int row, int col) {
        if (board[row][col] == QUEEN) {
            return false;
        }
        return countFreeCellsInRow(board, row) != -1
                && countFreeCellsInColumn(board, row) != -1
                && diagonalsAreFree(board, row, col);
    }

    private boolean diagonalsAreFree(char[][] a, int row, int col) {
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (a[r][c] == QUEEN) {
                return false;
            }
        }
        for (int r = row + 1, c = col + 1; r < a.length && c < a.length; r++, c++) {
            if (a[r][c] == QUEEN) {
                return false;
            }
        }
        for (int r = row - 1, c = col + 1; r >= 0 && c < a.length; r--, c++) {
            if (a[r][c] == QUEEN) {
                return false;
            }
        }
        for (int r = row + 1, c = col - 1; r < a.length && c >= 0; r++, c--) {
            if (a[r][c] == QUEEN) {
                return false;
            }
        }
        return true;
    }

    private int countFreeCellsInRow(char[][] a, int row) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (a[row][i] == QUEEN) {
                return -1;
            }
            count++;
        }
        return count;
    }

    private int countFreeCellsInColumn(char[][] a, int col) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (a[i][col] == QUEEN) {
                return -1;
            }
            count++;
        }
        return count;
    }

    // todo: put a Queen in position where it fires through least number of cells
    public static void main(String[] args) {
        E0736EightQueens game = new E0736EightQueens(8);
        game.start();
    }
}
