/* 17.2     Create a binary data file. */
package learn.ijpds.ch17io.exercises;

import java.io.*;
import java.util.Random;

public class E1702CreateBinary {
    public static void main(String[] args) throws IOException {
        final String path = "io/data/e_17_02.dat";
        final Random random = new Random();
        try (DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(path, true)))) {
            for (int i = 0; i < 150; i++) {
                out.writeInt(random.nextInt(1000));
            }
        }
    }
}
