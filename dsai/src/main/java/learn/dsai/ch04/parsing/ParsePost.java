/* 4.8 */
package learn.dsai.ch04.parsing;

import learn.dsai.ch04.stacks.StackLong;

import java.util.HashMap;
import java.util.Map;
import java.util.function.LongBinaryOperator;

public class ParsePost {
    private StackLong stack;
    private boolean log;

    public ParsePost() {
        this(false);
    }

    public ParsePost(boolean log) {
        this.log = log;
    }

    private static final Map<Character, LongBinaryOperator> operations = new HashMap<>();
    static {
        operations.put('+', (x, y) -> x + y);
        operations.put('-', (x, y) -> x - y);
        operations.put('*', (x, y) -> x * y);
        operations.put('/', (x, y) -> x / y);
    }

    public long parse(String input) {
        stack = new StackLong(20);
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            displayStack(ch);
            if ('0' <= ch && ch <= '9') {
                stack.push(ch - '0');
            } else {
                long num2 = stack.pop();
                long num1 = stack.pop();
                stack.push(operations.get(ch).applyAsLong(num1, num2));
            }
        }
        return stack.pop();
    }

    public void displayStack(char ch) {
        if (log) {
            System.out.println(ch + " " + stack);
        }
    }
}
