package learn.javaio2e.ch10compress;

import java.io.*;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/**
 * Inflates files named on the command line.
 */
public class DirectInflater {
    private final static String SUFFIX = DirectDeflater.DEFLATE_SUFFIX;

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java DirectInflater file1 [file2...]");
            return;
        }
        Inflater inf = new Inflater();
        byte[] input = new byte[1024];
        byte[] output = new byte[1024];
        for (String fileName : args) {
            if (!fileName.endsWith(SUFFIX)) {
                System.err.println(fileName + " does not look like a deflated file");
                continue;
            }
            String inflatedName = fileName.substring(0, fileName.length() - SUFFIX.length()) + ".inf";
            try (InputStream in = new BufferedInputStream(new FileInputStream(fileName));
                 OutputStream out = new BufferedOutputStream(new FileOutputStream(inflatedName))) {
                while (true) {  // Read and inflate the data
                    int numRead = in.read(input);
                    if (numRead != -1) {
                        inf.setInput(input, 0, numRead);
                    }
                    int numDecompressed;
                    while ((numDecompressed = inf.inflate(output, 0, output.length)) != 0) {
                        out.write(output, 0, numDecompressed);
                    }
                    if (inf.finished()) {   // all done
                        break;
                    } else if (inf.needsDictionary()) { // We don't handle dictionaries
                        System.err.println("Dictionary require! bailing...");
                        break;
                    } else if (inf.needsInput()) {
                        //noinspection UnnecessaryContinue
                        continue;
                    }
                }
                System.out.println("Inflated and saved to " + inflatedName);
                inf.reset();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (DataFormatException e) {
                System.err.println(fileName + " appears to be corrupt");
                e.printStackTrace();
            }
        }
    }
}
