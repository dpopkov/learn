package learn.core1.ch06.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * Demonstrates the use of proxies.
 */
public class ProxyUsage {
    public static void main(String[] args) {
        Object[] elements = new Object[1000];

        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null, new Class[] {Comparable.class}, handler);
            elements[i] = proxy;
        }
        Integer randomKey = new Random().nextInt(elements.length) + 1;
        int keyIndex = Arrays.binarySearch(elements, randomKey);
        if (keyIndex >= 0) {
            System.out.println(elements[keyIndex]);
        }
    }
}
