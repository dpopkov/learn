/*
14.19
Plots the sine function.
 */
package learn.ijpds.ch14fx.exercises;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class E1419SineFunction extends Application {
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
            points.add(centerY - scaleFactor * Math.sin((x / 100.0) * 2 * Math.PI));
        }

        Pane pane = new Pane(xAxis, yAxis, polyline);
        Scene scene = new Scene(pane, centerX * 2, height);
        primaryStage.setTitle("SineFunction");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
