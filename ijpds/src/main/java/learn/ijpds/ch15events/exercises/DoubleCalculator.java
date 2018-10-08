package learn.ijpds.ch15events.exercises;

import java.util.EnumMap;
import java.util.function.BiFunction;

public class DoubleCalculator {
    private final EnumMap<ArithmeticOperation, BiFunction<Double, Double, Double>> operations;
    {
        operations = new EnumMap<>(ArithmeticOperation.class);
        operations.put(ArithmeticOperation.ADD, (a, b) -> a + b);
        operations.put(ArithmeticOperation.SUBTRACT, (a, b) -> a - b);
        operations.put(ArithmeticOperation.MULTIPLY, (a, b) -> a * b);
        operations.put(ArithmeticOperation.DIVIDE, (a, b) -> a / b);
    }

    public double calculate(double op1, double op2, ArithmeticOperation operation) {
        return operations.get(operation).apply(op1, op2);
    }
}
