package learn.core1.ch05;

public class Student extends Person {
    private final String major;

    public Student(String name, String major) {
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription() {
        return String.format("a student majoring in %s",
                this.major);
    }

    @Override
    public String toString() {
        return super.toString() + "{major=" + major + "}";
    }
}
