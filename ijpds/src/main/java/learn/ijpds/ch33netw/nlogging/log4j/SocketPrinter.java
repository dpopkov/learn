package learn.ijpds.ch33netw.nlogging.log4j;

import org.apache.log4j.spi.LoggingEvent;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Listens to the socket and prints every input.
 */
public class SocketPrinter {
    public static void main(String[] args) throws IOException {
        int port = 4712;
        if (args.length == 1) {
            port = Integer.parseInt(args[0]);
        }
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.printf("SocketPrinter listening on port %d...%n", port);
            Socket incoming = serverSocket.accept();
            System.out.printf("Accepted connection from port %d.%n", incoming.getPort());
            InputStream in = incoming.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(in);
            //noinspection InfiniteLoopStatement
            while (true) {
                LoggingEvent event = (LoggingEvent) ois.readObject();
                System.out.printf("%s: %s%n", event.getLevel(), event.getMessage());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            System.out.println("Closing connection");
        }
        System.out.println("Finished.");
    }
}
