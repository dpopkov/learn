package learn.mutumju.ch01recall;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class AssertThatTest {
    @Test
    public void testAssertThat() {
        int age = 30;
        assertThat(age, equalTo(30));
        assertThat(age, is(30));

        assertThat(age, not(equalTo(33)));
        assertThat(age, is(not(33)));
    }

    /* Test compound value matchers. */
    @Test
    public void testMultipleValues() {
        double marks = 100.0;
        assertThat(marks, either(is(100.0)).or(is(90.9)));
        assertThat(marks, both(not(99.99)).and(not(60.0)));
        assertThat(marks, anyOf(is(100.0), is(1.0), is(55.0), is(88.0), is(67.8)));
        assertThat(marks, not(anyOf(is(0.0), is(200.0))));
        assertThat(marks, not(allOf(is(1.0), is(100.0), is(30.0))));
    }

    @Test
    public void testCollectionValues() {
        List<Double> salary = Arrays.asList(50.0, 200.0, 500.0);
        assertThat(salary, hasItem(50.0));
        assertThat(salary, hasItems(50.0, 200.0));
        assertThat(salary, not(hasItem(1.0)));
    }
}
