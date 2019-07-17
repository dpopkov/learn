package learn.dsajg6e.ch07list.exer;

import learn.dsajg6e.ch07list.List;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C0726CircularDynamicArrayListTest {
    @Test
    public void canAddToTheEndAndGetElements() {
        List<Integer> list = new C0726CircularDynamicArrayList<>(1);
        list.add(10);
        list.add(20);
        assertThat(list.toString(), is("[10, 20]"));
        list.add(30);
        assertThat(list.toString(), is("[10, 20, 30]"));
    }

    @Test
    public void canAddInTheMiddleAndGetElements() {
        List<Integer> list = new C0726CircularDynamicArrayList<>(1);
        list.add(10);
        list.add(20);
        assertThat(list.toString(), is("[10, 20]"));
        list.add(1, 15);
        assertThat(list.toString(), is("[10, 15, 20]"));
        list.add(1, 12);
        assertThat(list.toString(), is("[10, 12, 15, 20]"));
    }

    @Test
    public void canAddAtFrontAndGetElements() {
        List<Integer> list = new C0726CircularDynamicArrayList<>(1);
        list.add(20);
        list.add(0, 15);
        assertThat(list.toString(), is("[15, 20]"));
        list.add(0, 12);
        assertThat(list.toString(), is("[12, 15, 20]"));
        list.add(0, 10);
        assertThat(list.toString(), is("[10, 12, 15, 20]"));
    }
}
