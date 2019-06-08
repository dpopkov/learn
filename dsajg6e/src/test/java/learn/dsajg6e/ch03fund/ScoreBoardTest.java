package learn.dsajg6e.ch03fund;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class ScoreBoardTest {
    private final GameEntry e5 = new GameEntry("e5", 5);
    private final GameEntry e10 = new GameEntry("e10", 10);
    private final GameEntry e20 = new GameEntry("e20", 20);
    private final GameEntry e30 = new GameEntry("e30", 30);

    @Test
    public void whenAddScoreThenInsertInDescendingOrder() {
        ScoreBoard board = new ScoreBoard(3);
        board.add(e20);
        assertBoard(board, e20);
        board.add(e30);
        assertBoard(board, e30, e20);
        board.add(e10);
        assertBoard(board, e30, e20, e10);
        board.add(e5);
        assertBoard(board, e30, e20, e10);
    }

    @Test
    public void whenAddGreaterScoreThenAllElementsShiftRight() {
        ScoreBoard board = new ScoreBoard(2);
        board.add(e5, e10, e20);
        assertBoard(board, e20, e10);
    }

    @Test
    public void whenRemoveThenElementsShiftedLeft() {
        ScoreBoard board = new ScoreBoard(4);
        GameEntry ge;
        board.add(e5, e10, e20, e30);

        ge = board.remove(3);
        assertThat(ge, is(e5));
        assertBoard(board, e30, e20, e10);

        ge = board.remove(1);
        assertBoard(board, e30, e10);
        assertThat(ge, is(e20));

        ge = board.remove(0);
        assertBoard(board, e10);
        assertThat(ge, is(e30));

        ge = board.remove(0);
        assertThat(ge, is(e10));
        assertThat(board.size(), is(0));
    }

    private static void assertBoard(ScoreBoard board, GameEntry... entries) {
        for (int i = 0; i < entries.length; i++) {
            assertThat(board.get(i), is(entries[i]));
        }
    }
}
