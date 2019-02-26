package learn.mutumju.ch01recall;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Exploring the test suite.
 * During the execution the suite will execute all the specified tests.
 * A test suite is created for group-related tests such as a group of data access,
 * API usage tests, or a group of input validation logic tests.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({AssertTest.class, ExecutionOrderTest.class, AssumptionTest.class})
public class SuiteTest {
}
