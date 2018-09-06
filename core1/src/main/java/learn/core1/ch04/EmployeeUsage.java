package learn.core1.ch04;

/**
 * Example of usage {@code Employee} class.
 */
public class EmployeeUsage {
    public static void main(String[] args) {
        Employee[] staff = new Employee[5];

        staff[0] = new Employee("Carl Cracker", 75_000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50_000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40_000, 1990, 3, 15);
        staff[3] = new Employee(100_000);
        staff[4] = new Employee(200_000);

        for (Employee e : staff) {
            e.raiseSalary(5);
        }

        for (Employee e : staff) {
            System.out.println(e);
        }

        int n = Employee.getNextId();
        System.out.printf("Next available id = %d%n", n);
    }
}
