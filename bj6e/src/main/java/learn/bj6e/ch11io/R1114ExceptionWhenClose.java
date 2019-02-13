package learn.bj6e.ch11io;

import java.io.IOException;

/**
 * Demonstrates suppressing an exception thrown in implicit finally
 * block when using try-with-resources.
 */
public class R1114ExceptionWhenClose {
    private static class ClosingException extends IOException { }

    private static class MainException extends IOException {}

    private static class FooStream implements AutoCloseable {
        public void foo() throws MainException {
            System.out.println("In method foo()");
            throw new MainException();
        }

        @Override
        public void close() throws Exception {
            System.out.println("Closing FooStream");
            throw new ClosingException();
        }
    }

    public static void main(String[] args) {
        try (FooStream stream = new FooStream()) {
            stream.foo();
        } catch (Exception e) {
            System.out.println("Exception: " + e.toString());
            System.out.println("Suppressed: " + e.getSuppressed()[0].toString());
        }
    }


}
