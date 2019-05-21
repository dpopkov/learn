package learn.javaio2e.fileviewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Graphical file viewer application.
 * It gets the filename from a file chooser and displays the file's content in a text area.
 * <br>
 * <strong>Important</strong>: The I/O dumping is not using it's own thread yet.
 */
public class FileViewer2 extends JFrame implements ActionListener {
    private final JFileChooser chooser = new JFileChooser();
    private final JWritableTextArea theView = new JWritableTextArea();
    private final TextModePanel modePanel = new TextModePanel();

    public FileViewer2() throws HeadlessException {
        super("File Viewer");
        init();
    }

    public void init() {
        chooser.setApproveButtonText("View File");
        chooser.setApproveButtonMnemonic('V');
        chooser.addActionListener(this);
        chooser.setCurrentDirectory(new File("."));
        add(BorderLayout.CENTER, chooser);
        JScrollPane sp = new JScrollPane(theView);
        sp.setPreferredSize(new Dimension(640, 400));
        add(BorderLayout.SOUTH, sp);
        add(BorderLayout.WEST, modePanel);
        pack();
        centerOnDisplay();
    }

    @SuppressWarnings("Duplicates")
    private void centerOnDisplay() {
        Dimension display = getToolkit().getScreenSize();
        Dimension bounds = this.getSize();
        int x = (display.width - bounds.width) / 2;
        int y = (display.height - bounds.height) / 2;
        x = x < 0 ? 10 : x;
        y = y < 0 ? 15 : y;
        setLocation(x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
            File file = chooser.getSelectedFile();
            if (file != null) {
                theView.reset();
                try (InputStream in = new BufferedInputStream(new FileInputStream(file))) {
                    FilterInputStream fin = new ProgressMonitorInputStream(this, "Reading...", in);
                    Writer out = theView.getWriter();
                    FileDumper6 dumper = new FileDumper6(modePanel.getMode(), modePanel.isBigEndian(),
                            modePanel.isDeflated(), modePanel.isGZipped(), modePanel.getPassword());
                    if (modePanel.isText()) {
                        dumper.dump(fin, out, modePanel.getEncoding());
                    } else {
                        dumper.dump(fin, out);
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(),
                            "I/O Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getActionCommand().equals(JFileChooser.CANCEL_SELECTION)) {
            this.setVisible(false);
            this.dispose();
            System.exit(0); // This is a single window application
        }
    }

    public static void main(String[] args) {
        FileViewer2 viewer = new FileViewer2();
        viewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewer.setVisible(true);
    }
}
