package learn.core1.ch06.cloning;

/**
 * Demonstrates cloning.
 */
public class CloneUsage {
    public static void main(String[] args) {
        Employee original = new Employee("John Q. Public", 50_000);
        original.setHireDay(2000, 1, 1);
        try {
            Employee copy = original.clone();
            copy.raiseSalary(100);
            copy.setHireDay(2002, 12, 31);
            System.out.println("Original = " + original);
            System.out.println("Copy     = " + copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
