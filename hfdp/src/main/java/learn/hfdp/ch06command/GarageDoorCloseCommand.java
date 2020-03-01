package learn.hfdp.ch06command;

import learn.hfdp.ch06command.devices.GarageDoor;

/**
 * Defines the binding between an "up" action and a {@link GarageDoor} receiver.
 */
public class GarageDoorCloseCommand implements Command {
    private final GarageDoor door;

    public GarageDoorCloseCommand(GarageDoor door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.down();
    }

    @Override
    public void undo() {
        door.up();
    }
}
