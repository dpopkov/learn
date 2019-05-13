package learn.javaio2e.fileviewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Provides a simple user interface to allow the user to specify the format the file is in,
 * whether and how it's compressed, and the password, if any.<br>
 */
public class ModePanel extends JPanel {
    private final JCheckBox bigEndian = new JCheckBox("Big Endian", false);
    private final JCheckBox deflated = new JCheckBox("Deflated", false);
    private final JCheckBox gzipped = new JCheckBox("GZipped", false);
    private final ButtonGroup dataTypes = new ButtonGroup();
    private final JTextField password = new JPasswordField();
    private DumpMode mode = DumpMode.ASC;

    public ModePanel() {
        this.setLayout(new GridLayout(13, 1));
        this.add(bigEndian);
        bigEndian.setSelected(true);
        this.add(deflated);
        this.add(gzipped);
        makeRadio("ASCII", DumpMode.ASC, true);
        makeRadio("Decimal", DumpMode.DEC, false);
        makeRadio("Hexadecimal", DumpMode.HEX, false);
        makeRadio("Short", DumpMode.SHORT, false);
        makeRadio("Int", DumpMode.INT, false);
        makeRadio("Long", DumpMode.LONG, false);
        makeRadio("Float", DumpMode.FLOAT, false);
        makeRadio("Double", DumpMode.DOUBLE, false);
        this.add(password);
    }

    public boolean isBigEndian() {
        return bigEndian.isSelected();
    }

    public boolean isDeflated() {
        return deflated.isSelected();
    }

    public boolean isGZipped() {
        return gzipped.isSelected();
    }

    public DumpMode getMode() {
        return mode;
    }

    public String getPassword() {
        return password.getText();
    }

    private final ActionListener radioListener = e -> {
        DumpModeRadioButton radio = (DumpModeRadioButton) e.getSource();
        ModePanel.this.mode = radio.getMode();
    };

    private void makeRadio(String text, DumpMode mode, boolean select) {
        DumpModeRadioButton btn = new DumpModeRadioButton(text, mode);
        btn.setSelected(select);
        btn.addActionListener(radioListener);
        dataTypes.add(btn);
        this.add(btn);
    }

    private class DumpModeRadioButton extends JRadioButton {
        private final DumpMode mode;

        public DumpModeRadioButton(String text, DumpMode mode) {
            super(text);
            this.mode = mode;
        }

        public DumpMode getMode() {
            return mode;
        }
    }
}
