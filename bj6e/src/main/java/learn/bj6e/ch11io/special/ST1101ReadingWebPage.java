package learn.bj6e.ch11io.special;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class ST1101ReadingWebPage {
    public static void main(String[] args) throws IOException {
        String address;
        if (args.length == 1) {
            address = args[0];
        } else {
            address = "http://horstmann.com/index.html";
        }
        URL url = new URL(address);
        Scanner in = new Scanner(url.openStream());
        while (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println(line);
        }
    }
}
