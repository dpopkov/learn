package learn.javaio2e.ch10compress;

import java.io.*;
import java.util.zip.Deflater;

public class DirectDeflater {
    public final static String DEFLATE_SUFFIX = ".dfl";

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Usage: java DirectDeflater file1 [file2...]");
            return;
        }
        Deflater def = new Deflater();
        byte[] input = new byte[1024];
        byte[] output = new byte[1024];
        for (String fileName : args) {
            try (InputStream in = new BufferedInputStream(new FileInputStream(fileName));
                 OutputStream out = new BufferedOutputStream(new FileOutputStream(fileName + DEFLATE_SUFFIX))) {
                while (true) {
                    int numRead = in.read(input);
                    if (numRead == -1) {
                        def.finish();
                        while (!def.finished()) {
                            deflateAndWrite(def, output, out);
                        }
                        break;
                    } else {
                        def.setInput(input, 0, numRead);
                        while (!def.needsInput()) {
                            deflateAndWrite(def, output, out);
                        }
                    }
                }
                def.reset();
            }
        }
    }

    private static void deflateAndWrite(Deflater def, byte[] output, OutputStream out) throws IOException {
        int numCompressedBytes = def.deflate(output, 0, output.length);
        if (numCompressedBytes > 0) {
            out.write(output, 0, numCompressedBytes);
        }
    }
}
