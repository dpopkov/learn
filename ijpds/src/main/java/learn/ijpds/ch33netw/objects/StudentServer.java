package learn.ijpds.ch33netw.objects;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class StudentServer {
    private static final int PORT_NUMBER = 8000;
    public static final String FILE_PATH = "io/data/student.dat";

    public static void main(String[] args) {
        new StudentServer().start(PORT_NUMBER);
    }

    public void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port);
             ObjectOutputStream outToFile = new ObjectOutputStream(
                     new BufferedOutputStream(new FileOutputStream(FILE_PATH, true)))) {
            System.out.println("Server started.");
            int count = 0;
            while (count < 3) {
                try (Socket socket = serverSocket.accept();
                     ObjectInputStream clientInput = new ObjectInputStream(socket.getInputStream())) {
                    Object object = clientInput.readObject();
                    outToFile.writeObject(object);
                    System.out.println("A new student object is stored.");
                    count++;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
