package learn.ijpds.ch17io.exercises;

import java.io.IOException;
import java.io.RandomAccessFile;

public class E1708CountExecutions {
    public static void main(String[] args) throws IOException {
        String path = "io/data/e_17_08.dat";
        try (RandomAccessFile raf = new RandomAccessFile(path, "rw")) {
            int count = 0;
            if (raf.length() > 0) {
                count = raf.readInt();
            }
            count++;
            raf.seek(0);
            raf.writeInt(count);
            System.out.println("The program has been executed " + count + " times.");
        }
    }
}
