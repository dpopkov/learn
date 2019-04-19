package learn.javaio2e.ch11jar;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.jar.JarFile;
import java.util.jar.Pack200;

/**
 * Packs an existing JAR file using Pack200.
 * The convention is that the file is suffixed with .pack
 */
public class Packer200 {
    @SuppressWarnings("removal")
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Packer200 jar-file");
            return;
        }
        String jarName = args[0];
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(jarName + ".pack"))) {
            JarFile f = new JarFile(jarName);
            Pack200.Packer packer = Pack200.newPacker();
            packer.pack(f, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
