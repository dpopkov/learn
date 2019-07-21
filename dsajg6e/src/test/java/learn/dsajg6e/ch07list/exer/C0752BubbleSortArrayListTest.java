package learn.dsajg6e.ch07list.exer;

import learn.dsajg6e.ch07list.ArrayList;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0752BubbleSortArrayListTest {

    @Test
    public void whenBubbleSortThenElementsAreSorted() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(30);
        list.add(20);
        list.add(10);
        assertThat(list.toString(), is("[30, 20, 10]"));
        C0752BubbleSortArrayList.sort(list);
        assertThat(list.toString(), is("[10, 20, 30]"));
    }
}
