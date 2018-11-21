package learn.dsai.ch04.projects.p0405;

public class Customer {
    private final int id;
    private int groceries;

    public Customer(int id, int groceries) {
        this.id = id;
        this.groceries = groceries;
    }

    public int getGroceries() {
        return groceries;
    }

    public void setGroceries(int groceries) {
        this.groceries = groceries;
    }

    @Override
    public String toString() {
        return "{#" + id + ": " + groceries + '}';
    }
}
