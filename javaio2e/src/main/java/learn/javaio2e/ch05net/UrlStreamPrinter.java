package learn.javaio2e.ch05net;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Demonstrates how to connect to a URL entered on the command line, download its data, and copy that to System.out.
 */
public class UrlStreamPrinter {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java UrlStreamPrinter url");
            return;
        }
        InputStream in = null;
        try {
            URL url = new URL(args[0]);
            in = url.openStream();
            int c;
            while ((c = in.read()) != -1) {
                System.out.write(c);
            }
        } catch (MalformedURLException e) {
            System.err.println(args[0] + " is not a URL Java understands.");
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
