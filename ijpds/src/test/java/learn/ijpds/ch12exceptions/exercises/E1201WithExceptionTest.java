package learn.ijpds.ch12exceptions.exercises;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class E1201WithExceptionTest {

    private static final PrintStream STD_OUT = System.out;
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setStandardOutput() {
        System.setOut(new PrintStream(output));
    }

    @After
    public void restoreStandardOutput() {
        System.setOut(STD_OUT);
    }

    @Test
    public void whenMainDoesNotHas3ArgumentsThenExitWithMessage() {
        String[] args = {};
        E1201WithException.main(args);
        assertResult("Usage: java IntCalculator operand1 operator operand2");
    }

    @Test
    public void whenNotAllowedOperatorThenExitWithMessage() {
        evaluateExpression("1", "?", "2");
        assertResult("Invalid operator: ?");
    }

    @Test
    public void whenPlusThenResultIsSum() {
        evaluateExpression("1", "+", "2");
        assertResult("1 + 2 = 3");
    }

    @Test
    public void whenMinusThenResultIsDifference() {
        evaluateExpression("3", "-", "1");
        assertResult("3 - 1 = 2");
    }

    @Test
    public void whenMultiplicationThenResultIsProduct() {
        evaluateExpression("3", "*", "2");
        assertResult("3 * 2 = 6");
    }

    @Test
    public void whenDivisionThenResultIsQuotient() {
        evaluateExpression("5", "/", "2");
        assertResult("5 / 2 = 2");
    }

    @Test
    public void whenNonNumericThenMessageAboutIntegerOperands() {
        evaluateExpression("ab" , "+", "cd");
        assertResult("Integer operands are expected.");
    }

    private void evaluateExpression(String op1, String operator, String op2) {
        String[] args = {op1, operator, op2};
        E1201WithException.main(args);
    }

    private void assertResult(String s) {
        assertThat(output.toString(), is(s + System.lineSeparator()));
    }
}