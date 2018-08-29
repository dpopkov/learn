package learn.csia.ch0103.exer;

import java.util.*;

public class Counter {
    private Map<Integer, Integer> map = new HashMap<>();

    public void add(int value) {
        if (map.containsKey(value)) {
            map.put(value, map.get(value) + 1);
        } else {
            map.put(value, 1);
        }
    }

    public int getCount(int value) {
        if (map.containsKey(value)) {
            return map.get(value);
        }
        return -1;
    }

    @Override
    public String toString() {
        String nl = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        Set<Integer> keys = map.keySet();
        List<Integer> keyList = Arrays.asList(keys.toArray(new Integer[0]));
        keyList.sort(Comparator.naturalOrder());
        for (Integer key : keyList) {
            sb.append(key);
            sb.append(": ");
            sb.append(getCount(key));
            sb.append(nl);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Counter c = new Counter();
        c.add(3);
        c.add(3);
        c.add(3);
        c.add(3);
        c.add(42);
        c.add(42);
        c.add(42);
        c.add(32);
        System.out.println(c);
    }
}
