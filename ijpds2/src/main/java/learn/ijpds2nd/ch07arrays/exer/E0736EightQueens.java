package learn.ijpds2nd.ch07arrays.exer;

/**
 * Ex. 7.36 - not finished.
 */
public class E0736EightQueens {
    private static final String EMPTY = " ";
    private static final String QUEEN = "Q";

    private final int size;
    private final int[][] cells;
    private final E0736Board board;

    public E0736EightQueens(int size) {
        this.size = size;
        cells = new int[size][size];
        board = new E0736Board(size);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                sb.append("|").append(cells[r][c] == 0 ? EMPTY : QUEEN);
            }
            sb.append("|").append(System.lineSeparator());
        }
        return sb.toString();
    }

    /*
    Начать с кол=0
    Разместить К на ближайшей возможной ячейке.
    Попытаться разместить оставшиеся К на оставшихся столбцах.
    Если получилось
        процесс закончен
    если не получилось
        Перенести К на следующую возможную ячейку
     */
    void startRecursion() {
        int id = 1;
        int col = 0;
        int row = 0;
        placeAtNearestRow(col, row, id);
        boolean ok = placeRecursively(col + 1, id + 1);

    }

    private boolean placeRecursively(int column, int id) {
        return false;
    }

    private void placeAtNearestRow(int currentCol, int startingFromRow, int id) {
        // todo: find place with least damage
        int ct = board.countFreeCellsInAllDirections(startingFromRow, currentCol, id);
    }

    public void start() {
        for (int col = 0; col < size; col++) {
            boolean settled = tryToPutInColumn(col, col + 1);
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
                    settled = tryToPutInColumn(col, col + 1);
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

    private boolean tryToPutInColumn(int col, int id) {
        for (int row = 0; row < size; row++) {
            // todo: m.b. I should count number of fired cells and choose minimal damage
            if (positionIsSafe(row, col)) {
                cells[row][col] = id;
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
        int tmp = cells[fromRow][col];
        cells[fromRow][col] = cells[toRow][col];
        cells[toRow][col] = tmp;
    }

    private int findRowWithQueenOnColumn(int col) {
        for (int row = 0; row < size; row++) {
            if (cells[row][col] != 0) {
                return row;
            }
        }
        return -1;
    }

    private boolean placeQueenOnNextRow(int row, int id) {
        int col = 0;
        while (col < size) {
            if (countFreeCellsInColumn(col) != -1 && diagonalsAreFree(row, col)) {
                cells[row][col] = id;
                return true;
            }
            col++;
        }
        return false;
    }

    private boolean positionIsSafe(int row, int col) {
        if (cells[row][col] != 0) {
            return false;
        }
        return countFreeCellsInRow(row) != -1
                && countFreeCellsInColumn(row) != -1
                && diagonalsAreFree(row, col);
    }

    private boolean diagonalsAreFree(int row, int col) {
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (cells[r][c] != 0) {
                return false;
            }
        }
        for (int r = row + 1, c = col + 1; r < size && c < size; r++, c++) {
            if (cells[r][c] != 0) {
                return false;
            }
        }
        for (int r = row - 1, c = col + 1; r >= 0 && c < size; r--, c++) {
            if (cells[r][c] != 0) {
                return false;
            }
        }
        for (int r = row + 1, c = col - 1; r < size && c >= 0; r++, c--) {
            if (cells[r][c] != 0) {
                return false;
            }
        }
        return true;
    }

    private int countFreeCellsInRow(int row) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (cells[row][i] != 0) {
                return -1;
            }
            count++;
        }
        return count;
    }

    private int countFreeCellsInColumn(int col) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (cells[i][col] != 0) {
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
