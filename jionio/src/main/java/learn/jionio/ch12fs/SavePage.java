package learn.jionio.ch12fs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SavePage {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("usage: java SavePage url");
            return;
        }
        URL url = new URL(args[0]);
        System.out.println("Opening " + url);
        InputStreamReader isr = new InputStreamReader(url.openStream());
        BufferedReader br = new BufferedReader(isr);
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            lines.add(line);
        }
        Files.write(Paths.get("page.html"), lines);
    }
}
