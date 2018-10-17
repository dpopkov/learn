/* 16.2 */
package learn.ijpds.ch16fxui.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class E1602SelectFigures extends Application {
    private final Pane figurePane = new StackPane();
    private final Shape[] shapes = {
            new Circle(50),
            new Rectangle(100, 100),
            new Ellipse(80, 50)
    };
    {
        for (Shape shape : shapes) {
            shape.setStroke(Color.BLACK);
        }
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setCenter(figurePane);
        pane.setBottom(createBottomPane());
        setFigure(2);
        setFillFigures(false);
        primaryStage.setTitle("SelectFigures");
        primaryStage.setScene(new Scene(pane, 450, 200));
        primaryStage.show();
    }

    private void setFigure(int index) {
        figurePane.getChildren().clear();
        figurePane.getChildren().add(shapes[index]);
    }

    private void setFillFigures(boolean fill) {
        for (Shape shape : shapes) {
            shape.setFill(fill ? Color.WHITE : Color.TRANSPARENT);
        }
    }

    private Pane createBottomPane() {
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10));
        ToggleGroup group = new ToggleGroup();
        CheckBox chkFill = new CheckBox("Fill");
        chkFill.setOnAction(e -> setFillFigures(chkFill.isSelected()));
        RadioButton current;
        hBox.getChildren().addAll(
            new FigureRadioButton("Circle", 0, group),
            new FigureRadioButton("Square", 1, group),
            current = new FigureRadioButton("Ellipse", 2, group),
            chkFill
        );
        current.setSelected(true);
        return hBox;
    }

    private class FigureRadioButton extends RadioButton {
        private FigureRadioButton(String title, int shapeIndex, ToggleGroup group) {
            super(title);
            setToggleGroup(group);
            setOnAction(e -> E1602SelectFigures.this.setFigure(shapeIndex));
        }
    }
}
