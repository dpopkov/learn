package learn.ijpds.ch20collections.exercises.e2005;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class E2005MultipleBallPane extends Pane {
    private final Timeline animation;

    public E2005MultipleBallPane() {
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
        List<Ball> eatenBalls = new ArrayList<>();
        ObservableList<Node> children = getChildren();
        for (Node node : children) {
            Ball ball = (Ball) node;
            checkCollisions(ball, children, eatenBalls);
            if (ball.getCenterX() < ball.getRadius() || ball.getCenterX() > getWidth() - ball.getRadius()) {
                ball.dx *= -1;
            }
            if (ball.getCenterY() < ball.getRadius() || ball.getCenterY() > getHeight() - ball.getRadius()) {
                ball.dy *= -1;
            }
            ball.setCenterX(ball.dx + ball.getCenterX());
            ball.setCenterY(ball.dy + ball.getCenterY());
        }
        for (Ball b : eatenBalls) {
            children.remove(b);
        }
    }

    private void checkCollisions(Ball ball, ObservableList<Node> others, List<Ball> eatenBalls) {
        if (eatenBalls.contains(ball)) {
            return;
        }
        Bounds bounds = ball.getBoundsInLocal();
        for (Node n : others) {
            if (n == ball) {
                continue;
            }
            if (bounds.intersects(n.getBoundsInLocal())) {
                Ball other = (Ball) n;
                eatenBalls.add(other);
                ball.eatRadius(other);
            }
        }
    }

    private static class Ball extends Circle {
        private double dx = 1, dy = 1;

        private Ball(double centerX, double centerY, double radius, Color color) {
            super(centerX, centerY, radius);
            setFill(color);
        }

        void eatRadius(Ball other) {
            this.setRadius(this.getRadius() + other.getRadius());
        }
    }
}
