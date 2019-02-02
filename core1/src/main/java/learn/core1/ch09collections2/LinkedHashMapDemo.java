package learn.core1.ch09collections2;

import learn.core1.ch04.Employee;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        Map<String, Employee> staff = new CacheMap<>(4);
        staff.put("144-25-5464", new Employee("Amy Lee", 80_000.0));
        staff.put("576-24-2546", new Employee("Harry Hacker", 90_000.0));
        staff.put("157-62-7935", new Employee("Gary Cooper", 100_000.0));
        staff.put("456-62-5527", new Employee("Francesca Cruz", 70_000.0));
        staff.keySet().forEach(System.out::println);
        staff.values().forEach(System.out::println);
        System.out.println(staff.get("157-62-7935"));
        staff.keySet().forEach(System.out::println);
        System.out.println("Add entry...");
        staff.put("123-45-6789", new Employee("Harry Hook", 60_000.0));
        staff.keySet().forEach(System.out::println);
    }

    /**
     * Hash map that removes its eldest entry after every put operation.
     * @param <K> the type of keys
     * @param <V> the type of values
     */
    static class CacheMap<K, V> extends LinkedHashMap<K, V> {
        private final int maximumCacheSize;

        public CacheMap(int maximumCacheSize) {
            super(maximumCacheSize + 1, 0.75F, true);
            this.maximumCacheSize = maximumCacheSize;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > maximumCacheSize;
        }
    }
}
