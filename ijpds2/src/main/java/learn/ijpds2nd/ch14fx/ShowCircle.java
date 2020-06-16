package learn.ijpds2nd.ch14fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/* Listing 14.4 */
public class ShowCircle extends Application {
    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(100, 100, 50, Color.BLUE);
        Pane pane = new StackPane(circle);
        primaryStage.setScene(new Scene(pane, 200, 200));
        primaryStage.setTitle("ShowCircle");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
