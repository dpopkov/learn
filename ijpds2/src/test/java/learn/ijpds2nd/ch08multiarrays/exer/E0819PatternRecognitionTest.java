package learn.ijpds2nd.ch08multiarrays.exer;

import org.junit.Test;

import static org.junit.Assert.*;

public class E0819PatternRecognitionTest {
    @Test
    public void testDoesNotContainConsecutive() {
        int[][] a = {{1, 2}, {3, 4}};
        boolean r = E0819PatternRecognition.containsConsecutive(a, 2);
        assertFalse(r);
    }

    @Test
    public void testContainsConsecutiveRow() {
        int[][] a = {{1, 2}, {3, 3}};
        boolean r = E0819PatternRecognition.containsConsecutive(a, 2);
        assertTrue(r);
    }

    @Test
    public void testContainsConsecutiveColumn() {
        int[][] a = {{1, 2}, {3, 2}};
        boolean r = E0819PatternRecognition.containsConsecutive(a, 2);
        assertTrue(r);
    }

    @Test
    public void testContainsConsecutiveLeftDiagonal() {
        int[][] a = {
                {5, 3, 2, 1, 6},
                {6, 5, 3, 6, 1},
                {1, 3, 6, 3, 4},
                {3, 2, 3, 3, 3}
        };
        boolean r = E0819PatternRecognition.containsConsecutive(a, 4);
        assertTrue(r);
    }

    @Test
    public void testContainsConsecutiveLeftDiagonalFromSecondRow() {
        int[][] a = {
                {5, 3, 2, 1, 6},
                {6, 6, 1, 5, 1},
                {1, 6, 2, 3, 4},
                {3, 2, 6, 6, 3}
        };
        boolean r = E0819PatternRecognition.containsConsecutive(a, 3);
        assertTrue(r);
    }

    @Test
    public void testContainsConsecutiveRightDiagonal() {
        int[][] a = {
                {5, 6, 2, 1, 6},
                {6, 5, 6, 6, 1},
                {1, 3, 6, 1, 4},
                {3, 6, 3, 3, 4}
        };
        boolean r = E0819PatternRecognition.containsConsecutive(a, 4);
        assertTrue(r);
    }
}
