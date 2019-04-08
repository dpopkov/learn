package learn.javaio2e.ch05net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Tries to send an email.
 * It requires that the local host be running an SMTP server,
 * or that the system property mail.host must contain the name of an accessible SMTP server,
 * or that a machine in the local domain named mailhost be running an SMTP server.
 */
public class MailClient {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Usage: java MailClient username@host.com");
            return;
        }
        OutputStream out = null;
        try {
            URL url = new URL("mailto:" + args[0]);
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            connection.connect();
            out = connection.getOutputStream(); // throws java.net.UnknownHostException: mailhost
            Scanner in = new Scanner(System.in);
            System.out.print("Enter line of text to send: ");
            String text = in.nextLine();
            for (byte b : text.getBytes()) {
                out.write(b);
            }
        } finally {
            if (out != null) {
                out.close();
                System.out.println("Connection closed.");
            }
        }
    }
}
