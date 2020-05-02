package learn.ijpds2nd.ch08multiarrays;

import java.util.Scanner;

public class CheckSudokuSolution {

    private static class SudokuSolution {
        private static final int SIZE = 9;
        private int[][] grid;

        public SudokuSolution(Scanner in) {
            if (in.hasNextInt()) {
                readGrid(in);
            } else {
                String s = in.nextLine();
                throw new IllegalArgumentException("Invalid grid: " + s);
            }
        }

        private void readGrid(Scanner in) {
            grid = new int[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    grid[i][j] = in.nextInt();
                }
            }
        }

        public boolean isValid() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (grid[i][j] < 1 || grid[i][j] > SIZE || !isValid(i, j)) {
                        return false;
                    }
                }
            }
            return true;
        }

        /** Checks that value at the position is valid in the grid. */
        private boolean isValid(int i, int j) {
            // Check uniqueness in i's row
            for (int col = 0; col < SIZE; col++) {
                if (col != j && grid[i][col] == grid[i][j]) {
                    return false;
                }
            }
            // Check uniqueness in j's column
            for (int row = 0; row < SIZE; row++) {
                if (row != i && grid[row][j] == grid[i][j]) {
                    return false;
                }
            }
            // Check uniqueness in the 3-by-3 box
            for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
                for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++) {
                    if (!(row == i && col == j) && grid[row][col] == grid[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter a Sudoku puzzle solution: ");
        SudokuSolution solution = new SudokuSolution(new Scanner(System.in));
        boolean valid = solution.isValid();
        System.out.println(valid ? "Valid solution" : "Invalid solution");
    }
}
