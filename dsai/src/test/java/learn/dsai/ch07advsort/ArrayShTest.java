package learn.dsai.ch07advsort;

import learn.dsai.ch03sorting.ArrayLong;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class ArrayShTest {

    @Test
    public void sort() {
        ArrayLong arr = new ArraySh(10);
        long[] values = {3, 5, 1, 7, 10, 2, 9, 4, 8, 6};
        arr.insert(values);
        arr.sort();
        assertThat(arr.toString(), is("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]"));
    }
}
