package learn.ijpds.ch17io.exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class E1709AddressBook implements AutoCloseable {
    private static final String PATH = "io/data/e_17_09.dat";

    private final List<Address> addresses = new ArrayList<>();
    private RandomAccessFile dbFile;
    private AddressReaderWriter readerWriter;

    public E1709AddressBook() throws IOException {
        File file = new File(PATH);
        boolean notNew = file.exists();
        openDbFile(file);
        readerWriter = new AddressReaderWriter(dbFile);
        if (notNew) {
            readAddresses();
        }
    }

    public int size() {
        return addresses.size();
    }

    public Address getFirst() {
        if (addresses.size() == 0) {
            return null;
        }
        return addresses.get(0);
    }

    public Address getLast() {
        if (addresses.size() == 0) {
            return null;
        }
        return addresses.get(addresses.size() - 1);
    }

    public Address get(int index) {
        return addresses.get(index);
    }

    public void set(int index, Address address) throws IOException {
        addresses.set(index, address);
        readerWriter.update(index, address);
    }

    private void readAddresses() throws IOException {
        Address address;
        while ((address = readerWriter.readNext()) != null) {
            addresses.add(address);
        }
    }

    private void openDbFile(File file) throws FileNotFoundException {
        dbFile = new RandomAccessFile(file, "rw");
    }


    @Override
    public void close() throws Exception {
        dbFile.close();
    }

    public void add(Address address) throws IOException {
        addresses.add(address);
        readerWriter.add(address);
    }
}
