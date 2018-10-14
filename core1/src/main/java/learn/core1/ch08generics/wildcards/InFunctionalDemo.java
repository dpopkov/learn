package learn.core1.ch08generics.wildcards;

import learn.core1.ch04.Employee;
import learn.core1.ch05.Manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

/* How wildcards are used in functional interfaces. */
public class InFunctionalDemo {
    public static void main(String[] args) {
        Collection<Manager> col = new ArrayList<Manager>() {
            {
                add(new Manager("Bob", 200_000, 2000, 10, 1));
                add(new Manager("Alice", 100_000, 2000, 10, 1));
                add(new Manager("Bill", 30_000, 2000, 10, 1));
                get(0).setBonus(350_000);
                get(1).setBonus(50_000);
                get(2).setBonus(250_000);
            }
        };
        col.forEach(System.out::println);

        /* Here predicate uses supertype of list's element type. */
        Predicate<Employee> filterEmployees = employee -> employee.getSalary() > 500_000.0;
        col.removeIf(filterEmployees);
        System.out.println("\nAfter removing employees by salary:");
        col.forEach(System.out::println);

        Predicate<Manager> filterManagers = manager -> manager.getBonus() < 100_000.0;
        col.removeIf(filterManagers);
        System.out.println("\nAfter removing managers by bonus:");
        col.forEach(System.out::println);
    }
}
