package learn.core1.ch05;

import learn.core1.ch04.Employee;

public class ManagerUsage {
    public static void main(String[] args) {
        Manager boss = new Manager("Carl Cracker", 80_000, 1978, 12, 15);
        boss.setBonus(5_000);

        Employee[] staff = new Employee[3];

        staff[0] = boss;
        staff[1] = new Employee("Harry Hacker", 50_000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40_000, 1990, 3, 15);

        for (Employee e : staff) {
            System.out.printf("%s %.2f%n", e.getName(), e.getSalary());
        }
    }
}
