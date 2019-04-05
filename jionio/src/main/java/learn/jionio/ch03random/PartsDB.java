package learn.jionio.ch03random;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Implementing the Parts Flat File Database.
 */
public class PartsDB {
    private RandomAccessFile file;

    public PartsDB(String path) throws FileNotFoundException {
        file = new RandomAccessFile(path, "rw");
    }

    public void append(Part part) throws IOException {
        file.seek(file.length());
        new PartWriter().write(file, part);
    }

    private void write(Part part) {

    }
}
