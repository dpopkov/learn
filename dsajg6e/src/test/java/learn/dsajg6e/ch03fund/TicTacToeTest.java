package learn.dsajg6e.ch03fund;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class TicTacToeTest {

    @Test
    public void testIsWinRow() {
        TicTacToe ttt = new TicTacToe();
        assertThat(ttt.isWin(TicTacToe.X), is(false));
        ttt.putMark(0,0);
        ttt.putMark(1,0);
        ttt.putMark(0,1);
        ttt.putMark(1,1);
        ttt.putMark(0,2);
        assertThat(ttt.isWin(TicTacToe.X), is(true));
    }

    @Test
    public void testIsWinCol() {
        TicTacToe ttt = new TicTacToe();
        assertThat(ttt.isWin(TicTacToe.X), is(false));
        ttt.putMark(0,2);
        ttt.putMark(1,0);
        ttt.putMark(1,2);
        ttt.putMark(1,1);
        ttt.putMark(2,2);
        assertThat(ttt.isWin(TicTacToe.X), is(true));
    }

    @Test
    public void testIsWinDiagonal() {
        TicTacToe ttt = new TicTacToe();
        assertThat(ttt.isWin(TicTacToe.X), is(false));
        ttt.putMark(0,0);
        ttt.putMark(1,0);
        ttt.putMark(1,1);
        ttt.putMark(0,1);
        ttt.putMark(2,2);
        assertThat(ttt.isWin(TicTacToe.X), is(true));
    }
}
