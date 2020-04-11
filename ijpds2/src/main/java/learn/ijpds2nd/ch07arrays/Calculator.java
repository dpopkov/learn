package learn.ijpds2nd.ch07arrays;

/* Listing 7.9 */
public class Calculator {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Calculator operand1 operator operand2");
            System.exit(1);
        }
        int result;
        int op1 = Integer.parseInt(args[0]);
        String operator = args[1];
        int op2 = Integer.parseInt(args[2]);
        switch (operator) {
            case "+":
                result = op1 + op2;
                break;
            case "-":
                result = op1 - op2;
                break;
            case ".":
                result = op1 * op2;
                break;
            case "/":
                result = op1 / op2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
        System.out.printf("%d %s %d = %d%n", op1, operator, op2, result);
    }
}
