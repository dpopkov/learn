package learn.dsai.ch06rec.stacktriangle;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class StackTriangleTest {

    @Test
    public void testCalculate1() {
        StackTriangle st = new StackTriangle();
        int result = st.calculate(1);
        assertThat(result, is(1));
    }

    @Test
    public void testCalculate3() {
        StackTriangle st = new StackTriangle();
        int result = st.calculate(3);
        assertThat(result, is(6));
    }

    @Test
    public void testCalculateAndCalculate() {
        StackTriangle st = new StackTriangle();
        int result = st.calculate(4);
        assertThat(result, is(10));
        result = st.calculate(5);
        assertThat(result, is(15));
    }
}
