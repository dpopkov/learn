package learn.dsajg6e.ch02oop.exer;

import org.junit.Test;

import static learn.dsajg6e.ch02oop.exer.C0218PredatoryCreditCard.CHARGES_PER_MONTH_LIMIT;
import static learn.dsajg6e.ch02oop.exer.C0218PredatoryCreditCard.MONTH_LIMIT_SURCHARGE;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class C0218PredatoryCreditCardTest {
    private static final int MONTHS_PER_YEAR = 12;

    @Test
    public void whenProcessMonthWithPositiveBalanceThenApplyAnnualRate() {
        C0218PredatoryCreditCard card = make(200, 1000.0, 0.12);
        assertThat(card.getBalance(), is(1000.0));
        for (int i = 0; i < MONTHS_PER_YEAR; i++) {
            card.processMonth();
        }
        assertThat(card.getBalance(), closeTo(1120.0, 1e-7));
    }

    @Test
    public void whenAttemptToOverchargeThenPenalty() {
        C0218PredatoryCreditCard card = make(100, 0, 0.24);
        assertThat(card.getBalance(), is(0.0));
        assertThat(card.charge(150), is(false));
        assertThat(card.charge(200), is(false));
        assertThat(card.getBalance(), is(2 * C0218PredatoryCreditCard.ATTEMPTED_OVERCHARGE_PENALTY));
    }

    @Test
    public void whenLessThan10chargesThenNoSurcharge() {
        C0218PredatoryCreditCard card = make(100, 0, 0.24);
        card.charge(10);
        card.charge(20);
        assertThat(card.getBalance(), is(30.0));
    }

    @Test
    public void whenMoreThan10chargesThenSurcharge() {
        C0218PredatoryCreditCard card = make(100, 0, 0.24);
        final int charges = 20;
        final double price = 2.0;
        for (int i = 0; i < charges; i++) {
            card.charge(price);
        }
        double expected = charges * price + (charges - CHARGES_PER_MONTH_LIMIT) * MONTH_LIMIT_SURCHARGE;
        assertThat(card.getBalance(), is(expected));
    }

    private static C0218PredatoryCreditCard make(int limit, double balance, double rate) {
        return new C0218PredatoryCreditCard("customer", "bank", "account",
                limit, balance, rate);
    }
}