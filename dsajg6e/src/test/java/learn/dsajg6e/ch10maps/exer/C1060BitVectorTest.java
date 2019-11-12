package learn.dsajg6e.ch10maps.exer;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class C1060BitVectorTest {

    @Test
    public void testContains() {
        C1060BitVector vector = new C1060BitVector(100);
        assertThat(vector.contains(42), Matchers.is(false));
        vector.add(42);
        assertThat(vector.contains(42), Matchers.is(true));
    }
}
