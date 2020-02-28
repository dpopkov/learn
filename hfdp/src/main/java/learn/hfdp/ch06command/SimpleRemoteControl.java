package learn.hfdp.ch06command;

/**
 * Invoker that holds a command and at some point asks the command
 * to carry out a request.
 */
public class SimpleRemoteControl {
    private Command slot;

    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonPressed() {
        slot.execute();
    }
}
