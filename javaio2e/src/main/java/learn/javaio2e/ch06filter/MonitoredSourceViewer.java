package learn.javaio2e.ch06filter;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Reads data from a URL given on the command line and copies it to System.out.
 * It uses a ProgressMonitor to keep the user alerted as to its progress.
 * It uses the content-length HTTP header to determine how much data will be sent
 * in order to set the maximum value for the progress bar.
 */
public class MonitoredSourceViewer {
    public static void main(String[] args) {
        if (args.length <= 0) {
            System.err.println("Usage: java MonitoredSourceViewer url");
            return;
        }
        try {
            URL url = new URL(args[0]);
            URLConnection connection = url.openConnection();
            InputStream in = connection.getInputStream();
            ProgressMonitorInputStream monitorInput = new ProgressMonitorInputStream(null, url.toString(), in);
            monitorInput.getProgressMonitor().setMaximum(connection.getContentLength());
            int ch;
            while ((ch = monitorInput.read()) != -1) {
                System.out.print((char) ch);
            }
            monitorInput.close();
        } catch (MalformedURLException e) {
            System.err.println(args[0] + " is not a parsable URL");
        } catch (InterruptedIOException e) {
            System.out.println("User cancelled.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0); // since we brought up a GUI, we have to explicitly exit here
    }
}
