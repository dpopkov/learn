package learn.hfdp.ch09iterator;

public class MenuItem implements MenuComponent {
    private String name;
    private String description;
    private boolean vegetarian;
    private double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.println("  " + getName() + (isVegetarian() ? " (v)" : "") + ", " + getPrice());
        System.out.println("    -- " + getDescription());
    }

    public String getDescription() {
        return description;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " " + price + " " + description + ", " + (vegetarian ? "vegetarian" : "non-vegetarian");
    }
}
