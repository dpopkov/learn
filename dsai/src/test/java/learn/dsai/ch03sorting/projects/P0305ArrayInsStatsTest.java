package learn.dsai.ch03sorting.projects;

import learn.dsai.ch03sorting.ArrayLong;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class P0305ArrayInsStatsTest {

    @Test
    public void testSort() {
        P0305ArrayInsStats arr = new P0305ArrayInsStats(5);
        arr.insert(4);
        arr.insert(1);
        arr.insert(5);
        arr.insert(3);
        arr.insert(2);
        assertThat(arr.toString(), is("[4, 1, 5, 3, 2]"));
        arr.insertionSort();
        assertThat(arr.toString(), is("[1, 2, 3, 4, 5]"));
    }

    /** Test is for the sake of getting number of comparisons and copies. */
    @Test
    public void testSortInversed() {
        P0305ArrayInsStats arr = new P0305ArrayInsStats(100);
        fillInversed(arr);
        arr.insertionSort();
        assertThat(arr.isNotFull(), is(false));
    }

    /** Test is for the sake of getting number of comparisons and copies. */
    @Test
    public void testSortSorted() {
        P0305ArrayInsStats arr = new P0305ArrayInsStats(100);
        fillSorted(arr);
        arr.insertionSort();
        assertThat(arr.isNotFull(), is(false));
    }

    private static void fillSorted(ArrayLong arr) {
        int value = 1;
        while (arr.isNotFull()) {
            arr.insert(value++);
        }
    }

    private static void fillInversed(ArrayLong arr) {
        int value = arr.getMaxCapacity();
        while (arr.isNotFull()) {
            arr.insert(value--);
        }
    }
}