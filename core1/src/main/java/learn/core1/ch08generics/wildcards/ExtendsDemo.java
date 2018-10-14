package learn.core1.ch08generics.wildcards;

import learn.core1.ch04.Employee;
import learn.core1.ch05.Manager;
import learn.core1.ch08generics.Pair;

public class ExtendsDemo {
    public static void printBuddies(Pair<? extends Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Ivan", 100_000);
        Employee e2 = new Manager("Al", 200_000, 2018, 10, 12);
        Pair<Employee> p = new Pair<>(e1, e2);
        printBuddies(p);

        Manager m1 = new Manager("Al", 200_000, 2018, 10, 12);
        Manager m2 = new Manager("Ivan", 300_000, 2018, 10, 12);
        Pair<Manager> p2 = new Pair<>(m1, m2);
        printBuddies(p2);

//        Pair<? extends Employee> p3 = p2;
//        NotManager nm = new NotManager("Sam", 100_000);
//        p3.setFirst(nm);    // compile error
    }
}

@SuppressWarnings("unused")
class NotManager extends Employee {

    public NotManager(String name, double salary) {
        super(name, salary);
    }
}