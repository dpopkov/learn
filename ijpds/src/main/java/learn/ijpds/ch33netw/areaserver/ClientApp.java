package learn.ijpds.ch33netw.areaserver;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.function.Consumer;

/**
 * GUI app that creates connection to the specified host on the specified port number
 * and a double value representing radius of a circle.
 */
public class ClientApp extends Application implements Consumer<String> {
    private static final String HOST_NAME = "localhost";
    private static final int PORT_NUMBER = 8000;

    private DataOutputStream toServer;
    private DataInputStream fromServer;
    private TextArea textArea;

    @Override
    public void start(Stage primaryStage) {
        BorderPane topPane = new BorderPane();
        topPane.setPadding(new Insets(5,5,5,5));
        topPane.setStyle("-fx-border-color: green");
        topPane.setLeft(new Label("Enter a radius: "));
        TextField textField = new TextField();
        textField.setAlignment(Pos.BOTTOM_RIGHT);
        topPane.setCenter(textField);

        BorderPane mainPane = new BorderPane();
        textArea = new TextArea();
        mainPane.setCenter(new ScrollPane(textArea));
        mainPane.setTop(topPane);

        Scene scene = new Scene(mainPane, 450, 200);
        primaryStage.setTitle("Client");
        primaryStage.setScene(scene);
        primaryStage.show();

        textField.setOnAction(e -> {
            try {
                double radius = Double.parseDouble(textField.getText().trim());
                toServer.writeDouble(radius);
                toServer.flush();
                double area = fromServer.readDouble();
                display("Radius is " + radius + '\n'
                        + "Area received from the server is " + area);
            } catch (java.net.SocketException se) {
                display("Server closed. Error: " + se);
            } catch (IOException e1) {
                display("I/O error: " + e1.toString());
            }
        });

        try {
            Socket socket = new Socket(HOST_NAME, PORT_NUMBER);
            textArea.appendText("Created socket on port " + socket.getLocalPort() + '\n');
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            display("I/O error: " + e.toString());
        }
    }

    private void display(String s) {
        textArea.appendText(s + '\n');
    }

    @Override
    public void stop() throws Exception {
        if (fromServer != null) {
            fromServer.close();
        }
        if (toServer != null) {
            toServer.close();
        }
    }

    @Override
    public void accept(String s) {
        Platform.runLater(() -> textArea.appendText(s));
    }
}
