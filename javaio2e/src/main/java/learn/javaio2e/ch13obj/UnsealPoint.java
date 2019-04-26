package learn.javaio2e.ch13obj;

import javax.crypto.SealedObject;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.awt.*;
import java.io.*;
import java.security.GeneralSecurityException;

/**
 * Reads the sealed object from the point.des written by {@link SealedPoint} and unseals the object.
 */
public class UnsealPoint {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException, GeneralSecurityException, ClassNotFoundException {
        try (InputStream in = new BufferedInputStream(new FileInputStream(SealedPoint.FILE_PATH));
             ObjectInputStream oin = new ObjectInputStream(in)) {
            byte[] desKeyData = {(byte) 0x90, (byte) 0x67, (byte) 0x3E, (byte) 0xE6,
                    (byte) 0x42, (byte) 0x15, (byte) 0x7A, (byte) 0xA3};
            DESKeySpec desKeySpec = new DESKeySpec(desKeyData);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey desKey = keyFactory.generateSecret(desKeySpec);
            SealedObject sealed = (SealedObject) oin.readObject();
            Point p = (Point) sealed.getObject(desKey);
            System.out.println("p = " + p);
        }
    }
}
