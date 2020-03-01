package learn.hfdp.ch06command;

import learn.hfdp.ch06command.devices.TV;

public class TvOnCommand implements Command {
    private final TV tv;

    public TvOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }

    @Override
    public void undo() {
        tv.off();
    }
}
