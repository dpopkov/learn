package learn.hfdp.ch06command;

import learn.hfdp.ch06command.devices.CeilingFan;

public class CeilingFanOnCommand implements Command {
    private final CeilingFan ceilingFan;

    public CeilingFanOnCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.low();
    }
}
