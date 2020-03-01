package learn.hfdp.ch06command;

import learn.hfdp.ch06command.devices.CeilingFan;

public class CeilingFanMediumCommand implements Command {
    private final CeilingFan ceilingFan;
    private int prevSpeed;

    public CeilingFanMediumCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.medium();
    }

    @Override
    public void undo() {
        ceilingFan.setSpeed(prevSpeed);
    }
}
