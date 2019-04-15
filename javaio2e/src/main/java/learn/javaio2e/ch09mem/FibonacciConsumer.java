package learn.javaio2e.ch09mem;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.IntConsumer;

/**
 * Reads integers from its input stream until the stream is exhausted.
 * At this point, the other end of the pipe closes and an IOException is thrown.
 */
public class FibonacciConsumer extends Thread {
    private final DataInputStream in;
    private final IntConsumer intConsumer;

    public FibonacciConsumer(InputStream in, IntConsumer intConsumer) {
        this.in = new DataInputStream(in);
        this.intConsumer = intConsumer;
    }

    @Override
    public void run() {
        System.out.println("FibonacciConsumer started");
        try {
            while (true) {
                int value = in.readInt();
                if (value < 0) {
                    break; // it never happens, the real loop exit is by exception
                }
                intConsumer.accept(value);
            }
        } catch (IOException exception) {
            String message = exception.getMessage();
            if (message.equals("Pipe broken") || message.equals("Write end dead")) {
                return; // normal termination
            }
            exception.printStackTrace();
        }
    }
}
