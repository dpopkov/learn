package learn.bj6e.common;

import javax.swing.*;
import java.io.File;
import java.util.Optional;

/**
 * Wrapper around {@code JFileChooser} that can be used in command line interface apps.
 */
public class CmdFileChooser {
    private final JFileChooser chooser;

    /**
     * Constructs chooser initialized with the current working directory.
     */
    public CmdFileChooser() {
        this(".");
    }

    /**
     * Constructs chooser using the specified starting directory.
     * @param startingDirectory path to a starting directory
     */
    public CmdFileChooser(String startingDirectory) {
        this.chooser = new JFileChooser(startingDirectory);
    }

    /**
     * Shows open dialog and lets choose a file.
     * @return wrapped selected file or empty wrapper
     */
    public Optional<File> select() {
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return Optional.of(chooser.getSelectedFile());
        }
        return Optional.empty();
    }
}
