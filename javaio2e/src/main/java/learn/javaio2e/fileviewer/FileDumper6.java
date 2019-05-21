package learn.javaio2e.fileviewer;

import learn.javaio2e.fileviewer.filters.*;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.*;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

/**
 * Reads a series of filenames from the command line.
 * The file's data is read and printed on System.out. A command line switch determines how the data is printed.<br>
 * -a   text format (Latin-1)<br>
 * -d   decimal dump<br>
 * -h   hex dump<br>
 * -s   short dump<br>
 * -i   integer dump<br>
 * -l   long dump<br>
 * -f   float dump<br>
 * -x   double dump<br>
 * -little   little endian<br>
 * -gzip     gzipped files<br>
 * -deflated deflated files<br>
 * -password password<br>
 */
public class FileDumper6 {
    private final DumpMode mode;
    private final boolean bigEndian;
    private final boolean deflated;
    private final boolean gzipped;
    private byte[] desKeyData;

    public FileDumper6(DumpMode mode, boolean bigEndian, boolean deflated, boolean gzipped, String password) {
        this.mode = mode;
        this.bigEndian = bigEndian;
        this.deflated = deflated;
        this.gzipped = gzipped;
        if (password != null && password.length() > 0) {
            desKeyData = password.getBytes();
        }
    }

    @SuppressWarnings("Duplicates")
    public void dump(InputStream in, Writer out) throws IOException {
        if (desKeyData != null) {
            try {
                Cipher des = prepareDecryptingDesCipher(desKeyData);
                in = new CipherInputStream(in, des);
            } catch (GeneralSecurityException e) {
                throw new IOException(e.getMessage(), e);
            }
        }
        if (deflated) {
            in = new InflaterInputStream(in);
        } else if (gzipped) {
            in = new GZIPInputStream(in);
        }
        if (bigEndian) {
            //noinspection StatementWithEmptyBody
            if (mode == DumpMode.ASC) {
                // no filtering
            } else if (mode == DumpMode.HEX) {
                in = new HexFilter(in);
            } else if (mode == DumpMode.DEC) {
                in = new DecimalFilter(in);
            } else if (mode == DumpMode.SHORT) {
                in = new ShortFilter(new DataInputStream(in));
            } else if (mode == DumpMode.INT) {
                in = new IntFilter(new DataInputStream(in));
            } else if (mode == DumpMode.LONG) {
                in = new LongFilter(new DataInputStream(in));
            } else {
                throw new UnsupportedOperationException("This mode is not implemented yet: " + mode);
            }
        } else {
            throw new UnsupportedOperationException("Little Endian is not implemented yet");
        }
        for (int c = in.read(); c != -1; c = in.read()) {
            out.write(c);
        }
        out.flush();
    }

    @SuppressWarnings("Duplicates")
    public void dump(InputStream in, Writer out, String inputEncoding) throws IOException {
        if (inputEncoding == null || inputEncoding.isEmpty()) {
            inputEncoding = "US-ASCII";
        }
        if (desKeyData != null) {
            try {
                Cipher des = prepareDecryptingDesCipher(desKeyData);
                in = new CipherInputStream(in, des);
            } catch (GeneralSecurityException e) {
                throw new IOException(e.getMessage(), e);
            }
        }
        if (deflated) {
            in = new InflaterInputStream(in);
        } else if (gzipped) {
            in = new GZIPInputStream(in);
        }
        InputStreamReader isr = new InputStreamReader(in, inputEncoding);
        int c;
        while ((c = isr.read()) != -1) {
            out.write(c);
        }
        out.flush();
    }

    @SuppressWarnings("Duplicates")
    private static Cipher prepareDecryptingDesCipher(byte[] desKeyData) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException {
        DESKeySpec desKeySpec = new DESKeySpec(desKeyData);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey desKey = keyFactory.generateSecret(desKeySpec);
        Cipher des = Cipher.getInstance("DES/ECB/PKCS5Padding");
        des.init(Cipher.DECRYPT_MODE, desKey);
        return des;
    }
}
