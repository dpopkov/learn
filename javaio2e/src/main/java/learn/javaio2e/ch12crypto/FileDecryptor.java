package learn.javaio2e.ch12crypto;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;

public class FileDecryptor {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: java FileDecryptor infile outfile password");
            return;
        }
        String infile = args[0];
        String outfile = args[1];
        String password = args[2];
        if (password.length() < 8) {
            System.err.println("Password must be at least eight characters long");
            return;
        }
        try (InputStream in = new BufferedInputStream(new FileInputStream(infile));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(outfile))) {
            byte[] desKeyData = password.getBytes();
            DESKeySpec desKeySpec = new DESKeySpec(desKeyData);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey desKey = keyFactory.generateSecret(desKeySpec);
            DataInputStream din = new DataInputStream(in);
            int ivSize = din.readInt();
            byte[] iv = new byte[ivSize];
            din.readFully(iv);
            IvParameterSpec ivPs = new IvParameterSpec(iv);
            Cipher des = Cipher.getInstance("DES/CBC/PKCS5Padding");
            des.init(Cipher.DECRYPT_MODE, desKey, ivPs);
            byte[] input = new byte[64];
            while (true) {
                int bytesRead = in.read(input);
                if (bytesRead == -1) {
                    break;
                }
                byte[] output = des.update(input, 0, bytesRead);
                if (output != null) {
                    out.write(output);
                }
            }
            byte[] output = des.doFinal();
            if (output != null) {
                out.write(output);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
