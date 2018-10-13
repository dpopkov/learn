/*
15.27
Displays a moving text.
 */
package learn.ijpds.ch15events.exercises;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class E1527MovingText extends Application {

    private static final int EXTENSION = 60;
    private static final int WIDTH = 200;

    @Override
    public void start(Stage primaryStage) {
        Text text = new Text("Welcome to Java");
        Line path = new Line(-EXTENSION, 50, WIDTH + EXTENSION, 50);

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(3000));
        pt.setPath(path);
        pt.setNode(text);
        pt.setCycleCount(Timeline.INDEFINITE);

        Pane pane = new Pane(text);
        Scene scene = new Scene(pane, WIDTH, 100);
        primaryStage.setTitle("MovingText");
        primaryStage.setScene(scene);
        primaryStage.show();

        pt.play();
    }
}
