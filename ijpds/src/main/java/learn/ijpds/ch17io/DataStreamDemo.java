/* 17.2 */
package learn.ijpds.ch17io;

import java.io.*;

public class DataStreamDemo {
    public static void main(String[] args) throws IOException {
        final String path = "io/data/temp.dat";
        try (DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)))) {
            output.writeUTF("John");
            output.writeDouble(85.5);
            output.writeUTF("Jim");
            output.writeDouble(185.5);
            output.writeUTF("George");
            output.writeDouble(105.25);
        }
        try (DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(path)))) {
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
        }
    }
}
