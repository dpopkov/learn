package learn.ijpds.ch07arrays;

public class IntResult {
    private final int value;
    private final boolean success;
    private final String message;

    public IntResult(int value) {
        this(value, true, null);
    }

    public IntResult(String message) {
        this(-1, false, message);
    }

    private IntResult(int value, boolean success, String message) {
        this.value = value;
        this.success = success;
        this.message = message;
    }

    public int getValue() {
        return value;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
