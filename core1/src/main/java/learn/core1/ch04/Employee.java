package learn.core1.ch04;

import learn.core1.ch05.Person;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;

/**
 * Represents an employee with id, name, salary and hire date.
 * Use {@link #raiseSalary(double)} to raise an employee's salary.
 *
 * @see learn.core1.ch04.EmployeeUsage
 */
public class Employee extends Person implements Comparable<Employee> {
    public static final int NAME_SIZE = 38;
    public static final int RECORD_SIZE = Integer.BYTES + NAME_SIZE * 2 + Double.BYTES + Integer.BYTES * 3 ;

    private static final int INITIAL_ID = 1;

    private static int nextId;

    static {
        resetNextId();
    }

    public static int getNextId() {
        return nextId;
    }

    /**
     * Resets {@code nextId} field.
     * This method has package access for unit testing purposes.
     */
    static void resetNextId() {
        nextId = INITIAL_ID;
    }

    private final int id;
    private double salary;
    private final LocalDate hireDay;

    private static int assignId() {
        return nextId++;
    }

    public Employee() {
        super("default");
        id = assignId();
        this.hireDay = LocalDate.now();
    }

    /**
     * Constructs employee with name and salary.
     * @param name name of employee
     * @param salary salary of employee
     */
    public Employee(String name, double salary) {
        super(name);
        id = assignId();
        this.salary = salary;
        this.hireDay = LocalDate.now();
    }

    /**
     * Constructs employee with salary.
     * @param salary salary of employee
     */
    public Employee(double salary) {
        super("Employee");
        id = assignId();
        augmentNameWithId();
        this.salary = salary;
        this.hireDay = LocalDate.now();
    }

    /**
     * Constructs employee with name, salary and hire date.
     * @param name name
     * @param salary salary
     * @param year year (e.g. 2001)
     * @param month month (1-12)
     * @param day day of month
     */
    public Employee(String name, double salary, int year, int month, int day) {
        super(name);
        id = assignId();
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    /**
     * Constructor that is used in {@link EmployeeIO} static methods.
     * @param id id
     * @param name name
     * @param salary salary
     * @param hireDay hire day
     */
    public Employee(int id, String name, double salary, LocalDate hireDay) {
        super(name);
        this.id = id;
        this.salary = salary;
        this.hireDay = hireDay;
    }

    private void augmentNameWithId() {
        super.addSuffixToName(" #" + id);
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String getDescription() {
        return String.format(Locale.US,
                "an employee with a salary of $%.2f",
                getSalary());
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                "id=" + id +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) return false;
        if (getClass() != otherObject.getClass()) return false;
        Employee other = (Employee) otherObject;
        return this.salary == other.salary
                && Objects.equals(this.hireDay, other.hireDay);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + 17 * Objects.hash(salary, hireDay);
    }

    @Override
    public final int compareTo(Employee other) {
        return Double.compare(this.getSalary(), other.getSalary());
    }
}
