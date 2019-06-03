package learn.dsajg6e.ch02oop;

import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class PredatoryCreditCardTest {
    private static final int MONTHS_PER_YEAR = 12;

    @Test
    public void whenProcessMonthWithPositiveBalanceThenApplyAnnualRate() {
        PredatoryCreditCard card = make(200, 1000.0, 0.12);
        assertThat(card.getBalance(), is(1000.0));
        for (int i = 0; i < MONTHS_PER_YEAR; i++) {
            card.processMonth();
        }
        assertThat(card.getBalance(), closeTo(1120.0, 1e-7));
    }

    @Test
    public void whenAttemptToOverchargeThenPenalty() {
        PredatoryCreditCard card = make(100, 0, 0.24);
        assertThat(card.getBalance(), is(0.0));
        assertThat(card.charge(150), is(false));
        assertThat(card.charge(200), is(false));
        assertThat(card.getBalance(), is(2 * PredatoryCreditCard.ATTEMPTED_OVERCHARGE_PENALTY));
    }

    private static PredatoryCreditCard make(int limit, double balance, double rate) {
        return new PredatoryCreditCard("customer", "bank", "account",
                limit, balance, rate);
    }
}