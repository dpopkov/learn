/* 4.2 */
package learn.dsai.ch04.stacks;

public class Reverser {
    private final String input;

    public Reverser(String input) {
        this.input = input;
    }

    public String reverse() {
        int stackSize = input.length();
        StackChar stack = new StackChar(stackSize);
        for (int i = 0; i < stackSize; i++) {
            stack.push(input.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }
}
