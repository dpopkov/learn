package learn.hfdp.ch10state;

public class GumballMachineTestDrive {
    public static void main(String[] args) {
        GumballMachine machine = new GumballMachine(5);
        display(machine);

        machine.insertQuarter();
        machine.turnCrank();
        display(machine);

        machine.insertQuarter();
        machine.ejectQuarter();
        machine.turnCrank();
        display(machine);

        machine.insertQuarter();
        machine.turnCrank();
        machine.insertQuarter();
        machine.turnCrank();
        machine.ejectQuarter();
        display(machine);

        machine.insertQuarter();
        machine.insertQuarter();
        machine.turnCrank();
        machine.insertQuarter();
        machine.turnCrank();
        machine.insertQuarter();
        machine.turnCrank();
        display(machine);
    }

    private static void display(GumballMachine machine) {
        System.out.println(machine);
        System.out.println();
    }
}
