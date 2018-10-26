package learn.ijpds.ch17io.checkpoint;

import java.util.Objects;

public class Student {
    private final String name;
    private final String major;

    public Student(String name, String major) {
        this.name = name;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', major='" + major + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(major, student.major);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, major);
    }
}
