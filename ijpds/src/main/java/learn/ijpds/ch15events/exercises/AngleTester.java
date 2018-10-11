package learn.ijpds.ch15events.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import learn.ijpds.tools.Angle;

public class AngleTester extends Application {
    @Override
    public void start(Stage primaryStage) {
        AnglePane pane = new AnglePane();
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("AngleTester");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class AnglePane extends Pane {
        private static final int START_X = 100;
        private static final int START_Y = 100;
        private static final int RADIUS = 10;

        private final Line horizontal;
        private Line line;
        private Circle circle;
        private double circleX;
        private double circleY;
        private Text angleText;

        private AnglePane() {
            horizontal = new Line(START_X, START_Y, 200, 100);
            circleX = 200;
            circleY = 50;
            line = new Line(START_X, START_Y, circleX, circleY);
            circle = new Circle(circleX, circleY, RADIUS);
            angleText = new Text(START_X, START_Y + 30, "");
            this.getChildren().addAll(horizontal, line, circle, angleText);
            measureAngle();

            circle.setOnMouseDragged(e -> {
                circleX = e.getX();
                circleY = e.getY();
                updateEnd();
            });
        }

        private void updateEnd() {
            circle.setCenterX(circleX);
            circle.setCenterY(circleY);
            line.setEndX(circleX);
            line.setEndY(circleY);
            measureAngle();
        }

        private void measureAngle() {
            double angle = Angle.between(horizontal.getStartX(), horizontal.getStartY(),
                    horizontal.getEndX(), horizontal.getEndY(),
                    line.getStartX(), line.getStartY(),
                    line.getEndX(), line.getEndY());
            angleText.setText(String.format("angle = %.2f", angle));
        }
    }
}
