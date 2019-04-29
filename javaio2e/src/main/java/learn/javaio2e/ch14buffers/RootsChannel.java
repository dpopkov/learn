package learn.javaio2e.ch14buffers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.channels.FileChannel;

/**
 * Writes doubles to a file using a view buffer.
 */
public class RootsChannel {
    private static final int LENGTH = 1001;

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java RootsChannel filename");
            return;
        }
        ByteBuffer data = ByteBuffer.allocate(Double.BYTES * LENGTH);
        DoubleBuffer roots = data.asDoubleBuffer();
        while (roots.hasRemaining()) {
            roots.put(Math.sqrt(roots.position()));
        }
        try (FileOutputStream fileOut = new FileOutputStream(args[0]);
             FileChannel outChannel = fileOut.getChannel()) {
            outChannel.write(data);
        }
    }
}
