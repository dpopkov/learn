package learn.mutumju.ch01recall;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * {@code ExpectedException} rule allows to assert the expected exception type
 * and the exception message.
 * For example, your code may throw a generic exception (such as IllegalStateException)
 * for all failure conditions, but you can assert the generic exception message
 * to verify the exact cause.
 */
public class ExpectedExceptionRuleTest {
    /** Object thrown is reset on each test. */
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @SuppressWarnings("EmptyMethod")
    @Test
    public void throwsNothing() {
    }

    @Test
    public void throwsNullPointerException() {
        thrown.expect(NullPointerException.class);
        throw new NullPointerException();
    }

    @Test
    public void throwsIllegalStateExceptionWithMessage() {
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Is this a legal state?");
        throw new IllegalStateException("Is this a legal state?");
    }
}
