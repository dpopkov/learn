package learn.ijpds.ch17io.exercises;

import java.io.IOException;
import java.io.InputStream;

public class HexContentPresenter implements ContentPresenter {
    private final int bytesPerLine;

    public HexContentPresenter(int bytesPerLine) {
        this.bytesPerLine = bytesPerLine;
    }

    @Override
    public String getFromStream(InputStream input) throws IOException {
        StringBuilder buffer = new StringBuilder();
        Printer printer = new HexPrinter(buffer::append, bytesPerLine);
        printer.print(input);
        return buffer.toString();
    }

    @Override
    public byte[] toBytes(String content) {
        HexStringReader converter = new HexStringReader();
        return converter.read(content);
    }
}
