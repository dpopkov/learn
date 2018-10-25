/* 17.6 */
package learn.ijpds.ch17io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

public class ObjectInputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("io/data/object.dat"))) {
            String name = input.readUTF();
            double score = input.readDouble();
            Date date = (Date) input.readObject();
            System.out.println(name + " " + score + " " + date);
        }
    }
}
