/* 2-7. A local inner class that inherits from another class. */
package learn.jlf2e.ch02inner;

public class OuterForRandomLocal {
    public RandomInteger getRandomInteger() {
        class RandomIntegerLocal extends RandomInteger {
            @Override
            public int getValue() {
                int n1 = super.getValue();
                int n2 = super.getValue();
                return (n1 + n2) / 2;
            }
        }
        return new RandomIntegerLocal();
    }
}
