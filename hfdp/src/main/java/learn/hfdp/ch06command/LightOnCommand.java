package learn.hfdp.ch06command;

import learn.hfdp.ch06command.devices.Light;

/**
 * Defines the binding between an "on" action and a {@link Light} receiver.
 */
public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
        System.out.println("Light is On");
    }
}
