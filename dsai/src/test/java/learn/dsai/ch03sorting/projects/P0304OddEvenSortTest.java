package learn.dsai.ch03sorting.projects;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class P0304OddEvenSortTest {

    @Test
    public void sortOddEven() {
        P0304OddEvenSort arr = new P0304OddEvenSort(5);
        arr.insert(4);
        arr.insert(1);
        arr.insert(5);
        arr.insert(3);
        arr.insert(2);
        assertThat(arr.toString(), is("[4, 1, 5, 3, 2]"));
        arr.sortOddEven();
        assertThat(arr.toString(), is("[1, 2, 3, 4, 5]"));
    }
}