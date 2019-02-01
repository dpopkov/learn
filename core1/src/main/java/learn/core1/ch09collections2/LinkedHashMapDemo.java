package learn.core1.ch09collections2;

import learn.core1.ch04.Employee;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        Map<String, Employee> staff = new LinkedHashMap<>();
        staff.put("144-25-5464", new Employee("Amy Lee", 80_000.0));
        staff.put("576-24-2546", new Employee("Harry Hacker", 90_000.0));
        staff.put("157-62-7935", new Employee("Gary Cooper", 100_000.0));
        staff.put("456-62-5527", new Employee("Francesca Cruz", 70_000.0));
        staff.keySet().forEach(System.out::println);
        staff.values().forEach(System.out::println);
    }
}
