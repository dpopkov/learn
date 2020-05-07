package learn.ijpds2nd.ch08multiarrays.exer;

import org.junit.Test;

import static org.junit.Assert.*;

public class E0809GridTest {
    public static final String NL = System.lineSeparator();

    @Test
    public void testEmptyToString() {
        E0809Grid grid = new E0809Grid();
        String result = grid.toString();
        String expected = ""
                + "-------------" + NL
                + "|   |   |   |" + NL
                + "-------------" + NL
                + "|   |   |   |" + NL
                + "-------------" + NL
                + "|   |   |   |" + NL
                + "-------------" + NL;
        assertEquals(expected, result);
    }

    @Test
    public void testNonEmptyToString() {
        E0809Grid grid = new E0809Grid();
        grid.set(0, 0, 'X');
        grid.set(1, 1, 'O');
        grid.set(2, 2, 'X');
        grid.set(1, 2, 'O');
        String result = grid.toString();
        String expected = ""
                + "-------------" + NL
                + "| X |   |   |" + NL
                + "-------------" + NL
                + "|   | O | O |" + NL
                + "-------------" + NL
                + "|   |   | X |" + NL
                + "-------------" + NL;
        assertEquals(expected, result);
    }

    @Test
    public void canFindHorizontalWinner() {
        E0809Grid grid = new E0809Grid();
        grid.set(0, 0, 'X');
        grid.set(0, 1, 'X');
        grid.set(0, 2, 'X');
        char winner = grid.getWinner();
        assertEquals('X', winner);
    }

    @Test
    public void canFindVerticalWinner() {
        E0809Grid grid = new E0809Grid();
        grid.set(0, 1, 'O');
        grid.set(1, 1, 'O');
        grid.set(2, 1, 'O');
        char winner = grid.getWinner();
        assertEquals('O', winner);
    }

    @Test
    public void canFindLeftDiagonalWinner() {
        E0809Grid grid = new E0809Grid();
        grid.set(0, 0, 'X');
        grid.set(1, 1, 'X');
        grid.set(2, 2, 'X');
        char winner = grid.getWinner();
        assertEquals('X', winner);
    }

    @Test
    public void canFindRightDiagonalWinner() {
        E0809Grid grid = new E0809Grid();
        grid.set(0, 2, 'X');
        grid.set(1, 1, 'X');
        grid.set(2, 0, 'X');
        char winner = grid.getWinner();
        assertEquals('X', winner);
    }
}
