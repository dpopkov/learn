package learn.dsai.ch08trees2.projects;

import org.junit.Test;

import static learn.dsai.tools.Constants.NL;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0804PostfixTreeTest {
    @Test
    public void whenInitializeWithPostfixThenBuildsTree() {
        P0804PostfixTree tree = new P0804PostfixTree("ABC+*");
        assertThat(tree.toString(), is(""
                + "   *" + NL
                + " A   +" + NL
                + "    B C" + NL
        ));
    }

    @Test
    public void whenGetInfixThenReturnsExpressionInInfixForm() {
        P0804PostfixTree tree = new P0804PostfixTree("AB+CD/E-*F+");
        assertThat(tree.getInfix(), is("(A+B)*(C/D-E)+F"));
    }
}
