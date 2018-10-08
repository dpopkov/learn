/* 15.13 */
package learn.ijpds.ch15events.animation;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FlagRisingAnimation extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        ImageView view = new ImageView("image/introvj6.jpg");
        pane.getChildren().add(view);

        PathTransition pt = new PathTransition(Duration.millis(10000),
                new Line(100, 200, 100, 0), view);
        pt.setCycleCount(5);
        pt.play();

        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setTitle("FlagRisingAnimation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
