package learn.mutumju.ch01recall;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Working with timeouts.
 * The test will fail after the specified timeout.
 */
public class TimeoutTest {
    @Ignore // ignore this test though failing is planned
    @Test(timeout = 10)
    public void testForever() throws InterruptedException {
        Thread.sleep(20_0000L);
    }
}
