package learn.ijpds.ch20collections.evaluating;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EvaluateExpressionTest {

    @Test
    public void testEvaluate() {
        String e = "(2 + 3) * 4 / (10 - 3)";
        int result = EvaluateExpression.evaluate(e);
        assertThat(result, is(2));
    }
}