package learn.ijpds.ch17io.exercises;

import java.io.*;

public class E1703SumDoubles {
    public static void main(String[] args) throws IOException {
        final String path = "io/data/temp.dat";
        try (DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(path)))) {
            double sum = 0.0;
            boolean hasMore = true;
            while (hasMore) {
                try {
                    double d = input.readDouble();
                    sum += d;
                    System.out.println(d);
                } catch (EOFException e) {
                    hasMore = false;
                }
            }
            System.out.println("sum = " + sum);
        }
    }
}
