package learn.dsai.ch08trees2.projects;

import org.junit.Test;

import static learn.dsai.tools.Constants.NL;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0803PyramidTreeTest {
    @Test
    public void testAdd() {
        P0803PyramidTree tree = new P0803PyramidTree();
        tree.add('A');
        assertThat(tree.toString(), is(""
                + "A" + NL
        ));
        assertThat(tree.getSize(), is(1));
        tree.add('B');
        assertThat(tree.toString(), is(""
                + " A" + NL
                + "B -" + NL
        ));
        assertThat(tree.getSize(), is(2));
        tree.add('C');
        assertThat(tree.toString(), is(""
                + " A" + NL
                + "B C" + NL
        ));
        tree.add('D');
        assertThat(tree.toString(), is(""
                + "   A" + NL
                + " B   C" + NL
                + "D - - -" + NL
        ));
        tree.add('E');
        assertThat(tree.toString(), is(""
                + "   A" + NL
                + " B   C" + NL
                + "D E - -" + NL
        ));
        tree.add('F');
        assertThat(tree.toString(), is(""
                + "   A" + NL
                + " B   C" + NL
                + "D E F -" + NL
        ));
        tree.add('G');
        assertThat(tree.toString(), is(""
                + "   A" + NL
                + " B   C" + NL
                + "D E F G" + NL
        ));
        tree.add('H');
        assertThat(tree.toString(), is(""
                + "       A" + NL
                + "   B       C" + NL
                + " D   E   F   G" + NL
                + "H - - - - - - -" + NL
        ));
        assertThat(tree.getSize(), is(8));
    }
}
