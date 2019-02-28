package learn.ijpds.ch33netw.areaserver;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.function.Consumer;

public class AreaServer implements Runnable, Closeable {
    private static final int PORT_NUMBER = 8000;

    private final Consumer<String> textConsumer;
    private ServerSocket serverSocket;
    private Socket incoming;

    public AreaServer(Consumer<String> textConsumer) {
        this.textConsumer = textConsumer;
    }

    public void start() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(PORT_NUMBER);
            textConsumer.accept("AreaServer started at " + new Date());
            incoming = serverSocket.accept();
            InetAddress client = incoming.getInetAddress();
            textConsumer.accept("Accepted connection from: " + client.getHostName()
                    + ", IP address: " + client.getHostAddress());
            try (DataInputStream in = new DataInputStream(incoming.getInputStream());
                 DataOutputStream out = new DataOutputStream(incoming.getOutputStream())) {
                int count = 0;
                int limit = 5;
                while (count < limit) {
                    double radius = in.readDouble();
                    double area = radius * radius * Math.PI;
                    out.writeDouble(area);
                    textConsumer.accept("Radius received from client: " + radius + '\n'
                            + "Area is: " + area);
                    count++;
                }
                textConsumer.accept("Reached limit of " + limit + " calculations");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws IOException {
        if (incoming != null && !incoming.isClosed()) {
            incoming.close();
        }
        if (serverSocket != null && !serverSocket.isClosed()) {
            serverSocket.close();
        }
    }
}
