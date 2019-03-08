package learn.ijpds.ch33netw.distributed;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TicTacToeServer extends Application implements TicTacToeConstants {
    public static final int PORT = 8000;

    private final TextArea taLog = new TextArea();
    private int sessionNo = 1;

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new javafx.scene.control.ScrollPane(taLog), 450, 200);
        primaryStage.setTitle("TicTacToeServer");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(PORT);
                print("%s: Server started at socket %d", new Date(), PORT);
                while (true) {
                    print("%s: Wait for players to join session %d", new Date(), sessionNo);
                    Socket player1 = serverSocket.accept();
                    print("%s: Player 1 joined session %d", new Date(), sessionNo);
                    print("Player 1's IP address %s:%d",
                            player1.getInetAddress().getHostAddress(), player1.getPort());
                    new DataOutputStream(player1.getOutputStream()).writeInt(PLAYER1);
                    Socket player2 = serverSocket.accept();
                    print("%s: Player 2 joined session %d", new Date(), sessionNo);
                    print("Player 2's IP address %s:%d",
                            player2.getInetAddress().getHostAddress(), player2.getPort());
                    new DataOutputStream(player2.getOutputStream()).writeInt(PLAYER2);
                    print("%s: Start a thread for session %d", new Date(), sessionNo);
                    new Thread(new HandleSession(player1, player2)).start();
                    sessionNo++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void print(String fmt, Object... args) {
        Platform.runLater(() -> {
            taLog.appendText(String.format(fmt, args));
            taLog.appendText("\n");
        });
    }
}
