/* 16.1 */
package learn.ijpds.ch16fxui.exercises;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E1601ChangeColor extends Application {
    private final Text text = new Text(20, 50, "Welcome to Java");

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setTop(createRadioButtonsPane());
        Pane textPane = new Pane();
        textPane.getChildren().add(text);
        pane.setCenter(textPane);
        pane.setBottom(createButtonsBottomPane());
        primaryStage.setScene(new Scene(pane, 500, 150));
        primaryStage.setTitle("ChangeColor");
        primaryStage.show();
    }

    private HBox createButtonsBottomPane() {
        HBox bottomPane = new HBox(10);
        bottomPane.setAlignment(Pos.CENTER);
        Button btLeft = new Button("<=");
        Button btRight = new Button("=>");
        btLeft.setOnAction(e -> text.setX(text.getX() - 10));
        btRight.setOnAction(e -> text.setX(text.getX() + 10));
        bottomPane.getChildren().addAll(btLeft, btRight);
        return bottomPane;
    }

    private HBox createRadioButtonsPane() {
        HBox topPane = new HBox(10);
        topPane.setAlignment(Pos.CENTER);
        ToggleGroup group = new ToggleGroup();
        RadioButton current;
        topPane.getChildren().addAll(new ColorButton("Red", group),
                new ColorButton("Yellow", group),
                current = new ColorButton("Black", group),
                new ColorButton("Orange", group),
                new ColorButton("Green", group)
        );
        current.setSelected(true);
        return topPane;
    }

    private class ColorButton extends RadioButton {
        private final Color textColor;

        private ColorButton(String title, ToggleGroup group) {
            super(title);
            setToggleGroup(group);
            textColor = Color.valueOf(title);
            setOnAction(e -> E1601ChangeColor.this.text.setFill(textColor));
        }
    }
}
