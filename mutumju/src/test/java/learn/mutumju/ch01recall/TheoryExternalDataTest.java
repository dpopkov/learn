package learn.mutumju.ch01recall;

import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Externalizing data using {@code @ParametersSuppliedBy, @ParameterSupplier}.
 */
@RunWith(Theories.class)
public class TheoryExternalDataTest {
    @Theory
    public void testAddNumbers(
            @ParametersSuppliedBy(NumberSupplier.class) Number num1,
            @ParametersSuppliedBy(NumberSupplier.class) Number num2
    ) {
        System.out.println(num1 + " and " + num2);
        Adder adder = new Adder();
        double expected = num1.doubleValue() + num2.doubleValue();
        double actual = (Double) adder.add(num1, num2);
        assertEquals(actual, expected, 0.01);
    }

    @Theory
    public void testAddStrings(
            @ParametersSuppliedBy(StringSupplier.class) String s1,
            @ParametersSuppliedBy(StringSupplier.class) String s2
    ) {
        System.out.println(s1 + " and " + s2);
        Adder adder = new Adder();
        String expected = s1 + s2;
        Object actual = adder.add(s1, s2);
        assertEquals(actual, expected);
    }
}
