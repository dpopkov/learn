package learn.ijpds.ch33netw;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.function.Consumer;

public class AreaServer implements Runnable {
    private final Consumer<String> textConsumer;

    public AreaServer(Consumer<String> textConsumer) {
        this.textConsumer = textConsumer;
    }

    public void start() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            textConsumer.accept("AreaServer started at " + new Date() + '\n');
            Socket incoming = serverSocket.accept();
            DataInputStream in = new DataInputStream(incoming.getInputStream());
            DataOutputStream out = new DataOutputStream(incoming.getOutputStream());
            int count = 0;
            int limit = 5;
            while (count < limit) {
                double radius = in.readDouble();
                double area = radius * radius * Math.PI;
                out.writeDouble(area);
                textConsumer.accept("Radius received from client: " + radius + '\n'
                                    + "Area is: " + area + '\n');
                count++;
            }
            textConsumer.accept("Reached limit of " + limit + " calculations");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
