package learn.core2.ch04netw.interruptible;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

/**
 * A multithreaded server that listens to port 8189 and sends numbers to the client,
 * simulating a hanging server after 10 numbers.
 */
public class DemoServer implements Runnable {
    private static final int PORT_NUMBER = 8189;

    private final Consumer<String> messageConsumer;

    public DemoServer(Consumer<String> messageConsumer) {
        this.messageConsumer = messageConsumer;
    }

    @Override
    public void run() {
        final int incomingLimit = 10;
        int count = 0;
        try (ServerSocket s = new ServerSocket(PORT_NUMBER)) {
            while (count < incomingLimit) {
                Socket incoming = s.accept();
                new Thread(new DemoServerSocketHandler(incoming, messageConsumer)).start();
                count++;
            }
        } catch (IOException e) {
            messageConsumer.accept(getClass().getSimpleName() + ".run: " + e);
        }
    }
}
