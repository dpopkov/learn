/*
15.3
Move the rectangle in a pane.
 */
package learn.ijpds.ch15events.exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class E1503Move extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        RectanglePane rectPane = new RectanglePane();
        pane.setCenter(rectPane);

        Button btLeft = new Button("Left");
        btLeft.setOnAction(e -> rectPane.moveLeft());
        Button btRight = new Button("Right");
        btRight.setOnAction(e -> rectPane.moveRight());
        Button btUp = new Button("Up");
        btUp.setOnAction(e -> rectPane.moveUp());
        Button btDown = new Button("Down");
        btDown.setOnAction(e -> rectPane.moveDown());

        HBox hBox = new HBox(5);
        hBox.setPadding(new Insets(5));
        hBox.getChildren().addAll(btLeft, btRight, btUp, btDown);
        pane.setBottom(hBox);

        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setTitle("MoveRectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class RectanglePane extends Pane {
        private final Rectangle rectangle;

        RectanglePane() {
            rectangle = new Rectangle(100, 100, 40, 40);
            rectangle.setFill(Color.TRANSPARENT);
            rectangle.setStroke(Color.BLACK);
            this.getChildren().add(rectangle);
        }

        public void moveLeft() {
            rectangle.setX(Math.max(0, rectangle.getX() - 10));
        }

        public void moveRight() {
            rectangle.setX(Math.min(rectangle.getX() + 10, this.getWidth() - rectangle.getWidth()));
        }

        public void moveUp() {
            rectangle.setY(Math.max(0, rectangle.getY() - 10));
        }

        public void moveDown() {
            rectangle.setY(Math.min(rectangle.getY() + 10, this.getHeight() - rectangle.getHeight()));
        }
    }
}
