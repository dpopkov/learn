package learn.javaio2e.ch13obj;

import javax.crypto.Cipher;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.awt.*;
import java.io.*;
import java.security.GeneralSecurityException;

/**
 * Demonstration of {@link SealedObject} usage.
 * Writes an encrypted {@code java.awt.Point} object into the file point.des.
 */
public class SealedPoint {
    public static final String FILE_PATH = "files.io/point.des";

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException, GeneralSecurityException {
        Point tdp = new Point(32, 45);
        try (ObjectOutputStream objOut = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(FILE_PATH)))) {
            byte[] desKeyData = {(byte) 0x90, (byte) 0x67, (byte) 0x3E, (byte) 0xE6,
                                (byte) 0x42, (byte) 0x15, (byte) 0x7A, (byte) 0xA3};
            DESKeySpec desKeySpec = new DESKeySpec(desKeyData);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey desKey = keyFactory.generateSecret(desKeySpec);
            Cipher des = Cipher.getInstance("DES/ECB/PKCS5Padding");
            des.init(Cipher.ENCRYPT_MODE, desKey);
            SealedObject sealed = new SealedObject(tdp, des);
            objOut.writeObject(sealed);
        }
    }
}
