/* 9.6 */
package learn.core1.ch09collections;

import learn.core1.ch04.Employee;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Employee> staff = new HashMap<>();
        staff.put("144-25-5464", new Employee("Amy Lee", 100_000));
        staff.put("567-24-2546", new Employee("Harry Hacker", 100_000));
        staff.put("157-62-7935", new Employee("Gary Cooper", 100_000));
        staff.put("456-62-5527", new Employee("Francesca Cruz", 100_000));
        staff.forEach((k, v) -> System.out.printf("%s : %s%n", k, v.getName()));

        staff.remove("567-24-2546");
        staff.put("456-62-5527", new Employee("Francesca Miller", 200_000));
        System.out.println(staff.get("157-62-7935"));
        staff.forEach((k, v) -> System.out.printf("%s : %s%n", k, v.getName()));
    }
}
