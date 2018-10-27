package learn.ijpds.ch17io.exercises;

import java.io.IOException;
import java.io.RandomAccessFile;

public class AddressReaderWriter {
    public static final int UTF_PREFIX = 2;
    public static final int RECORD_LENGTH = Address.getMaximumLength(UTF_PREFIX);

    private final RandomAccessFile raf;

    public AddressReaderWriter(RandomAccessFile raf) {
        this.raf = raf;
    }

    public Address readNext() throws IOException {
        long start = raf.getFilePointer();
        if (start > raf.length() - RECORD_LENGTH) {
            return null;
        }
        String name = raf.readUTF();
        String street = raf.readUTF();
        String city = raf.readUTF();
        String state = raf.readUTF();
        String zip = raf.readUTF();
        raf.seek(start + RECORD_LENGTH);
        return new Address(name, street, city, state, zip);
    }

    public void add(Address address) throws IOException {
        writeAddress(address, raf.length());
    }

    public void update(int index, Address address) throws IOException {
        writeAddress(address, index * RECORD_LENGTH);
    }

    private void writeAddress(Address address, long position) throws IOException {
        raf.seek(position);
        raf.writeUTF(address.getName());
        raf.writeUTF(address.getStreet());
        raf.writeUTF(address.getCity());
        raf.writeUTF(address.getState());
        raf.writeUTF(address.getZip());
        long currentLength = raf.length() - position;
        int fill = (int) (RECORD_LENGTH - currentLength);
        if (fill > 0) {
            byte[] zeroPadding = new byte[fill];
            raf.write(zeroPadding);
        }
    }
}
