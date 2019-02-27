package learn.mutumju.ch01recall;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Verifier;

import static org.junit.Assert.assertNull;

/**
 * Demonstrates usage of {@code Verifier} rule which can turn passing tests into
 * failing tests if a verification check fails.
 * Verifier’s verify method is executed after each test execution. If the verify method
 * defines any assertions, and that assertion fails, then the test is marked as failed
 */
@Ignore("This test demonstrates failing by rule, so it may be ignored")
public class VerifierRuleTest {

    private String errorMsg = null;

    @Rule
    public TestRule rule = new Verifier() {
        @Override
        protected void verify() {
            assertNull("errorMsg should be null after each test execution", errorMsg);
        }
    };

    @Test
    public void testName() {
        errorMsg = "Giving a value";
    }
}
