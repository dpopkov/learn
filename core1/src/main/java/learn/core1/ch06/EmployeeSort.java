package learn.core1.ch06;

import learn.core1.ch04.Employee;
import learn.core1.ch05.Manager;

import java.util.Arrays;

public class EmployeeSort {
    public static void main(String[] args) {
        Employee[] staff = new Employee[4];
        staff[0] = new Employee("Harry  Hacker", 35_000);
        staff[1] = new Employee("Carl Cracker", 75_000);
        Manager timRobins = new Manager("Tim Robins", 30_000, 2000, 1, 1);
        timRobins.setBonus(100_000);
        staff[3] = timRobins;
        staff[2] = new Employee("Tony Tester", 38_000);
        Arrays.sort(staff);
        for (Employee e : staff) {
            System.out.printf("name=%s, salary=%f%n", e.getName(), e.getSalary());
        }
    }
}
