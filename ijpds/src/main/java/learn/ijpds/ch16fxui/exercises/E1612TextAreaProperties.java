/*
16.12
Demonstrates the properties of a text area.
 */
package learn.ijpds.ch16fxui.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import learn.ijpds.tools.Text;

import java.io.IOException;

public class E1612TextAreaProperties extends Application {
    private final TextArea textArea = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        initTextArea();
        HBox bottomPane = new HBox(10);
        bottomPane.setPadding(new Insets(10));
        CheckBox cbxEditable = new CheckBox("Editable");
        cbxEditable.setSelected(true);
        cbxEditable.setOnAction(e -> textArea.setEditable(cbxEditable.isSelected()));
        CheckBox cbxWrap = new CheckBox("Wrap");
        cbxWrap.setOnAction(e -> textArea.setWrapText(cbxWrap.isSelected()));
        bottomPane.getChildren().addAll(cbxEditable, cbxWrap);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(textArea);
        borderPane.setBottom(bottomPane);
        primaryStage.setScene(new Scene(borderPane, 300, 200));
        primaryStage.setTitle("TextAreaProperties");
        primaryStage.show();
    }

    private void initTextArea() {
        try {
            String text = Text.readFile("io/text/reformat.txt");
            textArea.setText(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
