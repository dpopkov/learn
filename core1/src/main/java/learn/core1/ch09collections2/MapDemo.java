package learn.core1.ch09collections2;

import learn.core1.ch04.Employee;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Employee> staff = new HashMap<>();
        staff.put("144-25-5464", new Employee("Amy Lee", 80_000.0));
        staff.putAll(Map.of(
                "576-24-2546", new Employee("Harry Hacker", 90_000.0),
                "157-62-7935", new Employee("Gary Cooper", 100_000.0),
                "456-62-5527", new Employee("Francesca Cruz", 70_000.0)
        ));
        print("Initial:", staff);
        staff.remove("576-24-2546");
        print("Removing...", staff);
        staff.put("456-62-5527", new Employee("Francesca Miller", 110_000.0));
        print("Replacing...", staff);
    }

    private static <K, V> void print(String title, Map<K, V> staff) {
        System.out.println(title);
        staff.forEach((k, v) -> System.out.printf("%s : %s%n", k, v));
    }
}
