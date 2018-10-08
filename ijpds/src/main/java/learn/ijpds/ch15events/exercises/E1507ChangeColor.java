package learn.ijpds.ch15events.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class E1507ChangeColor extends Application {
    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(50, 50, 40, Color.BLUE);
        circle.setOnMousePressed(e -> circle.setFill(Color.RED));
        circle.setOnMouseReleased(e -> circle.setFill(Color.BLUE));
        Pane pane = new Pane();
        pane.getChildren().add(circle);
        Scene scene = new Scene(pane, 150, 100);
        primaryStage.setTitle("ChangeColor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
