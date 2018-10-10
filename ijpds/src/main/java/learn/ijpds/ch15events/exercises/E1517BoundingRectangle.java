/*
15.17
Find the bounding rectangle.
Add and remove points dynamically. Update a minimum bounding rectangle as the points are
added and removed.
 */
package learn.ijpds.ch15events.exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class E1517BoundingRectangle extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label instructions = new Label("INSTRUCTION\nAdd: Left Click\nRemove: Right Click");
        instructions.setStyle("-fx-border-color: black; -fx-padding: 10px");
        BorderPane pane = new BorderPane();
        pane.setLeft(instructions);
        PointsPane pointsPane = new PointsPane();
        pointsPane.setStyle("-fx-background-color: yellow");
        pane.setCenter(pointsPane);
        Scene scene = new Scene(pane, 420, 240);
        pointsPane.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                pointsPane.addPoint(e.getX(), e.getY());
            } else if (e.getButton() == MouseButton.SECONDARY) {
                pointsPane.removePoint(e.getX(), e.getY());
            }
        });
        primaryStage.setTitle("FindBoundingRectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
        pointsPane.requestFocus();
    }

    private class PointsPane extends Pane {
        private static final int CIRCLE_RADIUS = 10;

        private final List<Circle> circles = new ArrayList<>();
        private final Rectangle boundingRect;

        private PointsPane() {
            boundingRect = new Rectangle();
            boundingRect.setFill(Color.TRANSPARENT);
            boundingRect.setStroke(Color.BLACK);
            this.getChildren().add(boundingRect);
        }

        private void addPoint(double x, double y) {
            Circle c = new Circle(x, y, CIRCLE_RADIUS);
            c.setFill(Color.TRANSPARENT);
            c.setStroke(Color.BLACK);
            circles.add(c);
            this.getChildren().add(c);
            resizeBoundingRect();
        }

        private void removePoint(double x, double y) {
            for (int i = 0; i < circles.size(); i++) {
                Circle c = circles.get(i);
                if (c.contains(x, y)) {
                    this.getChildren().remove(c);
                    circles.remove(i);
                    resizeBoundingRect();
                    break;
                }
            }
        }

        private void resizeBoundingRect() {
            double minX = 0;
            double maxX = 0;
            double minY = 0;
            double maxY = 0;
            if (circles.size() > 1) {
                Circle c = circles.get(0);
                minX = c.getCenterX();
                maxX = minX;
                minY = c.getCenterY();
                maxY = minY;
                for (int i = 1; i < circles.size(); i++) {
                    c = circles.get(i);
                    if (c.getCenterX() < minX) {
                        minX = c.getCenterX();
                    }
                    if (c.getCenterX() > maxX) {
                        maxX = c.getCenterX();
                    }
                    if (c.getCenterY() < minY) {
                        minY = c.getCenterY();
                    }
                    if (c.getCenterY() > maxY) {
                        maxY = c.getCenterY();
                    }
                }
                minX -= CIRCLE_RADIUS;
                maxX += CIRCLE_RADIUS;
                minY -= CIRCLE_RADIUS;
                maxY += CIRCLE_RADIUS;
            }
            boundingRect.setX(minX);
            boundingRect.setY(minY);
            boundingRect.setWidth(maxX - minX);
            boundingRect.setHeight(maxY - minY);
        }
    }
}
