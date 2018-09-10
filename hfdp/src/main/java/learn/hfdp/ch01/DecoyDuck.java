package learn.hfdp.ch01;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        super(new FlyNoWay(), new MuteQuack());
    }

    @Override
    public void display() {
        System.out.println("Looks like decoy.");
    }
}
