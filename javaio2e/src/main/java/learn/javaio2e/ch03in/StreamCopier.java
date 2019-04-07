package learn.javaio2e.ch03in;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Copies data between two streams.
 */
public class StreamCopier {
    public static void copy(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
    }

    public static void main(String[] args) {
        try {
            copy(System.in, System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
