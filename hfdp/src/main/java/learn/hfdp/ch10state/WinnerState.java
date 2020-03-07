package learn.hfdp.ch10state;

public final class WinnerState extends BaseState {
    public WinnerState(GumballMachine machine) {
        super(machine);
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball");
    }

    @Override
    public void dispense() {
        System.out.println("YOU'RE A WINNER! You get two gumballs for your quarter");
        machine.releaseBall();
        if (machine.getCount() == 0) {
            System.out.println("Oops, out of gumballs!");
            machine.setState(machine.getSoldOutState());
        } else {
            machine.releaseBall();
            if (machine.getCount() == 0) {
                System.out.println("Oops, out of gumballs!");
                machine.setState(machine.getSoldOutState());
            } else {
                machine.setState(machine.getNoQuarterState());
            }
        }
    }
}
