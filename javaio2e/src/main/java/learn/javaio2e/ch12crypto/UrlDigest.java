package learn.javaio2e.ch12crypto;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Uses the {@link MessageDigest} to calculate the SHA-1 hash for a web page named on the command line.
 */
public class UrlDigest {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        if (args.length != 1) {
            System.err.println("Usage: java UrlDigest url");
            return;
        }
        URL url = new URL(args[0]);
        MessageDigest sha = MessageDigest.getInstance("SHA");
        byte[] data = new byte[128];
        try (InputStream in = url.openStream()) {
            while (true) {
                int bytesRead = in.read(data);
                if (bytesRead < 0) {
                    break;
                }
                sha.update(data, 0, bytesRead);
            }
        }
        byte[] result = sha.digest();
        for (byte b : result) {
            System.out.print(b + " ");
        }
        System.out.println();
        System.out.println(new BigInteger(result));
    }
}
