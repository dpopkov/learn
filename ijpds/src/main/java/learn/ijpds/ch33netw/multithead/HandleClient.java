package learn.ijpds.ch33netw.multithead;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.function.Consumer;

/**
 * Handles new client connection.
 */
public class HandleClient implements Runnable {
    private final Socket socket;
    private final Consumer<String> display;

    public HandleClient(Socket incoming, Consumer<String> consumer) {
        socket = incoming;
        display = consumer;
    }

    @Override
    public void run() {
        try (DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            int count = 0;
            while (count < 5) {
                double radius = in.readDouble();
                double area = radius * radius * Math.PI;
                out.writeDouble(area);
                display.accept("radius received from client: " + radius + '\n'
                                + "Area found: " + area + '\n');
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
