/* 16.5 */
package learn.ijpds.ch16fxui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class TextFieldDemo extends RadioButtonDemo {
    @Override
    protected BorderPane getPane() {
        BorderPane textFieldPane = new BorderPane();
        textFieldPane.setPadding(new Insets(5));
        textFieldPane.setStyle("-fx-border-color: green");
        textFieldPane.setLeft(new Label("Enter a new message: "));

        TextField tf = new TextField();
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        textFieldPane.setCenter(tf);

        tf.setOnAction(e -> text.setText(tf.getText()));

        BorderPane pane = super.getPane();
        pane.setTop(textFieldPane);
        return pane;
    }
}
