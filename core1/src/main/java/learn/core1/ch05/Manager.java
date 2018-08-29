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

    @Override
    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + this.bonus;
    }

    public static void main(String[] args) {
        Manager[] ma = new Manager[2];
        Manager m0 = new Manager("Manager1", 100_000, 2000, 1, 1);
        ma[0] = m0;

        Employee e = new Employee("Jack", 10_000);
        Employee[] ea = new Employee[2];
        ea[0] = m0;
        ea[1] = e;

        ea = ma;
        System.out.println(ea[0].getName());
        ea[1] = e;
        System.out.println(ea[1].getName());
    }
}
