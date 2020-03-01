package learn.hfdp.ch06command;

import learn.hfdp.ch06command.devices.Light;

/**
 * Defines the binding between an "off" action and a {@link Light} receiver.
 */
public class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
