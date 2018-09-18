package learn.ijpds.ch12exceptions.exercises;

import learn.ijpds.ch07arrays.IntCalculator;
import learn.ijpds.ch07arrays.IntResult;

public class E1201ValidatingCalculator {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java IntCalculator operand1 operator operand2");
            return;
        }
        IntResult result = new E1201ValidatingCalculator().calculate(args[0], args[1], args[2]);
        if (result.isSuccess()) {
            System.out.printf("%s %s %s = %d%n", args[0], args[1], args[2], result.getValue());
        } else {
            System.out.println(result.getMessage());
        }
    }

    private IntResult calculate(String operand1, String operator, String operand2) {
        if (!operand1.matches("-?\\d+")) {
            return new IntResult("Integer operand1 is expected.");
        }
        if (!operand2.matches("-?\\d+")) {
            return new IntResult("Integer operand2 is expected.");
        }
        int op1 = Integer.parseInt(operand1);
        int op2 = Integer.parseInt(operand2);
        return new IntCalculator().calculate(op1, operator, op2);
    }
}
