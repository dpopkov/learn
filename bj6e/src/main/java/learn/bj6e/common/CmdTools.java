package learn.bj6e.common;

import java.io.File;
import java.util.Optional;

/**
 * Utilities for using in command line apps.
 */
public class CmdTools {
    /**
     * Gets filename as 1st command line argument or, if absent,
     * calls file dialog.
     * @param args command line arguments of {@code main} method
     * @return wrapped filename
     */
    public static Optional<String> getFileName(String[] args) {
        String filename;
        if (args.length == 1) {
            filename = args[0];
        } else {
            CmdFileChooser chooser = new CmdFileChooser();
            Optional<File> selected = chooser.select();
            if (selected.isPresent()) {
                filename = selected.get().getPath();
            } else {
                return Optional.empty();
            }
        }
        return Optional.of(filename);
    }
}
