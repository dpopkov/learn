package learn.javaio2e.ch12crypto;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.*;
import java.security.DigestInputStream;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class DigestDecryptor {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println("Usage: java DigestDecryptor infile outfile password");
            return;
        }
        String infile = args[0];
        String outfile = args[1];
        String password = args[2];
        if (password.length() < 8) {
            System.err.println("Password must be at least eight characters long");
            return;
        }
        byte[] desKeyData = password.getBytes();
        Cipher des = prepareCipher(desKeyData);
        try (InputStream in = new BufferedInputStream(new FileInputStream(infile));
             DataInputStream dataIn = new DataInputStream(
                     new BufferedInputStream(new FileInputStream(infile + ".digest")));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(outfile));
             CipherOutputStream cipherOut = new CipherOutputStream(out, des)) {
            byte[] oldDigest = new byte[20];
            dataIn.readFully(oldDigest);
            dataIn.close();
            MessageDigest sha = MessageDigest.getInstance("SHA");
            DigestInputStream digestIn = new DigestInputStream(in, sha);
            byte[] input = new byte[64];
            while (true) {
                int bytesRead = digestIn.read(input);
                if (bytesRead == -1) {
                    break;
                }
                cipherOut.write(input, 0, bytesRead);
            }
            byte[] newDigest = sha.digest();
            if (!MessageDigest.isEqual(newDigest, oldDigest)) {
                System.out.println("Input file appears to be corrupt!");
            }
        }
    }

    private static Cipher prepareCipher(byte[] desKeyData) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException {
        DESKeySpec desKeySpec = new DESKeySpec(desKeyData);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey desKey = keyFactory.generateSecret(desKeySpec);
        Cipher des = Cipher.getInstance("DES/ECB/PKCS5Padding");
        des.init(Cipher.DECRYPT_MODE, desKey);
        return des;
    }
}
