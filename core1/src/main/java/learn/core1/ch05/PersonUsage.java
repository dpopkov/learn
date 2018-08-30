package learn.core1.ch05;

import learn.core1.ch04.Employee;

/**
 * This program demonstrates abstract classes.
 */
public class PersonUsage {
    public static void main(String[] args) {
        Person[] people = new Person[2];

        people[0] = new Employee("Harry Hacker", 50_000, 1989, 10, 1);
        people[1] = new Student("Maria Morris", "Computer Science");

        for (Person p : people) {
            System.out.printf("%s, %s%n", p.getName(), p.getDescription());
        }
    }
}
