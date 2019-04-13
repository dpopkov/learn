package learn.javaio2e.ch08data;

import java.io.*;

public class DoubleReader {
    public static void main(String[] args) throws IOException {
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(args[0])))) {
            System.out.println("--------------" + args[0] + "--------------");
            //noinspection InfiniteLoopStatement
            while (true) {
                double number = in.readDouble();
                System.out.println(number);
            }
        } catch (EOFException e) {
            // normal termination
        }
    }
}
