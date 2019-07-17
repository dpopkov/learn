package learn.dsajg6e.ch07list.exer;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class RandomAccessAbstractListTest {

    @Test
    public void testToString() {
        RandomAccessAbstractList<Integer> list = new C0725CircularArrayList<>(3);
        list.add(20);
        list.add(0, 10);
        list.add(30);
        String s = list.toString();
        assertThat(s, is("[10, 20, 30]"));
    }
}
