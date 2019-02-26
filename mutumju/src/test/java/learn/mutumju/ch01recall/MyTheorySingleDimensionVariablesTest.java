package learn.mutumju.ch01recall;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * Exploring JUnit theories.
 * Whatever a theory asserts is expected to be true for all data sets.
 * Theories are useful for finding bugs in boundary-value cases.
 * When the multiple {@code @DataPoint} annotations are defined in a test,
 * the theories apply to all possible well-typed combinations of data points
 * for the test arguments.
 */
@RunWith(Theories.class)
public class MyTheorySingleDimensionVariablesTest {
    @DataPoint
    public static String jack = "Jack";
    @DataPoint
    public static String mike = "Mike";

    @Theory
    public void sanity(String firstName, String lastName) {
        System.out.println("Sanity check " + firstName + ", " + lastName);
    }
}
