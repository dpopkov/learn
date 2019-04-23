package learn.javaio2e.ch13obj;

import java.io.*;
import java.util.zip.ZipFile;

/**
 * Demonstrates the problem of missing no-argument constructor in superclass.
 * It trows java.io.InvalidClassException: learn.javaio2e.ch13obj.SerializableZipFileNot; no valid constructor
 */
public class SerializableZipFileNot extends ZipFile implements Serializable {
    private static final long serialVersionUID = -6010474283932811801L;

    public SerializableZipFileNot(String name) throws IOException {
        super(name);
    }

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java SerializableZipFileNot zip-file");
            return;
        }
        try {
            SerializableZipFileNot szf = new SerializableZipFileNot(args[0]);
            ByteArrayOutputStream arrayOut = new ByteArrayOutputStream();
            ObjectOutputStream objectOut = new ObjectOutputStream(arrayOut);
            objectOut.writeObject(szf);
            objectOut.close();
            System.out.println("Wrote object!");
            ByteArrayInputStream arrayIn = new ByteArrayInputStream(arrayOut.toByteArray());
            ObjectInputStream oin = new ObjectInputStream(arrayIn);
            Object o = oin.readObject();
            if (o != null) {
                System.out.println("Read object!");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
