package learn.csia.ch0102;

import org.junit.Assert;
import org.junit.Test;

public class LeapYearTest {
    @Test
    public void whenDivisibleBy4ThenLeap() {
        Assert.assertTrue(LeapYear.isLeapYear(2004));
    }

    @Test
    public void whenDivisibleBy100ThenNotLeap() {
        Assert.assertFalse(LeapYear.isLeapYear(1900));
    }

    @Test
    public void whenDivisibleBy400ThenLeap() {
        Assert.assertTrue(LeapYear.isLeapYear(2000));
    }
}
