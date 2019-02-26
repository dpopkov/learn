package learn.mutumju.ch01recall;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Exploring the {@code @RunWith} annotation.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({SanityTest.class, ExceptionTest.class})
public class RunWithHowTo {
}
