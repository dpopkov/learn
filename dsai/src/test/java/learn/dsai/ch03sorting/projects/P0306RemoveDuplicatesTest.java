package learn.dsai.ch03sorting.projects;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class P0306RemoveDuplicatesTest {

    @Test
    public void removeDuplicates() {
        P0306RemoveDuplicates arr = new P0306RemoveDuplicates(10);
        arr.insert(2);
        arr.insert(1);
        arr.insert(2);
        arr.insert(3);
        arr.insert(3);
        arr.insert(3);
        arr.insert(3);
        arr.insert(1);
        arr.removeDuplicates();
        assertThat(arr.toString(), is("[1, 2, 3]"));
    }
}
