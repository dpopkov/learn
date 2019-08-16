package learn.dsajg6e.ch08trees.exer;

import org.junit.Test;

import static learn.dsajg6e.ch08trees.exer.Expressions.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class P0865ConvertToExpressionTreeTest {

    @Test
    public void testConvertSimple() {
        String expression = "2 + 3";
        P0865ConvertToExpressionTree converter = new P0865ConvertToExpressionTree();
        Infix tree = converter.convert(expression);
        assertThat(tree.getOperation(), is(Operation.ADD));
        assertThat(tree.getFirst().value(), is(2));
        assertThat(tree.getSecond().value(), is(3));
        assertThat(tree.value(), is(5));
    }
}
