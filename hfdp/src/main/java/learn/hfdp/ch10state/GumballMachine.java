package learn.hfdp.ch10state;

public class GumballMachine {
    private final State noQuarterState;
    private final State hasQuarterState;
    private final State soldState;
    private final State soldOutState;
    private State state;
    private int count;

    public GumballMachine(int count) {
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);
        this.count = count;
        if (count > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        if (state == soldState) {
            state.dispense();
        }
    }

    public void releaseBall() {
        if (count != 0) {
            System.out.println("A gumball comes rolling out the slot...");
            count--;
        }
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "GumballMachine{state=" + state + ", count=" + count + '}';
    }
}
