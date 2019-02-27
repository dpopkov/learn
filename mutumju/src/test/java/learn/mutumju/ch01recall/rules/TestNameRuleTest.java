package learn.mutumju.ch01recall.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.junit.Assert.assertEquals;

/**
 * Shows that the test name is asserted inside the test.
 * {@code TestName} rule makes the current test name available inside test methods.
 * The {@code TestName} rule can be used in conjunction with the {@code TestWatcher} rule
 * to make a unit testing framework compile a unit testing report.
 */
public class TestNameRuleTest {
    @Rule
    public TestName name = new TestName();

    @Test
    public void testA() {
        assertEquals("testA", name.getMethodName());
    }

    @Test
    public void testB() {
        assertEquals("testB", name.getMethodName());
    }
}
