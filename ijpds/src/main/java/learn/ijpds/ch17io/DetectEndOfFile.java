/* 17.3 */
package learn.ijpds.ch17io;

import java.io.*;

public class DetectEndOfFile {
    public static void main(String[] args) {
        final String path = "io/data/test.dat";
        try {
            try (DataOutputStream output = new DataOutputStream(new FileOutputStream(path))) {
                output.writeDouble(4.5);
                output.writeDouble(43.25);
                output.writeDouble(3.2);
            }
            try (DataInputStream input = new DataInputStream(new FileInputStream(path))) {
                //noinspection InfiniteLoopStatement
                while (true) {
                    System.out.println(input.readDouble());
                }
            }
        } catch (EOFException e) {
            System.out.println("All data were read.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
