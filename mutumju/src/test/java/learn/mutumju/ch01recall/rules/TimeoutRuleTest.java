package learn.mutumju.ch01recall.rules;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;

/**
 * The timeout rule applies the same timeout to all the test methods in a class.
 */
@Ignore
public class TimeoutRuleTest {
    @Rule
    public Timeout globalTimeout = new Timeout(20, TimeUnit.MILLISECONDS);

    @Test
    public void testInfiniteLoop1() throws InterruptedException {
        Thread.sleep(30);
    }

    @Test
    public void testInfiniteLoop2() throws InterruptedException {
        Thread.sleep(30);
    }
}
