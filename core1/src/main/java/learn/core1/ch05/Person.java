package learn.core1.ch05;

import java.util.Objects;

public abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getDescription();

    protected void addSuffixToName(String suffix) {
        this.name = this.name + suffix;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Person other = (Person) otherObject;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{name=" + name + "}";
    }
}
