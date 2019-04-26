package learn.javaio2e.ch14buffers;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Copies a file using java.nio.
 */
public class NioCopier {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: java NioCopier original copy");
            return;
        }
        try (FileInputStream in = new FileInputStream(args[0]);
             FileOutputStream out = new FileOutputStream(args[1]);
             FileChannel inChannel = in.getChannel();
             FileChannel outChannel = out.getChannel()) {
            for (ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);
                 inChannel.read(buffer) != -1;
                 buffer.clear()) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    outChannel.write(buffer);
                }
            }

        }
    }
}
