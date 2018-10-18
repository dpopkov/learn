/* 16.6     Demonstrate TextField properties dynamically. */
package learn.ijpds.ch16fxui.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class E1606TextFieldProperties extends Application {
    public static final int COLUMN_COUNT = 22;

    private final TextField textField = new TextField("JavaFX");

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setCenter(createTopPane());
        pane.setBottom(createBottomPane());

        primaryStage.setScene(new Scene(pane, 460, 100));
        primaryStage.setTitle("TextFieldProperties");
        primaryStage.show();
    }

    private Pane createTopPane() {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setPadding(new Insets(10));
        gridPane.add(new Label("Text Field"), 0, 0);
        textField.setPrefColumnCount(COLUMN_COUNT);
        gridPane.add(textField, 1, 0);
        return gridPane;
    }

    private Pane createBottomPane() {
        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(10));
        ToggleGroup group = new ToggleGroup();
        RadioButton rbLeft = createRadioButton("Left", group, Pos.CENTER_LEFT);
        RadioButton rbCenter = createRadioButton("Center", group, Pos.CENTER);
        RadioButton rbRight = createRadioButton("Right", group, Pos.CENTER_RIGHT);
        rbLeft.setSelected(true);
        IntegerTextField tfSize = new IntegerTextField(10);
        tfSize.setPrefColumnCount(6);
        tfSize.setText(Integer.toString(COLUMN_COUNT));
        tfSize.setOnAction(e -> textField.setPrefColumnCount(tfSize.getNumber()));
        hBox.getChildren().addAll(rbLeft, rbCenter, rbRight, new Label("Column Size"), tfSize);
        return hBox;
    }

    private RadioButton createRadioButton(String text, ToggleGroup group, Pos alignment) {
        RadioButton rb = new RadioButton(text);
        rb.setToggleGroup(group);
        rb.setOnAction(e -> textField.setAlignment(alignment));
        return rb;
    }
}
