package learn.core1.ch04;

import java.time.LocalDate;

/**
 * Represents an employee with id, name, salary and hire date.
 * Use {@link #raiseSalary(double)} to raise an employee's salary.
 *
 * @see learn.core1.ch04.EmployeeUsage
 */
public class Employee {
    private static final int INITIAL_ID = 1;

    private static int nextId;

    static {
        resetNextId();
        /*
        Random generator = new Random();
        nextId = generator.nextInt(10_000);
        */
    }

    public static int getNextId() {
        return nextId;
    }

    public static void resetNextId() {
        nextId = INITIAL_ID;
    }

    private static int assignId() {
        int r = nextId;
        nextId++;
        return r;
    }

    private int id; // = Employee.assignId();
    private final String name;
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
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.now();
    }

    /**
     * Constructs employee with salary.
     * @param salary
     */
    public Employee(double salary) {
        this.name = "Employee #" + id;
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
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }
}
