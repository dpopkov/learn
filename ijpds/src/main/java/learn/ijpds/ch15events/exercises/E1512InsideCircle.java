/*
15.12
Draw a circle. Whenever the mouse is moved, display a message indicating whether the mouse point
is inside the circle or outside of it.
 */
package learn.ijpds.ch15events.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E1512InsideCircle extends Application {
    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(100, 60, 50);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        Text text = new Text("");
        Pane pane = new Pane(circle, text);
        Scene scene = new Scene(pane, 300, 200);
        scene.setOnMouseMoved(e -> {
            text.setX(e.getX());
            text.setY(e.getY());
            if (circle.contains(e.getX(), e.getY())) {
                text.setText("Mouse point is inside the circle");
            } else {
                text.setText("Mouse point is outside the circle");
            }
        });
        primaryStage.setTitle("InsideCircle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
