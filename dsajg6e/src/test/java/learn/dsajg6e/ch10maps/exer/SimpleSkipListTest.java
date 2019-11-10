package learn.dsajg6e.ch10maps.exer;

import learn.dsajg6e.ch07list.positional.Position;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class SimpleSkipListTest {

    @Test
    public void canInsert() {
        AbstractSkipList<Integer> list = new IntegerSkipList();
        Position<Integer> pos = list.put(50);
        assertThat(list.size(), is(1));
        assertThat(pos.getElement(), is(50));
        pos = list.skipSearch(50);
        assertThat(pos.getElement(), is(50));
        pos = list.skipSearch(51);
        assertThat(pos.getElement(), is(50));
    }

    @Test
    public void canInsertMany() {
        AbstractSkipList<Integer> list = new IntegerSkipList();
        Integer[] keys = {38, 40, 50, 20, 31, 42, 25, 55, 17};
        for (int i = 0; i < keys.length; i++) {
            Integer key = keys[i];
            assertPutKey(list, key);
            assertThat(list.size(), is(i + 1));
            for (int j = 0; j < i; j++) {
                Integer existingKey = keys[j];
                assertThat(list.skipSearch(existingKey).getElement(), is(existingKey));
            }
        }
    }

    private void assertPutKey(SkipList<Integer> list, int key) {
        Position<Integer> pos = list.put(key);
        assertThat(pos.getElement(), is(key));
        pos = list.skipSearch(key);
        assertThat(pos.getElement(), is(key));
        pos = list.skipSearch(key + 1);
        assertThat(pos.getElement(), is(key));
    }
}
