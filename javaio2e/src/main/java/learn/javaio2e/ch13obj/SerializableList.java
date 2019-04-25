package learn.javaio2e.ch13obj;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates usage of {@link Externalizable} interface - a list that can be serialized no matter what it contains,
 * one that will never throw a NotSerializableException even if it contains objects that aren't serializable.
 * The writeExternal( ) method uses instanceof to test whether each element is or is not serializable before writing it
 * onto the output. If the element does not implement Serializable, writeExternal( ) writes null in its place.
 */
public class SerializableList extends ArrayList implements Externalizable {
    private static final long serialVersionUID = -793110601295638108L;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(size());
        for (Object obj : this) {
            if (obj instanceof Serializable) {
                out.writeObject(obj);
            } else {
                out.writeObject(null);
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int elementCount = in.readInt();
        this.ensureCapacity(elementCount);
        for (int i = 0; i < elementCount; i++) {
            this.add(in.readObject());
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        SerializableList list = new SerializableList();
        list.add("Element 1");
        list.add(9);
        final String host = "http://www.oreilly.com/";
        list.add(new URL(host));
        list.add(new Socket("www.oreilly.com", 80));     // not Serializable
        list.add("Element 5");
        list.add(9);
        list.add(new URL(host));
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream temp = new ObjectOutputStream(bout);
        temp.writeObject(list);
        temp.close();
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream oin = new ObjectInputStream(bin);
        List out = (List) oin.readObject();
        for (Object obj : out) {
            System.out.println(obj);
        }
    }
}
