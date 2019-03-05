package learn.ijpds.ch33netw.multithead;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.function.Consumer;

public class MultiThreadServer implements Runnable, Closeable {
    private static final int PORT_NUMBER = 8000;

    private final Consumer<String> textConsumer;
    private ServerSocket serverSocket;
    /** Number of clients. */
    private int clientNo = 0;

    public MultiThreadServer(Consumer<String> textConsumer) {
        this.textConsumer = textConsumer;
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(PORT_NUMBER);
            textConsumer.accept("MultiThreadServer started at " + new Date() + '\n');
            while (clientNo < 5) {
                Socket incoming = serverSocket.accept();
                clientNo++;
                displayClientInfo(incoming);
                new Thread(new HandleClient(incoming, textConsumer)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayClientInfo(Socket socket) {
        StringBuilder builder = new StringBuilder();
        builder.append("Starting thread for client ").append(clientNo).append(" at ").append(new Date()).append('\n');
        InetAddress address = socket.getInetAddress();
        builder.append("Client ").append(clientNo).append("'s host name is ").append(address.getHostName()).append('\n');
        builder.append("Client ").append(clientNo).append("'s ID Address is ").append(address.getHostAddress()).append('\n');
        textConsumer.accept(builder.toString());
    }

    @Override
    public void close() throws IOException {
        if (serverSocket != null && !serverSocket.isClosed()) {
            serverSocket.close();
        }
    }
}
