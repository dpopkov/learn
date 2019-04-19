package learn.javaio2e.ch11jar;

import java.io.*;
import java.util.jar.JarOutputStream;
import java.util.jar.Pack200;
import java.util.zip.GZIPInputStream;

@SuppressWarnings("removal")
public class Unpacker200 {

    private static final String PACK_EXT = ".pack";
    private static final String GZ_EXT = ".gz";
    private static final String PACK_GZ_EXT = PACK_EXT + GZ_EXT;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Unpacker200 packed-file");
            return;
        }
        String inName = args[0];
        String outName;
        if (inName.endsWith(PACK_GZ_EXT)) {
            outName = inName.substring(0, inName.length() - PACK_GZ_EXT.length());
        } else if (inName.endsWith(PACK_EXT)) {
            outName = inName.substring(0, inName.length() - PACK_EXT.length());
        } else {
            outName = inName + ".unpacked";
        }
        try (InputStream in = openInput(inName);
             JarOutputStream out = new JarOutputStream(new BufferedOutputStream(new FileOutputStream(outName)))) {
            Pack200.Unpacker unpacker = Pack200.newUnpacker();
            unpacker.unpack(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static InputStream openInput(String inName) throws IOException {
        InputStream input = new BufferedInputStream(new FileInputStream(inName));
        if (inName.endsWith(GZ_EXT)) {
            input = new GZIPInputStream(input);
        }
        return input;
    }
}
