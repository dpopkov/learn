package learn.hfdp.ch06command;

import learn.hfdp.ch06command.devices.Stereo;

public class StereoOnWithCdCommand implements Command {
    private final Stereo stereo;

    public StereoOnWithCdCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCd();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
