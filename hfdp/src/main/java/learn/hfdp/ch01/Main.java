package learn.hfdp.ch01;

public class Main {
    public static void main(String[] args) {
        Duck[] ducks = new Duck[2];
        ducks[0] = new MallardDuck();
        ducks[1] = new RedheadDuck();
        for (Duck duck : ducks) {
            duck.display();
            duck.quack();
            duck.swim();
        }
    }
}
