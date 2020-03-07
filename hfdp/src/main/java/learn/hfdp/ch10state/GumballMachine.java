package learn.hfdp.ch10state;

public class GumballMachine {
    private States state = States.SOLD_OUT;
    private int count;

    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = States.NO_QUARTER;
        }
    }

    public void insertQuarter() {
        if (state == States.HAS_QUARTER) {
            System.out.println("You can't insert another quarter");
        } else if (state == States.SOLD_OUT) {
            System.out.println("You can't insert a quarter, the machine is sold out");
        } else if (state == States.GUMBALL_SOLD) {
            System.out.println("Please wait, we're already giving you a gumball");
        } else if (state == States.NO_QUARTER) {
            state = States.HAS_QUARTER;
            System.out.println("You inserted a quarter");
        }
    }

    public void ejectQuarter() {
        if (state == States.HAS_QUARTER) {
            System.out.println("Quarter returned");
            state = States.NO_QUARTER;
        } else if (state == States.NO_QUARTER) {
            System.out.println("You haven't inserted a quarter");
        } else if (state == States.GUMBALL_SOLD) {
            System.out.println("Sorry, you already turned the crank");
        } else if (state == States.SOLD_OUT) {
            System.out.println("You can't eject, you haven't inserted a quarter yet");
        }
    }

    public void turnCrank() {
        if (state == States.GUMBALL_SOLD) {
            System.out.println("Turning twice doesn't get you another gumball");
        } else if (state == States.NO_QUARTER) {
            System.out.println("You turned but there's no quarter");
        } else if (state == States.SOLD_OUT) {
            System.out.println("You turned but there are no gumballs");
        } else if (state == States.HAS_QUARTER) {
            System.out.println("You turned...");
            state = States.GUMBALL_SOLD;
            dispense();
        }

    }

    public void dispense() {
        if (state == States.GUMBALL_SOLD) {
            System.out.println("A gumball comes rolling out the slot");
            count--;
            if (count == 0) {
                System.out.println("Oops, out of gumballs!");
                state = States.SOLD_OUT;
            } else {
                state = States.NO_QUARTER;
            }
        } else if (state == States.NO_QUARTER) {
            System.out.println("You need to pay first");
        } else if (state == States.SOLD_OUT) {
            System.out.println("No gumball dispensed");
        } else if (state == States.HAS_QUARTER) {
            System.out.println("No gumball dispensed");
        }
    }

    @Override
    public String toString() {
        return "GumballMachine{state=" + state + ", count=" + count + '}';
    }
}
