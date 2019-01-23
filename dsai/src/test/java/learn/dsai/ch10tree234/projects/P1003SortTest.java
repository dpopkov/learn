package learn.dsai.ch10tree234.projects;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class P1003SortTest {

    @Test
    public void testSort() {
        List<Long> list = new ArrayList<>(List.of(8L, 3L, 1L, 5L, 4L, 7L, 2L, 6L));
        P1003Sort.sort(list);
        assertThat(list, Is.is(List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L)));
    }
}