/* 4.1 */
package learn.dsai.ch04.stacks;

public class StackApp {
    public static void main(String[] args) {
        StackLong stack = new StackLong(4);
        stack.push(20);
        stack.push(40);
        stack.push(60);
        stack.push(80);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
