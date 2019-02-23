package learn.core2.ch04netw.interruptible;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

/**
 * Handles the client input for one server connection.
 */
public class DemoServerSocketHandler implements Runnable {
    private final Consumer<String> messageConsumer;
    private final Socket incoming;
    private int counter;

    public DemoServerSocketHandler(Socket incoming, Consumer<String> messageConsumer) {
        this.incoming = incoming;
        this.messageConsumer = messageConsumer;
    }

    @Override
    public void run() {
        try {
            final int countLimit = 100;
            final int sleepMillis = 100;
            try {
                PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(incoming.getOutputStream(), StandardCharsets.UTF_8), true);
                while (counter < countLimit) {
                    counter++;
                    if (counter <= 10) {
                        out.println(counter);
                    }
                    Thread.sleep(sleepMillis);
                }
            } finally {
                incoming.close();
                messageConsumer.accept("Closing server after " + countLimit + " ticks");
            }
        } catch (Exception e) {
            messageConsumer.accept(getClass().getSimpleName() + ".run: " + e);
        }
    }
}
