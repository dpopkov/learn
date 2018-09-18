package learn.ijpds.ch12exceptions.exercises;

import learn.ijpds.ch07arrays.IntResult;
import learn.ijpds.ch07arrays.RawCalculator;

public class E1201WithException {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java IntCalculator operand1 operator operand2");
            return;
        }
        IntResult result = new RawCalculator().calculate(args[0], args[1], args[2]);
        if (result.isSuccess()) {
            System.out.printf("%s %s %s = %d%n", args[0], args[1], args[2], result.getValue());
        } else {
            System.out.println(result.getMessage());
        }
    }
}
