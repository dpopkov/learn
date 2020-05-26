package learn.ijpds2nd.ch09obj;

import java.util.Date;

/*
Example of mutable class.
For a class to be immutable, it must meet the following requirements:
- All data fields must be private.
- There can’t be any mutator methods for data fields.
- No accessor methods can return a reference to a data field that is mutable.
 */
public class StudentMutable {
    private final int id;
    private final String name;
    private final Date created;

    public StudentMutable(int id, String name) {
        this.id = id;
        this.name = name;
        created = new Date();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreated() {
        return created;
    }

    public static void main(String[] args) {
        StudentMutable student = new StudentMutable(101, "Bob");
        Date created = student.getCreated();
        created.setTime(0L);
        System.out.println("Now 'created' field is change!");
    }
}
