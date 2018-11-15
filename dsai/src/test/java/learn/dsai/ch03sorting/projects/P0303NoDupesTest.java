package learn.dsai.ch03sorting.projects;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0303NoDupesTest {

    @Test
    public void testNoDupes() {
        P0303NoDupes arr = new P0303NoDupes(10);
        arr.insert(2);
        arr.insert(1);
        arr.insert(2);
        arr.insert(3);
        arr.insert(1);
        assertThat(arr.toString(), is("[2, 1, 2, 3, 1]"));
        arr.noDupes();
        assertThat(arr.toString(), is("[1, 2, 3]"));
    }
}