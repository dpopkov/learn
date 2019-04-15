package learn.javaio2e.ch09mem;

import java.io.*;

/**
 * Uses a byte array output stream to implement a simple form of buffering.
 */
public class FibonacciFile {
    public static void main(String[] args) throws IOException {
        int howMany = 20;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream(howMany * Integer.BYTES);
        DataOutputStream dataOut = new DataOutputStream(buffer);
        int f1 = 1;
        int f2 = 1;
        dataOut.writeInt(f1);
        dataOut.writeInt(f2);
        for (int i = 3; i <= howMany; i++) {
            int temp = f2;
            f2 = f2 + f1;
            f1 = temp;
            dataOut.writeInt(f2);
        }
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream("fibonacci.dat"))) {
            buffer.writeTo(out);
            out.flush();
        }
    }
}
