package learn.dsajg6e.ch01primer;

/**
 * CF 1.3: demonstration of the used of {@link Counter} instances.
 */
public class CounterDemo {
    public static void main(String[] args) {
        Counter c = new Counter();
        c.increment();
        System.out.println("c = " + c);
        c.increment(3);
        System.out.println("c = " + c);
        int temp = c.getCount();
        System.out.println("temp = " + temp);
        c.reset();
        System.out.println("c = " + c);
        Counter d = new Counter(5);
        System.out.println("d = " + d);
        d.increment();
        System.out.println("d = " + d);
        @SuppressWarnings("UnnecessaryLocalVariable")
        Counter e = d;
        System.out.println("e = " + e);
        temp = e.getCount();
        System.out.println("temp = " + temp);
        e.increment();
        System.out.println("e = " + e);
    }
}
