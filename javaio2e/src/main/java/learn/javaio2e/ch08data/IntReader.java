package learn.javaio2e.ch08data;

import java.io.*;

public class IntReader {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("usage: java IntReader filename");
            return;
        }
        try (DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream(args[0])))) {
            System.out.println("-----------" + args[0] + "-------------");
            //noinspection InfiniteLoopStatement
            while (true) {
                int number = in.readInt();
                System.out.println(number);
            }
        } catch (EOFException e) {
            // normal termination
        } catch (IOException e) {
            e.printStackTrace();    // abnormal termination
        }
    }
}
