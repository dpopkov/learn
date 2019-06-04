package learn.dsajg6e.ch02oop.exer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0230FrequenciesChartTest {

    @Test
    public void testProcess() {
        char[] chars = {'a', 'b', 'c', 'b', 'a', 'a'};
        Map<Character, Long> stats = new HashMap<>();
        P0230FrequenciesChart.process(stats, chars, chars.length);
        assertThat(stats.get('a'), is(3L));
        assertThat(stats.get('b'), is(2L));
        assertThat(stats.get('c'), is(1L));
    }

    @Test
    public void testChart() {
        Map<Character, Long> stats = Map.of('a', 3L, 'b', 1L, 'c', 2L);
        String rst = P0230FrequenciesChart.chart(stats);
        String expected = String.join(System.lineSeparator(), "a : ***", "b : *", "c : **")
                + System.lineSeparator();
        assertThat(rst, is(expected));
    }
}