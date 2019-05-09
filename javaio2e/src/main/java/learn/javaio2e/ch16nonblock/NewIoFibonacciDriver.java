package learn.javaio2e.ch16nonblock;

import java.io.IOException;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class NewIoFibonacciDriver {
    public static void main(String[] args) throws IOException {
        Pipe pipe = Pipe.open();
        WritableByteChannel out = pipe.sink();
        ReadableByteChannel in = pipe.source();
        FibonacciProducer producer = new FibonacciProducer(out, 200);
        FibonacciConsumer consumer = new FibonacciConsumer(in);
        producer.start();
        consumer.start();
    }
}
