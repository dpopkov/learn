/* 15.18    Move a rectangle using mouse. */
package learn.ijpds.ch15events.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class E1518MoveUsingMouse extends Application {
    @Override
    public void start(Stage primaryStage) {
        Rectangle rectangle = new Rectangle(10, 10, 50, 50);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);
        Pane pane = new Pane();
        pane.getChildren().add(rectangle);
        rectangle.setOnMouseDragged(e -> {
            rectangle.setX(e.getX() - rectangle.getWidth() / 2);
            rectangle.setY(e.getY() - rectangle.getHeight() / 2);
        });
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("MoveUsingMouse");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
