package learn.dsajg6e.ch05recursion.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class C0516TowersOfHanoiTest {

    @Test
    public void testMove() {
        List<Integer> from = new ArrayList<>();
        from.add(4);
        from.add(3);
        from.add(2);
        from.add(1);
        List<Integer> helper = new ArrayList<>();
        List<Integer> to = new ArrayList<>();
        C0516TowersOfHanoi.move(from, to, helper);
        assertTrue(from.isEmpty());
        assertTrue(helper.isEmpty());
        assertThat(to, is(List.of(4, 3, 2, 1)));
    }
}
