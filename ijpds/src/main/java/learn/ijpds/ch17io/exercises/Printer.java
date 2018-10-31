package learn.ijpds.ch17io.exercises;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;

public abstract class Printer {
    private final Consumer<String> output;
    private final int bytesPerLine;

    public Printer(Consumer<String> output, int bytesPerLine) {
        this.output = output;
        this.bytesPerLine = bytesPerLine;
    }

    /**
     * Prints data from the specified source stream.
     * @param source source stream
     * @throws IOException when parameter source throws exception
     */
    public void print(InputStream source) throws IOException {
        for (int count = 1, byteValue; (byteValue = source.read()) != -1; count++) {
            output.accept(getByteRepresentation(byteValue));
            output.accept(count % bytesPerLine == 0
                    ? System.lineSeparator()
                    : " ");
        }
    }

    public abstract String getByteRepresentation(int byteValue);
}
