package learn.dsajg6e.ch07list.exer;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class C0727ClonedCircularDynamicArrayListTest {
    @Test
    public void whenClonedThenCanChangeElementsIndependently() throws CloneNotSupportedException {
        C0727ClonedCircularDynamicArrayList<Integer> list = new C0727ClonedCircularDynamicArrayList<>();
        list.add(20);
        list.add(0, 10);
        list.add(30);
        C0727ClonedCircularDynamicArrayList<Integer> clone = list.clone();
        assertThat(list.toString(), Matchers.is("[10, 20, 30]"));
        assertThat(clone.toString(), Matchers.is("[10, 20, 30]"));
        list.set(1, 22);
        assertThat(list.toString(), Matchers.is("[10, 22, 30]"));
        assertThat(clone.toString(), Matchers.is("[10, 20, 30]"));
        list.add(0, 5);
        clone.add(35);
        assertThat(list.toString(), Matchers.is("[5, 10, 22, 30]"));
        assertThat(clone.toString(), Matchers.is("[10, 20, 30, 35]"));
    }
}
