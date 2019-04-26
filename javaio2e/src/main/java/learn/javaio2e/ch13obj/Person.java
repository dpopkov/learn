package learn.javaio2e.ch13obj;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Demonstrates usage of {@link ObjectInputValidation} to check the class invariants.
 * Let's suppose that the application doesn't allow two Person objects with the same social security
 * number to exist at the same time. The ObjectInputValidation is used to check each Person object as
 * its deserialized to make sure it doesn't duplicate the social security number of a person
 * already in the map.
 */
public class Person implements Serializable, ObjectInputValidation {
    private static final long serialVersionUID = -1341121001370083934L;

    private static final Map<String, String> thePeople = new HashMap<>();

    private final String name;
    /** Social security number. */
    private final String ss;

    public Person(String name, String ss) {
        this.name = name;
        this.ss = ss;
        thePeople.put(ss, name);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.registerValidation(this, 5);
        in.defaultReadObject();
    }

    @Override
    public void validateObject() throws InvalidObjectException {
        if (thePeople.containsKey(this.ss)) {
            throw new InvalidObjectException(this.name + " already exists");
        } else {
            thePeople.put(this.ss, this.name);
        }
    }

    @Override
    public String toString() {
        return name + "\t" + ss;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person p1 = new Person("Rusty", "123-45-5678");
        Person p2 = new Person("Beth",  "321-45-5678");
        Person p3 = new Person("David", "453-45-5678");
        Person p4 = new Person("David", "453-45-5678");
        thePeople.values().forEach(System.out::println);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream objectOut = new ObjectOutputStream(bout);
        writePersons(objectOut, p1, p2, p3, p4);
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream objectIn = new ObjectInputStream(bin);
        readPersons(objectIn);
        thePeople.clear();
        bin = new ByteArrayInputStream(bout.toByteArray());
        objectIn = new ObjectInputStream(bin);
        readPersons(objectIn);
        thePeople.values().forEach(System.out::println);
    }

    private static void writePersons(ObjectOutputStream out, Person... persons) throws IOException {
        for (Person p : persons) {
            out.writeObject(p);
        }
        out.flush();
        out.close();
    }

    private static void readPersons(ObjectInputStream in) throws IOException, ClassNotFoundException {
        try {
            System.out.println(in.readObject());
            System.out.println(in.readObject());
            System.out.println(in.readObject());
            System.out.println(in.readObject());
        } catch (InvalidObjectException e) {
            System.err.println(e.getMessage());
        }
        in.close();
    }
}
