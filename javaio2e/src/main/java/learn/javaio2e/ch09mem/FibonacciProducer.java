package learn.javaio2e.ch09mem;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Writes data onto the output stream that it's given in the constructor.
 */
public class FibonacciProducer extends Thread {
    private final DataOutputStream out;
    private final int howMany;

    public FibonacciProducer(OutputStream out, int howMany) {
        this.out = new DataOutputStream(out);
        this.howMany = howMany;
    }

    @Override
    public void run() {
        System.out.println("FibonacciProducer started");
        try {
            int f1 = 1;
            int f2 = 1;
            out.writeInt(f1);
            out.writeInt(f2);
            for (int i = 2; i < howMany; i++) {
                int temp = f2;
                f2 = f2 + f1;
                f1 = temp;
                if (f2 < 0) {
                    break;
                }
                out.writeInt(f2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
