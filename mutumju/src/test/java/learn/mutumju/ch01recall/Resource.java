package learn.mutumju.ch01recall;

/**
 * Represents an external resource and prints the output in the console.
 * This class is used in {@link ExternalResourceRuleTest}.
 */
public class Resource {
    public void open() {
        System.out.println("Opened");
    }

    public void close() {
        System.out.println("Closed");
    }

    public double get() {
        return Math.random();
    }
}
