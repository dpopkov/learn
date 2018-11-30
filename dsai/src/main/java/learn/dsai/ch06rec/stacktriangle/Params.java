package learn.dsai.ch06rec.stacktriangle;

/**
 * Parameters to save on stack.
 */
public class Params {
    public final int number;
    public final int returnAddress;

    public Params(int number, int returnAddress) {
        this.number = number;
        this.returnAddress = returnAddress;
    }
}
