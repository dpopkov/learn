package learn.ijpds2nd.ch07arrays.exer;

public class E0736Board {
    public static final int NOT_FOUND = -1;

    private final int[][] cells;
    private final int size;

    public E0736Board(int size) {
        this.size = size;
        cells = new int[size][size];
    }

    public void place(int id, int row, int col) {
        cells[row][col] = id;
    }

    public int countFreeCellsInAllDirections(int row, int col, int exceptId) {
        int count = 0;
        int r = countFreeCellsInOrthogonalDirections(row, col, exceptId);
        if (r == NOT_FOUND) {
            return NOT_FOUND;
        }
        count += r;
        r = countFreeCellsInDiagonalDirections(row, col, exceptId);
        if (r == NOT_FOUND) {
            return NOT_FOUND;
        }
        count += r;
        if (cells[row][col] == 0) {
            count--;
        }
        return count;
    }

    private int countFreeCellsInOrthogonalDirections(int row, int col, int exceptId) {
        int count = 0;
        for (int c = 0, r = 0; c < size && r < size; c++, r++) {
            int cellInCol = cells[r][col];
            if (cellInCol == 0) {
                count++;
            } else if (cellInCol != exceptId) {
                return NOT_FOUND;
            }
            int cellInRow = cells[row][c];
            if (cellInRow == 0) {
                count++;
            } else if (cellInRow != exceptId) {
                return NOT_FOUND;
            }
        }
        if (cells[row][col] == 0) {
            count--;
        }
        return count;
    }

    private int countFreeCellsInDiagonalDirections(int row, int col, int exceptId) {
        int count = 0;
        int c0 = row >= col ? 0 : col - row;
        int r0 = col >= row ? 0 : row - col;
        for (int c = c0, r = r0; c < size && r < size; c++, r++) {
            if (cells[r][c] == 0) {
                count++;
            } else if (cells[r][c] != exceptId) {
                return NOT_FOUND;
            }
        }
        int last = size - 1;
        if (row <= last - col) {
            r0 = 0;
            c0 = col + row;
        } else {
            r0 = row - (last - col);
            c0 = last;
        }
        for (int c = c0, r = r0; c >= 0 && r < size; c--, r++) {
            if (cells[r][c] == 0) {
                count++;
            } else if (cells[r][c] != exceptId) {
                return NOT_FOUND;
            }
        }
        if (cells[row][col] == 0) {
            count--;
        }
        return count;
    }
}
