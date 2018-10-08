/* 15.4 */
package learn.ijpds.ch15events.animation;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FadeTransitionDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Ellipse e = new Ellipse(10, 10, 10, 50);
        e.setFill(Color.RED);
        e.setStroke(Color.BLACK);
        e.centerXProperty().bind(pane.widthProperty().divide(2));
        e.centerYProperty().bind(pane.heightProperty().divide(2));
        e.radiusXProperty().bind(pane.widthProperty().multiply(0.4));
        e.radiusYProperty().bind(pane.heightProperty().multiply(0.4));
        pane.getChildren().add(e);

        FadeTransition ft = new FadeTransition(Duration.millis(3000), e);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        e.setOnMousePressed(ev -> ft.pause());
        e.setOnMouseReleased(ev -> ft.play());

        Scene scene = new Scene(pane, 200, 150);
        primaryStage.setTitle("FadeTransitionDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
