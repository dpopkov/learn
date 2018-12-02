package learn.dsai.ch06rec.projects;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0602TreeTest {
    private final P0602Tree tree = new P0602Tree();

    @Test
    public void test1Branch() {
        String result = tree.makeBranches(1);
        assertThat(result, is("X"));
    }

    @Test
    public void test2Branches() {
        String result = tree.makeBranches(2);
        String expected =
                "-X" + System.lineSeparator() +
                "XX";
        assertThat(result, is(expected));
    }

    @Test
    public void test8Branches() {
        String result = tree.makeBranches(8);
        String expected =
                "----X---" + System.lineSeparator() +
                "--X---X-" + System.lineSeparator() +
                "-X-X-X-X" + System.lineSeparator() +
                "XXXXXXXX";
        assertThat(result, is(expected));
    }
}
