package learn.bj6e.ch11io;

import java.io.IOException;

/**
 * Reports bad input data.
 */
public class BadDataException extends IOException {
    public BadDataException() {}

    public BadDataException(String message) {
        super(message);
    }
}
