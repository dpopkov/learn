package learn.jionio.ch12fs;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class WatchServiceDemo {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java WatchServiceDemo directory");
            return;
        }
        FileSystem fsDefault = FileSystems.getDefault();
        WatchService watchService = fsDefault.newWatchService();
        Path dir = fsDefault.getPath(args[0]);
        System.out.println("Watching directory " + dir.toAbsolutePath().normalize());
        dir.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
        for (;;) {
            WatchKey key;
            try {
                key = watchService.take();
            } catch (InterruptedException e) {
                return;
            }
            for (WatchEvent event : key.pollEvents()) {
                WatchEvent.Kind kind = event.kind();
                if (kind == OVERFLOW) {
                    System.out.println("overflow");
                    continue;
                }
                Path filename = (Path) event.context();
                System.out.printf("%s: %s%n", event.kind(), filename);
            }
            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
    }
}
