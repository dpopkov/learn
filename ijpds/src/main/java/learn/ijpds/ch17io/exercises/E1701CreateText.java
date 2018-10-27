/* 17.1     Create a text file. p737. */
package learn.ijpds.ch17io.exercises;

import java.io.*;
import java.util.Random;

public class E1701CreateText {
    public static void main(String[] args) throws FileNotFoundException {
        final Random random = new Random();
        final String path = "io/text/e_17_01.txt";
        try (PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(path)))) {
            writer.println("150 random integers:");
            for (int i = 0; i < 150; i++) {
                if (i > 0) {
                    writer.print(' ');
                }
                writer.print(random.nextInt(1000));
            }
        }
    }
}
