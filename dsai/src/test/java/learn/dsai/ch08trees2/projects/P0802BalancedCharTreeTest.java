package learn.dsai.ch08trees2.projects;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;
import static learn.dsai.tools.Constants.NL;

public class P0802BalancedCharTreeTest {
    @Test
    public void test() {
        char[] chars = {'A', 'B', 'C', 'D'};
        P0802BalancedCharTree tree = new P0802BalancedCharTree(chars);
        assertThat(tree.toString(), Is.is(
                ""
                + "   +" + NL
                + " +   +" + NL
                + "A B C D" + NL
        ));
    }
}