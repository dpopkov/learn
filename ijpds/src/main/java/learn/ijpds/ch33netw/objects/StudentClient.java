package learn.ijpds.ch33netw.objects;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class StudentClient extends Application {
    private static final String HOST_NAME = "localhost";
    private static final int PORT_NUMBER = 8000;

    private final TextField tfName = new TextField();
    private final TextField tfStreet = new TextField();
    private final TextField tfCity = new TextField();
    private final TextField tfState = new TextField();
    private final TextField tfZip = new TextField();
    private final Button btRegister = new Button("Register to the Server");

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));
        grid.setAlignment(Pos.CENTER);
        grid.addColumn(0, makeLabels("Name", "Street", "City", "State", "Zip"));
        grid.addColumn(1, tfName, tfStreet, tfCity, tfState, tfZip);
        grid.add(btRegister, 1, 5);
        btRegister.setOnAction(new ButtonListener());

        Scene scene = new Scene(grid, 380, 300);
        primaryStage.setTitle("StudentClient");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class ButtonListener implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            try (Socket socket = new Socket(HOST_NAME, PORT_NUMBER)) {
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                StudentAddress studentAddress = new StudentAddress(
                        tfName.getText().trim(),
                        tfStreet.getText().trim(),
                        tfCity.getText().trim(),
                        tfState.getText().trim(),
                        tfZip.getText().trim()
                );
                out.writeObject(studentAddress);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Label[] makeLabels(String... names) {
        Label[] labels = new Label[names.length];
        for (int i = 0; i < names.length; i++) {
            labels[i] = new Label(names[i]);
        }
        return labels;
    }
}
