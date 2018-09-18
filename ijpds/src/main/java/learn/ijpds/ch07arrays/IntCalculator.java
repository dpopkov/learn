package learn.ijpds.ch07arrays;

public class IntCalculator {

    public IntResult calculate(int op1, String operator, int op2) {
        int value = -1;
        String message = null;
        boolean success = true;
        switch(operator) {
            case "+":
                value = op1 + op2;
                break;
            case "-":
                value = op1 - op2;
                break;
            case "*":
                value = op1 * op2;
                break;
            case "/":
                value = op1 / op2;
                break;
            default:
                message = "Invalid operator: " + operator;
                success = false;
                break;
        }
        return success ? new IntResult(value) : new IntResult(message);
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java IntCalculator operand1 operator operand2");
            return;
        }
        int op1 = Integer.parseInt(args[0]);
        int op2 = Integer.parseInt(args[2]);
        IntResult result = new IntCalculator().calculate(op1, args[1], op2);

        if (result.isSuccess()) {
            System.out.printf("%d %s %d = %d%n", op1, args[1], op2, result.getValue());
        } else {
            System.out.println(result.getMessage());
        }
    }
}
