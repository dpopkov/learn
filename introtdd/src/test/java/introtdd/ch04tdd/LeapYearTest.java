package introtdd.ch04tdd;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class LeapYearTest {
    private final LeapYear yearMatcher = new LeapYear();

    @Test
    public void leapYearsAreDivisibleByFour() {
        assertThat(yearMatcher.isLeap(4), is(true));
    }

    @Test
    public void nonLeapYearsAreNotDivisibleByFour() {
        assertThat(yearMatcher.isLeap(5), is(false));
    }

    @Test
    public void leapYearsAreNotDivisibleBy100() {
        assertThat(yearMatcher.isLeap(100), is(false));
    }

    @Test
    public void leapYearsAreDivisibleBy400() {
        assertThat(yearMatcher.isLeap(400), is(true));
    }
}
