package learn.javaio2e.ch12crypto;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.*;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/**
 * Combines encryption with a digest. Uses {@code CipherInputStream} to DES-encrypt a file.
 * The cipher-text is also digested and the digest saved so corruption can be detected.
 */
public class DigestEncryptor {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java DigestEncryptor filename password");
            return;
        }
        String filename = args[0];
        String password = args[1];
        if (password.length() < 8) {
            System.err.println("Password must be at least eight characters long");
            return;
        }
        String outName = filename + ".des";
        try (InputStream in = new BufferedInputStream(new FileInputStream(filename));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(outName));
             OutputStream digestOut = new BufferedOutputStream(new FileOutputStream(outName + ".digest"))) {
            byte[] desKeyData = password.getBytes();
            DESKeySpec desKeySpec = new DESKeySpec(desKeyData);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey desKey = keyFactory.generateSecret(desKeySpec);
            Cipher des = Cipher.getInstance("DES/ECB/PKCS5Padding");
            des.init(Cipher.ENCRYPT_MODE, desKey);
            CipherInputStream cipherIn = new CipherInputStream(in, des);
            MessageDigest sha = MessageDigest.getInstance("SHA");
            DigestInputStream digestIn = new DigestInputStream(cipherIn, sha);
            byte[] input = new byte[64];
            while (true) {
                int bytesRead = digestIn.read(input);
                if (bytesRead == -1) {
                    break;
                }
                out.write(input, 0, bytesRead);
            }
            digestOut.write(sha.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
