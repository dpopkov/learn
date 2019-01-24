package learn.core1.ch08generics.wildcards;

import learn.core1.ch04.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SuperBoundInPredicate {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Bob", 10_000));
        employees.add(new Employee("Alice", 20_000));
        employees.add(new Employee("Bobby", 30_000));
        Predicate<Object> oddHash = obj -> obj.hashCode() % 2 == 0;
        employees.removeIf(oddHash);
        Predicate<Employee> less25 = emp -> emp.getSalary() < 25_000.0;
        employees.removeIf(less25);
        employees.forEach(System.out::println);
    }
}
