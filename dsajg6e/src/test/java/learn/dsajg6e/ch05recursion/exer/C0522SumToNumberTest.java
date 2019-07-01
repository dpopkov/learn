package learn.dsajg6e.ch05recursion.exer;

import org.junit.Test;

import static learn.dsajg6e.ch05recursion.exer.C0522SumToNumber.*;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0522SumToNumberTest {

    @Test
    public void testFindSummingTo3() {
        int[] a = {1, 2};
        IntPair rst = findSummingTo(a, 3);
        assertThat(rst.x, is(1));
        assertThat(rst.y, is(2));
    }

    @Test
    public void testFindSummingTo4() {
        int[] a = {1, 2, 3};
        IntPair rst = findSummingTo(a, 4);
        assertThat(rst.x, is(1));
        assertThat(rst.y, is(3));
    }

    @Test
    public void testFindSummingTo4WhenMoreNumbersInArray() {
        int[] a = {1, 2, 3, 5};
        IntPair rst = findSummingTo(a, 4);
        assertThat(rst.x, is(1));
        assertThat(rst.y, is(3));
    }

    @Test
    public void testFindSummingWhenThereIsNoSum() {
        int[] a = {1, 2, 3};
        IntPair rst = findSummingTo(a, 6);
        assertThat(rst, is(NONE));
    }

    @Test
    public void testFindSummingTo7() {
        int[] a = {1, 2, 3, 5};
        IntPair rst = findSummingTo(a, 7);
        assertThat(rst.x, is(2));
        assertThat(rst.y, is(5));
    }

    @Test
    public void testFindSummingTo7WhenThereIsNoSum() {
        int[] a = {1, 8};
        IntPair rst = findSummingTo(a, 7);
        assertThat(rst, is(NONE));
        assertThat(rst.y, is(-1));
    }

    @Test
    public void testFindSummingWhenBigArray() {
        int[] a = {1, 2, 3, 4, 5, 6, 17, 18};
        IntPair rst = findSummingTo(a, 10);
        assertThat(rst.x, is(4));
        assertThat(rst.y, is(6));
    }
}
