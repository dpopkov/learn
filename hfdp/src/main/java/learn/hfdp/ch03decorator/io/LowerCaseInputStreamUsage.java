package learn.hfdp.ch03decorator.io;

import java.io.*;

public class LowerCaseInputStreamUsage {
    public static void main(String[] args) {
        String text = "I know the Decorator Pattern therefore I RULE!";
        InputStream in = new LowerCaseInputStream(new BufferedInputStream(new ByteArrayInputStream(text.getBytes())));
        int ch;
        try {
            while ((ch = in.read()) > 0) {
                System.out.print((char) ch);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
