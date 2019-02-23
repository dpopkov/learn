package learn.core2.ch04netw.interruptible;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class InterruptibleSocketFrame extends JFrame {
    private static final int TEXT_ROWS = 20;
    private static final int TEXT_COLUMNS = 60;

    private final JButton interruptibleBtn = new JButton("Interruptible");
    private final JButton blockingBtn = new JButton("Blocking");
    private final JButton cancelBtn = new JButton("Cancel");
    private final JButton clearBtn = new JButton("Clear");
    private final JTextArea messages = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
    private Scanner in;
    private Thread connectThread;

    public InterruptibleSocketFrame() {
        setTitle(getClass().getSimpleName());
        addComponents();
        addListeners();
        DemoServer server = new DemoServer(this::printLn);
        new Thread(server).start();
        pack();
    }

    private void addComponents() {
        JPanel northPanel = new JPanel();
        add(northPanel, BorderLayout.NORTH);
        northPanel.add(interruptibleBtn);
        northPanel.add(blockingBtn);
        northPanel.add(cancelBtn);
        northPanel.add(clearBtn);
        add(new JScrollPane(messages));
    }

    private void addListeners() {
        interruptibleBtn.addActionListener(event -> {
            interruptibleBtn.setEnabled(false);
            blockingBtn.setEnabled(false);
            cancelBtn.setEnabled(true);
            connectThread = new Thread(() -> {
                try {
                    connectInterruptibly();
                } catch (IOException e) {
                    printLn("InterruptibleSocketFrame.connectInterruptibly: " + e);
                }
            });
            connectThread.start();
        });
        blockingBtn.addActionListener(event -> {
            interruptibleBtn.setEnabled(false);
            blockingBtn.setEnabled(false);
            cancelBtn.setEnabled(true);
            connectThread = new Thread(() -> {
                try {
                    connectBlocking();
                } catch (IOException e) {
                    printLn("InterruptibleSocketFrame.connectBlocking: " + e);
                }
            });
            connectThread.start();
        });
        cancelBtn.setEnabled(false);
        cancelBtn.addActionListener(event -> {
            connectThread.interrupt();
            cancelBtn.setEnabled(false);
        });
        clearBtn.addActionListener(event -> messages.setText(""));
    }

    /**
     * Connects to the server using interruptible I/O.
     * @throws IOException if I/O error occurs
     */
    private void connectInterruptibly() throws IOException {
        printLn("Interruptible:");
        try (SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost", 8189))) {
            in = new Scanner(channel, StandardCharsets.UTF_8);
            while (!Thread.currentThread().isInterrupted()) {
                print("Reading interruptible ");
                if (in.hasNextLine()) {
                    String line = in.nextLine();
                    printLn(line);
                }
            }
        } finally {
            EventQueue.invokeLater(() -> {
                printLn("Channel closed");
                interruptibleBtn.setEnabled(true);
                blockingBtn.setEnabled(true);
            });
        }
    }

    private void connectBlocking() throws IOException {
        printLn("Blocking:");
        try (Socket socket = new Socket("localhost", 8189)) {
            in = new Scanner(socket.getInputStream(), StandardCharsets.UTF_8);
            while (!Thread.currentThread().isInterrupted()) {
                print("Reading blocking ");
                if (in.hasNextLine()) {
                    String line = in.nextLine();
                    printLn(line);
                }
            }
        } finally {
            EventQueue.invokeLater(() -> {
                printLn("Socket closed");
                interruptibleBtn.setEnabled(true);
                blockingBtn.setEnabled(true);
            });
        }
    }

    private void printLn(String s) {
        messages.append(s + System.lineSeparator());
    }

    private void print(String s) {
        messages.append(s);
    }
}
