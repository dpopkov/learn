package learn.hfdp.ch10state;

public abstract class BaseState implements State {
    protected final GumballMachine machine;

    public BaseState(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
