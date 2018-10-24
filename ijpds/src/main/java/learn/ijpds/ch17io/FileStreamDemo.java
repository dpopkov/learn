/* 17.1 */
package learn.ijpds.ch17io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamDemo {
    public static void main(String[] args) throws IOException {
        final String path = "io/data/temp.dat";
        try (FileOutputStream output = new FileOutputStream(path)) {
            for (int i = 1; i <= 10; i++) {
                output.write(i);
            }
        }
        try (FileInputStream input = new FileInputStream(path)) {
            int value;
            while ((value = input.read()) != -1) {
                System.out.print(value + " ");
            }
        }
    }
}
