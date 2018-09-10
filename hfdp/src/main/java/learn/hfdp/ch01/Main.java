package learn.hfdp.ch01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Duck> ducks = new ArrayList<>();
        ducks.add(new MallardDuck());
        ducks.add(new RedheadDuck());
        ducks.add(new RubberDuck());
        ducks.add(new DecoyDuck());
        for (Duck duck : ducks) {
            System.out.println();
            duck.display();
            if (duck instanceof Quackable) {
                ((Quackable)duck).quack();
            }
            duck.swim();
            if (duck instanceof Flyable) {
                ((Flyable)duck).fly();
            }
        }
    }
}
