package learn.hfdp.ch06command;

public interface Command {
    void execute();

    /** Undo the last action. */
    void undo();
}
