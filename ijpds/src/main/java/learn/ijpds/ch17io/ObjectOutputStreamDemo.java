/* 17.5 */
package learn.ijpds.ch17io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("io/data/object.dat"))) {
            out.writeUTF("John");
            out.writeDouble(85.5);
            out.writeObject(new Date());
        }
    }
}
