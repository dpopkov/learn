package learn.dsajg6e.ch10maps.exer;

import learn.dsajg6e.ch07list.positional.Position;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class SimpleSkipListTest {

    @Test
    public void canInsert() {
        SkipList<Integer> list = new IntegerSkipList();
        Position<Integer> pos = list.put(50);
        assertThat(pos.getElement(), is(50));
        pos = list.skipSearch(50);
        assertThat(pos.getElement(), is(50));
        pos = list.skipSearch(51);
        assertThat(pos.getElement(), is(50));
    }

    // todo: write more tests
}
