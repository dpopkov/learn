package learn.mutumju.ch01recall;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Creating parameterized methods.
 */
@RunWith(Parameterized.class)
public class FactorialParameterizedMethodTest {
    /** Dataset for factorial algorithm. The arrays contain the number and the expected result. */
    @Parameterized.Parameters(name = "{index}: factorial({0}) = {1}")
    public static Collection<Object[]> factorialData() {
        return Arrays.asList(new Object[][]{
                {0, 1}, {1, 1}, {2, 2}, {3, 6}, {4, 24}, {5, 120}, {6, 720}
        });
    }

    /** Holds the input number at 0th index. */
    @SuppressWarnings("DefaultAnnotationParam")
    @Parameterized.Parameter(value = 0)
    public int number;
    /** Holds the expected factorial result at 1st index. */
    @Parameterized.Parameter(value = 1)
    public int expectedResult;

    @Test
    public void testFactorial() {
        Factorial fact = new Factorial();
        assertEquals(fact.factorial(number), expectedResult);
    }
}
