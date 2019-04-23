package learn.javaio2e.ch13obj;

import java.io.*;

/**
 * Demonstrates usage of {@code readResolve()} method to maintain the uniqueness of singleton.
 * By serializing the instance of this class and then deserializing it, one can create a new instance
 * despite the private constructor because serialization doesn't rely on constructors.
 * To fix this, you have to make sure that whenever the class is deserialized, the new object is replaced
 * by the genuine single instance.
 * This is easy to accomplish by adding the {@link #readResolve()} method.
 */
public class SerializableSingleton implements Serializable {
    private static final long serialVersionUID = -7999200057091440027L;

    public final static SerializableSingleton INSTANCE = new SerializableSingleton();

    private SerializableSingleton() {
        System.out.println("private SerializableSingleton()");
    }

    /**
     * Replaces the object read from a stream during deserialization with a single instance object.
     * @return singleton instance
     */
    private Object readResolve() {
        return INSTANCE;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        SerializableSingleton ss1 = SerializableSingleton.INSTANCE;
        oos.writeObject(ss1);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
        SerializableSingleton ss2 = (SerializableSingleton) ois.readObject();
        System.out.println(ss1 == ss2);
    }
}
