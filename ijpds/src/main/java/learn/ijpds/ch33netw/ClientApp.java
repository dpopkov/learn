package learn.ijpds.ch33netw;

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

public class ClientApp extends Application implements Consumer<String> {
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
                textArea.appendText("Radius is " + radius + '\n'
                                    + "Area received from the server is " + area + '\n');
            } catch (IOException e1) {
                textArea.appendText("I/O error: " + e1.toString());
            }
        });

        try {
            Socket socket = new Socket("localhost", 8000);
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            textField.appendText("I/O error: " + e.toString());
        }
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
