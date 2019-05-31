package learn.dsajg6e.ch01primer.exer;

import java.util.Scanner;

/**
 * Simulates a simple calculator, using the Java console as the exclusive input and output device.
 */
public class P0127Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String op;
        int o1 = -1, o2 = -1, result;
        char operator = 0;
        boolean need2nd = false;
        while (!(op = in.nextLine()).equals("exit")) {
            if ("=".equals(op)) {
                result = calculate(o1, operator, o2);
                System.out.println(result);
            } else if (isNumber(op)) {
                if (need2nd) {
                    o2 = Integer.parseInt(op);
                    need2nd = false;
                } else {
                    o1 = Integer.parseInt(op);
                    need2nd = true;
                }
            } else {
                char ch = op.charAt(0);
                if ("+-*/".indexOf(ch) >= 0) {
                    operator = ch;
                } else {
                    System.out.println("Not an operation: " + ch);
                }
            }
        }
    }

    static int calculate(int o1, char op, int o2) {
        int result;
        switch (op) {
            case '+': result = o1 + o2; break;
            case '-': result = o1 - o2; break;
            case '*': result = o1 * o2; break;
            case '/': result = o1 / o2; break;
            default:
                throw new IllegalArgumentException("Not valid operation: " + op);
        }
        return result;
    }

    private static boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
