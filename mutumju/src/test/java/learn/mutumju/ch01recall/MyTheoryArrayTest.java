package learn.mutumju.ch01recall;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * Exploring JUnit theories.
 * Whatever a theory asserts is expected to be true for all data sets.
 * Theories are useful for finding bugs in boundary-value cases.
 * When the {@code @DataPoints} annotation is used then
 * the theory will be executed with all possible combinations of data in array.
 */
@RunWith(Theories.class)
public class MyTheoryArrayTest {
    @DataPoints
    public static char[] chars = {'A', 'B', 'C'};

    @Theory
    public void build(char c, char d) {
        System.out.println(c + " " + d);
    }
}
