/*
15.25
Animate a ball moving along a cosine curve.
 */
package learn.ijpds.ch15events.exercises;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
import javafx.util.Duration;

public class E1525AnimateCosine extends Application {
    @Override
    public void start(Stage primaryStage) {
        final int centerX = 200;
        final int centerY = 100;
        final double height = centerY * 2.0;

        Line xAxis = new Line(0, centerY, centerX * 2, centerY);
        Line yAxis = new Line(centerX, 0, centerX, height);

        Polyline polyline = new Polyline();
        ObservableList<Double> points = polyline.getPoints();
        double scaleFactor = 50;
        for (int x = -centerX; x <= centerX; x++) {
            points.add((double) (x + centerX));
            points.add(centerY - scaleFactor * Math.cos((x / 100.0) * 2 * Math.PI));
        }

        Circle circle = new Circle(centerX, centerY, 10);
        circle.setFill(Color.GRAY);

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(polyline);
        pt.setNode(circle);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();

        Pane pane = new Pane(xAxis, yAxis, polyline, circle);
        Scene scene = new Scene(pane, centerX * 2, height);
        primaryStage.setTitle("AnimateCosine");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
