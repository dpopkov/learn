package learn.csia.ch0102.exer;

import org.junit.Assert;
import org.junit.Test;

public class E010223DayBetweenTest {
    @Test
    public void whenMonthIsBeforeThenFalse() {
        Assert.assertFalse(E010223DayBetween.isBetween(1, 2, "3/01", "4/01"));
    }

    @Test
    public void whenMonthIsAfterThenFalse() {
        Assert.assertFalse(E010223DayBetween.isBetween(1, 5, "3/01", "4/01"));
    }

    @Test
    public void whenFromMonthAfterToMonthThenFail() {
        try {
            Assert.assertFalse(E010223DayBetween.isBetween(1, 5, "5/02", "4/01"));
            Assert.fail("fromDate cannot be after toDate: IllegalArgumentException should rise.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    @Test
    public void whenMonthIsSameAndDayBeforeThenFalse() {
        Assert.assertFalse(E010223DayBetween.isBetween(1, 5, "5/02", "6/01"));
    }

    @Test
    public void whenMonthIsSameAndDayAfterThenFalse() {
        Assert.assertFalse(E010223DayBetween.isBetween(2, 5, "3/02", "5/01"));
    }

    @Test
    public void whenBetweenThenTrue() {
        Assert.assertTrue(E010223DayBetween.isBetween(2, 5, "3/02", "5/03"));
    }
}
