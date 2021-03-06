package learn.hfdp.ch06command;

import learn.hfdp.ch06command.devices.CeilingFan;

public class CeilingFanOffCommand implements Command {
    private final CeilingFan ceilingFan;
    private int prevSpeed;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.off();
    }

    @Override
    public void undo() {
        ceilingFan.setSpeed(prevSpeed);
    }
}
