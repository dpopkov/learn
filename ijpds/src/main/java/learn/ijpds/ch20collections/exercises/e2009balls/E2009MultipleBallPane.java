package learn.ijpds.ch20collections.exercises.e2009balls;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class E2009MultipleBallPane extends Pane {
    private final Timeline animation;

    public E2009MultipleBallPane() {
        animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    public void add() {
        Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
        int radius = 2 + (int)(19 * Math.random());
        int startAt = (int) (radius * 1.5);
        getChildren().add(new Ball(startAt, startAt, radius, color));
    }

    public void subtract() {
        if (getChildren().size() > 0) {
            List<Node> nodes = new ArrayList<>(getChildren());
            nodes.sort(Comparator.comparing(o -> ((Ball) o)));
            Node largest = nodes.get(nodes.size() - 1);
            getChildren().remove(largest);
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
            checkBallDirection(ball);
            ball.setCenterX(ball.dx + ball.getCenterX());
            ball.setCenterY(ball.dy + ball.getCenterY());
        }
    }

    private void checkBallDirection(Ball ball) {
        if (ball.getCenterX() < ball.getRadius() || ball.getCenterX() > getWidth() - ball.getRadius()) {
            ball.dx *= -1;
        }
        if (ball.getCenterY() < ball.getRadius() || ball.getCenterY() > getHeight() - ball.getRadius()) {
            ball.dy *= -1;
        }
    }

    private static class Ball extends Circle implements Comparable<Ball> {
        private double dx = 1, dy = 1;

        private Ball(double centerX, double centerY, double radius, Color color) {
            super(centerX, centerY, radius);
            setFill(color);
        }

        @Override
        public int compareTo(Ball o) {
            return Double.compare(this.getRadius(), o.getRadius());
        }
    }
}
