/*
15.24
Animates a pendulum swing.
Press/release the mouse to pause/resume the animation.
 */
package learn.ijpds.ch15events.exercises;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

public class E1524PendulumSwing extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pendulum pendulum = new Pendulum(100, 120);
        Pane pane = new Pane(pendulum);
        Scene scene = new Scene(pane, 200, 140);
        scene.setOnMouseClicked(e -> pendulum.switchState());
        primaryStage.setTitle("PendulumSwing");
        primaryStage.setScene(scene);
        primaryStage.show();
        pendulum.play();
    }

    private class Pendulum extends Group {
        private Arc arc;
        private Circle circle;
        private PathTransition pt;

        public Pendulum(int centerX, int radius) {
            arc = new Arc(centerX, 0, radius, radius, 230, 80);
            arc.setType(ArcType.OPEN);
            arc.setFill(Color.TRANSPARENT);
            arc.setStroke(Color.BLACK);
            circle = new Circle(centerX, radius, 10);
            circle.setFill(Color.GRAY);
            this.getChildren().addAll(arc, circle);

            pt = initPath(arc, circle);
        }

        public void switchState() {
            if (pt.getStatus() == Animation.Status.RUNNING) {
                pt.pause();
            } else {
                pt.play();
            }
        }

        public void play() {
            pt.play();
        }

        private PathTransition initPath(Shape arc, Node circle) {
            PathTransition pt = new PathTransition();
            pt.setDuration(Duration.millis(1000));
            pt.setPath(arc);
            pt.setNode(circle);
            pt.setCycleCount(Timeline.INDEFINITE);
            pt.setAutoReverse(true);
            pt.play();
            return pt;
        }
    }
}
