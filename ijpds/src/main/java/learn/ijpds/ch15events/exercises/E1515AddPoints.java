/*
15.15
Add and remove points.
 */
package learn.ijpds.ch15events.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class E1515AddPoints extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        List<Circle> circles = new ArrayList<>();
        Scene scene = new Scene(pane, 300, 200);
        scene.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                Circle circle = new Circle(e.getX(), e.getY(), 10);
                circle.setFill(Color.TRANSPARENT);
                circle.setStroke(Color.BLACK);
                pane.getChildren().add(circle);
                circles.add(circle);
            } else if (e.getButton() == MouseButton.SECONDARY) {
                for (int i = 0; i < circles.size(); i++) {
                    Circle circle = circles.get(i);
                    if (circle.contains(e.getX(), e.getY())) {
                        pane.getChildren().remove(circle);
                        circles.remove(i);
                        break;
                    }
                }
            }
        });
        primaryStage.setTitle("AddAndRemovePoints");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
