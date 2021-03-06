package learn.hfdp.ch10state;

import learn.hfdp.ch11proxy.GumballMachineRemote;

public class GumballMachine implements GumballMachineRemote {
    private final State noQuarterState;
    private final State hasQuarterState;
    private final State soldState;
    private final State winnerState;
    private final State soldOutState;
    private State state;
    private int count;
    private final String location;

    public GumballMachine(String location, int count) {
        this.location = location;
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
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
        if (state == soldState || state == winnerState) {
            state.dispense();
        }
    }

    public void refill(int count) {
        this.count = count;
        state = noQuarterState;
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

    public State getWinnerState() {
        return winnerState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return "GumballMachine{state=" + state + ", count=" + count + '}';
    }
}
