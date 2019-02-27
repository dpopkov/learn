package learn.mutumju.ch01recall.rules;

import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.fail;

/**
 * Demonstrates usage of {@code TestWatcher} rule that takes note of the testing action,
 * without modifying it.
 * The {@code TestWatcher} instance listens to every test execution, collects the failure, and
 * success instances, and at the end, prints the result in the afterClass() method.
 */
@Ignore("method testRed fails for demonstration purposes, so the whole test may be ignored")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestWatcherRuleTest {

    private static String dog = "";

    @Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            dog += description.getDisplayName() + " " + "success!\n";
        }

        @Override
        protected void failed(Throwable e, Description description) {
            dog += description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n";
        }
    };

    @Test
    public void testRed() {
        fail();
    }

    @SuppressWarnings("EmptyMethod")
    @Test
    public void testGreen() {
    }

    @AfterClass
    public static void afterClass() {
        System.out.println(dog);
    }
}
