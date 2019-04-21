package learn.javaio2e.ch12crypto;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.*;

/**
 * Reads a filename and a password and encrypts the file with DES.
 */
public class FileEncryptor {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java FileEncryptor filename password");
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
             OutputStream out = new BufferedOutputStream(new FileOutputStream(outName))) {
            byte[] desKeyData = password.getBytes();
            DESKeySpec desKeySpec = new DESKeySpec(desKeyData);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey desKey = keyFactory.generateSecret(desKeySpec);
            Cipher des = Cipher.getInstance("DES/CBC/PKCS5Padding");
            des.init(Cipher.ENCRYPT_MODE, desKey);
            byte[] iv = des.getIV();
            DataOutputStream dataOut = new DataOutputStream(out);
            dataOut.writeInt(iv.length);
            dataOut.write(iv);
            byte[] input = new byte[64];
            while (true) {
                int bytesRead = in.read(input);
                if (bytesRead == -1) {
                    break;
                }
                byte[] output = des.update(input, 0, bytesRead);
                if (output != null) {
                    dataOut.write(output);
                }
            }
            byte[] output = des.doFinal();
            if (output != null) {
                dataOut.write(output);
            }
            dataOut.flush();
            dataOut.close();
            System.out.println(filename + " encrypted and saved to " + outName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
