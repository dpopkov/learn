package learn.ijpds.ch15events.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E1519EyeHandCoordination extends Application {
    @Override
    public void start(Stage primaryStage) {
        EyeHandCoordinationPane pane = new EyeHandCoordinationPane();
        Scene scene = new Scene(pane, 300, 200);
        pane.addRandomCircle();
        scene.setOnMouseClicked(e -> pane.processClick(e.getX(), e.getY()));
        primaryStage.setTitle("EyeHandCoordination");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class EyeHandCoordinationPane extends Pane {
        private final int RADIUS = 10;
        private boolean started;
        private long start;
        private Circle circle;
        private int count;

        private EyeHandCoordinationPane() {
            setStyle("-fx-background-color: yellow");
        }

        private void processClick(double x, double y) {
            if (!started) {
                start = System.currentTimeMillis();
                if (circle != null && circle.contains(x, y)) {
                    this.getChildren().clear();
                    addRandomCircle();
                }
                count = 1;
                started = true;
            } else {
                if (count < 10) {
                    if (circle != null && circle.contains(x, y)) {
                        count++;
                        this.getChildren().clear();
                        addRandomCircle();
                    }
                } else {
                    this.getChildren().clear();
                    long elapsed = System.currentTimeMillis() - start;
                    Text text = new Text(30, 30, String.format("Time spent %d milliseconds", elapsed));
                    this.getChildren().add(text);
                    started = false;
                }
            }
        }

        private void addRandomCircle() {
            double x = RADIUS + Math.random() * (getWidth() - RADIUS * 2);
            double y = RADIUS + Math.random() * (getHeight() - RADIUS * 2);
            circle = new Circle(x, y, RADIUS);
            circle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
            this.getChildren().add(circle);
        }
    }
}
