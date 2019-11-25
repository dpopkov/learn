package learn.dsajg6e.ch11searchtrees;

import org.junit.Test;

public class RbTreeMapTest extends TreeMapBaseTest {

    @Test
    public void canInsertAndGet() {
        TreeMap<Integer, String> map = new RbTreeMap<>();
        assertPutGet(map,10, "10", 1);
        assertPutGet(map,20, "20", 2);
        assertPutGet(map,25, "25", 3);
        assertPutGet(map,30, "30", 4);
        assertPutGet(map,35, "35", 5);
    }
}
