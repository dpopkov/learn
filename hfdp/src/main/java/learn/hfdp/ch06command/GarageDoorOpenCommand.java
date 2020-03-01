package learn.hfdp.ch06command;

import learn.hfdp.ch06command.devices.GarageDoor;

/**
 * Defines the binding between an "up" action and a {@link GarageDoor} receiver.
 */
public class GarageDoorOpenCommand implements Command {
    private final GarageDoor door;

    public GarageDoorOpenCommand(GarageDoor door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.up();
    }

    @Override
    public void undo() {
        door.down();
    }
}
