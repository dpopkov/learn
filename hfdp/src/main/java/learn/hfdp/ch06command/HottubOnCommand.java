package learn.hfdp.ch06command;

import learn.hfdp.ch06command.devices.Hottub;

public class HottubOnCommand implements Command {
    private final Hottub hottub;

    public HottubOnCommand(Hottub hottub) {
        this.hottub = hottub;
    }

    @Override
    public void execute() {
        hottub.jetsOn();
    }

    @Override
    public void undo() {
        hottub.jestOff();
    }
}
