package learn.ijpds2nd.ch08multiarrays.exer;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class E0824CheckSudokuTest {
    @Test
    public void testRowValidator() {
        String s = "" +
                "9 6 3 1 7 4 1 5 8\n" +
                "1 7 8 3 2 5 6 4 9\n" +
                "2 5 4 6 8 9 7 3 1\n" +
                "8 2 1 4 3 7 5 9 6\n" +
                "4 9 6 8 5 2 3 1 7\n" +
                "7 3 5 9 6 1 8 2 4\n" +
                "5 8 9 7 1 3 4 6 2\n" +
                "3 1 7 2 4 6 9 8 5\n" +
                "6 4 2 5 9 8 1 7 3";
        int[][] grid = parseGrid(s);
        E0824CheckSudoku.Validator validator = new E0824CheckSudoku.RowValidator();
        assertFalse(validator.valid(grid));
    }

    @Test
    public void testColumnValidator() {
        String s = "" +
                "1 6 3 1 7 4 2 5 8\n" +
                "1 7 8 3 2 5 6 4 9\n" +
                "2 5 4 6 8 9 7 3 1\n" +
                "8 2 1 4 3 7 5 9 6\n" +
                "4 9 6 8 5 2 3 1 7\n" +
                "7 3 5 9 6 1 8 2 4\n" +
                "5 8 9 7 1 3 4 6 2\n" +
                "3 1 7 2 4 6 9 8 5\n" +
                "6 4 2 5 9 8 1 7 3";
        int[][] grid = parseGrid(s);
        E0824CheckSudoku.Validator validator = new E0824CheckSudoku.ColumnValidator();
        assertFalse(validator.valid(grid));
    }

    @Test
    public void testBlockValidatorFalse() {
        String s = "" +
                "1 6 3 1 7 4 2 5 8\n" +
                "1 7 8 3 2 5 6 4 9\n" +
                "2 5 4 6 8 9 7 3 1\n" +
                "8 2 1 4 3 7 5 9 6\n" +
                "4 9 6 8 5 2 3 1 7\n" +
                "7 3 5 9 6 1 8 2 4\n" +
                "5 8 9 7 1 3 4 6 2\n" +
                "3 1 7 2 4 6 9 8 5\n" +
                "6 4 2 5 9 8 1 7 3";
        int[][] grid = parseGrid(s);
        E0824CheckSudoku.Validator validator = new E0824CheckSudoku.BlockValidator();
        assertFalse(validator.valid(grid));
    }

    @Test
    public void testBlockValidatorTrue() {
        String s = "" +
                "9 6 3 1 7 4 2 5 8\n" +
                "1 7 8 3 2 5 6 4 9\n" +
                "2 5 4 6 8 9 7 3 1\n" +
                "8 2 1 4 3 7 5 9 6\n" +
                "4 9 6 8 5 2 3 1 7\n" +
                "7 3 5 9 6 1 8 2 4\n" +
                "5 8 9 7 1 3 4 6 2\n" +
                "3 1 7 2 4 6 9 8 5\n" +
                "6 4 2 5 9 8 1 7 3";
        int[][] grid = parseGrid(s);
        E0824CheckSudoku.Validator validator = new E0824CheckSudoku.BlockValidator();
        assertTrue(validator.valid(grid));
    }

    @Test
    public void testValidTrue() {
        String s = "" +
                "9 6 3 1 7 4 2 5 8\n" +
                "1 7 8 3 2 5 6 4 9\n" +
                "2 5 4 6 8 9 7 3 1\n" +
                "8 2 1 4 3 7 5 9 6\n" +
                "4 9 6 8 5 2 3 1 7\n" +
                "7 3 5 9 6 1 8 2 4\n" +
                "5 8 9 7 1 3 4 6 2\n" +
                "3 1 7 2 4 6 9 8 5\n" +
                "6 4 2 5 9 8 1 7 3";
        int[][] grid = parseGrid(s);
        E0824CheckSudoku.SudokuSolution solution = new E0824CheckSudoku.SudokuSolution(grid);
        assertTrue(solution.isValid());
    }

    @Test
    public void testValidFalse() {
        String s = "" +
                "1 6 3 1 7 4 2 5 8\n" +
                "1 7 8 3 2 5 6 4 9\n" +
                "2 5 4 6 8 9 7 3 1\n" +
                "8 2 1 4 3 7 5 9 6\n" +
                "4 9 6 8 5 2 3 1 7\n" +
                "7 3 5 9 6 1 8 2 4\n" +
                "5 8 9 7 1 3 4 6 2\n" +
                "3 1 7 2 4 6 9 8 5\n" +
                "6 4 2 5 9 8 1 7 3";
        int[][] grid = parseGrid(s);
        E0824CheckSudoku.SudokuSolution solution = new E0824CheckSudoku.SudokuSolution(grid);
        assertFalse(solution.isValid());
    }

    private int[][] parseGrid(String s) {
        String[] lines = s.split("\n");
        int[][] grid = new int[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String[] numbers = line.split(" ");
            grid[i] = new int[numbers.length];
            for (int j = 0; j < numbers.length; j++) {
                grid[i][j] = Integer.parseInt(numbers[j]);
            }
        }
        return grid;
    }
}
