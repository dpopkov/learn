package learn.csia.ch0102.exer;

import org.junit.Assert;
import org.junit.Test;

public class E010215TriangleTest {
    @Test
    public void whenAIsLongThenFalse() {
        Assert.assertFalse(E010215Triangle.canMakeTriangle(10, 3, 4));
    }

    @Test
    public void whenBIsLongThenFalse() {
        Assert.assertFalse(E010215Triangle.canMakeTriangle(10, 30, 4));
    }

    @Test
    public void whenCIsLongThenFalse() {
        Assert.assertFalse(E010215Triangle.canMakeTriangle(10, 30, 400));
    }

    @Test
    public void whenAllAreShortThenTrue() {
        Assert.assertTrue(E010215Triangle.canMakeTriangle(3, 4, 5));
    }
}
