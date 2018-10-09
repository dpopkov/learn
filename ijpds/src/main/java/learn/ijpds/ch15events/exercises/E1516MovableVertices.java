/*
15.16
Two movable vertices and their distances.
Displays two circles with a line connecting the two circles. The distance between the circles
is displayed along the line. The circle can be dragged.
 */
package learn.ijpds.ch15events.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E1516MovableVertices extends Application {
    @Override
    public void start(Stage primaryStage) {
        VerticesPane pane = new VerticesPane(40, 40, 120, 150);
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("MovableVertices");
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.requestFocus();
    }

    private class VerticesPane extends Pane {
        private static final int RADIUS = 10;

        private final Line line;
        private final Circle circle1;
        private final Circle circle2;
        private final Text text;
        private double x1;
        private double y1;
        private double x2;
        private double y2;

        @SuppressWarnings("SameParameterValue")
        private VerticesPane(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            line = new Line(x1, y1, x2, y2);
            circle1 = createCircle(x1, y1);
            circle2 = createCircle(x2, y2);
            text = new Text(midX(), midY(), distanceText());
            this.getChildren().addAll(line, circle1, circle2, text);

            circle1.setOnMouseDragged(e -> dragStart(e.getX(), e.getY()));
            circle2.setOnMouseDragged(e -> dragEnd(e.getX(), e.getY()));
        }

        private void dragStart(double x, double y) {
            this.x1 = x;
            this.y1 = y;
            line.setStartX(x);
            line.setStartY(y);
            circle1.setCenterX(x);
            circle1.setCenterY(y);
            updateText();
        }

        private void dragEnd(double x, double y) {
            this.x2 = x;
            this.y2 = y;
            line.setEndX(x);
            line.setEndY(y);
            circle2.setCenterX(x);
            circle2.setCenterY(y);
            updateText();
        }

        private void updateText() {
            text.setX(midX());
            text.setY(midY());
            text.setText(distanceText());
        }

        private String distanceText() {
            return Integer.toString((int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
        }

        private double midY() {
            return (y1 + y2) / 2.0;
        }

        private double midX() {
            return (x1 + x2) / 2.0;
        }

        private Circle createCircle(int x, int y) {
            Circle c = new Circle(x, y, RADIUS);
            c.setFill(Color.WHITE);
            c.setStroke(Color.BLACK);
            return c;
        }
    }
}
