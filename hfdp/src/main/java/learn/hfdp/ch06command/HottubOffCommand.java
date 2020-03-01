package learn.hfdp.ch06command;

import learn.hfdp.ch06command.devices.Hottub;

public class HottubOffCommand implements Command {
    private final Hottub hottub;

    public HottubOffCommand(Hottub hottub) {
        this.hottub = hottub;
    }

    @Override
    public void execute() {
        hottub.jestOff();
    }

    @Override
    public void undo() {
        hottub.jetsOn();
    }
}
