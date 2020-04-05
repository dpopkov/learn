package learn.ijpds2nd.ch06methods.exer;

import org.junit.Test;

import java.util.function.IntConsumer;

import static org.junit.Assert.*;

public class E0630CrapsGameTest {

    private final IntConsumer dummyPrinter = i -> {};

    @Test
    public void when11ThenWin() {
        E0630CrapsGame game = new E0630CrapsGame(() -> 11, dummyPrinter);
        boolean goesOn = game.roll();
        assertFalse(goesOn);
        assertTrue(game.youWin());
    }

    @Test
    public void when3ThenLose() {
        E0630CrapsGame game = new E0630CrapsGame(() -> 3, dummyPrinter);
        boolean goesOn = game.roll();
        assertFalse(goesOn);
        assertFalse(game.youWin());
    }

    @Test
    public void when8and8ThenPointEstablishedAndWin() {
        E0630Roller roller = new SequenceRoller(new int[] {8, 8});
        E0630CrapsGame game = new E0630CrapsGame(roller, dummyPrinter);
        boolean goesOn = game.roll();
        assertTrue(goesOn);
        goesOn = game.roll();
        assertFalse(goesOn);
        assertTrue(game.youWin());
    }

    @Test
    public void when5and7ThenPointEstablishedAndLose() {
        E0630Roller roller = new SequenceRoller(new int[] {5, 7});
        E0630CrapsGame game = new E0630CrapsGame(roller, dummyPrinter);
        boolean goesOn = game.roll();
        assertTrue(goesOn);
        goesOn = game.roll();
        assertFalse(goesOn);
        assertFalse(game.youWin());
    }

    private static class SequenceRoller implements E0630Roller {
        private final int[] values;
        private int idx = 0;

        SequenceRoller(int[] values) {
            this.values = values;
        }

        @Override
        public int roll() {
            return values[idx++];
        }
    }
}
