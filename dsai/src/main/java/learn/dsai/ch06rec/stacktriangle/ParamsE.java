package learn.dsai.ch06rec.stacktriangle;

/**
 * Parameters to save on stack.
 */
public class ParamsE {
    public final int number;
    public final Address returnAddress;

    public ParamsE(int number, Address returnAddress) {
        this.number = number;
        this.returnAddress = returnAddress;
    }
}
