package learn.ijpds.ch07arrays;

public class RawCalculator {
    public IntResult calculate(String operand1, String operator, String operand2) {
        try {
            int op1 = Integer.parseInt(operand1);
            int op2 = Integer.parseInt(operand2);
            return new IntCalculator().calculate(op1, operator, op2);
        } catch (NumberFormatException nfe) {
            return new IntResult("Integer operands are expected.");
        }
    }
}
