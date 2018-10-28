package learn.ijpds.ch17io.exercises;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import learn.ijpds.ch16fxui.exercises.GridBuilder;

import java.io.IOException;

public class E1713CombineFilesGui extends Application {
    private final TextField txPath = new TextField();
    private final TextField txNumber = new TextField();

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(createInputPane());
        borderPane.setBottom(createButtonsPane());
        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setTitle("Combine Files");
        primaryStage.show();
    }

    private HBox createButtonsPane() {
        HBox pane = new HBox(10);
        final Button btStart = new Button("Start");
        EventHandler<ActionEvent> startHandler = e -> {
            btStart.setText("Processing...");
            btStart.setDisable(true);
            String base = txPath.getText();
            int pieces = Integer.parseInt(txNumber.getText());
            String[] sources = new String[pieces];
            for (int i = 0; i < pieces; i++) {
                sources[i] = String.format("%s.%03d", base, i + 1);
            }
            try {
                E1712CombineFiles.combineFiles(sources);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            btStart.setText("Start");
            btStart.setDisable(false);
        };
        btStart.setOnAction(startHandler);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10));
        pane.getChildren().add(btStart);
        return pane;
    }

    private GridPane createInputPane() {
        GridBuilder builder = new GridBuilder();
        builder.appendRow("Enter a file base path (without part numbers):", txPath);
        builder.appendRow("Specify the number of smaller files:", txNumber);
        return builder.getGrid();
    }
}
