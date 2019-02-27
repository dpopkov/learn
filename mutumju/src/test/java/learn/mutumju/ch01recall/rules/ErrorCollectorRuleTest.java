package learn.mutumju.ch01recall.rules;


import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.CoreMatchers.*;

/**
 * Demonstrates {@code ErrorCollector} rule that allows the execution of a test
 * to continue after the first problem is found.
 * The test will finish its execution, and at the end, notify all errors.
 */
@Ignore("This class demonstrates collecting of fails, so it my be ignored")
public class ErrorCollectorRuleTest {
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void testFailsAfterExecution() {
        collector.checkThat("a", equalTo("b"));
        collector.checkThat(1, equalTo(2));
        collector.checkThat("ae", equalTo("g"));
    }
}
