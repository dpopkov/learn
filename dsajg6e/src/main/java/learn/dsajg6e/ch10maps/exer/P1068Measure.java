package learn.dsajg6e.ch10maps.exer;

import learn.dsajg6e.ch10maps.ChainHashMap;
import learn.dsajg6e.ch10maps.Map;
import learn.dsajg6e.ch10maps.ProbeHashMap;
import learn.dsajg6e.tools.Input;
import learn.dsajg6e.tools.StopWatch;

import java.util.Random;

public class P1068Measure {
    private static final String DUMMY = "dummy";
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int size = Input.nextInt("Enter number of elements: ");
        Integer[] data = new Integer[size];
        for (int i = 0; i < size; i++) {
            data[i] = RANDOM.nextInt();
        }

        Map<Integer, String> chainMap = new ChainHashMap<>();
        Map<Integer, String> probeMap = new ProbeHashMap<>();

        System.out.println("Putting elements");
        putData(chainMap, data);
        putData(probeMap, data);

        System.out.println("Getting elements");
        getData(chainMap);
        getData(probeMap);
    }

    private static void putData(Map<Integer, String> map, Integer[] data) {
        StopWatch sw = new StopWatch();
        sw.start();
        for (Integer k : data) {
            map.put(k, DUMMY);
        }
        sw.stop();
        System.out.printf("Put %d elements to %s: %d ms%n", data.length, map.getClass().getSimpleName(), sw.getElapsed());
    }

    private static void getData(Map<Integer, String> map) {
        Iterable<Integer> keys = map.keySet();
        StopWatch sw = new StopWatch();
        sw.start();
        for (Integer k : keys) {
            map.get(k);
        }
        sw.stop();
        System.out.printf("Get %d elements to %s: %d ms%n", map.size(), map.getClass().getSimpleName(), sw.getElapsed());
    }
}
