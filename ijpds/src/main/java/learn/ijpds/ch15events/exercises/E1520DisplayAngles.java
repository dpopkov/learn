/*
15.20
Geometry: display angles.
Enables to drag the vertices of a triangle and displays the angles dynamically.
 */
package learn.ijpds.ch15events.exercises;

import com.sun.imageio.spi.RAFImageInputStreamSpi;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import learn.ijpds.tools.Angle;

import java.util.ArrayList;
import java.util.List;

public class E1520DisplayAngles extends Application {
    @Override
    public void start(Stage primaryStage) {
        TrianglePane pane = new TrianglePane(40, 50, 80, 20, 160, 40);
        Scene scene = new Scene(pane, 300, 200);
        pane.processLinesAndAngles();
        primaryStage.setTitle("DisplayAngles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class TrianglePane extends Pane {
        private static final int RADIUS = 10;
        private static final int NUM_VERTICES = 3;

        private List<Circle> circles;
        private List<Line> lines;
        private List<Text> texts;

        private TrianglePane(double... coords) {
            if (coords.length != 6) {
                throw new IllegalArgumentException("There must be coordinates for 3 points");
            }
            circles = new ArrayList<>(NUM_VERTICES);
            for (int i = 0; i < 6; i += 2) {
                Circle circle = new Circle(coords[i], coords[i + 1], RADIUS);
                this.getChildren().add(circle);
                circle.setOnMouseDragged(e -> {
                    circle.setCenterX(e.getX());
                    circle.setCenterY(e.getY());
                    processLinesAndAngles();
                });
                circles.add(circle);
            }
            lines = new ArrayList<>(NUM_VERTICES);
            for (int i = 0; i < NUM_VERTICES; i++) {
                Line line = new Line();
                this.getChildren().add(line);
                lines.add(line);
            }
            texts = new ArrayList<>(NUM_VERTICES);
            for (int i = 0; i < NUM_VERTICES; i++) {
                Text t = new Text();
                this.getChildren().add(t);
                texts.add(t);
            }
        }

        private void processLinesAndAngles() {
            for (int i = 0; i < lines.size(); i++) {
                Line line = lines.get(i);
                Circle start = circles.get(i);
                Circle end = circles.get(i + 1 < circles.size() ? i + 1 : 0);
                line.setStartX(start.getCenterX());
                line.setStartY(start.getCenterY());
                line.setEndX(end.getCenterX());
                line.setEndY(end.getCenterY());
            }
            for (int i = 0; i < texts.size(); i++) {
                Text text = texts.get(i);
                Line prev = lines.get(i - 1 >= 0 ? i - 1 : lines.size() - 1);
                Line next = lines.get(i);
                double prevAngle = computeAngle(prev);
                System.out.println("i = " + i);
                prevAngle = Angle.reverse(prevAngle);
                System.out.println("prevAngle = " + prevAngle);
                double nextAngle = computeAngle(next);
                System.out.println("nextAngle = " + nextAngle);
                double angle = Math.abs(nextAngle - prevAngle);
                System.out.println("angle = " + angle);
                Circle c = circles.get(i);
                text.setX(c.getCenterX() + RADIUS * 2);
                text.setY(c.getCenterY() - RADIUS);
                text.setText(String.format("%.2f", angle));
            }
        }

        private double computeAngle(Line line) {
            double dx = line.getEndX() - line.getStartX();
            /* Subtracting start - end for Y because Y grows downward. */
            double dy = line.getStartY() - line.getEndY();
            return Angle.get(dx, dy);
        }
    }
}
