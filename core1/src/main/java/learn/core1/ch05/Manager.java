package learn.core1.ch05;

import learn.core1.ch04.Employee;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        this.bonus = 0;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + this.bonus;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) return false;
        Manager other = (Manager) otherObject;
        return this.bonus == other.bonus;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + 17 * Double.hashCode(bonus);
    }

    @Override
    public String toString() {
        return super.toString() + "{bonus=" + bonus + "}";
    }

    public static void main(String[] args) {
        Manager[] managers = new Manager[2];
        Manager m0 = new Manager("Manager1", 100_000, 2000, 1, 1);
        managers[0] = m0;

        Employee jack = new Employee("Jack", 10_000);
        Employee[] employees = new Employee[2];
        employees[0] = m0;
        employees[1] = jack;

        //noinspection UnnecessaryLocalVariable
        Employee[] likeEmployees = managers;
        System.out.println(likeEmployees[0].getName());

        // How to get a runtime exception:
        /*likeEmployees[1] = jack;    // java.lang.ArrayStoreException
        System.out.println(likeEmployees[1].getName());*/

        if (likeEmployees[0] instanceof Manager) {
            Manager managerAgain = (Manager) likeEmployees[0];
            managerAgain.raiseSalary(5);
            System.out.println(managerAgain.getSalary());
        }

        if (employees[1] instanceof Manager) {
            Manager wannabe = (Manager) employees[1];   // java.lang.ClassCastException
            wannabe.raiseSalary(100500);
            System.out.println(wannabe.getSalary());
        } else {
            System.out.println("Can not cast non Manager to Manager");
        }
    }
}
