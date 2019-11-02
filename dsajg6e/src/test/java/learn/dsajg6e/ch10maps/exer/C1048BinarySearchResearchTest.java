package learn.dsajg6e.ch10maps.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C1048BinarySearchResearchTest {

    @Test
    public void canFindExactValue() {
        Integer[] data = {3, 5, 7, 11, 13, 17, 19};
        var binSearch = new C1048BinarySearchResearch<>(data);
        int idx = binSearch.findIndex(11);
        assertThat(idx, is(3));
        assertThat(data[idx], is(11));
    }

    @Test
    public void canFindPositionOfGreaterElement() {
        Integer[] data = {3, 5, 7, 11, 13, 17, 19};
        var binSearch = new C1048BinarySearchResearch<>(data);
        int idx = binSearch.findIndex(6);
        assertThat(idx, is(2));
        assertThat(data[idx], is(7));
    }

    @Test
    public void canFindPositionOfCeiling() {
        Integer[] data = {3, 5, 7, 7, 11, 13, 17, 19};
        var binSearch = new C1048BinarySearchResearch<>(data);
        int idx = binSearch.findIndex(11);
        assertThat(idx, is(4));
        assertThat(data[idx], is(11));
        idx = binSearch.findIndex(10);
        assertThat(idx, is(4));
        assertThat(data[idx], is(11));
    }
}
