package learn.hfdp.ch06command;

public class RemoteControl {
    private static final int NUM_OF_PAIRS = 7;

    private final Command[] onCommands;
    private final Command[] offCommands;
    private Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[NUM_OF_PAIRS];
        offCommands = new Command[NUM_OF_PAIRS];
        final Command noCommand = new Command() {
            @Override
            public void execute() { }

            @Override
            public void undo() { }
        };
        for (int i = 0; i < NUM_OF_PAIRS; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonPushed() {
        undoCommand.undo();
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
