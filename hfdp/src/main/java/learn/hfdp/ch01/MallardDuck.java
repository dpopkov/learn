package learn.hfdp.ch01;

public class MallardDuck extends Duck {
    public MallardDuck() {
        super(new FlyWithWings(), new Quack());
    }

    @Override
    public void display() {
        System.out.println("Looks like a mallard.");
    }
}
