package learn.mutumju.ch01recall;

import org.junit.Assume;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Learning assumptions.
 * If the assumption is not true, the tests are ignored.
 * Assumption is also used in the {@code Before} methods.
 * Assumption is good for use with TDD where one writes pretests ahead of time.
 */
public class AssumptionTest {

    private boolean isSonarRunning = false;

    @SuppressWarnings("ConstantConditions")
    @Test
    public void testVeryCriticalWhenSonarIsRunning() {
        isSonarRunning = true;
        Assume.assumeFalse(isSonarRunning);
        assertTrue(true);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void testVeryCriticalWhenSonarIsNotRunning() {
        isSonarRunning = false;
        Assume.assumeFalse(isSonarRunning);
        assertTrue(true);
    }
}
