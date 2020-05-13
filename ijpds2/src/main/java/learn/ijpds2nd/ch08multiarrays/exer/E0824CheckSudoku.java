package learn.ijpds2nd.ch08multiarrays.exer;

import java.util.BitSet;
import java.util.Scanner;

public class E0824CheckSudoku {
    interface Validator {
        boolean valid(int[][] grid);
    }

    static class RowValidator implements Validator {
        @Override
        public boolean valid(int[][] grid) {
            int size = grid.length;
            BitSet flags = new BitSet(size);
            for (int[] row : grid) {
                flags.clear();
                for (int v : row) {
                    if (v > 0 && v <= size) {
                        flags.set(v - 1);
                    } else {
                        return false;
                    }
                }
                if (flags.cardinality() != size) {
                    return false;
                }
            }
            return true;
        }
    }

    static class ColumnValidator implements Validator {
        @Override
        public boolean valid(int[][] grid) {
            int size = grid.length;
            BitSet flags = new BitSet(size);
            for (int c = 0; c < size; c++) {
                flags.clear();
                for (int[] row : grid) {
                    int v = row[c];
                    if (v > 0 && v <= size) {
                        flags.set(v - 1);
                    } else {
                        return false;
                    }
                }
                if (flags.cardinality() != size) {
                    return false;
                }
            }
            return true;
        }
    }

    static class BlockValidator implements Validator {

        @Override
        public boolean valid(int[][] grid) {
            int size = grid.length;
            BitSet flags = new BitSet(size);
            // todo: implement
            return true;
        }
    }

    static class SudokuSolution {
        private static final int SIZE = 9;
        private int[][] grid;

        /** Constructs the solution for testing purposes. */
        SudokuSolution(int[][] grid) {
            this.grid = grid;
        }

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
            // check rows
            // check columns
            // check blocks
            return false;
        }




    }
}
