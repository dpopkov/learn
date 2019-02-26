package learn.mutumju.ch01recall;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Ignoring a test.
 * Giving a proper description explains the intention behind ignoring the test.
 */
public class IgnoreTest {
    @Ignore("John's holiday stuff failing")
    @Test
    public void whenTodayIsHolidayThenStopAlarm() {
        assertTrue(Math.random() > 1.0);
    }
}
