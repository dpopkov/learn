package learn.javaio2e.ch19charsets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

/**
 * Converts encodings. It reads a stream in one encoding and writes it out in another encoding.
 */
public class Converter {
    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
            return;
        }
        try {
            Charset inputEncoding = Charset.forName(args[0]);
            Charset outputEncoding = Charset.forName(args[1]);
            convert(inputEncoding, outputEncoding, System.in, System.out);
        } catch (UnsupportedCharsetException ex) {
            System.err.println(ex.getCharsetName() + " is not supported by this VM.");
        } catch (IllegalCharsetNameException ex) {
            System.err.println(ex.getMessage());
            printUsage();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("SameParameterValue")
    private static void convert(Charset inputEncoding, Charset outputEncoding,
                                InputStream inputStream, PrintStream outStream) throws IOException {
        ReadableByteChannel in = Channels.newChannel(inputStream);
        WritableByteChannel out = Channels.newChannel(outStream);
        ByteBuffer inBuffer = ByteBuffer.allocate(4096);
        while (in.read(inBuffer) != -1) {
            inBuffer.flip();
            CharBuffer charBuffer = inputEncoding.decode(inBuffer);
            ByteBuffer outBuffer = outputEncoding.encode(charBuffer);
            while (outBuffer.hasRemaining()) {
                out.write(outBuffer);
            }
            inBuffer.clear();
        }
    }

    private static void printUsage() {
        System.err.println("Usage: java " + Converter.class.getName()
                + " inputEncoding outputEncoding <inFile >outFile");
    }
}
