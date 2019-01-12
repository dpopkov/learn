package learn.dsai.ch08trees2.projects;

import org.hamcrest.core.Is;
import org.junit.Test;

import static learn.dsai.tools.Constants.NL;
import static org.junit.Assert.*;

public class P0801CharTreeTest {
    @Test
    public void whenConstructTree() {
        String s = "ABC";
        P0801CharTree tree = new P0801CharTree(s.charAt(0), s.charAt(1));
        String expected = " +" + NL
                + "A B" + NL;
        assertThat(tree.toString(), Is.is(expected));
        tree.add(s.charAt(2));
        expected = "   +" + NL
                 + " +   C" + NL
                 + "A B - -" + NL;
        assertThat(tree.toString(), Is.is(expected));
    }
}
