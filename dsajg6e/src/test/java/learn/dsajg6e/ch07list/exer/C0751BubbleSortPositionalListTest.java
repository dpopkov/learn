package learn.dsajg6e.ch07list.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0751BubbleSortPositionalListTest {

    @Test
    public void whenBubbleSortThenElementsAreSorted() {
        C0751BubbleSortPositionalList<Integer> list = new C0751BubbleSortPositionalList<>();
        list.addLast(30);
        list.addLast(20);
        list.addLast(10);
        assertThat(list.toString(), is("[30, 20, 10]"));
        list.bubbleSort();
        assertThat(list.toString(), is("[10, 20, 30]"));
    }
}
