package learn.core1.ch04;

import learn.core1.ch05.Person;

import java.time.LocalDate;
import java.util.Locale;

/**
 * Represents an employee with id, name, salary and hire date.
 * Use {@link #raiseSalary(double)} to raise an employee's salary.
 *
 * @see learn.core1.ch04.EmployeeUsage
 */
public class Employee extends Person {
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

    private int id; // = Employee.assignId();
    private double salary;
    private final LocalDate hireDay;

    // object initialization block runs first
    {
        id = nextId;
        nextId++;
    }

    /**
     * Constructs employee with name and salary.
     * @param name
     * @param salary
     */
    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
        this.hireDay = LocalDate.now();
    }

    /**
     * Constructs employee with salary.
     * @param salary
     */
    public Employee(double salary) {
        super("Employee");
        augmentNameWithId();
        this.salary = salary;
        this.hireDay = LocalDate.now();
    }

    /**
     * Constructs employee with name, salary and hire date.
     * @param name
     * @param salary
     * @param year
     * @param month
     * @param day
     */
    public Employee(String name, double salary, int year, int month, int day) {
        super(name);
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    private void augmentNameWithId() {
        this.name = this.name + " #" + id;
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
        return "Employee{" +
                "id=" + id +
                ", name='" + getName() + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }
}