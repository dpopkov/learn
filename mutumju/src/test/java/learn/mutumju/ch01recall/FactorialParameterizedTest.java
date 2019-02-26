package learn.mutumju.ch01recall;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Creating parameterized tests.
 */
@RunWith(Parameterized.class)
public class FactorialParameterizedTest {
    /** Dataset for factorial algorithm. The arrays contain the number and the expected result. */
    @Parameterized.Parameters(name = "{index}: factorial({0}) = {1}")
    public static Collection<Object[]> factorialData() {
        return Arrays.asList(new Object[][]{
                {0, 1}, {1, 1}, {2, 2}, {3, 6}, {4, 24}, {5, 120}, {6, 720}
        });
    }

    /** Holds the input number. */
    private final int number;
    /** Holds the expected factorial result. */
    private final int expectedResult;

    public FactorialParameterizedTest(int number, int expectedResult) {
        this.number = number;
        this.expectedResult = expectedResult;
    }

    @Test
    public void testFactorial() {
        Factorial fact = new Factorial();
        assertEquals(fact.factorial(number), expectedResult);
    }
}
