package introtdd.ch03good;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class HamcrestExampleTest {
    @Test
    public void mapShouldContainValue() {
        Map<String, Integer> map = getValues();
        assertThat(map, hasKey("B"));
    }

    private Map<String, Integer> getValues() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        return map;
    }

    @Test
    public void listOrderingIsIrrelevant() {
        List<Integer> numbers = getNumbers();
        assertThat(numbers, hasItem(5));
    }

    private List<Integer> getNumbers() {
        return List.of(1, 2, 3, 5, 4);
    }
}
