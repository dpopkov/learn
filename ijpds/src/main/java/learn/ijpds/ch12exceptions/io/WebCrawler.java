package learn.ijpds.ch12exceptions.io;

import learn.csia.utils.CliAppArgs;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class WebCrawler {
    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter a starting URL");
        String url = in.nextString();
        crawler(url);
    }

    private static void crawler(String startingUrl) {
        Deque<String> pending = new LinkedList<>();
        List<String> traversed = new ArrayList<>();

        pending.add(startingUrl);
        while (!pending.isEmpty() && traversed.size() <= 100) {
            String url = pending.removeFirst();
            if (!traversed.contains(url)) {
                traversed.add(url);
                System.out.println("Crawl " + url);
                for (String s : getSubUrls(url)) {
                    if (!traversed.contains(s)) {
                        pending.add(s);
                    }
                }
            }
        }
    }

    private static List<String> getSubUrls(String urlString) {
        List<String> list = new ArrayList<>();
        try {
            URL url = new URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int current = 0;
            while (input.hasNext()) {
                String line = input.nextLine();
                current = line.indexOf("http:", current);
                while (current > 0) {
                    int endIndex = line.indexOf("\"", current);
                    if (endIndex > 0) {
                        list.add(line.substring(current, endIndex));
                        current = line.indexOf("http:", endIndex);
                    } else {
                        current = -1;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return list;
    }
}
