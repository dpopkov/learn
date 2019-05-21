package learn.javaio2e.fileviewer;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Improved {@link ModePanel} that contains a list box of text encodings.
 */
public class TextModePanel extends JPanel {
    private final ModePanel modePanel = new ModePanel();
    private final JList<String> encodings = new JList<>();

    public TextModePanel() {
        Map<String, Charset> charsets = Charset.availableCharsets();
        encodings.setListData(charsets.keySet().toArray(new String[0]));
        this.setLayout(new GridLayout(1, 2));
        JScrollPane scrollPane = new JScrollPane(encodings);
        this.add(modePanel);
        this.add(scrollPane);
    }

    public boolean isBigEndian() {
        return modePanel.isBigEndian();
    }

    public boolean isDeflated() {
        return modePanel.isDeflated();
    }

    public boolean isGZipped() {
        return modePanel.isGZipped();
    }

    public boolean isText() {
        return modePanel.getMode() == DumpMode.ASC;
    }

    public String getEncoding() {
        return encodings.getSelectedValue();
    }

    public DumpMode getMode() {
        return modePanel.getMode();
    }

    public String getPassword() {
        return modePanel.getPassword();
    }
}
