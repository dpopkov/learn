/*
15.11
Move a circle using keys.
 */
package learn.ijpds.ch15events.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class E1511MoveCircle extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Circle circle = new Circle(50, 50, 20);
        circle.setFill(Color.BURLYWOOD);
        pane.getChildren().add(circle);
        Scene scene = new Scene(pane, 300, 200);
        scene.setOnKeyPressed(e -> {
            final int step = 5;
            switch (e.getCode()) {
                case UP: circle.setCenterY(circle.getCenterY() - step); break;
                case DOWN: circle.setCenterY(circle.getCenterY() + step); break;
                case LEFT: circle.setCenterX(circle.getCenterX() - step); break;
                case RIGHT: circle.setCenterX(circle.getCenterX() + step); break;
            }
        });
        primaryStage.setTitle("MoveCircle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
