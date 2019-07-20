package learn.dsajg6e.ch07list.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0747SparseArrayTest {

    @Test
    public void whenSetThenElementCanBeAccessedByIndex() {
        C0747SparseArray<Integer> arr = new C0747SparseArray<>(4);
        assertThat(arr.length(), is(4));
        arr.set(0, 10);
        assertThat(arr.get(0), is(10));
        assertNull(arr.get(1));
        assertNull(arr.get(2));
        assertNull(arr.get(3));
        arr.set(3, 40);
        arr.set(2, 30);
        assertThat(arr.get(0), is(10));
        assertNull(arr.get(1));
        assertThat(arr.get(2), is(30));
        assertThat(arr.get(3), is(40));
        arr.set(2, 33);
        assertThat(arr.get(0), is(10));
        assertNull(arr.get(1));
        assertThat(arr.get(2), is(33));
        assertThat(arr.get(3), is(40));
    }
}
