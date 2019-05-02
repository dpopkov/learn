package learn.javaio2e.ch15channels;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.zip.GZIPInputStream;

/**
 * Shows how to decompress a gzipped file by first decompressing it with a GZipInputStream,
 * then converting this input stream info a ReadableByteChannel.
 */
public class NioUnzipper {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java NioUnzipper filename");
            return;
        }
        try (FileInputStream fin = new FileInputStream(args[0]);
             GZIPInputStream gzipIn = new GZIPInputStream(fin);
             ReadableByteChannel in = Channels.newChannel(gzipIn)) {
            WritableByteChannel out = Channels.newChannel(System.out);
            ByteBuffer buffer = ByteBuffer.allocate(65536);
            while (in.read(buffer) != -1) {
                buffer.flip();
                out.write(buffer);
                buffer.clear();
            }
        }
    }
}
