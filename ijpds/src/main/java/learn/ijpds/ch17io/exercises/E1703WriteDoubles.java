package learn.ijpds.ch17io.exercises;

import java.io.*;

public class E1703WriteDoubles {
    public static void main(String[] args) throws IOException {
        final String path = "io/data/temp.dat";
        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)))) {
            for (int i = 0; i < 100; i++) {
                out.writeDouble((double) i);
            }
        }
    }
}
