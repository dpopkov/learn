package learn.ijpds.ch20collections.exercises.e2002;

import javax.swing.*;
import java.awt.*;

public class E2002Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }

    private static class MainFrame extends JFrame {
        private final NumberStore numberStore = new NumberStore();
        private final JTextArea displayArea = new JTextArea();

        MainFrame() {
            super("Store Numbers");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(380, 180);
            createComponents();
        }

        private void createComponents() {
            add(createTopPanel(), BorderLayout.NORTH);
            add(new JScrollPane(displayArea), BorderLayout.CENTER);
            add(createBottomPanel(), BorderLayout.SOUTH);
        }

        private JPanel createTopPanel() {
            JPanel topPanel = new JPanel();
            topPanel.add(new JLabel("Enter a number:"));
            final JTextField textField = new JTextField(20);
            textField.addActionListener(e -> {
                numberStore.add(Integer.parseInt(textField.getText().trim()));
                textField.setText("");
                displayNumbers();
            });
            topPanel.add(textField);
            return topPanel;
        }

        private JPanel createBottomPanel() {
            JPanel bottomPanel = new JPanel();
            JButton btnSort = new JButton("Sort");
            btnSort.addActionListener(e -> {
                numberStore.sort();
                displayNumbers();
            });
            bottomPanel.add(btnSort);
            JButton btnShuffle = new JButton("Shuffle");
            btnShuffle.addActionListener(e -> {
                numberStore.shuffle();
                displayNumbers();
            });
            bottomPanel.add(btnShuffle);
            JButton btnReverse = new JButton("Reverse");
            btnReverse.addActionListener(e -> {
                numberStore.reverse();
                displayNumbers();
            });
            bottomPanel.add(btnReverse);
            return bottomPanel;
        }

        private void displayNumbers() {
            displayArea.setText(numberStore.toString());
        }
    }
}
