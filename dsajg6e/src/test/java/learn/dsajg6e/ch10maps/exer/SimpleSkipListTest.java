package learn.dsajg6e.ch10maps.exer;

import learn.dsajg6e.ch07list.positional.Position;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class SimpleSkipListTest {

    @Test
    public void canInsert() {
        SkipList<Integer> list = new SimpleSkipList<>(0, 100);
        Position<Integer> pos = list.put(50);
        assertThat(pos.getElement(), is(50));
        pos = list.search(50);
        assertThat(pos.getElement(), is(50));
        pos = list.search(51);
        assertThat(pos.getElement(), is(50));
    }
}
