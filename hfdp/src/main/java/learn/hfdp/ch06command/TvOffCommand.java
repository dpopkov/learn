package learn.hfdp.ch06command;

import learn.hfdp.ch06command.devices.TV;

public class TvOffCommand implements Command {
    private final TV tv;

    public TvOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }

    @Override
    public void undo() {
        tv.on();
    }
}
