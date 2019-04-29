package learn.javaio2e.ch14buffers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Demonstrates usage of the {@code compact()} method.
 */
public class NioDuplicator {
    public static void main(String[] args) throws IOException {
        try (FileInputStream inFile = new FileInputStream(args[0]);
             FileOutputStream outFile = new FileOutputStream(args[1]);
             FileChannel inChannel = inFile.getChannel();
             FileChannel outChannel = outFile.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);
            int bytesRead = 0;
            while (bytesRead >= 0 || buffer.hasRemaining()) {
                if (bytesRead != -1) {
                    bytesRead = inChannel.read(buffer);
                }
                buffer.flip();
                outChannel.write(buffer);
                buffer.compact();
            }
        }
    }
}
