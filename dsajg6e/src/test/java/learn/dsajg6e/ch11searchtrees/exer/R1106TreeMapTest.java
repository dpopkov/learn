package learn.dsajg6e.ch11searchtrees.exer;

import learn.dsajg6e.ch11searchtrees.TreeMap;
import learn.dsajg6e.ch11searchtrees.TreeMapBaseTest;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class R1106TreeMapTest extends TreeMapBaseTest {

    @Test
    public void testTreeSearch() {
        TreeMap<Integer, String> map = new R1106TreeMap<>();
        assertPutGet(map,10, "10", 1);
        assertPutGet(map,20, "20", 2);
        assertPutGet(map,25, "25", 3);
        assertPutGet(map,30, "30", 4);
        assertPutGet(map,35, "35", 5);
    }
}
