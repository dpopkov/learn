package learn.ijpds2nd.ch03select.exer;

import org.junit.Test;

import static learn.ijpds2nd.ch03select.exer.E0315Lottery3Digits.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class E0315Lottery3DigitsTest {

    @Test
    public void testGuessMatchesLottery() {
        assertEquals(WHOLE_MATCH, calculateAward(999, 999));
    }

    @Test
    public void testAllDigitsMatch() {
        assertEquals(ALL_DIGITS, calculateAward(123, 321));
        assertEquals(ALL_DIGITS, calculateAward(113, 311));
    }

    @Test
    public void testOneDigitMatches() {
        assertEquals(ONE_DIGIT, calculateAward(123, 104));
        assertEquals(ONE_DIGIT, calculateAward(123, 703));
    }

    @Test
    public void testNoMatch() {
        assertEquals(NO_MATCH, calculateAward(123, 456));
    }

    @Test
    public void testSort() {
        int[] a = {3, 2, 1};
        sortThreeDigits(a);
        assertThat(a, is(new int[]{1, 2, 3}));

        a = new int[]{1, 33, 2};
        sortThreeDigits(a);
        assertThat(a, is(new int[]{1, 2, 33}));

        a = new int[]{2, 44, 1};
        sortThreeDigits(a);
        assertThat(a, is(new int[]{1, 2, 44}));
    }
}
