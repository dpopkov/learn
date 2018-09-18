package learn.ijpds.ch12exceptions.exercises;

public class IllegalTriangleException extends RuntimeException {
    public IllegalTriangleException(String message) {
        super(message);
    }
}
