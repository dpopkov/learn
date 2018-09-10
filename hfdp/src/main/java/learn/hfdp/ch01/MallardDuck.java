package learn.hfdp.ch01;

public class MallardDuck extends Duck implements Flyable, Quackable {
    @Override
    public void display() {
        System.out.println("Looks like a mallard.");
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
