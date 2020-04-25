package learn.ijpds2nd.ch07arrays.exer;

import org.junit.Test;

import static org.junit.Assert.*;

public class E0736BoardTest {

    public static final int ID = -42;

    @Test
    public void whenEmptyBoardSize3ThenCountFromCenterReturns9() {
        E0736Board board = new E0736Board(3);
        int r = board.countFreeCellsInAllDirections(1, 1, ID);
        assertEquals(9, r);
    }

    @Test
    public void when_Size3_Then_Should_Return8() {
        E0736Board board = new E0736Board(3);
        board.place(ID, 1, 1);
        int r = board.countFreeCellsInAllDirections(1, 1, ID);
        assertEquals(8, r);
    }

    @Test
    public void when_Size5_Then_Should_Return16() {
        E0736Board board = new E0736Board(5);
        board.place(ID, 2, 2);
        int r = board.countFreeCellsInAllDirections(2, 2, ID);
        assertEquals(16, r);
    }

    @Test
    public void when_Size3AndPlacedAt1And0_Then_Should_Return6() {
        E0736Board board = new E0736Board(3);
        board.place(ID, 1, 0);
        int r = board.countFreeCellsInAllDirections(1, 0, ID);
        assertEquals(6, r);
    }

    @Test
    public void when_Size3AndPlacedAt1And2WithOtherId_Then_Should_ReturnMinus1() {
        E0736Board board = new E0736Board(3);
        board.place(42, 0, 1);
        int r = board.countFreeCellsInAllDirections(1, 2, ID);
        assertEquals(E0736Board.NOT_FOUND, r);
    }
}
