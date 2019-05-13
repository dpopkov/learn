package learn.javaio2e.fileviewer;

import learn.javaio2e.ch02out.JStreamedTextArea;

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
public class FileViewer extends JFrame implements ActionListener {
    private final JFileChooser chooser = new JFileChooser();
    private final JStreamedTextArea theView = new JStreamedTextArea();
    private final ModePanel modePanel = new ModePanel();

    public FileViewer() throws HeadlessException {
        super("File Viewer");
        init();
    }

    public void init() {
        chooser.setApproveButtonText("View File");
        chooser.setApproveButtonMnemonic('V');
        chooser.addActionListener(this);
        this.getContentPane().add(BorderLayout.CENTER, chooser);
        JScrollPane sp = new JScrollPane(theView);
        sp.setPreferredSize(new Dimension(640, 400));
        add(BorderLayout.SOUTH, sp);
        add(BorderLayout.WEST, modePanel);
        pack();
        centerOnDisplay();
    }

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
                    OutputStream out = theView.getOutputStream();
                    FileDumper5 dumper = new FileDumper5(modePanel.getMode(), modePanel.isBigEndian(),
                            modePanel.isDeflated(), modePanel.isGZipped(), modePanel.getPassword());
                    dumper.dump(fin, out);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(),
                            "I/O Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getActionCommand().equals(JFileChooser.CANCEL_SELECTION)) {
            this.setVisible(false);
            this.dispose();
        }
    }

    public static void main(String[] args) {
        FileViewer viewer = new FileViewer();
        viewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewer.setVisible(true);
    }
}
