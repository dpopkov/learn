package learn.dsajg6e.ch01primer.exer;

import learn.dsajg6e.tools.Input;

/**
 * Takes as input three integers, a, b, and c, from the console and determines
 * if they can be used in a correct arithmetic formula (in the given order),
 * like "a + b = c", "a = b - c", "a * b = c".
 */
public class C0116Formula {
    public static void main(String[] args) {
        int a = Input.nextInt("a: ");
        int b = Input.nextInt("b: ");
        int c = Input.nextInt("c: ");
        boolean rst = checkFormula(a, b, c);
        if (rst) {
            System.out.println("these numbers can be used in all given formulas");
        }
    }

    private static boolean checkFormula(int a, int b, int c) {
        boolean rst = true;
        if (a + b != c) {
            rst = false;
            printError(a, b, c, "a + b = c");
        }
        if (a != b - c) {
            rst = false;
            printError(a, b, c, "a = b - c");
        }
        if (a * b != c) {
            rst = false;
            printError(a, b, c, "a * b = c");
        }
        return rst;
    }

    private static void printError(int a, int b, int c, String formula) {
        System.out.printf("%d, %d, %d can not be used in formula %s%n", a, b, c, formula);
    }
}
