package learn.ijpds.ch07arrays;

public class Calculator {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Calculator operand1 operator operand2");
            return;
        }
        int result = 0;
        int op1 = Integer.parseInt(args[0]);
        int op2 = Integer.parseInt(args[2]);
        boolean success = true;
        switch(args[1]) {
            case "+":
                result = op1 + op2;
                break;
            case "-":
                result = op1 - op2;
                break;
            case "*":
                result = op1 * op2;
                break;
            case "/":
                result = op1 / op2;
                break;
            default:
                System.out.println("Invalid operator: " + args[1]);
                success = false;
                break;
        }
        if (success) {
            System.out.printf("%d %s %d = %d%n", op1, args[1], op2, result);
        }
    }
}
