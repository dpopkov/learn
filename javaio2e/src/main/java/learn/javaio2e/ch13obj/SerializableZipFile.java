package learn.javaio2e.ch13obj;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Demonstrates usage of composition rather than inheritance to make zip file serializable.
 * Previous version of zip file - {@link SerializableZipFileNot} has the problem
 * of missing no-argument constructor in superclass.
 */
@SuppressWarnings("unused")
public class SerializableZipFile implements Serializable {
    private static final long serialVersionUID = -1606192634709194624L;

    private ZipFile zf;

    public SerializableZipFile(String filename) throws IOException {
        this.zf = new ZipFile(filename);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(zf.getName());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        String filename = (String) in.readObject();
        zf = new ZipFile(filename);
    }

    public ZipEntry getEntry(String name) {
        return zf.getEntry(name);
    }

    public InputStream getInputStream(ZipEntry entry) throws IOException {
        return zf.getInputStream(entry);
    }

    public String getName() {
        return zf.getName();
    }

    public Enumeration<? extends ZipEntry> entries() {
        return zf.entries();
    }

    public int size() {
        return zf.size();
    }

    public void close() throws IOException {
        zf.close();
    }

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java SerializableZipFile zip-file");
            return;
        }
        try {
            SerializableZipFile zf = new SerializableZipFile(args[0]);
            ByteArrayOutputStream arrayOut = new ByteArrayOutputStream();
            ObjectOutputStream objectOut = new ObjectOutputStream(arrayOut);
            objectOut.writeObject(zf);
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
