package learn.ijpds.ch33netw.nlogging.log4j;

import org.apache.log4j.spi.LoggingEvent;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Listens to the socket and prints logging events.
 */
public class SocketPrinter {
    private static final long MS_PER_HOUR = 60 * 60 * 1000;

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
                printEvent(event);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            System.out.println("Closing connection");
        }
        System.out.println("Finished.");
    }

    private static void printEvent(LoggingEvent event) {
        long timeStamp = event.getTimeStamp();
        System.out.printf("%d: %s: %s%n", timeStamp % MS_PER_HOUR, event.getLevel(), event.getMessage());
    }
}
