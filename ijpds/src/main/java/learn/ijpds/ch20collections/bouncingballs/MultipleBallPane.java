package learn.ijpds.ch20collections.bouncingballs;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class MultipleBallPane extends Pane {
    private final Timeline animation;

    public MultipleBallPane() {
        animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    public void add() {
        Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
        int radius = 10 + (int)(11 * Math.random());
        int startAt = (int) (radius * 1.5);
        getChildren().add(new Ball(startAt, startAt, radius, color));
    }

    public void subtract() {
        if (getChildren().size() > 0) {
            getChildren().remove(getChildren().size() - 1);
        }
    }

    public void play() {
        animation.play();
    }

    public void pause() {
        animation.pause();
    }

    public DoubleProperty rateProperty() {
        return animation.rateProperty();
    }

    private void moveBall() {
        for (Node node : getChildren()) {
            Ball ball = (Ball) node;
            if (ball.getCenterX() < ball.getRadius() || ball.getCenterX() > getWidth() - ball.getRadius()) {
                ball.dx *= -1;
            }
            if (ball.getCenterY() < ball.getRadius() || ball.getCenterY() > getHeight() - ball.getRadius()) {
                ball.dy *= -1;
            }
            ball.setCenterX(ball.dx + ball.getCenterX());
            ball.setCenterY(ball.dy + ball.getCenterY());
        }
    }

    private static class Ball extends Circle {
        private double dx = 1, dy = 1;

        private Ball(double centerX, double centerY, double radius, Color color) {
            super(centerX, centerY, radius);
            setFill(color);
        }
    }
}
