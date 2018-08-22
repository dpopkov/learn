package learn.core1.ch03;

/**
 * Example of how to use break in a block of code.
 */
public class UsingBreakInBlock {
    public static void main(String[] args) {
        String s = "one";
        System.out.println("s = " + s);
        System.out.println("Before outer if block");
        outer_if:
        if (s.equals("one")) {
            System.out.println("Inside outer if block");
            if (!s.equals("two")) {
                System.out.println("Inside inner if block");
                break outer_if;
            }
            System.out.println("This line will not be printed");
        }
        System.out.println("After outer if block");
    }
}
