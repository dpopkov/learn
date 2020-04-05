package learn.ijpds2nd.ch06methods.exer;

import java.util.Random;

class E0630Dice {
    private final Random random = new Random();

    public int roll() {
        return random.nextInt(6) + 1;
    }
}
