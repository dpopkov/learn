package learn.hfdp.ch01;

public class RedheadDuck extends Duck implements Flyable, Quackable {
    @Override
    public void display() {
        System.out.println("Looks like a readhead.");
    }

    @Override
    public void fly() {
        System.out.println("Fly.");
    }

    @Override
    public void quack() {
        System.out.println("Quack!");
    }
}
