/* 16.4 */
package learn.ijpds.ch16fxui;

import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class RadioButtonDemo extends CheckBoxDemo {
    @Override
    protected BorderPane getPane() {
        BorderPane borderPane = super.getPane();

        VBox radioPane = new VBox(20);
        radioPane.setPadding(new Insets(5));
        radioPane.setStyle("-fx-border-width: 2px; -fx-border-color: green");

        ToggleGroup group = new ToggleGroup();
        radioPane.getChildren().addAll(
                new ColorRadioButton("Red", group),
                new ColorRadioButton("Green", group),
                new ColorRadioButton("Blue", group),
                new ColorRadioButton("Gray", group)
        );
        borderPane.setLeft(radioPane);

        return borderPane;
    }

    private class ColorRadioButton extends RadioButton {
        private final Color fillColor;

        private ColorRadioButton(String labelText, ToggleGroup group) {
            super(labelText);
            this.fillColor = Color.valueOf(labelText);
            this.setToggleGroup(group);
            this.setOnAction(e -> {
                if (this.isSelected()) {
                    RadioButtonDemo.this.text.setFill(fillColor);
                }
            });
        }
    }
}
