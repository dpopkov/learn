package learn.ijpds.ch17io.exercises;

import java.io.IOException;
import java.io.InputStream;

public class BinaryContentPresenter implements ContentPresenter {
    private final int bytesPerLine;

    public BinaryContentPresenter(int bytesPerLine) {
        this.bytesPerLine = bytesPerLine;
    }

    @Override
    public String getFromStream(InputStream input) throws IOException {
        StringBuilder buffer = new StringBuilder();
        BinaryPrinter printer = new BinaryPrinter(buffer::append, bytesPerLine);
        printer.print(input);
        return buffer.toString();
    }

    @Override
    public byte[] toBytes(String content) {
        BinaryStringReader converter = new BinaryStringReader();
        return converter.read(content);
    }
}
