package learn.ijpds.ch20collections.exercises;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SolverTest {

    @Test
    public void findSolutionUsingAddition() {
        List<Integer> operands = Arrays.asList(1, 2, 3, 4);
        Solver solver = new Solver(operands);
        String expression = solver.findSolution(10);
        assertThat(expression, is("Found solution: 1 + 2 + 3 + 4"));
    }
}