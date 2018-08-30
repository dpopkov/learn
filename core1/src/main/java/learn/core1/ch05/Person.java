package learn.core1.ch05;

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
}
