package learn.ijpds.ch12exceptions.io;

import learn.csia.utils.CliAppArgs;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ReadFileFromUrl {
    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter a URL");
        String urlString = in.nextString();

        try {
            URL url = new URL(urlString);
            int count = 0;
            Scanner input = new Scanner(url.openStream());
            while (input.hasNext()) {
                String line = input.nextLine();
                System.out.println(line);
                count += line.length();
            }
            System.out.println("The file size is " + count + " characters");
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL: " + urlString);
        } catch (IOException e) {
            System.out.println("I/O Errors: no such file.");
        }
    }
}
