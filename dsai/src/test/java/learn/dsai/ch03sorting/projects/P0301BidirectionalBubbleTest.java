package learn.dsai.ch03sorting.projects;

import learn.dsai.ch03sorting.ArrayLong;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.assertThat;

public class P0301BidirectionalBubbleTest {

    @Test
    public void testSort() {
        ArrayLong arr = new P0301BidirectionalBubble(5);
        arr.insert(4);
        arr.insert(1);
        arr.insert(5);
        arr.insert(3);
        arr.insert(2);
        assertThat(arr.toString(), is("[4, 1, 5, 3, 2]"));
        arr.sort();
        assertThat(arr.toString(), is("[1, 2, 3, 4, 5]"));
    }
}