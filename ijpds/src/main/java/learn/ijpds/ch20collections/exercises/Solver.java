package learn.ijpds.ch20collections.exercises;

import learn.ijpds.tools.SentenceBuilder;

import java.util.List;

/**
 * Finds solution for specified operands and expected result.
 * Uses only addition operation for now.
 */
public class Solver {
    private Evaluator evaluator = new Evaluator();
    private List<Integer> operands;

    public Solver(List<Integer> operands) {
        this.operands = operands;
    }

    public String findSolution(int expectedResult) {
        SentenceBuilder builder = new SentenceBuilder();
        builder.append(operands.get(0));
        for (int i = 1; i < operands.size(); i++) {
            builder.append("+");
            builder.append(operands.get(i));
        }
        String expression = builder.toString();
        if (evaluator.evaluate(expression) == expectedResult) {
            return "Found solution: " + expression;
        }
        return "Solution not found.";
    }
}
