package learn.dsajg6e.ch02oop.progressions;

/**
 * CF 2.6
 */
public class ProgressionDemo {
    private static final int PROGRESSION_LENGTH = 10;

    public static void main(String[] args) {
        print("Arithmetic progression with default increment:", new ArithmeticProgression());
        print("Arithmetic progression with increment 5:", new ArithmeticProgression(5));
        print("Arithmetic progression with start 2:", new ArithmeticProgression(2, 1));
        print("Geometric progression with base 3:", new GeometricProgression(1, 3));
        print("Fibonacci progression with default values:", new FibonacciProgression());
        print("Fibonacci progression with values 4 and 6:", new FibonacciProgression(4, 6));
    }

    private static void print(String title, AbstractProgression progression) {
        System.out.println(title);
        progression.print(PROGRESSION_LENGTH);
    }
}
