package learn.core2.ch10sec.loaders;

import learn.core2.common.GBC;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Method;

public class ClassLoaderFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private final JTextField keyField = new JTextField("3", 4);
    private final JTextField nameField = new JTextField("DummyFoo", 30);
    private final JCheckBox useDecryptionCheck = new JCheckBox();

    public ClassLoaderFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLayout(new GridBagLayout());
        add(new JLabel("Class"), new GBC(0, 0).setAnchor(GBC.EAST));
        add(nameField, new GBC(1, 0).setWeight(100, 0).setAnchor(GBC.WEST));
        add(new JLabel("Key"), new GBC(0, 1).setAnchor(GBC.EAST));
        add(keyField, new GBC(1, 1).setWeight(100, 0).setAnchor(GBC.WEST));
        add(new JLabel("Use decryption"), new GBC(0, 2).setAnchor(GBC.EAST));
        add(useDecryptionCheck, new GBC(1, 2).setWeight(100, 0).setAnchor(GBC.WEST));
        JButton loadButton = new JButton("Load");
        add(loadButton, new GBC(0, 3, 2, 1));
        loadButton.addActionListener(event -> runClass(nameField.getText(), useDecryptionCheck.isSelected(), keyField.getText()));
        pack();
    }

    /**
     * Runs the main method of a given class.
     *
     * @param name the class name
     * @param useDecryption flag whether to use decryption
     * @param key  the decryption key for the class files
     */
    public void runClass(String name, boolean useDecryption, String key) {
        try {
            ClassLoader loader;
            if (useDecryption) {
                loader = new CryptoClassLoader(Integer.parseInt(key));
            } else {
                loader = new SimpleClassLoader();
            }
            Class<?> c = loader.loadClass(name);
            Method m = c.getMethod("main", String[].class);
            m.invoke(null, (Object) new String[]{});
        } catch (Throwable t) {
            JOptionPane.showMessageDialog(this, t);
        }
    }

}
