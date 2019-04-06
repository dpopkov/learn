package learn.jionio.ch03random;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Implementing the Parts Flat File Database.
 */
public class PartsDb {
    private RandomAccessFile file;
    private PartWriter writer = new PartWriter();
    private PartReader reader = new PartReader();

    public PartsDb(String path) throws FileNotFoundException {
        file = new RandomAccessFile(path, "rw");
    }

    public void append(Part part) throws IOException {
        file.seek(file.length());
        writer.write(file, part);
    }

    public Part select(int recordNo) throws IOException {
        checkRecordNo(recordNo);
        file.seek(recordNo * Part.RECORD_LEN);
        return reader.read(file);
    }

    public void update(int recordNo, Part part) throws IOException {
        checkRecordNo(recordNo);
        file.seek(recordNo * Part.RECORD_LEN);
        writer.write(file, part);
    }

    public void close() {
        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int numRecords() throws IOException {
        return (int) (file.length() / Part.RECORD_LEN);
    }

    private void checkRecordNo(int recordNo) throws IOException {
        if (recordNo < 0 || recordNo > numRecords()) {
            throw new IllegalArgumentException(recordNo + " out of range");
        }
    }
}
