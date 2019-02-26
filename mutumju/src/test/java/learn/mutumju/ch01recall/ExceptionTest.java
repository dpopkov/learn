package learn.mutumju.ch01recall;

import org.junit.Test;

/**
 * Working with exception handling.
 */
public class ExceptionTest {
    @Test(expected = RuntimeException.class)
    public void testException() {
        throw new RuntimeException();
    }
}
