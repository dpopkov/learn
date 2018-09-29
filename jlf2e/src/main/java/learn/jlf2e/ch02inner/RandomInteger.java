/* 2-6. Declaring a top-level class, which is used as the superclass for a local class. */
package learn.jlf2e.ch02inner;

import java.util.Random;

public class RandomInteger {
    private final Random random = new Random();

    public int getValue() {
        return random.nextInt();
    }
}
