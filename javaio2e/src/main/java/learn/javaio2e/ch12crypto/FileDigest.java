package learn.javaio2e.ch12crypto;

import java.io.*;
import java.net.URL;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Reads data from a specified url and copies it into a file on the local system.
 */
public class FileDigest {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        if (args.length != 2) {
            System.err.println("Usage: java FileDigest url filename");
            return;
        }
        URL url = new URL(args[0]);
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(args[1]))) {
            String digest = copyFileWithDigest(url, out);
            System.out.println("digest = " + digest);
        }
    }

    private static String copyFileWithDigest(URL u, OutputStream out) throws IOException, NoSuchAlgorithmException {
        MessageDigest sha = MessageDigest.getInstance("SHA-512");
        DigestOutputStream digestOut = new DigestOutputStream(out, sha);
        byte[] data = new byte[128];
        try (InputStream in = u.openStream()) {
            while (true) {
                int bytesRead = in.read(data);
                if (bytesRead < 0) {
                    break;
                }
                digestOut.write(data, 0, bytesRead);
            }
            digestOut.flush();
            byte[] result = digestOut.getMessageDigest().digest();
            StringBuilder builder = new StringBuilder();
            for (byte b : result) {
                builder.append(b);
                builder.append(" ");
            }
            return builder.toString();
        }
    }
}
