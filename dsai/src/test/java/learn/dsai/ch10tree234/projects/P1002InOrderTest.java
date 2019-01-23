package learn.dsai.ch10tree234.projects;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P1002InOrderTest {

    @Test
    public void testInOrder() {
        P1002InOrder tree = new P1002InOrder();
        tree.insert(30L);
        assertThat(tree.toStringInOrder(), is("/30"));
        tree.insert(40L);
        tree.insert(20L);
        tree.insert(50L);
        tree.insert(10L);
        tree.insert(60L);
        assertThat(tree.toStringInOrder(), is("/10/20/30/40/50/60"));
    }
}