package learn.hfdp.ch10state;

import java.util.Random;

public final class HasQuarterState extends BaseState {
    private final Random randomWinner = new Random();

    public HasQuarterState(GumballMachine machine) {
        super(machine);
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        machine.setState(machine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        int winner = randomWinner.nextInt(10);
        if (winner == 0 && machine.getCount() > 1) {
            machine.setState(machine.getWinnerState());
        } else {
            machine.setState(machine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
