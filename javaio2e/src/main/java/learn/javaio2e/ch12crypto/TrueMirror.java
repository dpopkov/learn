package learn.javaio2e.ch12crypto;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Compares the byte arrays returned by two MD5 digests, one for an original web page
 * and one for a mirror copy of the page.
 */
public class TrueMirror {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        if (args.length != 2) {
            System.err.println("Usage: java TrueMirror source-url mirror-url");
            return;
        }
        URL source = new URL(args[0]);
        URL mirror = new URL(args[1]);
        byte[] sourceDigest = getDigestFrom(source);
        byte[] mirrorDigest = getDigestFrom(mirror);
        String resultMsg = MessageDigest.isEqual(sourceDigest, mirrorDigest)
                ? " is up to date"
                : " needs to be updated";
        System.out.println(mirror + resultMsg);
    }

    private static byte[] getDigestFrom(URL url) throws NoSuchAlgorithmException, IOException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] data = new byte[128];
        try (InputStream in = url.openStream()) {
            int bytesRead;
            while ((bytesRead = in.read(data)) > 0) {
                md5.update(data, 0, bytesRead);
            }
        }
        return md5.digest();
    }
}
