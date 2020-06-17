package learn.ijpds2nd.ch14fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/* Listing 14.5 */
public class ShowCircleCentered extends Application {
    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(100, 100, 50, Color.BLUE);
        Pane pane = new Pane();
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        pane.getChildren().add(circle);
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle(ShowCircleCentered.class.getSimpleName());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
