package learn.hfdp.ch06command;

public class RemoteControl {
    private static final int NUM_OF_PAIRS = 7;

    private final Command[] onCommands;
    private final Command[] offCommands;

    public RemoteControl() {
        onCommands = new Command[NUM_OF_PAIRS];
        offCommands = new Command[NUM_OF_PAIRS];
        Command noCommand = () -> { };
        for (int i = 0; i < NUM_OF_PAIRS; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonPushed(int slot) {
        offCommands[slot].execute();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n------ Remote Control ------\n");
        for (int i = 0; i < onCommands.length; i++) {
            builder.append("[slot ").append(i).append("] ")
                    .append(onCommands[i].getClass().getSimpleName()).append("    ")
                    .append(offCommands[i].getClass().getSimpleName()).append("\n");
        }
        return builder.toString();
    }
}
