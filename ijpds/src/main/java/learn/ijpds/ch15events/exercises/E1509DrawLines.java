/*
15.9
Draw lines using the arrow keys.
 */
package learn.ijpds.ch15events.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class E1509DrawLines extends Application {
    @Override
    public void start(Stage primaryStage) {
        PolylinePane pane = new PolylinePane(150, 100, 10);
        Scene scene = new Scene(pane, 320, 240);
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP: pane.up(); break;
                case DOWN: pane.down(); break;
                case LEFT: pane.left(); break;
                case RIGHT: pane.right(); break;
            }
        });
        primaryStage.setTitle("DrawLines");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class PolylinePane extends Pane {
        private final Polyline polyline;
        private final double step;
        private double currentX;
        private double currentY;

        @SuppressWarnings("SameParameterValue")
        private PolylinePane(double x, double y, double step) {
            polyline = new Polyline(x, y);
            this.getChildren().add(polyline);
            currentX = x;
            currentY = y;
            this.step = step;
        }

        private void addNext() {
            polyline.getPoints().add(currentX);
            polyline.getPoints().add(currentY);
        }

        private void up() {
            currentY -= step;
            addNext();
        }

        private void down() {
            currentY += step;
            addNext();
        }

        private void left() {
            currentX -= step;
            addNext();
        }

        private void right() {
            currentX += step;
            addNext();
        }
    }
}
