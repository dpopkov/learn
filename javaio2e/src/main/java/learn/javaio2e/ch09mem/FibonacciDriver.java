package learn.javaio2e.ch09mem;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Creates a piped output stream and a piped input stream
 * and uses those to construct producer and consumer objects.
 */
public class FibonacciDriver {
    public static void main(String[] args) throws IOException, InterruptedException {
        PipedOutputStream pipedOutput = new PipedOutputStream();
        PipedInputStream pipedInput = new PipedInputStream(pipedOutput);
        FibonacciProducer producer = new FibonacciProducer(pipedOutput, 10);
        FibonacciConsumer consumer = new FibonacciConsumer(pipedInput, System.out::println);
        consumer.start();
        Thread.sleep(1000);
        producer.start();
    }
}
